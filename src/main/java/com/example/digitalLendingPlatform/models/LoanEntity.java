package com.example.digitalLendingPlatform.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "loan")
public class LoanEntity extends BaseEntity{
    private long id;
    private Date loanDate;
    private double loanPrinciple;
    private String loanStatus;
    private long Active;


    @OneToOne()
    @JoinColumn(name = "loanOfferId")
    private LoanOfferEntity loanOfferEntity;


}
