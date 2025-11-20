package com.example.projet_rachel_digna.repository;

import com.example.projet_rachel_digna.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
