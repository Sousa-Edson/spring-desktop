package com.edson.springdesktop.service;

import com.edson.springdesktop.model.Produto;
import com.edson.springdesktop.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> encontrarProdutosPorParteDoNome(String parteDoNome) {
        return produtoRepository.findByDescricaoContaining(parteDoNome.toUpperCase());
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> obterProdutoPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto salvarProduto(Produto produto) {
        if (produto.getAtivo() == null) {
            produto.setAtivo(true);
        }
        if (produto.getObservacao() == null) {
            produto.setObservacao("");
        }
        return produtoRepository.save(produto);
    }

    public Produto atualizarProduto(Long id, Produto produto) {
        if (produtoRepository.existsById(id)) {
            produto.setId(id);
            return produtoRepository.save(produto);
        }
        return null; 
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
