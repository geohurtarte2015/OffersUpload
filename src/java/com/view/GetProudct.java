/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view;

import com.model.DaoObject;
import com.pojo.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author LENOVO
 */
public class GetProudct extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        try {
            processRequest(request, response);
            
            PrintWriter out = response.getWriter();
            
            String text = "Update successfull"; //message you will recieve
            //String name = request.getParameter("id");
            
            DaoObject daoObject = new DaoObject();            
            //List<Product> listProduct=daoObject.getListProduct("SELECT * FROM POS_CATALOG.TB_POS_TYPE_FOCALIZADO");
            List<Product> listProduct=daoObject.getListProduct("SELECT * FROM POS_CATALOG.TB_POS_TYPE_FOCALIZADO");            
            int size = listProduct.size();
            JSONArray jsonArray = new JSONArray();
            for(int x=0;x<size;x++){
            JSONObject json = new JSONObject();
            json.put(listProduct.get(x).getId(),listProduct.get(x).getDescription());
            jsonArray.put(json);           
            }
            response.setContentType("application/json");
            response.getWriter().write(jsonArray.toString());
            } catch (JSONException ex) {
                System.out.println("Error "+ex);
            }
        
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
