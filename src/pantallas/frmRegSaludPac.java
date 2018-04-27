/**
 * Nombre de los autores: Dámaso Valdés Rosales.
 *                        Iván Ruiz Ramírez.
 * Fecha de creación: 14/02/2017.
 * Nombre del proyecto: casaDescanso
 * Nombre del módulo: centralDeEnfermería
 * Breve descripción del contenido:  Este es el frame de la clase DAORegistroSaludPac, en ella se usa la clase dao para
 * poder insertar,eliminar,buscar y listar los respectivos datos de los Registros de salud de los pacientes.
 */
package pantallas;

import clases.ComboItem;
import clases.Conex;
import clases.DAORegistroSaludPac;
import static pantallas.frmMenuCentEnf.menuP;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;

/**
 *
 * @author IvanR
 */
public class frmRegSaludPac extends javax.swing.JFrame {

    /**
     * Creates new form ultimaTabla
     */
    public frmRegSaludPac() {
        initComponents();
        cargaComboPaciente();
        cargaComboEnfermera();
        btnListar.doClick();
        skin1();
    }
    private Connection con;
    DAORegistroSaludPac daoReg = new DAORegistroSaludPac();
    private boolean noRealizarBtn = false;
    Font textoTitulos = new Font("Tahoma",Font.BOLD,24);
    Font textoComponentes = new Font("Tahoma",Font.BOLD,14);
    static frmxLogin logIn = new frmxLogin();

