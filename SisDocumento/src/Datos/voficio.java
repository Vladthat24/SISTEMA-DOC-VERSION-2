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
    private int idtrabajador;
    private String num_correlativo;
    private String receptor;
    private String cargo_receptor;
    private String atencion;
    private String asunto;
    private String cuerpo;
    private String iniciales;
    private String fecha;

    public voficio() {
    }

    public voficio(int idoficios, int idtrabajador, String num_correlativo, String receptor, String cargo_receptor, String atencion, String asunto, String cuerpo, String iniciales, String fecha) {
        this.idoficios = idoficios;
        this.idtrabajador = idtrabajador;
        this.num_correlativo = num_correlativo;
        this.receptor = receptor;
        this.cargo_receptor = cargo_receptor;
        this.atencion = atencion;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.iniciales = iniciales;
        this.fecha = fecha;
    }

    public int getIdoficios() {
        return idoficios;
    }

    public void setIdoficios(int idoficios) {
        this.idoficios = idoficios;
    }

    public int getIdtrabajador() {
        return idtrabajador;
    }

    public void setIdtrabajador(int idtrabajador) {
        this.idtrabajador = idtrabajador;
    }

    public String getNum_correlativo() {
        return num_correlativo;
    }

    public void setNum_correlativo(String num_correlativo) {
        this.num_correlativo = num_correlativo;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public String getCargo_receptor() {
        return cargo_receptor;
    }

    public void setCargo_receptor(String cargo_receptor) {
        this.cargo_receptor = cargo_receptor;
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

    public String getIniciales() {
        return iniciales;
    }

    public void setIniciales(String iniciales) {
        this.iniciales = iniciales;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

   
    
}
