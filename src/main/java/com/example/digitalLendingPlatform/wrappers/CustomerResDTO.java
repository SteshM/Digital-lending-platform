package com.example.digitalLendingPlatform.wrappers;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class CustomerResDTO {
    private long id;
    private String fullName ;
    private String email;
    private String phoneNo;
    private Date dateOfBirth;
    private float maxQualification;
    private String nationalId;
    private String residentialAddress;
}
