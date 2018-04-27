/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Date;

/**
 *
 * @author JP
 */
public class DetalleEntrada {
    public int idDetalleEntrada; 
    public int idProducto; 
    public int entrada; 
    public String tipoEntrada; 
    public int idCompra; 
    public String caducidad; 

    public DetalleEntrada() {
        
    }

    public DetalleEntrada(int idDetalleEntrada, int idProducto, int entrada, String tipoEntrada, int idCompra, String caducidad) {
        this.idDetalleEntrada = idDetalleEntrada;
        this.idProducto = idProducto;
        this.entrada = entrada;
        this.tipoEntrada = tipoEntrada;
        this.idCompra = idCompra;
        this.caducidad = caducidad;
    }

    public int getIdDetalleEntrada() {
        return idDetalleEntrada;
    }

    public void setIdDetalleEntrada(int idDetalleEntrada) {
        this.idDetalleEntrada = idDetalleEntrada;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getEntrada() {
        return entrada;
    }

    public void setEntrada(int entrada) {
        this.entrada = entrada;
    }

    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(String caducidad) {
        this.caducidad = caducidad;
    }
    
    
    
}
