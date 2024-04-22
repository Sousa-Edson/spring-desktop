package com.edson.springdesktop.domain.model.orderItem;

import com.edson.springdesktop.domain.model.Product;

public class ConvertToOrderItem {
    public static OrderItem convertToOrderItem(SaveOrderItemDTO orderItemDTO) {
        OrderItem orderItem = new OrderItem();

        // Definindo o produto
        Product product = new Product();
        product.setId(orderItemDTO.productId());
        orderItem.setProduct(product);

        // Definindo CFOP e quantidade
        orderItem.setCFOP(orderItemDTO.CFOP());
        orderItem.setQuantity(orderItemDTO.quantity());

        return orderItem;
    }
}
