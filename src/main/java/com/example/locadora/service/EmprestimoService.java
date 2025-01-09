package com.example.locadora.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.locadora.model.Emprestimo;
import com.example.locadora.model.Filme;
import com.example.locadora.model.Usuario;

@Service
public class EmprestimoService {
    private final List<Emprestimo> emprestimos = new ArrayList<>();
    private Long contadorId = 1L;

    public Emprestimo registrarEmprestimo(Usuario usuario, Filme Filme) {
        if (Filme.isEmprestado()) {
            throw new RuntimeException("Filme já está emprestado!");
        }

        Filme.setEmprestado(true);
        usuario.setPossuiEmprestimo(true);

        Emprestimo emprestimo = new Emprestimo(
            contadorId++, usuario, Filme, LocalDate.now(), LocalDate.now().plusDays(14)
        );
        emprestimos.add(emprestimo);
        return emprestimo;
    }

    public void registrarDevolucao(Long id) {
        Emprestimo emprestimo = emprestimos.stream()
            .filter(e -> e.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));

        emprestimo.getFilme().setEmprestado(false);
        emprestimo.getUsuario().setPossuiEmprestimo(false);
        emprestimo.setDataDevolucaoReal(LocalDate.now());
    }

    public List<Emprestimo> listarAtrasados() {
        return emprestimos.stream()
            .filter(e -> e.getDataDevolucaoReal() == null && e.getDataDevolucaoPrevista().isBefore(LocalDate.now()))
            .collect(Collectors.toList());
    }
}
