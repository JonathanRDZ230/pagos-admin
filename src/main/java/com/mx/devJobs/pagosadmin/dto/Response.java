package com.mx.devJobs.pagosadmin.dto;

public class Response {

    private int Code;
    private String Descripcion;
    private Object Content;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Object getContent() { return Content; }

    public void setContent(Object content) { this.Content = content; }

    /**
     *  -----   Constructures  -----
     * @param code
     * @param descripcion
     */
    public Response(int code, String descripcion) {
        Code = code;
        Descripcion = descripcion;
    }
    public Response(int code, String descripcion, Object content) {
        Code = code;
        Descripcion = descripcion;
        Content = content;
    }
    public Response() {
    }
}
