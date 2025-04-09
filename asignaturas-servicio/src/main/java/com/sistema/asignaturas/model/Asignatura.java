package com.sistema.asignaturas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "asignaturas")
public class Asignatura {

    @Id
    private String id;
    private String nombre;
    private String aula;
    private int creditos;

    // Constructor vacío requerido por Spring y MongoDB
    public Asignatura() {
    }

    // Constructor con los 4 parámetros
    public Asignatura(String id, String nombre, String aula, int creditos) {
        this.id = id;
        this.nombre = nombre;
        this.aula = aula;
        this.creditos = creditos;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
}
