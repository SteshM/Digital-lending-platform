package com.example.digitalLendingPlatform.repositories;

import com.example.digitalLendingPlatform.models.LoanProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanProductRepo extends JpaRepository<LoanProduct,Long> {
}
