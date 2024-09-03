package com.mx.devJobs.pagosadmin.entities;

import javax.persistence.*;

@Entity
@Table(name = "INFORME_EMPLEADOS", schema = "JONATHAN_R")
public class InformeEmpleados {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceEmpleados")
    @SequenceGenerator(name = "sequenceEmpleados", sequenceName = "SEQ_INFORME_EMPLEADOS", allocationSize = 1)
    @Column(name = "ID_EMPLEADO")
    private Long idEmpleado;

    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;

    @Column(name = "RFC")
    private String rfc;

    @Column(name = "CURP")
    private String curp;

    @Column(name = "EDAD")
    private Integer edad;

    @Column(name = "SEXO")
    private char sexo;

    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "NSS")
    private Long nss;

    @Column(name = "TELEFONO")
    private Long telefono;

    @Column(name = "ACTIVO")
    private short activo;

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getNss() {
        return nss;
    }

    public void setNss(Long nss) {
        this.nss = nss;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public short getActivo() {
        return activo;
    }

    public void setActivo(short activo) {
        this.activo = activo;
    }
}
