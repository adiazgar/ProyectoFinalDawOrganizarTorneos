/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto.projectofinal.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import static projecto.projectofinal.metodos.MetodosEmparejamiento.recogerEmparejamiento;
import static projecto.projectofinal.metodos.MetodosFase.buscarFase;
import static projecto.projectofinal.metodos.MetodosFase.numeroFase;
import static projecto.projectofinal.metodos.MetodosResultado.recogerResultado;
import static projecto.projectofinal.metodos.MetodosTorneo.buscarTorneo;

/**
 *
 * @author administrador
 */
public class ServletMostrarTorneoActivo extends HttpServlet {

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
        
        String nombreTorneoA = (String) request.getParameter("torneo");
        
        Torneo tor = buscarTorneo(nombreTorneoA);
            
            List<Fase> fase = buscarFase(tor);
            long num = numeroFase(tor);
            int numeroFase = (int) num;
            List<List<Enparejamiento>> lem = new ArrayList<>();
            List<List<Resultado>> lres = new ArrayList<>();
            List<Enparejamiento> em = new ArrayList<>();
            List<Resultado> res = new ArrayList<>();
            
            for(Fase f : fase){
                
                em = recogerEmparejamiento(f);
                lem.add(em);
                
            }
            
            switch (numeroFase) {
                case 1:
                    {
                        String aLaEspera = "A la espera de recibir resultados";
                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/Layout.jsp");
                        request.setAttribute("tor",tor);
                        request.setAttribute("fase",fase);
                        request.setAttribute("lem",lem);
                        request.setAttribute("aLaEspera",aLaEspera);
                        request.setAttribute("action", "mostrarTorneoIndividualActivo");
                        rd.forward(request, response);
                        break;
                    }
                case 2:
                    {
                        for(int i = 0; i < (numeroFase - 1); i++){
                            
                            res = recogerResultado(fase.get(i));
                            lres.add(res);
                        }       String aLaEspera = "A la espera de recibir resultados";
                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/Layout.jsp");
                        request.setAttribute("tor",tor);
                        request.setAttribute("fase",fase);
                        request.setAttribute("lres",lres);
                        request.setAttribute("lem",lem);
                        request.setAttribute("aLaEspera",aLaEspera);
                        request.setAttribute("action", "mostrarTorneoIndividualActivo");
                        rd.forward(request, response);
                        break;
                    }
                case 3:
                    {
                        for(int i = 0; i < (numeroFase - 1); i++){
                            
                            res = recogerResultado(fase.get(i));
                            lres.add(res);
                        }       String aLaEspera = "A la espera de recibir resultados";
                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/Layout.jsp");
                        request.setAttribute("tor",tor);
                        request.setAttribute("fase",fase);
                        request.setAttribute("lres",lres);
                        request.setAttribute("lem",lem);
                        request.setAttribute("aLaEspera",aLaEspera);
                        request.setAttribute("action", "mostrarTorneoIndividualActivo");
                        rd.forward(request, response);
                        break;
                    }
                default:
                    {
                        for(int i = 0; i < (numeroFase - 1); i++){
                            
                            res = recogerResultado(fase.get(i));
                            lres.add(res);
                        }       String aLaEspera = "A la espera de recibir resultados";
                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/Layout.jsp");
                        request.setAttribute("tor",tor);
                        request.setAttribute("fase",fase);
                        request.setAttribute("lres",lres);
                        request.setAttribute("lem",lem);
                        request.setAttribute("aLaEspera",aLaEspera);
                        request.setAttribute("action", "mostrarTorneoIndividualActivo");
                        rd.forward(request, response);
                        break;
                    }
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
