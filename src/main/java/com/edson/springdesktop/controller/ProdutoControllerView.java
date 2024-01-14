package com.edson.springdesktop.controller;

import com.edson.springdesktop.api.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produto")
public class ProdutoControllerView {



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
}