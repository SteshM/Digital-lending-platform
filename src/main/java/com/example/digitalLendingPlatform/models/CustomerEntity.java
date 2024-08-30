package com.example.digitalLendingPlatform.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntity{
    private long id;
    private String fullName ;
    private String email;
    private String phoneNo;
    private Date dateOfBirth;
    private float maxQualification;
    private String nationalId;
    private String residentialAddress;
    private long active;

}
