package com.edson.springdesktop.domain.entity.itemPedido;


import com.edson.springdesktop.domain.entity.produto.ProdutoDTO;

import java.util.List;

public record ItemPageDTO(List<ItemPedido> itens, long totalElements, int totalpages) {
}
