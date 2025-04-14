package com.sistema.matriculas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.sistema.matriculas.model.Usuario; // Aquí importamos la clase Usuario

@FeignClient(name = "usuarios-servicio")
public interface UsuarioClient {

    @GetMapping("/api/usuarios/{id}")
    Usuario obtenerUsuario(@PathVariable("id") String id);
}
