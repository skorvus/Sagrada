/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author joelfc
 */
public class DaoUsuario extends Usuario{

    public DaoUsuario(String clave, String password, String nombre, String appat, String apmat, int mPacientes, int mFarmacia, int mBenefactores, int mCtrlEnf, int mInventario, int mPersMed, int mUsuarios) {
        super(clave, password, nombre, appat, apmat, mPacientes, mFarmacia, mBenefactores, mCtrlEnf, mInventario, mPersMed,mUsuarios);
    }

    public DaoUsuario() {
     super();
    }
    
    public boolean cambiarPassword(String user, String pass){
        boolean res = false;
        Connection micon = Conex.getInstance().getConnection();
            String  cadSql = "update usuarios set password =? where clave=?";
            try {
                PreparedStatement pstm = micon.prepareStatement(cadSql);
                pstm.setString(1, pass);
                pstm.setString(2, user);
                pstm.execute();
                res=true;
            } catch (SQLException ex) {
                Logger.getLogger(DAOPacientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            return res;
    }
    
    public boolean modificar(){
    boolean res = false;
    if(this.getClave().equals("")||this.getNombre().equals("")||this.getApmat().equals("")||this.getAppat().equals("")){
            res = false;
        }else{
            Connection micon = Conex.getInstance().getConnection();
            String  cadSql = "update usuarios set nombre=?, appat=?,apmat=?,"+
                    "mpacientes=?,mfarmacia=?,mbenefactores=?,mctrlenf=?,minventario=?,mpersmed=?,musuarios=? where clave=?";
            try {
                PreparedStatement pstm = micon.prepareStatement(cadSql);
                pstm.setString(1, this.getNombre());
                pstm.setString(2, this.getAppat());
                pstm.setString(3, this.getApmat());
                pstm.setInt(4, this.getmPacientes());
                pstm.setInt(5, this.getmFarmacia());
                pstm.setInt(6, this.getmBenefactores());
                pstm.setInt(7,this.getmCtrlEnf());
                pstm.setInt(8, this.getmInventario());
                pstm.setInt(9, this.getmPersMed());
                pstm.setInt(10, this.getmUsuarios());
                pstm.setString(11, this.getClave());
                pstm.execute();
                res=true;
            } catch (SQLException ex) {
                Logger.getLogger(DAOPacientes.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    return res;
}
    public Usuario buscar(){
        Usuario ux= new Usuario();
       Connection micon = Conex.getInstance().getConnection();
       PreparedStatement pstm;
        ResultSet rs;
        try {
            pstm = micon.prepareStatement("Select * from usuarios where clave=?");
            pstm.setString(1, this.getClave());
            rs =pstm.executeQuery();
            if(rs.next()){
                ux.setClave(rs.getString("clave"));
                ux.setNombre(rs.getString("nombre"));
                ux.setAppat(rs.getString("appat"));
                ux.setApmat(rs.getString("apmat"));
                ux.setmPacientes(rs.getInt("mpacientes"));
                ux.setmFarmacia(rs.getInt("mfarmacia"));
                ux.setmCtrlEnf(rs.getInt("mctrlenf"));
                ux.setmBenefactores(rs.getInt("mbenefactores"));
                ux.setmInventario(rs.getInt("minventario"));
                ux.setmUsuarios(rs.getInt("musuarios"));
                ux.setmPersMed(rs.getInt("mpersmed"));
                                
            }else{
                ux=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return ux;
    }
    public boolean agregar(){
        Connection cone = Conex.getInstance().getConnection();
        boolean res = false;
        if(this.getClave().equals("")||this.getNombre().equals("")||this.getApmat().equals("")||this.getAppat().equals("")){
            res = false;
        }else{
            try {
               CallableStatement cstm = cone.prepareCall("{call insuser(?,?,?,?,?,?,?,?,?,?,?,?)}");
               cstm.setString(1,this.getClave());
               cstm.setString(2,this.getPassword());
               cstm.setString(3,this.getNombre());
               cstm.setString(4,this.getAppat());
               cstm.setString(5,this.getApmat());
               cstm.setInt(6,this.getmPacientes());
               cstm.setInt(7,this.getmFarmacia());
               cstm.setInt(8,this.getmCtrlEnf());
               cstm.setInt(9,this.getmBenefactores());
               cstm.setInt(10,this.getmInventario());
               cstm.setInt(11,this.getmPersMed());
               cstm.setInt(12, this.getmUsuarios());
               res= cstm.execute();
               res = true;

           } catch (SQLException ex) {
               Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
           }   
        }
        
        
        return res;
    }
}
