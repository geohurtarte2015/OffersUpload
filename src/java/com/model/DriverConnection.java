/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DriverConnection {
    private Connection con = null;
    
    public DriverConnection(){
        
        try {
            //this.con = DriverManager.getConnection("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=oracledes01-scan)(PORT=3872))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=DVSVD)))", "USSD_DOBLE", "D3$4_0Ll1");
            this.con = DriverManager.getConnection("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=oracleprd04-scan)(PORT=3872))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=POSDBGT)))", "POS_OFFLINETRX", "D26of#2019");
        } catch (SQLException ex) {
            Logger.getLogger(DriverConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public Connection getCon() {
        return con;
    }

  
    public void setCon(Connection con) {
        this.con = con;
    }

}