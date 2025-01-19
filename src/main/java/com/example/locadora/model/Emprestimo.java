package com.example.locadora.model;

import java.time.LocalDate;
import java.util.Objects;

public class Emprestimo {
    private Long Id;
    private Usuario Usuario;
    private Filme Filme;
    private LocalDate DataEmprestimo;
    private LocalDate DataDevolucaoPrevista;
    private LocalDate DataDevolucaoReal;

    public Emprestimo(Long id, Usuario usuario, Filme filme, LocalDate dataEmprestimo, LocalDate dataDevolucaoPrevista) {
        this.Id = id;
        this.Usuario = usuario;
        this.Filme = filme;
        this.DataEmprestimo = dataEmprestimo;
        this.DataDevolucaoPrevista = dataDevolucaoPrevista;
        this.DataDevolucaoReal = null;
    }

    // Getters
    public Long getId() {
        return Id;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public Filme getFilme() {
        return Filme;
    }

    public LocalDate getDataEmprestimo() {
        return DataEmprestimo;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return DataDevolucaoPrevista;
    }

    public LocalDate getDataDevolucaoReal() {
        return DataDevolucaoReal;
    }

    // Setters
    public void setId(Long id) {
        this.Id = id;
    }

    public void setUsuario(Usuario usuario) {
        this.Usuario = usuario;
    }

    public void setFilme(Filme filme) {
        this.Filme = filme;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.DataEmprestimo = dataEmprestimo;
    }

    public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista) {
        this.DataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public void setDataDevolucaoReal(LocalDate dataDevolucaoReal) {
        this.DataDevolucaoReal = dataDevolucaoReal;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "id=" + Id +
                ", usuario=" + Usuario +
                ", Filme=" + Filme +
                ", dataEmprestimo=" + DataEmprestimo +
                ", dataDevolucaoPrevista=" + DataDevolucaoPrevista +
                ", dataDevolucaoReal=" + DataDevolucaoReal +
                '}';
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (objeto == null || getClass() != objeto.getClass()) return false;
        Emprestimo that = (Emprestimo) objeto;
        return Objects.equals(Id, that.Id) &&
                Objects.equals(Usuario, that.Usuario) &&
                Objects.equals(Filme, that.Filme) &&
                Objects.equals(DataEmprestimo, that.DataEmprestimo) &&
                Objects.equals(DataDevolucaoPrevista, that.DataDevolucaoPrevista) &&
                Objects.equals(DataDevolucaoReal, that.DataDevolucaoReal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Usuario, Filme, DataEmprestimo, DataDevolucaoPrevista, DataDevolucaoReal);
    }
}
