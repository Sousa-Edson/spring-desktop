package com.edson.springdesktop.service;


import com.edson.springdesktop.domain.model.orderItem.OrderItem;
import com.edson.springdesktop.controller.exceptions.NotFoundException;
import com.edson.springdesktop.domain.model.Product;
import com.edson.springdesktop.domain.repository.OrderItemRepository;
import com.edson.springdesktop.service.enums.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
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

    public Optional<OrderItem> findById(Long id) {
        return orderItemRepository.findById(id);
    }

    public OrderItem save(OrderItem orderItem) {
        Optional<Product> product = productService.findById(orderItem.getProduct().getId());
 
        if(!product.isPresent()){
            throw new NotFoundException("Produto não encontrado com o ID: " + orderItem.getProduct().getId());
        }

        if (orderItem.getTransactionType() == null) {
            throw new IllegalArgumentException("O tipo de transação não pode ser nulo");
        } else if (orderItem.getTransactionType() != TransactionType.PEDIDO_COMPRAS &&
                orderItem.getTransactionType() != TransactionType.PEDIDO_VENDAS) {
            throw new IllegalArgumentException("Tipo de transação inválido. As opções válidas são: PEDIDO_COMPRAS, PEDIDO_VENDAS");
        }

        orderItem.setProduct(product.get());

 
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
