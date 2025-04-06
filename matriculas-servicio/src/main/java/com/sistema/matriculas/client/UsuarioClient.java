package com.sistema.matriculas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.sistema.matriculas.model.Usuario;

@FeignClient(name = "usuarios-servicio", url = "http://localhost:8081")
public interface UsuarioClient {

    @GetMapping("/usuarios/{id}")
    Usuario obtenerUsuarioPorId(@PathVariable("id") String id);
}
