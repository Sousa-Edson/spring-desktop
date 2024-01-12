package com.edson.springdesktop.api.service;

import com.edson.springdesktop.api.model.Produto;
import com.edson.springdesktop.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> encontrarProdutosPorParteDoNome(String parteDoNome) {
        return produtoRepository.findByDescricaoContaining(parteDoNome);
    }
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> obterProdutoPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto atualizarProduto(Long id, Produto produto) {
        if (produtoRepository.existsById(id)) {
            produto.setId(id);
            return produtoRepository.save(produto);
        }
        return null; // Produto não encontrado
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
