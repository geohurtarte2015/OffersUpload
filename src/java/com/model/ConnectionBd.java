
package com.model;


import com.pojo.Phone;
import com.pojo.Product;
import com.pojo.Response;
import com.pojo.ResultUpload;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;




public class ConnectionBd {
    
    public ArrayList<String[]> getSelect(DriverConnection driverConnection,String sql) throws SQLException {
          ArrayList<String[]> sequence = new ArrayList<String[]>();
             
        try {     
            Connection con = driverConnection.getCon();           
            PreparedStatement pr = con.prepareStatement(sql);   
            ResultSet rs = pr.executeQuery();
         
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();    
            int valResp = rs.getRow();
            
            
           while (rs.next()) {
             String[] column = new String[columnsNumber];  
               int cont=0;
             while (columnsNumber >cont) {
             column[cont] = rs.getString(cont+1);
              cont++;
             }
               sequence.add(column);
           }
            pr.close();
            rs.close();
            con.close();
            
           
        } catch (SQLException ex) {
            System.out.println("Error SQL"+" "+ex);        
        }
                    
         return sequence;
     }
    
    //insert type focalizado
    public String insertPack(List<Product> list,DriverConnection connection) throws SQLException {
          int cont =  0;
          String sql="";
          String response="error";
          Connection con = connection.getCon();
          PreparedStatement pr=null;
        try {           
              
            while (list.size()>cont) { 
                
            sql = "INSERT INTO POS_CATALOG.TB_POS_TYPE_FOCALIZADO" 
            + "(DESCRIPTION,DISCOUNT,STATUS,DATE_REGISTERED,MARCACION)" +
            " VALUES (?,?,?,?,?)";
            
                            
//            sql = "INSERT INTO TB_POS_TYPE_FOCALIZADO" 
//            + "(DESCRIPTION,DISCOUNT,STATUS,DATE_REGISTERED,MARCACION)" +
//            " VALUES (?,?,?,?,?)";
            
            java.util.Date today = new java.util.Date();     
            java.sql.Date sqlStartDate = new java.sql.Date(today.getTime());
            
            
            con.setAutoCommit(false);
            pr = con.prepareStatement(sql);
            pr.setString(1, list.get(cont).getDescription());
            pr.setInt(2, Integer.parseInt(list.get(cont).getDiscount()));
            pr.setString(3, list.get(cont).getStatus());
            pr.setDate(4, sqlStartDate);
            pr.setInt(5, Integer.parseInt(list.get(cont).getMarcacion()));    
            pr.executeUpdate();    
            cont++;
            connection.getCon().commit();
            }           
           
           
            response ="ok";
           
        } catch (SQLException ex) {
              try {
                 System.out.println(ex);
                 System.out.println("Error SQL"+" "+ex);
                 System.out.println("Rolling back data here.....");                  
                 con.rollback();
              } catch (SQLException ex1) {
                  System.out.println("Error Rolling back data here....."+ex1);
              }
        }finally {
            if (con != null) {
                    System.out.println("Execute Sql");
                    pr.close();
                    //rs.close();
                    con.close();
            }
        }
       return response;
     }
    
