package com.example.gerenciadorfilmes.repositories;

import com.example.gerenciadorfilmes.entities.Ator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtorRepository extends JpaRepository<Ator, Long> {
    public List<Ator> findByOrderByNomeAsc();
    public Ator getReferenceByNome(String nome);
}
