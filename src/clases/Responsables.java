/*
 * Titulo: Modulo paciente.
 * Este programa se realizó para la organización "La sagrada familia A.C".
 * Clase de los constructores, getters y setters(de los atributos) para el objeto Responsables.
 * @version 25/02/2017
 */
package clases;

/**
 * @author Pablo Alberto Rodirguez Lopez.
 * @author Tomas Alejandro Vargas Lopez.
 * @author Jose Luis Tinajero Carvajal.
 */
public class Responsables {
    private int idPaciente;
    private int idResponsable;
    private  char activo = '1';//si o no
    private String nombreResponsable;
    private String apPatResponsable;
    private String apMatResponsable;
    private String tel;
    private String relacion;
    private String calle;
    private String noExt;
    private String noInt;
    private String colonia;
    private String cP;
    private String municipioResponsable;
    private String estadoResponsable;

    public Responsables() {
    }

    public Responsables(int idPaciente, int idResponsable, String nombreResponsable, String apPatResponsable, String apMatResponsable, String tel, String relacion, String calle, String noExt, String noInt, String colonia, String cP, String municipioResponsable, String estadoResponsable) {
        this.idPaciente = idPaciente;
        this.idResponsable = idResponsable;
        this.nombreResponsable = nombreResponsable;
        this.apPatResponsable = apPatResponsable;
        this.apMatResponsable = apMatResponsable;
        this.tel = tel;
        this.relacion = relacion;
        this.calle = calle;
        this.noExt = noExt;
        this.noInt = noInt;
        this.colonia = colonia;
        this.cP = cP;
        this.municipioResponsable = municipioResponsable;
        this.estadoResponsable = estadoResponsable;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(int idResponsable) {
        this.idResponsable = idResponsable;
    }

    public char getActivo() {
        return activo;
    }

    public void setActivo(char activo) {
        this.activo = activo;
    }

    public String getNombreResponsable() {
        return nombreResponsable;
    }

    public void setNombreResponsable(String nombreResponsable) {
        this.nombreResponsable = nombreResponsable;
    }

    public String getApPatResponsable() {
        return apPatResponsable;
    }

    public void setApPatResponsable(String apPatResponsable) {
        this.apPatResponsable = apPatResponsable;
    }

    public String getApMatResponsable() {
        return apMatResponsable;
    }

    public void setApMatResponsable(String apMatResponsable) {
        this.apMatResponsable = apMatResponsable;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel2() {
        return tel;
    }

    public void setTel2(String tel) {
        this.tel = tel;
    }

    public String getTel3() {
        return tel;
    }

    public void setTel3(String tel) {
        this.tel = tel;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNoExt() {
        return noExt;
    }

    public void setNoExt(String noExt) {
        this.noExt = noExt;
    }

    public String getNoInt() {
        return noInt;
    }

    public void setNoInt(String noInt) {
        this.noInt = noInt;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getcP() {
        return cP;
    }

    public void setcP(String cP) {
        this.cP = cP;
    }

    public String getMunicipioResponsable() {
        return municipioResponsable;
    }

    public void setMunicipioResponsable(String municipioResponsable) {
        this.municipioResponsable = municipioResponsable;
    }

    public String getEstadoResponsable() {
        return estadoResponsable;
    }

    public void setEstadoResponsable(String estadoResponsable) {
        this.estadoResponsable = estadoResponsable;
    }
    
    
}
