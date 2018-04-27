/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author JP
 */
public class DaoDetalleEntrada extends DetalleEntrada {
    private String mensaje;
    Connection con;
    
    public DaoDetalleEntrada(int idDetalleProducto, int idProducto, int entrada, String tipoEntrada,int idCompra,String caducidad) {
        super(idDetalleProducto, idProducto,entrada,tipoEntrada,idCompra,caducidad);
    }

    public DaoDetalleEntrada() {
    }
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    public boolean agregar() {
        boolean res = false;
        con = clases.Conex.getInstance().getConnection();
        
        
    String cadSql = "{call sp_dete_ins1 (?,?,?,?)}";

        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setInt(1, getIdProducto());
            cstm.setInt(2, getEntrada());
            cstm.setString(3, getTipoEntrada());
            cstm.setString(4, getCaducidad());
            cstm.execute();
            res = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return res;
    }
    public boolean agregar2() {
        boolean res = false;
        con = clases.Conex.getInstance().getConnection();
        
        
    String cadSql = "{call sp_dete_ins2 (?,?,?,?)}";

        try {
            CallableStatement cstm = con.prepareCall(cadSql);
           cstm.setInt(1, getIdProducto());
            cstm.setInt(2, getEntrada());
            cstm.setString(3, getTipoEntrada());
            cstm.setString(4, getCaducidad());
            cstm.execute();
            res = true;
        } catch (SQLException ex) {
//            mensaje = ex.getMessage();
            JOptionPane.showMessageDialog(null,ex);
        }
        return res;
    }
    
    
}
