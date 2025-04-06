package com.sistema.matriculas.controller;

import com.sistema.matriculas.service.MatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matriculas")
@RequiredArgsConstructor
public class MatriculaController {

    private final MatriculaService matriculaService;

    @PostMapping("/registrar")
    public String registrarMatricula(@RequestParam String usuarioId, @RequestParam String asignaturaId) {
        return matriculaService.matricular(usuarioId, asignaturaId);
    }
}
