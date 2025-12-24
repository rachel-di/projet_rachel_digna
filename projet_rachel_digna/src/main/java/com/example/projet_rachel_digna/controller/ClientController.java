package com.example.projet_rachel_digna.controller;

import com.example.projet_rachel_digna.dto.ClientDto;
import com.example.projet_rachel_digna.entity.Client;
import com.example.projet_rachel_digna.repository.ClientRepository;
import com.example.projet_rachel_digna.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientDto> createClient(@Valid @RequestBody ClientDto clientDto) {
        ClientDto createdClient = clientService.createClient(clientDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
    }
    @GetMapping("{id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable Long id) {
        return clientService.getClientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("{id}")
    public ResponseEntity<ClientDto> updateClient(@PathVariable Long id, @RequestBody ClientDto clientDto) {
        return clientService.updateClient(id, clientDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

    @GetMapping
    public List<ClientDto> getClients() {
        return clientService.getAllClients();
    }
}
