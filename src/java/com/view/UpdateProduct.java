
package com.view;

import com.model.DaoObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateProduct extends HttpServlet {


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
            
        String idProducto = request.getParameter("idProductHidden");
        String description = request.getParameter("DescriptionUpdate");
        String discount = request.getParameter("DiscountUpdate");
        String marcacion = request.getParameter("MarcacionUpdate");   
        String status = request.getParameter("StatusUpdate");

        
         try  {
            long id=  Integer.parseInt(idProducto);
            DaoObject daoObject = new DaoObject();
            daoObject.updateProduct("update TB_CATALOG.TB_POS_TYPE_FOCALIZADO set DESCRIPTION='"+description+"',DISCOUNT="+discount+",MARCACION="+marcacion+",STATUS='"+status+"' where id="+idProducto);           
            response.sendRedirect("user.jsp");
        
        } finally{        
                
            out.close();
        }
        
        
        
        
        }

  
    @Override
    public String getServletInfo() {
        return "Short description";
        }

}
