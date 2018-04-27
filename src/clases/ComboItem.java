/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author tomasTeifitV
 */
public class ComboItem {
    private int Id;
    private String Descripcion;

    public ComboItem(int Id, String Descripcion) {
        this.Id = Id;
        this.Descripcion = Descripcion;
    }

    public ComboItem() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    @Override
    public String toString() {
        return Descripcion;
    }
    
    
}
