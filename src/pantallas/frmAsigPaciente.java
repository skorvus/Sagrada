/*
 * Nombre del autor: Iván Ruiz Ramírez
                     Jose Luis Terraza Cortés
 * Fecha de creación: 2017/01/31
 * Nombre del proyecto: casaDescanso
 * Nombre del módulo: centralDeEnfermería
 * Breve descripción del contenido: pantalla para asignar pacientes a enfermeras con horarios definidos.
 */
package pantallas;

import clases.Conex;
import clases.DAOAsigPac;
import clases.ComboItem;
import static pantallas.frmMenuCentEnf.menuP;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;

/**
 *
 * @author IvanR
 */
public class frmAsigPaciente extends javax.swing.JFrame {

    /**
     * Creates new form AsignarPaciente
     */
    public frmAsigPaciente() {
        initComponents();
        cargaComboPaciente();
        cargaComboEnf();
        btnListar.doClick();
        skin1();
    }

    DAOAsigPac daoAsig = new DAOAsigPac();
    Connection con = Conex.getInstance().getConnection();
    Font textoTitulos = new Font("Tahoma", Font.BOLD, 24);
    Font textoComponentes = new Font("Tahoma", Font.BOLD, 14);

    public void skin1() {
        Dimension dmnBtn = new Dimension(130, 40); //130, 50
        btnAgregar.setSize(dmnBtn);
        btnModificar.setSize(dmnBtn);
        btnEliminar.setSize(dmnBtn);
        btnListar.setSize(dmnBtn);
        btnRegresar.setSize(dmnBtn);
        btnTiempoTot.setSize(dmnBtn);
        lblEnfermera.setText(lblEnfermera.getText().toUpperCase());
        lblCmbFiltEnf.setText(lblCmbFiltEnf.getText().toUpperCase());
        lblPaciente.setText(lblPaciente.getText().toUpperCase());
        lblCmbFiltPac.setText(lblCmbFiltPac.getText().toUpperCase());
        lblArea.setText(lblArea.getText().toUpperCase());
        lblHorario.setText(lblHorario.getText().toUpperCase());
        lblHoraInicio.setText(lblHoraInicio.getText().toUpperCase());
        lblHoraFin.setText(lblHoraFin.getText().toUpperCase());
        lblTiempoTot.setText(lblTiempoTot.getText().toUpperCase());
        lblHoras.setText(lblHoras.getText().toUpperCase());
        lblMinutos.setText(lblMinutos.getText().toUpperCase());
        lblFiltNombreDeEnf.setText(lblFiltNombreDeEnf.getText().toUpperCase());
        lblAsigPac.setText(lblAsigPac.getText().toUpperCase());
        lblBuscModElim.setText(lblBuscModElim.getText().toUpperCase());
        lblIdAsigPac.setText(lblIdAsigPac.getText().toUpperCase());
        btnAgregar.setText(btnAgregar.getText().toUpperCase());
        btnModificar.setText(btnModificar.getText().toUpperCase());
        btnEliminar.setText(btnEliminar.getText().toUpperCase());
        btnListar.setText(btnListar.getText().toUpperCase());
        btnTiempoTot.setText(btnTiempoTot.getText().toUpperCase());
        btnRegresar.setText(btnRegresar.getText().toUpperCase());
    }

