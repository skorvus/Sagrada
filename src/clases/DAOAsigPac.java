/*
 * Nombre del autor: Iván Ruiz Ramírez
                     Jose Luis Terraza Cortés
 * Fecha de creación: 2017/01/31
 * Nombre del proyecto: casaDescanso
 * Nombre del módulo: centralDeEnfermería
 * Breve descripción del contenido: Esta es la clase DAOAsigPac, la cual contiene los metodos de agregar,buscar(filtrar),modificar,eliminar y listar, aparte de los métodos necesarios para llenar los comboBox.
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
 * @author LUPITO
 */
public class DAOAsigPac extends AsigPac {

    public DAOAsigPac(int idPaciente, int idEnfermera, int idAsigPac, int horaInicio, int horaFin, int minInicio, int minFin, int resHora, int resMin, String mensaje, String nombreEnf, String nombrePac, String area) {
        super(idPaciente, idEnfermera, idAsigPac, horaInicio, horaFin, minInicio, minFin, resHora, resMin, mensaje, nombreEnf, nombrePac, area);
    }

    public DAOAsigPac() {
    }

    public boolean agregar() {
        Connection con;
        boolean res = false;
        con = Conex.getInstance().getConnection();
        String cadSql = "{call sp_insAsigPac(?,?,?,?,?,?,?,?,?)};";
        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setInt(1, getIdPaciente());
            cstm.setInt(2, getIdEnfermera());
            cstm.setString(3, getArea());
            cstm.setInt(4, getHoraInicio());
            cstm.setInt(5, getMinInicio());
            cstm.setInt(6, getHoraFin());
            cstm.setInt(7, getMinFin());
            cstm.setInt(8, getResHora());
            cstm.setInt(9, getResMin());
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
        String cadSql = "{call sp_modAsigPac(?,?,?,?,?,?,?,?,?,?)};";
        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setInt(1, getIdAsigPac());
            cstm.setInt(2, getIdPaciente());
            cstm.setInt(3, getIdEnfermera());
            cstm.setString(4, getArea());
            cstm.setInt(5, getHoraInicio());
            cstm.setInt(6, getMinInicio());
            cstm.setInt(7, getHoraFin());
            cstm.setInt(8, getMinFin());
            cstm.setInt(9, getResHora());
            cstm.setInt(10, getResMin());
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
        String cadSql = "{call sp_elimAsigPac(?)};";
        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setInt(1, getIdAsigPac());
            cstm.execute();
        } catch (SQLException ex) {
            setMensaje(ex.getMessage());
        }
    }

    public void listar() {
        Connection con;
        try {
            con = Conex.getInstance().getConnection();
            String cadSql = "{call sp_listAsigPac()};";
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

    public void filtrarAsig() {
        Connection con;
        try {
            con = Conex.getInstance().getConnection();
            String cadSql = "{call sp_filtAsigPac(?)};";
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setString(1, getNombreEnf());
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

    public void detectarIdEnf() {
        Connection con;
        String[] array;
        try {
            con = Conex.getInstance().getConnection();
            String cadSql = "{call sp_cmbIdPersonal(?,?,?)};";
            array = getNombreEnf().split(" ");
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setString(1, array[0]);
            cstm.setString(2, array[1]);
            cstm.setString(3, array[2]);
            ResultSet rs = cstm.executeQuery();
            if (rs.next()) {
                setIdEnfermera(rs.getInt("idEnfermera"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el idProveedor.");
            }
        } catch (SQLException ex) {
            setMensaje(ex.getMessage());
        }
    }

    public void detectarIdPac() {
        Connection con;
        String[] array;
        try {
            con = Conex.getInstance().getConnection();
            String cadSql = "{call sp_cmbIdPac(?,?,?)};";
            array = getNombrePac().split(" ");
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setString(1, array[0]);
            cstm.setString(2, array[1]);
            cstm.setString(3, array[2]);
            ResultSet rs = cstm.executeQuery();
            if (rs.next()) {
                setIdPaciente(rs.getInt("idPaciente"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el idProveedor.");
            }
        } catch (SQLException ex) {
            setMensaje(ex.getMessage());
        }
    }

}
