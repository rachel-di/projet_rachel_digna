package com.example.projet_rachel_digna.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
public class CurrentAccount extends Account {
    private double overdraftLimit; // Decouvert

    public CurrentAccount(String accountNumber, double balance,
                          LocalDate creationDate, double overdraftLimit) {
        super(accountNumber, balance, creationDate);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (getBalance() - amount >= -overdraftLimit) {
            setBalance(getBalance() - amount);
            return true;
        }
        return false;
    }

    @Override
    public double getInterestRate() {
        return 0;
    }

    @Override
    public String getAccountType() {
        return "Current";
    }

    public double getOverdraftLimit() { return overdraftLimit; }
    public void setOverdraftLimit(double limit) { this.overdraftLimit = limit; }
}
