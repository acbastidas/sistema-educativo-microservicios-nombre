package com.sistema.matriculas.controller;

import com.sistema.matriculas.service.MatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/matriculas")
@RequiredArgsConstructor
public class MatriculaController {

    private final MatriculaService matriculaService;

    @PostMapping("/registrar")
    public String registrarMatricula(@RequestParam String usuarioId, @RequestParam String asignaturaId) {
        return matriculaService.matricular(usuarioId, asignaturaId);
    }

    @GetMapping
    public String listarMatriculas() {
        return "Endpoint de prueba: listar matrículas funcionando correctamente.";
    }

    // Endpoint de prueba para verificar en Postman o navegador
    @GetMapping("/saludo")
    public String saludar() {
        return "Hola desde el microservicio de asignaturas";
    }
}
