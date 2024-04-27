package com.edson.springdesktop.controller;

import com.edson.springdesktop.domain.entity.product.Product;
import com.edson.springdesktop.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional; 

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> Products = productService.findAll();
        return ResponseEntity.ok(Products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);

        if (productOptional.isPresent()) {
            return ResponseEntity.ok(productOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado para o ID: " + id);
        }
    } 

    @GetMapping("/description/{description}")
    public ResponseEntity<List<Product>> findByDescriptionContaining(@PathVariable String description) {
        List<Product> Products  = productService.findByDescriptionContaining(description);
        System.out.println("A BUSCA RETORNA::: "+Products);
        return ResponseEntity.ok(Products);
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody  @Valid Product Product) {
        Product savedProduct = productService.save(Product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product Product) {
        if (!productService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Product.setId(id);
        Product updatedProduct = productService.save(Product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!productService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
