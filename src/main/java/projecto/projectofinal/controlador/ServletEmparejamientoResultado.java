/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto.projectofinal.controlador;

import java.io.IOException;
import java.util.ArrayList;
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
import projecto.projectofinal.datamodel.entities.Resultado;
import projecto.projectofinal.datamodel.entities.Torneo;
import static projecto.projectofinal.metodos.MetodosEmparejamiento.insertEmparejamiento;
import static projecto.projectofinal.metodos.MetodosResultado.insertResultado;
import static projecto.projectofinal.metodos.MetodosEmparejamiento.mezclarParticipante;
import static projecto.projectofinal.metodos.MetodosEmparejamiento.participantesNuevoEmparejamiento;
import static projecto.projectofinal.metodos.MetodosEmparejamiento.recogerEmparejamiento;
import static projecto.projectofinal.metodos.MetodosFase.crearFase;
import static projecto.projectofinal.metodos.MetodosFase.recogerFase;
import static projecto.projectofinal.metodos.MetodosResultado.existeGanador;
import static projecto.projectofinal.metodos.MetodosResultado.recogerResultado;
import static projecto.projectofinal.metodos.MetodosTorneo.actualizarCantidadParticipanteTorneo;
import static projecto.projectofinal.metodos.MetodosTorneo.cambiarEstadoTorneo;

/**
 *
 * @author administrador
 */
public class ServletEmparejamientoResultado extends HttpServlet {

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
        
        int cantidadParticipantes = Integer.parseInt(request.getParameter("cantidad"));
        
        String id0 = request.getParameter("id0");
        String id1 = request.getParameter("id1");
        String id2 = request.getParameter("id2");
        String id3 = request.getParameter("id3");
        String id4 = request.getParameter("id4");
        String id5 = request.getParameter("id5");
        String id6 = request.getParameter("id6");
        String id7 = request.getParameter("id7");
        
        Torneo tor = (Torneo) session.getAttribute("tor");
        Fase fase = (Fase) session.getAttribute("fas");
        String correcto = "Se ha relizado correctamente la creación de un nuevo emparejamiento y la creación de resultados.";
        String resultadoGanador ="Resultados del ganador del torneo añadidos correctamente.";
        
