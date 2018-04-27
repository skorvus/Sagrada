/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 * Miguel Alfonso Guevara Hernández 07/02/2017 Casa de descanso Farmacia La
 * clase DaoTipo contiene los metodos para la conexion con la base de datos y
 * las consultas que se podran realizar. Hereda las variables y datos de la
 * clase Tipo
 */
public class DaoTipo extends Tipo {

    private String mensaje;
    Connection con;

    /**
     * Constructor con los datos heredados de la clase Tipo.
     *
     * @param idTipo
     * @param tipo
     *
     */
    public DaoTipo(int idTipo, String tipo) {
        super(idTipo, tipo);
    }

    public DaoTipo() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Metodo agregar, llama a un stored procedure que hace un insert de tipo de
     * producto, el id es autogenerado.
     *
     * @return res, para indicar si el proceso fue exitoso.
     */

    public boolean agregar() {
        boolean res = false;
        con = Conex.getInstance().getConnection();

        String cadSql = "{call sp_tip_ins(?)}";

        try {
            CallableStatement pstm = con.prepareCall(cadSql);
            pstm.setString(1, getTipo());
            pstm.execute();
            res = true;
        } catch (SQLException ex) {
            mensaje = ex.getMessage();
        }
        return res;
    }

    /**
     * Metodo para eliminado logico, cambia el parametro status a 0 con un
     * stored procedure encontrando por el nombre de tipo de producto.
     *
     * @return res, para indicar si el proceso fue exitoso.
     */

    public boolean eliminar() {
        boolean res = false;
        con = Conex.getInstance().getConnection();
        String cadSql = "{call sp_tip_elm(?)}";

        try {
            CallableStatement stm = con.prepareCall(cadSql);
            stm.setString(1, tipo);
            stm.executeUpdate();
            System.out.println(cadSql);
            res = true;

        } catch (SQLException ex) {
            mensaje = ex.getMessage();
        }
        return res;
    }

    /**
     * Metodo que modifica el nombre de tipo de producto a excepcion del id, y
     * el status por medio de stored procedures
     *
     * @return res, para indicar si el proceso fue exitoso.
     */
    public boolean modificar() {
        boolean res = false;

        String cadSql = "{call sp_tip_mod(?,?)}";

        try {
            con = Conex.getInstance().getConnection();
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setInt(1, getIdTipo());
            cstm.setString(2, getTipo());
            cstm.execute();

            cstm.executeUpdate();
            System.out.println(getIdTipo() + " " + getTipo());
            res = true;

        } catch (SQLException ex) {
            mensaje = ex.getMessage();
        }
        return res;
    }

    /**
     * Metodo que busca los datos de un solo tipo de producto por medio de su
     * nombre para rellenar el campo y posteriormente modificarlo o eliminarlo
     *
     * @return res, para indicar si el proceso fue exitoso.
     */
    public boolean buscar() {
        boolean res = false;
        con = Conex.getInstance().getConnection();
        String sql = "{call sp_tip_bus(?)}";
        try {
            CallableStatement stm = con.prepareCall(sql);
            stm.setString(1, getTipo());
            ResultSet rs = stm.executeQuery();
            res = true;
            if (rs.next()) {
                idTipo = (rs.getInt("idTipo"));
                tipo = (rs.getString("tipo"));

            }
        } catch (SQLException ex) {
            mensaje = ex.getMessage();
        }
        return res;

    }

    /**
     * Metodo que crea el modelo para la tabla que se desplegara en la ventana
     * utiliza un stored procedure para filtrar los datos en la tabla por los
     * caracteres que se ingresen en TipoProducto
     *
     * @return res, para indicar si el proceso fue exitoso.
     */
    public DefaultTableModel listar() {
        DefaultTableModel tmodel = new DefaultTableModel();
        con = Conex.getInstance().getConnection();
        String sql = "{call sp_tip_bus(?)}";

        try {

            CallableStatement stm = con.prepareCall(sql);
            stm.setString(1, getTipo());
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
        }

        return tmodel;
    }

}
