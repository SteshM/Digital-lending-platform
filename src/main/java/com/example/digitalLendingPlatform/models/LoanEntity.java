package com.example.digitalLendingPlatform.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "loan")
public class LoanEntity extends BaseEntity{
    private long loanAmount;
    private long interestRate;
    private long tenure;
    private Date loanDate;


    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity  customerEntity;
}
