package com.edson.springdesktop.service;

  

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edson.springdesktop.domain.entity.cliente.Cliente;
import com.edson.springdesktop.domain.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository ClienteRepository;

    public List<Cliente> findAll() {
        return ClienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return ClienteRepository.findById(id);
    }

    public Cliente save(Cliente Cliente) {
        return ClienteRepository.save(Cliente);
    }

    public void deleteById(Long id) {
        ClienteRepository.deleteById(id);
    }
}

