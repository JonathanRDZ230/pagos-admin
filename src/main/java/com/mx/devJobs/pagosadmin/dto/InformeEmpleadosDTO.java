package com.mx.devJobs.pagosadmin.dto;

public class InformeEmpleadosDTO {

    private Long idEmpleado;
    private String nombreCompleto;
    private String rfc;
    private String curp;
    private Integer edad;
    private char sexo;
    private String direccion;
    private Long nss;
    private Long telefono;
    private short activo;

    public InformeEmpleadosDTO() {
    }

    public InformeEmpleadosDTO(Long idEmpleado, String nombreCompleto, String rfc, String curp, Integer edad, char sexo,
                               String direccion, Long nss, Long telefono, short activo) {
        this.idEmpleado = idEmpleado;
        this.nombreCompleto = nombreCompleto;
        this.rfc = rfc;
        this.curp = curp;
        this.edad = edad;
        this.sexo = sexo;
        this.direccion = direccion;
        this.nss = nss;
        this.telefono = telefono;
        this.activo = activo;
    }

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
