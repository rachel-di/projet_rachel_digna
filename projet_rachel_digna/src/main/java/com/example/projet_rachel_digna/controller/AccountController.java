package com.example.projet_rachel_digna.controller;

import com.example.projet_rachel_digna.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

//    @PostMapping("addaccount")
//    public void addAccount(@RequestBody Account account) {
//        accountService.addCurrentAccount(account);
//    }
}