    public void skin1(){
        Dimension dmnBtn = new Dimension(130, 40); //130, 50,
        btnAgregar.setSize(dmnBtn);
        btnModificar.setSize(dmnBtn);
        btnEliminar.setSize(dmnBtn);
        btnListar.setSize(dmnBtn);
        btnRegresar.setSize(dmnBtn);
        lblEnf.setText(lblEnf.getText().toUpperCase());
        lblFiltEnf.setText(lblFiltEnf.getText().toUpperCase());
        lblRegistroSalud.setText(lblRegistroSalud.getText().toUpperCase());
        lblIdRegistroSalud.setText(lblIdRegistroSalud.getText().toUpperCase());
        lblFiltros.setText(lblFiltros.getText().toUpperCase());
        lblPaciente1.setText(lblPaciente1.getText().toUpperCase());
        lblFechaSalPac.setText(lblFechaSalPac.getText().toUpperCase());
        lblPaciente.setText(lblPaciente.getText().toUpperCase());
        lblCmbFiltPac.setText(lblCmbFiltPac.getText().toUpperCase());
        lblPresionArterial.setText(lblPresionArterial.getText().toUpperCase());
        lblPulso.setText(lblPulso.getText().toUpperCase());
        lblLatMin.setText(lblLatMin.getText().toUpperCase());
        lblTemperatura.setText(lblTemperatura.getText().toUpperCase());
        lblGlicemia.setText(lblGlicemia.getText().toUpperCase());
        lblPrePandial.setText(lblPrePandial.getText().toUpperCase());
        lblMgDlPre.setText(lblMgDlPre.getText().toUpperCase());
        lblPostPandial.setText(lblPostPandial.getText().toUpperCase());
        lblMgDlPost.setText(lblMgDlPost.getText().toUpperCase());
        lblNotas.setText(lblNotas.getText().toUpperCase());
        btnIncidencias.setText(btnIncidencias.getText().toUpperCase());
        btnAgregar.setText(btnAgregar.getText().toUpperCase());
        btnModificar.setText(btnModificar.getText().toUpperCase());
        btnListar.setText(btnListar.getText().toUpperCase());
        btnEliminar.setText(btnEliminar.getText().toUpperCase());
        btnRegresar.setText(btnRegresar.getText().toUpperCase());
    }
    private void cargaComboPaciente() {
        cmbPaciente.removeAllItems();
        if (daoReg.getNomPac() == null) {
            daoReg.setNomPac("%");
        }
        con = Conex.getInstance().getConnection();
        String cadSql = "{call sp_cmbNomPac(?)};";
        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setString(1, daoReg.getNomPac());
            ComboItem miItem;
            ResultSet res = cstm.executeQuery();
            while (res.next()) {
                miItem = new ComboItem(res.getInt("idPaciente"), res.getString("Nombre") + " " + res.getString("apPat") + " " + res.getString("apMat"));
                cmbPaciente.addItem(String.valueOf(miItem));
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmRegSaludPac.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cargaComboEnfermera() {
        cmbNomEnf.removeAllItems();
        if (daoReg.getNomEnf() == null) {
            daoReg.setNomEnf("%");
        }
        con = Conex.getInstance().getConnection();
        String cadSql = "{call sp_cmbNomPersonal(?)};";
        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setString(1, daoReg.getNomEnf());
            ComboItem miItem;
            ResultSet res = cstm.executeQuery();
            while (res.next()) {
                miItem = new ComboItem(res.getInt("idEnfermera"), res.getString("nombreEnfermera") + " " + res.getString("apellidoPatEnf") + " " + res.getString("apellidoMatEnf"));
                cmbNomEnf.addItem(String.valueOf(miItem));
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmAsigPaciente.class.getName()).log(Level.SEVERE, null, ex);
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

        lblRegistroSalud = new javax.swing.JLabel();
        lblIdRegistroSalud = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistroSalud = new javax.swing.JTable();
        lblFiltros = new javax.swing.JLabel();
        lblPaciente1 = new javax.swing.JLabel();
        txtIdRegistroSalud = new javax.swing.JTextField();
        lblPresionArterial = new javax.swing.JLabel();
        txtPresionArtSis = new javax.swing.JTextField();
        lblPrePandial = new javax.swing.JLabel();
        txtPrePandial = new javax.swing.JTextField();
        lblPulso = new javax.swing.JLabel();
        txtFrecuenciaCar = new javax.swing.JTextField();
        lblNotas = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaNotas = new javax.swing.JTextArea();
        lblTemperatura = new javax.swing.JLabel();
        lblPaciente = new javax.swing.JLabel();
        lblPostPandial = new javax.swing.JLabel();
        txtPostPandial = new javax.swing.JTextField();
        lblGlicemia = new javax.swing.JLabel();
        lblDivisor = new javax.swing.JLabel();
        lblMgDlPre = new javax.swing.JLabel();
        lblMgDlPost = new javax.swing.JLabel();
        txtPaciente = new javax.swing.JTextField();
        btnListar = new javax.swing.JButton();
        cmbPaciente = new javax.swing.JComboBox();
        dchFechaSalPac = new com.toedter.calendar.JDateChooser();
        lblFechaSalPac = new javax.swing.JLabel();
        lblLatMin = new javax.swing.JLabel();
        lblPresionArtDiaSis = new javax.swing.JLabel();
        txtPresionArtDias = new javax.swing.JTextField();
        ftfTemperatura = new javax.swing.JFormattedTextField();
        lblCmbFiltPac = new javax.swing.JLabel();
        txtCmbFiltPac = new javax.swing.JTextField();
        lblEnf = new javax.swing.JLabel();
        cmbNomEnf = new javax.swing.JComboBox<>();
        lblFiltEnf = new javax.swing.JLabel();
        txtFiltEnf = new javax.swing.JTextField();
        btnIncidencias = new javax.swing.JButton();
        lblFondoVerde = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRegistroSalud.setFont(textoTitulos);
        lblRegistroSalud.setText("Registro de Salud del Paciente");
        getContentPane().add(lblRegistroSalud, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        lblIdRegistroSalud.setFont(textoComponentes);
        lblIdRegistroSalud.setText("Id Registro de Salud:");
        getContentPane().add(lblIdRegistroSalud, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 200, -1));

        btnRegresar.setFont(textoComponentes);
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 690, 143, 40));

        btnAgregar.setFont(textoComponentes);
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 690, 200, 40));

        btnModificar.setFont(textoComponentes);
        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 101, 135, 40));

        btnEliminar.setFont(textoComponentes);
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 101, 135, 40));

        tblRegistroSalud.setModel(new javax.swing.table.DefaultTableModel(
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
        tblRegistroSalud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRegistroSaludMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRegistroSalud);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 172, 860, 480));

        lblFiltros.setFont(textoComponentes);
        lblFiltros.setText("Filtros:");
        getContentPane().add(lblFiltros, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, -1, -1));

        lblPaciente1.setFont(textoComponentes);
        lblPaciente1.setText("Paciente:");
        getContentPane().add(lblPaciente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 80, -1));

        txtIdRegistroSalud.setEnabled(false);
        getContentPane().add(txtIdRegistroSalud, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 70, 29));

        lblPresionArterial.setFont(textoComponentes);
        lblPresionArterial.setText("Presión Arterial (mmHg):");
        getContentPane().add(lblPresionArterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 220, -1));

        txtPresionArtSis.setFont(textoComponentes);
        getContentPane().add(txtPresionArtSis, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 60, 30));

        lblPrePandial.setFont(textoComponentes);
        lblPrePandial.setText("Pre P.");
        getContentPane().add(lblPrePandial, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 63, -1));

        txtPrePandial.setFont(textoComponentes);
        getContentPane().add(txtPrePandial, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, 106, 29));

        lblPulso.setFont(textoComponentes);
        lblPulso.setText("Pulso (Frecuencia cardiaca):");
        getContentPane().add(lblPulso, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 230, -1));

        txtFrecuenciaCar.setFont(textoComponentes);
        getContentPane().add(txtFrecuenciaCar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 80, 30));

        lblNotas.setFont(textoComponentes);
        lblNotas.setText("Notas:");
        getContentPane().add(lblNotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 70, -1));

        txaNotas.setColumns(20);
        txaNotas.setFont(textoComponentes);
        txaNotas.setRows(5);
        jScrollPane2.setViewportView(txaNotas);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 580, 298, 100));

        lblTemperatura.setFont(textoComponentes);
        lblTemperatura.setText("Temperatura:");
        getContentPane().add(lblTemperatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 120, -1));

        lblPaciente.setFont(textoComponentes);
        lblPaciente.setText("Paciente:");
        getContentPane().add(lblPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 90, -1));

        lblPostPandial.setFont(textoComponentes);
        lblPostPandial.setText("Post P.");
        getContentPane().add(lblPostPandial, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, -1, -1));

        txtPostPandial.setFont(textoComponentes);
        getContentPane().add(txtPostPandial, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 540, 106, 29));

        lblGlicemia.setFont(textoComponentes);
        lblGlicemia.setText("GLICEMIA");
        getContentPane().add(lblGlicemia, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, -1, -1));

        lblDivisor.setFont(textoComponentes);
        lblDivisor.setText("----------------------------------------------");
        getContentPane().add(lblDivisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, -1, -1));

        lblMgDlPre.setFont(textoComponentes);
        lblMgDlPre.setText("mg/dL");
        getContentPane().add(lblMgDlPre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, 68, -1));

        lblMgDlPost.setFont(textoComponentes);
        lblMgDlPost.setText("mg/dL");
        getContentPane().add(lblMgDlPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 550, 68, -1));

        txtPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPacienteKeyReleased(evt);
            }
        });
        getContentPane().add(txtPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 170, -1));

        btnListar.setFont(textoComponentes);
        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });
        getContentPane().add(btnListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 137, 40));

        cmbPaciente.setFont(textoComponentes);
        cmbPaciente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPacienteItemStateChanged(evt);
            }
        });
        cmbPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPacienteActionPerformed(evt);
            }
        });
        getContentPane().add(cmbPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 260, -1));

        dchFechaSalPac.setFont(textoComponentes);
        getContentPane().add(dchFechaSalPac, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 152, 172, -1));

        lblFechaSalPac.setFont(textoComponentes);
        lblFechaSalPac.setText("Fecha:");
        getContentPane().add(lblFechaSalPac, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 158, -1, -1));

        lblLatMin.setFont(textoComponentes);
        lblLatMin.setText("lat/min");
        getContentPane().add(lblLatMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, 70, -1));

        lblPresionArtDiaSis.setFont(textoComponentes);
        lblPresionArtDiaSis.setText("/");
        getContentPane().add(lblPresionArtDiaSis, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 10, -1));

        txtPresionArtDias.setFont(textoComponentes);
        getContentPane().add(txtPresionArtDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 60, 30));

        try {
            ftfTemperatura.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## °C")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfTemperatura.setFont(textoComponentes);
        getContentPane().add(ftfTemperatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 70, -1));

        lblCmbFiltPac.setFont(textoComponentes);
        lblCmbFiltPac.setText("Filtro Pac:");
        getContentPane().add(lblCmbFiltPac, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 100, -1));

        txtCmbFiltPac.setFont(textoComponentes);
        txtCmbFiltPac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCmbFiltPacKeyReleased(evt);
            }
        });
        getContentPane().add(txtCmbFiltPac, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 70, 30));

        lblEnf.setFont(textoComponentes);
        lblEnf.setText("Enfermera:");
        getContentPane().add(lblEnf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        cmbNomEnf.setFont(textoComponentes);
        getContentPane().add(cmbNomEnf, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 260, -1));

        lblFiltEnf.setFont(textoComponentes);
        lblFiltEnf.setText("Filtro Enf:");
        getContentPane().add(lblFiltEnf, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 90, 20));

        txtFiltEnf.setFont(textoComponentes);
        txtFiltEnf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltEnfKeyReleased(evt);
            }
        });
        getContentPane().add(txtFiltEnf, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 70, 30));

        btnIncidencias.setFont(textoComponentes);
        btnIncidencias.setText("Incidencias");
        btnIncidencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncidenciasActionPerformed(evt);
            }
        });
        getContentPane().add(btnIncidencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 100, 200, 40));

        lblFondoVerde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoVerde.jpg"))); // NOI18N
        getContentPane().add(lblFondoVerde, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        DateFormat fmt = new SimpleDateFormat("yy/MM/dd");
        if (dchFechaSalPac.getDate() == null) {
            JOptionPane.showMessageDialog(null, "El campo de la fecha no puede estar vacío.");
        } else {
            String date = fmt.format(dchFechaSalPac.getDate());
            if (cmbPaciente.getSelectedItem() == null || cmbNomEnf.getSelectedItem() == null) {
                noRealizarBtn = true;
                JOptionPane.showMessageDialog(null, "Combobox vacio.");
            } else {
                daoReg.setNomPac(cmbPaciente.getSelectedItem().toString());
                daoReg.setNomEnf(cmbNomEnf.getSelectedItem().toString());
                daoReg.detectarIdPaciente();
                daoReg.detectarIdEnfermera();
            }

            try {
                daoReg.setPresionArtSis(Integer.parseInt(txtPresionArtSis.getText()));
                daoReg.setPresionArtDias(Integer.parseInt(txtPresionArtDias.getText()));
                daoReg.setFrecuenciaCar(Integer.parseInt(txtFrecuenciaCar.getText()));
                daoReg.setPrePrandial(Integer.parseInt(txtPrePandial.getText()));
                daoReg.setPostPrandial(Integer.parseInt(txtPostPandial.getText()));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Los campos de presion arterial, glicemia y frecuencia cardiaca deben ser números enteros.");
                noRealizarBtn = true;
            }
            daoReg.setTemperatura(ftfTemperatura.getText());
            daoReg.setNotas(txaNotas.getText().toUpperCase());
            daoReg.setFechaSalPac(date);
            if (noRealizarBtn == false) {
                if (daoReg.agregar()) {
                    JOptionPane.showMessageDialog(null, "Registro Agregado");
                    txtPresionArtSis.setText("");
                    txtPresionArtDias.setText("");
                    txtFrecuenciaCar.setText("");
                    ftfTemperatura.setText("");
                    txtPrePandial.setText("");
                    txtPostPandial.setText("");
                    txaNotas.setText("");
                    dchFechaSalPac.setCalendar(null);
                    btnListar.doClick();
                }
            }
        }
        noRealizarBtn = false;
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        dispose();
        //menuP.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        DateFormat fmt = new SimpleDateFormat("yy/MM/dd");
        if (dchFechaSalPac.getDate() == null) {
            JOptionPane.showMessageDialog(null, "El campo de la fecha no puede estar vacío.");
        } else {
            String date = fmt.format(dchFechaSalPac.getDate());
            daoReg.setIdRegistroDeSalud(Integer.parseInt(txtIdRegistroSalud.getText()));
            if (cmbPaciente.getSelectedItem() == null || cmbNomEnf.getSelectedItem() == null) {
                noRealizarBtn = true;
                JOptionPane.showMessageDialog(null, "Combobox vacio.");
            } else {
                daoReg.setNomPac(cmbPaciente.getSelectedItem().toString());
                daoReg.setNomEnf(cmbNomEnf.getSelectedItem().toString());
                daoReg.detectarIdPaciente();
                daoReg.detectarIdEnfermera();
            }
            
            try {
                daoReg.setPresionArtSis(Integer.parseInt(txtPresionArtSis.getText()));
                daoReg.setPresionArtDias(Integer.parseInt(txtPresionArtDias.getText()));
                daoReg.setFrecuenciaCar(Integer.parseInt(txtFrecuenciaCar.getText()));
                daoReg.setPrePrandial(Integer.parseInt(txtPrePandial.getText()));
                daoReg.setPostPrandial(Integer.parseInt(txtPostPandial.getText()));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Los campos de presion arterial, glicemia y frecuencia cardiaca deben ser números enteros.");
                noRealizarBtn = true;
            }
            daoReg.setTemperatura(ftfTemperatura.getText());
            daoReg.setNotas(txaNotas.getText().toUpperCase());
            daoReg.setFechaSalPac(date);
            if (noRealizarBtn == false) {
                if (daoReg.modificar()) {
                    txtIdRegistroSalud.setText("");
                    txtPresionArtSis.setText("");
                    txtPresionArtDias.setText("");
                    txtFrecuenciaCar.setText("");
                    ftfTemperatura.setText("");
                    txtPrePandial.setText("");
                    txtPostPandial.setText("");
                    txaNotas.setText("");
                    dchFechaSalPac.setCalendar(null);
                    btnModificar.setEnabled(false);
                    btnEliminar.setEnabled(false);
                    btnAgregar.setEnabled(true);
                    btnListar.doClick();
                }
            }
        }

        noRealizarBtn = false;

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        daoReg.setIdRegistroDeSalud(Integer.parseInt(txtIdRegistroSalud.getText()));
        daoReg.eliminar();
        txtIdRegistroSalud.setText("");
        txtPresionArtSis.setText("");
        txtPresionArtDias.setText("");
        txtFrecuenciaCar.setText("");
        ftfTemperatura.setText("");
        txtPrePandial.setText("");
        txtPostPandial.setText("");
        txaNotas.setText("");
        dchFechaSalPac.setCalendar(null);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnAgregar.setEnabled(true);
        btnListar.doClick();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        daoReg.getTmodel().setColumnCount(0);
        daoReg.getTmodel().setRowCount(0);
        daoReg.listar();
        tblRegistroSalud.setModel(daoReg.getTmodel());
    }//GEN-LAST:event_btnListarActionPerformed

    private void cmbPacienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPacienteItemStateChanged

    }//GEN-LAST:event_cmbPacienteItemStateChanged

    private void cmbPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPacienteActionPerformed

    }//GEN-LAST:event_cmbPacienteActionPerformed

    private void txtPacienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPacienteKeyReleased
        String cadenaFilt = txtPaciente.getText() + "%";
        daoReg.setNomPac(cadenaFilt);
        daoReg.getTmodel().setColumnCount(0);
        daoReg.getTmodel().setRowCount(0);
        daoReg.filtrar();
        tblRegistroSalud.setModel(daoReg.getTmodel());
    }//GEN-LAST:event_txtPacienteKeyReleased

    private void tblRegistroSaludMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRegistroSaludMouseClicked
        if (!SwingUtilities.isRightMouseButton(evt)) {
            int index = tblRegistroSalud.getSelectedRow();
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            TableModel model = tblRegistroSalud.getModel();
            txtCmbFiltPac.setText("");
            daoReg.setNomPac("%");
            String idRegistroSalud = model.getValueAt(index, 0).toString();
            String enfermera = model.getValueAt(index, 1).toString() + " " + model.getValueAt(index, 2).toString() + " " + model.getValueAt(index, 3).toString();
            String paciente = model.getValueAt(index, 4).toString() + " " + model.getValueAt(index, 5).toString() + " " + model.getValueAt(index, 6).toString();
            String presionArtSis = model.getValueAt(index, 7).toString();
            String presionArtDias = model.getValueAt(index, 8).toString();
            String frecuenciaCar = model.getValueAt(index, 9).toString();
            String temperatura = model.getValueAt(index, 10).toString();
            String prePrandial = model.getValueAt(index, 11).toString();
            String postPrandial = model.getValueAt(index, 12).toString();
            String notas = model.getValueAt(index, 13).toString();
            String fechaSalPac = model.getValueAt(index, 14).toString();
            txtIdRegistroSalud.setText(idRegistroSalud);
            try {
                dchFechaSalPac.setDate(fmt.parse(fechaSalPac));
            } catch (ParseException ex) {
                Logger.getLogger(frmListPedMed.class.getName()).log(Level.SEVERE, null, ex);
            }
            cmbNomEnf.setSelectedItem(enfermera);
            cmbPaciente.setSelectedItem(paciente);
            txtPresionArtSis.setText(presionArtSis);
            txtPresionArtDias.setText(presionArtDias);
            txtFrecuenciaCar.setText(frecuenciaCar);
            ftfTemperatura.setText(temperatura);
            txtPrePandial.setText(prePrandial);
            txtPostPandial.setText(postPrandial);
            txaNotas.setText(notas);
            btnModificar.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnAgregar.setEnabled(false);
        }
    }//GEN-LAST:event_tblRegistroSaludMouseClicked

    private void txtCmbFiltPacKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCmbFiltPacKeyReleased
        daoReg.setNomPac(txtCmbFiltPac.getText() + "%");
        cmbPaciente.removeAllItems();
        cargaComboPaciente();
    }//GEN-LAST:event_txtCmbFiltPacKeyReleased

    private void txtFiltEnfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltEnfKeyReleased
        daoReg.setNomEnf(txtFiltEnf.getText() + "%");
        cmbNomEnf.removeAllItems();
        cargaComboEnfermera();
    }//GEN-LAST:event_txtFiltEnfKeyReleased

    private void btnIncidenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncidenciasActionPerformed
        dispose();
        logIn.setVisible(true);
    }//GEN-LAST:event_btnIncidenciasActionPerformed

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
            java.util.logging.Logger.getLogger(frmRegSaludPac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRegSaludPac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRegSaludPac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRegSaludPac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRegSaludPac().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnIncidencias;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegresar;
    public javax.swing.JComboBox<String> cmbNomEnf;
    public javax.swing.JComboBox cmbPaciente;
    private com.toedter.calendar.JDateChooser dchFechaSalPac;
    private javax.swing.JFormattedTextField ftfTemperatura;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCmbFiltPac;
    private javax.swing.JLabel lblDivisor;
    private javax.swing.JLabel lblEnf;
    private javax.swing.JLabel lblFechaSalPac;
    private javax.swing.JLabel lblFiltEnf;
    private javax.swing.JLabel lblFiltros;
    private javax.swing.JLabel lblFondoVerde;
    private javax.swing.JLabel lblGlicemia;
    private javax.swing.JLabel lblIdRegistroSalud;
    private javax.swing.JLabel lblLatMin;
    private javax.swing.JLabel lblMgDlPost;
    private javax.swing.JLabel lblMgDlPre;
    private javax.swing.JLabel lblNotas;
    private javax.swing.JLabel lblPaciente;
    private javax.swing.JLabel lblPaciente1;
    private javax.swing.JLabel lblPostPandial;
    private javax.swing.JLabel lblPrePandial;
    private javax.swing.JLabel lblPresionArtDiaSis;
    private javax.swing.JLabel lblPresionArterial;
    private javax.swing.JLabel lblPulso;
    private javax.swing.JLabel lblRegistroSalud;
    private javax.swing.JLabel lblTemperatura;
    private javax.swing.JTable tblRegistroSalud;
    private javax.swing.JTextArea txaNotas;
    private javax.swing.JTextField txtCmbFiltPac;
    private javax.swing.JTextField txtFiltEnf;
    private javax.swing.JTextField txtFrecuenciaCar;
    private javax.swing.JTextField txtIdRegistroSalud;
    private javax.swing.JTextField txtPaciente;
    private javax.swing.JTextField txtPostPandial;
    private javax.swing.JTextField txtPrePandial;
    private javax.swing.JTextField txtPresionArtDias;
    private javax.swing.JTextField txtPresionArtSis;
    // End of variables declaration//GEN-END:variables
}
