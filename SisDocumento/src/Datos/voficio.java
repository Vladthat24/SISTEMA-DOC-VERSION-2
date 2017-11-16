/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author Desarrollo
 */
public class voficio {
    
    private int idoficios;
    private int idadministrativos;
    private int idasistenciales;
    private String num_correlativo;
    private String atencion;
    private String asunto;
    private String cuerpo;
    private String membrete;
    private String fecha;

    public voficio() {
    }

    public voficio(int idoficios, int idadministrativos, int idasistenciales, String num_correlativo, String atencion, String asunto, String cuerpo, String membrete, String fecha) {
        this.idoficios = idoficios;
        this.idadministrativos = idadministrativos;
        this.idasistenciales = idasistenciales;
        this.num_correlativo = num_correlativo;
        this.atencion = atencion;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.membrete = membrete;
        this.fecha = fecha;
    }

    public int getIdoficios() {
        return idoficios;
    }

    public void setIdoficios(int idoficios) {
        this.idoficios = idoficios;
    }

    public int getIdadministrativos() {
        return idadministrativos;
    }

    public void setIdadministrativos(int idadministrativos) {
        this.idadministrativos = idadministrativos;
    }

    public int getIdasistenciales() {
        return idasistenciales;
    }

    public void setIdasistenciales(int idasistenciales) {
        this.idasistenciales = idasistenciales;
    }

    public String getNum_correlativo() {
        return num_correlativo;
    }

    public void setNum_correlativo(String num_correlativo) {
        this.num_correlativo = num_correlativo;
    }

    public String getAtencion() {
        return atencion;
    }

    public void setAtencion(String atencion) {
        this.atencion = atencion;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getMembrete() {
        return membrete;
    }

    public void setMembrete(String membrete) {
        this.membrete = membrete;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
    
    
}
