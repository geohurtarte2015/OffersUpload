
package com.pojo;



public class ResultUpload {

    
    private int id;
    private String userName;
    private String ip; 
    private String fileName;
    private int processedRecords;

    
    public String getUserName() {
        return userName;
    }

    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    public String getIp() {
        return ip;
    }

  
    public void setIp(String ip) {
        this.ip = ip;
    }

    
    public String getFileName() {
        return fileName;
    }

  
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

   
    public int getProcessedRecords() {
        return processedRecords;
    }

   
    public void setProcessedRecords(int processedRecords) {
        this.processedRecords = processedRecords;
    }
    
    
    
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }
    
   
    
}
