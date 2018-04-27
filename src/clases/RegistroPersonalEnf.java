/*
 * Nombre del autor: Iván Ruiz Ramírez
                     Jose Luis Terraza Cortés
                     Dámaso Valdés Rosales
 * Fecha de creación: 2017/01/31
 * Nombre del proyecto: casaDescanso
 * Nombre del módulo: centralDeEnfermería
 * Breve descripción del contenido: Esta es la clase de registro de personal de enfermería, la cual contiene los campos y constructores
 *  relacionados al personal y practicantes que se encuentran en la central de enfermería.
 */
package clases;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author IvanR
 */
public class RegistroPersonalEnf {
    private int idEnfermera;
    private String nombreEnfermera,apellidoPatEnf,apellidoMatEnf,especialidad,tipoDeIngreso, fechaIn, fechaTerm,estatus,descrEstatus,telefonoEnf,correoEnf,mensaje;
    public DefaultTableModel tmodel = new DefaultTableModel();
    
    public int getIdEnfermera() {
        return idEnfermera;
    }

    public void setIdEnfermera(int idEnfermera) {
        this.idEnfermera = idEnfermera;
    }

    public String getNombreEnfermera() {
        return nombreEnfermera;
    }

    public void setNombreEnfermera(String nombreEnfermera) {
        this.nombreEnfermera = nombreEnfermera;
    }

    public String getApellidoPatEnf() {
        return apellidoPatEnf;
    }

    public void setApellidoPatEnf(String apellidoPatEnf) {
        this.apellidoPatEnf = apellidoPatEnf;
    }

    public String getApellidoMatEnf() {
        return apellidoMatEnf;
    }

    public void setApellidoMatEnf(String apellidoMatEnf) {
        this.apellidoMatEnf = apellidoMatEnf;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTipoDeIngreso() {
        return tipoDeIngreso;
    }

    public void setTipoDeIngreso(String tipoDeIngreso) {
        this.tipoDeIngreso = tipoDeIngreso;
    }

    public String getFechaIn() {
        return fechaIn;
    }

    public void setFechaIn(String fechaIn) {
        this.fechaIn = fechaIn;
    }

    public String getFechaTerm() {
        return fechaTerm;
    }

    public void setFechaTerm(String fechaTerm) {
        this.fechaTerm = fechaTerm;
    }
    
    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getDescrEstatus() {
        return descrEstatus;
    }

    public void setDescrEstatus(String descrEstatus) {
        this.descrEstatus = descrEstatus;
    }

    public String getTelefonoEnf() {
        return telefonoEnf;
    }

    public void setTelefonoEnf(String telefonoEnf) {
        this.telefonoEnf = telefonoEnf;
    }

    public String getCorreoEnf() {
        return correoEnf;
    }

    public void setCorreoEnf(String correoEnf) {
        this.correoEnf = correoEnf;
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

    
    
    public RegistroPersonalEnf() {
    }

    public RegistroPersonalEnf(int idEnfermera, String nombreEnfermera, String apellidoPatEnf, String apellidoMatEnf, String especialidad, String tipoDeIngreso, String fechaIn, String fechaTerm, String estatus, String descrEstatus, String telefonoEnf, String correoEnf, String mensaje) {
        this.idEnfermera = idEnfermera;
        this.nombreEnfermera = nombreEnfermera;
        this.apellidoPatEnf = apellidoPatEnf;
        this.apellidoMatEnf = apellidoMatEnf;
        this.especialidad = especialidad;
        this.tipoDeIngreso = tipoDeIngreso;
        this.fechaIn = fechaIn;
        this.fechaTerm = fechaTerm;
        this.estatus = estatus;
        this.descrEstatus = descrEstatus;
        this.telefonoEnf = telefonoEnf;
        this.correoEnf = correoEnf;
        this.mensaje = mensaje;
    }
    
}
