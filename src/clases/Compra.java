/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author JP
 */
public class Compra {
    public int idCompra; 
    public String farmacia;
    public String numFactura; 
    public double costo;

    public Compra() {
    }

    public Compra(int idCompra, String farmacia, String numFactura, double costo) {
        this.idCompra = idCompra;
        this.farmacia = farmacia;
        this.numFactura = numFactura;
        this.costo = costo;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(String farmacia) {
        this.farmacia = farmacia;
    }

    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    
    
    
}
