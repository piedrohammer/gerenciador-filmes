package com.example.gerenciadorfilmes.controllers;

import com.example.gerenciadorfilmes.dtos.AtorDto;
import com.example.gerenciadorfilmes.services.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AtorController {

    @Autowired
    private AtorService as;

    @PostMapping("/atores")
    public boolean addAtor(@RequestBody AtorDto ator) {
        return this.as.addAtor(ator);
    }

    @GetMapping("/atores")
    public List<AtorDto> listaAtores(){
        return this.as.listaAtores();
    }
}