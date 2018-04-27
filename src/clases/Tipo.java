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
 * La clase Tipo contiene las variables y funciones que se utilizaran en 
 * el proyecto y se estandarizaron para tener los mismos nombres que en la 
 * base de datos.
 */
public class Tipo {
    
    public int idTipo;
    public String tipo;

    public Tipo() {
    } 
    /** 
     * Constructor con atributos de Tipo.
     * @param idTipo
     * @param tipo 
     */

    public Tipo(int idTipo, String tipo) {
        this.idTipo = idTipo;
        this.tipo = tipo;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
   
}
