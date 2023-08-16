package com.example.gerenciadorfilmes.dtos;

import com.example.gerenciadorfilmes.entities.Ator;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class AtorDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty // vai ta nos objs -> no json
    private String nome;

    public AtorDto() {

    }

    @JsonCreator // Pega o construtor q vc quer usar
    public AtorDto(String nome) {
        this.nome = nome;
    }

    public AtorDto(AtorDto ator) {
        this.nome = ator.getNome();
    }

    public AtorDto(Ator ator) {
        this.nome = ator.getNome();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AtorDto other = (AtorDto) obj;
        return Objects.equals(nome, other.nome);
    }
}