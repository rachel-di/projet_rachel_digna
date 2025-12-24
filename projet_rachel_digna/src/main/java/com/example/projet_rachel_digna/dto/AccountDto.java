package com.example.projet_rachel_digna.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AccountDto {

    private Long id;

    @NotBlank(message = "Account number cannot be empty")
    private String accountNumber;

    @NotBlank(message = "Account balance cannot be empty")
    private Double balance;

    @NotBlank(message = "Account creation date cannot be empty")
    private LocalDate creationDate;

    @NotBlank(message = "Account type cannot be empty")
    private String accountType; // "Current" ou "Saving"

    public AccountDto(String accountNumber, double balance,
                      LocalDate creationDate, String accountType) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.creationDate = creationDate;
        this.accountType = accountType;
    }
}
