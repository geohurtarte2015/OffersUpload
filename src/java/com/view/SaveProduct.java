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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveProduct extends HttpServlet {


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
            processRequest(request, response);
            PrintWriter out = response.getWriter();
            String description = request.getParameter("Description");
            String discount = request.getParameter("Discount");   
            String status = request.getParameter("Status");
            String marcacion = request.getParameter("Marcacion");       
          
            try  {
            DaoObject daoProduct = new DaoObject();
            Product product = new Product();
            product.setDescription(description);
            product.setDiscount(discount);
            product.setStatus(status);
            product.setMarcacion(marcacion);
            String responseInsert = daoProduct.insertProduct(product);
            
            response.sendRedirect("user.jsp");
        
            } catch (SQLException ex) {        
            System.out.println("Error "+ex);
        } finally{        
                
            out.close();
        }
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
