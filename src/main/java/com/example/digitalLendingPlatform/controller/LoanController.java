package com.example.digitalLendingPlatform.controller;
import com.example.digitalLendingPlatform.impl.LoanService;
import com.example.digitalLendingPlatform.wrappers.LoanDTO;
import com.example.digitalLendingPlatform.wrappers.LoanRequestDTO;
import com.example.digitalLendingPlatform.wrappers.ResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
public class LoanController {
private final LoanService loanService;

@GetMapping("/loan-offers")
    public ResponseDTO loanOffers(@PathVariable int id){
    return loanService.loanOffers(id);
}

    @PostMapping("/request-loan")
    public ResponseDTO requestLoan(@RequestBody LoanRequestDTO loanRequestDTO) throws JsonProcessingException {
        return loanService.requestLoan(loanRequestDTO);
    }

}
