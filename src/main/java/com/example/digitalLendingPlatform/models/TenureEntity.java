package com.example.digitalLendingPlatform.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "tenures")
public class TenureEntity {
    private long tenureDuration;
    private long active;

}
