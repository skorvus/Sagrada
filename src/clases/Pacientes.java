/*
 * Titulo: Modulo paciente.
 * Este programa se realizó para la organización "La sagrada familia A.C".
 * Clase de los constructores, getters y setters(de los atributos) para el objeto Pacientes.
 * @version 31/01/2017
 */
package clases;
/**
 * @author Pablo Alberto Rodirguez Lopez.
 * @author Tomas Alejandro Vargas Lopez.
 * @author Jose Luis Tinajero Carvajal.
 */
public class Pacientes {     
    
    private int idPaciente;
    private String nombre;
    private String apPat;
    private String apMat;
    private int noExpediente;
    private  char actaIfe;//si o no
    private  char estado;//si o no
    private  String estadoCivil;
    private String fechaNac;
    private String EstadoProcedencia;
    private  String MunicipioProcedencia; 
    private  String EstadoOrigen;
    private  String MunicipioOrigen; 
    private  String tpPaciente;
    private  String seguro;
    private String tpSangre;
    private String Alergias;
    private  String fechaIngreso;
    private  String areas;
    private String diagnostico;
    private String tel;
    private  char activo = '1';//si o no
   

    public Pacientes() {
    }

    public Pacientes(int idPaciente, String nombre, String apPat, String apMat, int noExpediente, char actaIfe, char estado, String estadoCivil, String fechaNac, String EstadoProcedencia, String MunicipioProcedencia, String EstadoOrigen, String MunicipioOrigen, String tpPaciente, String seguro, String tpSangre, String Alergias, String fechaIngreso, String areas, String diagnostico, String tel) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.apPat = apPat;
        this.apMat = apMat;
        this.noExpediente = noExpediente;
        this.actaIfe = actaIfe;
        this.estado = estado;
        this.estadoCivil = estadoCivil;
        this.fechaNac = fechaNac;
        this.EstadoProcedencia = EstadoProcedencia;
        this.MunicipioProcedencia = MunicipioProcedencia;
        this.EstadoOrigen = EstadoOrigen;
        this.MunicipioOrigen = MunicipioOrigen;
        this.tpPaciente = tpPaciente;
        this.seguro = seguro;
        this.tpSangre = tpSangre;
        this.Alergias = Alergias;
        this.fechaIngreso = fechaIngreso;
        this.areas = areas;
        this.diagnostico = diagnostico;
        this.tel = tel;
    }

  

 

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPat() {
        return apPat;
    }

    public void setApPat(String apPat) {
        this.apPat = apPat;
    }

    public String getApMat() {
        return apMat;
    }

    public void setApMat(String apMat) {
        this.apMat = apMat;
    }

    public int getNoExpediente() {
        return noExpediente;
    }

    public void setNoExpediente(int noExpediente) {
        this.noExpediente = noExpediente;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

   

    public char getActaIfe() {
        return actaIfe;
    }

    public void setActaIfe(char actaIfe) {
        this.actaIfe = actaIfe;
    }

    public String getEstadoProcedencia() {
        return EstadoProcedencia;
    }

    public void setEstadoProcedencia(String EstadoProcedencia) {
        this.EstadoProcedencia = EstadoProcedencia;
    }

    public String getMunicipioProcedencia() {
        return MunicipioProcedencia;
    }

    public void setMunicipioProcedencia(String MunicipioProcedencia) {
        this.MunicipioProcedencia = MunicipioProcedencia;
    }

    public String getEstadoOrigen() {
        return EstadoOrigen;
    }

    public void setEstadoOrigen(String EstadoOrigen) {
        this.EstadoOrigen = EstadoOrigen;
    }

    public String getMunicipioOrigen() {
        return MunicipioOrigen;
    }

    public void setMunicipioOrigen(String MunicipioOrigen) {
        this.MunicipioOrigen = MunicipioOrigen;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

 

    public String getTpPaciente() {
        return tpPaciente;
    }

    public void setTpPaciente(String tpPaciente) {
        this.tpPaciente = tpPaciente;
    }

    public String getTpSangre() {
        return tpSangre;
    }

    public void setTpSangre(String tpSangre) {
        this.tpSangre = tpSangre;
    }

    public String getAlergias() {
        return Alergias;
    }

    public void setAlergias(String Alergias) {
        this.Alergias = Alergias;
    }

    public String getAreas() {
        return areas;
    }

    public void setAreas(String area) {
        this.areas = area;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public char getActivo() {
        return activo;
    }

    public void setActivo(char activo) {
        this.activo = activo;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


    
    
}
