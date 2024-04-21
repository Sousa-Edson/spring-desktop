package com.edson.springdesktop.antigo.service;

import com.edson.springdesktop.antigo.model.Item;
import com.edson.springdesktop.antigo.model.Produto;
import com.edson.springdesktop.antigo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ProdutoService produtoService;

    public Object salvarItem(Item item) {
       // Obtém o produto associado ao item pelo ID
       Optional<Produto> produtoOptional = produtoService.findById(item.getProduto().getId());
       if (produtoOptional.isPresent()) {
           Produto produto = produtoOptional.get();
           item.setProduto(produto);
           // Calcula o valor total multiplicando a quantidade pelo valor do produto
           item.setValorTotal(item.getQuantidade() * produto.getPreco());
           // Salva o item
           return itemRepository.save(item);
       } else {
           // Retorna null se o produto associado não for encontrado
           return null;
       }
    }

    public List<Item> listarItens() {
        return itemRepository.findAll();
    }

    public Optional<Item> obterItemPorId(Long id) {
        return itemRepository.findById(id);
    }

    public Item atualizarItem(Long id, Item item) {
        // Verifica se o item com o ID especificado existe
        if (itemRepository.existsById(id)) {
            // Define o ID do item para garantir que seja atualizado corretamente
            item.setId(id);
            // Atualiza o item
            return itemRepository.save(item);
        } else {
            // Retorna null se o item não for encontrado
            return null;
        }
    }

    public void deletarItem(Long id) {
        itemRepository.deleteById(id);
    }

     
}
