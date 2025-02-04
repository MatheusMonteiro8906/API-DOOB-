package com.example.locadora.model;

import java.util.Objects;

public class Filme {
    private Long Id;
    private String Nome;
    private double Rating;
    private String Sinopse;
    private boolean Emprestado;
    private double Preco;
    private int ContadorEmprestimos;

    public Filme(Long id, String nome, double rating, String sinopse, double preco) {
        this.Id = id;
        this.Nome = nome;
        this.Rating = rating;
        this.Sinopse = sinopse;
        this.Emprestado = false;
        this.Preco = preco;
        this.ContadorEmprestimos = 0;
    }

    // Getters
    public Long getId() {
        return Id;
    }

    public String getNome() {
        return Nome;
    }

    public double getRating() {
        return Rating;
    }

    public String getSinopse() {
        return Sinopse;
    }

    public boolean isEmprestado() {
        return Emprestado;
    }

    public double getPreco() {
        return Preco;
    }

    public int getContadorEmprestimos() {
        return ContadorEmprestimos;
    }

    // Setters
    public void setPreco(double preco) {
        this.Preco = preco;
    }

    public void incrementarContadorEmprestimos() {
        this.ContadorEmprestimos++;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public void setRating(double rating) {
        this.Rating = rating;
    }

    public void setSinopse(String sinopse) {
        this.Sinopse = sinopse;
    }

    public void setEmprestado(boolean emprestado) {
        this.Emprestado = emprestado;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + Id +
                ", nome='" + Nome + '\'' +
                ", rating=" + Rating +
                ", sinopse='" + Sinopse + '\'' +
                ", emprestado=" + Emprestado +
                ", preco=" + Preco +
                ", contadorEmprestimos=" + ContadorEmprestimos +
                '}';
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (objeto == null || getClass() != objeto.getClass()) return false;
        Filme filme = (Filme) objeto;
        return Double.compare(filme.Rating, Rating) == 0 &&
                Emprestado == filme.Emprestado &&
                Double.compare(filme.Preco, Preco) == 0 &&
                ContadorEmprestimos == filme.ContadorEmprestimos &&
                Objects.equals(Id, filme.Id) &&
                Objects.equals(Nome, filme.Nome) &&
                Objects.equals(Sinopse, filme.Sinopse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Nome, Rating, Sinopse, Emprestado, Preco, ContadorEmprestimos);
    }
}
