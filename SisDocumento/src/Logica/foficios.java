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

        String[] titulos = {"ID", "idadministrativos", "Receptor Admin", "CargoAdmin", "idasistenciales", "Recptor Asisten", "CargoAsisten", "N° Correlativo", "Atencion", "Asunto", "Cuerpo", "Membrete", "FechaRegistro"};
        String[] registro = new String[13];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sql = "select idoficios,idadministrativos,(select nombre from administrativos where idadministrativos=idadministrativos) as adminnombre,"
                + "(select apellidos from administrativos where idadministrativos=idadministrativos)as adminapellidos,"
                + "(select cargo_institucion from administrativos where idadministrativos=idadministrativos)as admincargo,"
                + "idasistenciales,(select nombre from asistenciales where idasistenciales=idasistenciales)as asistennombre,"
                + "(select apellidos from asistenciales where idasistenciales=idasistenciales)as asistenapellidos,"
                + "(select cargo_institucion from asistenciales where idasistenciales=idasistenciales)as asistencargo,"
                + "num_correlativo,atencion,asunto,cuerpo,membrete,fecha from oficio where num_correlativo like '%" + buscar + "%' order by idoficios desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registro[0] = rs.getString("idoficios");
                registro[1] = rs.getString("idadministrativos");
                registro[2] = rs.getString("adminnombre") + " " + rs.getString("adminapellidos");
                registro[3] = rs.getString("admincargo");
                registro[4] = rs.getString("idasistenciales");
                registro[5] = rs.getString("asistennombre") + " " + rs.getString("asistenapellidos");
                registro[6] = rs.getString("asistencargo");
                registro[7] = rs.getString("num_correlativo");
                registro[8] = rs.getString("atencion");
                registro[9] = rs.getString("asunto");
                registro[10] = rs.getString("cuerpo");
                registro[11] = rs.getString("membrete");
                registro[12] = rs.getString("fecha");

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
        sql = "insert into oficio (idoficios,idadministrativos,idasistenciales,num_correlativo,atencion,asunto,cuerpo,membrete,fecha)"
                + "values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, dts.getIdoficios());
            pst.setInt(2, dts.getIdadministrativos());
            pst.setInt(3, dts.getIdasistenciales());
            pst.setString(4, dts.getNum_correlativo());
            pst.setString(5, dts.getAtencion());
            pst.setString(6, dts.getAsunto());
            pst.setString(7, dts.getCuerpo());
            pst.setString(8, dts.getMembrete());
            pst.setString(9, dts.getFecha());

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
        sql = "update oficio set idoficios=?,idadministrativos=?,idasistenciales=?,num_correlativo=?,atencion=?,asunto=?,cuerpo=?,membrete=?,fecha=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, dts.getIdoficios());
            pst.setInt(2, dts.getIdadministrativos());
            pst.setInt(3, dts.getIdasistenciales());
            pst.setString(4, dts.getNum_correlativo());
            pst.setString(5, dts.getAtencion());
            pst.setString(6, dts.getAsunto());
            pst.setString(7, dts.getCuerpo());
            pst.setString(8, dts.getMembrete());
            pst.setString(9, dts.getFecha());

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
