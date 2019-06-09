/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto.projectofinal.controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projecto.projectofinal.datamodel.entities.Enparejamiento;
import projecto.projectofinal.datamodel.entities.Fase;
import projecto.projectofinal.datamodel.entities.Resultado;
import projecto.projectofinal.datamodel.entities.Torneo;
import static projecto.projectofinal.metodos.MetodosEmparejamiento.borrarEmparejamiento;
import static projecto.projectofinal.metodos.MetodosEmparejamiento.recogerEmparejamiento;
import static projecto.projectofinal.metodos.MetodosFase.borrarFase;
import static projecto.projectofinal.metodos.MetodosFase.buscarFase;
import static projecto.projectofinal.metodos.MetodosParticipante.borrarParticipante;
import static projecto.projectofinal.metodos.MetodosResultado.borrarResultado;
import static projecto.projectofinal.metodos.MetodosResultado.recogerResultado;
import static projecto.projectofinal.metodos.MetodosTorneo.borrarTorneo;
import static projecto.projectofinal.metodos.MetodosTorneo.buscarTorneo;

/**
 *
 * @author administrador
 */
public class ServletBorrarTorneo extends HttpServlet {

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
        
        String torneo = (String) request.getParameter("torneo");
        
        Torneo tor = buscarTorneo(torneo);
        
        List<Fase> fase = buscarFase(tor);
        
        if(fase != null){
        
        for(int i = 0;i < fase.size(); i++){
            
            List<Enparejamiento> em = recogerEmparejamiento(fase.get(i));
            
            if(em != null){
            
            borrarEmparejamiento(fase.get(i));
            
            }
            
            List<Resultado> res = recogerResultado(fase.get(i));
            
            if(res != null){
            
            borrarResultado(fase.get(i));
            
            }
            
        }
        
        borrarParticipante(tor);
        
        borrarFase(tor);
        
        borrarTorneo(tor);
        
         RequestDispatcher rd = request.getRequestDispatcher("ServletCargarOrganizador");
        rd.forward(request, response);
        
        }else{
            
        borrarParticipante(tor);
        
        borrarFase(tor);
        
        borrarTorneo(tor);
        
        RequestDispatcher rd = request.getRequestDispatcher("ServletCargarOrganizador");
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