    private void cargaComboPaciente() {
        cmbPaciente.removeAllItems();
        if (daoAsig.getNombrePac() == null) {
            daoAsig.setNombrePac("%");
        }
        con = Conex.getInstance().getConnection();
        String cadSql = "{call sp_cmbNomPac(?)};";
        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setString(1, daoAsig.getNombrePac());
            ComboItem miItem;
            ResultSet res = cstm.executeQuery();
            while (res.next()) {
                miItem = new ComboItem(res.getInt("idPaciente"), res.getString("Nombre") + " " + res.getString("apPat") + " " + res.getString("apMat"));
                cmbPaciente.addItem(String.valueOf(miItem));
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmAsigPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargaComboEnf() {
        cmbEnfermera.removeAllItems();
        if (daoAsig.getNombreEnf() == null) {
            daoAsig.setNombreEnf("%");
        }
        con = Conex.getInstance().getConnection();
        String cadSql = "{call sp_cmbNomPersonal(?)};";
        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setString(1, daoAsig.getNombreEnf());
            ComboItem miItem;
            ResultSet res = cstm.executeQuery();
            while (res.next()) {
                miItem = new ComboItem(res.getInt("idEnfermera"), res.getString("nombreEnfermera") + " " + res.getString("apellidoPatEnf") + " " + res.getString("apellidoMatEnf"));
                cmbEnfermera.addItem(String.valueOf(miItem));
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmAsigPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbEnfermera = new javax.swing.JComboBox<>();
        txtHoraInicio = new javax.swing.JTextField();
        lblSep = new javax.swing.JLabel();
        txtMinInicio = new javax.swing.JTextField();
        txtHoraFin = new javax.swing.JTextField();
        lblSep2 = new javax.swing.JLabel();
        txtMinFin = new javax.swing.JTextField();
        lblHoras = new javax.swing.JLabel();
        lblMinutos = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblIdAsigPac = new javax.swing.JLabel();
        txtIdAsigPac = new javax.swing.JTextField();
        lblBuscModElim = new javax.swing.JLabel();
        btnListar = new javax.swing.JButton();
        lblFiltNombreDeEnf = new javax.swing.JLabel();
        txtFiltNombreDeEnf = new javax.swing.JTextField();
        txtResHora = new javax.swing.JTextField();
        txtResMin = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAsigPac = new javax.swing.JTable();
        btnTiempoTot = new javax.swing.JButton();
        cmbPaciente = new javax.swing.JComboBox<>();
        txtCmbFiltEnf = new javax.swing.JTextField();
        txtCmbFiltPac = new javax.swing.JTextField();
        lblCmbFiltEnf = new javax.swing.JLabel();
        lblCmbFiltPac = new javax.swing.JLabel();
        lblTiempoTot = new javax.swing.JLabel();
        lblAsigPac = new javax.swing.JLabel();
        lblPaciente = new javax.swing.JLabel();
        lblEnfermera = new javax.swing.JLabel();
        lblHorario = new javax.swing.JLabel();
        lblHoraInicio = new javax.swing.JLabel();
        lblHoraFin = new javax.swing.JLabel();
        lblArea = new javax.swing.JLabel();
        cmbArea = new javax.swing.JComboBox<>();
        lblFondoVerde = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbEnfermera.setFont(textoComponentes);
        cmbEnfermera.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEnfermeraItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbEnfermera, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 52, 210, -1));

        txtHoraInicio.setFont(textoComponentes);
        txtHoraInicio.setText("00");
        txtHoraInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtHoraInicioMouseClicked(evt);
            }
        });
        txtHoraInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraInicioActionPerformed(evt);
            }
        });
        txtHoraInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHoraInicioKeyReleased(evt);
            }
        });
        getContentPane().add(txtHoraInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 320, 40, -1));

        lblSep.setText(":");
        getContentPane().add(lblSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 323, 6, -1));

        txtMinInicio.setFont(textoComponentes);
        txtMinInicio.setText("00");
        txtMinInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMinInicioActionPerformed(evt);
            }
        });
        txtMinInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMinInicioKeyReleased(evt);
            }
        });
        getContentPane().add(txtMinInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 40, -1));

        txtHoraFin.setFont(textoComponentes);
        txtHoraFin.setText("00");
        txtHoraFin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHoraFinKeyReleased(evt);
            }
        });
        getContentPane().add(txtHoraFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 355, 40, -1));

        lblSep2.setText(":");
        getContentPane().add(lblSep2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 358, 6, -1));

        txtMinFin.setFont(textoComponentes);
        txtMinFin.setText("00");
        txtMinFin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMinFinKeyReleased(evt);
            }
        });
        getContentPane().add(txtMinFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 355, 40, -1));

        lblHoras.setFont(textoComponentes);
        lblHoras.setText("horas");
        getContentPane().add(lblHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 425, -1, -1));

        lblMinutos.setFont(textoComponentes);
        lblMinutos.setText("minutos");
        getContentPane().add(lblMinutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 459, -1, -1));

        btnRegresar.setFont(textoComponentes);
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 590, 136, 40));

        btnAgregar.setFont(textoComponentes);
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 586, 148, 40));

        btnModificar.setFont(textoComponentes);
        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 586, 152, 40));

        btnEliminar.setFont(textoComponentes);
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 588, 154, 40));

        lblIdAsigPac.setFont(textoComponentes);
        lblIdAsigPac.setText("ID AsignarPaciente:");
        getContentPane().add(lblIdAsigPac, new org.netbeans.lib.awtextra.AbsoluteConstraints(1027, 438, 185, -1));

        txtIdAsigPac.setFont(textoComponentes);
        txtIdAsigPac.setEnabled(false);
        getContentPane().add(txtIdAsigPac, new org.netbeans.lib.awtextra.AbsoluteConstraints(1085, 458, 73, -1));

        lblBuscModElim.setFont(textoComponentes);
        lblBuscModElim.setText("Buscar/Modificar/Eliminar");
        getContentPane().add(lblBuscModElim, new org.netbeans.lib.awtextra.AbsoluteConstraints(1007, 496, 246, -1));

        btnListar.setFont(textoComponentes);
        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });
        getContentPane().add(btnListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(572, 587, 137, 40));

        lblFiltNombreDeEnf.setFont(textoComponentes);
        lblFiltNombreDeEnf.setText("Filtro (Nombre de Enfermera):");
        getContentPane().add(lblFiltNombreDeEnf, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 459, 259, -1));

        txtFiltNombreDeEnf.setFont(textoComponentes);
        txtFiltNombreDeEnf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltNombreDeEnfActionPerformed(evt);
            }
        });
        txtFiltNombreDeEnf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltNombreDeEnfKeyReleased(evt);
            }
        });
        getContentPane().add(txtFiltNombreDeEnf, new org.netbeans.lib.awtextra.AbsoluteConstraints(725, 456, 116, -1));

        txtResHora.setFont(textoComponentes);
        txtResHora.setEnabled(false);
        getContentPane().add(txtResHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 422, 49, -1));

        txtResMin.setFont(textoComponentes);
        txtResMin.setEnabled(false);
        getContentPane().add(txtResMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 453, 71, -1));

        tblAsigPac.setModel(new javax.swing.table.DefaultTableModel(
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
        tblAsigPac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAsigPacMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblAsigPac);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 928, 375));

        btnTiempoTot.setFont(textoComponentes);
        btnTiempoTot.setText("Tiempo Total");
        btnTiempoTot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTiempoTotActionPerformed(evt);
            }
        });
        getContentPane().add(btnTiempoTot, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 487, 150, 40));

        cmbPaciente.setFont(textoComponentes);
        cmbPaciente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPacienteItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 216, -1));

        txtCmbFiltEnf.setFont(textoComponentes);
        txtCmbFiltEnf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCmbFiltEnfActionPerformed(evt);
            }
        });
        txtCmbFiltEnf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCmbFiltEnfKeyReleased(evt);
            }
        });
        getContentPane().add(txtCmbFiltEnf, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 85, 85, -1));

        txtCmbFiltPac.setFont(textoComponentes);
        txtCmbFiltPac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCmbFiltPacActionPerformed(evt);
            }
        });
        txtCmbFiltPac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCmbFiltPacKeyReleased(evt);
            }
        });
        getContentPane().add(txtCmbFiltPac, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 189, 85, -1));

        lblCmbFiltEnf.setFont(textoComponentes);
        lblCmbFiltEnf.setText("Filtro Enf:");
        getContentPane().add(lblCmbFiltEnf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 88, 91, -1));

        lblCmbFiltPac.setFont(textoComponentes);
        lblCmbFiltPac.setText("Filtro Paciente:");
        getContentPane().add(lblCmbFiltPac, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 192, 145, -1));

        lblTiempoTot.setFont(textoComponentes);
        lblTiempoTot.setText("Tiempo Total:");
        getContentPane().add(lblTiempoTot, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 402, 167, -1));

        lblAsigPac.setFont(textoTitulos);
        lblAsigPac.setText("Asignar Paciente");
        getContentPane().add(lblAsigPac, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 461, -1));

        lblPaciente.setFont(textoComponentes);
        lblPaciente.setText("Paciente:");
        getContentPane().add(lblPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 143, 116, -1));

        lblEnfermera.setFont(textoComponentes);
        lblEnfermera.setText("Enfermera:");
        getContentPane().add(lblEnfermera, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 55, 120, -1));

        lblHorario.setFont(textoComponentes);
        lblHorario.setText("Horario : 00:00 a 23:59");
        getContentPane().add(lblHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 288, 300, -1));

        lblHoraInicio.setFont(textoComponentes);
        lblHoraInicio.setText("Hora Inicio:");
        getContentPane().add(lblHoraInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 323, 120, -1));

        lblHoraFin.setFont(textoComponentes);
        lblHoraFin.setText("Hora Final:");
        getContentPane().add(lblHoraFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 361, 120, -1));

        lblArea.setFont(textoComponentes);
        lblArea.setText("Área:");
        getContentPane().add(lblArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 241, -1, -1));

        cmbArea.setFont(textoComponentes);
        cmbArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SAN JOSÉ", "CESARITA", "NAZARET", "CORAZÓN DE JESÚS", "SAGRADA FAMILIA", "VILLA SECA" }));
        getContentPane().add(cmbArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 180, -1));

        lblFondoVerde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoVerde.jpg"))); // NOI18N
        getContentPane().add(lblFondoVerde, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        dispose();
       // menuP.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed


    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        boolean noRealizar = false;
        if (txtHoraInicio.getText().equals("") || txtMinInicio.getText().equals("") || txtHoraFin.getText().equals("") || txtMinFin.getText().equals("") || txtResHora.getText().equals("") || txtResMin.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campos vacios o incorrectos.");
        } else {
            try {
                daoAsig.setHoraInicio(Integer.parseInt(txtHoraInicio.getText()));
                daoAsig.setMinInicio(Integer.parseInt(txtMinInicio.getText()));
                daoAsig.setHoraFin(Integer.parseInt(txtHoraFin.getText()));
                daoAsig.setMinFin(Integer.parseInt(txtMinFin.getText()));
                daoAsig.setResHora(Integer.parseInt(txtResHora.getText()));
                daoAsig.setResMin(Integer.parseInt(txtResMin.getText()));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Los campos de horario deben ser números enteros.");
                noRealizar = true;
            }
            if (cmbPaciente.getSelectedItem() == null || cmbEnfermera.getSelectedItem() == null) {
                noRealizar = true;
                JOptionPane.showMessageDialog(null, "Combobox vacio.");

            } else {
                daoAsig.setNombrePac(cmbPaciente.getSelectedItem().toString());
                daoAsig.setNombreEnf(cmbEnfermera.getSelectedItem().toString());
                daoAsig.detectarIdPac();
                daoAsig.detectarIdEnf();
            }
            daoAsig.setArea(cmbArea.getSelectedItem().toString().toUpperCase());
            if (noRealizar == false) {
                btnTiempoTot.doClick();
                if (txtResHora.getText().equals("0") && txtResMin.getText().equals("0")) {
                    JOptionPane.showMessageDialog(null, "El resultado del horario no puede ser '00:00' ");
                } else if (daoAsig.agregar()) {
                    JOptionPane.showMessageDialog(null, "Nueva asignacion agregada.");
                    txtIdAsigPac.setText("");
                    txtHoraInicio.setText("");
                    txtMinInicio.setText("");
                    txtHoraFin.setText("");
                    txtMinFin.setText("");
                    txtResHora.setText("");
                    txtResMin.setText("");
                    btnListar.doClick();
                } else {
                    JOptionPane.showMessageDialog(null, daoAsig.getMensaje());
                }
            }

        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        daoAsig.getTmodel().setColumnCount(0);
        daoAsig.getTmodel().setRowCount(0);
        daoAsig.listar();
        tblAsigPac.setModel(daoAsig.getTmodel());
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        daoAsig.setIdAsigPac(Integer.parseInt(txtIdAsigPac.getText()));
        daoAsig.eliminar();
        JOptionPane.showMessageDialog(null,"Asignación eliminada.");
        txtIdAsigPac.setText("");
        txtHoraInicio.setText("");
        txtMinInicio.setText("");
        txtHoraFin.setText("");
        txtMinFin.setText("");
        txtResHora.setText("");
        txtResMin.setText("");
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnAgregar.setEnabled(true);
        btnListar.doClick();

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        boolean noRealizar = false;
        if (txtHoraInicio.getText().equals("") || txtMinInicio.getText().equals("") || txtHoraFin.getText().equals("") || txtMinFin.getText().equals("") || txtResHora.getText().equals("") || txtResMin.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campos vacios o incorrectos.");
        } else {
            try {
                daoAsig.setIdAsigPac(Integer.parseInt(txtIdAsigPac.getText()));
                daoAsig.setHoraInicio(Integer.parseInt(txtHoraInicio.getText()));
                daoAsig.setMinInicio(Integer.parseInt(txtMinInicio.getText()));
                daoAsig.setHoraFin(Integer.parseInt(txtHoraFin.getText()));
                daoAsig.setMinFin(Integer.parseInt(txtMinFin.getText()));
                daoAsig.setResHora(Integer.parseInt(txtResHora.getText()));
                daoAsig.setResMin(Integer.parseInt(txtResMin.getText()));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Los campos de horario deben ser números enteros.");
                noRealizar = true;
            }
            if (cmbPaciente.getSelectedItem() == null || cmbEnfermera.getSelectedItem() == null) {
                noRealizar = true;
                JOptionPane.showMessageDialog(null, "Combobox vacio.");

            } else {
                daoAsig.setNombrePac(cmbPaciente.getSelectedItem().toString());
                daoAsig.setNombreEnf(cmbEnfermera.getSelectedItem().toString());
                daoAsig.detectarIdPac();
                daoAsig.detectarIdEnf();
            }
            daoAsig.setArea(cmbArea.getSelectedItem().toString().toUpperCase());
            if (noRealizar == false) {
                btnTiempoTot.doClick();
                if (txtResHora.getText().equals("0") && txtResMin.getText().equals("0")) {
                    JOptionPane.showMessageDialog(null, "El resultado del horario no puede ser '00:00' ");
                } else if (daoAsig.modificar()) {
                    JOptionPane.showMessageDialog(null, "Asignación modificada.");
                    txtIdAsigPac.setText("");
                    txtHoraInicio.setText("");
                    txtMinInicio.setText("");
                    txtHoraFin.setText("");
                    txtMinFin.setText("");
                    txtResHora.setText("");
                    txtResMin.setText("");
                    btnEliminar.setEnabled(false);
                    btnModificar.setEnabled(false);
                    btnAgregar.setEnabled(true);
                    btnListar.doClick();
                } else {
                    JOptionPane.showMessageDialog(null, daoAsig.getMensaje());
                }
            }

        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtFiltNombreDeEnfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltNombreDeEnfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltNombreDeEnfActionPerformed

    private void txtFiltNombreDeEnfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltNombreDeEnfKeyReleased
        daoAsig.setNombreEnf(txtFiltNombreDeEnf.getText() + "%");
        daoAsig.getTmodel().setColumnCount(0);
        daoAsig.getTmodel().setRowCount(0);
        daoAsig.filtrarAsig();
        tblAsigPac.setModel(daoAsig.getTmodel());

    }//GEN-LAST:event_txtFiltNombreDeEnfKeyReleased

    private void cmbEnfermeraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEnfermeraItemStateChanged

    }//GEN-LAST:event_cmbEnfermeraItemStateChanged

    private void txtMinInicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMinInicioKeyReleased

    }//GEN-LAST:event_txtMinInicioKeyReleased

    private void txtHoraFinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraFinKeyReleased

    }//GEN-LAST:event_txtHoraFinKeyReleased

    private void txtMinFinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMinFinKeyReleased

    }//GEN-LAST:event_txtMinFinKeyReleased

    private void tblAsigPacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAsigPacMouseClicked
        if (!SwingUtilities.isRightMouseButton(evt)) {
            int index = tblAsigPac.getSelectedRow();
            TableModel model = tblAsigPac.getModel();
            txtCmbFiltEnf.setText("");
            txtCmbFiltPac.setText("");
            daoAsig.setNombreEnf("%");
            daoAsig.setNombrePac("%");
            String idRegistroSalud = model.getValueAt(index, 0).toString();
            String enfermera = model.getValueAt(index, 1).toString() + " " + model.getValueAt(index, 2).toString() + " " + model.getValueAt(index, 3).toString();
            String paciente = model.getValueAt(index, 4).toString() + " " + model.getValueAt(index, 5).toString() + " " + model.getValueAt(index, 6).toString();
            String area = model.getValueAt(index, 7).toString();
            String horaInicio = model.getValueAt(index, 8).toString();
            String minInicio = model.getValueAt(index, 9).toString();
            String horaFin = model.getValueAt(index, 10).toString();
            String minFin = model.getValueAt(index, 11).toString();
            String resHora = model.getValueAt(index, 12).toString();
            String resMin = model.getValueAt(index, 13).toString();
            txtIdAsigPac.setText(idRegistroSalud);
            cmbPaciente.setSelectedItem(paciente);
            cmbEnfermera.setSelectedItem(enfermera);
            cmbArea.setSelectedItem(area);
            txtHoraInicio.setText(horaInicio);
            txtMinInicio.setText(minInicio);
            txtHoraFin.setText(horaFin);
            txtMinFin.setText(minFin);
            txtResHora.setText(resHora);
            txtResMin.setText(resMin);
            btnModificar.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnAgregar.setEnabled(false);
        }
    }//GEN-LAST:event_tblAsigPacMouseClicked

    private void txtHoraInicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraInicioKeyReleased

    }//GEN-LAST:event_txtHoraInicioKeyReleased

    private void txtHoraInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraInicioActionPerformed

    }//GEN-LAST:event_txtHoraInicioActionPerformed

    private void txtHoraInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHoraInicioMouseClicked

    }//GEN-LAST:event_txtHoraInicioMouseClicked

    private void btnTiempoTotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTiempoTotActionPerformed
        int resMin = 0;
        int resHora = 0;
        boolean noRealizar = false;

        try {
            if (Integer.parseInt(txtHoraInicio.getText()) > Integer.parseInt(txtHoraFin.getText())) {
                resMin = Integer.parseInt(txtMinInicio.getText()) - Integer.parseInt(txtMinFin.getText());
                resHora = Integer.parseInt(txtHoraInicio.getText()) - Integer.parseInt(txtHoraFin.getText());
                resHora = 24 - resHora;
                if (Integer.parseInt(txtMinInicio.getText()) > Integer.parseInt(txtMinFin.getText())) {
                    resMin = 60 - resMin;
                    resHora = resHora - 1;
                }
                if (resMin < 0) {
                    resMin = -(resMin);
                }
            } else {
                resMin = Integer.parseInt(txtMinFin.getText()) - Integer.parseInt(txtMinInicio.getText());
                resHora = Integer.parseInt(txtHoraFin.getText()) - Integer.parseInt(txtHoraInicio.getText());
                if (resMin < 0) {
                    resHora = resHora - 1;
                    resMin = resMin + 60;
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Los campos deben ser números enteros.");
            noRealizar = true;
        }

        if (noRealizar == false) {
            if (Integer.parseInt(txtHoraInicio.getText()) > 23 || Integer.parseInt(txtHoraFin.getText()) > 23 || Integer.parseInt(txtMinInicio.getText()) > 59 || Integer.parseInt(txtMinFin.getText()) > 59) {
                JOptionPane.showMessageDialog(null, "Las horas no pueden sobrepasar la hora 23 y los minutos 59.");
            } else if (noRealizar == false) {
                if (txtHoraInicio.getText().equals(txtHoraFin.getText()) && resHora < 0) {
                    resHora = resHora + 1;
                    if (Integer.parseInt(txtMinInicio.getText()) > Integer.parseInt(txtMinFin.getText())) {
                        JOptionPane.showMessageDialog(null, "El horario inicial debe ser menor al final.");
                        noRealizar = true;
                    }
                }
                if (noRealizar == false) {
                    txtResMin.setText(String.valueOf(resMin));
                    txtResHora.setText(String.valueOf(resHora));
                }
            }

        }
        noRealizar = false;
    }//GEN-LAST:event_btnTiempoTotActionPerformed

    private void txtMinInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinInicioActionPerformed

    private void cmbPacienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPacienteItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPacienteItemStateChanged

    private void txtCmbFiltEnfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCmbFiltEnfKeyReleased
        daoAsig.setNombreEnf(txtCmbFiltEnf.getText() + "%");
        cmbEnfermera.removeAllItems();
        cargaComboEnf();
    }//GEN-LAST:event_txtCmbFiltEnfKeyReleased

    private void txtCmbFiltEnfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCmbFiltEnfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCmbFiltEnfActionPerformed

    private void txtCmbFiltPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCmbFiltPacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCmbFiltPacActionPerformed

    private void txtCmbFiltPacKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCmbFiltPacKeyReleased
        daoAsig.setNombrePac(txtCmbFiltPac.getText() + "%");
        cmbPaciente.removeAllItems();
        cargaComboPaciente();
    }//GEN-LAST:event_txtCmbFiltPacKeyReleased

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
            java.util.logging.Logger.getLogger(frmAsigPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAsigPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAsigPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAsigPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAsigPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnTiempoTot;
    private javax.swing.JComboBox<String> cmbArea;
    private javax.swing.JComboBox<String> cmbEnfermera;
    private javax.swing.JComboBox<String> cmbPaciente;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblAsigPac;
    private javax.swing.JLabel lblBuscModElim;
    private javax.swing.JLabel lblCmbFiltEnf;
    private javax.swing.JLabel lblCmbFiltPac;
    private javax.swing.JLabel lblEnfermera;
    private javax.swing.JLabel lblFiltNombreDeEnf;
    private javax.swing.JLabel lblFondoVerde;
    private javax.swing.JLabel lblHoraFin;
    private javax.swing.JLabel lblHoraInicio;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblHoras;
    private javax.swing.JLabel lblIdAsigPac;
    private javax.swing.JLabel lblMinutos;
    private javax.swing.JLabel lblPaciente;
    private javax.swing.JLabel lblSep;
    private javax.swing.JLabel lblSep2;
    private javax.swing.JLabel lblTiempoTot;
    private javax.swing.JTable tblAsigPac;
    private javax.swing.JTextField txtCmbFiltEnf;
    private javax.swing.JTextField txtCmbFiltPac;
    private javax.swing.JTextField txtFiltNombreDeEnf;
    private javax.swing.JTextField txtHoraFin;
    private javax.swing.JTextField txtHoraInicio;
    private javax.swing.JTextField txtIdAsigPac;
    private javax.swing.JTextField txtMinFin;
    private javax.swing.JTextField txtMinInicio;
    private javax.swing.JTextField txtResHora;
    private javax.swing.JTextField txtResMin;
    // End of variables declaration//GEN-END:variables
}
