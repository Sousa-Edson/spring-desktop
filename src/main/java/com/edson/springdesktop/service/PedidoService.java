package com.edson.springdesktop.service;
 
import java.util.List;
import java.util.Optional;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edson.springdesktop.domain.entity.pedido.Pedido;
import com.edson.springdesktop.domain.repository.PedidoRepository;


@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> findAll() {

        return pedidoRepository.findAll();
    }

    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedido save(Pedido order) {
        order.setDataRegistro(new Date());
        return pedidoRepository.save(order);
    }

    public void deleteById(Long id) {
        pedidoRepository.deleteById(id);
    }


}
