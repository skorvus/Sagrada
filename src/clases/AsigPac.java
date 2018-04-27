/*
 * Nombre del autor: Iván Ruiz Ramírez
                     Jose Luis Terraza Cortés
 * Fecha de creación: 2017/01/31
 * Nombre del proyecto: casaDescanso
 * Nombre del módulo: centralDeEnfermería
 * Breve descripción del contenido: Esta es la clase Asignación de pacientes, la cual contiene todos los datos/variables que necesita el DAOAsigPac.
 */
package clases;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author IvanR
 */
public class AsigPac {

    private int idPaciente, idEnfermera, idAsigPac;
    private int horaInicio, horaFin, minInicio, minFin, resHora, resMin;
    private String mensaje, nombreEnf, nombrePac,area;
    public DefaultTableModel tmodel = new DefaultTableModel();

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdEnfermera() {
        return idEnfermera;
    }

    public void setIdEnfermera(int idEnfermera) {
        this.idEnfermera = idEnfermera;
    }

    public int getIdAsigPac() {
        return idAsigPac;
    }

    public void setIdAsigPac(int idAsigPac) {
        this.idAsigPac = idAsigPac;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }

    public int getMinInicio() {
        return minInicio;
    }

    public void setMinInicio(int minInicio) {
        this.minInicio = minInicio;
    }

    public int getMinFin() {
        return minFin;
    }

    public void setMinFin(int minFin) {
        this.minFin = minFin;
    }

    public int getResHora() {
        return resHora;
    }

    public void setResHora(int resHora) {
        this.resHora = resHora;
    }

    public int getResMin() {
        return resMin;
    }

    public void setResMin(int resMin) {
        this.resMin = resMin;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombreEnf() {
        return nombreEnf;
    }

    public void setNombreEnf(String nombreEnf) {
        this.nombreEnf = nombreEnf;
    }

    public String getNombrePac() {
        return nombrePac;
    }

    public void setNombrePac(String nombrePac) {
        this.nombrePac = nombrePac;
    }

    public DefaultTableModel getTmodel() {
        return tmodel;
    }

    public void setTmodel(DefaultTableModel tmodel) {
        this.tmodel = tmodel;
    }

    public AsigPac() {
    }

    public AsigPac(int idPaciente, int idEnfermera, int idAsigPac, int horaInicio, int horaFin, int minInicio, int minFin, int resHora, int resMin, String mensaje, String nombreEnf, String nombrePac, String area) {
        this.idPaciente = idPaciente;
        this.idEnfermera = idEnfermera;
        this.idAsigPac = idAsigPac;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.minInicio = minInicio;
        this.minFin = minFin;
        this.resHora = resHora;
        this.resMin = resMin;
        this.mensaje = mensaje;
        this.nombreEnf = nombreEnf;
        this.nombrePac = nombrePac;
        this.area = area;
    }

    

}
