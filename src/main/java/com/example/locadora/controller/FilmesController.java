package com.example.locadora.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.locadora.model.Filme;
import com.example.locadora.service.FilmeService;

@RestController
@RequestMapping(value = "/filmes")
public class FilmesController {

    @Autowired
    private FilmeService filmeService;

    @PostMapping
    public Filme adicionarFilme(@RequestBody Filme filme) {
        return filmeService.adicionarFilme(filme.getNome(), filme.getRating(), filme.getSinopse());
    }

    @GetMapping
    public List<Filme> listarFilmes() {
        return filmeService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Filme> buscarFilmePorId(@PathVariable Long id) {
        return filmeService.buscarPorId(id);
    }

    @GetMapping("/disponiveis")
    public List<Filme> listarDisponiveis() {
        return filmeService.listarDisponiveis();
    }

    @PatchMapping("/{id}")
    public Filme atualizarFilme(@PathVariable Long id, @RequestBody Filme novosDados) {
        return filmeService.atualizarFilme(id, novosDados);
    }

    @DeleteMapping("/{id}")
    public void removerFilme(@PathVariable Long id) {
        filmeService.removerFilme(id);
    }
}
