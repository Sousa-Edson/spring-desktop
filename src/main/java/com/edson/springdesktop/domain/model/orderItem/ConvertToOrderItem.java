package com.edson.springdesktop.domain.model.orderItem;

import com.edson.springdesktop.domain.model.Product;

public class ConvertToOrderItem {
    public static OrderItem convertToOrderItem(SaveOrderItemDTO orderItemDTO) {
        OrderItem orderItem = new OrderItem();
        Product product = new Product();
        product.setId(orderItemDTO.getProductId());
        orderItem.setProduct(product);
        orderItem.setCFOP(orderItemDTO.getCFOP());
        orderItem.setQuantity(orderItemDTO.getQuantity());
        return orderItem;
    }
}
