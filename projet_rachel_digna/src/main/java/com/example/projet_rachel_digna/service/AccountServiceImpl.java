package com.example.projet_rachel_digna.service;

import com.example.projet_rachel_digna.entity.CurrentAccount;
import com.example.projet_rachel_digna.entity.SavingAccount;
import com.example.projet_rachel_digna.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    @Override
    public void addCurrentAccount(CurrentAccount currentAccount) {
        accountRepository.save(currentAccount);
    }

    @Override
    public void addSavingAccount(SavingAccount savingAccount) {
        accountRepository.save(savingAccount);
    }
}
