package com.sistema.matriculas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.sistema.matriculas.model.Usuario; // Aquí importamos la clase Usuario

@FeignClient(name = "usuarios-servicio")
public interface UsuarioClient {

    @GetMapping("/usuarios/{id}")
    Usuario obtenerUsuario(@PathVariable("id") String id);
}
