/*
 * Nombre del autor: Iván Ruiz Ramírez
 * Fecha de creación: 2017/01/31
 * Nombre del proyecto: casaDescanso
 * Nombre del módulo: centralDeEnfermería
 * Breve descripción del contenido: Esta es la clase PedMed, la cual contiene todas las variables que se van a ocupar para los métodos del DAOPedMed.
 */
package clases;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author IvanR
 */
public class PedMed {
    private int idPedidoMed;
    private int idEnfermera;
    private int idPaciente;
    private int idProducto;
    private String depart;
    private String fechaIngreso;
    private String diagnost;
    private String fechaPedMed;
    private float dosis;
    private String horarioEsp;
    private String horarioMan;
    private String horarioTarde;
    private String horarioNoche;
    private String descrPedMed;
    private String nomPac;
    private String nombreProductoGen;
    private String nombreProductoPat;
    private String enfermera;
    private String mensaje;
    public DefaultTableModel tmodel = new DefaultTableModel();

    public int getIdPedidoMed() {
        return idPedidoMed;
    }

    public void setIdPedidoMed(int idPedidoMed) {
        this.idPedidoMed = idPedidoMed;
    }

    public int getIdEnfermera() {
        return idEnfermera;
    }

    public void setIdEnfermera(int idEnfermera) {
        this.idEnfermera = idEnfermera;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getDiagnost() {
        return diagnost;
    }

    public void setDiagnost(String diagnost) {
        this.diagnost = diagnost;
    }

    public String getFechaPedMed() {
        return fechaPedMed;
    }

    public void setFechaPedMed(String fechaPedMed) {
        this.fechaPedMed = fechaPedMed;
    }

    public float getDosis() {
        return dosis;
    }

    public void setDosis(float dosis) {
        this.dosis = dosis;
    }

    public String getHorarioEsp() {
        return horarioEsp;
    }

    public void setHorarioEsp(String horarioEsp) {
        this.horarioEsp = horarioEsp;
    }

    public String getHorarioMan() {
        return horarioMan;
    }

    public void setHorarioMan(String horarioMan) {
        this.horarioMan = horarioMan;
    }

    public String getHorarioTarde() {
        return horarioTarde;
    }

    public void setHorarioTarde(String horarioTarde) {
        this.horarioTarde = horarioTarde;
    }

    public String getHorarioNoche() {
        return horarioNoche;
    }

    public void setHorarioNoche(String horarioNoche) {
        this.horarioNoche = horarioNoche;
    }

    public String getDescrPedMed() {
        return descrPedMed;
    }

    public void setDescrPedMed(String descrPedMed) {
        this.descrPedMed = descrPedMed;
    }
    
    public String getNomPac() {
        return nomPac;
    }

    public void setNomPac(String nomPac) {
        this.nomPac = nomPac;
    }

    public String getNombreProductoGen() {
        return nombreProductoGen;
    }

    public void setNombreProductoGen(String nombreProductoGen) {
        this.nombreProductoGen = nombreProductoGen;
    }

    public String getNombreProductoPat() {
        return nombreProductoPat;
    }

    public void setNombreProductoPat(String nombreProductoPat) {
        this.nombreProductoPat = nombreProductoPat;
    }

    public String getEnfermera() {
        return enfermera;
    }

    public void setEnfermera(String enfermera) {
        this.enfermera = enfermera;
    }
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public DefaultTableModel getTmodel() {
        return tmodel;
    }

    public void setTmodel(DefaultTableModel tmodel) {
        this.tmodel = tmodel;
    }
    
    public PedMed() {
    }

    public PedMed(int idPedidoMed, int idEnfermera, int idPaciente, int idProducto, String depart, String fechaIngreso, String diagnost, String fechaPedMed, float dosis, String horarioEsp, String horarioMan, String horarioTarde, String horarioNoche, String descrPedMed, String nomPac, String nombreProductoGen, String nombreProductoPat, String enfermera, String mensaje) {
        this.idPedidoMed = idPedidoMed;
        this.idEnfermera = idEnfermera;
        this.idPaciente = idPaciente;
        this.idProducto = idProducto;
        this.depart = depart;
        this.fechaIngreso = fechaIngreso;
        this.diagnost = diagnost;
        this.fechaPedMed = fechaPedMed;
        this.dosis = dosis;
        this.horarioEsp = horarioEsp;
        this.horarioMan = horarioMan;
        this.horarioTarde = horarioTarde;
        this.horarioNoche = horarioNoche;
        this.descrPedMed = descrPedMed;
        this.nomPac = nomPac;
        this.nombreProductoGen = nombreProductoGen;
        this.nombreProductoPat = nombreProductoPat;
        this.enfermera = enfermera;
        this.mensaje = mensaje;
    }
    
    
}
