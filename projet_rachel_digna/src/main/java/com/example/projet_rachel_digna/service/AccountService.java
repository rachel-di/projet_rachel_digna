package com.example.projet_rachel_digna.service;

import com.example.projet_rachel_digna.dto.AccountDto;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    AccountDto createAccount(Long clientId, AccountDto accountDTO);
    List<AccountDto> getAllAccounts();
    Optional<AccountDto> getAccountById(Long id);
    List<AccountDto> getAccountsByClient(Long clientId);
    Optional<AccountDto> updateAccount(Long id, AccountDto accountDTO);
    AccountDto deleteAccount(Long id);
    AccountDto deposit(Long accountId, Double amount);
    AccountDto withdraw(Long accountId, Double amount);
}
