/*
 * Titulo: Modulo paciente.
 * Este programa se realizó para la organización "La sagrada familia A.C".
 * Clase para generar todos los metodos para el objeto RegistroMovimientos.
 * @version 25/02/2017
 */
package clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 * @author Pablo Alberto Rodirguez Lopez.
 * @author Tomas Alejandro Vargas Lopez.
 * @author Jose Luis Tinajero Carvajal.
 */
public class DAORegistroMovimientos extends RegistroMovimientos {

    RegistroMovimientos rm = new RegistroMovimientos();
    private String mensaje;
    Connection con;

    public DAORegistroMovimientos() {
    }

    public DAORegistroMovimientos(int IdRegistro, int NoExpediente, int IdPaciente, String Descripcion, String Autorizado, String Motivos, String Comentarios) {
        super(IdRegistro, NoExpediente, IdPaciente, Descripcion, Autorizado, Motivos, Comentarios);
    }

    

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String msg) {
        mensaje = msg;
    }

    public void setRegistroMovimientos(RegistroMovimientos rm) {
        super.setIdRegistro(rm.getIdRegistro());
        super.setIdPaciente(rm.getIdPaciente());
        super.setDescripcion(rm.getDescripcion());
        super.setAutorizado(rm.getAutorizado());
        super.setMotivos(rm.getMotivos());
        super.setNoExpediente(rm.getNoExpediente());
        super.setComentarios(rm.getComentarios());
    }
    
    public boolean agregar(){
        System.out.println("Inicio de agregado");
        boolean res= false;
        con = Conex.getInstance().getConnection();

        String cadSql= "call ins_Movimiento("+
           "?,?,?,?,?)";
        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setInt(1, super.getNoExpediente());
            cstm.setString(2, super.getDescripcion());
            cstm.setString(3, super.getAutorizado());
            cstm.setString(4, super.getMotivos());
            cstm.setString(5, super.getComentarios());
            cstm.execute();
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(DAORegistroMovimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public DefaultTableModel listarMovimientos() {
        DefaultTableModel tmodel = new DefaultTableModel();
        con = Conex.getInstance().getConnection();
        try {
            CallableStatement stm = con.prepareCall("call listar_Movimientos(?)");
            stm.setInt(1, super.getNoExpediente());
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
    
        public DefaultTableModel listarReingresos() {
        DefaultTableModel tmodel = new DefaultTableModel();
        con = Conex.getInstance().getConnection();
        try {
            CallableStatement stm = con.prepareCall("call listar_Reingresos(?)");
            stm.setInt(1, super.getNoExpediente());
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
        
    public DefaultTableModel listarEgresos() {
        DefaultTableModel tmodel = new DefaultTableModel();
        con = Conex.getInstance().getConnection();
        try {
            CallableStatement stm = con.prepareCall("call listar_Egresos(?)");
            stm.setInt(1, super.getNoExpediente());
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
        

}
