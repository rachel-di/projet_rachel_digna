package com.example.projet_rachel_digna.controller;

import com.example.projet_rachel_digna.dto.AccountDto;
import com.example.projet_rachel_digna.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/client/{clientId}")
    public ResponseEntity<AccountDto> createAccount(
            @PathVariable Long clientId,
            @Valid @RequestBody AccountDto accountDTO) {
        AccountDto createdAccount = accountService.createAccount(clientId, accountDTO);
        if (createdAccount == null) {return ResponseEntity.notFound().build();}
        return ResponseEntity.ok(createdAccount);
    }


    @GetMapping
    public List<AccountDto> getAllAccounts() {
        return accountService.getAllAccounts();
    }


    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<AccountDto>> getAccountsByClient(@PathVariable Long clientId) {
        List<AccountDto> accounts = accountService.getAccountsByClient(clientId);
        if (accounts == null) {return ResponseEntity.notFound().build();}
        return ResponseEntity.ok(accounts);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<AccountDto> updateAccount(
            @PathVariable Long id,
            @Valid @RequestBody AccountDto accountDTO) {
        return accountService.updateAccount(id, accountDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<AccountDto> deleteAccount(@PathVariable Long id) {
        AccountDto account = accountService.deleteAccount(id);
        if (account != null) {
            return ResponseEntity.ok(account);
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(
            @PathVariable Long id,
            @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        AccountDto account = accountService.deposit(id, amount);
        if (account != null) {
            return ResponseEntity.ok(account);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(
            @PathVariable Long id,
            @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        AccountDto account = accountService.withdraw(id, amount);
        if (account != null) {
            return ResponseEntity.ok(account);
        }
        return ResponseEntity.notFound().build();
    }
}
