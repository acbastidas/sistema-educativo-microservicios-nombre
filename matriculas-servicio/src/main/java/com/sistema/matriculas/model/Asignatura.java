package com.sistema.matriculas.model;

public class Asignatura {
    private String asignaturaId;
    private String nombre;

    public Asignatura(String asignaturaId, String nombre) {
        this.asignaturaId = asignaturaId;
        this.nombre = nombre;
    }

    // Getters y setters
    public String getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(String asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
