package com.example.projet_rachel_digna.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "accountType",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CurrentAccountDto.class, name = "Current"),
        @JsonSubTypes.Type(value = SavingAccountDto.class, name = "Saving")
})
public class AccountDto {

    private Long id;

    @NotBlank(message = "Account number cannot be empty")
    private String accountNumber;

    @NotNull(message = "Account balance cannot be empty")
    private Double balance;

    @NotNull(message = "Account creation date cannot be empty")
    private LocalDate creationDate;

    public AccountDto(String accountNumber, double balance,
                      LocalDate creationDate) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.creationDate = creationDate;
    }
}
