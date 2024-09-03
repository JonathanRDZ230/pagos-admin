package com.mx.devJobs.pagosadmin.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "INFORME_ESTUDIANTE_DOCUMENTO", schema = "JONATHAN_R")
public class InformeEstudianteDocumento {

    @EmbeddedId
    private InformeEstudianteDocumentoPrimaryKey id;

    @Column(name = "NOMBRE_DOCUMENTO", length = 50)
    private String nombreDocumento;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Column(name = "FECHA_REGISTRO")
    private Date fechaRegistro;


    public InformeEstudianteDocumentoPrimaryKey getId() {
        return id;
    }
    public void setId(InformeEstudianteDocumentoPrimaryKey id) {
        this.id = id;
    }
    public String getNombreDocumento() {
        return nombreDocumento;
    }
    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }
    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
