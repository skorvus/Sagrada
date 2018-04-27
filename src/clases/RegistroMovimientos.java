/*
 * Titulo: Modulo paciente.
 * Este programa se realizó para la organización "La sagrada familia A.C".
 * Clase de los constructores, getters y setters(de los atributos) para el objeto RegistroMovimientos.
 * @version 25/02/2017
 */
package clases;

/**
 *
 * @author Wicho
 */
public class RegistroMovimientos {

    private int IdRegistro;
    private int NoExpediente;
    private int IdPaciente;
    private String Descripcion;
    private String Autorizado;
    private String Motivos;
    private String Comentarios;

    public RegistroMovimientos() {
    }

    public RegistroMovimientos(int IdRegistro, int NoExpediente, int IdPaciente, String Descripcion, String Autorizado, String Motivos, String Comentarios) {
        this.IdRegistro = IdRegistro;
        this.NoExpediente = NoExpediente;
        this.IdPaciente = IdPaciente;
        this.Descripcion = Descripcion;
        this.Autorizado = Autorizado;
        this.Motivos = Motivos;
        this.Comentarios = Comentarios;
    }

    public int getNoExpediente() {
        return NoExpediente;
    }

    public void setNoExpediente(int NoExpediente) {
        this.NoExpediente = NoExpediente;
    }

    

    public int getIdRegistro() {
        return IdRegistro;
    }

    public void setIdRegistro(int IdRegistro) {
        this.IdRegistro = IdRegistro;
    }

    public int getIdPaciente() {
        return IdPaciente;
    }

    public void setIdPaciente(int IdPaciente) {
        this.IdPaciente = IdPaciente;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getAutorizado() {
        return Autorizado;
    }

    public void setAutorizado(String Autorizado) {
        this.Autorizado = Autorizado;
    }

    public String getMotivos() {
        return Motivos;
    }

    public void setMotivos(String Motivos) {
        this.Motivos = Motivos;
    }

    public String getComentarios() {
        return Comentarios;
    }

    public void setComentarios(String Comentarios) {
        this.Comentarios = Comentarios;
    }
    
    
}
