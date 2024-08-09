package com.example.digitalLendingPlatform.wrappers;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class LoanDTO {
    private Date loanDate;
    private double loanPrincipal;
    private String loanStatus;
}
