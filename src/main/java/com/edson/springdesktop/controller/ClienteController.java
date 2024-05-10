package com.edson.springdesktop.controller;

import com.edson.springdesktop.domain.entity.cliente.Cliente;
import com.edson.springdesktop.service.ClienteService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Clientes")
public class ClienteController {

  @Autowired
  private ClienteService clienteService;

  @GetMapping
  public ResponseEntity<List<Cliente>> findAll() {
    List<Cliente> Clientes = clienteService.findAll();
    return ResponseEntity.ok(Clientes);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable Long id) {
    Optional<Cliente> ClienteOptional = clienteService.findById(id);

    if (ClienteOptional.isPresent()) {
      return ResponseEntity.ok(ClienteOptional.get());
    } else {
      return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body("Clientee não encontrado para o ID: " + id);
    }
  }

  @PostMapping
  public ResponseEntity<Cliente> save(@RequestBody @Valid Cliente cliente) {
    Cliente savedCliente = clienteService.save(cliente);
    return new ResponseEntity<>(savedCliente, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Cliente> update(
    @PathVariable Long id,
    @RequestBody Cliente cliente
  ) {
    if (!clienteService.findById(id).isPresent()) {
      return ResponseEntity.notFound().build();
    }
    cliente.setId(id);
    Cliente updatedCliente = clienteService.save(cliente);
    return ResponseEntity.ok(updatedCliente);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    if (!clienteService.findById(id).isPresent()) {
      return ResponseEntity.notFound().build();
    }
    clienteService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
