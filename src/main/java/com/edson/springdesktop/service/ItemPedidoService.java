package com.edson.springdesktop.service;

import com.edson.springdesktop.domain.entity.itemPedido.ItemPedido;
import com.edson.springdesktop.domain.repository.ItemPedidoRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
}
