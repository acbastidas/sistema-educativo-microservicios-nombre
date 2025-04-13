package com.sistema.matriculas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuarios-servicio")
public interface UsuarioClient {

    @GetMapping("/api/usuarios/{id}")
    Usuario obtenerUsuario(@PathVariable("id") String id);
}
