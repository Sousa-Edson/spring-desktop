package com.edson.springdesktop;


import com.edson.springdesktop.domain.entity.client.Address;
import com.edson.springdesktop.domain.entity.client.Client;
import com.edson.springdesktop.domain.entity.product.Product;
import com.edson.springdesktop.domain.repository.ClientRepository;
import com.edson.springdesktop.domain.repository.ProductRepository;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InicializadorDeDados implements CommandLineRunner {


    private final ProductRepository productRepository;
    private final ClientRepository clientRepository;    

    @Autowired
    public InicializadorDeDados(
            ProductRepository productRepository,
            ClientRepository clientRepository 
    ) {
        this.productRepository = productRepository;
        this.clientRepository = clientRepository; 
    }

    @Override
    public void run(String... args) throws Exception {
        // Verifica se a tabela de produtos está vazia
        if (productRepository.count() == 0) {
            for (int i = 0; i < 10; i++) {
                Product produto2 = new Product();
                produto2.setProductCode("CODE " + i);
                produto2.setDescription("Produto " + i);
                produto2.setUnit("UN");
                produto2.setUnitPrice(new BigDecimal(12.7588 + (i * 50.7895)));
                produto2.setNCM("87654321");
                productRepository.save(produto2);
            }
        }
  // Criar um objeto Address
  Address address = new Address();
  address.setStreet("123 Main St");
  address.setNeighborhood("Downtown");
  address.setCity("Cityville");
  address.setState("State");
  address.setZipCode("12345-678");
  

  // Criar um objeto Client
  Client client = new Client();
  client.setCnpj("11111111111");
  client.setName("Fulano"); 
  client.setStateRegistration("623061758112");
  client.setPhone("011 4168-3085");
  
  client.setAddress(address); // Atribuir o endereço ao cliente

  // Salvar o cliente no banco de dados
  clientRepository.save(client);


        
    }
}