/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 * Miguel Alfonso Guevara Hernández
 * 07/02/2017
 * Casa de descanso
 * Farmacia
 * La clase Administración contiene las variables y funciones que se utilizaran en 
 * el proyecto y se estandarizaron para tener los mismos nombres que en la 
 * base de datos.
 */
public class Administracion {
    
    public int idAdministracion;
    public String administracion;

    public Administracion() {
    }
    
    /** 
     * Constructor con atributos Administracion.
     * @param idAdministracion
     * @param administracion 
     */

    public Administracion(int idAdministracion, String administracion) {
        this.idAdministracion = idAdministracion;
        this.administracion = administracion;
    }

    public int getIdAdministracion() {
        return idAdministracion;
    }

    public void setIdAdministracion(int idAdministracion) {
        this.idAdministracion = idAdministracion;
    }

    public String getAdministracion() {
        return administracion;
    }

    public void setAdministracion(String administracion) {
        this.administracion = administracion;
    }
    
    
    
    
}
