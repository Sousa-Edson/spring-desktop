package com.edson.springdesktop.service;

import com.edson.springdesktop.domain.entity.orderItem.OrderItem;
import com.edson.springdesktop.domain.repository.OrderItemRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    orderItem.setProduct(productService.findById(orderItem.getProduct().getId()).get());

    BigDecimal quantity = orderItem.getQuantity(); 
    BigDecimal unitPrice = orderItem.getProduct().getUnitPrice();
    BigDecimal totalValue = quantity.multiply(unitPrice);
    
    orderItem.setTotalValue(totalValue);
    return orderItemRepository.save(orderItem);
  }

  public void deleteById(Long id) {
    orderItemRepository.deleteById(id);
  }
}
