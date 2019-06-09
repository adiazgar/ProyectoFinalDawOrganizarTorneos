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
import javax.servlet.http.HttpSession;
import projecto.projectofinal.datamodel.entities.Enparejamiento;
import projecto.projectofinal.datamodel.entities.Fase;
import projecto.projectofinal.datamodel.entities.Torneo;
import static projecto.projectofinal.metodos.MetodosResultado.buscarEmparejamiento;
import static projecto.projectofinal.metodos.MetodosResultado.buscarFase;
import static projecto.projectofinal.metodos.MetodosResultado.torneoEscogido;

/**
 *
 * @author administrador
 */
public class ServletFaseResultado extends HttpServlet {

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
        
        String nombre = (String) request.getParameter("torneo");
        
        HttpSession session = request.getSession();
        
        if(nombre != null){
        
            List<Torneo> torneo = torneoEscogido(nombre);

            Torneo tor = torneo.get(0);

            Fase fase = buscarFase(tor);

            List<Enparejamiento> em = buscarEmparejamiento(fase);

            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/LayoutOrg.jsp");
            session.setAttribute("tor", tor);
            session.setAttribute("fas", fase);
            request.setAttribute("torneoActual", tor);
            request.setAttribute("faseActual", fase);
            request.setAttribute("emActual", em);
            request.setAttribute("action", "formularioAddResultado");
            rd.forward(request, response);
        
        }else{
            
             RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/LayoutOrg.jsp");
            request.setAttribute("action", "erroresAdmin");
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
