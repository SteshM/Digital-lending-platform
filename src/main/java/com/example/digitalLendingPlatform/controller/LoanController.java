package com.example.digitalLendingPlatform.controller;
import com.example.digitalLendingPlatform.impl.LoanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
public class LoanController {
private final LoanService loanService;
//    @PostMapping("/request-loan")
//    public ResponseDTO requestLoan( @RequestBody LoanRequestDTO loanRequestDTO){
//        return loanService.requestLoan(loanRequestDTO);
//    }

}
