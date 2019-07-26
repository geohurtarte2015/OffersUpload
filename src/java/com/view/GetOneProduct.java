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
import org.json.JSONException;
import org.json.JSONObject;


public class GetOneProduct extends HttpServlet {


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
 
            String id = request.getParameter("id");
            String sql = "SELECT * FROM POS_CATALOG.TB_POS_TYPE_FOCALIZADO WHERE ID="+id;            
            DaoObject daoObject = new DaoObject();
            List<Product> product = daoObject.getOneProduct(sql);
            
            
            JSONObject json = new JSONObject();
            json.put("id", product.get(0).getId());
            json.put("description", product.get(0).getDescription());
            json.put("discount", product.get(0).getDiscount());
            json.put("status", product.get(0).getStatus());
            json.put("dateRegistered", product.get(0).getMarcacion());
            json.put("marcacion", product.get(0).getMarcacion());
            response.setContentType("application/json");
            response.getWriter().write(json.toString());
        } catch (JSONException ex) {
            Logger.getLogger(GetOneProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
