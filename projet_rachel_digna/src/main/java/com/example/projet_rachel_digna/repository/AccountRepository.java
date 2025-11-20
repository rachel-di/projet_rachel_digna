package com.example.projet_rachel_digna.repository;

import com.example.projet_rachel_digna.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
