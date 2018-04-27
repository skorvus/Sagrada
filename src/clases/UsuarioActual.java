/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author mikya
 */
public class UsuarioActual {
    
    public static String usuarioActual;

    public UsuarioActual() {
    }

    public static String getUsuarioActual() {
        return usuarioActual;
    }

    public static void setUsuarioActual(String usuarioActual) {
        UsuarioActual.usuarioActual = usuarioActual;
    }
    
}
