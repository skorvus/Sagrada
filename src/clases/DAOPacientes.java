/*
 * Titulo: Modulo paciente.
 * Este programa se realizó para la organización "La sagrada familia A.C".
 * Clase para generar todos los metodos para el objeto Pacientes.
 * @version 25/02/2017
 */
package clases;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 * @author Pablo Alberto Rodirguez Lopez.
 * @author Tomas Alejandro Vargas Lopez.
 * @author Jose Luis Tinajero Carvajal.
 */
public class DAOPacientes extends Pacientes {
    Pacientes paciente = new Pacientes();
    private String mensaje;
    Connection con;

    public DAOPacientes(int idPaciente, String nombre, String apPat, String apMat, int noExpediente, char actaIfe, char estado, String estadoCivil, String fechaNac, String EstadoProcedencia, String MunicipioProcedencia, String EstadoOrigen, String MunicipioOrigen, String tpPaciente, String seguro, String tpSangre, String Alergias, String fechaIngreso, String areas, String diagnostico, String tel) {
        super(idPaciente, nombre, apPat, apMat, noExpediente, actaIfe, estado, estadoCivil, fechaNac, EstadoProcedencia, MunicipioProcedencia, EstadoOrigen, MunicipioOrigen, tpPaciente, seguro, tpSangre, Alergias, fechaIngreso, areas, diagnostico, tel);
    }


    public DAOPacientes() {
    }
    
    public String getMensaje(){
        return mensaje;
    }
    public void setMensaje(String msg){
         mensaje = msg;
    }
    
    
    
    
    public  boolean agregar(){
        System.out.println("Inicio de agregado");
        boolean res= false;
        con = Conex.getInstance().getConnection();

        String cadSql= "call ins_Paciente("+
           "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
       try {
           CallableStatement pstm = con.prepareCall(cadSql);
           pstm.setString(1,super.getNombre());
           pstm.setString(2, super.getApPat());
           pstm.setString(3, super.getApMat());
           pstm.setInt(4, super.getNoExpediente());
           pstm.setString(5, super.getEstadoCivil());
           pstm.setString(6, super.getFechaNac());
           pstm.setString(7, super.getEstadoProcedencia());
           pstm.setString(8, super.getMunicipioProcedencia());
           pstm.setString(9, super.getEstadoOrigen());
           pstm.setString(10, super.getMunicipioOrigen());
           pstm.setString(11, ""+super.getSeguro());
           pstm.setString(12, super.getTel());
           pstm.setString(13, super.getTpPaciente());
           pstm.setString(14, super.getAreas());
           pstm.setString(15, super.getTpSangre());
           pstm.setString(16, super.getDiagnostico());
           pstm.setString(17, super.getAlergias());
           pstm.setString(18,""+super. getActaIfe());
           System.out.println("Se mando a ejecutar");
           pstm.executeUpdate();
           System.out.println("Se agregó exitosamente");
           res = true;
       } catch (SQLException ex) {
           mensaje = ex.getMessage();
           System.out.println(mensaje);
       }                  
        return res;
    }
    
//<editor-fold defaultstate="collapsed" desc="eliminar">
     public boolean eliminar() {
        boolean res = false;
        con = Conex.getInstance().getConnection();
        try {
            CallableStatement pstm = con.prepareCall("call delete_Paciente (?)");
            pstm.setInt(1, super.getIdPaciente());
            pstm.execute();
            res = true;
        } catch (SQLException ex) {
           mensaje = ex.getMessage();
           System.out.println(mensaje);
       }  
        return res;
    }
//</editor-fold>
     
