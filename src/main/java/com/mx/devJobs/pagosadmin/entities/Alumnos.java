package com.mx.devJobs.pagosadmin.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ALUMNOS", schema = "ISAUL")
@SequenceGenerator(name="Seq_alumnos", sequenceName = "ISAUL.SEQ_ALUMNOS", allocationSize=1)
public class Alumnos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Seq_alumnos")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ALUMNO")
    private Long id_alumno;
    @Column(name = "NOMBRE_ALUMNO")
    private String nombreAlumno;
    @Column(name = "EDAD")
    private int edad;
    @Column(name = "FECHA_INSCRIPCION")
    private Date fechaInscripcion;
    @Column(name = "CURSO")
    private int curso;
    @Column(name = "MAESTRO")
    private int maestro;

    public Long getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(Long id_alumno) {
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

    public Alumnos() {

    }
}
