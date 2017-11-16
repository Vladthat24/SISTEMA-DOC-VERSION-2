/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vrecepcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author root
 */
public class frecepcion {

    //conexcion con la base de datos
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sql = "";

    // para ver cuantos registro tenemos al total
    public Integer totalregistros;

    public DefaultTableModel mostar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Correlativo", "Referencia", "Asunto", "Fecha", "Emisor", "Recepcionado", "Observaciones"};
        String[] registro = new String[8];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sql = "select idrecepcion,correlativo,referencia,asunto,fecha,emisor,recepcionado,observaciones "
                + " from recepcion where correlativo like '%" + buscar + "%' or asunto like '%" + buscar + "%' or emisor like '%"
                + buscar + "%' order by idrecepcion desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registro[0] = rs.getString("idrecepcion");
                registro[1] = rs.getString("correlativo");
                registro[2] = rs.getString("referencia");
                registro[3] = rs.getString("asunto");
                registro[4] = rs.getString("fecha");
                registro[5] = rs.getString("emisor");
                registro[6] = rs.getString("recepcionado");
                registro[7] = rs.getString("observaciones");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error frecepcionado 01");
            return null;
        }
    }

    public boolean insertar(vrecepcion dts) {
        sql = "insert into recepcion (idrecepcion,correlativo,referencia,asunto,fecha,emisor,recepcionado,observaciones)"
                + "values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, dts.getIdrecepcion());
            pst.setString(2, dts.getCorelativo());
            pst.setString(3, dts.getReferencia());
            pst.setString(4, dts.getAsunto());
            pst.setString(5, dts.getFecha());
            pst.setString(6, dts.getEmisor());
            pst.setString(7, dts.getRecepcionado());
            pst.setString(8, dts.getObservaciones());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error frecepcion 02");
            return false;
        }

    }

    public boolean editar(vrecepcion dts) {
        sql = "update recepcion set correlativo=?,referencia=?,asunto=?,fecha=?,emisor=?,recepcionado=?,observaciones=? "
                + "where idrecepcion=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, dts.getCorelativo());
            pst.setString(2, dts.getReferencia());
            pst.setString(3, dts.getAsunto());
            pst.setString(4, dts.getFecha());
            pst.setString(5, dts.getEmisor());
            pst.setString(6, dts.getRecepcionado());
            pst.setString(7, dts.getObservaciones());
            pst.setInt(8, dts.getIdrecepcion());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error frecepcion 03");
            return false;
        }
    }

    public boolean eliminar(vrecepcion dts) {
        sql = "delete from recepcion where idrecepcion=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, dts.getIdrecepcion());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error frecepcion 04");
            return false;
        }
    }

}
