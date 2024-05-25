package com.edson.springdesktop.service;

import com.edson.springdesktop.domain.entity.itemPedido.ItemPageDTO;
import com.edson.springdesktop.domain.entity.itemPedido.ItemPedido;
import com.edson.springdesktop.domain.entity.itemPedido.ItemPedidoDTO;
import com.edson.springdesktop.domain.entity.produto.Produto;
import com.edson.springdesktop.domain.entity.produto.ProdutoDTO;
import com.edson.springdesktop.domain.entity.produto.ProdutoPageDTO;
import com.edson.springdesktop.domain.repository.ItemPedidoRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ItemPedidoService {

  @Autowired
  private ItemPedidoRepository itemPedidoRepository;

  @Autowired
  private ProdutoService produtoService;


  public List<ItemPedido> findAll() {
    return itemPedidoRepository.findAll();
  }

  public Optional<ItemPedido> findById(Long id) {
    return itemPedidoRepository.findById(id);
  }

  public ItemPedido save(ItemPedido itemPedido) {

    itemPedido.setProduto(produtoService.findById(itemPedido.getProduto().getId()).get());

    BigDecimal quantidade = itemPedido.getQuantidade(); 
    BigDecimal precoUnitario = itemPedido.getProduto().getPrecoUnitario();
    BigDecimal valorTotal = quantidade.multiply(precoUnitario);
    
    itemPedido.setValorTotal(valorTotal);
    return itemPedidoRepository.save(itemPedido);
  }

  public void deleteById(Long id) {
    itemPedidoRepository.deleteById(id);
  }

  public ItemPageDTO list(@PositiveOrZero int page, @Positive @Max(100) int pageSize) {
    Pageable pageable = PageRequest.of(page, pageSize, Sort.by("id").descending());
    Page<ItemPedido> pageItens = itemPedidoRepository.findAll(pageable);
    List<ItemPedido> itens = pageItens.get().collect(Collectors.toList());
    return new ItemPageDTO(itens, pageItens.getTotalElements(), pageItens.getTotalPages());
  }
}
