package com.example.gerenciadorfilmes.repositories;

import com.example.gerenciadorfilmes.entities.Diretor;
import com.example.gerenciadorfilmes.entities.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
    public List<Filme> findByOrderByNomeAsc();
    public List<Filme> findByDiretorOrderByNomeAsc(Diretor diretor);
    public List<Filme> findByNotaGreaterThanEqualOrderByNome(Float nota);
    @Query(value="select * from cf_filme as u inner join cf_filme_elenco as e on e.filme_id=u.id WHERE elenco_id=:id order by nome", nativeQuery=true)
    public List<Filme> findByAtorOrderByNome(Long id);
}