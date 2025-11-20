package com.example.projet_rachel_digna.service;

import com.example.projet_rachel_digna.entity.Client;
import com.example.projet_rachel_digna.repository.ClientRepository;
import org.springframework.stereotype.Service;

@SuppressWarnings("LanguageDetectionInspection")
@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void CreateClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void UpdateClient(Client client) {
        if (client == null || client.getId() == null) {
            return;
        }

        Client existing = clientRepository.findById(client.getId()).orElseThrow(() -> null);

        existing.setFirstName(client.getFirstName());
        existing.setLastName(client.getLastName());
        existing.setAddress(client.getAddress());
        existing.setPostalCode(client.getPostalCode());
        existing.setCity(client.getCity());
        existing.setPhone(client.getPhone());
        existing.setCurrentAccount(client.getCurrentAccount());
        existing.setSavingsAccount(client.getSavingsAccount());

        clientRepository.save(existing);
    }

    @Override
    public Client DeleteClient(Client client) {
        if (client == null || client.getId() == null) {
            return null;
        }

        Client existing = clientRepository.findById(client.getId())
                .orElseThrow(() -> null);

        clientRepository.delete(existing);
        return existing;
    }
}
