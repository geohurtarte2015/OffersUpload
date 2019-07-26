
package com.view;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.model.DaoObject;
import com.pojo.Product;
import estructure.DataTableObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ListProducts extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
     
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();    
            DaoObject daoObject = new DaoObject();
            List<Product> listProduct = daoObject.getListProduct("SELECT * FROM POS_CATALOG.TB_POS_TYPE_FOCALIZADO");            
           
            DataTableObject dataTableObject = new DataTableObject();
            List<Object> objectProducts= new ArrayList();
            
            for (Iterator indexIterator = listProduct.iterator();
                 indexIterator.hasNext();
                 )
            {
                Product product = (Product) indexIterator.next();
                List<Object> listObject = new ArrayList();
                listObject.add(product.getId());
                listObject.add(product.getDescription());
                listObject.add(product.getDiscount());
                listObject.add(product.getStatus());
                listObject.add(product.getMarcacion());
                objectProducts.add(listObject);
            
            }
            dataTableObject.setAaData(objectProducts); 

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(dataTableObject);
            out.print(json);
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           doGet(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
