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

    public Usuario registrarUsuario(String nome) {
        Usuario usuario = new Usuario(contadorId++, nome);
        usuarios.add(usuario);
        return usuario;
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarios.stream().filter(usuario -> usuario.getId().equals(id)).findFirst();
    }
}
