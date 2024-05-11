package com.edson.springdesktop.domain.entity.produto;

import java.math.BigDecimal;

public record ProdutoDTO(
        Long id,
        String codigoProduto,
        String descricao,
        String ncm,
        String unidade,
        BigDecimal precoUnitario,
        Boolean ativo
) {

    // Converte para Produto
    public Produto converterParaProduto() {
        Produto produto = new Produto();
        produto.setCodigoProduto(codigoProduto);
        produto.setDescricao(descricao);
        produto.setNcm(ncm);
        produto.setUnidade(unidade);
        produto.setPrecoUnitario(precoUnitario);
        return produto;
    }

    // Converte para DTO
    public static ProdutoDTO fromProduto(Produto produto) {
        return new ProdutoDTO(
                produto.getId(),
                produto.getCodigoProduto(),
                produto.getDescricao(),
                produto.getNcm(),
                produto.getUnidade(),
                produto.getPrecoUnitario(),
                produto.getAtivo()
        );
    }
}
