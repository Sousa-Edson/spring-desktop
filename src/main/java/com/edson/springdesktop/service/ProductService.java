package com.edson.springdesktop.service;

import com.edson.springdesktop.domain.model.Product;
import com.edson.springdesktop.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository ProductRepository;

    public List<Product> findAll() {
        return ProductRepository.findAll();
    }

    public Optional<Product> findById(UUID id) {
        return ProductRepository.findById(id);
    }

    public Product save(Product Product) {
        return ProductRepository.save(Product);
    }

    public void deleteById(UUID id) {
        ProductRepository.deleteById(id);
    }
}
