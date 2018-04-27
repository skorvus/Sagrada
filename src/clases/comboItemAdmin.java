/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Juan Pablo Vazquez Ruiz 
 * Clase que posteriormente nos permite cargar un el valor obtenido del toString, 
 * en el combobox Administracion dentro de el frame frmProducto.
 */
public class comboItemAdmin {
    private int idAdministracion;
    private String administracion;

    public comboItemAdmin(int idAdministracion, String administracion) {
        this.idAdministracion = idAdministracion;
        this.administracion = administracion;
    }

    public comboItemAdmin() {
       
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
    

    @Override
    public String toString() {
        return  administracion;
    }
    
    
    
}
