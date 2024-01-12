package com.edson.springdesktop.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotBlank(message = "A unidade não pode estar em branco")
//    @Size(min = 1, max = 50, message = "A unidade deve ter entre 1 e 50 caracteres")
    private String unidade;

//    @NotBlank(message = "A descrição não pode estar em branco")
//    @Size(min = 1, max = 255, message = "A descrição deve ter entre 1 e 255 caracteres")
    private String descricao;

//    @NotNull(message = "O preço não pode ser nulo")
    private Double preco; // Usando Double ao invés de double

    public Produto() {
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
}
