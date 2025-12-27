package com.example.projet_rachel_digna.mapper;

import com.example.projet_rachel_digna.dto.AccountDto;
import com.example.projet_rachel_digna.dto.CurrentAccountDto;
import com.example.projet_rachel_digna.dto.SavingAccountDto;
import com.example.projet_rachel_digna.entity.Account;
import com.example.projet_rachel_digna.entity.CurrentAccount;
import com.example.projet_rachel_digna.entity.SavingAccount;
import org.mapstruct.*;

@Mapper(componentModel = "spring" , unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AccountMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "client", ignore = true)
    CurrentAccount toCurrentAccount(CurrentAccountDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "client", ignore = true)
    SavingAccount toSavingAccount(SavingAccountDto dto);

    CurrentAccountDto toCurrentAccountDto(CurrentAccount entity);

    SavingAccountDto toSavingAccountDto(SavingAccount entity);


    default AccountDto toDto(Account account) {
        if (account == null) {
            return null;
        }

        if (account instanceof CurrentAccount) {
            CurrentAccountDto dto = toCurrentAccountDto((CurrentAccount) account);
            CurrentAccountDto finalDto = new CurrentAccountDto(
                    dto.getAccountNumber(),
                    dto.getBalance(),
                    dto.getCreationDate(),
                    dto.getOverdraftLimit()
            );
            finalDto.setId(dto.getId());
            return finalDto;
        } else if (account instanceof SavingAccount) {
            SavingAccountDto dto = toSavingAccountDto((SavingAccount) account);
            SavingAccountDto finalDto = new SavingAccountDto(
                    dto.getAccountNumber(),
                    dto.getBalance(),
                    dto.getCreationDate(),
                    dto.getInterestRate()
            );
            finalDto.setId(dto.getId());
            return finalDto;
        }

        throw new IllegalArgumentException("Type of DTO unknown: " + account.getClass().getSimpleName());
    }


    default Account toEntity(AccountDto dto) {
        if (dto == null) {
            return null;
        }
        if (dto instanceof CurrentAccountDto) {
            return toCurrentAccount((CurrentAccountDto) dto);
        } else if (dto instanceof SavingAccountDto) {
            return toSavingAccount((SavingAccountDto) dto);
        }

        throw new IllegalArgumentException("Type of DTO unknown: " + dto.getClass().getSimpleName());
    }


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "accountNumber", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "client", ignore = true)
    void updateCurrentAccount(@MappingTarget CurrentAccount entity, CurrentAccountDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "accountNumber", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "client", ignore = true)
    void updateSavingAccount(@MappingTarget SavingAccount entity, SavingAccountDto dto);

    default void updateAccountEntity(Account account, AccountDto dto) {
        if (dto == null || account == null) {
            return;
        }

        if (dto instanceof CurrentAccountDto) {
            updateCurrentAccount((CurrentAccount) account, (CurrentAccountDto) dto);
        } else if (dto instanceof SavingAccountDto) {
            updateSavingAccount((SavingAccount) account, (SavingAccountDto) dto);
        }
        else {
            throw new IllegalArgumentException("Type of DTO unknown: " + dto.getClass().getSimpleName());
        }
    }
}