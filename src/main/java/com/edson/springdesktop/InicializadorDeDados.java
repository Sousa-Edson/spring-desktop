package com.edson.springdesktop;

 
import com.edson.springdesktop.domain.model.Product;
import com.edson.springdesktop.domain.repository.ProductRepository; 

import java.math.BigDecimal;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class InicializadorDeDados implements CommandLineRunner {

 
    private final ProductRepository productRepository;

    @Autowired
    public InicializadorDeDados(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Verifica se a tabela de produtos está vazia
        if (productRepository.count() == 0) {
 
            // Popula a tabela com alguns produtos de exemplo
           
            for(int i=0;i < 1;i++){
                Product produto2 = new Product();
                produto2.setProductCode("CODE "+i); 
                produto2.setDescription("Produto "+i); 
                produto2.setUnit("UN");
                produto2.setUnitPrice(new BigDecimal(12.7588));
                produto2.setNCM("87654321"); 
                productRepository.save(produto2);}
 


        }
    }
}