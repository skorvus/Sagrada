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
 * en el combobox Tipo dentro de el frame frmProducto.
 */
public class comboItemTipo {
    private int idTipo;
    private String tipo;

    public comboItemTipo(int idTipo, String tipo) {
        this.idTipo = idTipo;
        this.tipo = tipo;
    }

//    public comboItemTipo() {
//        
//    }

    public int getIdTipo() {
        return idTipo;
    }

    @Override
    public String toString() {
        return tipo;
    }
    
    
    
}
