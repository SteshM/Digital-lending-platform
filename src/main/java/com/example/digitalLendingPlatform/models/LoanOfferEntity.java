package com.example.digitalLendingPlatform.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@Table(name = "loan_offer")
@ToString
public class LoanOfferEntity extends BaseEntity {
    private long id;
    private double amount;
    private long active = 1;

    @OneToOne()
    @JoinColumn(name = "loanProductId")
    private LoanProduct loanProduct;


    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity  customerEntity;


}
