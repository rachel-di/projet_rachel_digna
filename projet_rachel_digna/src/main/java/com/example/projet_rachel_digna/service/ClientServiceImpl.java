package com.example.projet_rachel_digna.service;

import com.example.projet_rachel_digna.entity.Client;
import com.example.projet_rachel_digna.repository.ClientRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @PostConstruct
    private void initDB(){
        clientRepository.save(new Client("Rachel", "DIGNA", "Rue Voltaire", "94800", "Villejuif", "0123456789"));
    }

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void CreateClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void UpdateClient(Long id, Client client) {
        if (client == null) {
            return;
        }

        Client existing = clientRepository.findById(id).orElse(null);
        if  (existing == null) {
            return;
        }
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
    public Client DeleteClient(Long id, Client client) {
        if (client == null) {
            return null;
        }

        Client existing = clientRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        clientRepository.delete(existing);
        return existing;
    }

    @Override
    public List<Client> GetAllClients() {
        return clientRepository.findAll();
    }
}
