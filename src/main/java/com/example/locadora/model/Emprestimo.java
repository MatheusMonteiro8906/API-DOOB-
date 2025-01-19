package com.example.locadora.model;

import java.time.LocalDate;
import java.util.Objects;

public class Emprestimo {
    private Long id;
    private Usuario usuario;
    private Filme filme;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;

    public Emprestimo(Long id, Usuario usuario, Filme filme, LocalDate dataEmprestimo, LocalDate dataDevolucaoPrevista) {
        this.id = id;
        this.usuario = usuario;
        this.filme = filme;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.dataDevolucaoReal = null;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Filme getFilme() {
        return filme;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public LocalDate getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public void setDataDevolucaoReal(LocalDate dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", Filme=" + filme +
                ", dataEmprestimo=" + dataEmprestimo +
                ", dataDevolucaoPrevista=" + dataDevolucaoPrevista +
                ", dataDevolucaoReal=" + dataDevolucaoReal +
                '}';
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (objeto == null || getClass() != objeto.getClass()) return false;
        Emprestimo that = (Emprestimo) objeto;
        return Objects.equals(id, that.id) &&
                Objects.equals(usuario, that.usuario) &&
                Objects.equals(filme, that.filme) &&
                Objects.equals(dataEmprestimo, that.dataEmprestimo) &&
                Objects.equals(dataDevolucaoPrevista, that.dataDevolucaoPrevista) &&
                Objects.equals(dataDevolucaoReal, that.dataDevolucaoReal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, filme, dataEmprestimo, dataDevolucaoPrevista, dataDevolucaoReal);
    }
}
