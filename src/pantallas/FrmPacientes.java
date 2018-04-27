/*
 * Titulo: Panatalla 1 Módulo paciente.
 * Este programa se realizó para la organización "La sagrada familia A.C".
 * Esta panatalla consiste en el registro,modificacion , busqueda y eliminacion de pacientes.
 * Fecha: 28/01/2017
 */
//package Pantallas;
package pantallas;

import clases.ComboItem;
import clases.DAOPacientes;
import clases.Estado;
import clases.Municipio;
import clases.Pacientes;
import clases.Reportes;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.color.ColorSpace;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 * @author Pablo Alberto Rodirguez Lopez.
 * @author Jose Luis Tinajero Carvajal.
 * @author ,Modificado por: Tomas Alejandro Vargas Lopez.
 */
public class FrmPacientes extends javax.swing.JFrame {

    DAOPacientes DaoPaciente = new DAOPacientes();
    Pacientes paciente = new Pacientes();
    Estado es = new Estado();
    Municipio mun = new Municipio();
    Color colorTitulo = new Color(150, 0, 12);
    Font fntTitulo = new Font("Tahoma", Font.BOLD, 24);
    Font fntComponente = new Font("Tahoma", Font.BOLD, 14);
    Dimension dmsBoton = new Dimension(120, 40);

    /**
     * Creates new form Pacientes
     */
    public FrmPacientes() {
        initComponents();
        cargaCmbEstadoCivil();
        cargaCmbHabitacion();
        cargaCmbTpPaciente();
        cargaCmbSeguros();
        cargaCmbTpSangre();
        cargarEstadoNac();
        cargarEstadoProce();
//        cargarMunicipioNac();
//        cargarMunicipioProce();
        cargaCmbFiltrado();
        skin();
    }

    private void cargaCmbSeguros() {
        cmbSeguro.removeAllItems();
        cmbSeguro.addItem("ISSSTE");
        cmbSeguro.addItem("IMSS");
        cmbSeguro.addItem("SP");
        cmbSeguro.addItem(" ");
    }

    private void skin() {
        lblApMat.setText(lblApMat.getText().toUpperCase());
        lblApPat.setText(lblApPat.getText().toUpperCase());
        lblFiltro.setText(lblFiltro.getText().toUpperCase());
        lblAlergias.setText(lblAlergias.getText().toUpperCase());
        lblArea.setText(lblArea.getText().toUpperCase());
        lblDiagnostico.setText(lblDiagnostico.getText().toUpperCase());
        lblEstadoCivil.setText(lblEstadoCivil.getText().toUpperCase());
        lblEstadoNac.setText(lblEstadoNac.getText().toUpperCase());
        lblEstadoProce.setText(lblEstadoProce.getText().toUpperCase());
        lblFechaNac.setText(lblFechaNac.getText().toUpperCase());
        lblFechaNac1.setText(lblFechaNac1.getText().toUpperCase());
        lblFechaNac2.setText(lblFechaNac2.getText().toUpperCase());
        lblId.setText(lblId.getText().toUpperCase());
        lblMunicipioNac.setText(lblMunicipioNac.getText().toUpperCase());
        lblMunicipioProce.setText(lblMunicipioProce.getText().toUpperCase());
        lblNoExpediente.setText(lblNoExpediente.getText().toUpperCase());
        lblTel.setText(lblTel.getText().toUpperCase());
        lblNombre.setText(lblNombre.getText().toUpperCase());
        lblTitulo.setText(lblTitulo.getText().toUpperCase());
        lblTpPaciente.setText(lblTpPaciente.getText().toUpperCase());
        lblTpSangre.setText(lblTpSangre.getText().toUpperCase());
        chkActaIfe.setText(chkActaIfe.getText().toUpperCase());
        //chkSeguro.setText(chkSeguro.getText().toUpperCase());
        btnAceptar.setText(btnAceptar.getText().toUpperCase());
        btnBuscar.setText(btnBuscar.getText().toUpperCase());
        btnEliminar.setText(btnEliminar.getText().toUpperCase());
        btnModificar.setText(btnModificar.getText().toUpperCase());
        btnListar.setText(btnListar.getText().toUpperCase());
//        txtComponente      
    }

    private void cargaCmbEstadoCivil() {
        cmbEstadoCivil.removeAllItems();
        cmbEstadoCivil.addItem("Casada");
        cmbEstadoCivil.addItem("Viuda");
        cmbEstadoCivil.addItem("Soltera");
        cmbEstadoCivil.addItem("Union libre");
        cmbEstadoCivil.addItem("Se desconoce ");

    }

