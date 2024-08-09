package com.example.digitalLendingPlatform.services;

import com.example.digitalLendingPlatform.models.CustomerEntity;
import com.example.digitalLendingPlatform.models.LoanEntity;
import com.example.digitalLendingPlatform.models.LoanOfferEntity;
import com.example.digitalLendingPlatform.repositories.CustomerRepo;
import com.example.digitalLendingPlatform.repositories.LoanOfferRepo;
import com.example.digitalLendingPlatform.repositories.LoanRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class DataService {
    private final CustomerRepo customerRepo;
    private final LoanRepo loanRepo;
    private final LoanOfferRepo loanOfferRepo;


    public CustomerEntity findCustomerById(long customerId){
        return customerRepo.findByCustomerId(customerId);

    }

    public List<LoanOfferEntity> fetchLoanOfferByCustomer(CustomerEntity customerEntity) {
         return loanOfferRepo.findByCustomerEntity(customerEntity);
    }

    public LoanOfferEntity fetchLoanOfferById(long loanOfferId){
         return loanOfferRepo.findByLoanOfferId(loanOfferId);
    }

    public void saveLoan(LoanEntity loan) {
        loanRepo.save(loan);
    }
}
