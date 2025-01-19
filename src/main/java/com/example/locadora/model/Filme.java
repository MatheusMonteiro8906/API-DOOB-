package com.example.locadora.model;

import java.util.Objects;

public class Filme {
    private Long Id;
    private String Nome;
    private double Rating;
    private String Sinopse;
    private boolean Emprestado;

    public Filme(Long id, String nome, double rating, String sinopse) {
        this.Id = id;
        this.Nome = nome;
        this.Rating = rating;
        this.Sinopse = sinopse;
        this.Emprestado = false;
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

    // Setters
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
                '}';
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (objeto == null || getClass() != objeto.getClass()) return false;
        Filme Filme = (Filme) objeto;
        return Double.compare(Filme.Rating, Rating) == 0 &&
                Emprestado == Filme.Emprestado &&
                Objects.equals(Id, Filme.Id) &&
                Objects.equals(Nome, Filme.Nome) &&
                Objects.equals(Sinopse, Filme.Sinopse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Nome, Rating, Sinopse, Emprestado);
    }

    }

