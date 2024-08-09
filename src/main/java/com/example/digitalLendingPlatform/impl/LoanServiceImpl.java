package com.example.digitalLendingPlatform.impl;

import com.example.digitalLendingPlatform.configs.SystemConfigs;
import com.example.digitalLendingPlatform.models.CustomerEntity;
import com.example.digitalLendingPlatform.services.DataService;
import com.example.digitalLendingPlatform.services.LoanService;
import com.example.digitalLendingPlatform.utilities.UniversalResponse;
import com.example.digitalLendingPlatform.wrappers.LoanRequestDTO;
import com.example.digitalLendingPlatform.wrappers.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoanServiceImpl implements LoanService {
    public final UniversalResponse universalResponse;
    public final DataService dataService;
    public final ModelMapper modelMapper;
    public final SystemConfigs systemConfigs;
    @Override
    public ResponseDTO requestLoan(LoanRequestDTO loanRequestDTO)

    {
        CustomerEntity customer = new CustomerEntity();
        customer.setFullName(loanRequestDTO.getFullName());
        customer.setEmail(loanRequestDTO.getEmail());
        customer.setNationalId(loanRequestDTO.getNationalId());
        customer.setDateOfBirth(loanRequestDTO.getDateOfBirth());
        return universalResponse.successResponse("Your loan request is successful",loanRequestDTO);








    }

}
