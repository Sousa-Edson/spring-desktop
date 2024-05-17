package com.edson.springdesktop.domain.entity.produto;


import java.util.List;

public record ProdutoPageDTO(List<ProdutoDTO> produtos, long totalElements, int totalpages) {
}
