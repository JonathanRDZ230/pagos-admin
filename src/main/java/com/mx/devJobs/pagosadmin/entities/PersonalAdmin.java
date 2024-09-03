package com.mx.devJobs.pagosadmin.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "PERSONAL_ADMIN", schema = "ISAUL")
@SequenceGenerator(name="Seq_personal", sequenceName = "CURSOADMIN.SEQ_PERSONAL", allocationSize=1)
public class PersonalAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Seq_personal")
    @Column(name = "ID_PERSONAL")
    private Long id_personal;
    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;
    @Column(name = "EDAD")
    private int edad;
    @Column(name = "SEXO")
    private int sexo;
    @Column(name = "UBICACION")
    private String ubicacion;
    @Column(name = "ACTIVO")
    private int activo;
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "CARREA")
    private String carrera;
    @Column(name = "FECHA_REGISTRO")
    private Date fechaRegistro;
    @Column(name = "FECHA_UPDATE")
    private Timestamp fechaUpdate;
    @Column(name = "USERNAME")
    private String username;

    public Long getId_personal() {
        return id_personal;
    }

    public void setId_personal(Long id_personal) {
        this.id_personal = id_personal;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Timestamp getFechaUpdate() {
        return fechaUpdate;
    }

    public void setFechaUpdate(Timestamp fechaUpdate) {
        this.fechaUpdate = fechaUpdate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
