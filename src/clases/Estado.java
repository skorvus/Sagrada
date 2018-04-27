/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Enrique
 */
public class Estado {
    private int id;
    private String clave;
    private String nombre;
    private String abreviatura;

    public Estado() {
    }
    /**
     * Obtener el id del Estado
     * @return entero
     */
    public int getId() {
        return id;
    }
    /**
     * Obtener la clave del estado
     * @return String
     */
    public String getClave() {
        return clave;
    }   
    /**
     * Obtener el nombre del estado
     * @return String
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Obtener la abreviatura del estado
     * @return String
     */
    public String getAbreviatura() {
        return abreviatura;
    }
    /**
     * Funcion para cargar los valores en la clase segun un id del estado que le pasen.
     * @param id Entero
     */
    public void Buscar(int id){
        Connection con = Conex.getInstance().getConnection();
        String cadSql = "SELECT * FROM estados WHERE id = ?";
        try {
            CallableStatement stm = con.prepareCall(cadSql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                this.id = Integer.parseInt(rs.getString(1));
                this.clave = rs.getString(2);
                this.nombre = rs.getString(3);
                this.abreviatura = rs.getString(4);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }
    /**
     * Función para cargar los valores en la clase segun un nombre de municipio que le pasen.
     * @param nombre 
     */
    public void Buscar(String nombre){
        Connection con = Conex.getInstance().getConnection();
        String cadSql = "SELECT * FROM estados WHERE nombre = ?";
        try {
            CallableStatement stm = con.prepareCall(cadSql);
            stm.setString(1, nombre);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                this.id = Integer.parseInt(rs.getString(1));
                this.clave = rs.getString(2);
                this.nombre = rs.getString(3);
                this.abreviatura = rs.getString(4);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    /**
     * Función para cargar los valores en la clase segun un nombre de municipio que le pasen. 
     * @return  
     */
    public String[][] Listar(){
        String[][] resultado = null;
        Connection con = Conex.getInstance().getConnection();
        String cadSql = "SELECT * FROM estados";
        try {
            CallableStatement stm = con.prepareCall(cadSql);
            ResultSet rs = stm.executeQuery();
            rs.last();
            resultado = new String[rs.getRow()][4];
            rs = stm.executeQuery();
            int i = 0;
            while(rs.next()){
                resultado[i][0]=rs.getString(1);
                resultado[i][1]=rs.getString(2);
                resultado[i][2]=rs.getString(3);
                resultado[i][3]=rs.getString(4);
                i++;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return resultado;
    }
    
}
