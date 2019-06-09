<%-- 
    Document   : nuevoEmparejamientoResultado
    Created on : 02-jun-2019, 18:11:11
    Author     : administrador
--%>

<%@page import="projecto.projectofinal.datamodel.entities.Fase"%>
<%@page import="projecto.projectofinal.datamodel.entities.Torneo"%>
<%@page import="projecto.projectofinal.datamodel.entities.Resultado"%>
<%@page import="projecto.projectofinal.datamodel.entities.Enparejamiento"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    
            <% String correcto = (String) request.getAttribute("correcto");
               String resultadoGanador = (String) request.getAttribute("resultadoGanador");
               List<Enparejamiento> em = (List<Enparejamiento>) request.getAttribute("nuevoEmparejamiento");
               List<Resultado> res = (List<Resultado>) request.getAttribute("resultadoUltimaFase");
               Torneo torneo = (Torneo) request.getAttribute("torneo");
               Fase fase = (Fase) request.getAttribute("ultimaFase");
            %>
            
            <% if(torneo.getCantidaParticipantes() > 1){ %>
            
            <div class="container-fluid">
            
            <div class="row h-100 justify-content-center align-items-center">
            
            <div class="alert alert-info text-center" style="margin: 3%;" role="alert">
                 
                <h3> <%= correcto %> </h3>
            
            </div>
               
                <div class="col-sl-12 col-sm-12 col-lg-12 text-center" style="color:white;margin-top: 2%;"><h2>Torneo: <%=torneo.getNombreTorneo()%></h2></div><br>
                
            <div class="col-sl-12 col-sm-12 col-lg-12 text-left" style="width: 98%; border-bottom: 2px solid red;margin: 2%;">
                <h4 style="color: white;">Fase: <%=fase.getNombreFase()%></h4></div><br>
               
                 <div class="col-lg-6 col-sm-12 col-md-6" style="float :left">  
                     
                     <div class="col-sl-12 col-sm-12 col-lg-12 text-left" style="margin-bottom: 1%;"><h4 style="color:white;">Últimos resultados añadidos</h4></div>
            
                    <div class="table-responsive-md">
                   
                        <table class="table table-dark table-bordered table-hover">
                           
                            <thead>
                                
                                <tr>
                                    
                                    <th scope="col">Nombre del torneo</th>
                                    <th scope="col">Fase del Torneo</th>
                                    <th scope="col">Id participante ganador</th>
                                    <th scope="col">Nombre participante ganador</th>
                                    <th scope="col">Apellidos participante ganador</th>
                                    
                                </tr>
                                
                            </thead>
                            
                            <tbody>
                                
                                <%for(Resultado r : res){ %>
                                
                                <tr>
                                  
                                    <td><%=torneo.getNombreTorneo() %></td>
                                    <td><%=fase.getNombreFase() %></td>
                                    <td><%=r.getIdPganador() %></td>
                                    <td><%=r.getNombreGanador() %></td>
                                    <td><%=r.getApellidosGanador() %></td>
                                
                                </tr>
                                            
                                           <% } %>
                                
                            </tbody>

                        </table>
                        
                    </div>
                
                </div>
                                           
                <div class="col-sl-6 col-sm-12 col-md-6" style="float: right"> 
                    
                    <div class="col-sl-12 col-sm-12 col-lg-12 text-left"><h4 style="color: white">Nuevos emparejamientos</h4></div>
            
                    <div class="table-responsive-md">
                   
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
                   
            </div>
                                           
                                           
                <% }else if(torneo.getCantidaParticipantes() == 1){ %>
                
                 <div class="row justify-content-md-center">
              
            
            <div class="alert alert-info" role="alert">
                 
                <h3> <%= resultadoGanador %> </h3>
            
            </div>
            
               
             <div class="col-sl-12 col-sm-12 col-lg-12 text-center" style="color:white;margin-top: 2%;"><h2>Torneo: <%=torneo.getNombreTorneo()%></h2></div><br>
                
            <div class="col-sl-12 col-sm-12 col-lg-12 text-left" style="width: 98%; border-bottom: 2px solid red;margin: 2%;">
                <h4 style="color: white;">Fase: <%=fase.getNombreFase()%></h4></div><br>
                     
                <div class="col-sl-12 col-sm-12 col-lg-12 text-center" style="margin-bottom: 1%;"><h3 style="color: white">Últimos resultados añadidos</h3></div>
            
                    <div class="table-responsive-sm">
                   
                        <table class="table table-dark table-bordered table-hover">
                           
                            <thead>
                                
                                <tr>
                                    
                                    <th scope="col">Nombre del torneo</th>
                                    <th scope="col">Fase del Torneo</th>
                                    <th scope="col">Id participante ganador</th>
                                    <th scope="col">Nombre participante ganador</th>
                                    <th scope="col">Apellidos participante ganador</th>
                                    
                                </tr>
                                
                            </thead>
                            
                            <tbody>
                                
                                <%for(Resultado r : res){ %>
                                
                                <tr>
                                  
                                    <td><%=torneo.getNombreTorneo() %></td>
                                    <td><%=fase.getNombreFase() %></td>
                                    <td><%=r.getIdPganador() %></td>
                                    <td><%=r.getNombreGanador() %></td>
                                    <td><%=r.getApellidosGanador() %></td>
                                
                                </tr>
                                            
                                           <% } %>
                                
                            </tbody>

                        </table>
                        
                    </div>
                
                <% }else{ %>
                         
                <br>
                
                <% } %>
                
                <div class="col-lg-12 col-sm-12 col-md-12 text-left" style="margin-bottom: 5%;">
                
                <a class="btn btn-info" href="ServletCargarOrganizador">Volver página principal</a>
                                               
         </div>
                
        </div>
        
    </div>
