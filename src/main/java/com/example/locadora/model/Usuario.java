package com.example.locadora.model;

import java.util.Objects;

public class Usuario {
    private Long Id;
    private String Nome;
    private boolean PossuiEmprestimo;

    public Usuario(Long id, String nome) {
        this.Id = id;
        this.Nome = nome;
        this.PossuiEmprestimo = false;
    }

    // Getters
    public Long getId() {
        return Id;
    }

    public String getNome() {
        return Nome;
    }

    public boolean isPossuiEmprestimo() {
        return PossuiEmprestimo;
    }

    // Setters
    public void setId(Long id) {
        this.Id = id;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public void setPossuiEmprestimo(boolean possuiEmprestimo) {
        this.PossuiEmprestimo = possuiEmprestimo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + Id +
                ", nome='" + Nome + '\'' +
                ", possuiEmprestimo=" + PossuiEmprestimo +
                '}';
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (objeto == null || getClass() != objeto.getClass()) return false;
        Usuario usuario = (Usuario) objeto;
        return PossuiEmprestimo == usuario.PossuiEmprestimo &&
                Objects.equals(Id, usuario.Id) &&
                Objects.equals(Nome, usuario.Nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Nome, PossuiEmprestimo);
    }
}
