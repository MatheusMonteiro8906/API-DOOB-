package com.example.locadora.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*")
public class FilmesController {

    public static class AlugarFilmeRequest {
        private Long userId;
    
        public Long getUserId() {
            return userId;
        }
    
        public void setUserId(Long userId) {
            this.userId = userId;
        }
    }

    @Autowired
    private FilmeService filmeService;

    @PostMapping
    public Filme adicionarFilme(@RequestBody Filme filme) {
        return filmeService.adicionarFilme(filme.getNome(), filme.getRating(), filme.getSinopse(), filme.getPreco());
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

    @PostMapping("/{id}/alugar")
    public Filme emprestarFilme(@PathVariable Long id, @RequestBody AlugarFilmeRequest request) {
        return filmeService.emprestarFilme(id, request.getUserId());
    }

    @PostMapping("/{id}/devolver")
    public Filme devolverFilme(@PathVariable Long id) {
        return filmeService.devolverFilme(id);
    }

    @GetMapping("/mais-alugados")
    public List<Filme> listarFilmesMaisAlugados() {
        return filmeService.listarFilmesMaisAlugados();
    }

    @GetMapping("/alugados")
    public List<Filme> listarAlugados() {
        return filmeService.listarAlugados();
    }

}
