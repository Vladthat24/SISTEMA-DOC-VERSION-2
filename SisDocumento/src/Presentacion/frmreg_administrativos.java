/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.vadministrativos;
import Datos.vasistenciales;
import Logica.fadministrativos;
import Logica.fasistenciales;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author root
 */
public class frmreg_administrativos extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmreg_administrativos
     */
    public frmreg_administrativos() {
        initComponents();
        mostrar("");
        inhabilitar();
    }
    public String accion = "guardar";

    void fecha_actual() {
        Calendar today = Calendar.getInstance();
        int fhoy_dia = today.get(Calendar.DAY_OF_MONTH);
        int fhoy_mes = today.get(Calendar.MONTH) + 1;
        int fhoy_year = today.get(Calendar.YEAR);
        lblfecha_registro.setText(fhoy_dia + "/" + fhoy_mes + "/" + fhoy_year);
    }

    void guardar() {
        if (txtnombre.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el nombre");
            txtnombre.requestFocus();
            return;
        }
        if (txtapellidos.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar los apellidos");
            txtapellidos.requestFocus();
            return;
        }
        if (txtcargo_institucion.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el cargo");
            txtcargo_institucion.requestFocus();
            return;
        }
        if (txtmodalidad_contrato.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar la modalidad de contrato");
            txtmodalidad_contrato.requestFocus();
            return;
        }
        if (txtnum_doc.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el numero de documento");
            txtnum_doc.requestFocus();
            return;
        }

        vadministrativos dts = new vadministrativos();
        fadministrativos func = new fadministrativos();

        dts.setNombre(txtnombre.getText());
        dts.setApellidos(txtapellidos.getText());
        dts.setCargo_institucion(txtcargo_institucion.getText());
        dts.setModalidad_contrato(txtmodalidad_contrato.getText());
        dts.setProfesion(txtprofesion.getText());
        int seleccionado = cbotipo_doc.getSelectedIndex();
        dts.setTipo_documento((String) cbotipo_doc.getItemAt(seleccionado));
        dts.setNum_documento(txtnum_doc.getText());
        dts.setCelular(txtcelular.getText());
        dts.setFecha_registro(lblfecha_registro.getText());
        dts.setEmail(txtemail.getText());

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El Registro fue ingresado exitosamente");
                mostrar("");
                inhabilitar();

            }
        } else if (accion.equals("editar")) {
            dts.setIdadministrativos(Integer.parseInt(txtidadministrativos.getText()));
            if (func.editar(dts)) {
                JOptionPane.showConfirmDialog(rootPane, "El Registro fue editado exitosamente");
                mostrar("");
                inhabilitar();

            }
        }

    }

    void inhabilitar() {
        txtidadministrativos.setVisible(false);

        txtnombre.setEnabled(false);
        txtapellidos.setEnabled(false);
        txtcargo_institucion.setEnabled(false);
        txtmodalidad_contrato.setEnabled(false);
        txtprofesion.setEnabled(false);
        cbotipo_doc.setEnabled(false);
        txtnum_doc.setEnabled(false);
        txtcelular.setEnabled(false);
        lblfecha_registro.setEnabled(false);
        txtemail.setEnabled(false);

        btnguardar.setEnabled(false);
        btnbuscar.setEnabled(false);
        btneliminar.setEnabled(false);

        lbltotalregistros.setEnabled(false);

        txtnombre.setText("");
        txtapellidos.setText("");
        txtcargo_institucion.setText("");
        txtmodalidad_contrato.setText("");

        txtnum_doc.setText("");
        txtcelular.setText("");
        txtemail.setText("");
    }

    void habilitar() {
        txtidadministrativos.setVisible(false);

        txtnombre.setEnabled(true);
        txtapellidos.setEnabled(true);
        txtcargo_institucion.setEnabled(true);
        txtmodalidad_contrato.setEnabled(true);
        txtprofesion.setEnabled(true);
        cbotipo_doc.setEnabled(true);
        txtnum_doc.setEnabled(true);
        txtcelular.setEnabled(true);
        lblfecha_registro.setEnabled(true);
        txtemail.setEnabled(true);

        btnguardar.setEnabled(true);
        btnbuscar.setEnabled(true);
        btneliminar.setEnabled(true);

        lbltotalregistros.setEnabled(true);

        txtnombre.setText("");
        txtapellidos.setText("");
        txtcargo_institucion.setText("");
        txtmodalidad_contrato.setText("");

        txtnum_doc.setText("");
        txtcelular.setText("");
        txtemail.setText("");
    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            fadministrativos func = new fadministrativos();
            modelo = func.mostart(buscar);

            tablalistado.setModel(modelo);
            ocultar_columnas();
            lbltotalregistros.setText("Total Registros " + Integer.toString(func.totalregistros));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error frmasistencial01");
        }
    }

    void ocultar_columnas() {
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(5).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(5).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(5).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(8).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(8).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(8).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(10).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(10).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(10).setPreferredWidth(0);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtidadministrativos = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtapellidos = new javax.swing.JTextField();
        txtcargo_institucion = new javax.swing.JTextField();
        txtmodalidad_contrato = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtemail = new javax.swing.JTextField();
        txtcelular = new javax.swing.JTextField();
        lblfecha_registro = new javax.swing.JLabel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cbotipo_doc = new javax.swing.JComboBox<String>();
        txtnum_doc = new javax.swing.JTextField();
        txtprofesion = new javax.swing.JTextField();
        lbltitulo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        lbltotalregistros = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(158, 179, 193));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro Administrativos:"));

        txtnombre.setBackground(new java.awt.Color(158, 179, 193));
        txtnombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        txtapellidos.setBackground(new java.awt.Color(158, 179, 193));
        txtapellidos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Apellidos:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        txtcargo_institucion.setBackground(new java.awt.Color(158, 179, 193));
        txtcargo_institucion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cargos en la Institucion:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        txtmodalidad_contrato.setBackground(new java.awt.Color(158, 179, 193));
        txtmodalidad_contrato.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modalidad de Contrato:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(182, 195, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtemail.setBackground(new java.awt.Color(158, 179, 193));
        txtemail.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Correo:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        txtcelular.setBackground(new java.awt.Color(158, 179, 193));
        txtcelular.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Celular:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        lblfecha_registro.setBackground(new java.awt.Color(158, 179, 193));
        lblfecha_registro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de Registro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(lblfecha_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(btnnuevo)
                                .addGap(64, 64, 64)
                                .addComponent(btnguardar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtcelular)
                    .addComponent(lblfecha_registro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnuevo)
                    .addComponent(btnguardar))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(158, 179, 193));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        cbotipo_doc.setBackground(new java.awt.Color(158, 179, 193));
        cbotipo_doc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DNI", "PASAPORTE", " " }));
        cbotipo_doc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        txtnum_doc.setBackground(new java.awt.Color(158, 179, 193));
        txtnum_doc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Numero de Doc.:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtnum_doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnum_docActionPerformed(evt);
            }
        });

        txtprofesion.setBackground(new java.awt.Color(158, 179, 193));
        txtprofesion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Profesión:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 11))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtprofesion))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(cbotipo_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtnum_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 19, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtnum_doc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbotipo_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtprofesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtidadministrativos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtcargo_institucion, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtmodalidad_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidadministrativos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcargo_institucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmodalidad_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        lbltitulo.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbltitulo.setText(".:: ADMINISTRATIVOS::.");

        jPanel4.setBackground(new java.awt.Color(88, 170, 168));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Administrativos:"));

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
        jScrollPane1.setViewportView(tablalistado);

        lbltotalregistros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/search.png"))); // NOI18N
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/file_delete.png"))); // NOI18N
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnbuscar)
                    .addComponent(btneliminar))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnbuscar)
                        .addGap(18, 18, 18)
                        .addComponent(btneliminar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(lbltitulo)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lbltitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
        btnguardar.setText("Guardar");
        accion = "guardar";
        fecha_actual();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        guardar();

    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtnum_docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnum_docActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnum_docActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        // TODO add your handling code here:
        btnguardar.setText("Editar");
        habilitar();
        btneliminar.setEnabled(true);
        accion = "editar";
        int fila = tablalistado.rowAtPoint(evt.getPoint());

        txtidadministrativos.setText(tablalistado.getValueAt(fila, 0).toString());
        txtnombre.setText(tablalistado.getValueAt(fila, 1).toString());
        txtapellidos.setText(tablalistado.getValueAt(fila, 2).toString());
        txtcargo_institucion.setText(tablalistado.getValueAt(fila, 3).toString());
        txtmodalidad_contrato.setText(tablalistado.getValueAt(fila, 4).toString());
        txtprofesion.setText(tablalistado.getValueAt(fila, 5).toString());
        cbotipo_doc.setSelectedItem(tablalistado.getValueAt(fila, 6).toString());
        txtnum_doc.setText(tablalistado.getValueAt(fila, 7).toString());
        txtcelular.setText(tablalistado.getValueAt(fila, 8).toString());
        lblfecha_registro.setText(tablalistado.getValueAt(fila, 9).toString());
        txtemail.setText(tablalistado.getValueAt(fila, 10).toString());
    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        String dni;
        dni = JOptionPane.showInputDialog("Ingrese el nombre, apellido,cargo,dni");
        mostrar(dni);
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        if (!txtidadministrativos.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminarlo");
            if (confirmacion == 0) {
                fadministrativos func = new fadministrativos();
                vadministrativos dts = new vadministrativos();

                dts.setIdadministrativos(Integer.parseInt(txtidadministrativos.getText()));
                func.eliminar(dts);
                mostrar("");
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmreg_administrativos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmreg_administrativos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmreg_administrativos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmreg_administrativos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmreg_administrativos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JComboBox<String> cbotipo_doc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblfecha_registro;
    private javax.swing.JLabel lbltitulo;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JTextField txtcargo_institucion;
    private javax.swing.JTextField txtcelular;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtidadministrativos;
    private javax.swing.JTextField txtmodalidad_contrato;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnum_doc;
    private javax.swing.JTextField txtprofesion;
    // End of variables declaration//GEN-END:variables
}
