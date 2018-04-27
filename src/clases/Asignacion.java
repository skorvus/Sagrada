/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 * Juan Pablo Vazquez Ruiz
 * 17/03/2017
 * Casa de descanso
 * Farmacia
 * La clase Asignacion contiene las variables y funciones que se utilizaran en 
 * el proyecto y se estandarizaron para tener los mismos nombres que en la 
 * base de datos.
 */
public class Asignacion {
   public int idAsignacion;
   public int idPaciente;
   public int idProducto;
   public int cantidad;
   
    public Asignacion() {
    }

    public Asignacion(int idAsignacion, int idPaciente, int idProducto,int cantidad) {
        this.idAsignacion = idAsignacion;
        this.idPaciente = idPaciente;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public int getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(int idAsignacion) {
        this.idAsignacion = idAsignacion;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
   
   
}
