package com.edson.springdesktop.controller;

import com.edson.springdesktop.domain.model.Order;
import com.edson.springdesktop.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> orders = orderService.findAll();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Order> orderOptional = orderService.findById(id);

        if (orderOptional.isPresent()) {
            return ResponseEntity.ok(orderOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado para o ID: " + id);
        }
    }

    @PostMapping
    public ResponseEntity<Order> save(@RequestBody @Valid Order order) {
        Order savedOrder = orderService.save(order);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> update(@PathVariable Long id, @RequestBody Order order) {
        if (!orderService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        order.setId(id);
        Order updatedOrder = orderService.save(order);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!orderService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        orderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

