package com.edson.springdesktop.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProdutoControllerApi {
    @GetMapping("/print")
    public String printOla() {
        System.out.println("Ola");
        return "Ola";
    }
}
