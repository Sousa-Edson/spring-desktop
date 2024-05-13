package com.edson.springdesktop.domain.entity.itemPedido;
 
import com.edson.springdesktop.domain.entity.pedido.Pedido;
import com.edson.springdesktop.domain.entity.produto.Produto;
import com.edson.springdesktop.service.enums.TipoTransacao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;


public record ItemPedidoDTO(
        @NotNull(message = "O ID do produto não pode ser nulo") Long idProduto,
        @NotBlank(message = "O CFOP não pode estar em branco") String CFOP,
        @PositiveOrZero(message = "A quantidade deve ser um número positivo ou zero")
        @NotNull(message = "A quantidade não pode ser nula") BigDecimal quantidade,
        @NotNull(message = "O tipo de transação não pode ser nulo") TipoTransacao tipoTransacao,
        Pedido pedido
) {
    public String nomeExibicaoTipoTransacao() {
        return tipoTransacao.getNomeExibicao();
    }

    public ItemPedido converterParaItemPedido() {
        ItemPedido itemPedido = new ItemPedido();

        // Definindo o produto
        Produto produto = new Produto();
        produto.setId(idProduto());
        itemPedido.setProduto(produto);

        // Definindo CFOP e quantidade
        itemPedido.setCFOP(CFOP());
        itemPedido.setQuantidade(quantidade());

        itemPedido.setTipoTransacao(tipoTransacao());

        itemPedido.setPedido(pedido());

        return itemPedido;
    }
}
