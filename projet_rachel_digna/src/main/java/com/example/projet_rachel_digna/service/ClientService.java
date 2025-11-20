package com.example.projet_rachel_digna.service;

import com.example.projet_rachel_digna.entity.Client;

import java.util.List;

public interface ClientService {
    void CreateClient(Client client);
    void UpdateClient(Long id, Client client);
    Client DeleteClient(Long id, Client client);
    List<Client> GetAllClients();
}
