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
import projecto.projectofinal.datamodel.entities.Fase;
import projecto.projectofinal.datamodel.entities.Torneo;
import static projecto.projectofinal.metodos.MetodosFase.borrarFase;
import static projecto.projectofinal.metodos.MetodosFase.crearFase;
import static projecto.projectofinal.metodos.MetodosFase.recogerFase;
import static projecto.projectofinal.metodos.MetodosParticipante.borrarParticipante;
import static projecto.projectofinal.metodos.MetodosTorneo.borrarTorneo;
import static projecto.projectofinal.metodos.MetodosTorneo.crearTorneo;
import static projecto.projectofinal.metodos.MetodosTorneo.existeNombreTorneo;
import static projecto.projectofinal.metodos.MetodosTorneo.existeTorneo;
import static projecto.projectofinal.metodos.MetodosTorneo.idTorneo;
import static projecto.projectofinal.metodos.MetodosTorneo.torneoAbierto;

/**
 *
 * @author administrador
 */
public class ServletCrearTorneo extends HttpServlet {

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
        
        String nombre = request.getParameter("nombre");
        String deporte = request.getParameter("deporte");
        String estado = "abierto";
        int numero = Integer.parseInt(request.getParameter("numero"));
        
        HttpSession session = request.getSession();
        
        if(nombre.equals("") || nombre == null){
            
            String noNombre = "No se ha introducido ningun nombre al torneo.";
            
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/LayoutOrg.jsp");
            request.setAttribute("noNombre", noNombre);
            request.setAttribute("action", "formularioCrearTorneo");
            rd.forward(request, response);
            
        }
        
        if(existeTorneo()){
            
            if(existeNombreTorneo(nombre)){
                
                List<Torneo> tor = torneoAbierto();
            
            if(tor != null){
                
                for(Torneo t : tor){
                    
                    borrarParticipante(t);
                    borrarFase(t);
                    borrarTorneo(t);
                    
                }
                
            }
            
            String existe = "Ya hay un torneo con ese nombre, por favor introduzca otro.";
            
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/LayoutOrg.jsp");
            request.setAttribute("existe", existe);
            request.setAttribute("action", "formularioCrearTorneo");
            rd.forward(request, response);
            
            }else {

                crearTorneo(nombre, deporte, estado, numero);

                Torneo torneo = idTorneo(nombre, deporte, numero);

                crearFase(torneo);
                
                Fase fase = recogerFase(torneo);

                String creado = "Se ha creado el torneo correctamente.";

                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/LayoutOrg.jsp");
                request.setAttribute("action", "formularioAddParticipante");
                request.setAttribute("creado", creado);
                session.setAttribute("numero", numero);
                session.setAttribute("fase", fase);
                session.setAttribute("id", torneo);
                rd.forward(request, response);
            
            }
            
        }else{
            
                crearTorneo(nombre, deporte, estado, numero);

                Torneo torneo = idTorneo(nombre, deporte, numero);

                crearFase(torneo);
                
                Fase fase = recogerFase(torneo);

                String creado = "Se ha creado el torneo correctamente.";

                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/LayoutOrg.jsp");
                request.setAttribute("action", "formularioAddParticipante");
                request.setAttribute("creado", creado);
                request.setAttribute("numero", numero);
                session.setAttribute("fase", fase);
                session.setAttribute("id", torneo);
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
