/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;


/**
 * Miguel Angel Preciado Valerio
 * 31/01/2017
 * Casa de descanso
 * Farmacia
 * La clase Prodcucto contiene las variables y funciones que se utilizaran en 
 * el proyecto y se estandarizaron para tener los mismos nombres que en la 
 * base de datos.
 */
public class Producto { 

    
   int idProducto;
   String  nombreProductoPat; 
   String nombreProductoGen;
   String  contenidoCaja; 
   int stockActual; 
   int stockMinimo;
   int administracion; 
   int tipo; 
  

    public Producto() {
    }

    public Producto(int idProducto, String nombreProductoPat, String nombreProductoGen, String contenidoCaja, int stockActual, int stockMinimo, int administracion, int tipo) {
        this.idProducto = idProducto;
        this.nombreProductoPat = nombreProductoPat;
        this.nombreProductoGen = nombreProductoGen;
        this.contenidoCaja = contenidoCaja;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.administracion = administracion;
        this.tipo = tipo;
    }

    /**
     * Constructor con atributos de producto
     * @param idProducto
     * @param nombreProductoPat
     * @param nombreProductoGen
     * @param contenidoCaja
     * @param stockActual
     * @param stockMinimo
     * @param administracion
     * @param tipo 
     */
    

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProductoPat() {
        return nombreProductoPat;
    }

    public void setNombreProductoPat(String nombreProductoPat) {
        this.nombreProductoPat = nombreProductoPat;
    }

    public String getNombreProductoGen() {
        return nombreProductoGen;
    }

    public void setNombreProductoGen(String nombreProductoGen) {
        this.nombreProductoGen = nombreProductoGen;
    }


    public String getContenidoCaja() {
        return contenidoCaja;
    }

    public void setContenidoCaja(String contenidoCaja) {
        this.contenidoCaja = contenidoCaja;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public int getAdministracion() {
        return administracion;
    }

    public void setAdministracion(int administracion) {
        this.administracion = administracion;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    
    

    
    
}