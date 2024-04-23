package com.edson.springdesktop.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edson.springdesktop.domain.model.orderItem.ConvertToOrderItem;
import com.edson.springdesktop.domain.model.orderItem.OrderItem;
import com.edson.springdesktop.domain.model.orderItem.SaveOrderItemDTO;
import com.edson.springdesktop.service.OrderItemService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid; 

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping
    public ResponseEntity<List<OrderItem>> findAll() {
        List<OrderItem> orderItems = orderItemService.findAll();
        return ResponseEntity.ok(orderItems);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<OrderItem> orderItemOptional = orderItemService.findById(id);

        if (orderItemOptional.isPresent()) {
            return ResponseEntity.ok(orderItemOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item do pedido não encontrado para o ID: " + id);
        }
    }

    
    @PostMapping
    public ResponseEntity<OrderItem> save(@RequestBody @Valid SaveOrderItemDTO orderItemDTO) {
        OrderItem savedOrderItem = orderItemService.save(ConvertToOrderItem.convertToOrderItem(orderItemDTO));
        return new ResponseEntity<>(savedOrderItem, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<OrderItem> update(@PathVariable Long id, @RequestBody OrderItem orderItem) {
        if (!orderItemService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        orderItem.setId(id);
        OrderItem updatedOrderItem = orderItemService.save(orderItem);
        return ResponseEntity.ok(updatedOrderItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!orderItemService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        orderItemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
