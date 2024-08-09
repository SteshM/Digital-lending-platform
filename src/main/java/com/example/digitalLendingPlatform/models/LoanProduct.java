package com.example.digitalLendingPlatform.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "loan_product")
public class LoanProduct extends BaseEntity{
    private String loanProductName;
    private double maxAllowableLimit;
    private long interest;
    private long active;


    @OneToOne()
    @JoinColumn(name = "tenureId")
    private TenureEntity tenureEntity;
}
