package com.edson.springdesktop.service;

import com.edson.springdesktop.controller.exceptions.NotFoundException;
import com.edson.springdesktop.domain.model.Order;
import com.edson.springdesktop.domain.model.Product;
import com.edson.springdesktop.domain.model.orderItem.OrderItem;
import com.edson.springdesktop.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    public Order save(Order order) {
//        Optional<OrderItem> orderItem = orderItemService.findById(order.getOrderItems().getId());
//
//        if(!orderItem.isPresent()){
//            throw new NotFoundException("Produto não encontrado com o ID: " + orderItem.().getId());
//        }
//
//
//
//        orderItem.setProduct(product.get());

        return orderRepository.save(order);
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}

