/*
 * Nombre del autor: Iván Ruiz Ramírez
 * Fecha de creación: 2017/01/31
 * Nombre del proyecto: casaDescanso
 * Nombre del módulo: centralDeEnfermería
 * Breve descripción del contenido: El frame "Pedido Medicamentos" (frmPedMed) contempla todo lo relacionado a dosis y cantidad de medicamentos para cada paciente,
 * el cual permite realizar altas,bajas,cambios a la base de datos y mostrar la lista de pedidos y en caso de ser usuario privilegiado, la lista de cantidad total de medicamentos a pedir.
 */
package pantallas;

import clases.ComboItem;
import clases.Conex;
import clases.DAOPedMed;
import static pantallas.frmMenuCentEnf.menuP;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author IvanR
 */
public class frmPedMed extends javax.swing.JFrame {

    /**
     * Creates new form reportePacientes
     */
    public frmPedMed() {
        initComponents();
        cargaComboPaciente();
        cargaComboMedGen();
        cargaComboEnfermera();
        cmbMedPat.removeAllItems();
        cargaComboMedPat();
        skin1();
    }
    private Connection con;
    private boolean noRealizarBtn = false;
    private int edad;
    private String contenidoCaja, administracion;
    DefaultTableModel model = new DefaultTableModel();
    static frmListPedMed listPedMed = new frmListPedMed();
    static frmListPedMedGrup listGrup = new frmListPedMedGrup();
    static frmListMedSem listSem = new frmListMedSem();
    static frmPedMed pedMed = new frmPedMed();
    DAOPedMed daoPed = new DAOPedMed();
    Font textoTitulos = new Font("Tahoma", Font.BOLD,24);
    Font textoComponentes = new Font("Tahoma", Font.BOLD,14);

    public void skin1() {
        Dimension dmnBtn = new Dimension(130, 50); //130, 50, 240
        btnAgregarPed.setSize(dmnBtn);
        btnModificarPed.setSize(dmnBtn);
        btnEliminarPed.setSize(dmnBtn);
        btnRegresarPed.setSize(dmnBtn);
        btnListaPedidos.setSize(dmnBtn);
        btnListCantPedMed.setSize(dmnBtn);
        lblPedMed.setText(lblPedMed.getText().toUpperCase());
        lblFechaPedMed.setText(lblFechaPedMed.getText().toUpperCase());
        lblPaciente.setText(lblPaciente.getText().toUpperCase());
        lblCmbFiltPac.setText(lblCmbFiltPac.getText().toUpperCase());
        lblMed1.setText(lblMed1.getText().toUpperCase());
        lblCmbFiltMed.setText(lblCmbFiltMed.getText().toUpperCase());
        lblMedPat.setText(lblMedPat.getText().toUpperCase());
        lblDosis.setText(lblDosis.getText().toUpperCase());
        lblHorario.setText(lblHorario.getText().toUpperCase());
        lblDescr.setText(lblDescr.getText().toUpperCase());
        lblBuscModEl.setText(lblBuscModEl.getText().toUpperCase());
        lblIdApunte.setText(lblIdApunte.getText().toUpperCase());
        lblContenidoCaja.setText(lblContenidoCaja.getText().toUpperCase());
        lblAdministracion.setText(lblAdministracion.getText().toUpperCase());
        lblEdad.setText(lblEdad.getText().toUpperCase());
        lblDiagnost.setText(lblDiagnost.getText().toUpperCase());
        lblEnfermera.setText(lblEnfermera.getText().toUpperCase());
        lblFiltEnf.setText(lblFiltEnf.getText().toUpperCase());
        btnAgregarPed.setText(btnAgregarPed.getText().toUpperCase());
        btnModificarPed.setText(btnModificarPed.getText().toUpperCase());
        btnListaPedidos.setText(btnListaPedidos.getText().toUpperCase());
        btnListCantPedMed.setText(btnListCantPedMed.getText().toUpperCase());
        btnListMedSem.setText(btnListMedSem.getText().toUpperCase());
        btnEliminarPed.setText(btnEliminarPed.getText().toUpperCase());
        btnRegresarPed.setText(btnRegresarPed.getText().toUpperCase());
        rbtEsp.setText(rbtEsp.getText().toUpperCase());
        rbtMaTaNo.setText(rbtMaTaNo.getText().toUpperCase());
        chkManana.setText(chkManana.getText().toUpperCase());
        chkTarde.setText(chkTarde.getText().toUpperCase());
        chkNoche.setText(chkNoche.getText().toUpperCase());
    }

