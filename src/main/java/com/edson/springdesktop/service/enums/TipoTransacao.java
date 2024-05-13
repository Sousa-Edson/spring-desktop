package com.edson.springdesktop.service.enums;

import java.util.LinkedHashMap;
import java.util.Map;

public enum TipoTransacao {
    PEDIDO_COMPRAS(0, "Pedido de Compras"),
    PEDIDO_VENDAS(1, "Pedido de Vendas");

    private final int tipo;
    private final String nomeExibicao;

    TipoTransacao(int tipo, String nomeExibicao) {
        this.tipo = tipo;
        this.nomeExibicao = nomeExibicao;
    }

    public int getId() {
        return tipo;
    }

    public String getNomeExibicao() {
        return nomeExibicao;
    }

    public Map<String, Object> getInfo() {
        Map<String, Object> info = new LinkedHashMap<>();
        info.put("tipo", this.tipo);
        info.put("tipoTransacao", this.name());
        info.put("nomeExibicao", this.nomeExibicao);
        return info;
    }
}
