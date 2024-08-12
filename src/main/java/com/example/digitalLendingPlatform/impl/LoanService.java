package com.example.digitalLendingPlatform.impl;

import com.example.digitalLendingPlatform.configs.SystemConfigs;
import com.example.digitalLendingPlatform.models.CustomerEntity;
import com.example.digitalLendingPlatform.models.LoanEntity;
import com.example.digitalLendingPlatform.models.LoanOfferEntity;
import com.example.digitalLendingPlatform.services.DataService;
import com.example.digitalLendingPlatform.utilities.UniversalResponse;
import com.example.digitalLendingPlatform.wrappers.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoanService{
    public final UniversalResponse universalResponse;
    private final DataService dataService;
    public final SystemConfigs systemConfigs;

    /**
     * Created by Stesh
     * created on 10/08/2024
     * This method provides a list of loan offers to a customer
     * @param id the customer id
     * @return response dto
     */
    public ResponseDTO loanOffers(long id){
        ModelMapper modelMapper = new ModelMapper();
        Optional<CustomerEntity> customer = dataService.findById(id);
        log.info("About to fetch loan offers for a customer");
        var loanOffers = dataService.fetchLoanOfferByCustomer(customer.get());
        List<LoanOfferEntity>loanOfferEntityList = loanOffers
                .stream()
                .map(offerEntity -> {
                   return modelMapper.map(offerEntity,LoanOfferEntity.class);

                })
                .toList();
        return universalResponse.successResponse("Loan offers",loanOfferEntityList);
    }


    /**
     * A customer sends a loan request and the request is granted based on their maximum allowable amount
     * @param loanRequestDTO this is the requestDTO
     * @return response dto
     * @throws JsonProcessingException the exception
     */

    public ResponseDTO requestLoan(LoanRequestDTO loanRequestDTO) throws JsonProcessingException {
        ModelMapper modelMapper = new ModelMapper();
        log.info("Request Loan Payload:{}",new ObjectMapper().writeValueAsString(loanRequestDTO));
        var loanOffer = dataService.fetchLoanOfferById(loanRequestDTO.getLoanOfferId());
        log.info("About to apply for Loan:{}",new ObjectMapper().writeValueAsString(loanOffer));
        var requestedPrinciple = loanRequestDTO.getLoanPrinciple();
        if (this.isAmountEligible(loanOffer.get().getAmount(), requestedPrinciple)){
            log.info("Amount is eligible, proceed to fund the account");
            LoanEntity loan = this.createLoan(loanRequestDTO,loanOffer);
            dataService.saveLoan(loan);
            if (this.fundAccount(requestedPrinciple)){
                loan.setLoanStatus("Disbursed");
                dataService.saveLoan(loan);
                var loanEntity = modelMapper.map(loan, LoanDTO.class);
                return universalResponse.successResponse("Success",loanEntity);
            }
            return universalResponse.failedResponse(00,"Could not fund account",null);
        }
        return universalResponse.failedResponse(00,"Requested amount \"+requestedPrinciple+\" is greater than allowed principle \"+loanOffer.getAmount()",null);
    }

    /**
     * This method creates a loan
     * @param loanRequestDTO this is the request dto
     * @param loanOffer the param
     * @return response dto
     * @throws JsonProcessingException the exception
     */

    private LoanEntity createLoan(LoanRequestDTO loanRequestDTO, Optional<LoanOfferEntity> loanOffer) throws JsonProcessingException {
        ModelMapper modelMapper = new ModelMapper();
        LoanEntity loan = modelMapper.map(loanRequestDTO,LoanEntity.class);
        loan.setLoanOfferEntity(loanOffer.get());
        loan.setLoanDate(new Date());
        loan.setLoanStatus("Received");
        loan.setActive(1);
        log.info("Created loan {}", new ObjectMapper().writeValueAsString(loan));
        return loan;

    }

    private boolean fundAccount(double amount){
        return amount!=5000;
    }


    private boolean isAmountEligible(double allowedAmount, double requestedPrinciple){
        return allowedAmount>=requestedPrinciple;
    }


    public ResponseDTO createCustomer(CustomerDTO customerDTO) {
        ModelMapper modelMapper = new ModelMapper();
        CustomerEntity customer = new CustomerEntity();
        customer.setFullName(customerDTO.getFullName());
        customer.setEmail(customerDTO.getEmail());
        customer.setNationalId(customerDTO.getNationalId());
        customer.setDateOfBirth(customerDTO.getDateOfBirth());
        customer.setMaxQualification(customerDTO.getMaxQualification());
        customer.setPhoneNo(customerDTO.getPhoneNo());
        customer.setResidentialAddress(customerDTO.getResidentialAddress());
        customer.setActive(1);
        customer.setCreatedBy(customerDTO.getCreatedBy());
        var savedCustomer = dataService.saveCustomer(customer);
        var customerResDTO = modelMapper.map(savedCustomer, CustomerResDTO.class);
        return universalResponse.successResponse("Success",customerResDTO);
    }
}
