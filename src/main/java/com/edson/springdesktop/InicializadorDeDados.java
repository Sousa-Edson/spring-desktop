package com.edson.springdesktop;

import com.edson.springdesktop.domain.entity.cliente.Cliente;
import com.edson.springdesktop.domain.entity.cliente.Endereco;
import com.edson.springdesktop.domain.entity.produto.Produto;
import com.edson.springdesktop.domain.repository.ClienteRepository;
import com.edson.springdesktop.domain.repository.ProdutoRepository;

import java.math.BigDecimal;

import com.edson.springdesktop.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InicializadorDeDados implements CommandLineRunner {


    private final ProdutoRepository produtoRepository;
    private final ClienteRepository clienteRepository;

    @Autowired
    public InicializadorDeDados(
            ProdutoRepository produtoRepository,
            ClienteRepository clienteRepository
    ) {
        this.produtoRepository = produtoRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Verifica se a tabela de produtos está vazia
        if (produtoRepository.count() == 0) {
            for (int i = 0; i < 10; i++) {
                Produto produto2 = new Produto();
                produto2.setCodigoProduto("CODE " + i);
                produto2.setDescricao("Produto " + i);
                produto2.setUnidade("UN");
                produto2.setPrecoUnitario(new BigDecimal(12.7588 + (i * 50.7895)));
                produto2.setNcm("87654321");
                produtoRepository.save(produto2);
            }
        }
        // Criar um objeto Endereco
        Endereco endereco = new Endereco();
        endereco.setLogradouro("123 Rua Principal");
        endereco.setBairro("Centro");
        endereco.setCidade("Cidade");
        endereco.setEstado("Estado");
        endereco.setCep("12345-678");


        // Criar um objeto Cliente
        Cliente cliente = new Cliente();
        cliente.setCnpj("11111111111");
        cliente.setNome("Fulano");
        cliente.setInscricaoEstadual("623061758112");
        cliente.setTelefone("011 4168-3085");

        cliente.setEndereco(endereco); // Atribuir o endereco ao cliente

        // Salvar o cliente no banco de dados
        clienteRepository.save(cliente);


    }
}