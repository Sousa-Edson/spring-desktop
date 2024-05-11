package com.edson.springdesktop.domain.entity.orderItem;

import com.edson.springdesktop.domain.entity.order.Order;
import com.edson.springdesktop.domain.entity.produto.Produto;
import com.edson.springdesktop.service.enums.TransactionType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;


public record SaveOrderItemDTO(
        @NotNull(message = "O ID do produto não pode ser nulo") Long productId,
        @NotBlank(message = "O CFOP não pode estar em branco") String CFOP,
        @PositiveOrZero(message = "A quantidade deve ser um número positivo ou zero")
        @NotNull(message = "A quantidade não pode ser nula") BigDecimal quantity,
        @NotNull(message = "O tipo de transação não pode ser nulo") TransactionType transactionType,
        Order order
) {
    public String transactionTypeDisplayName() {
        return transactionType.getDisplayName();
    }

    public OrderItem convertToOrderItem() {
        OrderItem orderItem = new OrderItem();

        // Definindo o produto
        Produto product = new Produto();
        product.setId(productId());
        orderItem.setProduct(product);

        // Definindo CFOP e quantidade
        orderItem.setCFOP(CFOP());
        orderItem.setQuantity(quantity());

        orderItem.setTransactionType(transactionType());

        orderItem.setOrder(order());

        return orderItem;
    }
}
