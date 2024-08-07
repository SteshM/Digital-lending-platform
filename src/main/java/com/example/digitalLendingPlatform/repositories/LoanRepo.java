package com.example.digitalLendingPlatform.repositories;

import com.example.digitalLendingPlatform.models.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepo  extends JpaRepository<LoanEntity,Long> {
}
