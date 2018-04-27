/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author JP
 */
public class DaoAsignacion extends Asignacion {
    private String mensaje;
    Connection con;

    public DaoAsignacion(int idAsignacion, int idPaciente, int idProducto, int cantidad) {
        super(idAsignacion, idPaciente, idProducto, cantidad);
    }
    
    public DaoAsignacion() {
        
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public boolean agregar(){
        boolean res = false;
        con = clases.Conex.getInstance().getConnection();
        String cadSql = "{call sp_asi_ins (?)}";

        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setInt(1, getIdPaciente());
            cstm.execute();
            res = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return res;
    }
    
    public boolean detalle(){
        boolean res = false;
         String cadSql = "{call sp_deta_ins (?,?)}";

        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setInt(1, getIdProducto());
            cstm.setInt(2, getCantidad());
            cstm.execute();
            res = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return res;
    }
    
}
