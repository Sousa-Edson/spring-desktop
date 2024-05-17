package com.edson.springdesktop.service;

import com.edson.springdesktop.domain.entity.produto.Produto;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.edson.springdesktop.domain.entity.produto.ProdutoDTO;
import com.edson.springdesktop.domain.entity.produto.ProdutoPageDTO;
import com.edson.springdesktop.domain.repository.ProdutoRepository;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

  public ProdutoPageDTO list(@PositiveOrZero int page, @Positive @Max(100) int pageSize) {
    Page<Produto> pageProdutos = produtoRepository.findAll(PageRequest.of(page, pageSize));
    List<ProdutoDTO> courses = pageProdutos.get().map(p -> ProdutoDTO.fromProduto(p)).collect(Collectors.toList());
    return new ProdutoPageDTO(courses, pageProdutos.getTotalElements(), pageProdutos.getTotalPages());
  }
}
