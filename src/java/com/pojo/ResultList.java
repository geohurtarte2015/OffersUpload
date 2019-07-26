
package com.pojo;

import java.util.ArrayList;


public class ResultList {
    
    private ArrayList<Phone> listPhones;
    private String nameFile;
    private Response response;


    public Response getResponse() {
        return response;
    }

   
    public void setResponse(Response response) {
        this.response = response;
    }
    
  
    public ArrayList<Phone> getListPhones() {
        return listPhones;
    }

   
    public void setListPhones(ArrayList<Phone> listPhones) {
        this.listPhones = listPhones;
    }

  
    public String getNameFile() {
        return nameFile;
    }


    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }
    

    
}
