/*
 * Nombre del autor: Dámaso Valdés Rosales
 * Fecha de creación: 2017/03/12
 * Nombre del proyecto: casaDescanso
 * Nombre del módulo: centralDeEnfermería
 * Breve descripción del contenido: Esta es la clase para validar los login de los usuarios.
 */
package clases;


import pantallas.frmxLogin;
import javax.swing.JOptionPane;
import pantallas.frmIncidencias;
import pantallas.frmRegSaludPac;

/**
 *
 * @author Damaso
 */
public class LoginEnf {
    private String usuario;
    private String password;
    frmIncidencias frmIn = new frmIncidencias();
    frmxLogin frmLogIn = new frmxLogin();
    
    public LoginEnf() {
    }

    public LoginEnf(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void validarLogin(){
        if(usuario.equals("") || password.equals("")){
            JOptionPane.showMessageDialog(null, "Favor de llenar ambos campos");
            frmLogIn.setVisible(true);
        }else{
            if(usuario.equals("UsuarioCentral") && password.equals("CtrlEnf")){
                JOptionPane.showMessageDialog(null, "Acceso Autorizado");
                frmIn.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrectos");
                frmLogIn.setVisible(true);
            }
        }
    }
}