    public boolean modificar() {
        boolean res = false;
        con = Conex.getInstance().getConnection();
        try {
            CallableStatement pstm = con.prepareCall("call update_Paciente("
                    + " ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
           pstm.setString(1,super.getNombre());
           pstm.setString(2, super.getApPat());
           pstm.setString(3, super.getApMat());
           pstm.setInt(4, super.getNoExpediente());
           pstm.setString(5, super.getEstadoCivil());
           pstm.setString(6, super.getFechaNac());
           pstm.setString(7, super.getEstadoProcedencia());
           pstm.setString(8, super.getMunicipioProcedencia());
           pstm.setString(9, super.getEstadoOrigen());
           pstm.setString(10, super.getMunicipioOrigen());
           pstm.setString(11, ""+super.getSeguro());
           pstm.setString(12, super.getTel());
           pstm.setString(13, super.getTpPaciente());
           //pstm.setNull(13,"");
           pstm.setString(14, super.getAreas());
           pstm.setString(15, super.getTpSangre());
           pstm.setString(16, super.getDiagnostico());
           pstm.setString(17, super.getAlergias());
           pstm.setInt(18, super.getIdPaciente());
           pstm.setString(19,""+super. getActaIfe());
            pstm.execute();

            res = true;
        } catch (SQLException ex) {
           mensaje = ex.getMessage();
           System.out.println(mensaje);
       } 
        return res;
    }
    
    public boolean activar() {
        boolean res = false;
        con = Conex.getInstance().getConnection();
        try {
            CallableStatement pstm = con.prepareCall("call Activar_Paciente("
                    + " ?)");
           pstm.setInt(1,super.getNoExpediente());
           pstm.execute();
            res = true;
        } catch (SQLException ex) {
           mensaje = ex.getMessage();
           System.out.println(mensaje);
       } 
        return res;
    }
    public boolean Desactivar() {
        boolean res = false;
        con = Conex.getInstance().getConnection();
        try {
            CallableStatement pstm = con.prepareCall("call Desactivar_Paciente("
                    + " ?)");
           pstm.setInt(1,super.getNoExpediente());
           pstm.execute();
            res = true;
        } catch (SQLException ex) {
           mensaje = ex.getMessage();
           System.out.println(mensaje);
       } 
        return res;
    }
    
    public boolean buscar() {
        boolean res = false;
        con = Conex.getInstance().getConnection();
        try {
            CallableStatement stm = con.prepareCall("call search_Paciente(?)");
            stm.setInt(1, super.getIdPaciente());
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {  
                super.setIdPaciente(rs.getInt("IDPaciente"));
                super.setNombre(rs.getString("Nombre"));
                super.setApPat(rs.getString("ApPat"));
                super.setApMat(rs.getString( "ApMat"));
                super.setNoExpediente(rs.getInt("NoExpediente"));
                super.setActaIfe(rs.getString("ActaIfe").charAt(0));
                super.setEstado(rs.getString("estado").charAt(0));
                super.setEstadoCivil(rs.getString( "estadoCivil"));
                super.setFechaNac(rs.getString( "fechaNac"));
                super.setEstadoProcedencia(rs.getString( "EstadoProcedencia"));
                super.setMunicipioProcedencia(rs.getString( "MunicipioProcedencia"));
                super.setSeguro(rs.getString("seguro"));
                super.setEstadoOrigen(rs.getString("EstadoOrigen"));
                super.setMunicipioOrigen(rs.getString( "MunicipioOrigen"));
                super.setTel(rs.getString("telefono"));
                super.setTpPaciente(rs.getString("TpPaciente"));
                super.setTpSangre(rs.getString("tpSangre"));
                super.setAlergias(rs.getString("Alergias"));
                super.setFechaIngreso(rs.getString("fechaIngreso"));
                super.setAreas(rs.getString("area"));
                super.setDiagnostico(rs.getString("diagnostico"));
                
                res = true;
            }
        } catch (SQLException ex) {
           mensaje = ex.getMessage();
           System.out.println(mensaje);
       } 
        return res;
    }
    
    
    
    public DefaultTableModel listar() {
        DefaultTableModel tmodel = new DefaultTableModel();
        con = Conex.getInstance().getConnection();
        try {
            CallableStatement stm = con.prepareCall("call list_Paciente()");
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
           System.out.println(mensaje);
       } 
        return tmodel;
    }

//<editor-fold defaultstate="collapsed" desc="FiltrarPacientes">
    public ArrayList<ComboItem> filtrarPacientes(String filtro){
        ArrayList<ComboItem> pacientes = new ArrayList<>();
        con = Conex.getInstance().getConnection();
        String nombre="";
        int id= 0;
        try {
            CallableStatement cstm = con.prepareCall("CALL filtrar_Pacientes(?)");
            cstm.setString(1, filtro);
            ResultSet rs = cstm.executeQuery();
            while(rs.next()){
                id = rs.getInt("IdPaciente");
                nombre = rs.getString("Nombre_Completo");
                pacientes.add(new ComboItem(id,nombre));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pacientes;
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="setPaciente">
    public void setPaciente(Pacientes pac){
        super.setIdPaciente(pac.getIdPaciente());
        super.setNombre(pac.getNombre());
        super.setApPat(pac.getApPat());
        super.setApMat(pac.getApMat());
        super.setNoExpediente(pac.getNoExpediente());
        super.setActaIfe(pac.getActaIfe());
        super.setEstadoCivil(pac.getEstadoCivil());
        super.setFechaNac(pac.getFechaNac());
        super.setEstadoProcedencia(pac.getEstadoProcedencia());
        super.setMunicipioProcedencia(pac.getMunicipioProcedencia());
        super.setSeguro(pac.getSeguro());
        super.setEstadoOrigen(pac.getEstadoOrigen());
        super.setMunicipioOrigen(pac.getMunicipioOrigen());
        super.setTel(pac.getTel());
        super.setTpSangre(pac.getTpSangre());
        super.setAlergias(pac.getAlergias());
        super.setDiagnostico(pac.getDiagnostico());
        super.setTpPaciente(pac.getTpPaciente());
        super.setFechaIngreso(pac.getFechaIngreso());
        super.setAreas(pac.getAreas());
        super.setEstado(pac.getEstado());
        super.setActivo(pac.getActivo());
    }
    //</editor-fold>
}
