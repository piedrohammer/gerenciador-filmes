package com.example.gerenciadorfilmes.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "cf_filme")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Diretor diretor;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Ator> elenco;

    private float nota;

    public Filme() {
    }

    public Filme(Long id, String nome, Diretor diretor, Set<Ator> elenco, float nota) {
        this.id = id;
        this.nome = nome;
        this.diretor = diretor;
        this.elenco = elenco;
        this.nota = nota;
    }

    public Filme(String nome, Diretor diretor, Set<Ator> elenco, float nota) {
        this.nome = nome;
        this.diretor = diretor;
        this.elenco = elenco;
        this.nota = nota;
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

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public Set<Ator> getElenco() {
        return elenco;
    }

    public void setElenco(Set<Ator> elenco) {
        this.elenco = elenco;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
}
