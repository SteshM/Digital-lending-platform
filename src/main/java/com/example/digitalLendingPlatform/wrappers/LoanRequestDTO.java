package com.example.digitalLendingPlatform.wrappers;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequestDTO {
    private String fullName ;
    private String email;
    private String phoneNo;
    private Date dateOfBirth;
    private long maxQualification;
    private String nationalId;
    private String residentialAddress;
    private long loanAmount;
    private long interestRate;
    private long tenure;
    private Date loanDate;

}
