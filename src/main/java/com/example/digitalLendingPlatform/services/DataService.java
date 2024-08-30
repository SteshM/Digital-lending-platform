package com.example.digitalLendingPlatform.services;

import com.example.digitalLendingPlatform.models.CustomerEntity;
import com.example.digitalLendingPlatform.models.LoanEntity;
import com.example.digitalLendingPlatform.models.LoanOfferEntity;
import com.example.digitalLendingPlatform.models.LoanProduct;
import com.example.digitalLendingPlatform.repositories.CustomerRepo;
import com.example.digitalLendingPlatform.repositories.LoanOfferRepo;
import com.example.digitalLendingPlatform.repositories.LoanProductRepo;
import com.example.digitalLendingPlatform.repositories.LoanRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class DataService {
    private final LoanRepo loanRepo;
    private final LoanOfferRepo loanOfferRepo;
    private final CustomerRepo customerRepo;
    private final LoanProductRepo loanProductRepo;


    public List<LoanOfferEntity> fetchLoanOfferByCustomer(CustomerEntity customerEntity) {
         return loanOfferRepo.findByCustomerEntity(customerEntity);
    }

    public Optional<LoanOfferEntity> fetchLoanOfferById(long id){
         return Optional.ofNullable(loanOfferRepo.findById(id));
    }

    public void saveLoan(LoanEntity loan) {
        loanRepo.save(loan);
    }


    public Optional<CustomerEntity> findById(long id) {
        return customerRepo.findById(id);
    }

    public List<LoanProduct> findAllOffers() {
        return loanProductRepo.findAll();
    }
}
