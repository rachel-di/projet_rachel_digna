package com.example.projet_rachel_digna.service;

import com.example.projet_rachel_digna.entity.CurrentAccount;
import com.example.projet_rachel_digna.entity.SavingAccount;

public interface AccountService {
    void addCurrentAccount(CurrentAccount currentAccount);
    void addSavingAccount(SavingAccount savingAccount);
}
