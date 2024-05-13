package com.edson.springdesktop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edson.springdesktop.domain.entity.itemPedido.ItemPedido; 

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

}