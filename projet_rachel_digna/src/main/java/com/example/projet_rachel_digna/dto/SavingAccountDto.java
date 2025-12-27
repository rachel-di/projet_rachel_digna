package com.example.projet_rachel_digna.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@JsonTypeName("Saving")
@EqualsAndHashCode(callSuper = true)
public class SavingAccountDto extends AccountDto {

    @NotNull(message = "The interest rate cannot be empty")
    @DecimalMin(value = "0.0", message = "The rate has to be positive")
    @DecimalMax(value = "100.0", message = "The rate cannot go over 100%")
    private Double interestRate = 3.0;

    public SavingAccountDto(String accountNumber, double balance,
                             LocalDate creationDate, double interestRate) {
        super(accountNumber, balance, creationDate);
        this.interestRate = interestRate;
    }

    public SavingAccountDto() {

    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }
}
