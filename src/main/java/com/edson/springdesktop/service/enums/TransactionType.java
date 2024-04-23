package com.edson.springdesktop.service.enums;

import java.util.LinkedHashMap;
import java.util.Map;

public enum TransactionType {
    PEDIDO_COMPRAS(0, "Pedido de Compras"),
    PEDIDO_VENDAS(1, "Pedido de Vendas");

    private final int id;
    private final String displayName;

    TransactionType(int id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public int getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }
    public Map<String, Object> getInfo() {
        Map<String, Object> info = new LinkedHashMap<>();
        info.put("id", this.id);
        info.put("transactionType", this.name());
        info.put("displayName", this.displayName);
        return info;
    }
}
