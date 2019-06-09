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
import javax.servlet.http.HttpSession;
import projecto.projectofinal.datamodel.entities.Enparejamiento;
import projecto.projectofinal.datamodel.entities.Fase;
import projecto.projectofinal.datamodel.entities.Participante;
import projecto.projectofinal.datamodel.entities.Torneo;
import static projecto.projectofinal.metodos.MetodosParticipante.insertParticipante;
import static projecto.projectofinal.metodos.MetodosEmparejamiento.insertEmparejamiento;
import static projecto.projectofinal.metodos.MetodosEmparejamiento.mezclarParticipante;
import static projecto.projectofinal.metodos.MetodosEmparejamiento.recogerEmparejamiento;
import static projecto.projectofinal.metodos.MetodosEmparejamiento.recogerParticipante;
import static projecto.projectofinal.metodos.MetodosParticipante.esNumero;
import static projecto.projectofinal.metodos.MetodosTorneo.cambiarEstadoTorneo;

/**
 *
 * @author administrador
 */
public class ServletAddParticipantes extends HttpServlet {

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

        HttpSession session = request.getSession();
        
        String[] nombre = request.getParameterValues("nombre");
        String[] apellidos = request.getParameterValues("apellidos");
        String[] edad = request.getParameterValues("edad");
        
        for(int i = 0; i <nombre.length; i++){
        
        if(nombre[i].length() == 0 || apellidos[i].length() == 0 || edad[i].length() == 0){
            
            String faltaNombre = "Hay campos que están vacios. Vuelva a introducirlos.";
            
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/LayoutOrg.jsp");
                request.setAttribute("faltaNombre", faltaNombre);
                request.setAttribute("action", "formularioAddParticipante");
                rd.forward(request, response);
            
            }
        
        }
        
        for(int i = 0; i < edad.length; i++){
            
            if(!esNumero(edad[i])){
                
                String faltaNombre = "La edad que ha introducido en algún campo no es valida.";
            
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/LayoutOrg.jsp");
                request.setAttribute("faltaNombre", faltaNombre);
                request.setAttribute("action", "formularioAddParticipante");
                rd.forward(request, response);
                
            }
            
        }
       
        Torneo idTorneo = (Torneo) session.getAttribute("id");
        Fase fase = (Fase) session.getAttribute("fase");
        
        insertParticipante(nombre, apellidos, edad, idTorneo);
        
        List<Participante> participante = recogerParticipante(idTorneo);
        
        List<Participante> partDesordenados = mezclarParticipante(participante);
        
        insertEmparejamiento(partDesordenados, fase);
        
        cambiarEstadoTorneo(idTorneo);
        
        List<Enparejamiento> em = recogerEmparejamiento(fase);
        
        String correcto = "El torneo se ha creado correctamente";
        
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/LayoutOrg.jsp");
        request.setAttribute("torneo", idTorneo);
        request.setAttribute("fase", fase);
        request.setAttribute("em", em);
        request.setAttribute("correcto", correcto);
        request.setAttribute("action", "admin");
        rd.forward(request, response);
        
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
