package com.edson.springdesktop.antigo.model;

import jakarta.persistence.Entity;

@Entity
public class Pedido extends Item {

    @Override
    public Long getId() {
        // TODO Auto-generated method stub
        return super.getId();
    }

    @Override
    public Produto getProduto() {
        // TODO Auto-generated method stub
        return super.getProduto();
    }

    @Override
    public Double getQuantidade() {
        // TODO Auto-generated method stub
        return super.getQuantidade();
    }

    @Override
    public Double getValorTotal() {
        // TODO Auto-generated method stub
        return super.getValorTotal();
    }

    @Override
    public void setId(Long id) {
        // TODO Auto-generated method stub
        super.setId(id);
    }

    @Override
    public void setProduto(Produto produto) {
        // TODO Auto-generated method stub
        super.setProduto(produto);
    }

    @Override
    public void setQuantidade(Double quantidade) {
        // TODO Auto-generated method stub
        super.setQuantidade(quantidade);
    }

    @Override
    public void setValorTotal(Double valorTotal) {
        // TODO Auto-generated method stub
        super.setValorTotal(valorTotal);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    
}
