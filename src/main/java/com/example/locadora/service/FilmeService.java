package com.example.locadora.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.locadora.model.Filme;

@Service
public class FilmeService {
    private final List<Filme> filmes = new ArrayList<>();
    private Long contadorId = 1L;

    public Filme adicionarFilme(String nome, double rating, String sinopse) {
        Filme filme = new Filme(contadorId++, nome, rating, sinopse);
        filmes.add(filme);
        return filme;
    }

    public List<Filme> listarTodos() {
        return filmes;
    }

    public List<Filme> listarDisponiveis() {
        return filmes.stream().filter(filme -> !filme.isEmprestado()).collect(Collectors.toList());
    }

    public Optional<Filme> buscarPorId(Long id) {
        return filmes.stream().filter(filme -> filme.getId().equals(id)).findFirst();
    }

    public Filme atualizarFilme(Long id, Filme novosDados) {
        Filme filme = buscarPorId(id).orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        filme.setNome(novosDados.getNome());
        filme.setRating(novosDados.getRating());
        filme.setSinopse(novosDados.getSinopse());
        return filme;
    }

    public void removerFilme(Long id) {
        filmes.removeIf(filme -> filme.getId().equals(id));
    }
}
