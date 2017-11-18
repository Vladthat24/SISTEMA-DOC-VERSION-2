/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vasistenciales;
import Datos.vconstancia_nacimiento;
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
public class fconstancia_nacimiento {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sql = "";

    public Integer totalregistros;

    public DefaultTableModel mostart(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID","idasistenciales", "nombre_asiste", "apellidos_asisten", "colegiatura_asiten", "N° Correlativo", "Nombre", "Apellidos","Tipo_Doc", "N° Doc","Direccion",
        "N° Historia","sexo","peso","talla","Fecha Naci","Hora","N° Doc. Nacido"};
        String[] registro = new String[18];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sql = "select idconstancia_nacimiento,idasistenciales,(select nombre from de asistenciales where idasistenciales=idasistenciales)as nombre_asisten,"
                + "(select apellidos from asistenciales where idasistenciales=idasistenciales)as apellidos_asisten,"
                + "(select colegiatura from asistenciales where idasistenciales=idasistenciales)as colegiatura_asisten,"
                + "correlativo_constancia,nombre,apellidos,tipo_doc,num_doc,direccion,historia_clinica,sexo,peso,talla,fecha_nacimiento,hora_nacimiento,num_doc_nacido"
                + " from constancia_nacimiento where num_doc like '%"+buscar+"%' order by idconstancia_nacimiento desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registro[0] = rs.getString("idconstancia_nacimiento");
                registro[1] = rs.getString("idasistenciales");
                registro[2] = rs.getString("nombre_asisten")+" "+ rs.getString("apellidos_asisten");
                registro[3] = rs.getString("colegiatura");
                registro[4] = rs.getString("correlativo_constancia");
                registro[5] = rs.getString("nombre");
                registro[6] = rs.getString("apellidos");
                registro[7] = rs.getString("tipo_doc");
                registro[8] = rs.getString("num_doc");
                registro[9] = rs.getString("direccion");
                registro[10] = rs.getString("historia_clinica");
                registro[11] = rs.getString("sexo");
                registro[12] = rs.getString("peso");
                registro[13] = rs.getString("talla");
                registro[14] = rs.getString("fecha_nacimiento");
                registro[15] = rs.getString("hora_nacimiento");
                registro[16] = rs.getString("num_doc_nacido");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error fconstancia_nacimiento 01");
            return null;
        }

    }

    public boolean insertar(vconstancia_nacimiento dts) {
        sql = "insert into constancia_nacimiento (idconstancia_nacimiento,idasistenciales,correlativo_constancia,nombre,apellidos,tipo_doc,num_doc,"
                +"direccion,historia_clinica,sexo,peso,talla,fecha_nacimiento,hora_nacimiento,num_doc_nacido)"
                +"values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, dts.getIdconstancia_nacimiento());
            pst.setInt(2, dts.getIdasistenciales());
            pst.setString(3, dts.getCorrelativo_constancia());
            pst.setString(4, dts.getNombre());
            pst.setString(5, dts.getApellidos());
            pst.setString(6, dts.getTipo_doc());
            pst.setString(7, dts.getNum_doc());
            pst.setString(8, dts.getDireccion());
            pst.setString(9, dts.getHistoria_clinica());
            pst.setString(10, dts.getSexo());
            pst.setString(11, dts.getPeso());
            pst.setString(12, dts.getTalla());
            pst.setDate(13, dts.getFecha_nacimiento());
            pst.setString(14, dts.getHora_nacimiento());
            pst.setString(15, dts.getNum_doc_nacido());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error fconstancia_nacimiento 02");
            return false;
        }
    }

    public boolean editar(vconstancia_nacimiento dts) {
        sql = "update constancia_nacimiento set idconstancia_nacimiento=?,idasistenciales=?,correlativo_constancia=?,nombre=?,apellidos=?,"
                + "tipo_doc=?,num_doc=?,direccion=?,historia_clinica=?,sexo=?,peso=?,talla=?,fecha_nacimiento=?,hora_nacimiento=?,num_doc_nacido=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            
            pst.setInt(1, dts.getIdconstancia_nacimiento());
            pst.setInt(2, dts.getIdasistenciales());
            pst.setString(3, dts.getCorrelativo_constancia());
            pst.setString(4, dts.getNombre());
            pst.setString(5, dts.getApellidos());
            pst.setString(6, dts.getTipo_doc());
            pst.setString(7, dts.getNum_doc());
            pst.setString(8, dts.getDireccion());
            pst.setString(9, dts.getHistoria_clinica());
            pst.setString(10, dts.getSexo());
            pst.setString(11, dts.getPeso());
            pst.setString(12, dts.getTalla());
            pst.setDate(13, dts.getFecha_nacimiento());
            pst.setString(14, dts.getHora_nacimiento());
            pst.setString(15, dts.getNum_doc_nacido());
            
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error fconstancia_nacimiento 03");
            return false;
        }
    }

    public boolean eliminar(vconstancia_nacimiento dts) {
        sql = "delete from constancia_nacimiento where idconstancia_nacimiento=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, dts.getIdconstancia_nacimiento());
            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error fconstancia_nacimiento 04");
            return false;
        }
    }

}
