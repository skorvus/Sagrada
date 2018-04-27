/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallas;

import clases.Conex;
import clases.DaoAsignacion;
import java.awt.Font;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sonny
 */
public class frmAsignacion extends javax.swing.JFrame {

    private void skin() {
        Font textTitulo = new Font("Tahoma", Font.BOLD, 24);
        Font textComponente = new Font("Tahoma", Font.BOLD, 14);
        lblCantidad.setFont(textComponente);
        lblPaciente.setFont(textComponente);
        lblProducto.setFont(textComponente);
        lblSalida.setFont(textTitulo);
        txtCantidadCajas.setFont(textComponente);
        cmbPaciente.setFont(textComponente);
        cmbProducto.setFont(textComponente);
        btnSalir.setFont(textComponente);
        btnAnyadir.setFont(textComponente);
        btnAceptar.setFont(textComponente);
    }

    /**
     * Creates new form frmSalida
     */
    public frmAsignacion() {
        initComponents();
        CargacomboPaciente();
        CargacomboProducto();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        lblSalida = new javax.swing.JLabel();
        cmbPaciente = new javax.swing.JComboBox();
        lblPaciente = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        lblProducto = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        cmbProducto = new javax.swing.JComboBox();
        txtCantidadCajas = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSalida = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();
        btnAnyadir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSalida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSalida.setText("SALIDA");
        getContentPane().add(lblSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 22, -1, -1));

        getContentPane().add(cmbPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 50, 180, -1));

        lblPaciente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPaciente.setText("PACIENTE");
        getContentPane().add(lblPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 50, -1, -1));

        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, -1, 40));

        lblProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblProducto.setText("PRODUCTO");
        getContentPane().add(lblProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 76, -1, -1));

        lblCantidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCantidad.setText("CANTIDAD CAJAS");
        getContentPane().add(lblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 107, -1, -1));

        getContentPane().add(cmbProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 76, 180, -1));
        getContentPane().add(txtCantidadCajas, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 107, 90, -1));

        tblSalida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idProducto", "Producto", "Cantifdad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSalida);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 133, 375, 275));

        btnAceptar.setText("ACEPTAR");
        btnAceptar.setEnabled(false);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, -1, 40));

        btnAnyadir.setText("AÑADIR");
        btnAnyadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnyadirActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnyadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, -1, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoVerde.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAnyadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnyadirActionPerformed
        cmbPaciente.setEnabled(false);
        btnAceptar.setEnabled(true);
        int idProd = 0;
        String prod = cmbProducto.getSelectedItem().toString();
        int cant = Integer.parseInt(txtCantidadCajas.getText());
        Connection con = Conex.getInstance().getConnection();
            String sql = "{call sp_prod_lis(?)}";
            try {
                CallableStatement stm = con.prepareCall(sql);
                stm.setString(1, prod);
                ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                idProd = rs.getInt("idProducto");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
        Object[] fila = {idProd, prod, cant};
        DefaultTableModel modelo = (DefaultTableModel) tblSalida.getModel();
        modelo.addRow(fila);
    }//GEN-LAST:event_btnAnyadirActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        DaoAsignacion da = new DaoAsignacion();
        int idPac = 0;
        String pac = cmbPaciente.getSelectedItem().toString();
        Connection con = Conex.getInstance().getConnection();
            String sql = "{call sp_pac_nom(?)}";
            try {
                CallableStatement stm = con.prepareCall(sql);
                stm.setString(1, pac);
                ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                idPac = rs.getInt("idPaciente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
        da.setIdPaciente(idPac);
       if (da.agregar() == true) {
            DefaultTableModel dtm = (DefaultTableModel) tblSalida.getModel();
            int fila = dtm.getRowCount();
            for (int i = 0; i < fila; i++) {
               da.setIdProducto((int)dtm.getValueAt(i, 0));
               da.setCantidad((int)dtm.getValueAt(i, 2));
               da.detalle();
            }
            dtm.setRowCount(0);
            JOptionPane.showMessageDialog(rootPane, "Asignacion terminada");
            cmbPaciente.setEnabled(true);
            btnAceptar.setEnabled(false);
       }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void CargacomboPaciente() {
        Connection con = Conex.getInstance().getConnection();
            String sql = "{call sp_pac_tnom ()}";
            try {
                CallableStatement stm = con.prepareCall(sql);
                ResultSet rs = stm.executeQuery();
            cmbPaciente.removeAllItems();
            while (rs.next()) {
                cmbPaciente.addItem(rs.getString("Nom_Completo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void CargacomboProducto() {
        Connection con = Conex.getInstance().getConnection();
               String sql = "{call sp_prod_sel ()}";
            try {
                CallableStatement stm = con.prepareCall(sql);
                ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                cmbProducto.addItem(rs.getString("nombreProductoPat"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(frmAsignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAsignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAsignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAsignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAsignacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAnyadir;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cmbPaciente;
    private javax.swing.JComboBox cmbProducto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblPaciente;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblSalida;
    private javax.swing.JTable tblSalida;
    private javax.swing.JTextField txtCantidadCajas;
    // End of variables declaration//GEN-END:variables
}
