package com.edson.springdesktop.controller;

import com.edson.springdesktop.domain.entity.product.Product;
import com.edson.springdesktop.domain.entity.product.ProductDTO;
import com.edson.springdesktop.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<Product> products = productService.findAll();
        List<ProductDTO> productDTOs = products.stream()
                .map(ProductDTO::fromProduct)
                .collect(Collectors.toList());
        return ResponseEntity.ok(productDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);

        if (productOptional.isPresent()) {
            ProductDTO productDTO = ProductDTO.fromProduct(productOptional.get());
            return ResponseEntity.ok(productDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado para o ID: " + id);
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity<List<ProductDTO>> findByDescriptionContaining(@PathVariable String description) {
        List<Product> products = productService.findByDescriptionContaining(description);

        // Converte a lista de produtos em uma lista de DTOs e retorna na resposta
        List<ProductDTO> productDTOs = products.stream()
                .map(ProductDTO::fromProduct)
                .collect(Collectors.toList());

        return ResponseEntity.ok(productDTOs);
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody @Valid ProductDTO product) {
        Product savedProduct = productService.save(product.convertToProduct());
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        Optional<Product> existingProductOptional = productService.findById(id);

        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();

            // Atualiza os campos do produto existente com os valores do DTO
            existingProduct = productDTO.convertToProduct();
            existingProduct.setId(id);

            // Salva o produto atualizado
            Product updatedProduct = productService.save(existingProduct);

            // Converte o produto atualizado em DTO e retorna na resposta
            ProductDTO updatedProductDTO = ProductDTO.fromProduct(updatedProduct);
            return ResponseEntity.ok(updatedProductDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
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
