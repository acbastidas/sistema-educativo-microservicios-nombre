package com.sistema.asignaturas.controller;

import com.sistema.asignaturas.model.Asignatura;
import com.sistema.asignaturas.service.AsignaturaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {

    private final AsignaturaService service;

    public AsignaturaController(AsignaturaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Asignatura> listar() {
        return service.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Asignatura obtener(@PathVariable String id) {
        return service.obtenerPorId(id).orElse(null);
    }

    @PostMapping
    public Asignatura crear(@RequestBody Asignatura asignatura) {
        return service.guardar(asignatura);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        service.eliminar(id);
    }

    // Endpoint de prueba para verificar en Postman o navegador
    @GetMapping("/saludo")
    public String saludar() {
        return "Hola desde el microservicio de asignaturas";
    }
}
