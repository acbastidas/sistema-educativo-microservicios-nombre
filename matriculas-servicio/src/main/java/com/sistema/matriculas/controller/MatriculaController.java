package com.sistema.matriculas.controller;

import com.sistema.matriculas.dto.MatriculaRequest;
import com.sistema.matriculas.service.MatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/matriculas")
@RequiredArgsConstructor
public class MatriculaController {

    private final MatriculaService matriculaService;

    @PostMapping
    public String registrarMatricula(@RequestBody MatriculaRequest request) {
        return matriculaService.matricular(request.getUsuarioId(), request.getAsignaturaId());
    }

    // Endpoint de prueba para verificar en Postman o navegador
    @GetMapping("/saludo")
    public String saludar() {
        return "Hola desde el microservicio de matrículas";
    }
}
