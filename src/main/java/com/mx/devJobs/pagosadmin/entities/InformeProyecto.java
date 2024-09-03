package com.mx.devJobs.pagosadmin.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "INFORME_PROYECTO", schema = "JONATHAN_R")
public class InformeProyecto implements Serializable {

    @EmbeddedId
    private InformeProyectoPrimaryKey id;
    private String usuario;
    private Date fechaRegistroInforme;
    private Date fechaEnvioInforme;
    private Integer cveEstatusInforme;
    private String cveInstitucion;
    private Integer esDecimoAnio;

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "idInforme", column = @Column(name = "ID_INFORME", nullable = false, precision = 10, scale = 0)),
            @AttributeOverride(name = "idProyecto", column = @Column(name = "ID_PROYECTO", nullable = false, precision = 6, scale = 0)),
            @AttributeOverride(name = "numeroConvocatoria", column = @Column(name = "NUMERO_CONVOCATORIA", nullable = false, length = 20)),
            @AttributeOverride(name = "anio", column = @Column(name = "ANIO", nullable = false, precision = 4, scale = 0)),
            @AttributeOverride(name = "cveTipoInforme", column = @Column(name = "CVE_TIPO_INFORME", nullable = false, precision = 2, scale =0))})
    public InformeProyectoPrimaryKey getId() {
        return this.id;
    }

    public void setId(InformeProyectoPrimaryKey id) {
        this.id = id;
    }

    @Column(name = "USUARIO", nullable = false)
    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Column(name = "FECHA_REGISTRO_INFORME")
    public Date getFechaRegistroInforme() {
        return this.fechaRegistroInforme;
    }

    public void setFechaRegistroInforme(Date fechaRegistroInforme) {
        this.fechaRegistroInforme = fechaRegistroInforme;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Column(name = "FECHA_ENVIO_INFORME")
    public Date getFechaEnvioInforme() {
        return this.fechaEnvioInforme;
    }

    public void setFechaEnvioInforme(Date fechaEnvioInforme) {
        this.fechaEnvioInforme = fechaEnvioInforme;
    }

    @Column(name = "CVE_ESTATUS_INFORME", nullable = false, precision = 2, scale = 0)
    public Integer getCveEstatusInforme() {
        return this.cveEstatusInforme;
    }

    public void setCveEstatusInforme(Integer cveEstatusInforme) {
        this.cveEstatusInforme = cveEstatusInforme;
    }

    @Column(name = "CVE_INSTITUCION", nullable = false, length = 20)
    public String getCveInstitucion() {
        return this.cveInstitucion;
    }

    public void setCveInstitucion(String cveInstitucion) {
        this.cveInstitucion = cveInstitucion;
    }

    @Column(name = "ES_DECIMO_ANIO", precision = 1, scale = 0)
    public Integer getEsDecimoAnio() {
        return this.esDecimoAnio;
    }

    public void setEsDecimoAnio(Integer esDecimoAnio) {
        this.esDecimoAnio = esDecimoAnio;
    }
}
