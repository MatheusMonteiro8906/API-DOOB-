package com.example.locadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.locadora.model.Emprestimo;
import com.example.locadora.model.Filme;
import com.example.locadora.model.Usuario;
import com.example.locadora.service.EmprestimoService;
import com.example.locadora.service.FilmeService;
import com.example.locadora.service.UsuarioService;

@RestController
@RequestMapping("/emprestimos")
@CrossOrigin(origins = "*")
public class EmprestimosController {

    @Autowired
    private EmprestimoService emprestimoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private FilmeService filmeService;

    @PostMapping
    public Emprestimo registrarEmprestimo(@RequestParam Long usuarioId, @RequestParam Long filmeId) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Filme filme = filmeService.buscarPorId(filmeId)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));

        return emprestimoService.registrarEmprestimo(usuario, filme);
    }

    @PostMapping("/devolucao/{id}")
    public void registrarDevolucao(@PathVariable Long id) {
        emprestimoService.registrarDevolucao(id);
    }

    @GetMapping("/atrasados")
    public List<Emprestimo> listarAtrasados() {
        return emprestimoService.listarAtrasados();
    }
}
