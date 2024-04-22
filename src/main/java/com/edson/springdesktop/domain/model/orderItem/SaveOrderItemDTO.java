package com.edson.springdesktop.domain.model.orderItem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.util.UUID;

public class SaveOrderItemDTO {
    @NotNull(message = "O ID do produto não pode ser nulo")
    private Long productId;

    @NotBlank(message = "O CFOP não pode estar em branco")
    private String CFOP;

    @PositiveOrZero(message = "A quantidade deve ser um número positivo")
    @NotNull(message = "A quantidade não pode ser nula")
    private BigDecimal quantity;

    // Getters e setters

     

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
