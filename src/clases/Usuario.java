/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

/**
 *
 * @author joelfc
 */
public class Usuario {
    private String clave;
    private String password;
    private String nombre;
    private String appat;
    private String apmat;
    private int mPacientes;
    private int mFarmacia;
    private int mBenefactores;
    private int mCtrlEnf;
    private int mInventario;
    private int mPersMed;
    private int mUsuarios;

    public int getmUsuarios() {
        return mUsuarios;
    }

    public void setmUsuarios(int mUsuarios) {
        this.mUsuarios = mUsuarios;
    }
    
    public Usuario(String clave, String password, String nombre, String appat, String apmat, int mPacientes, int mFarmacia, int mBenefactores, int mCtrlEnf, int mInventario, int mPersMed,int mUsuarios) {
        this.clave = clave;
        this.password = password;
        this.nombre = nombre;
        this.appat = appat;
        this.apmat = apmat;
        this.mPacientes = mPacientes;
        this.mFarmacia = mFarmacia;
        this.mBenefactores = mBenefactores;
        this.mCtrlEnf = mCtrlEnf;
        this.mInventario = mInventario;
        this.mPersMed = mPersMed;
        this.mUsuarios = mUsuarios;
    }

    public Usuario() {
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAppat() {
        return appat;
    }

    public void setAppat(String appat) {
        this.appat = appat;
    }

    public String getApmat() {
        return apmat;
    }

    public void setApmat(String apmat) {
        this.apmat = apmat;
    }

    public int getmPacientes() {
        return mPacientes;
    }

    public void setmPacientes(int mPacientes) {
        this.mPacientes = mPacientes;
    }

    public int getmFarmacia() {
        return mFarmacia;
    }

    public void setmFarmacia(int mFarmacia) {
        this.mFarmacia = mFarmacia;
    }

    public int getmBenefactores() {
        return mBenefactores;
    }

    public void setmBenefactores(int mBenefactores) {
        this.mBenefactores = mBenefactores;
    }

    public int getmCtrlEnf() {
        return mCtrlEnf;
    }

    public void setmCtrlEnf(int mCtrlEnf) {
        this.mCtrlEnf = mCtrlEnf;
    }

    public int getmInventario() {
        return mInventario;
    }

    public void setmInventario(int mInventario) {
        this.mInventario = mInventario;
    }

    public int getmPersMed() {
        return mPersMed;
    }

    public void setmPersMed(int mPersMed) {
        this.mPersMed = mPersMed;
    }
    
    
}
