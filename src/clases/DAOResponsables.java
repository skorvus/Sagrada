/*
 * Titulo: Modulo paciente.
 * Este programa se realizó para la organización "La sagrada familia A.C".
 * Clase para generar todos los metodos para el objeto Responsables.
 * @version 25/02/2017
 */
package clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 * @author Pablo Alberto Rodirguez Lopez.
 * @author Tomas Alejandro Vargas Lopez.
 * @author Jose Luis Tinajero Carvajal.
 */
public class DAOResponsables extends Responsables {

    Responsables res = new Responsables();
    private String mensaje;
    Connection con;

    public DAOResponsables() {

    }

    public DAOResponsables(int idPaciente, int idResponsable, String nombreResponsable, String apPatResponsable, String apMatResponsable, String tel, String relacion, String calle, String noExt, String noInt, String colonia, String cP, String municipioResponsable, String estadoResponsable) {
        super(idPaciente, idResponsable, nombreResponsable, apPatResponsable, apMatResponsable, tel, relacion, calle, noExt, noInt, colonia, cP, municipioResponsable, estadoResponsable);
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String msg) {
        mensaje = msg;
    }

    public boolean agregar() {
        System.out.println("Inicio de agregado");
        boolean res = false;
        con = Conex.getInstance().getConnection();

        String cadSql = "call ins_Responsable("
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            CallableStatement pstm = con.prepareCall(cadSql);
            pstm.setInt(1, super.getIdPaciente());
            pstm.setString(2, super.getNombreResponsable());
            pstm.setString(3, super.getApPatResponsable());
            pstm.setString(4, super.getApMatResponsable());
            pstm.setString(5, super.getTel());
            pstm.setString(6, super.getTel2());
            pstm.setString(7, super.getTel3());
            pstm.setString(8, super.getRelacion());
            pstm.setString(9, super.getNoExt());
            pstm.setString(10, super.getNoInt());
            pstm.setString(11, super.getColonia());
            pstm.setString(12, super.getEstadoResponsable());
            pstm.setString(13, super.getMunicipioResponsable());
            pstm.setString(14, super.getCalle());
            pstm.setString(15, super.getcP());

            System.out.println("Se mando a ejecutar");
            pstm.executeUpdate();
            System.out.println("Se agregó exitosamente");
            res = true;
        } catch (SQLException ex) {
            mensaje = ex.getMessage();
            System.out.println(mensaje);
        }
        return res;
    }
    public boolean agregarDetalle() {
        System.out.println("Inicio de agregado");
        boolean res = false;
        con = Conex.getInstance().getConnection();

        String cadSql = "call ins_Detalle("
                + "?,?)";
        try {
            CallableStatement pstm = con.prepareCall(cadSql);
            pstm.setInt(1, super.getIdPaciente());
            pstm.setInt(2, super.getIdResponsable());
            System.out.println("Se mando a ejecutar");
            pstm.executeUpdate();
            System.out.println("Se agregó exitosamente");
            res = true;
        } catch (SQLException ex) {
            mensaje = ex.getMessage();
            System.out.println(mensaje);
        }
        return res;
    }
    
    public boolean eliminar() {
        boolean res = false;
        con = Conex.getInstance().getConnection();
        try {
            CallableStatement pstm = con.prepareCall("call delete_Resposanble(?)");
            pstm.setInt(1, super.getIdResponsable());
            pstm.execute();
            res = true;
        } catch (SQLException ex) {
            mensaje = ex.getMessage();
            System.out.println(mensaje);
        }
        return res;
    }
    
    public boolean eliminarDetalle() {
        boolean res = false;
        con = Conex.getInstance().getConnection();
        try {
            CallableStatement pstm = con.prepareCall("call del_detalle(?,?)");
            pstm.setInt(1, super.getIdPaciente());
            pstm.setInt(2, super.getIdResponsable());
            pstm.execute();
            res = true;
        } catch (SQLException ex) {
            mensaje = ex.getMessage();
            System.out.println(mensaje);
        }
        return res;
    }

    public DefaultTableModel listar() {
        DefaultTableModel tmodel = new DefaultTableModel();
        con = Conex.getInstance().getConnection();
        try {
            CallableStatement stm = con.prepareCall("call listar_Responsable()");
            ResultSet rs = stm.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int numCols = rsmd.getColumnCount();
            String nombreCol;
            for (int i = 1; i <= numCols; i++) {
                nombreCol = rsmd.getColumnName(i);
                nombreCol = nombreCol.toUpperCase();
                tmodel.addColumn(nombreCol);
            }
            String renglon[] = new String[numCols];
            while (rs.next()) {
                for (int c = 1, j = 0; c <= numCols; c++, j++) {
                    renglon[j] = rs.getString(c);
                }
                tmodel.addRow(renglon);
            }
        } catch (SQLException ex) {
            mensaje = ex.getMessage();
            System.out.println(mensaje);
        }
        return tmodel;
    }

    public DefaultTableModel listarResponsable() {
        DefaultTableModel tmodel = new DefaultTableModel();
        con = Conex.getInstance().getConnection();
        try {
            CallableStatement stm = con.prepareCall("call lista_PorResponsable(?)");
            stm.setInt(1, super.getIdResponsable());
            ResultSet rs = stm.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int numCols = rsmd.getColumnCount();
            String nombreCol;
            for (int i = 1; i <= numCols; i++) {
                nombreCol = rsmd.getColumnName(i);
                nombreCol = nombreCol.toUpperCase();
                tmodel.addColumn(nombreCol);
            }
            String renglon[] = new String[numCols];
            while (rs.next()) {
                for (int c = 1, j = 0; c <= numCols; c++, j++) {
                    renglon[j] = rs.getString(c);
                }
                tmodel.addRow(renglon);
            }
        } catch (SQLException ex) {
            mensaje = ex.getMessage();
            System.out.println(mensaje);
        }
        return tmodel;
    }

    public DefaultTableModel listarPaciente() {
        DefaultTableModel tmodel = new DefaultTableModel();
        con = Conex.getInstance().getConnection();
        try {
            CallableStatement stm = con.prepareCall("call lista_PorPaciente(?)");
            stm.setInt(1, super.getIdPaciente());
            ResultSet rs = stm.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int numCols = rsmd.getColumnCount();
            String nombreCol;
            for (int i = 1; i <= numCols; i++) {
                nombreCol = rsmd.getColumnName(i);
                nombreCol = nombreCol.toUpperCase();
                tmodel.addColumn(nombreCol);
            }
            String renglon[] = new String[numCols];
            while (rs.next()) {
                for (int c = 1, j = 0; c <= numCols; c++, j++) {
                    renglon[j] = rs.getString(c);
                }
                tmodel.addRow(renglon);
            }
        } catch (SQLException ex) {
            mensaje = ex.getMessage();
            System.out.println(mensaje);
        }
        return tmodel;
    }

    // <editor-fold defaultstate="collapsed" desc="setPaciente">
    public void setResponsable(Responsables res) {
        super.setIdPaciente(res.getIdPaciente());
        super.setIdResponsable(res.getIdResponsable());
        super.setNombreResponsable(res.getNombreResponsable());
        super.setApPatResponsable(res.getApPatResponsable());
        super.setApMatResponsable(res.getApMatResponsable());
        super.setEstadoResponsable(res.getEstadoResponsable());

        super.setMunicipioResponsable(res.getMunicipioResponsable());
        super.setNoExt(res.getNoExt());
        super.setNoInt(res.getNoInt());

        super.setCalle(res.getCalle());
        super.setTel(res.getTel());
        super.setTel2(res.getTel2());
        super.setTel3(res.getTel3());
        super.setcP(res.getcP());

        super.setColonia(res.getColonia());
        super.setRelacion(res.getRelacion());
        super.setActivo(res.getActivo());
    }

    public boolean buscar() {
        boolean res = false;
        con = Conex.getInstance().getConnection();
        try {
            CallableStatement stm = con.prepareCall("CALL buscar_Responsable(?)");
            stm.setInt(1, super.getIdResponsable());
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                super.setIdResponsable(rs.getInt("IdResponsable"));
                super.setNombreResponsable(rs.getString("NombreResponsable"));
                super.setApPatResponsable(rs.getString("ApPatResponsable"));
                super.setApMatResponsable(rs.getString("ApMatResponsable"));
                super.setEstadoResponsable(rs.getString("Estado"));
                super.setMunicipioResponsable(rs.getString("Municipio"));
                super.setNoExt(rs.getString("NoExt"));
                super.setNoInt(rs.getString("NoInt"));
                super.setCalle(rs.getString("Calle"));
                super.setTel(rs.getString("Tel"));
                super.setTel2(rs.getString("Tel2"));
                super.setTel3(rs.getString("Tel3"));
                super.setcP(rs.getString("CP"));
                super.setColonia(rs.getString("Colonia"));
                super.setRelacion(rs.getString("Relacion"));
                res = true;
            }
        } catch (SQLException ex) {
            mensaje = ex.getMessage();
            System.out.println(mensaje);
        }
        return res;
    }

