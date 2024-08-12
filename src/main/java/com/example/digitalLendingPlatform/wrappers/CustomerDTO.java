package com.example.digitalLendingPlatform.wrappers;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class CustomerDTO {
    private String fullName ;
    private String email;
    private String phoneNo;
    private Date dateOfBirth;
    private float maxQualification;
    private String nationalId;
    private String residentialAddress;
    private String createdBy;
}
