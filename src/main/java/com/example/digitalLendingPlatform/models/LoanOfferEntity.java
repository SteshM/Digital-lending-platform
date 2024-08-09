package com.example.digitalLendingPlatform.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "loan_offer")
public class LoanOfferEntity extends BaseEntity {
    private long loanOfferId;
    private double amount;
    private long active;

    @OneToOne()
    @JoinColumn(name = "loanProductId")
    private LoanProduct loanProduct;


    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity  customerEntity;


}
