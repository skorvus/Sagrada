/*
 * Titulo: Clase Reportes.
 * Este programa se realizó para la organización "La sagrada familia A.C".
 * Esta clase sirve para obtener los elementos necesarios para realizar un reporte
 * Fecha: 24/03/2017
 */
package clases;

import java.sql.Connection;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author tomasTeifitV
 */
public class Reportes {
    Connection con;

    public Reportes() {
        con = Conex.getInstance().getConnection();
    }
    
    public void mostrarReporte(String ruta, Map parametro ){
        try {
            JasperReport jr = JasperCompileManager.compileReport(ruta);
            JasperPrint jp = JasperFillManager .fillReport(jr, parametro,con);
            JasperViewer.viewReport(jp,false);
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
