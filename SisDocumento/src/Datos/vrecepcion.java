/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author root
 */
public class vrecepcion {

    private int idrecepcion;
    private String correlativo;
    private String referencia;
    private String asunto;
    private String fecha;
    private String emisor;
    private String recepcionado;
    private String observaciones;

    public vrecepcion() {
    }

    public vrecepcion(int idrecepcion, String corelativo, String referencia, String asunto, String fecha, String emisor, String recepcionado, String observaciones) {
        this.idrecepcion = idrecepcion;
        this.correlativo = corelativo;
        this.referencia = referencia;
        this.asunto = asunto;
        this.fecha = fecha;
        this.emisor = emisor;
        this.recepcionado = recepcionado;
        this.observaciones = observaciones;
    }

    public int getIdrecepcion() {
        return idrecepcion;
    }

    public void setIdrecepcion(int idrecepcion) {
        this.idrecepcion = idrecepcion;
    }

    public String getCorelativo() {
        return correlativo;
    }

    public void setCorelativo(String corelativo) {
        this.correlativo = corelativo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getRecepcionado() {
        return recepcionado;
    }

    public void setRecepcionado(String recepcionado) {
        this.recepcionado = recepcionado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
    
    
    
    
}
