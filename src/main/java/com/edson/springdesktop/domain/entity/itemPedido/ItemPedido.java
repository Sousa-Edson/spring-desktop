package com.edson.springdesktop.domain.entity.itemPedido;

import com.edson.springdesktop.domain.entity.pedido.Pedido;
import com.edson.springdesktop.domain.entity.produto.Produto;
import com.edson.springdesktop.service.enums.TipoTransacao; 
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Map;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private Produto produto;

  @NotBlank(message = "O CFOP não pode estar em branco")
  @Size(min = 4, max = 4, message = "O CFOP deve ter 4 caracteres")
  private String CFOP;

  @NotNull(message = "A quantidade não pode ser nula")
  @PositiveOrZero(message = "A quantidade deve ser um número positivo")
  @Column(precision = 25, scale = 5)
  private BigDecimal quantidade;

  @NotNull(message = "O valor total não pode ser nulo")
  @Column(precision = 35, scale = 5)
  private BigDecimal valorTotal;

  @Enumerated(EnumType.STRING)
  @NotNull(message = "O tipo de transação não pode ser nulo")
  private TipoTransacao tipoTransacao;

  @ManyToOne
  @JoinColumn(name = "pedido_id")
  @JsonIgnore
  private Pedido pedido;

  public ItemPedido() {}

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public String getCFOP() {
    return CFOP;
  }

  public void setCFOP(String CFOP) {
    this.CFOP = CFOP;
  }

  public BigDecimal getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(BigDecimal quantidade) {
    this.quantidade = quantidade;
  }

  public BigDecimal getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(BigDecimal valorTotal) {
    this.valorTotal = valorTotal;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Map<String, Object> getInformacoesTipoTransacao() {
    return tipoTransacao != null ? tipoTransacao.getInfo() : null;
  }

  public Pedido getPedido() {
    return pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  public TipoTransacao getTipoTransacao() {
    return tipoTransacao;
  }

  public void setTipoTransacao(TipoTransacao tipoTransacao) {
    this.tipoTransacao = tipoTransacao;
  }
  
}
