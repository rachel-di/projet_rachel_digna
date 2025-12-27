package com.example.projet_rachel_digna.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ClientDto {

    private Long id;

    @NotBlank(message = "Client lastname cannot be empty")
    private String lastName;

    @NotBlank(message = "Client firstname cannot be empty")
    private String firstName;

    @NotBlank(message = "Client address cannot be empty")
    private String address;

    @NotBlank(message = "Client postalCode cannot be empty")
    private String postalCode;

    @NotBlank(message = "Client city cannot be empty")
    private String city;

    @NotBlank(message = "Client phone cannot be empty")
    private String phone;

    private List<AccountDto> accounts;

    public ClientDto(String lastName, String firstName, String address, String postalCode, String city, String phone) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.phone = phone;
    }
}

