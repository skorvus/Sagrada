/*
 * Nombre del autor: Iván Ruiz Ramírez
 * Fecha de creación: 2017/01/31
 * Nombre del proyecto: casaDescanso
 * Nombre del módulo: centralDeEnfermería
 * Breve descripción del contenido: Esta es la clase DAO para pedidos de medicamentos, la cual contiene los metodos de agregar,buscar,modificar,eliminar y listar.
 */
package clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*; 
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
//import org.apache.log4j.varia.NullAppender;

/**
 *
 * @author IvanR
 */
public class DAOPedMed extends PedMed {

    public DAOPedMed(int idPedidoMed, int idEnfermera, int idPaciente, int idProducto, String depart, String fechaIngreso, String diagnost, String fechaPedMed, float dosis, String horarioEsp, String horarioMan, String horarioTarde, String horarioNoche, String descrPedMed, String nomPac, String nombreProductoGen, String nombreProductoPat, String enfermera, String mensaje) {
        super(idPedidoMed, idEnfermera, idPaciente, idProducto, depart, fechaIngreso, diagnost, fechaPedMed, dosis, horarioEsp, horarioMan, horarioTarde, horarioNoche, descrPedMed, nomPac, nombreProductoGen, nombreProductoPat, enfermera, mensaje);
    }

    public DAOPedMed() {
    }
    
    public boolean agregar() {
        Connection con;
        boolean res = false;
        con = Conex.getInstance().getConnection();
        String cadSql = "{call sp_insPedMed(?,?,?,?,?,?,?,?,?,?,?,?,?)};";
        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setInt(1, getIdEnfermera());
            cstm.setInt(2, getIdPaciente());
            cstm.setInt(3, getIdProducto());
            cstm.setString(4, getDepart());
            cstm.setString(5, getFechaIngreso());
            cstm.setString(6, getDiagnost());
            cstm.setString(7, getFechaPedMed());
            cstm.setFloat(8,getDosis());
            cstm.setString(9, getHorarioEsp());
            cstm.setString(10, getHorarioMan());
            cstm.setString(11, getHorarioTarde());
            cstm.setString(12, getHorarioNoche());
            cstm.setString(13, getDescrPedMed());
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
        String cadSql = "{call sp_modPedMed(?,?,?,?,?,?,?,?,?,?,?,?,?,?)};";
        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setInt(1,getIdPedidoMed());
            cstm.setInt(2, getIdEnfermera());
            cstm.setInt(3, getIdPaciente());
            cstm.setInt(4, getIdProducto());
            cstm.setString(5, getDepart());
            cstm.setString(6, getFechaIngreso());
            cstm.setString(7, getDiagnost());
            cstm.setString(8, getFechaPedMed());
            cstm.setFloat(9,getDosis());
            cstm.setString(10, getHorarioEsp());
            cstm.setString(11, getHorarioMan());
            cstm.setString(12, getHorarioTarde());
            cstm.setString(13, getHorarioNoche());
            cstm.setString(14, getDescrPedMed());
            cstm.execute();
            res = true;
        } catch (SQLException ex) {
            setMensaje(ex.getMessage());
        }
        return res;
    }
    
    public boolean autorizar() {
        Connection con;
        boolean res = false;
        con = Conex.getInstance().getConnection();
        String cadSql = "{call sp_autPedMed(?)};";
        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setInt(1,getIdPedidoMed());
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
        String cadSql = "{call sp_elimPedMed(?)};";
        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setInt(1,getIdPedidoMed());
            cstm.execute();
        } catch (SQLException ex) {
            setMensaje(ex.getMessage());
        }
    }
    
    public void eliminarMedSem() {
        Connection con;
        con = Conex.getInstance().getConnection();
        String cadSql = "{call sp_elimMedSem(?)};";
        try {
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setInt(1,getIdPedidoMed());
            cstm.execute();
        } catch (SQLException ex) {
            setMensaje(ex.getMessage());
        }
    }

    
    public void listar(){
        Connection con;
        try {
            con = Conex.getInstance().getConnection();
            String cadSql = "{call sp_listPedMed()};";
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
    
    public void listarCantidadPed(){
        Connection con;
        try {
            con = Conex.getInstance().getConnection();
            String cadSql = "{call sp_listCantPedMed()};";
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
    
    public void listarMedSem(){
        Connection con;
        try {
            con = Conex.getInstance().getConnection();
            String cadSql = "{call sp_listMedSem()};";
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
    
    public void filtrar(){
        Connection con;
        try {
            con = Conex.getInstance().getConnection();
            String cadSql = "{call sp_filtPed(?)};";
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setString(1, getNomPac());
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
    
    public void filtrarMedSem(){
        Connection con;
        String[] array;
        String fechaSem = getFechaPedMed(); 
        SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
        Calendar cal = Calendar.getInstance();
        
        try {
            cal.setTime(sdf.parse(fechaSem));
            cal.add(Calendar.DATE, 7);
            fechaSem = sdf.format(cal.getTime()); 
        } catch (ParseException ex) {
            Logger.getLogger(DAOPedMed.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            con = Conex.getInstance().getConnection();
            String cadSql = "{call sp_filtMedSem(?,?,?,?,?)};";
            array = getNomPac().split(" ");
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setString(1, getFechaPedMed());
            cstm.setString(2, fechaSem);
            cstm.setString(3, array[0]);
            cstm.setString(4,array[1]);
            cstm.setString(5, array[2]);
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
    
    public void detectarIdPaciente(){
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
            if(rs.next()){
                setIdPaciente(rs.getInt("idPaciente"));
            }
            else{
                JOptionPane.showMessageDialog(null,"No se encontró el idPaciente.");
            }
        } catch (SQLException ex) {
            setMensaje(ex.getMessage());
        }
    }
    
    public void detectarIdProd(){
        Connection con;
        try {
            con = Conex.getInstance().getConnection();
            String cadSql = "{call sp_cmbIdMed(?,?)};";
            CallableStatement cstm = con.prepareCall(cadSql);
            cstm.setString(1,getNombreProductoGen());
            cstm.setString(2,getNombreProductoPat());
            ResultSet rs = cstm.executeQuery();
            if(rs.next()){
                setIdProducto(rs.getInt("idProducto"));
            }
            else{
                JOptionPane.showMessageDialog(null,"No se encontró el idProducto.");
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
            array = getEnfermera().split(" ");
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
    
    public void generarReporte(String dateSem){
        Connection con;
        try{
            //org.apache.log4j.BasicConfigurator.configure(new NullAppender()); //Sirve para evitar la configuracion del log4j.
            con = Conex.getInstance().getConnection();
            HashMap parametro = new HashMap();
            parametro.put("my_fechaPedMed", dateSem);
            String ruta = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
            ruta = ruta.split("build")[0] + "src/pantallas/reportMed.jrxml";
            JasperReport contenido = JasperCompileManager.compileReport(ruta);
            JasperPrint imprimir = JasperFillManager.fillReport(contenido, parametro, con);
            JasperViewer.viewReport(imprimir,false);
        } catch (JRException ex) {
            Logger.getLogger(DAOPedMed.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
