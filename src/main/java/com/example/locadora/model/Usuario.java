package com.example.locadora.model;

import java.util.Objects;

public class Usuario {
    private Long userId;
    private String nome;
    private boolean possuiEmprestimo;
    private int idade;

    public Usuario(Long userId, String nome, int idade) {
        this.userId = userId;
        this.nome = nome;
        this.possuiEmprestimo = false;
        this.idade = idade;
    }

    // Getters
    public Long getUserId() {
        return userId;
    }

    public String getNome() {
        return nome;
    }

    public boolean isPossuiEmprestimo() {
        return possuiEmprestimo;
    }

    public int getIdade() {
        return idade;
    }

    // Setters
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPossuiEmprestimo(boolean possuiEmprestimo) {
        this.possuiEmprestimo = possuiEmprestimo;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "userId=" + userId +
                ", nome='" + nome + '\'' +
                ", possuiEmprestimo=" + possuiEmprestimo +
                ", idade=" + idade +
                '}';
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (objeto == null || getClass() != objeto.getClass()) return false;
        Usuario usuario = (Usuario) objeto;
        return possuiEmprestimo == usuario.possuiEmprestimo &&
                idade == usuario.idade &&
                Objects.equals(userId, usuario.userId) &&
                Objects.equals(nome, usuario.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, nome, possuiEmprestimo, idade);
    }
}
