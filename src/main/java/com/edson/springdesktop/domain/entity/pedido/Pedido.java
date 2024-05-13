package com.edson.springdesktop.domain.entity.pedido;
 
import com.edson.springdesktop.domain.entity.cliente.Cliente;
import com.edson.springdesktop.domain.entity.itemPedido.ItemPedido;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String numeroNota;

  private String chaveNota;

  private String informacaoAdicional;

  private Date dataHoraFaturamento;

  private Date dataRegistro;

  @Column(name = "naturezaOperacao")
  private String naturezaOperacao;

  @OneToMany(mappedBy = "pedido")
  private List<ItemPedido> itensPedido;

  @ManyToOne
  private Cliente cliente;

  private String motorista;

  public Pedido() {}

  public Pedido(
    Long id,
    String numeroNota,
    String chaveNota,
    String informacaoAdicional,
    Date dataHoraFaturamento,
    String naturezaOperacao,
    List<ItemPedido> itensPedido,
    Cliente cliente,
    String motorista
  ) {
    this.id = id;
    this.numeroNota = numeroNota;
    this.chaveNota = chaveNota;
    this.informacaoAdicional = informacaoAdicional;
    this.dataHoraFaturamento = dataHoraFaturamento;
    this.naturezaOperacao = naturezaOperacao;
    this.itensPedido = itensPedido;
    this.cliente = cliente;
    this.motorista = motorista;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNumeroNota() {
    return numeroNota;
  }

  public void setNumeroNota(String numeroNota) {
    this.numeroNota = numeroNota;
  }

  public String getChaveNota() {
    return chaveNota;
  }

  public void setChaveNota(String chaveNota) {
    this.chaveNota = chaveNota;
  }

  public String getInformacaoAdicional() {
    return informacaoAdicional;
  }

  public void setInformacaoAdicional(String informacaoAdicional) {
    this.informacaoAdicional = informacaoAdicional;
  }

  public Date getDataHoraFaturamento() {
    return dataHoraFaturamento;
  }

  public void setDataHoraFaturamento(Date dataHoraFaturamento) {
    this.dataHoraFaturamento = dataHoraFaturamento;
  }

  public Date getDataRegistro() {
    return dataRegistro;
  }

  public void setDataRegistro(Date dataRegistro) {
    this.dataRegistro = dataRegistro;
  }

  public String getNaturezaOperacao() {
    return naturezaOperacao;
  }

  public void setNaturezaOperacao(String naturezaOperacao) {
    this.naturezaOperacao = naturezaOperacao;
  }

  public List<ItemPedido> getItensPedido() {
    return itensPedido;
  }

  public void setItensPedido(List<ItemPedido> itensPedido) {
    this.itensPedido = itensPedido;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public String getMotorista() {
    return motorista;
  }

  public void setMotorista(String motorista) {
    this.motorista = motorista;
  }
}
