package com.edson.springdesktop.service.enums;

import java.util.LinkedHashMap;
import java.util.Map;

public enum TransactionType {
    PEDIDO_COMPRAS(0, "Pedido de Compras"),
    PEDIDO_VENDAS(1, "Pedido de Vendas");

    private final int type;
    private final String displayName;

    TransactionType(int type, String displayName) {
        this.type = type;
        this.displayName = displayName;
    }

    public int getId() {
        return type;
    }

    public String getDisplayName() {
        return displayName;
    }
    public Map<String, Object> getInfo() {
        Map<String, Object> info = new LinkedHashMap<>();
        info.put("type", this.type);
        info.put("transactionType", this.name());
        info.put("displayName", this.displayName);
        return info;
    }
}
