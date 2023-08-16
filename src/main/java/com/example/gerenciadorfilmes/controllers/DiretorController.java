package com.example.gerenciadorfilmes.controllers;

import com.example.gerenciadorfilmes.dtos.DiretorDto;
import com.example.gerenciadorfilmes.services.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiretorController {

    @Autowired
    private DiretorService ds;

    @PostMapping("/diretores")
    public boolean addDiretor(@RequestBody DiretorDto diretor) {
        return this.ds.addDiretor(diretor);
    }

    @GetMapping("/diretores")
    public List<DiretorDto> listaDiretores(){
        return this.ds.listaDiretores();
    }
}