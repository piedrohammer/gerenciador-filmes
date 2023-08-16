package com.example.gerenciadorfilmes.services;

import java.util.ArrayList;
import java.util.List;

import com.example.gerenciadorfilmes.dtos.AtorDto;
import com.example.gerenciadorfilmes.entities.Ator;
import com.example.gerenciadorfilmes.repositories.AtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AtorService {

    @Autowired
    private AtorRepository ar;

    @Transactional(readOnly = false)
    public boolean addAtor(AtorDto ator) {

        Ator novoAtor = new Ator(ator);

        Ator atorSalvo = this.ar.save(novoAtor);

        if(atorSalvo != null) {
            return true;
        }
        else {
            return false;
        }
    }

    @Transactional(readOnly = true)
    public List<AtorDto> listaAtores(){
        List<Ator> atoresDoBanco = ar.findByOrderByNomeAsc();

        List<AtorDto> atores = null;

        if(atoresDoBanco != null) {
            atores = new ArrayList<AtorDto>();

            for(Ator a : atoresDoBanco) {
                atores.add(new AtorDto(a));
            }
        }

        return atores;
    }
}