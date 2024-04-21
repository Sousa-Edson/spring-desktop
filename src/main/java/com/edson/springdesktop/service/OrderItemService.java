package com.edson.springdesktop.service;


import com.edson.springdesktop.domain.model.orderItem.OrderItem;
import com.edson.springdesktop.domain.model.Product;
import com.edson.springdesktop.domain.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductService productService;

    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItem> findById(UUID id) {
        return orderItemRepository.findById(id);
    }

    public OrderItem save(OrderItem orderItem) {
        Product product = productService.findById(orderItem.getProduct().getId()).get();
        orderItem.setProduct(product);

        BigDecimal unitPrice = product.getUnitPrice();
        BigDecimal quantity = orderItem.getQuantity();

        BigDecimal totalValue = unitPrice.multiply(quantity);

        System.out.println("total value: " + totalValue);
        orderItem.setTotalValue(totalValue);
        return orderItemRepository.save(orderItem);
    }

    public void deleteById(UUID id) {
        orderItemRepository.deleteById(id);
    }
}
