/*
 * Nombre del autor: Iván Ruiz Ramírez
                     Jose Luis Terraza Cortés
                     Dámaso Valdés Rosales
 * Fecha de creación: 2017/01/31
 * Nombre del proyecto: casaDescanso
 * Nombre del módulo: centralDeEnfermería
 * Breve descripción del contenido: Esta es la clase DAO de registro de personal de enfermería, la cual contiene los metodos de agregar,buscar,modificar,eliminar y listar.
 */
package clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose Luis
 */
public class DAOEnfermeras extends RegistroPersonalEnf {   

    public DAOEnfermeras(int idEnfermera, String nombreEnfermera, String apellidoPatEnf, String apellidoMatEnf, String especialidad, String tipoDeIngreso, String fechaIn, String fechaTerm, String estatus, String descrEstatus, String telefonoEnf, String correoEnf, String mensaje) {
        super(idEnfermera, nombreEnfermera, apellidoPatEnf, apellidoMatEnf, especialidad, tipoDeIngreso, fechaIn, fechaTerm, estatus, descrEstatus, telefonoEnf, correoEnf, mensaje);
    }

    public DAOEnfermeras() {
    }

    public boolean agregar() {
        Connection con;
        boolean res = false;
        con = Conex.getInstance().getConnection();
        String cadSql = "{call sp_insPersonal(?,?,?,?,?,?,?,?,?,?,?)};";
        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setString(1, getNombreEnfermera());
            cstm.setString(2, getApellidoPatEnf());
            cstm.setString(3, getApellidoMatEnf());
            cstm.setString(4, getEspecialidad());
            cstm.setString(5, getTipoDeIngreso());
            cstm.setString(6, getFechaIn());
            cstm.setString(7, getFechaTerm());
            cstm.setString(8, getEstatus());
            cstm.setString(9, getDescrEstatus());
            cstm.setString(10, getTelefonoEnf());
            cstm.setString(11, getCorreoEnf());
            cstm.execute();
            res = true;
        } catch (SQLException ex) {
            setMensaje(ex.getMessage());
        }
        return res;
    }

    public boolean modificar() {
        Connection con;
        boolean res = false;
        con = Conex.getInstance().getConnection();
        String cadSql = "{call sp_modPersonal(?,?,?,?,?,?,?,?,?,?,?,?)};";
        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setInt(1,getIdEnfermera());
            cstm.setString(2, getNombreEnfermera());
            cstm.setString(3, getApellidoPatEnf());
            cstm.setString(4, getApellidoMatEnf());
            cstm.setString(5, getEspecialidad());
            cstm.setString(6, getTipoDeIngreso());
            cstm.setString(7, getFechaIn());
            cstm.setString(8, getFechaTerm());
            cstm.setString(9, getEstatus());
            cstm.setString(10, getDescrEstatus());
            cstm.setString(11, getTelefonoEnf());
            cstm.setString(12, getCorreoEnf());
            cstm.execute();
            res = true;
        } catch (SQLException ex) {
            setMensaje(ex.getMessage());
        }
        return res;
    }

    public void eliminar() {
        Connection con;
        con = Conex.getInstance().getConnection();
        String cadSql = "{call sp_elimPersonal(?)};";
        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setInt(1,getIdEnfermera());
            cstm.execute();
        } catch (SQLException ex) {
            setMensaje(ex.getMessage());
        }
    }

    
    public void listar(){
        Connection con;
        try {
            con = Conex.getInstance().getConnection();
            String cadSql = "{call sp_listPersonal()};";
            CallableStatement cstm = con.prepareCall(cadSql);
            ResultSet rs = cstm.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int numColumnas = rsmd.getColumnCount();
            String nomColumna;
            for(int i=1;i<=numColumnas;i++){
                nomColumna = rsmd.getColumnName(i);
                nomColumna = nomColumna.toUpperCase();
                tmodel.addColumn(nomColumna);
            }
            
            String renglon[]= new String[numColumnas];
            while(rs.next()){
                for(int c=1,j=0;c<=numColumnas;c++,j++){
                    renglon[j]= rs.getString(c);
                }
                tmodel.addRow(renglon);
            }
        } catch (SQLException ex) {
           setMensaje(ex.getMessage());
        }
    }
    
    public void filtrar(){
        Connection con;
        try {
            con = Conex.getInstance().getConnection();
            String cadSql = "{call sp_filtPersonal(?)};";
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setString(1, getNombreEnfermera());
            ResultSet rs = cstm.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int numColumnas = rsmd.getColumnCount();
            String nomColumna;
            for(int i=1;i<=numColumnas;i++){
                nomColumna = rsmd.getColumnName(i);
                nomColumna = nomColumna.toUpperCase();
                tmodel.addColumn(nomColumna);
            }
            
            String renglon[]= new String[numColumnas];
            while(rs.next()){
                for(int c=1,j=0;c<=numColumnas;c++,j++){
                    renglon[j]= rs.getString(c);
                }
                tmodel.addRow(renglon);
            }
        } catch (SQLException ex) {
            setMensaje(ex.getMessage());
        }
    }
}
