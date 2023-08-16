package com.example.gerenciadorfilmes.repositories;

import com.example.gerenciadorfilmes.entities.Diretor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiretorRepository extends JpaRepository<Diretor, Long> {
    public List<Diretor> findByOrderByNomeAsc();
    public Diretor getReferenceByNome(String nome);
}
