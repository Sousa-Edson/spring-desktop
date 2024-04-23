package com.edson.springdesktop.service.enums;

public enum TransactionType {
    PEDIDO_COMPRAS("Pedido de Compras"),
    PEDIDO_VENDAS("Pedido de Vendas");

    private final String displayName;

    TransactionType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
