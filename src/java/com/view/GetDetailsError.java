
package com.view;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.model.DaoObject;
import com.pojo.DetailError;
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


public class GetDetailsError extends HttpServlet {


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
            //processRequest(request, response);
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            
            
            String idUpload = request.getParameter("idUpload");
            DaoObject daoObject = new DaoObject();
            List<DetailError> listError = daoObject.getErrorDetails("select * from TB_POS_LOAD_DETAIL where ID_UPLOAD="+idUpload+" order by id asc");
            
            DataTableObject dataTableObject = new DataTableObject();
            List<Object> objectError= new ArrayList();
            
            for (Iterator indexIterator = listError.iterator();
                 indexIterator.hasNext();
                 )
            {
                DetailError errorDetail = (DetailError) indexIterator.next();
                List<Object> listObject = new ArrayList(); 
                listObject.add(errorDetail.getNumRecord());
                listObject.add(errorDetail.getDescription());           
                objectError.add(listObject);
            
            }
            dataTableObject.setAaData(objectError); 

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(dataTableObject);
            out.print(json);
        
  
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