        if(tor.getCantidaParticipantes() / 2 == cantidadParticipantes){
        
        if(cantidadParticipantes == 0){
        
            String noHaPuestoResultado = "No ha insertado ningun resultado, vuelva a intertarlo";
            
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/LayoutOrg.jsp");
            request.setAttribute("noHaPuestoResultado", noHaPuestoResultado);
            request.setAttribute("action", "erroresAdmin");
            rd.forward(request, response);
            
        }else if(cantidadParticipantes == 1){
            
            List<Participante> part = new ArrayList<>();
            Participante participanteGanadorTorneo = participantesNuevoEmparejamiento(id0);
            
            if(participanteGanadorTorneo != null){
                   
                   part.add(participanteGanadorTorneo);
                   
            }else {
                
                String idNoValidos = "Los id que ha insertado no coinciden.";
            
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/LayoutOrg.jsp");
                request.setAttribute("idNoValidos", idNoValidos);
                request.setAttribute("action", "erroresAdmin");
                rd.forward(request, response);
                
            }
            
            if(!existeGanador(fase)){
            
                insertResultado(part,fase);

                actualizarCantidadParticipanteTorneo(tor);

                cambiarEstadoTorneo(tor);

                List<Resultado> res = recogerResultado(fase);

                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/LayoutOrg.jsp");
                request.setAttribute("torneo", tor);
                request.setAttribute("ultimaFase", fase);
                request.setAttribute("resultadoGanador", resultadoGanador);
                request.setAttribute("resultadoUltimaFase", res);
                request.setAttribute("action", "nuevoEmparejamientoResultado");
                rd.forward(request, response);
            
            }else{
                
                String torneoCerrado = "Ya no se puede insertar más id, el torneo está cerrado.";
            
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/LayoutOrg.jsp");
                request.setAttribute("torneoCerrado", torneoCerrado);
                request.setAttribute("action", "erroresAdmin");
                rd.forward(request, response);
                
            }
            
        }else if(cantidadParticipantes == 2){
            
            List<Participante> part = new ArrayList<>();
            String[] idParticipante ={id0,id1};
            
            for(int i = 0; i < cantidadParticipantes; i++){

               Participante p = participantesNuevoEmparejamiento(idParticipante[i]);

               if(p != null){
                   
                   part.add(i, p);
                   
               }

            }
            
            insertResultado(part,fase);
            
            actualizarCantidadParticipanteTorneo(tor);
            
            List<Participante> partDesord = mezclarParticipante(part);
            
            Fase faseActual = recogerFase(tor);
            
            crearFase(tor);
            
            Fase ultimaFase = recogerFase(tor);
            
            insertEmparejamiento(partDesord,ultimaFase);
            
            List<Enparejamiento> em = recogerEmparejamiento(ultimaFase);
            List<Resultado> res = recogerResultado(faseActual);
            
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/LayoutOrg.jsp");
            request.setAttribute("torneo", tor);
            request.setAttribute("ultimaFase", ultimaFase);
            request.setAttribute("correcto", correcto);
            request.setAttribute("nuevoEmparejamiento", em);
            request.setAttribute("resultadoUltimaFase", res);
            request.setAttribute("action", "nuevoEmparejamientoResultado");
            rd.forward(request, response);
            
        }else if(cantidadParticipantes == 4){
               
            List<Participante> part = new ArrayList<>();  
           String[] idParticipante ={id0,id1,id2,id3};
            
             for(int i = 0; i < cantidadParticipantes; i++){

               Participante p = participantesNuevoEmparejamiento(idParticipante[i]);

               if(p != null){
                   
                   part.add(i, p);
                   
               }
               
            }
            
            if(part.size() == cantidadParticipantes){
                
                insertResultado(part,fase);
            
                actualizarCantidadParticipanteTorneo(tor);

                List<Participante> partDesord = mezclarParticipante(part);
                
                Fase faseActual = recogerFase(tor);

                crearFase(tor);

                Fase ultimaFase = recogerFase(tor);

                insertEmparejamiento(partDesord,ultimaFase);

                List<Enparejamiento> em = recogerEmparejamiento(ultimaFase);
                List<Resultado> res = recogerResultado(faseActual);

                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/LayoutOrg.jsp");
                request.setAttribute("torneo", tor);
                request.setAttribute("ultimaFase", ultimaFase);
                request.setAttribute("correcto", correcto);
                request.setAttribute("nuevoEmparejamiento", em);
                request.setAttribute("resultadoUltimaFase", res);
                request.setAttribute("action", "nuevoEmparejamientoResultado");
                rd.forward(request, response);
                
            }   
                
        }else{
            
            List<Participante> part = new ArrayList<>(); 
            String[] idParticipante ={id0,id1,id2,id3,id4,id5,id6,id7};
            
             for(int i = 0; i < cantidadParticipantes; i++){

               Participante p = participantesNuevoEmparejamiento(idParticipante[i]);

               if(p != null){
                   
                   part.add(i, p);
                   
               }
               
            }
            
            if(part.size() == cantidadParticipantes){
                
                insertResultado(part,fase);
            
                actualizarCantidadParticipanteTorneo(tor);

                List<Participante> partDesord = mezclarParticipante(part);
                
                Fase faseActual = recogerFase(tor);

                crearFase(tor);

                Fase ultimaFase = recogerFase(tor);

                insertEmparejamiento(partDesord,ultimaFase);

                List<Enparejamiento> em = recogerEmparejamiento(ultimaFase);
                List<Resultado> res = recogerResultado(faseActual);

                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/LayoutOrg.jsp");
                request.setAttribute("torneo", tor);
                request.setAttribute("ultimaFase", ultimaFase);
                request.setAttribute("correcto", correcto);
                request.setAttribute("nuevoEmparejamiento", em);
                request.setAttribute("resultadoUltimaFase", res);
                request.setAttribute("action", "nuevoEmparejamientoResultado");
                rd.forward(request, response);
            }  
        }
        
        }else{
            
            String idYaInsertados = "Ya has se han insertados los resultados de está fase";
            
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/LayoutOrg.jsp");
            request.setAttribute("idYaInsertados", idYaInsertados);
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
