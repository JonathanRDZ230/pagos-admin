package com.mx.devJobs.pagosadmin.dto;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.util.Date;

public class PersonalAdminDTO {

    private Long id_personal;
    private String nombreCompleto;
    private int edad;
    private int sexo;
    private String ubicacion;
    private int activo;
    private String direccion;
    private String carrera;
    private Date fechaRegistro;
    private Timestamp fechaUpdate;
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
