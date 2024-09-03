package com.mx.devJobs.pagosadmin.dto;

import java.util.Date;

public class InformeEstudianteDocumentoDTO {

    private Long idInformeDto;
    private char cveTipoInformeDto;
    private short idProyectoDto;
    private short anioDto;
    private String numeroConvocatoriaDto;
    private String cveInstitucionDto;
    private short numeroCatedraDto;
    private String cveTipoDocumentoDto;
    private String nombreDocumentoDto;
    private Date fechaRegistroDto;

    public InformeEstudianteDocumentoDTO(Long idInformeDto, char cveTipoInformeDto, short idProyectoDto, short anioDto,
                                         String numeroConvocatoriaDto, String cveInstitucionDto, short numeroCatedraDto, String cveTipoDocumentoDto,
                                         String nombreDocumentoDto, Date fechaRegistroDto) {
        super();
        this.idInformeDto = idInformeDto;
        this.cveTipoInformeDto = cveTipoInformeDto;
        this.idProyectoDto = idProyectoDto;
        this.anioDto = anioDto;
        this.numeroConvocatoriaDto = numeroConvocatoriaDto;
        this.cveInstitucionDto = cveInstitucionDto;
        this.numeroCatedraDto = numeroCatedraDto;
        this.cveTipoDocumentoDto = cveTipoDocumentoDto;
        this.nombreDocumentoDto = nombreDocumentoDto;
        this.fechaRegistroDto = fechaRegistroDto;
    }

    public InformeEstudianteDocumentoDTO () {

    }

    public Long getIdInformeDto() {
        return idInformeDto;
    }
    public void setIdInformeDto(Long idInformeDto) {
        this.idInformeDto = idInformeDto;
    }
    public char getCveTipoInformeDto() {
        return cveTipoInformeDto;
    }
    public void setCveTipoInformeDto(char cveTipoInformeDto) {
        this.cveTipoInformeDto = cveTipoInformeDto;
    }
    public short getIdProyectoDto() {
        return idProyectoDto;
    }
    public void setIdProyectoDto(short idProyectoDto) {
        this.idProyectoDto = idProyectoDto;
    }
    public short getAnioDto() {
        return anioDto;
    }
    public void setAnioDto(short anioDto) {
        this.anioDto = anioDto;
    }
    public String getNumeroConvocatoriaDto() {
        return numeroConvocatoriaDto;
    }
    public void setNumeroConvocatoriaDto(String numeroConvocatoriaDto) {
        this.numeroConvocatoriaDto = numeroConvocatoriaDto;
    }
    public String getCveInstitucionDto() {
        return cveInstitucionDto;
    }
    public void setCveInstitucionDto(String cveInstitucionDto) {
        this.cveInstitucionDto = cveInstitucionDto;
    }
    public short getNumeroCatedraDto() {
        return numeroCatedraDto;
    }
    public void setNumeroCatedraDto(short numeroCatedraDto) {
        this.numeroCatedraDto = numeroCatedraDto;
    }
    public String getCveTipoDocumentoDto() {
        return cveTipoDocumentoDto;
    }
    public void setCveTipoDocumentoDto(String cveTipoDocumentoDto) {
        this.cveTipoDocumentoDto = cveTipoDocumentoDto;
    }
    public String getNombreDocumentoDto() {
        return nombreDocumentoDto;
    }
    public void setNombreDocumentoDto(String nombreDocumentoDto) {
        this.nombreDocumentoDto = nombreDocumentoDto;
    }
    public Date getFechaRegistroDto() {
        return fechaRegistroDto;
    }
    public void setFechaRegistroDto(Date fechaRegistroDto) {
        this.fechaRegistroDto = fechaRegistroDto;
    }
}
