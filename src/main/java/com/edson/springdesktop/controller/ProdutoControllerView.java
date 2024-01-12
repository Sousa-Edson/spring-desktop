package com.edson.springdesktop.controller;

import com.edson.springdesktop.api.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produto")
public class ProdutoControllerView {
    @GetMapping("/cadastro")
    public String showScreen() {
        return "pages/produto-cadastro";
    }


}
