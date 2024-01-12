package com.edson.springdesktop.api.controller;

import com.edson.springdesktop.api.model.Produto;
import com.edson.springdesktop.api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {


    @Autowired
    private ProdutoService produtoService;

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Produto salvarProduto(@RequestBody Produto produto) {
//        return produtoService.salvarProduto(produto);
//    }

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    public Produto obterProdutoPorId(@PathVariable Long id) {
        Optional<Produto> produto = produtoService.obterProdutoPorId(id);
        return produto.orElse(null); // Retorna null se o produto não for encontrado
    }

    @PostMapping
    public Produto salvarProduto(@RequestBody Produto produto) {
        return produtoService.salvarProduto(produto);
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.atualizarProduto(id, produto);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
    }

}
