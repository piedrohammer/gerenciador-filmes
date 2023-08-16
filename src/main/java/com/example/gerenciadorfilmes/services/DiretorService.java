package com.example.gerenciadorfilmes.services;

import java.util.ArrayList;
import java.util.List;

import com.example.gerenciadorfilmes.dtos.DiretorDto;
import com.example.gerenciadorfilmes.entities.Diretor;
import com.example.gerenciadorfilmes.repositories.DiretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class DiretorService {

    @Autowired
    private DiretorRepository dr;

    @Transactional(readOnly = false)
    public boolean addDiretor(DiretorDto diretor) {
        Diretor novoDiretor = dr.save(new Diretor(diretor));

        if(novoDiretor != null)
            return true;
        else
            return false;
    }

    @Transactional(readOnly = true)
    public List<DiretorDto> listaDiretores(){

        List<Diretor> diretoresDoBanco = this.dr.findByOrderByNomeAsc();

        List<DiretorDto> diretoresDto = null;

        if(diretoresDoBanco != null) {
            diretoresDto = new ArrayList<DiretorDto>();

            for(Diretor d : diretoresDoBanco)
                diretoresDto.add(new DiretorDto(d));
        }

        return diretoresDto;
    }
}