    public void cargaComboPaciente() {
        cmbPaciente.removeAllItems();
        if (daoPed.getNomPac() == null) {
            daoPed.setNomPac("%");
        }
        con = Conex.getInstance().getConnection();
        String cadSql = "{call sp_cmbNomPac(?)};";
        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setString(1, daoPed.getNomPac());
            ComboItem miItem;
            ResultSet res = cstm.executeQuery();
            while (res.next()) {
                miItem = new ComboItem(res.getInt("idPaciente"), res.getString("Nombre") + " " + res.getString("apPat") + " " + res.getString("apMat"));
                cmbPaciente.addItem(String.valueOf(miItem));
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmPedMed.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargaComboEnfermera() {
        cmbEnfermera.removeAllItems();
        if (daoPed.getEnfermera() == null) {
            daoPed.setEnfermera("%");
        }
        con = Conex.getInstance().getConnection();
        String cadSql = "{call sp_cmbNomPersonal(?)};";
        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setString(1, daoPed.getEnfermera());
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

    public void cargaComboMedGen() {
        cmbMedGen.removeAllItems();
        if (daoPed.getNombreProductoGen() == null) {
            daoPed.setNombreProductoGen("%");
        }
        con = Conex.getInstance().getConnection();
        String cadSql = "{call sp_cmbNomMedGen(?)};";
        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setString(1, daoPed.getNombreProductoGen());
            ComboItem miItem;
            ResultSet res = cstm.executeQuery();
            while (res.next()) {
                miItem = new ComboItem(res.getInt("idProducto"), res.getString("nombreProductoGen"));
                cmbMedGen.addItem(String.valueOf(miItem));
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmPedMed.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargaComboMedPat() {
        cmbMedPat.removeAllItems();
        String cadCmbMedGen = "";
        if (cmbMedGen.getSelectedItem() == null) {
            cadCmbMedGen = "";
        } else {
            cadCmbMedGen = cmbMedGen.getSelectedItem().toString();
        }
        con = Conex.getInstance().getConnection();
        String cadSql = "{call sp_cmbNomMedPat(?)};";
        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setString(1, cadCmbMedGen);
            ComboItem miItem;
            ResultSet res = cstm.executeQuery();
            while (res.next()) {
                miItem = new ComboItem(res.getInt("idProducto"), res.getString("nombreProductoPat"));
                cmbMedPat.addItem(String.valueOf(miItem));
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmPedMed.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void MostrarInfoPac() {
        con = Conex.getInstance().getConnection();
        String cadSql = "{call sp_cmbInfoPac(?)};";
        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setInt(1, daoPed.getIdPaciente());
            ResultSet rs = cstm.executeQuery();
            if (rs.next()) {
                edad = rs.getInt("Edad");
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmPedMed.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void MostrarInfoMed() {
        con = Conex.getInstance().getConnection();
        String cadSql = "{call sp_cmbInfoMed(?)};";
        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setInt(1, daoPed.getIdProducto());
            ResultSet rs = cstm.executeQuery();
            if (rs.next()) {
                contenidoCaja = rs.getString("contenidoCaja");
                administracion = rs.getString("administracion");
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmPedMed.class.getName()).log(Level.SEVERE, null, ex);
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

        lblPedMed = new javax.swing.JLabel();
        lblDescr = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaDescrPedMed = new javax.swing.JTextArea();
        lblPaciente = new javax.swing.JLabel();
        lblMedPat = new javax.swing.JLabel();
        btnRegresarPed = new javax.swing.JButton();
        lblDosis = new javax.swing.JLabel();
        txtDosis = new javax.swing.JTextField();
        btnAgregarPed = new javax.swing.JButton();
        btnModificarPed = new javax.swing.JButton();
        btnEliminarPed = new javax.swing.JButton();
        lblBuscModEl = new javax.swing.JLabel();
        lblIdApunte = new javax.swing.JLabel();
        txtIdPedidoMed = new javax.swing.JTextField();
        btnListaPedidos = new javax.swing.JButton();
        lblHorario = new javax.swing.JLabel();
        rbtEsp = new javax.swing.JRadioButton();
        rbtMaTaNo = new javax.swing.JRadioButton();
        chkManana = new javax.swing.JCheckBox();
        chkTarde = new javax.swing.JCheckBox();
        chkNoche = new javax.swing.JCheckBox();
        txtHorarioMan = new javax.swing.JTextField();
        txtHorarioTarde = new javax.swing.JTextField();
        txtHorarioNoche = new javax.swing.JTextField();
        txtHorarioEsp = new javax.swing.JTextField();
        btnListCantPedMed = new javax.swing.JButton();
        lblFechaPedMed = new javax.swing.JLabel();
        dchFechaPedMed = new com.toedter.calendar.JDateChooser();
        cmbPaciente = new javax.swing.JComboBox();
        cmbMedPat = new javax.swing.JComboBox();
        lblMed1 = new javax.swing.JLabel();
        cmbMedGen = new javax.swing.JComboBox();
        lblCmbFiltPac = new javax.swing.JLabel();
        txtCmbFiltPac = new javax.swing.JTextField();
        lblCmbFiltMed = new javax.swing.JLabel();
        txtCmbFiltMed = new javax.swing.JTextField();
        lblDiagnost = new javax.swing.JLabel();
        txtDiagnost = new javax.swing.JTextField();
        txtDepart = new javax.swing.JLabel();
        lblEnfermera = new javax.swing.JLabel();
        cmbEnfermera = new javax.swing.JComboBox();
        cmbDepart = new javax.swing.JComboBox<String>();
        lblEdad = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        lblFiltEnf = new javax.swing.JLabel();
        txtCmbFiltEnf = new javax.swing.JTextField();
        lblAdministracion = new javax.swing.JLabel();
        txtAdministracion = new javax.swing.JTextField();
        lblFechaIngreso = new javax.swing.JLabel();
        dchFechaIngreso = new com.toedter.calendar.JDateChooser();
        lblContenidoCaja = new javax.swing.JLabel();
        txtContenidoCaja = new javax.swing.JTextField();
        btnListMedSem = new javax.swing.JButton();
        lblFondoVerde = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPedMed.setFont(textoTitulos);
        lblPedMed.setText("Pedidos Medicamentos (Enfermeras)");
        getContentPane().add(lblPedMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        lblDescr.setFont(textoComponentes);
        lblDescr.setText("Cuidados especiales:");
        getContentPane().add(lblDescr, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 664, -1, -1));

        txaDescrPedMed.setColumns(20);
        txaDescrPedMed.setFont(textoComponentes);
        txaDescrPedMed.setRows(5);
        jScrollPane1.setViewportView(txaDescrPedMed);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 684, 433, 111));

        lblPaciente.setFont(textoComponentes);
        lblPaciente.setText("Paciente:");
        getContentPane().add(lblPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        lblMedPat.setFont(textoComponentes);
        lblMedPat.setText("Medicamento Patente:");
        getContentPane().add(lblMedPat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 382, -1, -1));

        btnRegresarPed.setFont(textoComponentes);
        btnRegresarPed.setText("Regresar");
        btnRegresarPed.setMaximumSize(new java.awt.Dimension(0, 40));
        btnRegresarPed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarPedActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresarPed, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 690, 122, 40));

        lblDosis.setFont(textoComponentes);
        lblDosis.setText("Dosis:");
        getContentPane().add(lblDosis, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 512, -1, -1));

        txtDosis.setFont(textoComponentes);
        getContentPane().add(txtDosis, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 509, 70, -1));

        btnAgregarPed.setFont(textoComponentes);
        btnAgregarPed.setText("Agregar");
        btnAgregarPed.setMaximumSize(new java.awt.Dimension(0, 40));
        btnAgregarPed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPedActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarPed, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 806, 129, 40));

        btnModificarPed.setFont(textoComponentes);
        btnModificarPed.setText("Modificar");
        btnModificarPed.setEnabled(false);
        btnModificarPed.setMaximumSize(new java.awt.Dimension(0, 40));
        btnModificarPed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPedActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificarPed, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 806, 129, 40));

