package com.edson.springdesktop.antigo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "A unidade não pode estar em branco")
    @Size(min = 1, max = 50, message = "A unidade deve ter entre 1 e 50 caracteres")
    private String unidade;

    @NotBlank(message = "A descrição não pode estar em branco")
    @Size(min = 1, max = 255, message = "A descrição deve ter entre 1 e 255 caracteres")
    private String descricao;

    @NotNull(message = "O preço não pode ser nulo")
    private double preco;

    @NotBlank(message = "O ncm não pode estar em branco")
    @Size(min = 8, max = 8, message = "O ncm deve ter 8 caracteres")
    private String ncm;
    @Column(columnDefinition = "TEXT")
    private String observacao;

    private Boolean ativo;


    public Produto() {
//        this.observacao = "Valor padrão"; // Definindo o valor padrão para o campo observacao
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
