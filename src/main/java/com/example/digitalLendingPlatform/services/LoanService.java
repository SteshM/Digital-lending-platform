package com.example.digitalLendingPlatform.services;

import com.example.digitalLendingPlatform.wrappers.LoanRequestDTO;
import com.example.digitalLendingPlatform.wrappers.ResponseDTO;

public interface LoanService {
 public ResponseDTO requestLoan( LoanRequestDTO loanRequestDTO);

}