    private void cargaCmbHabitacion() {
        cmbArea.removeAllItems();
        cmbArea.addItem("San José");
        cmbArea.addItem("Cesarita");
        cmbArea.addItem("Nazaret");
        cmbArea.addItem("Corazón de Jesús");
        cmbArea.addItem("Sagrada Familia");
        cmbArea.addItem("Vilaseca");
    }

    private void cargaCmbTpPaciente() {
        cmbTpPaciente.removeAllItems();
        cmbTpPaciente.addItem("Geriatría");
        cmbTpPaciente.addItem("Psquiatría");
        cmbTpPaciente.addItem("Geriatría y psquiatría");
    }

    private void cargaCmbTpSangre() {
        cmbTpSangre.removeAllItems();
        cmbTpSangre.addItem("A+");
        cmbTpSangre.addItem("A-");
        cmbTpSangre.addItem("B+");
        cmbTpSangre.addItem("B-");
        cmbTpSangre.addItem("AB+");
        cmbTpSangre.addItem("AB-");
        cmbTpSangre.addItem("O+");
        cmbTpSangre.addItem("O-");
        cmbTpSangre.addItem(" ");
    }

    private void cargarEstadoNac() {
        cmbEstadoNac.removeAllItems();
        for (int i = 0; i < es.Listar().length; i++) {
            cmbEstadoNac.addItem(es.Listar()[i][2]);
        }
    }
//
//    private void cargarMunicipioNac() {
//        try {
//            String estado = cmbEstadoNac.getSelectedItem().toString();
//            cmbMunicipioNac.removeAllItems();
//            for (int i = 0; i < mun.Listar(estado).length; i++) {
//                cmbMunicipioNac.addItem(mun.Listar(estado)[i][3]);
//            }
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//    }

    private void cargarEstadoProce() {
        cmbEstadoProce.removeAllItems();
        for (int i = 0; i < es.Listar().length; i++) {
            cmbEstadoProce.addItem(es.Listar()[i][2]);
        }
    }

//    private void cargarMunicipioProce() {
//        try {
//            String estado = cmbEstadoProce.getSelectedItem().toString();
//            cmbMunicipioProce.removeAllItems();
//            for (int i = 0; i < mun.Listar(estado).length; i++) {
//                cmbMunicipioProce.addItem(mun.Listar(estado)[i][3]);
//            }
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
    private void LimpiarCampos() {
        txtIdPaciente.setText("");
        txtNoExpediente.setText("");
        txtNombre.setText("");
        txtApPat.setText("");
        txtApMat.setText("");
        txtAnioNac.setText("");
        txtDiaNac.setText("");
        txtMesNac.setText("");
        //txtFiltroPacientes.setText("");
        txtTel.setText("");
        txaAlergias.setText("");
        txaDiagnostico.setText("");
        txtMunicipioNac.setText("");
        txtMunicipioProce.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        pnlDatos = new javax.swing.JPanel();
        txtApPat = new javax.swing.JTextField();
        txtApMat = new javax.swing.JTextField();
        sep1 = new javax.swing.JSeparator();
        cmbTpPaciente = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();
        txtIdPaciente = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApPat = new javax.swing.JLabel();
        lblApMat = new javax.swing.JLabel();
        sep3 = new javax.swing.JSeparator();
        lblTitulo = new javax.swing.JLabel();
        lblEstadoCivil = new javax.swing.JLabel();
        sep2 = new javax.swing.JSeparator();
        lblTpPaciente = new javax.swing.JLabel();
        lblArea = new javax.swing.JLabel();
        cmbArea = new javax.swing.JComboBox<>();
        chkActaIfe = new javax.swing.JCheckBox();
        lblNoExpediente = new javax.swing.JLabel();
        txtNoExpediente = new javax.swing.JTextField();
        cmbEstadoCivil = new javax.swing.JComboBox();
        btnAceptar = new javax.swing.JButton();
        lblTpSangre = new javax.swing.JLabel();
        cmbTpSangre = new javax.swing.JComboBox();
        lblDiagnostico = new javax.swing.JLabel();
        lblAlergias = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaDiagnostico = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaAlergias = new javax.swing.JTextArea();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        lblTel = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        btnListar = new javax.swing.JButton();
        lblMunicipioNac = new javax.swing.JLabel();
        lblEstadoNac = new javax.swing.JLabel();
        lblMunicipioProce = new javax.swing.JLabel();
        lblEstadoProce = new javax.swing.JLabel();
        cmbEstadoNac = new javax.swing.JComboBox<>();
        cmbEstadoProce = new javax.swing.JComboBox<>();
        txtDiaNac = new javax.swing.JTextField();
        txtMesNac = new javax.swing.JTextField();
        txtAnioNac = new javax.swing.JTextField();
        lblFechaNac1 = new javax.swing.JLabel();
        lblFechaNac2 = new javax.swing.JLabel();
        lblFechaNac = new javax.swing.JLabel();
        cmbFiltradoPacientes = new javax.swing.JComboBox();
        txtFiltroPacientes = new javax.swing.JTextField();
        lblFiltro = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPacientes = new javax.swing.JTable();
        txtMunicipioNac = new javax.swing.JTextField();
        txtMunicipioProce = new javax.swing.JTextField();
        cmbSeguro = new javax.swing.JComboBox();
        lblEstadoCivil1 = new javax.swing.JLabel();
        mbrPrincipal = new javax.swing.JMenuBar();
        mn1 = new javax.swing.JMenu();
        mitHistorial1 = new javax.swing.JMenuItem();
        mitResponsables = new javax.swing.JMenuItem();
        mitPacientes = new javax.swing.JMenuItem();
        mitReporte = new javax.swing.JMenuItem();
        sep5 = new javax.swing.JPopupMenu.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(198, 253, 188));

