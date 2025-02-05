package com.example.locadora.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.locadora.model.Usuario;

@Service
public class UsuarioService {
    private final List<Usuario> usuarios = new ArrayList<>();
    private Long contadorId = 1L;

    public Usuario registrarUsuario(String nome, int idade) {
        Usuario usuario = new Usuario(contadorId++, nome, idade);
        usuarios.add(usuario);
        return usuario;
    }

    public List<Usuario> listarUsuarios() {
        return usuarios;
    }

    public Optional<Usuario> buscarUsuarioPorId(Long userId) {
        return usuarios.stream().filter(usuario -> usuario.getUserId().equals(userId)).findFirst();
    }

    public void deletarUsuarioPorId(Long userId) {
        usuarios.removeIf(usuario -> usuario.getUserId().equals(userId));
    }
}
