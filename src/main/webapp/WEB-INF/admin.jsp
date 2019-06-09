<%-- 
    Document   : admin
    Created on : 29-may-2019, 21:21:17
    Author     : administrador
--%>

<%@page import="projecto.projectofinal.datamodel.entities.Enparejamiento"%>
<%@page import="projecto.projectofinal.datamodel.entities.Fase"%>
<%@page import="projecto.projectofinal.datamodel.entities.Torneo"%>
<%@page import="projecto.projectofinal.datamodel.entities.Participante"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="container">
    
    <div class="row text-center">

        <div class="col-sl-12 col-sm-12 col-lg-12">

            <% Torneo torneo = (Torneo) request.getAttribute("torneo");
               Fase fase = (Fase) request.getAttribute("fase");
               List<Enparejamiento> em = (List<Enparejamiento>) request.getAttribute("em");
               String correcto = (String) request.getAttribute("correcto");
            %>
            
            <div class="alert alert-info text-center" style="margin: 3%;" role="alert">
                 
                <h3> <%= correcto %> </h3>
            
            </div>
               
            <div style="color:white"><h2>Torneo: <%=torneo.getNombreTorneo()%></h2></div><br>
                
            <div class="col-sl-12 col-sm-12 col-lg-12 text-left" style="width: 100%; border-bottom: 2px solid red;">
                <h4 style="color: white;">Fase: <%=fase.getNombreFase()%></h4></div><br>
               
                <div class="table-responsive-sm" style="margin: 3%;">
                   
                        <table class="table table-dark table-bordered table-hover">
                           
                            <thead>
                                
                                <tr>
                                    
                                    <th scope="col">Emparejamiento</th>
                                    <th scope="col">Participante 1</th>
                                    <th scope="col">Contra</th>
                                    <th scope="col">Participante 2</th>
                                    
                                </tr>
                                
                            </thead>
                            
                            <tbody>
                                
                                <%for(Enparejamiento e : em){ %>
                                
                                <tr>
                                  
                                    <td><%=e.getNombreEmparejamiento() %></td>
                                    <td><%=e.getNombreP1()%> <%=e.getApellidosP1() %></td>
                                    <td>Vs</td>
                                    <td><%=e.getNombreP2()%> <%=e.getApellidosP2() %></td>
                                
                                </tr>
                                            
                                           <% } %>
                                
                            </tbody>

                        </table>
                        
                    </div>

        </div>
                                           
        <div class="col-lg-12 col-sm-12 col-md-12 text-left" style="margin-bottom: 5%;">
                
                <a class="btn btn-info" href="ServletCargarOrganizador">Volver página principal</a>
                                               
         </div>
        
    </div>

</div>