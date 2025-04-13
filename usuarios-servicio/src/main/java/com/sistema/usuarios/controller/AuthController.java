package com.sistema.usuarios.controller;

import com.sistema.usuarios.model.Usuario;
import com.sistema.usuarios.repository.UsuarioRepository;
import com.sistema.usuarios.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        Optional<Usuario> userDb = usuarioRepository.findByUsername(usuario.getUsername());
        if (userDb.isPresent() && userDb.get().getPassword().equals(usuario.getPassword())) {
            return jwtUtil.generateToken(usuario.getUsername());
        }
        throw new RuntimeException("Credenciales inválidas");
    }
}
