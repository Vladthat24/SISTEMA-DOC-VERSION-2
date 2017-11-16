/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.vrecepcion;
import Logica.frecepcion;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author root
 */
public class frmrecepciondoc extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmrecepciondoc
     */
    public frmrecepciondoc() {
        initComponents();
        mostrar("");
        inhabilitar();
    }
    private String accion = "guardar";

    void fecha_actual() {
        Calendar today = Calendar.getInstance();
        int fhoy_dia = today.get(Calendar.DAY_OF_MONTH);
        int fhoy_mes = today.get(Calendar.MONTH) + 1;
        int fhoy_year = today.get(Calendar.YEAR);

        lblfecha_actual.setText(fhoy_dia + "/" + fhoy_mes + "/" + fhoy_year);
    }

    void guardar() {
        if (txtcorrelativo.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el correlativo");
            txtcorrelativo.requestFocus();
            return;
        }
        if (txtreferencia.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar la referencia");
            txtreferencia.requestFocus();
            return;
        }

        if (txtemisor.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el emisor");
            txtemisor.requestFocus();
            return;
        }
        if (txtasunto.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el asunto");
            txtasunto.requestFocus();
            return;
        }
        vrecepcion dts = new vrecepcion();
        frecepcion func = new frecepcion();

        dts.setCorelativo(txtcorrelativo.getText());
        dts.setReferencia(txtreferencia.getText());
        dts.setAsunto(txtasunto.getText());
        dts.setFecha(lblfecha_actual.getText());
        dts.setEmisor(txtemisor.getText());
        int selecc = cborecepcionado.getSelectedIndex();
        dts.setRecepcionado((String) cborecepcionado.getItemAt(selecc));
        dts.setObservaciones(txtobservaciones.getText());
        
        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El Registro de la Recepcion fue guardado exitosamente");
                mostrar("");
                inhabilitar();
                checkobservaciones.setSelected(false);
            }
        } else if (accion.equals("editar")) {
            dts.setIdrecepcion(Integer.parseInt(txtidrecepcion.getText()));
            if (func.editar(dts)) {
                JOptionPane.showConfirmDialog(rootPane, "El Registro de la Recepcion fue editado exitosamente");
                mostrar("");
                inhabilitar();
                checkobservaciones.setSelected(false);
            }
        }
    }

    void ocultar_columnas() {
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(7).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(7).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(7).setPreferredWidth(0);
    }

    void inhabilitar() {
        txtidrecepcion.setVisible(false);

        txtcorrelativo.setEnabled(false);
        lblfecha_actual.setEnabled(false);
        txtreferencia.setEnabled(false);
        txtasunto.setEnabled(false);
        txtemisor.setEnabled(false);
        checkobservaciones.setEnabled(false);
        txtobservaciones.setEnabled(false);
        cborecepcionado.setEnabled(false);
        
   
        btnguardar.setEnabled(false);
        btnbuscar.setEnabled(false);
        btneliminar.setEnabled(false);
        
        txtcorrelativo.setText("");
        txtreferencia.setText("");
        txtasunto.setText("");
        txtemisor.setText("");
        txtobservaciones.setText("");
    }

    void habilitar() {
        txtidrecepcion.setVisible(false);

        txtcorrelativo.setEnabled(true);
        lblfecha_actual.setEnabled(true);
        txtreferencia.setEnabled(true);
        txtasunto.setEnabled(true);
        txtemisor.setEnabled(true);
        checkobservaciones.setEnabled(true);
        txtobservaciones.setEnabled(false);
        cborecepcionado.setEnabled(true);

   
        btnguardar.setEnabled(true);
        btnbuscar.setEnabled(true);
        btneliminar.setEnabled(true);

        txtcorrelativo.setText("");
        txtreferencia.setText("");
        txtasunto.setText("");
        txtemisor.setText("");
        txtobservaciones.setText("");
    }

    private void seleccionarObservacion() {
        if (checkobservaciones.isSelected()) {
            txtobservaciones.setEnabled(true);
        } else if (checkobservaciones.isSelected() == false) {
            txtobservaciones.setEnabled(false);
        }
    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            frecepcion func = new frecepcion();
            modelo = func.mostar(buscar);

            tablalistado.setModel(modelo);
            ocultar_columnas();
            lbltotalregistros.setText("Total Registros " + Integer.toString(func.totalregistros));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error frmrecepcion 01");
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

        jPanel1 = new javax.swing.JPanel();
        txtidrecepcion = new javax.swing.JTextField();
        txtcorrelativo = new javax.swing.JTextField();
        txtreferencia = new javax.swing.JTextField();
        txtasunto = new javax.swing.JTextField();
        lblfecha_actual = new javax.swing.JLabel();
        cborecepcionado = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtobservaciones = new javax.swing.JTextArea();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        checkobservaciones = new javax.swing.JCheckBox();
        txtemisor = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        btnbuscar = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        btneliminar = new javax.swing.JButton();
        lbltitulo = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(158, 179, 193));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Recepcion:"));

        txtcorrelativo.setBackground(new java.awt.Color(158, 179, 193));
        txtcorrelativo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Correlativo:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        txtreferencia.setBackground(new java.awt.Color(158, 179, 193));
        txtreferencia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Referencia:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        txtasunto.setBackground(new java.awt.Color(158, 179, 193));
        txtasunto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Asunto:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        lblfecha_actual.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha Actual:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        cborecepcionado.setBackground(new java.awt.Color(158, 179, 193));
        cborecepcionado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cborecepcionado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Recibido", "Pendiente", " " }));
        cborecepcionado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        txtobservaciones.setBackground(new java.awt.Color(158, 179, 193));
        txtobservaciones.setColumns(20);
        txtobservaciones.setRows(5);
        txtobservaciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        jScrollPane1.setViewportView(txtobservaciones);

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

        checkobservaciones.setText("Con Observaciones");
        checkobservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkobservacionesActionPerformed(evt);
            }
        });

        txtemisor.setBackground(new java.awt.Color(158, 179, 193));
        txtemisor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Emisor:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkobservaciones)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtcorrelativo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblfecha_actual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidrecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cborecepcionado, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnnuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtasunto)
                    .addComponent(txtreferencia, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtemisor))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtidrecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblfecha_actual, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcorrelativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtemisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtasunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkobservaciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cborecepcionado, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnguardar)
                        .addComponent(btnnuevo)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(93, 173, 168));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Recepcion:"));

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
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        lbltotalregistros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registros:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/file_delete.png"))); // NOI18N
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnbuscar)
                    .addComponent(btneliminar)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneliminar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lbltitulo.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        lbltitulo.setText(".:: Recepcion ::.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbltitulo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbltitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        habilitar();
        btnguardar.setText("Guardar");
        accion = "guardar";
        checkobservaciones.setSelected(false);
        seleccionarObservacion();
        fecha_actual();

    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        guardar();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        // TODO add your handling code here:
        btnguardar.setText("Editar");
        habilitar();
        btneliminar.setEnabled(true);

        int fila = tablalistado.rowAtPoint(evt.getPoint());

        txtidrecepcion.setText(tablalistado.getValueAt(fila, 0).toString());
        txtcorrelativo.setText(tablalistado.getValueAt(fila, 1).toString());
        txtreferencia.setText(tablalistado.getValueAt(fila, 2).toString());
        txtasunto.setText(tablalistado.getValueAt(fila, 3).toString());
        lblfecha_actual.setText(tablalistado.getValueAt(fila, 4).toString());
        txtemisor.setText(tablalistado.getValueAt(fila, 5).toString());
        cborecepcionado.setSelectedItem(tablalistado.getValueAt(fila, 6).toString());
        txtobservaciones.setText(tablalistado.getValueAt(fila, 7).toString());

    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        if (!txtidrecepcion.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminar la recepcion");
            if (confirmacion == 0) {
                frecepcion func = new frecepcion();
                vrecepcion dts = new vrecepcion();

                dts.setIdrecepcion(Integer.parseInt(txtidrecepcion.getText()));
                func.eliminar(dts);
                mostrar("");
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
       String dni;
       dni=JOptionPane.showInputDialog("Ingrese el correlativo,asunto o emisor ");
        mostrar(dni);
       
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void checkobservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkobservacionesActionPerformed
        // TODO add your handling code here:
        seleccionarObservacion();
    }//GEN-LAST:event_checkobservacionesActionPerformed

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
            java.util.logging.Logger.getLogger(frmrecepciondoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmrecepciondoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmrecepciondoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmrecepciondoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmrecepciondoc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JComboBox<String> cborecepcionado;
    private javax.swing.JCheckBox checkobservaciones;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblfecha_actual;
    private javax.swing.JLabel lbltitulo;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTextField txtasunto;
    private javax.swing.JTextField txtcorrelativo;
    private javax.swing.JTextField txtemisor;
    private javax.swing.JTextField txtidrecepcion;
    private javax.swing.JTextArea txtobservaciones;
    private javax.swing.JTextField txtreferencia;
    // End of variables declaration//GEN-END:variables
}
