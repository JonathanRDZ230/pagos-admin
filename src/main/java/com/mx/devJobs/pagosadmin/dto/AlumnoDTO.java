package com.mx.devJobs.pagosadmin.dto;

import java.util.Date;

public class AlumnoDTO {

    private int id_alumno;
    private String nombreAlumno;
    private int edad;
    private Date fechaInscripcion;
    private int curso;
    private int maestro;

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getMaestro() {
        return maestro;
    }

    public void setMaestro(int maestro) {
        this.maestro = maestro;
    }
}
