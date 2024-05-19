package com.edson.springdesktop;

import com.edson.springdesktop.domain.entity.cliente.Cliente;
import com.edson.springdesktop.domain.entity.cliente.Endereco;
import com.edson.springdesktop.domain.entity.produto.Produto;
import com.edson.springdesktop.domain.repository.ClienteRepository;
import com.edson.springdesktop.domain.repository.ProdutoRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
//        if (produtoRepository.count() == 0) {
//            for (int i = 0; i < 10; i++) {
//                Produto produto2 = new Produto();
//                produto2.setCodigoProduto("CODE " + i);
//                produto2.setDescricao("Produto " + i);
//                produto2.setUnidade("UN");
//                produto2.setPrecoUnitario(new BigDecimal(12.7588 + (i * 50.7895)));
//                produto2.setNcm("87654321");
//                produtoRepository.save(produto2);
//            }
//        }


        if (produtoRepository.count() == 0) {
            List<Produto> produtos = new ArrayList<>();

            // Adicionar produtos à lista
            produtos.add(criarProduto("Arroz", "AR01", "78912345", "KG", new BigDecimal("5.99")));
            produtos.add(criarProduto("Feijão", "FJ01", "67891234", "KG", new BigDecimal("4.50")));
            produtos.add(criarProduto("Macarrão", "MC01", "56789123", "UN", new BigDecimal("2.75")));
            produtos.add(criarProduto("Óleo de Soja", "OS01", "45678912", "L", new BigDecimal("8.99")));
            produtos.add(criarProduto("Leite", "LT01", "34567891", "L", new BigDecimal("3.49")));
            produtos.add(criarProduto("Café", "CF01", "23456789", "KG", new BigDecimal("9.75")));
            produtos.add(criarProduto("Açúcar", "AC01", "12345678", "KG", new BigDecimal("4.25")));
            produtos.add(criarProduto("Sal", "SA01", "12345670", "KG", new BigDecimal("2.99")));
            produtos.add(criarProduto("Farinha de Trigo", "FT01", "34567890", "KG", new BigDecimal("3.85")));
            produtos.add(criarProduto("Óleo de Milho", "OM01", "45678910", "L", new BigDecimal("7.25")));
            produtos.add(criarProduto("Chocolate em Pó", "CP01", "56789120", "UN", new BigDecimal("6.50")));
            produtos.add(criarProduto("Bolacha", "BL01", "67891230", "UN", new BigDecimal("2.25")));
            produtos.add(criarProduto("Arroz Integral", "AI01", "78912340", "KG", new BigDecimal("6.99")));
            produtos.add(criarProduto("Feijão Preto", "FP01", "67891235", "KG", new BigDecimal("5.50")));
            produtos.add(criarProduto("Macarrão Integral", "MI01", "56789122", "UN", new BigDecimal("3.75")));
            produtos.add(criarProduto("Óleo de Girassol", "OG01", "45678911", "L", new BigDecimal("9.99")));
            produtos.add(criarProduto("Leite Condensado", "LC01", "34567892", "L", new BigDecimal("4.49")));
            produtos.add(criarProduto("Café Solúvel", "CS01", "23456788", "KG", new BigDecimal("12.75")));
            produtos.add(criarProduto("Adoçante", "AD01", "12345677", "UN", new BigDecimal("5.25")));
            produtos.add(criarProduto("Sal Marinho", "SM01", "12345671", "KG", new BigDecimal("3.99")));
            produtos.add(criarProduto("Farinha de Mandioca", "FM01", "34567893", "KG", new BigDecimal("4.85")));
            produtos.add(criarProduto("Azeite de Oliva", "AO01", "45678913", "L", new BigDecimal("11.25")));
            produtos.add(criarProduto("Chocolate em Barra", "CB01", "56789121", "UN", new BigDecimal("7.50")));
            produtos.add(criarProduto("Bolacha Recheada", "BR01", "67891231", "UN", new BigDecimal("3.25")));


            // Salvar produtos no banco de dados
            produtoRepository.saveAll(produtos);
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

    private Produto criarProduto(String descricao, String codigo, String ncm, String unidade, BigDecimal precoUnitario) {
        Produto produto = new Produto();
        produto.setDescricao(descricao);
        produto.setCodigoProduto(codigo);
        produto.setNcm(ncm);
        produto.setUnidade(unidade);
        produto.setPrecoUnitario(precoUnitario);
        return produto;
    }
}