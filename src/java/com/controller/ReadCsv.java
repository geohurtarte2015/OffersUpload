
package com.controller;


import com.pojo.Phone;
import com.pojo.Response;
import com.pojo.ResultList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.util.Streams;

/**
 *
 * @author Edgar Giovanni Hurtarte
 */
public class ReadCsv {
    
    
    public ResultList getReadCsv(FileItemIterator iter){
          ResultList resultList = new ResultList();
          Response response = new Response();
          response.setResponseResume("error");
          response.setDescription("Error en formato del archivo");
        
        try {
       
            String file = "";
            String line = "";
            String cvsSplitBy = ",";
            ArrayList<Phone> listPhones = new ArrayList<Phone>();
          
            int val = 1;
            int option = -1;
            
            BufferedReader br = null;
            
            
            while (iter.hasNext()) {
                FileItemStream item = iter.next();
                if (item.isFormField()) {
                    // Normal field
                    String name = item.getFieldName();
                    String value = Streams.asString(item.openStream());
                    if(name.equals("Product")){
                        option=Integer.parseInt(value);
                    }
                } else {
                    file = item.getName();
                    
                    br = new BufferedReader(new InputStreamReader(item.openStream()));
                    while ((line = br.readLine()) != null) {
                        if (val > 1) {
                            Phone phone = new Phone();
                            // use comma as separator
                            String[] lineCsv = line.split(cvsSplitBy);
                            if (lineCsv.length != 0) {
                                phone.setMsisdn(lineCsv[0]);
                                if (option == -1) {
                                    phone.setFocalizado(lineCsv[1]);
                                } else {
                                    phone.setFocalizado(String.valueOf(option));
                                }
                                phone.setBeginDate(lineCsv[2]);
                                phone.setEndDate(lineCsv[3]);
                                phone.setMarcacion(lineCsv[4]);
                                listPhones.add(phone);
                            }
                            
                        }
                        val++;
                    }
                    br.close();
                    
                }
            }
            resultList.setListPhones(listPhones);
            resultList.setNameFile(file);
            
        } catch (FileUploadException | IOException ex) {     
            response.setResponseResume("error");
            response.setDescription("Error en lectura de archivo, formato invalido");
            System.out.println("Error en lectura de archivo, formato invalido: "+ex);
            return resultList;
        }
        response.setResponseResume("ok");
        response.setDescription("Lectura de archivo correcta");
        resultList.setResponse(response);
        return  resultList;
    }
     
}
