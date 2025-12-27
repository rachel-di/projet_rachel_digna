package com.example.projet_rachel_digna.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@JsonTypeName("Current")
@EqualsAndHashCode(callSuper = true)
public class CurrentAccountDto extends AccountDto {

    @NotNull(message = "The overdraft limit cannot be empty")
    @DecimalMin(value = "0.0", message = "The overdraft has to be positive")
    private Double overdraftLimit = 1000.0;

    public CurrentAccountDto(String accountNumber, double balance,
                             LocalDate creationDate, double overdraftLimit) {
        super(accountNumber, balance, creationDate);
        this.overdraftLimit = overdraftLimit;
    }

    public CurrentAccountDto() {

    }

    public Double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(Double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
}
