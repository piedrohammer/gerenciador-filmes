package com.example.gerenciadorfilmes.entities;

import com.example.gerenciadorfilmes.dtos.AtorDto;
import jakarta.persistence.*;

@Entity
@Table(name = "cf_ator")
public class Ator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    public Ator() {
    }

    public Ator(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Ator(AtorDto ator) {
        this.nome = ator.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
