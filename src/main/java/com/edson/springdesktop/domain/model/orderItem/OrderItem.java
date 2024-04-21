package com.edson.springdesktop.domain.model.orderItem;

import com.edson.springdesktop.domain.model.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    private Product product;

    @NotBlank(message = "O cfop não pode estar em branco")
    @Size(min = 4, max = 4, message = "O cfop deve ter 4 caracteres")
    private String CFOP;

    @NotNull(message = "A quantidade não pode ser nula")
    @Positive(message = "A quantidade deve ser um número positivo")
    private BigDecimal quantity;

    @NotNull(message = "O total não pode ser nulo")
    private BigDecimal totalValue;

    public OrderItem() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

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

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }
}