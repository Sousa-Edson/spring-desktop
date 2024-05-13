package com.edson.springdesktop.service;

import com.edson.springdesktop.domain.entity.produto.Produto;
import com.edson.springdesktop.domain.repository.ProdutoRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

  @Autowired
  private ProdutoRepository ProductRepository;

  public List<Produto> findAll() {
    return ProductRepository.findAll();
  }

  public Optional<Produto> findById(Long id) {
    return ProductRepository.findById(id);
  }

  public Produto save(Produto Product) {
    return ProductRepository.save(Product);
  }

  public void deleteById(Long id) {
    ProductRepository.deleteById(id);
  }

  public List<Produto> findByDescricaoContaining(String descricao) {
    return ProductRepository.findByDescricaoContaining(descricao);
  }
}
