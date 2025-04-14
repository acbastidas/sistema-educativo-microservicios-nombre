package com.sistema.asignaturas.controller;

import com.sistema.asignaturas.model.Asignatura;
import com.sistema.asignaturas.service.AsignaturaService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Asignatura> obtener(@PathVariable String id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Asignatura> crear(@RequestBody Asignatura asignatura) {
        Asignatura nueva = service.guardar(asignatura);
        return ResponseEntity.status(201).body(nueva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint de prueba para verificar en Postman o navegador
    @GetMapping("/saludo")
    public String saludar() {
        return "Hola desde el microservicio de asignaturas";
    }
}
