/**
 * Nombre de los autores: Dámaso Valdés Rosales.
 *                        Iván Ruiz Ramírez
 * Fecha de creación: 14/02/2017.
 * Nombre del proyecto: casaDescanso
 * Nombre del módulo: centralDeEnfermería
 * Breve descripción del contenido: Ésta es la clase de Registro de salud del paciente, en esta clase se encuentran
 * todos los datos que lleva un registro medico de un paciente y las demás variables que va a ocupar el DAORegistroSaludPac.
 */
package clases;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Damaso
 */
public class RegistroSaludPac {

    private int idRegistroDeSalud;
    private int idPaciente;
    private int idEnfermera;
    private int presionArtSis;
    private int presionArtDias;
    private int frecuenciaCar;
    private String temperatura;
    private int prePrandial;
    private int postPrandial;
    private String notas;
    private String fechaSalPac;
    private String mensaje;
    private String nomPac;
    private String nomEnf;
    public DefaultTableModel tmodel = new DefaultTableModel();

    public int getIdRegistroDeSalud() {
        return idRegistroDeSalud;
    }

    public void setIdRegistroDeSalud(int idRegistroDeSalud) {
        this.idRegistroDeSalud = idRegistroDeSalud;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdEnfermera() {
        return idEnfermera;
    }

    public void setIdEnfermera(int idEnfermera) {
        this.idEnfermera = idEnfermera;
    }
    
    public int getPresionArtSis() {
        return presionArtSis;
    }

    public void setPresionArtSis(int presionArtSis) {
        this.presionArtSis = presionArtSis;
    }

    public int getPresionArtDias() {
        return presionArtDias;
    }

    public void setPresionArtDias(int presionArtDias) {
        this.presionArtDias = presionArtDias;
    }

    public int getFrecuenciaCar() {
        return frecuenciaCar;
    }

    public void setFrecuenciaCar(int frecuenciaCar) {
        this.frecuenciaCar = frecuenciaCar;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public int getPrePrandial() {
        return prePrandial;
    }

    public void setPrePrandial(int prePrandial) {
        this.prePrandial = prePrandial;
    }

    public int getPostPrandial() {
        return postPrandial;
    }

    public void setPostPrandial(int postPrandial) {
        this.postPrandial = postPrandial;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getFechaSalPac() {
        return fechaSalPac;
    }

    public void setFechaSalPac(String fechaSalPac) {
        this.fechaSalPac = fechaSalPac;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNomPac() {
        return nomPac;
    }

    public void setNomPac(String nomPac) {
        this.nomPac = nomPac;
    }

    public String getNomEnf() {
        return nomEnf;
    }

    public void setNomEnf(String nomEnf) {
        this.nomEnf = nomEnf;
    }
    
    public DefaultTableModel getTmodel() {
        return tmodel;
    }

    public void setTmodel(DefaultTableModel tmodel) {
        this.tmodel = tmodel;
    }

    public RegistroSaludPac() {
    }

    public RegistroSaludPac(int idRegistroDeSalud, int idPaciente, int idEnfermera, int presionArtSis, int presionArtDias, int frecuenciaCar, String temperatura, int prePrandial, int postPrandial, String notas, String fechaSalPac, String mensaje, String nomPac, String nomEnf) {
        this.idRegistroDeSalud = idRegistroDeSalud;
        this.idPaciente = idPaciente;
        this.idEnfermera = idEnfermera;
        this.presionArtSis = presionArtSis;
        this.presionArtDias = presionArtDias;
        this.frecuenciaCar = frecuenciaCar;
        this.temperatura = temperatura;
        this.prePrandial = prePrandial;
        this.postPrandial = postPrandial;
        this.notas = notas;
        this.fechaSalPac = fechaSalPac;
        this.mensaje = mensaje;
        this.nomPac = nomPac;
        this.nomEnf = nomEnf;
    }

}
