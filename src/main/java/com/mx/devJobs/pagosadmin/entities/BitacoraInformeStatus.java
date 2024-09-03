package com.mx.devJobs.pagosadmin.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BITACORA_INFORME_ESTATUS", schema = "JONATHAN_R")
public class BitacoraInformeStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BITACORA_INFORME_ESTATUS")
    @SequenceGenerator(name = "SEQ_BITACORA_INFORME_ESTATUS", sequenceName = "SEQ_BITACORA_INFORME_ESTATUS", allocationSize = 1)
    @Column(name = "ID_BITACORA")
    private Long idBitacora;

    @Column(name = "ID_PROYECTO")
    private Integer idProyecto;

    @Column(name = "USUARIO")
    private String usuario;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_ACTUAL")
    private Date fechaActual;

    @Column(name = "ESTATUS")
    private String estatus;

    @Column(name = "FECHA_REGISTRO_INFORME")
    private Date fechaRegistroInforme;

    @Column(name = "FECHA_ENVIO_INFORME")
    private Date fechaEnvioInforme;

    @Column(name = "BANDERA_TRANSACCION")
    private String banderaTransaccion;

    @Column(name = "FOLIO_PROYECTO")
    private Integer folioProyecto;

    public Long getIdBitacora() {
        return idBitacora;
    }
    public void setIdBitacora(Long idBitacora) {
        this.idBitacora = idBitacora;
    }
    public Integer getIdProyecto() {
        return idProyecto;
    }
    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public Date getFechaActual() {
        return fechaActual;
    }
    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }
    public String getEstatus() {
        return estatus;
    }
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    public Date getFechaRegistroInforme() {
        return fechaRegistroInforme;
    }
    public void setFechaRegistroInforme(Date fechaRegistroInforme) {
        this.fechaRegistroInforme = fechaRegistroInforme;
    }
    public Date getFechaEnvioInforme() {
        return fechaEnvioInforme;
    }
    public void setFechaEnvioInforme(Date fechaEnvioInforme) {
        this.fechaEnvioInforme = fechaEnvioInforme;
    }
    public String getBanderaTransaccion() {
        return banderaTransaccion;
    }
    public void setBanderaTransaccion(String banderaTransaccion) {
        this.banderaTransaccion = banderaTransaccion;
    }
    public Integer getFolioProyecto() {
        return folioProyecto;
    }
    public void setFolioProyecto(Integer folioProyecto) {
        this.folioProyecto = folioProyecto;
    }

}
