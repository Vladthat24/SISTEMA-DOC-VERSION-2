/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.voficio;
import Logica.foficios;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import reports.imprimir_oficios;
import reports.reporte_oficio;

/**
 *
 * @author Desarrollo
 */
public class frmoficios extends javax.swing.JInternalFrame {

    String fecha_inicial;
    String fecha_final;
    int num_correlativo;

    /**
     * Creates new form frmoficios
     */
    public frmoficios() {
        initComponents();
        mostrar("");
        inhabilitar();
        txtcuerpo.setLineWrap(true);
        txtcuerpo.setWrapStyleWord(true);
    }

    void fecha_actual() {
        Calendar today = Calendar.getInstance();
        int fhoy_dia = today.get(Calendar.DAY_OF_MONTH);
        int fhoy_mes = today.get(Calendar.MONTH) + 1;
        String mes = null;
        if (fhoy_mes == 01) {
            mes = "Enero";
        } else if (fhoy_mes == 02) {
            mes = "Febreso";
        } else if (fhoy_mes == 03) {
            mes = "Marzo";
        } else if (fhoy_mes == 04) {
            mes = "Abril";
        } else if (fhoy_mes == 05) {
            mes = "Mayo";
        } else if (fhoy_mes == 06) {
            mes = "Junio";
        } else if (fhoy_mes == 07) {
            mes = "Julio";
        } else if (fhoy_mes == 10) {
            mes = "Octubre";
        } else if (fhoy_mes == 11) {
            mes = "Noviembre";
        } else if (fhoy_mes == 12) {
            mes = "Diciembre";
        }
        int fhoy_year = today.get(Calendar.YEAR);
        lblfecha_registro.setText(fhoy_dia + " de " + mes + " del " + fhoy_year);
    }

    private String accion = "guardar";