//<editor-fold defaultstate="collapsed" desc="FiltrarPacientes">
    public ArrayList<ComboItem> filtrarResponsables(String filtro) {
        ArrayList<ComboItem> pacientes = new ArrayList<>();
        con = Conex.getInstance().getConnection();
        String nombre = "";
        int id = 0;
        try {
            CallableStatement cstm = con.prepareCall("CALL filtrar_Responsables(?)");
            cstm.setString(1, filtro);
            ResultSet rs = cstm.executeQuery();
            while (rs.next()) {
                id = rs.getInt("IdResponsable");
                nombre = rs.getString("Nombre_Completo");
                pacientes.add(new ComboItem(id, nombre));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pacientes;
    }
    //</editor-fold>

    public boolean modificar() {
        boolean res = false;
        con = Conex.getInstance().getConnection();
        try {
            CallableStatement pstm = con.prepareCall("call mod_Responsable("
                    + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            pstm.setInt(1, super.getIdResponsable());
            pstm.setInt(2, super.getIdPaciente());
            pstm.setString(3, super.getNombreResponsable());
            pstm.setString(4, super.getApPatResponsable());
            pstm.setString(5, super.getApMatResponsable());
            pstm.setString(6, super.getTel());
            pstm.setString(7, super.getTel2());
            pstm.setString(8, super.getTel3());
            pstm.setString(9, super.getRelacion());
            pstm.setString(10, super.getNoExt());
            pstm.setString(11, super.getNoInt());
            pstm.setString(12, super.getColonia());
            pstm.setString(13, super.getEstadoResponsable());
            pstm.setString(14, super.getMunicipioResponsable());
            pstm.setString(15, super.getCalle());
            pstm.setString(16, super.getcP());
            pstm.execute();

            res = true;
        } catch (SQLException ex) {
            mensaje = ex.getMessage();
            System.out.println(mensaje);
        }
        return res;
    }

}
