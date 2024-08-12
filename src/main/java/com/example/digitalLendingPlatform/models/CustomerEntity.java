package com.example.digitalLendingPlatform.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

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

    @OneToMany
    List<LoanEntity>loans;
}
