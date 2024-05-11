package com.edson.springdesktop.domain.entity.produto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal; 

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O código do produto não pode estar em branco")
    @Size(min = 1, max = 255, message = "O código do produto deve ter entre 1 e 255 caracteres")
    private String codigoProduto;

    @NotBlank(message = "A descrição não pode estar em branco")
    @Size(min = 1, max = 255, message = "A descrição deve ter entre 1 e 255 caracteres")
    private String descricao;

    @NotBlank(message = "O NCM não pode estar em branco")
    @Size(min = 8, max = 8, message = "O NCM deve ter 8 caracteres")
    private String ncm;

    @NotBlank(message = "A unidade não pode estar em branco")
    @Size(min = 1, max = 50, message = "A unidade deve ter entre 1 e 50 caracteres")
    private String unidade;

    @NotNull(message = "O preço não pode ser nulo")
    private BigDecimal precoUnitario;

    private Boolean ativo = true;

    public Produto() {
    }
 
    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
