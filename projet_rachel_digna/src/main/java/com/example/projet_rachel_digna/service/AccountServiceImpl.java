package com.example.projet_rachel_digna.service;

import com.example.projet_rachel_digna.dto.AccountDto;
import com.example.projet_rachel_digna.entity.Account;
import com.example.projet_rachel_digna.entity.Client;
import com.example.projet_rachel_digna.mapper.AccountMapper;
import com.example.projet_rachel_digna.repository.AccountRepository;
import com.example.projet_rachel_digna.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final ClientRepository clientRepository;
    private final AccountMapper accountMapper;

    @Override
    public AccountDto createAccount(Long clientId, AccountDto accountDTO) {
        Client client = clientRepository.findById(clientId)
                .orElse(null);
        if (client == null) {return null;}
        Account account =  accountMapper.toEntity(accountDTO);
        account.setClient(client);
        Account savedAccount = accountRepository.save(account);
        return accountMapper.toDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        return accountRepository.findAll()
                .stream()
                .map(accountMapper::toDto).toList();
    }

    @Override
    public Optional<AccountDto> getAccountById(Long id) {
        return accountRepository.findById(id).map(accountMapper::toDto);
    }

    @Override
    public List<AccountDto> getAccountsByClient(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElse(null);
        if (client == null) {return null;}
        return accountRepository.findByClientId(clientId).stream().map(accountMapper::toDto).toList();
    }

    @Override
    public Optional<AccountDto> updateAccount(Long id, AccountDto accountDTO) {
        return accountRepository.findById(id).map( account -> {
            accountMapper.updateAccountEntity(account, accountDTO);
            Account updatedAccount = accountRepository.save(account);
            return accountMapper.toDto(updatedAccount);
        });
    }

    @Override
    public AccountDto deleteAccount(Long id) {
        Account account = accountRepository.findById(id)
                .orElse(null);
        if (account == null) {return null;}
        AccountDto accountDTO = accountMapper.toDto(account);
        accountRepository.delete(account);
        return accountDTO;
    }

    @Override
    public AccountDto deposit(Long accountId, Double amount) {
        if (amount <= 0) {
            return null;
        }

        Account account = accountRepository.findById(accountId)
                .orElse(null);
        if (account == null) {return null;}
        account.deposit(amount);
        Account updatedAccount = accountRepository.save(account);
        return accountMapper.toDto(updatedAccount);
    }

    @Override
    public AccountDto withdraw(Long accountId, Double amount) {
        if (amount <= 0) {
            return null;
        }

        Account account = accountRepository.findById(accountId)
                .orElse(null);
        if (account == null) {return null;}
        if (!account.withdraw(amount)) {
            return null;
        }

        Account updatedAccount = accountRepository.save(account);
        return accountMapper.toDto(updatedAccount);
    }
}
