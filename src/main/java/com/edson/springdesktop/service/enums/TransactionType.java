package com.edson.springdesktop.service.enums;

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
}
