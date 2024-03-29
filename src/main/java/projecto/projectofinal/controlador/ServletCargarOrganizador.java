/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto.projectofinal.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projecto.projectofinal.datamodel.entities.Torneo;
import static projecto.projectofinal.metodos.MetodosTorneo.torneosActivos;
import static projecto.projectofinal.metodos.MetodosTorneo.torneosTerminados;

/**
 *
 * @author administrador
 */
public class ServletCargarOrganizador extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        List<Torneo> torneoActivo = torneosActivos();
        List<Torneo> torneoTerminado = torneosTerminados();
        
        if(torneoActivo == null && torneoTerminado == null){
            
            String nohayTorneo = "No hay torneos creados";
            
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/LayoutOrg.jsp");
            request.setAttribute("nohayTorneo",nohayTorneo);
            request.setAttribute("action", "rdLogin");
            rd.forward(request, response);
            
        }else{
        
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/LayoutOrg.jsp");
            request.setAttribute("torneoActivo", torneoActivo);
            request.setAttribute("torneoTerminado", torneoTerminado);
            request.setAttribute("action", "rdLogin");
            rd.forward(request, response); 
        
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
