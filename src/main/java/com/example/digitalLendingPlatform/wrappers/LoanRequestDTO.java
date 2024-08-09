package com.example.digitalLendingPlatform.wrappers;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequestDTO {
    private long loanOfferId ;
    private double loanPrinciple;
    
  

}
