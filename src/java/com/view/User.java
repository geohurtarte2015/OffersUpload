package com.view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author LENOVO
 */
public class User extends HttpServlet {

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
        processRequest(request, response);
         PrintWriter out = response.getWriter();
         try  {
             
            boolean valUsuario = false;           
            
            String usuario = request.getParameter("name");
            String password = request.getParameter("pass");                
            
  
                
            valUsuario = (usuario.contains("admin") && password.contains("admin"));
            if (valUsuario){             
                HttpSession httpSession = request.getSession(true);
                httpSession.setAttribute("nombre", "Claro");
                httpSession.setAttribute("apellido", "Administrador");
                httpSession.setAttribute("usuario", usuario);
            }else{
                String error="errorusuario";
                out.println(error.trim());
            }
            
        } finally{        
                
            out.close();
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
