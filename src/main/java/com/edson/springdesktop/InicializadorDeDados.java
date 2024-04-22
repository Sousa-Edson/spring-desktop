package com.edson.springdesktop;


import com.edson.springdesktop.domain.model.Product;
import com.edson.springdesktop.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class InicializadorDeDados implements CommandLineRunner {

    public static final Product product = new Product();
    private final ProductRepository productRepository;

    @Autowired
    public InicializadorDeDados(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Verifica se a tabela de produtos está vazia
        if (productRepository.count() == 0) {


            for (int i = 0; i < 2; i++) {
                Product product = new Product();
                product.setProductCode("Code " + i);
                product.setDescription("Produto " + i);
                product.setUnit("UN");
                product.setUnitPrice(BigDecimal.valueOf(20.00));
                product.setNCM("87654321");
                Product p =productRepository.save(product);
                System.out.println(p.getId());
            }


        }
    }
}