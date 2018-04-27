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
 *
 * @author Juan Pablo Vazquez Ruiz Casa de Descanso Farmacia 
 * DaoAdministracion contiene los metodos para la conexion con la base de datos y las
 * consultas que se podran realizar. Hereda las variables y datos de la clase
 * Administracion. 
 * 
 */
public class DaoAdministracion extends Administracion {
    
    private String mensaje;
    Connection con;
    
    /** 
     * Constructor con los datos heredados de la clase Administracion.
     * @param idAdministracion
     * @param administracion 
     */
    
    public DaoAdministracion(int idAdministracion, String administracion) {
        super(idAdministracion, administracion);
    }

    public DaoAdministracion() {
    }
    
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    /**
     * Metodo agregar, llama a un stored procedure que hace un insert de medio de
     * administracion, el id es autogenerado.
     *
     * @return res, para indicar si el proceso fue exitoso.
     */
    public boolean agregar() {
        boolean res = false;
        con = Conex.getInstance().getConnection();
        
        
    String cadSql = "{call sp_adm_ins (?)}";

        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setString(1, getAdministracion());
            cstm.execute();
            res = true;
        } catch (SQLException ex) {
            mensaje = ex.getMessage();
        }
        return res;
    }
    /**
     * Metodo para eliminado logico, cambia el parametro status a 0 con un
     * stored procedure encontrando por el nombre de Administracion de producto.
     *
     * @return res, para indicar si el proceso fue exitoso.
     */
   public boolean eliminar(){ 
    boolean res = false;
    con = Conex.getInstance().getConnection();
        String cadSql = "{call sp_adm_elm(?)}";
    try {
           
           CallableStatement  cstm = con.prepareCall(cadSql);
           cstm.setString(1,getAdministracion());
           cstm.execute();
           res = true; 
        
        } catch (SQLException ex) {
             mensaje = ex.getMessage();
        } 
        return res;
    } 
    /**
     * Metodo que modifica el nombre de medio de Administracion a excepcion del id, y
     * el status por medio de stored procedures.
     *
     * @return res, para indicar si el proceso fue exitoso.
     */
   public boolean modificar(){ 
        boolean res = false;
        con = Conex.getInstance().getConnection();
        String cadSql = "{call sp_adm_mod(?,?)}";
        try {
           
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setInt(1,getIdAdministracion()); 
            cstm.setString(2, getAdministracion());
            cstm.execute();

            cstm.executeUpdate(); 
            System.out.println(getIdAdministracion()+" "+getAdministracion());
            res = true; 
        
    }   catch (SQLException ex) {   
            mensaje = ex.getMessage();
        }   
        return res;
    }
    /**
     * Metodo que busca los datos de un solo medio de Administracion por medio de su
     * nombre para rellenar el campo y posteriormente modificarlo o eliminarlo.
     *
     * @return res, para indicar si el proceso fue exitoso.
     */
    public boolean buscar(){ 
         boolean res = false;
        con = Conex.getInstance().getConnection();
        String sql = "{call sp_adm_bus(?)}";
        try{
            CallableStatement stm = con.prepareCall(sql);
            stm.setString(1, getAdministracion());
            ResultSet rs = stm.executeQuery();
            res = true; 
            if(rs.next()){
                idAdministracion = (rs.getInt("idAdministracion"));
                administracion = (rs.getString("administracion"));
               
            }
        }catch(SQLException ex){
            mensaje = ex.getMessage();
        }
        return res;
    
    
    }
    
   
    /**
     * Metodo que crea el modelo para la tabla que se desplegara en la ventana
     * utiliza un stored procedure para filtrar los datos en la tabla por los
     * caracteres que se ingresen en el textfield administracion.
     *
     * @return res, para indicar si el proceso fue exitoso.
     */
    public DefaultTableModel listar() {
                DefaultTableModel tmodel = new DefaultTableModel();
               con = Conex.getInstance().getConnection();
               String sql = "{call sp_adm_bus(?)}";
               
        try {
          
            CallableStatement stm = con.prepareCall(sql);
            stm.setString(1, getAdministracion());
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
        
      
        

    }   catch (SQLException ex) {   
            mensaje = ex.getMessage();
        }   
    
    return tmodel;
    }
    
    
    
}
