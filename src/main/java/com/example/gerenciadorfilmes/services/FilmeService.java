package com.example.gerenciadorfilmes.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.example.gerenciadorfilmes.dtos.AtorDto;
import com.example.gerenciadorfilmes.dtos.DiretorDto;
import com.example.gerenciadorfilmes.dtos.FilmeDto;
import com.example.gerenciadorfilmes.entities.Ator;
import com.example.gerenciadorfilmes.entities.Diretor;
import com.example.gerenciadorfilmes.entities.Filme;
import com.example.gerenciadorfilmes.repositories.AtorRepository;
import com.example.gerenciadorfilmes.repositories.DiretorRepository;
import com.example.gerenciadorfilmes.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class FilmeService {

    @Autowired
    private FilmeRepository fr;
    @Autowired
    private AtorRepository ar;
    @Autowired
    private DiretorRepository dr;

    @Transactional(readOnly = false)
    public boolean addFilme(FilmeDto filme) {

        Diretor diretorJaExiste = dr.getReferenceByNome(filme.getDiretor().getNome());

        HashSet<Ator> elenco = new HashSet<Ator>();

        for (AtorDto a : filme.getElenco()) {
            Ator atorJaExiste = ar.getReferenceByNome(a.getNome());

            if (atorJaExiste != null)
                elenco.add(atorJaExiste);
            else
                elenco.add(new Ator(a));
        }

        Filme f;

        if (diretorJaExiste != null)
            f = new Filme(filme.getNome(), diretorJaExiste, elenco, filme.getNota());
        else
            f = new Filme(filme.getNome(), new Diretor(filme.getDiretor()), elenco, filme.getNota());

        Filme filmeRetorno = fr.save(f);

        if (filmeRetorno != null)
            return true;
        else
            return false;
    }

    @Transactional(readOnly = true)
    public List<FilmeDto> listaFilmesOrdenadoPorNome() {

        List<Filme> filmesDoBanco = this.fr.findByOrderByNomeAsc();

        List<FilmeDto> filmesDto = converteListaFilmeParaFilmeDto(filmesDoBanco);

        return filmesDto;
    }

    @Transactional(readOnly = true)
    public List<FilmeDto> listaFilmesPorDiretor(DiretorDto diretor) {
        Diretor diretorDoBanco = dr.getReferenceByNome(diretor.getNome());

        if (diretorDoBanco == null)
            return null;

        List<Filme> filmesDoBanco = fr.findByDiretorOrderByNomeAsc(diretorDoBanco);

        List<FilmeDto> filmesDto = converteListaFilmeParaFilmeDto(filmesDoBanco);

        return filmesDto;
    }

    @Transactional(readOnly = true)
    public List<FilmeDto> listaFilmesPorAtor(AtorDto ator) {

        Ator a = this.ar.getReferenceByNome(ator.getNome());

        if (a == null)
            return null;

        List<Filme> filmesDoBanco = fr.findByAtorOrderByNome(a.getId());

        List<FilmeDto> filmesDto = converteListaFilmeParaFilmeDto(filmesDoBanco);

        return filmesDto;
    }

    @Transactional(readOnly = true)
    public List<FilmeDto> listaFilmesPorNota(Float nota) {
        List<Filme> filmesDoBanco = fr.findByNotaGreaterThanEqualOrderByNome(nota);

        List<FilmeDto> filmesDto = converteListaFilmeParaFilmeDto(filmesDoBanco);

        return filmesDto;
    }

    private List<FilmeDto> converteListaFilmeParaFilmeDto(List<Filme> filmes) {
        List<FilmeDto> filmesDto = null;

        if (filmes != null) {
            filmesDto = new ArrayList<FilmeDto>();

            for (Filme f : filmes)
                filmesDto.add(new FilmeDto(f));
        }

        return filmesDto;
    }
}
