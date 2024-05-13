package com.edson.springdesktop.controller;

import com.edson.springdesktop.domain.entity.pedido.Pedido;
import com.edson.springdesktop.domain.entity.pedido.PedidoDTO; 
import com.edson.springdesktop.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> findAll() {
        List<Pedido> orders = pedidoService.findAll();
        List<PedidoDTO> pedidoDTOs = orders.stream()
                .map(PedidoDTO::fromPedido)
                .collect(Collectors.toList());
        return ResponseEntity.ok(pedidoDTOs);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Pedido> pedidoOptional = pedidoService.findById(id);

        if (pedidoOptional.isPresent()) {
            return ResponseEntity.ok(pedidoOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado para o ID: " + id);
        }
    }

    @PostMapping
    public ResponseEntity<Pedido> save(@RequestBody @Valid PedidoDTO order) {
        Pedido savedOrder = pedidoService.save(order.toPedido(order));
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> update(@PathVariable Long id, @RequestBody Pedido order) {
        if (!pedidoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        order.setId(id);
        Pedido updatedOrder = pedidoService.save(order);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!pedidoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        pedidoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

