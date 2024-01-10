package com.edson.springdesktop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ProdutoController {
     @GetMapping("/show")
    public String showScreen() {
        return "pages/hello"; // Retorna o nome do arquivo HTML sem extensão
    }
}
