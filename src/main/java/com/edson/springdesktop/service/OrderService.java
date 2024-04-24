package com.edson.springdesktop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edson.springdesktop.domain.model.Order;
import com.edson.springdesktop.domain.repository.OrderRepository;
  

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
    return orderRepository.save(order);
  }

  public void deleteById(Long id) {
    orderRepository.deleteById(id);
  }
}
