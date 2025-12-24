package com.example.projet_rachel_digna.service;

import com.example.projet_rachel_digna.dto.ClientDto;
import com.example.projet_rachel_digna.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    ClientDto createClient(ClientDto clientDto);
    List<ClientDto> getAllClients();
    Optional<ClientDto> getClientById(Long id);
    Optional<ClientDto> updateClient(Long id, ClientDto clientDto);
    void deleteClient(Long id);

}
