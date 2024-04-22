package com.edson.springdesktop.service;

import com.edson.springdesktop.domain.model.Product;
import com.edson.springdesktop.domain.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired
  private ProductRepository ProductRepository;

  public List<Product> findAll() {
    return ProductRepository.findAll();
  }

  public Optional<Product> findById(Long id) {
    return ProductRepository.findById(id);
  }

  public Product save(Product Product) {
    return ProductRepository.save(Product);
  }

  public void deleteById(Long id) {
    ProductRepository.deleteById(id);
  }

  public List<Product> findByDescriptionContaining(String description) {
    return ProductRepository.findByDescriptionContaining(description);
  }
}
