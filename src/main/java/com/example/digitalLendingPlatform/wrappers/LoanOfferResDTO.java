package com.example.digitalLendingPlatform.wrappers;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoanOfferResDTO {
    private long id;
    private String loanProductName;
    private double maxAllowableLimit;
    private long interest;
    private long active;
    private long tenure;
}
