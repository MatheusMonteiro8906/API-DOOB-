package com.example.locadora.model;

import java.util.Objects;

public class Usuario {
    private Long id;
    private String nome;
    private boolean possuiEmprestimo;

    public Usuario(Long id, String nome) {
        this.id = id;
        this.nome = nome;
        this.possuiEmprestimo = false;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean isPossuiEmprestimo() {
        return possuiEmprestimo;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPossuiEmprestimo(boolean possuiEmprestimo) {
        this.possuiEmprestimo = possuiEmprestimo;
    }

    // toString
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", possuiEmprestimo=" + possuiEmprestimo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return possuiEmprestimo == usuario.possuiEmprestimo &&
                Objects.equals(id, usuario.id) &&
                Objects.equals(nome, usuario.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, possuiEmprestimo);
    }
}
