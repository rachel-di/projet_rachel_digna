package com.example.projet_rachel_digna.service;

import com.example.projet_rachel_digna.entity.Client;

public interface ClientService {
    void CreateClient(Client client);
    void UpdateClient(Client client);
    Client DeleteClient(Client client);
}
