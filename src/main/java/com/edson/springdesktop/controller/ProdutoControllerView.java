package com.edson.springdesktop.controller;

import com.edson.springdesktop.api.model.Produto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/produto")
public class ProdutoControllerView {

    @Value("${sua.api.base.url}") // Configure a base URL da sua API no application.properties
    private String apiBaseUrl;


    @GetMapping("/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("menuAtivo", "menu2"); // Substitua "menu1" pelo ID do menu desejado
        return "pages/produto-cadastro";
    }
    @GetMapping
    public String lista(Model model) {
        model.addAttribute("menuAtivo", "menu1"); // Substitua "menu1" pelo ID do menu desejado
        return "pages/produto-lista";
    }
     @GetMapping("/edicao/{id}")
    public String edicao(@PathVariable Long id, Model model) {
        String apiUrl = apiBaseUrl + "/api/produtos/" + id;
        RestTemplate restTemplate = new RestTemplate();
        Produto produto = restTemplate.getForObject(apiUrl, Produto.class);

System.out.println("O produto é:: "+produto.getDescricao());
        model.addAttribute("menuAtivo", "menu3"); // Substitua "menu3" pelo ID do menu desejado
        model.addAttribute("produto", produto);
        return "pages/produto-edicao";
    }
}
