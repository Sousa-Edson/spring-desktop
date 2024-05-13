package com.edson.springdesktop.controller;

import com.edson.springdesktop.domain.entity.itemPedido.ItemPedido;
import com.edson.springdesktop.domain.entity.itemPedido.ItemPedidoDTO;
import com.edson.springdesktop.service.ItemPedidoService;
import jakarta.validation.Valid;
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

@RestController
@RequestMapping("/api/pedido-items")
public class ItemPedidoController {

  @Autowired
  private ItemPedidoService itemPedidoService;

  @GetMapping
  public ResponseEntity<List<ItemPedido>> findAll() {
    List<ItemPedido> orderItems = itemPedidoService.findAll();
    return ResponseEntity.ok(orderItems);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable Long id) {
    Optional<ItemPedido> orderItemOptional = itemPedidoService.findById(id);

    if (orderItemOptional.isPresent()) {
      return ResponseEntity.ok(orderItemOptional.get());
    } else {
      return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body("Item do pedido não encontrado para o ID: " + id);
    }
  }

  @PostMapping
  public ResponseEntity<ItemPedido> save(
          @RequestBody @Valid ItemPedidoDTO orderItemDTO
  ) {
    //        ConvertToItemPedido.convertToItemPedido(orderItemDTO)
    ItemPedido savedItemPedido = itemPedidoService.save(
      orderItemDTO.converterParaItemPedido()
    );
    return new ResponseEntity<>(savedItemPedido, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ItemPedido> update(
    @PathVariable Long id,
    @RequestBody ItemPedido orderItem
  ) {
    if (!itemPedidoService.findById(id).isPresent()) {
      return ResponseEntity.notFound().build();
    }
    orderItem.setId(id);
    ItemPedido updatedItemPedido = itemPedidoService.save(orderItem);
    return ResponseEntity.ok(updatedItemPedido);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    if (!itemPedidoService.findById(id).isPresent()) {
      return ResponseEntity.notFound().build();
    }
    itemPedidoService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
