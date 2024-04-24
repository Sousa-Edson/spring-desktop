package com.edson.springdesktop.domain.repository;

import com.edson.springdesktop.domain.model.orderItem.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}