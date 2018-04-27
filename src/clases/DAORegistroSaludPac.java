/**
 * Nombre del autor: Dámaso Valdés Rosales.
 *                   Iván Ruiz Ramírez.
 * Fecha de creación: 14/02/2017.
 * Nombre del proyecto: casaDescanso
 * Nombre del módulo: centralDeEnfermería
 * Breve descripción del contenido:  Ésta es la clase DAO de registro de salud de paciente, la cual contiene los métodos de agregar,buscar,modificar,eliminar y listar.
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
 * @author Damaso
 */
public class DAORegistroSaludPac extends RegistroSaludPac {

    public DAORegistroSaludPac(int idRegistroDeSalud, int idPaciente, int idEnfermera, int presionArtSis, int presionArtDias, int frecuenciaCar, String temperatura, int prePrandial, int postPrandial, String notas, String fechaSalPac, String mensaje, String nomPac, String nomEnf) {
        super(idRegistroDeSalud, idPaciente, idEnfermera, presionArtSis, presionArtDias, frecuenciaCar, temperatura, prePrandial, postPrandial, notas, fechaSalPac, mensaje, nomPac, nomEnf);
    }
  
    public DAORegistroSaludPac() {

    }

    public boolean agregar() {
        Connection con;
        boolean res = false;
        con = Conex.getInstance().getConnection();
        String cadSql = "{call sp_insRegSalud(?,?,?,?,?,?,?,?,?,?)};";
        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setInt(1, getIdPaciente());
            cstm.setInt(2, getIdEnfermera());
            cstm.setInt(3, getPresionArtSis());
            cstm.setInt(4, getPresionArtDias());
            cstm.setInt(5, getFrecuenciaCar());
            cstm.setString(6, getTemperatura());
            cstm.setInt(7, getPrePrandial());
            cstm.setInt(8, getPostPrandial());
            cstm.setString(9, getNotas());
            cstm.setString(10, getFechaSalPac());
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
        String cadSql = "{call sp_modRegSalud(?,?,?,?,?,?,?,?,?,?,?)};";
        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setInt(1, getIdRegistroDeSalud());
            cstm.setInt(2, getIdPaciente());
            cstm.setInt(3, getIdEnfermera());
            cstm.setInt(4, getPresionArtSis());
            cstm.setInt(5, getPresionArtDias());
            cstm.setInt(6, getFrecuenciaCar());
            cstm.setString(7, getTemperatura());
            cstm.setInt(8, getPrePrandial());
            cstm.setInt(9, getPostPrandial());
            cstm.setString(10, getNotas());
            cstm.setString(11, getFechaSalPac());
            cstm.execute();
            JOptionPane.showMessageDialog(null, "Registro Modificado");
            res = true;
        } catch (SQLException ex) {
            setMensaje(ex.getMessage());
        }
        return res;
    }

    public void eliminar() {
        Connection con;
        con = Conex.getInstance().getConnection();
        String cadSql = "{call sp_elimRegSalud(?)};";
        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setInt(1, getIdRegistroDeSalud());
            cstm.execute();
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
        } catch (SQLException ex) {
            setMensaje(ex.getMessage());
        }
    }

    public void listar() {
        Connection con;
        try {
            con = Conex.getInstance().getConnection();
            String cadSql = "{call sp_listRegSalud()};";
            CallableStatement cstm = con.prepareCall(cadSql);
            ResultSet rs = cstm.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int numColumnas = rsmd.getColumnCount();
            String nomColumna;
            for (int i = 1; i <= numColumnas; i++) {
                nomColumna = rsmd.getColumnName(i);
                nomColumna = nomColumna.toUpperCase();
                tmodel.addColumn(nomColumna);
            }

            String renglon[] = new String[numColumnas];
            while (rs.next()) {
                for (int c = 1, j = 0; c <= numColumnas; c++, j++) {
                    renglon[j] = rs.getString(c);
                }
                tmodel.addRow(renglon);
            }
        } catch (SQLException ex) {
            setMensaje(ex.getMessage());
        }
    }
    
    public void listarIncidencias(){
       Connection con;
        try {
            con = Conex.getInstance().getConnection();
            String cadSql = "{call sp_listInc()};";
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

    public void filtrar() {
        Connection con;
        try {
            con = Conex.getInstance().getConnection();
            String cadSql = "{call sp_filtRegSalud(?)};";
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setString(1, getNomPac());
            ResultSet rs = cstm.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int numColumnas = rsmd.getColumnCount();
            String nomColumna;
            for (int i = 1; i <= numColumnas; i++) {
                nomColumna = rsmd.getColumnName(i);
                nomColumna = nomColumna.toUpperCase();
                tmodel.addColumn(nomColumna);
            }

            String renglon[] = new String[numColumnas];
            while (rs.next()) {
                for (int c = 1, j = 0; c <= numColumnas; c++, j++) {
                    renglon[j] = rs.getString(c);
                }
                tmodel.addRow(renglon);
            }
        } catch (SQLException ex) {
           setMensaje(ex.getMessage());
        }
    }
    
    public void filtrarIncidencia() {
        Connection con;
        try {
            con = Conex.getInstance().getConnection();
            String cadSql = "{call sp_filtInc(?)};";
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setString(1, getNomPac());
            ResultSet rs = cstm.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int numColumnas = rsmd.getColumnCount();
            String nomColumna;
            for (int i = 1; i <= numColumnas; i++) {
                nomColumna = rsmd.getColumnName(i);
                nomColumna = nomColumna.toUpperCase();
                tmodel.addColumn(nomColumna);
            }

            String renglon[] = new String[numColumnas];
            while (rs.next()) {
                for (int c = 1, j = 0; c <= numColumnas; c++, j++) {
                    renglon[j] = rs.getString(c);
                }
                tmodel.addRow(renglon);
            }
        } catch (SQLException ex) {
           setMensaje(ex.getMessage());
        }
    }

    public void detectarIdPaciente() {
        Connection con;
        String[] array;
        try {
            con = Conex.getInstance().getConnection();
            String cadSql = "{call sp_cmbIdPac(?,?,?)};";
            array = getNomPac().split(" ");
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setString(1,array[0]);
            cstm.setString(2,array[1]);
            cstm.setString(3, array[2]);
            ResultSet rs = cstm.executeQuery();
            if (rs.next()) {
                setIdPaciente(rs.getInt("idPaciente"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el idPaciente.");
            }
        } catch (SQLException ex) {
            setMensaje(ex.getMessage());
        }
    }
    
    public void detectarIdEnfermera() {
        Connection con;
        String[] array;
        try {
            con = Conex.getInstance().getConnection();
            String cadSql = "{call sp_cmbIdPersonal(?,?,?)};";
            array = getNomEnf().split(" ");
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setString(1, array[0]);
            cstm.setString(2, array[1]);
            cstm.setString(3, array[2]);
            ResultSet rs = cstm.executeQuery();
            if (rs.next()) {
                setIdEnfermera(rs.getInt("idEnfermera"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el idEnfermera.");
            }
        } catch (SQLException ex) {
            setMensaje(ex.getMessage());
        }
    }

}
