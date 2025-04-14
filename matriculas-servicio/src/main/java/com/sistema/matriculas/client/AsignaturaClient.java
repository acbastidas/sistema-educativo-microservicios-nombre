package com.sistema.matriculas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.sistema.matriculas.model.Asignatura; // Aquí se importa la clase Asignatura

@FeignClient(name = "asignaturas-servicio")
public interface AsignaturaClient {

    @GetMapping("/api/asignaturas/{id}")
    Asignatura obtenerAsignatura(@PathVariable("id") String id);
}
