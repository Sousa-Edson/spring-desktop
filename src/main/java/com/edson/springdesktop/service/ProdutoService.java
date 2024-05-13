package com.edson.springdesktop.service;

import com.edson.springdesktop.domain.entity.produto.Produto;
import java.util.List;
import java.util.Optional;

import com.edson.springdesktop.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

  @Autowired
  private ProdutoRepository produtoRepository;

  public List<Produto> findAll() {
    return produtoRepository.findAll();
  }

  public Optional<Produto> findById(Long id) {
    return produtoRepository.findById(id);
  }

  public Produto save(Produto Product) {
    return produtoRepository.save(Product);
  }

  public void deleteById(Long id) {
    produtoRepository.deleteById(id);
  }

  public List<Produto> findByDescricaoContaining(String descricao) {
    return produtoRepository.findByDescricaoContaining(descricao);
  }
}
