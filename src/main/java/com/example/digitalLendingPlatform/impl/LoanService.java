package com.example.digitalLendingPlatform.impl;

import com.example.digitalLendingPlatform.configs.SystemConfigs;
import com.example.digitalLendingPlatform.models.CustomerEntity;
import com.example.digitalLendingPlatform.models.LoanEntity;
import com.example.digitalLendingPlatform.models.LoanOfferEntity;
import com.example.digitalLendingPlatform.models.LoanProduct;
import com.example.digitalLendingPlatform.services.DataService;
import com.example.digitalLendingPlatform.utilities.UniversalResponse;
import com.example.digitalLendingPlatform.wrappers.*;
import com.fasterxml.jackson.core.JsonProcessingException;
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
     * @param customerId the customer id
     * @return response dto
     */
    public ResponseDTO loanOffers(long customerId){
        ModelMapper modelMapper = new ModelMapper();
        Optional<CustomerEntity> customer = dataService.findById(customerId);
        log.info("About to fetch loan offers for a customer");
        log.info("Customer: {}", customer.get().getMaxQualification());

        var loanProducts = dataService.findAllOffers();
        List<LoanProduct>loanProductList = loanProducts
                .stream()
                .map(offerEntity -> {
                    log.info(offerEntity.getMaxAllowableLimit()+"");
                  if(customer.get().getMaxQualification()>offerEntity.getMaxAllowableLimit()){
                      return offerEntity;
                  }else{
                      return null;
                  }
                })
                .toList();
        return universalResponse.successResponse("Loan offers",loanProductList);
    }


    /**
     * A customer sends a loan request and the request is granted based on their maximum allowable amount
     * @param loanRequestDTO this is the requestDTO
     * @return response dto
     * @throws JsonProcessingException the exception
     */


    public ResponseDTO requestLoan(LoanRequestDTO loanRequestDTO) {
        ModelMapper modelMapper = new ModelMapper();
        log.info("Request Loan Payload: {}", loanRequestDTO);
        var loanOffer = dataService.fetchLoanOfferById(loanRequestDTO.getLoanOfferId());
        log.info("About to apply for Loan: {}", loanOffer);
        var requestedPrinciple = loanRequestDTO.getLoanPrinciple();

        if(this.isAmountEligible(loanOffer.get().getAmount(), requestedPrinciple)){
            log.info("Amount is eligible. Proceed to record loan and fund the account");
            var loanEntity = this.createLoan(loanRequestDTO, loanOffer);
            dataService.saveLoan(loanEntity);

            if (this.fundAccount(requestedPrinciple)){
                loanEntity.setLoanStatus("Disbursed");
                dataService.saveLoan(loanEntity);
                var loan = modelMapper.map(loanEntity, LoanDTO.class);
                return universalResponse.successResponse("loan request was successful",loan);
            }
            return universalResponse.failedResponse(01,"Could not fund account",null);
        }
        return universalResponse.failedResponse(01,"Requested amount  is greater than allowed principle ",null);
    }



        
    /**
     * This method creates a loan
     * @param loanRequestDTO this is the request dto
     * @param loanOffer the param
     * @return response dto
     */

    private LoanEntity createLoan(LoanRequestDTO loanRequestDTO, Optional<LoanOfferEntity> loanOffer){
        ModelMapper modelMapper = new ModelMapper();
        LoanEntity loan = modelMapper.map(loanRequestDTO,LoanEntity.class);
        loan.setLoanOfferEntity(loanOffer.get());
        loan.setLoanDate(new Date());
        loan.setLoanStatus("Received");
        loan.setActive(1);
        log.info("Created loan {}",loan);
        return loan;

    }

    private boolean fundAccount(double amount){
        return amount!=5000;
    }


    private boolean isAmountEligible(double allowedAmount, double requestedPrinciple){
        return allowedAmount>=requestedPrinciple;
    }


}
