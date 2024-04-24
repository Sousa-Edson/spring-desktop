package com.edson.springdesktop.controller;

import com.edson.springdesktop.domain.model.Client;
import com.edson.springdesktop.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        List<Client> clients = clientService.findAll();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Client> clientOptional = clientService.findById(id);

        if (clientOptional.isPresent()) {
            return ResponseEntity.ok(clientOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado para o ID: " + id);
        }
    }

    @PostMapping
    public ResponseEntity<Client> save(@RequestBody @Valid Client client) {
        Client savedClient = clientService.save(client);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
        if (!clientService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        client.setId(id);
        Client updatedClient = clientService.save(client);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!clientService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        clientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
