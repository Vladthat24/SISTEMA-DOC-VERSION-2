/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vasistenciales;
import Datos.voficio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Desarrollo
 */
public class foficios {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sql = "";

    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "idtrabajor", "nombre_apellidos", "N° Correlativo", "receptor", "cargo_receptor", "Atencion", "Asunto", "Cuerpo", "Membrete", "FechaRegistro"};
        String[] registro = new String[11];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sql = "select idoficios,idtrabajador,(select nombre from persona_trabajador where idptrabajador=idptrabajador) as nombre_trab,"
                + "(select apaterno from persona_trabajador where idptrabajador=idptrabajador)as apaterno_trab,"
                + "(select amaterno from persona_trabajador where idptrabajador=idptrabajador)as amaterno_trab,"
                + "num_correlativo,receptor,cargo_receptor,atencion,asunto,cuerpo,membrete,fecha from oficio where num_correlativo like '%" + buscar + "%' order by idoficios desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registro[0] = rs.getString("idoficios");
                registro[1] = rs.getString("idtrabajador");
                registro[2] = rs.getString("nombre_trab") + " " + rs.getString("apaterno_trab") + " " + rs.getString("amaterno_trab");
                registro[3] = rs.getString("num_correlativo");
                registro[4] = rs.getString("receptor");
                registro[5] = rs.getString("cargo_receptor");
                registro[6] = rs.getString("atencion");
                registro[7] = rs.getString("asunto");
                registro[8] = rs.getString("cuerpo");
                registro[9] = rs.getString("membrete");
                registro[10] = rs.getString("fecha");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error foficios 01");
            return null;
        }

    }

    public boolean insertar(voficio dts) {
        sql = "insert into oficio (idoficios,idtrabajador,num_correlativo,receptor,cargo_receptor,atencion,asunto,cuerpo,membrete,fecha)"
                + "values (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, dts.getIdoficios());
            pst.setInt(2, dts.getIdtrabajador());
            pst.setString(3, dts.getNum_correlativo());
            pst.setString(4, dts.getReceptor());
            pst.setString(5, dts.getCargo_receptor());
            pst.setString(6, dts.getAtencion());
            pst.setString(7, dts.getAsunto());
            pst.setString(8, dts.getCuerpo());
            pst.setString(9, dts.getMembrete());
            pst.setString(10, dts.getFecha());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error foficios 02");
            return false;
        }
    }

    public boolean editar(voficio dts) {
        sql = "update oficio set idoficios=?,idtrabajador=?,num_correlativo=?,receptor=?,cargo_receptor=?,atencion=?,asunto=?,cuerpo=?,membrete=?,fecha=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, dts.getIdoficios());
            pst.setInt(2, dts.getIdtrabajador());
            pst.setString(4, dts.getNum_correlativo());
            pst.setString(5, dts.getReceptor());
            pst.setString(6, dts.getCargo_receptor());
            pst.setString(6, dts.getAtencion());
            pst.setString(7, dts.getAsunto());
            pst.setString(8, dts.getCuerpo());
            pst.setString(9, dts.getMembrete());
            pst.setString(10, dts.getFecha());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error foficios 03");
            return false;
        }
    }

    public boolean eliminar(voficio dts) {
        sql = "delete from oficio where idoficios=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, dts.getIdoficios());

            int n = pst.executeUpdate();

            if (n != 0) {

                return true;

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error foficio 04");
            return false;
        }
    }

}
