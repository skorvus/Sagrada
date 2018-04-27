package clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 * Miguel Angel Preciado Valerio 06/02/2017 Casa de descanso Farmacia La clase
 * DaoProducto contiene los metodos para la conexion con la base de datos y las
 * consultas que se podran realizar. Hereda las variables y datos de la clase
 * Productos
 */
public class DaoProducto extends Producto {

    private String mensaje;
    Connection con;

    /**
     * Constructor con los datos heredados de la clase producto
     *
     * @param idProducto
     * @param nombreProductoPat
     * @param nombreProductoGen
     * @param contenidoCaja
     * @param stockActual
     * @param stockMinimo
     * @param administracion
     * @param tipo
     */
    public DaoProducto(int idProducto, String nombreProductoPat, String nombreProductoGen,
            String contenidoCaja, int stockActual, int stockMinimo, int administracion, int tipo) {

        super(idProducto, nombreProductoPat, nombreProductoGen, contenidoCaja, stockActual, stockMinimo, administracion, tipo);

    }

    public DaoProducto() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String msg) {
        mensaje = msg;
    }

    /**
     * Metodo agregar, llama a un stored procedure que hace un insert de todos
     * los datos excepto el id, que es autogenerado
     *
     * @return res, para indicar si el proceso fue exitoso.
     */
    public boolean agregar() {
        boolean res = false;
        con = Conex.getInstance().getConnection();

        String cadSql = "{call sp_prod_ins(?,?,?,?,?,?,?)}";

        try {
            CallableStatement pstm = con.prepareCall(cadSql);
            pstm.setString(1, getNombreProductoPat());
            pstm.setString(2, getNombreProductoGen());
            pstm.setString(3, getContenidoCaja());
            pstm.setInt(4, getStockActual());
            pstm.setInt(5, getStockMinimo());
            pstm.setInt(6, getAdministracion());
            pstm.setInt(7, getTipo());
            pstm.execute();
            res = true;
        } catch (SQLException ex) {
            mensaje = ex.getMessage();
        }
        return res;
    }

    /**
     * Metodo para eliminado logico, cambia el parametro status a 0 con un
     * stored procedure encontrando por el nombre de la patente al producto.
     *
     * @return res, para indicar si el proceso fue exitoso.
     */
    public boolean eliminar() {
        boolean res = false;
        con = Conex.getInstance().getConnection();
        String cadSql = "{call sp_prod_elm(?)}";
        try {

            CallableStatement stm = con.prepareCall(cadSql);
            stm.setString(1, nombreProductoPat);
            stm.executeUpdate();
            res = true;

        } catch (SQLException ex) {
            mensaje = ex.getMessage();
        }
        return res;
    }

    /**
     * Metodo que modifica los datos del producto a excepcion del id, y el
     * status por medio de stored procedures
     *
     * @return res, para indicar si el proceso fue exitoso.
     */
    public boolean modificar() {
        boolean res = false;
        String sql = "{call sp_prod_mod(?,?,?,?,?,?,?,?)}";
        try {
            con = Conex.getInstance().getConnection();
            CallableStatement cstm = con.prepareCall(sql);
            cstm.setInt(1, getIdProducto());
            cstm.setString(2, getNombreProductoPat());
            cstm.setString(3, getNombreProductoGen());
            cstm.setString(4, getContenidoCaja());
            cstm.setInt(5, getStockActual());
            cstm.setInt(6, getStockMinimo());
            cstm.setInt(7, getAdministracion());
            cstm.setInt(8, getTipo());

            cstm.execute();

            cstm.executeUpdate();

            System.out.println(sql);
            res = true;

        } catch (SQLException ex) {
            mensaje = ex.getMessage();
        }
        return res;
    }

    /**
     * Metodo que crea el modelo para la tabla que se desplegara en la ventana
     * utiliza un stores procedure para filtrar los datos en la tabla por los
     * caracteres qie se ingresen en nombrePatente
     *
     * @return res, para indicar si el proceso fue exitoso.
     */
    public DefaultTableModel listar() {
        DefaultTableModel tmodel = new DefaultTableModel();
        con = Conex.getInstance().getConnection();
        
        String sql = "{call sp_prod_bus (?)}";
        try {
            
            CallableStatement stm = con.prepareCall(sql);
            stm.setString(1, getNombreProductoPat());
            ResultSet rs = stm.executeQuery();
            
            ResultSetMetaData rsmd = rs.getMetaData();
            int numCols = rsmd.getColumnCount();
            String nombreCol;
            
            for (int i = 1; i <= numCols; i++) {
                //Colocar el nombre a cada columna 
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

    /**
     * Metodo que busca los datos de un solo producto por medio de su nombre
     * para rellenar los campos y posteriormente modificarlos o eliminarlos
     *
     * @return res, para indicar si el proceso fue exitoso.
     */
    public boolean buscar() {
        boolean res = false;
        con = Conex.getInstance().getConnection();
        String sql = "{call sp_prod_lis(?)}";
        try {
            CallableStatement stm = con.prepareCall(sql);
            stm.setString(1, nombreProductoPat);
            ResultSet rs = stm.executeQuery();
            res = true;
            if (rs.next()) {
                idProducto = (rs.getInt("idProducto"));
                nombreProductoPat = (rs.getString("nombreProductoPat"));
                nombreProductoGen = (rs.getString("nombreProductoGen"));
                contenidoCaja = (rs.getString("contenidoCaja"));
                stockActual = (rs.getInt("stockActual"));
                stockMinimo = (rs.getInt("stockMinimo"));
                administracion = (rs.getInt("idAdministracion"));
                tipo = (rs.getInt("idTipo"));

            }
        } catch (SQLException ex) {
            System.out.println("fallo");
            mensaje = ex.getMessage();
        }
        return res;
    }

}
