
package com.view;

import com.controller.ReadCsv;
import com.model.DaoObject;
import com.pojo.ResultList;
import com.webservice.GetWebservice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.json.JSONException;
import org.json.JSONObject;

@MultipartConfig
public class DeletePhone extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String resultDelete = "";
        PrintWriter out = response.getWriter();
        BufferedReader br = null;
        ReadCsv readCsv = new ReadCsv();
        DaoObject daoObject = new DaoObject();
    boolean isMultipart = ServletFileUpload.isMultipartContent(request);
    ServletFileUpload upload = new ServletFileUpload();
    try {
        FileItemIterator iter = upload.getItemIterator(request);
        ResultList resultList=readCsv.getReadCsv(iter);
        resultDelete = daoObject.deletePhonesStoreProcedure(resultList.getListPhones());
        
        //Response webservice and parse response
           GetWebservice webservice = new GetWebservice();
           String responseWebservice = webservice.doPost("http://172.16.168.139:7003/wsValidatorPOS/webresources/validate/loadData");  
           String responseWebservice2 = webservice.doPost("http://172.16.168.138:7003/wsValidatorPOS/webresources/validate/loadData");  
           String[] parseResponse = responseWebservice.replaceAll("\\<.*?>"," ").trim().split(" ");
           String[] parseResponse2 = responseWebservice2.replaceAll("\\<.*?>"," ").trim().split(" ");
           String responseHttp = parseResponse[0];
           String responseHttp2 = parseResponse2[0];
        
        //prepare json response
            JSONObject json = new JSONObject();
            json.put("phones", resultDelete);               
            response.setContentType("application/json");
            response.getWriter().write(json.toString());
        
        
       // response.sendRedirect(request.getContextPath() + "creacion.jsp");
     
    } catch (FileUploadException ex) {
        System.out.println("Error upload "+ex);
    }   catch (JSONException ex) {
        System.out.println("Json error read "+ex);
        }
     
        
        
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
