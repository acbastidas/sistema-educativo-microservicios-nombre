package com.sistema.matriculas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "asignaturas-servicio")
public interface AsignaturaClient {
    @GetMapping("/api/asignaturas/{id}")
    Asignatura obtenerAsignatura(@PathVariable("id") String id);
}
