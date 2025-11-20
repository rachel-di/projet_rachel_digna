package com.example.projet_rachel_digna.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "saving_account")
public class SavingAccount extends Account {
    private Double interestRate = 0.03;
}
