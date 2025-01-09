package com.example.locadora.model;

import java.util.Objects;

public class Filme {
    private Long id;
    private String nome;
    private double rating;
    private String sinopse;
    private boolean emprestado;

    public Filme(Long id, String nome, double rating, String sinopse) {
        this.id = id;
        this.nome = nome;
        this.rating = rating;
        this.sinopse = sinopse;
        this.emprestado = false;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getRating() {
        return rating;
    }

    public String getSinopse() {
        return sinopse;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    // toString
    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", rating=" + rating +
                ", sinopse='" + sinopse + '\'' +
                ", emprestado=" + emprestado +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filme Filme = (Filme) o;
        return Double.compare(Filme.rating, rating) == 0 &&
                emprestado == Filme.emprestado &&
                Objects.equals(id, Filme.id) &&
                Objects.equals(nome, Filme.nome) &&
                Objects.equals(sinopse, Filme.sinopse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, rating, sinopse, emprestado);
    }

    }