    public String insertMsisdn(List<Phone> list,DriverConnection connection) {
          int cont =  0;
          String sql="";
          String response="error";
          PreparedStatement pr=null;
          Connection con = connection.getCon();
        try {           
              
            while (list.size()>cont) { 
                
            sql = "INSERT INTO TB_POS_PHONE_FOCALIZADO" 
            + "(MSISDN,FOCALIZADO,STATUS,DATE_REGISTERED,BEGIN_DATE,END_DATE,MARCACION)" +
            " VALUES (?,?,?,?,?,?,?)";
            
            java.util.Date today = new java.util.Date();     
            java.sql.Date sqlTodayDate = new java.sql.Date(today.getTime());
            
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String date = format.format( new java.util.Date());      
            java.util.Date  beginDate = format.parse(list.get(cont).getBeginDate());
            java.util.Date  endDate = format.parse(list.get(cont).getEndDate()); 
    
               
            con.setAutoCommit(false);
            pr = con.prepareStatement(sql);
            pr.setLong(1, Long.parseLong(list.get(cont).getMsisdn().trim()));
            pr.setInt(2, Integer.parseInt(list.get(cont).getFocalizado()));
            pr.setString(3, list.get(cont).getStatus());
            pr.setDate(4, sqlTodayDate);
            pr.setDate(5, new java.sql.Date(beginDate.getTime()));
            pr.setDate(6, new java.sql.Date(endDate.getTime()));         
            pr.setInt(7, Integer.parseInt(list.get(cont).getMarcacion()));    
            pr.executeUpdate();    
            cont++;
            connection.getCon().commit();
            }           
           
           
            response ="ok";
           
        } catch (SQLException ex) {
              try {
                 System.out.println(ex);
                 System.out.println("Error SQL"+" "+ex);
                 System.out.println("Rolling back data here.....");                  
                 con.rollback();
              } catch (SQLException ex1) {
                  System.out.println("Error Rolling back data here....."+ex1);
              }
        } catch (ParseException ex) {
            Logger.getLogger(ConnectionBd.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (con != null) {
               
                try {
                    System.out.println("Execute Sql");
                    pr.close();
                    //rs.close();
                    con.close();
                } catch (SQLException ex) {
                    System.out.println("SQL Error close "+ex);
                }
              
              

            }
        }
       return response;
     }
    
    public String insertUpload(ResultUpload list,DriverConnection connection) {
          int cont =  0;
          String sql="";
          String response="error";
          PreparedStatement pr=null;
          Connection con = connection.getCon();
        try {   
            sql = "INSERT INTO TB_POS_UPLOAD_FOCALIZADOS" 
            + "(ID,USER_NAME,IP,DATE_UPLOAD,FILE_NAME,PROCESSED_RECORDS)" +
            " VALUES (?,?,?,?,?,?)";
            
            java.util.Date today = new java.util.Date();     
            java.sql.Date sqlTodayDate = new java.sql.Date(today.getTime());            
              
            con.setAutoCommit(false);
            pr = con.prepareStatement(sql);
            pr.setInt(1, list.getId());
            pr.setString(2, list.getUserName());
            pr.setString(3, list.getIp());
            pr.setDate(4, sqlTodayDate);
            pr.setString(5, list.getFileName());
            pr.setInt(6, list.getProcessedRecords());   
            pr.executeUpdate();    
            cont++;
            connection.getCon().commit();
       
           
           
            response ="ok";
           
        } catch (SQLException ex) {
              try {
                 System.out.println(ex);
                 System.out.println("Error SQL"+" "+ex);
                 System.out.println("Rolling back data here.....");                  
                 con.rollback();
              } catch (SQLException ex1) {
                  System.out.println("Error Rolling back data here....."+ex1);
              }
        }finally {
            if (con != null) {
               
                try {
                    System.out.println("Execute Sql");
                    pr.close();
                    //rs.close();
                    con.close();
                } catch (SQLException ex) {
                    System.out.println("SQL Error close "+ex);
                }
              
              

            }
        }
       return response;
     }
    
    public Response insertPhonesStoreProcedure(DriverConnection driverConnection,List<Phone> list,int countRow,int idUpload) {
        
        Response response = new Response();
        response.setResponseResume("error");
        try {
            int cont=0;
            CallableStatement cstmt;
            ResultSet rs;
            Connection con;
            
            
            con = driverConnection.getCon();
            String procedure = "{call POS_PROGRAM.PR_POS_INS_PHONE_FOCALIZADO(?,?,?,?,?,?,?)}";
            
            
            while (list.size()>cont) {       
            cstmt=con.prepareCall(procedure);
            java.util.Date today = new java.util.Date();     
            java.sql.Date sqlTodayDate = new java.sql.Date(today.getTime());
            
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String date = format.format( new java.util.Date());      
            java.util.Date  beginDate = format.parse(list.get(cont).getBeginDate());
            java.util.Date  endDate = format.parse(list.get(cont).getEndDate()); 
            
                    
            cstmt.setLong(1, Long.parseLong(list.get(cont).getMsisdn()));
            cstmt.setInt(2, Integer.parseInt(list.get(cont).getFocalizado()));
            cstmt.setDate(3, new java.sql.Date(beginDate.getTime()));
            cstmt.setDate(4, new java.sql.Date(endDate.getTime())); 
            cstmt.setInt(5, Integer.parseInt(list.get(cont).getMarcacion()));
            cstmt.setInt(6, idUpload);
            cstmt.setInt(7, cont);
            cstmt.execute();
            cstmt.close();
            cont++;         
            }
            
            con.close();
            response.setResponseResume("ok");
            response.setDescription("Ingreso correcto a base de datos");
            
        } catch (SQLException ex) {
            System.out.println(ex);
            response.setDescription("Error en el ingreso de MSISDN o formato del archivo invalido");
        } catch (ParseException ex) {
            System.out.println(ex);
            response.setDescription("Error en formato del archivo");
        }
        return response;
    }
    
    public String getUpdate(DriverConnection driverConnection,String sql) {     
         Connection con = null;
         int count=0;
         Statement statement = null;
        try {                 
            con = driverConnection.getCon();
            statement=con.createStatement();
            count = statement.executeUpdate(sql);
            
        } catch (SQLException ex) {
            System.out.println("Error SQL"+" "+ex);        
        } finally {
        
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                     System.out.println(ex.getMessage());
                }
            }

        
        }
               
         return String.valueOf(count);
     }
   
    public String deletePhonesStoreProcedure(DriverConnection driverConnection,List<Phone> list) {
        String response="error";
        try {
            int cont=0;
            CallableStatement cstmt;
            ResultSet rs;
            Connection con;
            
            con = driverConnection.getCon();
            String procedure = "{call POS_PROGRAM.PR_POS_DEL_PHONE_FOCALIZADO(?,?,?)}";
            
            
            while (list.size()>cont) {       
            cstmt=con.prepareCall(procedure);
            cstmt.setLong(1, Long.parseLong(list.get(cont).getMsisdn()));
            cstmt.setInt(2, Integer.parseInt(list.get(cont).getFocalizado()));        
            cstmt.setInt(3, Integer.parseInt(list.get(cont).getMarcacion()));
            cstmt.execute();
            cstmt.close();
            cont++;         
            }
            
            con.close();
            response="ok";
            
        } catch (SQLException ex) {
            System.out.println("Error al eliminar: "+ex);
        }        
        return response;
    }
     
  }
