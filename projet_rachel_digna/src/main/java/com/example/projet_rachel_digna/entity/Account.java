package com.example.projet_rachel_digna.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public abstract class Account {
    @Id
    private String accountNumber;
    private double balance;
    private LocalDate creationDate;

    // Constructeur commun
    public Account(String accountNumber, double balance, LocalDate creationDate) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.creationDate = creationDate;
    }

    // Méthodes communes
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    // Méthodes abstraites (comportement différent)
    public abstract boolean withdraw(double amount);
    public abstract double getInterestRate();
    public abstract String getAccountType();
}
