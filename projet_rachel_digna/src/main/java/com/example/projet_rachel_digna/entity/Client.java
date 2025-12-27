package com.example.projet_rachel_digna.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST)
    private List<Account> accounts;

    public void addAccount(Account account) {
        if (accounts.size() < 2) { // Max 2 comptes
            accounts.add(account);
        }
    }
}