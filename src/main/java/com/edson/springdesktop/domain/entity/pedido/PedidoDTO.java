package com.edson.springdesktop.domain.entity.pedido;
 
import com.edson.springdesktop.domain.entity.cliente.Cliente;
import com.edson.springdesktop.domain.entity.itemPedido.ItemPedido;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public record PedidoDTO(
        Long id,
        String numeroNota,
        String chaveNota,
        String informacaoAdicional,
        Date dataHoraFaturamento,
        String naturezaOperacao,
        List<ItemPedido> itensPedido,
        Cliente cliente,
        String motorista,
        int quantidadeItens,
        BigDecimal valorTotal
) {
    // Método estático para converter de Pedido para PedidoDTO
    public static PedidoDTO fromPedido(Pedido pedido) {
        BigDecimal valorTotal = BigDecimal.ZERO;
        int quantidadeItens = pedido.getItensPedido().size();
        for (ItemPedido item : pedido.getItensPedido()) {
            valorTotal = valorTotal.add(item.getValorTotal());
        }
        return new PedidoDTO(
                pedido.getId(),
                pedido.getNumeroNota(),
                pedido.getChaveNota(),
                pedido.getInformacaoAdicional(),
                pedido.getDataHoraFaturamento(),
                pedido.getNaturezaOperacao(),
                pedido.getItensPedido(),
                pedido.getCliente(),
                pedido.getMotorista(),
                quantidadeItens,
                valorTotal
        );
    }

    // Método estático para converter de PedidoDTO para Pedido
    public static Pedido toPedido(PedidoDTO pedidoDTO) {
        return new Pedido(
                pedidoDTO.id,
                pedidoDTO.numeroNota,
                pedidoDTO.chaveNota,
                pedidoDTO.informacaoAdicional,
                pedidoDTO.dataHoraFaturamento,
                pedidoDTO.naturezaOperacao,
                pedidoDTO.itensPedido,
                pedidoDTO.cliente,
                pedidoDTO.motorista
        );
    }
}
