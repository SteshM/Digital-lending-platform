package com.example.digitalLendingPlatform.repositories;

import com.example.digitalLendingPlatform.models.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerEntity,Long> {
    CustomerEntity findByCustomerId(long customerId);
}
