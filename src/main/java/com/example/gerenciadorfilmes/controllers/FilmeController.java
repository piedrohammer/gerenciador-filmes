package com.example.gerenciadorfilmes.controllers;

import com.example.gerenciadorfilmes.dtos.AtorDto;
import com.example.gerenciadorfilmes.dtos.DiretorDto;
import com.example.gerenciadorfilmes.dtos.FilmeDto;
import com.example.gerenciadorfilmes.services.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmeController {

    @Autowired
    private FilmeService fs;

    @PostMapping("/filmes")
    public boolean addFilme(@RequestBody FilmeDto filme) {
        return this.fs.addFilme(filme);
    }

    @GetMapping("/filmes")
    public List<FilmeDto> listaFilmes(){
        return this.fs.listaFilmesOrdenadoPorNome();
    }

    @GetMapping("/filmes/diretor/{nomediretor}")
    public List<FilmeDto> listaFilmesPorDiretor(@PathVariable("nomediretor") String nomeDiretor){
        DiretorDto diretor = new DiretorDto(nomeDiretor);
        return this.fs.listaFilmesPorDiretor(diretor);
    }

    @GetMapping("/filmes/ator/{nomeator}")
    public List<FilmeDto> listaFilmesPorAtor(@PathVariable("nomeator") String nomeAtor){
        AtorDto ator = new AtorDto(nomeAtor);
        return this.fs.listaFilmesPorAtor(ator);
    }

    @GetMapping("/filmes/nota/{nota}")
    public List<FilmeDto> listaFilmesPorNota(@PathVariable("nota") Float nota){
        return this.fs.listaFilmesPorNota(nota);
    }
}