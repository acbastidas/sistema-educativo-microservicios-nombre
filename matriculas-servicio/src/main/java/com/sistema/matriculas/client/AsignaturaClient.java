package com.sistema.matriculas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.sistema.matriculas.model.Asignatura;

@FeignClient(name = "asignaturas-servicio", url = "http://localhost:8080")
public interface AsignaturaClient {

    @GetMapping("/asignaturas/{id}")
    Asignatura obtenerAsignaturaPorId(@PathVariable("id") String id);
}
