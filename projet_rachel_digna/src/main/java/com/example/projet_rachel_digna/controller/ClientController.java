package com.example.projet_rachel_digna.controller;

import com.example.projet_rachel_digna.entity.Client;
import com.example.projet_rachel_digna.repository.ClientRepository;
import com.example.projet_rachel_digna.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("addclient")
    public void addClient(@RequestBody Client client) {
        clientService.CreateClient(client);
    }

    @PutMapping("updateclient/{id}")
    public void updateClient(@PathVariable Long id, @RequestBody Client client) {
        clientService.UpdateClient(id, client);
    }

    @DeleteMapping("deleteclient/{id}")
    public void deleteClient(@PathVariable Long id, @RequestBody Client client) {
        clientService.DeleteClient(id, client);
    }

    @GetMapping("clients")
    public List<Client> getClients() {
        return clientService.GetAllClients();
    }
}
