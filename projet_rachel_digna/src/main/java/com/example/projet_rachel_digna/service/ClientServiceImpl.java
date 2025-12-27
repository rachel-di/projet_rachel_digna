package com.example.projet_rachel_digna.service;

import com.example.projet_rachel_digna.dto.ClientDto;
import com.example.projet_rachel_digna.entity.Client;
import com.example.projet_rachel_digna.mapper.ClientMapper;
import com.example.projet_rachel_digna.repository.ClientRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @PostConstruct
    private void initdb() {
        clientRepository.saveAll(List.of(
                new Client("Digna", "Rachel", "Grande Avenue", "75000", "Paris", "0123456789")

        ));
    }

    @Override
    public ClientDto createClient(ClientDto clientDto) {
        Client client = clientMapper.toEntity(clientDto);
        Client savedClient = clientRepository.save(client);
        return clientMapper.toDto(savedClient);
    }

    @Override
    public List<ClientDto> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::toDto).toList();
    }

    @Override
    public Optional<ClientDto> getClientById(Long id) {
        return clientRepository.findById(id).map(clientMapper::toDto);
    }

    @Override
    public Optional<ClientDto> updateClient(Long id, ClientDto clientDto) {
        return clientRepository.findById(id).map(existingClient -> {
            clientMapper.updateEntity(existingClient, clientDto);
            Client updatedClient = clientRepository.save(existingClient);
            return clientMapper.toDto(updatedClient);

        });
    }

    @Override
    public ClientDto deleteClient(Long id) {
        Client client = clientRepository.findById(id)
                .orElse(null);

        if (client == null) {
            return null;
        }
        ClientDto clientDto = clientMapper.toDto(client);
        clientRepository.delete(client);
        return clientDto;
    }
}