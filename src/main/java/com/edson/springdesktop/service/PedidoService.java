package com.edson.springdesktop.service;

import com.edson.springdesktop.model.Pedido;
import com.edson.springdesktop.repository.PedidoRepository; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido salvarPedido(Pedido pedido) {
        // Aqui você pode adicionar a lógica para salvar o pedido
        // Exemplo básico apenas para ilustrar a estrutura
        if (pedido.getProduto() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pedido sem itens");
        }
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> obterPedidoPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedido atualizarPedido(Long id, Pedido pedido) {
        // Aqui você pode adicionar a lógica para atualizar o pedido
        // Exemplo básico apenas para ilustrar a estrutura
        Pedido pedidoExistente = pedidoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));
        // Atualiza os campos do pedidoExistente com os valores do pedido recebido
        // pedidoExistente.setCliente(pedido.getCliente());
        // pedidoExistente.setItens(pedido.getItens());
        return pedidoRepository.save(pedidoExistente);
    }

    public void deletarPedido(Long id) {
        // Aqui você pode adicionar a lógica para deletar o pedido
        // Exemplo básico apenas para ilustrar a estrutura
        if (!pedidoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado");
        }
        pedidoRepository.deleteById(id);
    }
}
