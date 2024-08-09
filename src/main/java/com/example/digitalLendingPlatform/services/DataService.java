package com.example.digitalLendingPlatform.services;

import com.example.digitalLendingPlatform.models.CustomerEntity;
import com.example.digitalLendingPlatform.repositories.CustomerRepo;
import com.example.digitalLendingPlatform.repositories.LoanRepo;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class DataService {
    private final CustomerRepo customerRepo;
    private final LoanRepo loanRepo;

     public CustomerEntity findCustomerById(long customerId){
        return customerRepo.findByCustomerId(customerId);

    }
}
