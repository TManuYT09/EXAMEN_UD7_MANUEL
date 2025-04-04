package org.example.excursion;

import java.util.Objects;

public class Estudiante {
    private String apellido;
    private String nombre;
    private String curso;
    private int edad;

    public Estudiante(String apellido, String nombre, String curso, int edad) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.curso = curso;
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public String getCurso() {
        return curso;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Estudiante that = (Estudiante) o;
        return Objects.equals(apellido, that.apellido) && Objects.equals(nombre, that.nombre) && Objects.equals(curso, that.curso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apellido, nombre, curso);
    }
}
