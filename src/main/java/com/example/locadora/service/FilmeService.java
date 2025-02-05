package com.example.locadora.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.locadora.model.Filme;
import com.example.locadora.model.Usuario;

@Service
public class FilmeService {
    private final UsuarioService usuarioService;
    private final List<Filme> filmes = new ArrayList<>();
    private Long contadorId = 1L;

    public FilmeService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public Filme adicionarFilme(String nome, double rating, String sinopse, double preco) {
        Filme filme = new Filme(contadorId++, nome, rating, sinopse, preco);
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
        filme.setPreco(novosDados.getPreco());
            return filme;
    }

    public void removerFilme(Long id) {
        filmes.removeIf(filme -> filme.getId().equals(id));
    }

    public Filme emprestarFilme(Long id, Long userId) {
        Filme filme = buscarPorId(id).orElseThrow(() -> new RuntimeException("Filme não encontrado"));

        if (filme.isEmprestado()) {
            throw new RuntimeException("Filme já emprestado");
    }

    Optional<Usuario> usuarioOpt = usuarioService.buscarUsuarioPorId(userId);
        if (!usuarioOpt.isPresent()) {
            throw new RuntimeException("Usuário não encontrado");
    }

    Usuario usuario = usuarioOpt.get();

        if (usuario.isPossuiEmprestimo()) {
            throw new RuntimeException("Usuário já possui um empréstimo ativo");
    }

        filme.setEmprestado(true);
        filme.incrementarContadorEmprestimos();
        usuario.setPossuiEmprestimo(true);

            return filme;
}

    public Filme devolverFilme(Long id) {
        Filme filme = buscarPorId(id).orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        if (filme.isEmprestado()) {
            filme.setEmprestado(false);
        }
            return filme;
    }

    public List<Filme> listarFilmesMaisAlugados() {
            return filmes.stream()
                    .sorted((f1, f2) -> Integer.compare(f2.getContadorEmprestimos(), f1.getContadorEmprestimos()))
                    .limit(10)
                    .collect(Collectors.toList());
    }

    public List<Filme> listarAlugados() {
        return filmes.stream()
            .filter(Filme::isEmprestado)
            .collect(Collectors.toList());
    }
}
