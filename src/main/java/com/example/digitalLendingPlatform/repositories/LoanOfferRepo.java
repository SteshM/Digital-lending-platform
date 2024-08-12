package com.example.digitalLendingPlatform.repositories;

import com.example.digitalLendingPlatform.models.CustomerEntity;
import com.example.digitalLendingPlatform.models.LoanOfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanOfferRepo extends JpaRepository<LoanOfferEntity,Long> {

    List<LoanOfferEntity> findByCustomerEntity(CustomerEntity customerEntity);

    LoanOfferEntity findById(long id);
}