        btnEliminarPed.setFont(textoComponentes);
        btnEliminarPed.setText("Eliminar");
        btnEliminarPed.setEnabled(false);
        btnEliminarPed.setMaximumSize(new java.awt.Dimension(0, 40));
        btnEliminarPed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPedActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminarPed, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 806, 130, 40));

        lblBuscModEl.setFont(textoComponentes);
        lblBuscModEl.setText("Buscar/Modificar/Eliminar");
        getContentPane().add(lblBuscModEl, new org.netbeans.lib.awtextra.AbsoluteConstraints(683, 53, 253, -1));

        lblIdApunte.setFont(textoComponentes);
        lblIdApunte.setText("Id Pedido Med:");
        getContentPane().add(lblIdApunte, new org.netbeans.lib.awtextra.AbsoluteConstraints(717, 81, -1, -1));

        txtIdPedidoMed.setFont(textoComponentes);
        txtIdPedidoMed.setEnabled(false);
        getContentPane().add(txtIdPedidoMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(857, 78, 70, -1));

        btnListaPedidos.setFont(textoComponentes);
        btnListaPedidos.setText("Lista Pedidos");
        btnListaPedidos.setMaximumSize(new java.awt.Dimension(0, 40));
        btnListaPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaPedidosActionPerformed(evt);
            }
        });
        getContentPane().add(btnListaPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 179, 171, 40));

        lblHorario.setFont(textoComponentes);
        lblHorario.setText("Horario:");
        getContentPane().add(lblHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 544, -1, -1));

        rbtEsp.setBackground(new java.awt.Color(198, 253, 188));
        rbtEsp.setFont(textoComponentes);
        rbtEsp.setSelected(true);
        rbtEsp.setText("Especifico");
        rbtEsp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbtEspItemStateChanged(evt);
            }
        });
        getContentPane().add(rbtEsp, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 540, 140, -1));

        rbtMaTaNo.setBackground(new java.awt.Color(198, 253, 188));
        rbtMaTaNo.setFont(textoComponentes);
        rbtMaTaNo.setText("Mañana/Tarde/Noche");
        rbtMaTaNo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbtMaTaNoItemStateChanged(evt);
            }
        });
        getContentPane().add(rbtMaTaNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 575, 220, -1));

        chkManana.setBackground(new java.awt.Color(198, 253, 188));
        chkManana.setFont(textoComponentes);
        chkManana.setText("Mañana");
        chkManana.setEnabled(false);
        chkManana.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkMananaItemStateChanged(evt);
            }
        });
        getContentPane().add(chkManana, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 570, -1, -1));

        chkTarde.setBackground(new java.awt.Color(198, 253, 188));
        chkTarde.setFont(textoComponentes);
        chkTarde.setText("Tarde");
        chkTarde.setEnabled(false);
        chkTarde.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkTardeItemStateChanged(evt);
            }
        });
        getContentPane().add(chkTarde, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 600, -1, -1));

        chkNoche.setBackground(new java.awt.Color(198, 253, 188));
        chkNoche.setFont(textoComponentes);
        chkNoche.setText("Noche");
        chkNoche.setEnabled(false);
        chkNoche.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkNocheItemStateChanged(evt);
            }
        });
        chkNoche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkNocheActionPerformed(evt);
            }
        });
        getContentPane().add(chkNoche, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 630, -1, -1));

        txtHorarioMan.setFont(textoComponentes);
        txtHorarioMan.setEnabled(false);
        getContentPane().add(txtHorarioMan, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 570, 61, -1));

        txtHorarioTarde.setFont(textoComponentes);
        txtHorarioTarde.setEnabled(false);
        getContentPane().add(txtHorarioTarde, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 600, 61, -1));

        txtHorarioNoche.setFont(textoComponentes);
        txtHorarioNoche.setEnabled(false);
        getContentPane().add(txtHorarioNoche, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 630, 61, -1));

        txtHorarioEsp.setFont(textoComponentes);
        getContentPane().add(txtHorarioEsp, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 540, 150, -1));

        btnListCantPedMed.setFont(textoComponentes);
        btnListCantPedMed.setText("Lista Medicamentos Autorizados");
        btnListCantPedMed.setMaximumSize(new java.awt.Dimension(0, 40));
        btnListCantPedMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListCantPedMedActionPerformed(evt);
            }
        });
        getContentPane().add(btnListCantPedMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(607, 237, 317, 40));

        lblFechaPedMed.setFont(textoComponentes);
        lblFechaPedMed.setText("Fecha Medicamento:");
        getContentPane().add(lblFechaPedMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 286, -1, -1));

        dchFechaPedMed.setFont(textoComponentes);
        getContentPane().add(dchFechaPedMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 280, 150, -1));

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
        getContentPane().add(cmbPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 189, -1));

        cmbMedPat.setFont(textoComponentes);
        cmbMedPat.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMedPatItemStateChanged(evt);
            }
        });
        cmbMedPat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMedPatActionPerformed(evt);
            }
        });
        getContentPane().add(cmbMedPat, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 379, 210, -1));

        lblMed1.setFont(textoComponentes);
        lblMed1.setText("Medicamento Genérico:");
        getContentPane().add(lblMed1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 314, -1, -1));

        cmbMedGen.setFont(textoComponentes);
        cmbMedGen.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMedGenItemStateChanged(evt);
            }
        });
        cmbMedGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMedGenActionPerformed(evt);
            }
        });
        getContentPane().add(cmbMedGen, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 311, 210, -1));

        lblCmbFiltPac.setFont(textoComponentes);
        lblCmbFiltPac.setText("Filtro paciente:");
        getContentPane().add(lblCmbFiltPac, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 138, -1, -1));

        txtCmbFiltPac.setFont(textoComponentes);
        txtCmbFiltPac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCmbFiltPacKeyReleased(evt);
            }
        });
        getContentPane().add(txtCmbFiltPac, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 135, 100, -1));

        lblCmbFiltMed.setFont(textoComponentes);
        lblCmbFiltMed.setText("Filtro med. genérico:");
        getContentPane().add(lblCmbFiltMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 345, -1, -1));

        txtCmbFiltMed.setFont(textoComponentes);
        txtCmbFiltMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCmbFiltMedActionPerformed(evt);
            }
        });
        txtCmbFiltMed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCmbFiltMedKeyReleased(evt);
            }
        });
        getContentPane().add(txtCmbFiltMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 342, 110, -1));

        lblDiagnost.setFont(textoComponentes);
        lblDiagnost.setText("Diagnóstico:");
        getContentPane().add(lblDiagnost, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        txtDiagnost.setFont(textoComponentes);
        getContentPane().add(txtDiagnost, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 185, 190, 20));

        txtDepart.setFont(textoComponentes);
        txtDepart.setText("Departamento:");
        getContentPane().add(txtDepart, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 65, -1, -1));

        lblEnfermera.setFont(textoComponentes);
        lblEnfermera.setText("Medico:");
        getContentPane().add(lblEnfermera, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        cmbEnfermera.setFont(textoComponentes);
        cmbEnfermera.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEnfermeraItemStateChanged(evt);
            }
        });
        cmbEnfermera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEnfermeraActionPerformed(evt);
            }
        });
        getContentPane().add(cmbEnfermera, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 250, -1));

        cmbDepart.setFont(textoComponentes);
        cmbDepart.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SAN JOSÉ", "CESARITA", "NAZARET", "CORAZÓN DE JESÚS", "SAGRADA FAMILIA", "VILLA SECA" }));
        cmbDepart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDepartActionPerformed(evt);
            }
        });
        getContentPane().add(cmbDepart, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 180, -1));

        lblEdad.setFont(textoComponentes);
        lblEdad.setText("Edad:");
        getContentPane().add(lblEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, 20));

        txtEdad.setFont(textoComponentes);
        txtEdad.setEnabled(false);
        getContentPane().add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 55, -1));

        lblFiltEnf.setFont(textoComponentes);
        lblFiltEnf.setText("Filtro médico:");
        getContentPane().add(lblFiltEnf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

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
        getContentPane().add(txtCmbFiltEnf, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 100, 20));

        lblAdministracion.setFont(textoComponentes);
        lblAdministracion.setText("Vía de Admón.:");
        getContentPane().add(lblAdministracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 451, -1, -1));

        txtAdministracion.setEnabled(false);
        getContentPane().add(txtAdministracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 448, 130, -1));

        lblFechaIngreso.setFont(textoComponentes);
        lblFechaIngreso.setText("Fecha de ingreso:");
        getContentPane().add(lblFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 68, -1, -1));

        dchFechaIngreso.setFont(textoComponentes);
        getContentPane().add(dchFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 62, 150, -1));

        lblContenidoCaja.setFont(textoComponentes);
        lblContenidoCaja.setText("Contenido Caja:");
        getContentPane().add(lblContenidoCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        txtContenidoCaja.setEnabled(false);
        getContentPane().add(txtContenidoCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 417, 130, -1));

        btnListMedSem.setFont(textoComponentes);
        btnListMedSem.setText("Lista Medicamentos Semanal");
        btnListMedSem.setMaximumSize(new java.awt.Dimension(0, 40));
        btnListMedSem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListMedSemActionPerformed(evt);
            }
        });
        getContentPane().add(btnListMedSem, new org.netbeans.lib.awtextra.AbsoluteConstraints(607, 295, 317, 40));

        lblFondoVerde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoVerde.jpg"))); // NOI18N
        getContentPane().add(lblFondoVerde, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 870));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarPedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarPedActionPerformed
        dispose();
        //menuP.setVisible(true);
    }//GEN-LAST:event_btnRegresarPedActionPerformed

    private void btnAgregarPedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPedActionPerformed
        DateFormat fmt = new SimpleDateFormat("yy/MM/dd");
        if (dchFechaPedMed.getDate() == null || dchFechaIngreso.getDate() == null) {
            JOptionPane.showMessageDialog(null, "El campo de la fecha no puede estar vacío.");
        } else {
            String dateIng = fmt.format(dchFechaIngreso.getDate());
            String dateMed = fmt.format(dchFechaPedMed.getDate());
            if (txtDosis.getText().equals("") || txtDiagnost.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Campos vacios o incorrectos.");
            } else {
                if (rbtEsp.isSelected()) {
                    txtHorarioMan.setText("0");
                    txtHorarioTarde.setText("0");
                    txtHorarioNoche.setText("0");
                    daoPed.setHorarioMan(txtHorarioMan.getText());
                    daoPed.setHorarioTarde(txtHorarioMan.getText());
                    daoPed.setHorarioNoche(txtHorarioMan.getText());
                    if (txtHorarioEsp.equals("")) {
                        JOptionPane.showMessageDialog(null, "El campo del horario especial no puede estar vacío");
                        noRealizarBtn = true;
                    } else {
                        daoPed.setHorarioEsp(txtHorarioEsp.getText().toUpperCase());
                    }
                } else if (rbtMaTaNo.isSelected()) {
                    if(chkManana.isSelected()){
                        if(txtHorarioMan.getText().equals("")){
                            txtHorarioMan.setText("0");
                            daoPed.setHorarioMan(txtHorarioMan.getText());
                        }
                        else{
                            daoPed.setHorarioMan(txtHorarioMan.getText());
                        }
                        if(txtHorarioTarde.getText().equals("")){
                            txtHorarioTarde.setText("0");
                            daoPed.setHorarioTarde(txtHorarioTarde.getText());
                        }
                        if(txtHorarioNoche.getText().equals("")){
                            txtHorarioNoche.setText("0");
                            daoPed.setHorarioNoche(txtHorarioNoche.getText());
                        }
                        if(!chkTarde.isSelected()){
                            txtHorarioTarde.setText("0");
                            daoPed.setHorarioTarde(txtHorarioTarde.getText());
                        }
                        if(!chkNoche.isSelected()){
                            txtHorarioNoche.setText("0");
                            daoPed.setHorarioNoche(txtHorarioNoche.getText());
                        }
                    }
                    if(chkTarde.isSelected()){
                        if(txtHorarioTarde.getText().equals("")){
                            txtHorarioTarde.setText("0");
                            daoPed.setHorarioTarde(txtHorarioTarde.getText());
                        }
                        else{
                            daoPed.setHorarioTarde(txtHorarioTarde.getText());
                        }
                        if(txtHorarioMan.getText().equals("")){
                            txtHorarioMan.setText("0");
                            daoPed.setHorarioMan(txtHorarioMan.getText());
                        }
                        if(txtHorarioNoche.getText().equals("")){
                            txtHorarioNoche.setText("0");
                            daoPed.setHorarioNoche(txtHorarioNoche.getText());
                        }
                        if(!chkManana.isSelected()){
                            txtHorarioMan.setText("0");
                            daoPed.setHorarioMan(txtHorarioMan.getText());
                        }
                        if(!chkNoche.isSelected()){
                            txtHorarioNoche.setText("0");
                            daoPed.setHorarioNoche(txtHorarioNoche.getText());
                        }
                    }
                    if(chkNoche.isSelected()){
                        if(txtHorarioNoche.getText().equals("")){
                            txtHorarioNoche.setText("0");
                            daoPed.setHorarioNoche(txtHorarioNoche.getText());
                        }
                        else{
                            daoPed.setHorarioNoche(txtHorarioNoche.getText());
                        }
                        if(txtHorarioMan.getText().equals("")){
                            txtHorarioMan.setText("0");
                            daoPed.setHorarioMan(txtHorarioMan.getText());
                        }
                        if(txtHorarioTarde.getText().equals("")){
                            txtHorarioTarde.setText("0");
                            daoPed.setHorarioTarde(txtHorarioTarde.getText());
                        }
                        if(!chkManana.isSelected()){
                            txtHorarioMan.setText("0");
                            daoPed.setHorarioMan(txtHorarioMan.getText());
                        }
                        if(!chkTarde.isSelected()){
                            txtHorarioTarde.setText("0");
                            daoPed.setHorarioTarde(txtHorarioTarde.getText());
                        }
                    }
                }
                
                if (cmbPaciente.getSelectedItem() == null || cmbMedGen.getSelectedItem() == null || cmbEnfermera.getSelectedItem() == null) {
                    noRealizarBtn = true;
                    JOptionPane.showMessageDialog(null, "Combobox vacio.");
                } else {
                    if(cmbMedPat.getSelectedItem() == null){
                        daoPed.setNombreProductoPat(" ");
                    }
                    else{
                        daoPed.setNombreProductoPat(cmbMedPat.getSelectedItem().toString());
                    }
                    daoPed.setNomPac(cmbPaciente.getSelectedItem().toString());
                    daoPed.setNombreProductoGen(cmbMedGen.getSelectedItem().toString());
                    daoPed.setEnfermera(cmbEnfermera.getSelectedItem().toString());
                    daoPed.detectarIdPaciente();
                    daoPed.detectarIdProd();
                    daoPed.detectarIdEnf();
                }
                try {
                    daoPed.setDosis(Float.parseFloat(txtDosis.getText()));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "El campo de dosis debe ser numérico.");
                    noRealizarBtn = true;
                }
                daoPed.setDescrPedMed(txaDescrPedMed.getText().toUpperCase());
                daoPed.setFechaIngreso(dateIng);
                daoPed.setFechaPedMed(dateMed);
                daoPed.setDepart(cmbDepart.getSelectedItem().toString().toUpperCase());
                daoPed.setDiagnost(txtDiagnost.getText().toUpperCase());

                if (noRealizarBtn == false) {
                    if (daoPed.agregar()) {
                        JOptionPane.showMessageDialog(null, "El nuevo pedido del medicamento fue agregado.");
                        txtIdPedidoMed.setText("");
                        txtHorarioEsp.setText("");
                        txtHorarioMan.setText("");
                        txtHorarioTarde.setText("");
                        txtHorarioNoche.setText("");
                        txaDescrPedMed.setText("");
                        txtDosis.setText("");
                        txtDiagnost.setText("");
                        dchFechaPedMed.setCalendar(null);
                        dchFechaIngreso.setCalendar(null);
                    } else {
                        JOptionPane.showMessageDialog(null, daoPed.getMensaje());
                    }
                }
                noRealizarBtn = false;
            }
        }
    }//GEN-LAST:event_btnAgregarPedActionPerformed

    private void btnModificarPedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPedActionPerformed
        DateFormat fmt = new SimpleDateFormat("yy/MM/dd");
        daoPed.setIdPedidoMed(Integer.parseInt(txtIdPedidoMed.getText()));
        if (dchFechaPedMed.getDate() == null || dchFechaIngreso.getDate() == null) {
            JOptionPane.showMessageDialog(null, "El campo de la fecha no puede estar vacío.");
        } else {
            String dateIng = fmt.format(dchFechaIngreso.getDate());
            String dateMed = fmt.format(dchFechaPedMed.getDate());
            if (txtDosis.getText().equals("") || txtDiagnost.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Campos vacios o incorrectos.");
            } else {
                if (rbtEsp.isSelected()) {
                    txtHorarioMan.setText("0");
                    txtHorarioTarde.setText("0");
                    txtHorarioNoche.setText("0");
                    daoPed.setHorarioMan(txtHorarioMan.getText());
                    daoPed.setHorarioTarde(txtHorarioMan.getText());
                    daoPed.setHorarioNoche(txtHorarioMan.getText());
                    if (txtHorarioEsp.equals("")) {
                        JOptionPane.showMessageDialog(null, "El campo del horario especial no puede estar vacío");
                        noRealizarBtn = true;
                    } else {
                        daoPed.setHorarioEsp(txtHorarioEsp.getText().toUpperCase());
                    }
                } else if (rbtMaTaNo.isSelected()) {
                    if(chkManana.isSelected()){
                        if(txtHorarioMan.getText().equals("")){
                            txtHorarioMan.setText("0");
                            daoPed.setHorarioMan(txtHorarioMan.getText());
                        }
                        else{
                            daoPed.setHorarioMan(txtHorarioMan.getText());
                        }
                        if(txtHorarioTarde.getText().equals("")){
                            txtHorarioTarde.setText("0");
                            daoPed.setHorarioTarde(txtHorarioTarde.getText());
                        }
                        if(txtHorarioNoche.getText().equals("")){
                            txtHorarioNoche.setText("0");
                            daoPed.setHorarioNoche(txtHorarioNoche.getText());
                        }
                        if(!chkTarde.isSelected()){
                            txtHorarioTarde.setText("0");
                            daoPed.setHorarioTarde(txtHorarioTarde.getText());
                        }
                        if(!chkNoche.isSelected()){
                            txtHorarioNoche.setText("0");
                            daoPed.setHorarioNoche(txtHorarioNoche.getText());
                        }
                    }
                    if(chkTarde.isSelected()){
                        if(txtHorarioTarde.getText().equals("")){
                            txtHorarioTarde.setText("0");
                            daoPed.setHorarioTarde(txtHorarioTarde.getText());
                        }
                        else{
                            daoPed.setHorarioTarde(txtHorarioTarde.getText());
                        }
                        if(txtHorarioMan.getText().equals("")){
                            txtHorarioMan.setText("0");
                            daoPed.setHorarioMan(txtHorarioMan.getText());
                        }
                        if(txtHorarioNoche.getText().equals("")){
                            txtHorarioNoche.setText("0");
                            daoPed.setHorarioNoche(txtHorarioNoche.getText());
                        }
                        if(!chkManana.isSelected()){
                            txtHorarioMan.setText("0");
                            daoPed.setHorarioMan(txtHorarioMan.getText());
                        }
                        if(!chkNoche.isSelected()){
                            txtHorarioNoche.setText("0");
                            daoPed.setHorarioNoche(txtHorarioNoche.getText());
                        }
                    }
                    if(chkNoche.isSelected()){
                        if(txtHorarioNoche.getText().equals("")){
                            txtHorarioNoche.setText("0");
                            daoPed.setHorarioNoche(txtHorarioNoche.getText());
                        }
                        else{
                            daoPed.setHorarioNoche(txtHorarioNoche.getText());
                        }
                        if(txtHorarioMan.getText().equals("")){
                            txtHorarioMan.setText("0");
                            daoPed.setHorarioMan(txtHorarioMan.getText());
                        }
                        if(txtHorarioTarde.getText().equals("")){
                            txtHorarioTarde.setText("0");
                            daoPed.setHorarioTarde(txtHorarioTarde.getText());
                        }
                        if(!chkManana.isSelected()){
                            txtHorarioMan.setText("0");
                            daoPed.setHorarioMan(txtHorarioMan.getText());
                        }
                        if(!chkTarde.isSelected()){
                            txtHorarioTarde.setText("0");
                            daoPed.setHorarioTarde(txtHorarioTarde.getText());
                        }
                    }
                }
                
                if (cmbPaciente.getSelectedItem() == null || cmbMedGen.getSelectedItem() == null || cmbEnfermera.getSelectedItem() == null) {
                    noRealizarBtn = true;
                    JOptionPane.showMessageDialog(null, "Combobox vacio.");

                } else {
                    if(cmbMedPat.getSelectedItem() == null){
                        daoPed.setNombreProductoPat(" ");
                    }
                    else{
                        daoPed.setNombreProductoPat(cmbMedPat.getSelectedItem().toString());
                    }
                    daoPed.setNomPac(cmbPaciente.getSelectedItem().toString());
                    daoPed.setNombreProductoGen(cmbMedGen.getSelectedItem().toString());
                    daoPed.setEnfermera(cmbEnfermera.getSelectedItem().toString());
                    daoPed.detectarIdEnf();
                    daoPed.detectarIdPaciente();
                    daoPed.detectarIdProd();
                }
                try {
                    daoPed.setDosis(Float.parseFloat(txtDosis.getText()));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "El campo de dosis debe ser numérico.");
                    noRealizarBtn = true;
                }
                daoPed.setDescrPedMed(txaDescrPedMed.getText().toUpperCase());
                daoPed.setFechaIngreso(dateIng);
                daoPed.setFechaPedMed(dateMed);
                daoPed.setDepart(cmbDepart.getSelectedItem().toString().toUpperCase());
                daoPed.setDiagnost(txtDiagnost.getText().toUpperCase());

                if (noRealizarBtn == false) {
                    if (daoPed.modificar()) {
                        JOptionPane.showMessageDialog(null, "El pedido del medicamento fue modificado.");
                        txtIdPedidoMed.setText("");
                        txtHorarioEsp.setText("");
                        txtHorarioMan.setText("");
                        txtHorarioTarde.setText("");
                        txtHorarioNoche.setText("");
                        txaDescrPedMed.setText("");
                        txtDosis.setText("");
                        txtDiagnost.setText("");
                        dchFechaPedMed.setCalendar(null);
                        dchFechaIngreso.setCalendar(null);
                        btnAgregarPed.setEnabled(true);
                        btnModificarPed.setEnabled(false);
                        btnEliminarPed.setEnabled(false);
                    } else {
                        JOptionPane.showMessageDialog(null, daoPed.getMensaje());
                    }
                }
                noRealizarBtn = false;
            }
        }
    }//GEN-LAST:event_btnModificarPedActionPerformed

    private void btnEliminarPedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPedActionPerformed
        daoPed.setIdPedidoMed(Integer.parseInt(txtIdPedidoMed.getText()));
        daoPed.eliminar();
        JOptionPane.showMessageDialog(null,"El pedido fue eliminado.");
        txtIdPedidoMed.setEnabled(true);
        txtIdPedidoMed.setText("");
        txtHorarioEsp.setText("");
        txtHorarioMan.setText("");
        txtHorarioTarde.setText("");
        txtHorarioNoche.setText("");
        txaDescrPedMed.setText("");
        txtDosis.setText("");
        txtDiagnost.setText("");
        dchFechaPedMed.setCalendar(null);
        btnModificarPed.setEnabled(false);
        btnEliminarPed.setEnabled(false);
        btnAgregarPed.setEnabled(true);
    }//GEN-LAST:event_btnEliminarPedActionPerformed

    private void rbtEspItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbtEspItemStateChanged
        if (rbtEsp.isSelected()) {
            chkManana.setEnabled(false);
            chkTarde.setEnabled(false);
            chkNoche.setEnabled(false);
            txtHorarioEsp.setEnabled(true);
            rbtMaTaNo.setSelected(false);
        }

    }//GEN-LAST:event_rbtEspItemStateChanged

    private void rbtMaTaNoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbtMaTaNoItemStateChanged
        if (rbtMaTaNo.isSelected()) {
            chkManana.setEnabled(true);
            chkTarde.setEnabled(true);
            chkNoche.setEnabled(true);
            txtHorarioEsp.setEnabled(false);
            rbtEsp.setSelected(false);
        }

    }//GEN-LAST:event_rbtMaTaNoItemStateChanged

    private void cmbPacienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPacienteItemStateChanged
        if(cmbPaciente.getSelectedItem() != null){
            daoPed.setNomPac(cmbPaciente.getSelectedItem().toString());
            daoPed.detectarIdPaciente();
        }
        MostrarInfoPac();
        txtEdad.setText(String.valueOf(edad));
    }//GEN-LAST:event_cmbPacienteItemStateChanged

    private void cmbPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPacienteActionPerformed

    }//GEN-LAST:event_cmbPacienteActionPerformed

    private void cmbMedPatItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMedPatItemStateChanged
        if(cmbMedGen.getSelectedItem() != null && cmbMedPat.getSelectedItem() != null){
            daoPed.setNombreProductoGen(cmbMedGen.getSelectedItem().toString());
            daoPed.setNombreProductoPat(cmbMedPat.getSelectedItem().toString());
            daoPed.detectarIdProd();
        }
        MostrarInfoMed();
        txtAdministracion.setText(administracion);
        txtContenidoCaja.setText(contenidoCaja);
    }//GEN-LAST:event_cmbMedPatItemStateChanged

    private void cmbMedPatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMedPatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMedPatActionPerformed

    private void btnListaPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaPedidosActionPerformed
        dispose();
        listPedMed.setVisible(true);
        daoPed.getTmodel().setColumnCount(0);
        daoPed.getTmodel().setRowCount(0);
        daoPed.listar();
        listPedMed.tblPedMed.setModel(daoPed.getTmodel());
    }//GEN-LAST:event_btnListaPedidosActionPerformed

    private void chkMananaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkMananaItemStateChanged
        if (chkManana.isSelected()) {
            txtHorarioMan.setEnabled(true);
        } else {
            txtHorarioMan.setEnabled(false);
        }
    }//GEN-LAST:event_chkMananaItemStateChanged

    private void chkTardeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkTardeItemStateChanged
        if (chkTarde.isSelected()) {
            txtHorarioTarde.setEnabled(true);
        } else {
            txtHorarioTarde.setEnabled(false);
        }

    }//GEN-LAST:event_chkTardeItemStateChanged

    private void chkNocheItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkNocheItemStateChanged
        if (chkNoche.isSelected()) {
            txtHorarioNoche.setEnabled(true);
        } else {
            txtHorarioNoche.setEnabled(false);
        }
    }//GEN-LAST:event_chkNocheItemStateChanged

    private void btnListCantPedMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListCantPedMedActionPerformed
        dispose();
        listGrup.setVisible(true);
        daoPed.getTmodel().setColumnCount(0);
        daoPed.getTmodel().setRowCount(0);
        daoPed.listarCantidadPed();
        listGrup.tblListGrup.setModel(daoPed.getTmodel());

    }//GEN-LAST:event_btnListCantPedMedActionPerformed

    private void cmbMedGenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMedGenItemStateChanged
        cmbMedPat.removeAllItems();
        cargaComboMedPat();
    }//GEN-LAST:event_cmbMedGenItemStateChanged

    private void cmbMedGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMedGenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMedGenActionPerformed

    private void txtCmbFiltPacKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCmbFiltPacKeyReleased
        daoPed.setNomPac(txtCmbFiltPac.getText() + "%");
        cmbPaciente.removeAllItems();
        cargaComboPaciente();
    }//GEN-LAST:event_txtCmbFiltPacKeyReleased

    private void txtCmbFiltMedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCmbFiltMedKeyReleased
        daoPed.setNombreProductoGen(txtCmbFiltMed.getText() + "%");
        cmbMedGen.removeAllItems();
        cargaComboMedGen();
    }//GEN-LAST:event_txtCmbFiltMedKeyReleased

    private void txtCmbFiltMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCmbFiltMedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCmbFiltMedActionPerformed

    private void cmbEnfermeraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEnfermeraItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEnfermeraItemStateChanged

    private void cmbEnfermeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEnfermeraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEnfermeraActionPerformed

    private void txtCmbFiltEnfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCmbFiltEnfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCmbFiltEnfActionPerformed

    private void txtCmbFiltEnfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCmbFiltEnfKeyReleased
        daoPed.setEnfermera(txtCmbFiltEnf.getText() + "%");
        cmbEnfermera.removeAllItems();
        cargaComboEnfermera();
    }//GEN-LAST:event_txtCmbFiltEnfKeyReleased

    private void btnListMedSemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListMedSemActionPerformed
        dispose();
        listSem.setVisible(true);
        daoPed.getTmodel().setColumnCount(0);
        daoPed.getTmodel().setRowCount(0);
        daoPed.listarMedSem();
        listSem.tblListMedSem.setModel(daoPed.getTmodel());
    }//GEN-LAST:event_btnListMedSemActionPerformed

    private void chkNocheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkNocheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkNocheActionPerformed

    private void cmbDepartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDepartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDepartActionPerformed

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
            java.util.logging.Logger.getLogger(frmPedMed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPedMed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPedMed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPedMed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPedMed().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregarPed;
    public javax.swing.JButton btnEliminarPed;
    private javax.swing.JButton btnListCantPedMed;
    private javax.swing.JButton btnListMedSem;
    private javax.swing.JButton btnListaPedidos;
    public javax.swing.JButton btnModificarPed;
    private javax.swing.JButton btnRegresarPed;
    private javax.swing.JCheckBox chkManana;
    private javax.swing.JCheckBox chkNoche;
    private javax.swing.JCheckBox chkTarde;
    public javax.swing.JComboBox<String> cmbDepart;
    public javax.swing.JComboBox cmbEnfermera;
    public javax.swing.JComboBox cmbMedGen;
    public javax.swing.JComboBox cmbMedPat;
    public javax.swing.JComboBox cmbPaciente;
    public com.toedter.calendar.JDateChooser dchFechaIngreso;
    public com.toedter.calendar.JDateChooser dchFechaPedMed;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdministracion;
    private javax.swing.JLabel lblBuscModEl;
    private javax.swing.JLabel lblCmbFiltMed;
    private javax.swing.JLabel lblCmbFiltPac;
    private javax.swing.JLabel lblContenidoCaja;
    private javax.swing.JLabel lblDescr;
    private javax.swing.JLabel lblDiagnost;
    private javax.swing.JLabel lblDosis;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblEnfermera;
    private javax.swing.JLabel lblFechaIngreso;
    private javax.swing.JLabel lblFechaPedMed;
    private javax.swing.JLabel lblFiltEnf;
    private javax.swing.JLabel lblFondoVerde;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblIdApunte;
    private javax.swing.JLabel lblMed1;
    private javax.swing.JLabel lblMedPat;
    private javax.swing.JLabel lblPaciente;
    private javax.swing.JLabel lblPedMed;
    private javax.swing.JRadioButton rbtEsp;
    private javax.swing.JRadioButton rbtMaTaNo;
    public javax.swing.JTextArea txaDescrPedMed;
    private javax.swing.JTextField txtAdministracion;
    private javax.swing.JTextField txtCmbFiltEnf;
    public javax.swing.JTextField txtCmbFiltMed;
    public javax.swing.JTextField txtCmbFiltPac;
    private javax.swing.JTextField txtContenidoCaja;
    private javax.swing.JLabel txtDepart;
    public javax.swing.JTextField txtDiagnost;
    public javax.swing.JTextField txtDosis;
    private javax.swing.JTextField txtEdad;
    public javax.swing.JTextField txtHorarioEsp;
    public javax.swing.JTextField txtHorarioMan;
    public javax.swing.JTextField txtHorarioNoche;
    public javax.swing.JTextField txtHorarioTarde;
    public javax.swing.JTextField txtIdPedidoMed;
    // End of variables declaration//GEN-END:variables
}
