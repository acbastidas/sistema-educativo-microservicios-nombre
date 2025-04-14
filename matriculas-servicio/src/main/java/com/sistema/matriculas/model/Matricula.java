package com.sistema.matriculas.model;

public class Matricula {
    private String matriculaId;
    private String usuarioId;
    private String asignaturaId;

    public Matricula(String matriculaId, String usuarioId, String asignaturaId) {
        this.matriculaId = matriculaId;
        this.usuarioId = usuarioId;
        this.asignaturaId = asignaturaId;
    }

    // Getters y setters
    public String getMatriculaId() {
        return matriculaId;
    }

    public void setMatriculaId(String matriculaId) {
        this.matriculaId = matriculaId;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(String asignaturaId) {
        this.asignaturaId = asignaturaId;
    }
}
