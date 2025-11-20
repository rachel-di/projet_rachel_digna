package com.example.projet_rachel_digna.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "current_account")
public class CurrentAccount extends Account {
    private Double overdraft = 1000.0;
}
