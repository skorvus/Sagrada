/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sonny
 */
public class Conex {
    private String url;
    private String server;
    private String puerto;
    private String bd;
    private String user;
    private String pwd;
    private String driver;
    private String insSql;
    private static Conex instancia;
    private Connection con;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getInsSql() {
        return insSql;
    }

    public void setInsSql(String insSql) {
        this.insSql = insSql;
    }

   

   
    
    public static Conex getInstance(){
        if(instancia == null){
            instancia = new Conex();
        }
        return instancia;
    }
    
    private Conex(){               
        server = "localhost";        
        insSql = "";      
        puerto="3306";
        bd="sagradafamilia";       
        user="root";        
        pwd = "";        
        driver="com.mysql.jdbc.Driver";    
        if(insSql.trim().length() ==0){         
          url="jdbc:mysql://"+server+"/" +bd;
        }else{           
            url="jdbc:mysql://"+server+"/" +bd;
        }
     
       // System.out.println(url);
        
        try {
            Class.forName(driver);
             con = DriverManager.getConnection(url,user,pwd);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error a: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error b: " + ex.getMessage());
        }
         
    }
    public Connection getConnection(){
            return con;
        }  
}
