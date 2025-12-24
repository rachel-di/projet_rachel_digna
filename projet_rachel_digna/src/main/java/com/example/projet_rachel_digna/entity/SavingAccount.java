package com.example.projet_rachel_digna.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
public class SavingAccount extends Account {
    private double interestRate; // remuneration

    public SavingAccount(String accountNumber, double balance,
                          LocalDate creationDate, double interestRate) {
        super(accountNumber, balance, creationDate);
        this.interestRate = interestRate;
    }

    @Override
    public boolean withdraw(double amount) {
        if (getBalance() >= amount) {
            setBalance(getBalance() - amount);
            return true;
        }
        return false;
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public String getAccountType() {
        return "Saving";
    }

    public void setInterestRate(double rate) { this.interestRate = rate; }

    public double calculateInterest() {
        return getBalance() * (interestRate / 100);
    }
}
