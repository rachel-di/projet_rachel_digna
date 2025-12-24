package com.example.projet_rachel_digna.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;


public class SavingAccountDto extends AccountDto {

    @NotBlank(message = "The interest rate cannot be empty")
    @DecimalMin(value = "0.0", message = "The rate has to be positive")
    @DecimalMax(value = "100.0", message = "The rate cannot go over 100%")
    private Double interestRate = 3.0;

    public SavingAccountDto(String accountNumber, double balance,
                             LocalDate creationDate, double interestRate) {
        super(accountNumber, balance, creationDate, "Saving");
        this.interestRate = interestRate;
    }

    public Double getInterestRate() {
        return interestRate;
    }
}
