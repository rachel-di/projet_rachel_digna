package com.example.projet_rachel_digna.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

public class CurrentAccountDto extends AccountDto {

    @NotBlank(message = "The overdraft limit cannot be empty")
    @DecimalMin(value = "0.0", message = "The overdraft has to be positive")
    private Double overdraftLimit = 1000.0;

    public CurrentAccountDto(String accountNumber, double balance,
                             LocalDate creationDate, double overdraftLimit) {
        super(accountNumber, balance, creationDate, "Current");
        this.overdraftLimit = overdraftLimit;
    }

    public Double getOverdraftLimit() {
        return overdraftLimit;
    }
}
