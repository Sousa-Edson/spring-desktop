package com.edson.springdesktop.domain.model.order;

import com.edson.springdesktop.domain.model.Client;
import com.edson.springdesktop.domain.model.orderItem.OrderItem;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public record OrderDTO(
        Long id,
        String noteNumber,
        String noteKey,
        String additionalInformation,
        Date issueDate,
        String operationNature,
        List<OrderItem> orderItems,
        Client client,
        int itemCount,
        BigDecimal totalValue,
        String driver
) {
    // Método estático para converter de Order para OrderDTO
    public static OrderDTO fromOrder(Order order) {
        BigDecimal totalValue = BigDecimal.ZERO;
        int itemCount = order.getOrderItems().size();
        for (OrderItem item : order.getOrderItems()) {
            totalValue = totalValue.add(item.getTotalValue());
        }
        return new OrderDTO(
                order.getId(),
                order.getNoteNumber(),
                order.getNoteKey(),
                order.getAdditionalInformation(),
                order.getIssueDate(),
                order.getOperationNature(),
                order.getOrderItems(),
                order.getClient(),
                itemCount,
                totalValue,
                order.getDriver()
        );
    }
}