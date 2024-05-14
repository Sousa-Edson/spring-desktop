package com.edson.springdesktop.controller;

import com.edson.springdesktop.domain.entity.produto.Produto;
import com.edson.springdesktop.domain.entity.produto.ProdutoDTO;
import com.edson.springdesktop.service.ProdutoService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAll() {
        List<Produto> produtos = produtoService.findAll();
        List<ProdutoDTO> produtoDTOs = produtos.stream()
                .map(ProdutoDTO::fromProduto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(produtoDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Produto> produtoOptional = produtoService.findById(id);

        if (produtoOptional.isPresent()) {
            ProdutoDTO produtoDTO = ProdutoDTO.fromProduto(produtoOptional.get());
            return ResponseEntity.ok(produtoDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado para o ID: " + id);
        }
    }

    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<ProdutoDTO>> findByDescricaoContaining(@PathVariable String descricao) {
        List<Produto> produtos = produtoService.findByDescricaoContaining(descricao);

        // Converte a lista de produtos em uma lista de DTOs e retorna na resposta
        List<ProdutoDTO> produtoDTOs = produtos.stream()
                .map(ProdutoDTO::fromProduto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(produtoDTOs);
    }

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody @Valid ProdutoDTO produto) {
        Produto savedProduto = produtoService.save(produto.converterParaProduto());
        return new ResponseEntity<>(savedProduto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> update(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        Optional<Produto> produtoExistenteOptional = produtoService.findById(id);

        if (produtoExistenteOptional.isPresent()) {
            Produto produtoExistente = produtoExistenteOptional.get();

            // Atualiza os campos do produto existente com os valores do DTO
            produtoExistente = produtoDTO.converterParaProduto();
            produtoExistente.setId(id);

            // Salva o produto atualizado
            Produto produtoAtualizado = produtoService.save(produtoExistente);

            // Converte o produto atualizado em DTO e retorna na resposta
            ProdutoDTO produtoAtualizadoDTO = ProdutoDTO.fromProduto(produtoAtualizado);
            return ResponseEntity.ok(produtoAtualizadoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!produtoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        produtoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
