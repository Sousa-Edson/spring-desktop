package com.edson.springdesktop.service;


import com.edson.springdesktop.controller.exceptions.NotFoundException;
import com.edson.springdesktop.domain.model.Order;
import com.edson.springdesktop.domain.model.Product;
import com.edson.springdesktop.domain.model.orderItem.OrderItem;
import com.edson.springdesktop.domain.repository.OrderItemRepository;
import com.edson.springdesktop.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderRepository orderRepository;


    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItem> findById(Long id) {
        return orderItemRepository.findById(id);
    }

    public OrderItem save(OrderItem orderItem) {
        Optional<Product> product = productService.findById(orderItem.getProduct().getId());

        if (!product.isPresent()) {
            throw new NotFoundException("Produto não encontrado com o ID: " + orderItem.getProduct().getId());
        }
        orderItem.setProduct(product.get());

        // Verificar se a ordem à qual o item está sendo associado existe
        Optional<Order> orderOptional = orderRepository.findById(orderItem.getOrder().getId());
        if (!orderOptional.isPresent()) {
            throw new NotFoundException("Ordem não encontrada com o ID: " + orderItem.getOrder().getId());
        }
        Order orderC = orderOptional.get();
        orderItem.setOrder(orderC);

        BigDecimal unitPrice = product.get().getUnitPrice();
        BigDecimal quantity = orderItem.getQuantity();

        BigDecimal totalValue = unitPrice.multiply(quantity);

        System.out.println("total value: " + totalValue);
        orderItem.setTotalValue(totalValue);
        return orderItemRepository.save(orderItem);
    }

    public void deleteById(Long id) {
        orderItemRepository.deleteById(id);
    }

}
