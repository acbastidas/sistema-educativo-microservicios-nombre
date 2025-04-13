package com.sistema.usuarios.controller;

import com.sistema.usuarios.dto.JwtResponse;
import com.sistema.usuarios.model.Usuario;
import com.sistema.usuarios.service.UsuarioService;
import com.sistema.usuarios.security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/usuarios")
    public ResponseEntity<JwtResponse> crearUsuario(@RequestBody Usuario usuario) {
        // Lógica para crear el usuario
        Usuario usuarioCreado = usuarioService.saveUsuario(usuario);

        String jwt = jwtUtil.generateToken(usuarioCreado.getNombre());
        JwtResponse jwtResponse = new JwtResponse(jwt, usuarioCreado.getNombre(), usuarioCreado.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(jwtResponse);
    }
}
