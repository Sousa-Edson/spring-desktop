package com.edson.springdesktop;


import com.edson.springdesktop.antigo.model.Produto;
import com.edson.springdesktop.antigo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InicializadorDeDados implements CommandLineRunner {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public InicializadorDeDados(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Verifica se a tabela de produtos está vazia
        if (produtoRepository.count() == 0) {
            // Popula a tabela com alguns produtos de exemplo
            Produto produto1 = new Produto();
            produto1.setDescricao("Produto 1");
            produto1.setAtivo(true);
            produto1.setUnidade("UN");
            produto1.setPreco(10.00);
            produto1.setNcm("12345678");
            produto1.setObservacao("Observação do Produto 1");
            produtoRepository.save(produto1);

            for(int i=0;i < 1;i++){
                Produto produto2 = new Produto();
                produto2.setDescricao("Produto "+i);
                produto2.setAtivo(true);
                produto2.setUnidade("KG");
                produto2.setPreco( 20.00);
                produto2.setNcm("87654321");
                produto2.setObservacao("Observação do Produto 2"+i);
                produtoRepository.save(produto2);}


        }
    }
}