package com.edson.springdesktop.controller;

import com.edson.springdesktop.domain.entity.itemPedido.ItemPageDTO;
import com.edson.springdesktop.domain.entity.itemPedido.ItemPedido;
import com.edson.springdesktop.domain.entity.itemPedido.ItemPedidoDTO;
import com.edson.springdesktop.domain.entity.produto.ProdutoPageDTO;
import com.edson.springdesktop.service.ItemPedidoService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedido-items")
public class ItemPedidoController {

  @Autowired
  private ItemPedidoService itemPedidoService;

  //  @GetMapping
//  public ResponseEntity<List<ItemPedido>> findAll() {
//    List<ItemPedido> orderItems = itemPedidoService.findAll();
//    return ResponseEntity.ok(orderItems);
//  }
  @GetMapping
  public ItemPageDTO list(@RequestParam(defaultValue = "0") @PositiveOrZero int page,
                          @RequestParam(defaultValue = "10") @Positive @Max(100) int pageSize) {
    return itemPedidoService.list(page, pageSize);
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
