package com.example.projet_rachel_digna.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String city;
    private String phone;

    public Client(String firstName, String lastName, String address, String postalCode, String city, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.phone = phone;
    }


    // Compte courant
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "current_account_id")
    private CurrentAccount currentAccount;

    // Compte d'epargne
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "savings_account_id")
    private SavingAccount savingsAccount;
}