    void guardar() {
        if (txtreceptor.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el receptor del documento");
            txtreceptor.requestFocus();
            return;
        }
        if (txtcargo_receptor.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el cargo del receptor");
            txtcargo_receptor.requestFocus();
            return;
        }
        if (lblnombre_apellido_trab.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar los datos del trabajador que realizo el documento");
            lblnombre_apellido_trab.requestFocus();
            return;
        }

        if (txtnum_correlativo.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el Correlativo");
            txtnum_correlativo.requestFocus();
            return;
        }
        if (txtatencion.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar la Atencion");
            txtatencion.requestFocus();
            return;
        }
        if (txtasunto.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el Asunto");
            txtasunto.requestFocus();
            return;
        }
        if (txtcuerpo.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el Cuerpo del Documento");
            txtcuerpo.requestFocus();
            return;
        }
        if (txtiniciales.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar los iniciales del trabajador que realizo el documento");
            txtiniciales.requestFocus();
        }

        voficio dts = new voficio();
        foficios func = new foficios();

        dts.setIdtrabajador(Integer.parseInt(txtidtrabajador.getText()));
        dts.setNum_correlativo(txtnum_correlativo.getText());
        dts.setReceptor(txtreceptor.getText());
        dts.setCargo_receptor(txtcargo_receptor.getText());
        dts.setAtencion(txtatencion.getText());
        dts.setAsunto(txtasunto.getText());
        dts.setCuerpo(txtcuerpo.getText());
        dts.setIniciales(txtiniciales.getText());
        dts.setFecha(lblfecha_registro.getText());

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El Registro fue ingresado satisfactoriamente");
                mostrar("");
                inhabilitar();
            }
        } else if (accion.equals("editar")) {
            dts.setIdoficios(Integer.parseInt(txtidoficios.getText()));
            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El Registro fue editaro satisfactoriamente");
                mostrar("");
                inhabilitar();
            }
        }

    }

    void ocultar_columnas() {
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(1).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(2).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(2).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(2).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(3).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(3).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(3).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(4).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(4).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(4).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(5).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(5).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(5).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(6).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(6).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(6).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(10).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(10).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(10).setPreferredWidth(0);

    }

    void inhabilitar() {
        txtidoficios.setVisible(false);
        txtidtrabajador.setVisible(false);

        txtreceptor.setEnabled(false);
        txtcargo_receptor.setEnabled(false);
        txtnum_correlativo.setEnabled(false);
        txtatencion.setEnabled(false);
        txtasunto.setEnabled(false);
        txtcuerpo.setEnabled(false);
        lblfecha_registro.setEnabled(false);
        txtiniciales.setEnabled(false);
        lblnombre_apellido_trab.setEnabled(false);

        btnguardar.setEnabled(false);
        btnbuscar.setEnabled(false);
        btneliminar.setEnabled(false);
        btnreportes.setEnabled(false);
        btntrabajador.setEnabled(false);
        btnimprimir.setEnabled(false);
        btnreportes.setEnabled(false);

        txtnum_correlativo.setText("");
        txtreceptor.setText("");
        txtcargo_receptor.setText("");
        lblnombre_apellido_trab.setText("");
        txtatencion.setText("");
        txtasunto.setText("");
        txtcuerpo.setText("");
        txtiniciales.setText("");
        lblfecha_registro.setText("");

    }

    void habilitar() {
        txtidoficios.setVisible(false);
        txtidtrabajador.setVisible(false);

        txtreceptor.setEnabled(true);
        txtcargo_receptor.setEnabled(true);
        txtnum_correlativo.setEnabled(true);
        txtatencion.setEnabled(true);
        txtasunto.setEnabled(true);
        txtcuerpo.setEnabled(true);
        lblfecha_registro.setEnabled(true);
        txtiniciales.setEnabled(true);
        lblnombre_apellido_trab.setEnabled(true);

        btnguardar.setEnabled(true);
        btnbuscar.setEnabled(true);
        btneliminar.setEnabled(true);
        btnreportes.setEnabled(true);
        btntrabajador.setEnabled(true);
        btnimprimir.setEnabled(true);
        btnreportes.setEnabled(true);

        txtnum_correlativo.setText("");
        txtreceptor.setText("M.C.OLIVERA CARHUALLANQUI HUBERT");
        txtcargo_receptor.setText("Medico Jefe de la Administracion de la DRS SJM-VMT");
        lblnombre_apellido_trab.setText("");
        txtatencion.setText("");
        txtasunto.setText("");
        txtcuerpo.setText("");
        txtiniciales.setText("");
        lblfecha_registro.setText("");
    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            foficios func = new foficios();
            voficio dts = new voficio();

            modelo = func.mostrar(buscar);
            tablalistado.setModel(modelo);
            ocultar_columnas();
            lbltotalregistro.setText("Total de Registros " + Integer.toString(func.totalregistros));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e + "error frmoficio 01");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngroup_registro = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtcuerpo = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        txtnum_correlativo = new javax.swing.JTextField();
        txtidtrabajador = new javax.swing.JTextField();
        txtidoficios = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btntrabajador = new javax.swing.JButton();
        lblnombre_apellido_trab = new javax.swing.JLabel();
        lblfecha_registro = new javax.swing.JLabel();
        txtiniciales = new javax.swing.JTextField();
        txtatencion = new javax.swing.JTextField();
        txtasunto = new javax.swing.JTextField();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        txtreceptor = new javax.swing.JTextField();
        txtcargo_receptor = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        btnbuscar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnreportes = new javax.swing.JButton();
        lbltotalregistro = new javax.swing.JLabel();
        btnimprimir = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setTitle("C.M.I. Daniel Alcides Carrion - Sistema de Gestion de Documento");

        jPanel1.setBackground(new java.awt.Color(158, 179, 193));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Oficios:"));

        txtcuerpo.setBackground(new java.awt.Color(158, 178, 193));
        txtcuerpo.setColumns(20);
        txtcuerpo.setRows(5);
        txtcuerpo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cuerpo:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 11))); // NOI18N
        jScrollPane1.setViewportView(txtcuerpo);

        jPanel4.setBackground(new java.awt.Color(158, 179, 193));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtnum_correlativo.setBackground(new java.awt.Color(158, 178, 193));
        txtnum_correlativo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "N° Correlativo:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 11))); // NOI18N

        txtidtrabajador.setText("jTextField2");

        txtidoficios.setText("jTextField1");

        jPanel3.setBackground(new java.awt.Color(158, 179, 193));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Trabajador:"));

        btntrabajador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/asistencial.png"))); // NOI18N
        btntrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntrabajadorActionPerformed(evt);
            }
        });

        lblnombre_apellido_trab.setBackground(new java.awt.Color(158, 178, 193));
        lblnombre_apellido_trab.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 11))); // NOI18N

        lblfecha_registro.setBackground(new java.awt.Color(158, 178, 193));
        lblfecha_registro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de Registro:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 11))); // NOI18N

        txtiniciales.setBackground(new java.awt.Color(158, 178, 193));
        txtiniciales.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Iniciales:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 11))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtiniciales, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblfecha_registro, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblnombre_apellido_trab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btntrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btntrabajador)
                    .addComponent(lblnombre_apellido_trab, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblfecha_registro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtiniciales, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)))
        );

        txtatencion.setBackground(new java.awt.Color(158, 178, 193));
        txtatencion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Atencion:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 11))); // NOI18N

        txtasunto.setBackground(new java.awt.Color(158, 178, 193));
        txtasunto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Asunto:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 11))); // NOI18N

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/document_add.png"))); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/diskette.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        txtreceptor.setBackground(new java.awt.Color(158, 178, 193));
        txtreceptor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombres y Apellidos:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 11))); // NOI18N

        txtcargo_receptor.setBackground(new java.awt.Color(158, 178, 193));
        txtcargo_receptor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cargo:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 11))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtnum_correlativo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnguardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtidtrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidoficios, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtreceptor, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcargo_receptor, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtatencion)
                            .addComponent(txtasunto))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtidoficios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidtrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnum_correlativo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnnuevo)
                                .addComponent(btnguardar)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtreceptor, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcargo_receptor, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtatencion, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtasunto, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(87, 168, 163));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Oficios:"));

        tablalistado.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablalistado);

        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/search.png"))); // NOI18N
        btnbuscar.setBorder(new javax.swing.border.MatteBorder(null));
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/file_delete.png"))); // NOI18N
        btneliminar.setBorder(new javax.swing.border.MatteBorder(null));
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnreportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/reporte_2.png"))); // NOI18N
        btnreportes.setBorder(new javax.swing.border.MatteBorder(null));
        btnreportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreportesActionPerformed(evt);
            }
        });

        lbltotalregistro.setBackground(new java.awt.Color(65, 191, 187));
        lbltotalregistro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro : ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 11))); // NOI18N

        btnimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/impresora.png"))); // NOI18N
        btnimprimir.setBorder(new javax.swing.border.MatteBorder(null));
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnimprimir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnbuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnreportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbltotalregistro, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnbuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btneliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnimprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnreportes)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbltotalregistro, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
        btnguardar.setText("guardar");
        accion = "guardar";
        fecha_actual();

    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        String dni;
        dni = JOptionPane.showInputDialog("Ingresa el Correlativo", "Buscar Oficios");
        mostrar(dni);
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        // TODO add your handling code here:
        btnguardar.setText("editar");
        habilitar();
        btneliminar.setEnabled(true);
        accion = "editar";
        int fila = tablalistado.rowAtPoint(evt.getPoint());

        txtidoficios.setText(tablalistado.getValueAt(fila, 0).toString());
        txtidtrabajador.setText(tablalistado.getValueAt(fila, 1).toString());
        lblnombre_apellido_trab.setText(tablalistado.getValueAt(fila, 2).toString());
        txtnum_correlativo.setText(tablalistado.getValueAt(fila, 3).toString());
        txtreceptor.setText(tablalistado.getValueAt(fila, 4).toString());
        txtcargo_receptor.setText(tablalistado.getValueAt(fila, 5).toString());
        txtatencion.setText(tablalistado.getValueAt(fila, 6).toString());
        txtasunto.setText(tablalistado.getValueAt(fila, 7).toString());
        txtcuerpo.setText(tablalistado.getValueAt(fila, 8).toString());
        txtiniciales.setText(tablalistado.getValueAt(fila, 9).toString());
        lblfecha_registro.setText(tablalistado.getValueAt(fila, 10).toString());
        fecha_inicial = lblfecha_registro.getText();
        fecha_final = lblfecha_registro.getText();
        num_correlativo = Integer.parseInt(txtnum_correlativo.getText());
    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        if (!txtidoficios.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminar el oficio");

            if (confirmacion == 0) {
                foficios func = new foficios();
                voficio dts = new voficio();

                dts.setIdoficios(Integer.parseInt(txtidoficios.getText()));
                func.eliminar(dts);
                mostrar("");
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btntrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntrabajadorActionPerformed
        // TODO add your handling code here:+
        frmvistatrabajador_oficios from = new frmvistatrabajador_oficios();
        from.toFront();
        from.setVisible(true);
    }//GEN-LAST:event_btntrabajadorActionPerformed

    private void btnreportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreportesActionPerformed
        // TODO add your handling code here:
        fecha_inicial = JOptionPane.showInputDialog("Ingresa la fecha inicial dia/mes/año");
        fecha_final = JOptionPane.showInputDialog("Ingresa la fecha final dia/mes/año");
        reporte_oficio g = new reporte_oficio();
        g.reportePacientes(fecha_inicial, fecha_final);
    }//GEN-LAST:event_btnreportesActionPerformed


    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        imprimir_oficios gw = new imprimir_oficios();
        gw.reportePacientes(num_correlativo);
    }//GEN-LAST:event_btnimprimirActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmoficios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneliminar;
    private javax.swing.ButtonGroup btngroup_registro;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnreportes;
    private javax.swing.JButton btntrabajador;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblfecha_registro;
    public static javax.swing.JLabel lblnombre_apellido_trab;
    private javax.swing.JLabel lbltotalregistro;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTextField txtasunto;
    private javax.swing.JTextField txtatencion;
    private javax.swing.JTextField txtcargo_receptor;
    private javax.swing.JTextArea txtcuerpo;
    private javax.swing.JTextField txtidoficios;
    public static javax.swing.JTextField txtidtrabajador;
    private javax.swing.JTextField txtiniciales;
    private javax.swing.JTextField txtnum_correlativo;
    private javax.swing.JTextField txtreceptor;
    // End of variables declaration//GEN-END:variables
}