        pnlBackground.setBackground(new java.awt.Color(198, 253, 188));

        pnlDatos.setBackground(new java.awt.Color(198, 253, 188));

        txtApPat.setFont(fntComponente);
        txtApPat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApPatKeyReleased(evt);
            }
        });

        txtApMat.setFont(fntComponente);
        txtApMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApMatActionPerformed(evt);
            }
        });
        txtApMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApMatKeyReleased(evt);
            }
        });

        cmbTpPaciente.setFont(fntComponente);
        cmbTpPaciente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtNombre.setFont(fntComponente);
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        txtIdPaciente.setFont(fntComponente);
        txtIdPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdPacienteActionPerformed(evt);
            }
        });

        lblId.setFont(fntComponente);
        lblId.setText("No. Progresivo:");

        lblNombre.setFont(fntComponente);
        lblNombre.setText("Nombre(s):");

        lblApPat.setFont(fntComponente);
        lblApPat.setText("Apellido Paterno:");

        lblApMat.setFont(fntComponente);
        lblApMat.setText("Apellido Materno:");

        lblTitulo.setFont(fntTitulo);
        lblTitulo.setText("Datos del paciente");

        lblEstadoCivil.setFont(fntComponente);
        lblEstadoCivil.setText("Estado Civil:");

        lblTpPaciente.setFont(fntComponente);
        lblTpPaciente.setText("Tipo paciente:");

        lblArea.setFont(fntComponente);
        lblArea.setText("Depto:");

        cmbArea.setFont(fntComponente);
        cmbArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        chkActaIfe.setFont(fntComponente);
        chkActaIfe.setText("Acta/IFE");
        chkActaIfe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkActaIfeActionPerformed(evt);
            }
        });

        lblNoExpediente.setFont(fntComponente);
        lblNoExpediente.setText("No.Expediente:");

        txtNoExpediente.setFont(fntComponente);

        cmbEstadoCivil.setFont(fntComponente);
        cmbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAceptar.setFont(fntComponente);
        btnAceptar.setText("Agregar");
        btnAceptar.setToolTipText("");
        btnAceptar.setMaximumSize(new java.awt.Dimension(71, 40));
        btnAceptar.setMinimumSize(new java.awt.Dimension(71, 40));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        lblTpSangre.setFont(fntComponente);
        lblTpSangre.setText("Tipo de sangre:");

        cmbTpSangre.setFont(fntComponente);
        cmbTpSangre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblDiagnostico.setFont(fntComponente);
        lblDiagnostico.setText("Diágnostico Inicial:");

        lblAlergias.setFont(fntComponente);
        lblAlergias.setText("Alergias:");

        txaDiagnostico.setColumns(20);
        txaDiagnostico.setFont(fntComponente);
        txaDiagnostico.setRows(5);
        txaDiagnostico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaDiagnosticoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txaDiagnostico);

        txaAlergias.setColumns(20);
        txaAlergias.setFont(fntComponente);
        txaAlergias.setRows(5);
        txaAlergias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaAlergiasKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txaAlergias);

        btnBuscar.setFont(fntComponente);
        btnBuscar.setText("Buscar");
        btnBuscar.setMaximumSize(dmsBoton);
        btnBuscar.setPreferredSize(dmsBoton);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(fntComponente);
        btnEliminar.setText("Eliminar");
        btnEliminar.setMaximumSize(dmsBoton);
        btnEliminar.setPreferredSize(dmsBoton);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setFont(fntComponente);
        btnModificar.setText("Modificar");
        btnModificar.setMaximumSize(dmsBoton);
        btnModificar.setPreferredSize(dmsBoton);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        lblTel.setFont(fntComponente);
        lblTel.setText("Telefono:");

        txtTel.setFont(fntComponente);

        btnListar.setFont(fntComponente);
        btnListar.setText("Listar");
        btnListar.setMaximumSize(dmsBoton);
        btnListar.setPreferredSize(dmsBoton);
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        lblMunicipioNac.setFont(fntComponente);
        lblMunicipioNac.setText("Municipo Nacimiento:");

        lblEstadoNac.setFont(fntComponente);
        lblEstadoNac.setText("Estado Nacimiento:");

        lblMunicipioProce.setFont(fntComponente);
        lblMunicipioProce.setText("Municipio Procedencia:");

        lblEstadoProce.setFont(fntComponente);
        lblEstadoProce.setText("Estado Procedencia:");

        cmbEstadoNac.setFont(fntComponente);
        cmbEstadoNac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbEstadoNac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoNacActionPerformed(evt);
            }
        });

        cmbEstadoProce.setFont(fntComponente);
        cmbEstadoProce.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbEstadoProce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoProceActionPerformed(evt);
            }
        });

        txtDiaNac.setFont(fntComponente);

        txtMesNac.setFont(fntComponente);

        txtAnioNac.setFont(fntComponente);

        lblFechaNac1.setText("/");

        lblFechaNac2.setText("/");

        lblFechaNac.setFont(fntComponente);
        lblFechaNac.setText("Fecha de nacimiento:");

        cmbFiltradoPacientes.setFont(fntComponente);
        cmbFiltradoPacientes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtFiltroPacientes.setFont(fntComponente);
        txtFiltroPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroPacientesActionPerformed(evt);
            }
        });
        txtFiltroPacientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroPacientesKeyReleased(evt);
            }
        });

        lblFiltro.setFont(fntComponente);
        lblFiltro.setText("Filtro: ");

        tblPacientes.setFont(fntComponente);
        tblPacientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPacientesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPacientes);

        txtMunicipioNac.setFont(fntComponente);
        txtMunicipioNac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMunicipioNacKeyReleased(evt);
            }
        });

        txtMunicipioProce.setFont(fntComponente);
        txtMunicipioProce.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMunicipioProceKeyReleased(evt);
            }
        });

        cmbSeguro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblEstadoCivil1.setFont(fntComponente);
        lblEstadoCivil1.setText("Seguro:");

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addComponent(sep3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(sep2)
            .addComponent(sep1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                .addGap(436, 436, 436)
                .addComponent(lblTitulo)
                .addGap(444, 444, 444))
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(323, 323, 323)
                        .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlDatosLayout.createSequentialGroup()
                                            .addComponent(lblFiltro)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtFiltroPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(234, 234, 234))
                                        .addComponent(cmbFiltradoPacientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlDatosLayout.createSequentialGroup()
                                        .addComponent(lblId)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblNoExpediente)
                                        .addGap(17, 17, 17)
                                        .addComponent(txtNoExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addComponent(lblNombre)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblApPat)
                                .addGap(18, 18, 18)
                                .addComponent(txtApPat, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblApMat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtApMat, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(lblTpSangre)
                        .addGap(0, 0, 0)
                        .addComponent(cmbTpSangre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lblArea)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(lblTpPaciente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTpPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblFechaNac)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDiaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFechaNac1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMesNac, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFechaNac2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAnioNac, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(lblEstadoCivil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblEstadoCivil1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEstadoNac)
                                    .addComponent(lblEstadoProce))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbEstadoNac, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbEstadoProce, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlDatosLayout.createSequentialGroup()
                                        .addComponent(lblMunicipioNac)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtMunicipioNac))
                                    .addGroup(pnlDatosLayout.createSequentialGroup()
                                        .addComponent(lblMunicipioProce)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtMunicipioProce, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addComponent(chkActaIfe)
                        .addGap(18, 18, 18)
                        .addComponent(lblTel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lblAlergias)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(lblDiagnostico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFiltro)
                            .addComponent(txtFiltroPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbFiltradoPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblId)
                            .addComponent(txtIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNoExpediente)
                            .addComponent(txtNoExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblApPat)
                            .addComponent(txtApPat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblApMat)
                            .addComponent(txtApMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(sep1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEstadoCivil)
                            .addComponent(cmbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkActaIfe)
                            .addComponent(lblFechaNac)
                            .addComponent(txtDiaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAnioNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMesNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFechaNac1)
                            .addComponent(lblFechaNac2)
                            .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTel)
                            .addComponent(cmbSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEstadoCivil1))
                        .addGap(19, 19, 19)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbEstadoNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMunicipioNac)
                            .addComponent(txtMunicipioNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblEstadoNac, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(24, 24, 24)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstadoProce)
                    .addComponent(cmbEstadoProce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMunicipioProce)
                    .addComponent(txtMunicipioProce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(sep2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTpSangre)
                            .addComponent(cmbTpSangre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblArea)
                            .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTpPaciente)
                            .addComponent(cmbTpPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                                .addComponent(lblDiagnostico)
                                .addGap(51, 51, 51))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)))
                        .addComponent(sep3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(lblAlergias)
                        .addGap(93, 93, 93)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mn1.setText("Menú Principal");

        mitHistorial1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.SHIFT_MASK));
        mitHistorial1.setText("Historial de salidas y entradas");
        mitHistorial1.setActionCommand("Historial Medico");
        mitHistorial1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitHistorial1ActionPerformed(evt);
            }
        });
        mn1.add(mitHistorial1);

        mitResponsables.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        mitResponsables.setText("Responsables de Pacientes");
        mitResponsables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitResponsablesActionPerformed(evt);
            }
        });
        mn1.add(mitResponsables);

        mitPacientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        mitPacientes.setText("Pacientes");
        mitPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitPacientesActionPerformed(evt);
            }
        });
        mn1.add(mitPacientes);

        mitReporte.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mitReporte.setText("Crear Reporte");
        mitReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitReporteActionPerformed(evt);
            }
        });
        mn1.add(mitReporte);
        mn1.add(sep5);

        mbrPrincipal.add(mn1);

        setJMenuBar(mbrPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtApMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApMatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApMatActionPerformed

    private void txtIdPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdPacienteActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (!txtNoExpediente.getText().isEmpty()) {
            if (!txtNombre.getText().isEmpty()) {
                if (!txtApPat.getText().isEmpty()) {
                    if (!txtApPat.getText().isEmpty()) {
                        if (!txtDiaNac.getText().isEmpty()) {
                            if (!txtMesNac.getText().isEmpty()) {
                                if (!txtAnioNac.getText().isEmpty()) {
                                    Pacientes pac = new Pacientes();
                                    DAOPacientes dPac = new DAOPacientes();
                                    pac.setTel(txtTel.getText());
                                    pac.setNombre(txtNombre.getText());
                                    pac.setApPat(txtApPat.getText());
                                    pac.setApMat(txtApMat.getText());
                                    pac.setNoExpediente(Integer.parseInt(txtNoExpediente.getText()));
                                    if (chkActaIfe.isSelected()) {
                                        pac.setActaIfe('1');
                                    } else {
                                        pac.setActaIfe('0');
                                    }
                                    pac.setEstadoCivil(cmbEstadoCivil.getSelectedItem().toString());
                                    pac.setFechaNac(txtAnioNac.getText() + "-" + txtMesNac.getText() + "-" + txtDiaNac.getText());
                                    pac.setEstadoProcedencia(cmbEstadoProce.getSelectedItem().toString());
                                    pac.setMunicipioProcedencia(txtMunicipioProce.getText());
                                    pac.setSeguro(cmbSeguro.getSelectedItem().toString());
                                    pac.setEstadoOrigen(cmbEstadoNac.getSelectedItem().toString());
                                    pac.setMunicipioOrigen(txtMunicipioNac.getText());
                                    pac.setTpPaciente(cmbTpPaciente.getSelectedItem().toString());
                                    pac.setAreas(cmbArea.getSelectedItem().toString());
                                    pac.setTpSangre(cmbTpSangre.getSelectedItem().toString());
                                    pac.setAlergias(txaAlergias.getText());
                                    pac.setDiagnostico(txaDiagnostico.getText());
                                    dPac.setPaciente(pac);
                                    if (dPac.agregar()) {
                                        JOptionPane.showMessageDialog(rootPane, "Registro guardado");
                                        LimpiarCampos();
                                        btnListar.doClick();
                                    } else {
                                        JOptionPane.showMessageDialog(rootPane, "No se inserto");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(this, "ERROR: Faltó el año de nacimiento.");
                                }

                            } else {
                                JOptionPane.showMessageDialog(this, "ERROR: Faltó el mes de nacimiento.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "ERROR: Faltó el día de nacimiento.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "ERROR: Faltó el apellido materno.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "ERROR: Faltó el apellido paterno.");
                }

            } else {
                JOptionPane.showMessageDialog(this, "ERROR: Faltó el Nombre de paciente.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "ERROR: Faltó el No. de Expediente.");
        }


    }//GEN-LAST:event_btnAceptarActionPerformed
    public void llenaCamposDAO(DAOPacientes dPac) {
        String[] fechaTiempo;
        String[] fecha;
        cmbSeguro.setSelectedItem(dPac.getSeguro());
        if (dPac.getActaIfe() == '1') {
            chkActaIfe.setSelected(true);
        } else {
            chkActaIfe.setSelected(false);
        }
        cmbTpPaciente.setSelectedItem(dPac.getTpPaciente());
        cmbArea.setSelectedItem(dPac.getAreas());
        cmbEstadoCivil.setSelectedItem(dPac.getEstadoCivil());
        //cmbTpPaciente.setSelectedItem(dPac.getTpPaciente());
        cmbTpSangre.setSelectedItem(dPac.getTpSangre());
        txtNombre.setText(dPac.getNombre());
        txtApPat.setText(dPac.getApPat());
        txtApMat.setText(dPac.getApMat());
        txtNoExpediente.setText("" + dPac.getNoExpediente());
        txaAlergias.setText(dPac.getAlergias());
        txaDiagnostico.setText(dPac.getDiagnostico());
        txtTel.setText(dPac.getTel());
        fechaTiempo = dPac.getFechaNac().split(" ");
        fecha = fechaTiempo[0].split("-");
        txtDiaNac.setText(fecha[2]);
        txtMesNac.setText(fecha[1]);
        txtAnioNac.setText(fecha[0]);
        cmbEstadoNac.setSelectedItem(dPac.getEstadoOrigen());
        txtMunicipioNac.setText(dPac.getMunicipioOrigen());
        cmbEstadoProce.setSelectedItem(dPac.getEstadoProcedencia());
        txtMunicipioProce.setText(dPac.getMunicipioProcedencia());
        txtIdPaciente.setText(""+dPac.getIdPaciente());
    }
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        ComboItem ci = (ComboItem) cmbFiltradoPacientes.getSelectedItem();
        DAOPacientes dPac = new DAOPacientes();
        System.out.println(ci.getId());
        dPac.setIdPaciente(ci.getId());
        dPac.buscar();
        llenaCamposDAO(dPac);

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        ComboItem ci = (ComboItem) cmbFiltradoPacientes.getSelectedItem();
        DAOPacientes dPac = new DAOPacientes();
        System.out.println(ci.getId());
        dPac.setIdPaciente(ci.getId());
        if (dPac.eliminar()) {
            JOptionPane.showMessageDialog(rootPane, "Registro eliminado");
            LimpiarCampos();
            btnListar.doClick();
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se elimino");
        }
        LimpiarCampos();
        btnListar.doClick();

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        // TODO add your handling code here:
        DAOPacientes dp = new DAOPacientes();
        tblPacientes.setModel(dp.listar());
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if (!txtNoExpediente.getText().isEmpty()) {
            if (!txtNombre.getText().isEmpty()) {
                if (!txtApPat.getText().isEmpty()) {
                    if (!txtApPat.getText().isEmpty()) {
                        if (!txtDiaNac.getText().isEmpty()) {
                            if (!txtMesNac.getText().isEmpty()) {
                                if (!txtAnioNac.getText().isEmpty()) {
                                    ComboItem ci = (ComboItem) cmbFiltradoPacientes.getSelectedItem();
                                    Pacientes pac = new Pacientes();
                                    DAOPacientes dPac = new DAOPacientes();
                                    pac.setIdPaciente(ci.getId());
                                    pac.setTel(txtTel.getText());
                                    pac.setNombre(txtNombre.getText());
                                    pac.setApPat(txtApPat.getText());
                                    pac.setApMat(txtApMat.getText());
                                    pac.setNoExpediente(Integer.parseInt(txtNoExpediente.getText()));
                                    if (chkActaIfe.isSelected()) {
                                        pac.setActaIfe('1');
                                    } else {
                                        pac.setActaIfe('0');
                                    }
                                    pac.setFechaNac(txtAnioNac.getText() + "-" + txtMesNac.getText() + "-" + txtDiaNac.getText());
                                    pac.setEstadoCivil(cmbEstadoCivil.getSelectedItem().toString());
                                     pac.setEstadoProcedencia(cmbEstadoProce.getSelectedItem().toString());
                                    pac.setMunicipioProcedencia(txtMunicipioProce.getText());
                                    pac.setSeguro(cmbSeguro.getSelectedItem().toString());
                                    pac.setEstadoOrigen(cmbEstadoNac.getSelectedItem().toString());
                                    pac.setMunicipioOrigen(txtMunicipioNac.getText());
                                    pac.setTpPaciente(cmbTpPaciente.getSelectedItem().toString());
                                    pac.setAreas(cmbArea.getSelectedItem().toString());
                                    pac.setTpSangre(cmbTpSangre.getSelectedItem().toString());
                                    pac.setAlergias(txaAlergias.getText());
                                    pac.setDiagnostico(txaDiagnostico.getText());
                                    pac.setEstado('1');

                                    dPac.setPaciente(pac);
                                    if (dPac.modificar()) {
                                        JOptionPane.showMessageDialog(rootPane, "Registro modificado");
                                        LimpiarCampos();
                                        cargaCmbFiltrado();
                                        btnListar.doClick();
                                    } else {
                                        JOptionPane.showMessageDialog(rootPane, "No se modifico");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(this, "ERROR: Faltó el año de nacimiento.");
                                }

                            } else {
                                JOptionPane.showMessageDialog(this, "ERROR: Faltó el mes de nacimiento.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "ERROR: Faltó el día de nacimiento.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "ERROR: Faltó el apellido materno.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "ERROR: Faltó el apellido paterno.");
                }

            } else {
                JOptionPane.showMessageDialog(this, "ERROR: Faltó el Nombre de paciente.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "ERROR: Faltó el No. de Expediente.");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void mitHistorial1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitHistorial1ActionPerformed
        dispose();
        FrmHistorial_Ingresos_Egresos frmhie = new FrmHistorial_Ingresos_Egresos();
        frmhie.setVisible(true);
    }//GEN-LAST:event_mitHistorial1ActionPerformed

    private void mitResponsablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitResponsablesActionPerformed
        dispose();
        FrmPacientes2 frm2 = new FrmPacientes2();
        frm2.setVisible(true);

    }//GEN-LAST:event_mitResponsablesActionPerformed

    private void mitPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitPacientesActionPerformed
        dispose();
        FrmPacientes frm = new FrmPacientes();
        frm.setVisible(true);
    }//GEN-LAST:event_mitPacientesActionPerformed

    private void cmbEstadoNacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoNacActionPerformed
        // TODO add your handling code here:
//        cargarMunicipioNac();
    }//GEN-LAST:event_cmbEstadoNacActionPerformed

    private void cmbEstadoProceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoProceActionPerformed
        // TODO add your handling code here:
        //      cargarMunicipioProce();
    }//GEN-LAST:event_cmbEstadoProceActionPerformed

    private void chkActaIfeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkActaIfeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkActaIfeActionPerformed

    private void txtFiltroPacientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroPacientesKeyReleased
        // TODO add your handling code here:
        txtFiltroPacientes.setText(txtFiltroPacientes.getText().toUpperCase());
        cargaCmbFiltrado();
    }//GEN-LAST:event_txtFiltroPacientesKeyReleased

    private void tblPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPacientesMouseClicked
        int filaSeleccionada = tblPacientes.getSelectedRow();
        int columna = 0;
        int buscar = Integer.parseInt((String) tblPacientes.getValueAt(filaSeleccionada, columna));

        DAOPacientes dPac = new DAOPacientes();
        dPac.setIdPaciente(buscar);
        dPac.buscar();
        llenaCamposDAO(dPac);

    }//GEN-LAST:event_tblPacientesMouseClicked

    private void txtFiltroPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroPacientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroPacientesActionPerformed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        // TODO add your handling code here:
        txtNombre.setText(txtNombre.getText().toUpperCase());
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtApPatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApPatKeyReleased
        // TODO add your handling code here:
        txtApPat.setText(txtApPat.getText().toUpperCase());
    }//GEN-LAST:event_txtApPatKeyReleased

    private void txtApMatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApMatKeyReleased
        // TODO add your handling code here:
        txtApMat.setText(txtApMat.getText().toUpperCase());
    }//GEN-LAST:event_txtApMatKeyReleased

    private void txaAlergiasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaAlergiasKeyReleased
        // TODO add your handling code here:
        txaAlergias.setText(txaAlergias.getText().toUpperCase());
    }//GEN-LAST:event_txaAlergiasKeyReleased

    private void txaDiagnosticoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaDiagnosticoKeyReleased
        // TODO add your handling code here:
        txaDiagnostico.setText(txaDiagnostico.getText().toUpperCase());
    }//GEN-LAST:event_txaDiagnosticoKeyReleased

    private void mitReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitReporteActionPerformed
        // TODO add your handling code here:
        String rutaReporte = "src/reportes/reportePacientes.jrxml";
        Reportes re = new Reportes();
        Map parametros = new HashMap();
        int codigo=Integer.parseInt(txtNoExpediente.getText());
        parametros.put("codigo",codigo);
        re.mostrarReporte(rutaReporte, parametros);
    }//GEN-LAST:event_mitReporteActionPerformed

    private void txtMunicipioNacKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMunicipioNacKeyReleased
        // TODO add your handling code here:
        txtMunicipioNac.setText(txtMunicipioNac.getText().toUpperCase());
    }//GEN-LAST:event_txtMunicipioNacKeyReleased

    private void txtMunicipioProceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMunicipioProceKeyReleased
        // TODO add your handling code here:
        txtMunicipioProce.setText(txtMunicipioProce.getText().toUpperCase());
    }//GEN-LAST:event_txtMunicipioProceKeyReleased

    public void cargaCmbFiltrado() {
        DAOPacientes dp = new DAOPacientes();
        cmbFiltradoPacientes.removeAllItems();
        ArrayList<ComboItem> pacientes = dp.filtrarPacientes(txtFiltroPacientes.getText());
        for (int i = 0; i < pacientes.size(); i++) {
            cmbFiltradoPacientes.addItem((ComboItem) pacientes.get(i));
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
            java.util.logging.Logger.getLogger(FrmPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new FrmPacientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JCheckBox chkActaIfe;
    private javax.swing.JComboBox<String> cmbArea;
    private javax.swing.JComboBox cmbEstadoCivil;
    private javax.swing.JComboBox<String> cmbEstadoNac;
    private javax.swing.JComboBox<String> cmbEstadoProce;
    private javax.swing.JComboBox cmbFiltradoPacientes;
    private javax.swing.JComboBox cmbSeguro;
    private javax.swing.JComboBox<String> cmbTpPaciente;
    private javax.swing.JComboBox cmbTpSangre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAlergias;
    private javax.swing.JLabel lblApMat;
    private javax.swing.JLabel lblApPat;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblDiagnostico;
    private javax.swing.JLabel lblEstadoCivil;
    private javax.swing.JLabel lblEstadoCivil1;
    private javax.swing.JLabel lblEstadoNac;
    private javax.swing.JLabel lblEstadoProce;
    private javax.swing.JLabel lblFechaNac;
    private javax.swing.JLabel lblFechaNac1;
    private javax.swing.JLabel lblFechaNac2;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblMunicipioNac;
    private javax.swing.JLabel lblMunicipioProce;
    private javax.swing.JLabel lblNoExpediente;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTel;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTpPaciente;
    private javax.swing.JLabel lblTpSangre;
    private javax.swing.JMenuBar mbrPrincipal;
    private javax.swing.JMenuItem mitHistorial1;
    private javax.swing.JMenuItem mitPacientes;
    private javax.swing.JMenuItem mitReporte;
    private javax.swing.JMenuItem mitResponsables;
    private javax.swing.JMenu mn1;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JSeparator sep1;
    private javax.swing.JSeparator sep2;
    private javax.swing.JSeparator sep3;
    private javax.swing.JPopupMenu.Separator sep5;
    private javax.swing.JTable tblPacientes;
    private javax.swing.JTextArea txaAlergias;
    private javax.swing.JTextArea txaDiagnostico;
    private javax.swing.JTextField txtAnioNac;
    private javax.swing.JTextField txtApMat;
    private javax.swing.JTextField txtApPat;
    private javax.swing.JTextField txtDiaNac;
    private javax.swing.JTextField txtFiltroPacientes;
    private javax.swing.JTextField txtIdPaciente;
    private javax.swing.JTextField txtMesNac;
    private javax.swing.JTextField txtMunicipioNac;
    private javax.swing.JTextField txtMunicipioProce;
    private javax.swing.JTextField txtNoExpediente;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
