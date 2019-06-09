<%-- 
    Document   : formularioAddResultado
    Created on : 02-jun-2019, 12:51:53
    Author     : administrador
--%>

<%@page import="projecto.projectofinal.datamodel.entities.Enparejamiento"%>
<%@page import="java.util.List"%>
<%@page import="projecto.projectofinal.datamodel.entities.Fase"%>
<%@page import="projecto.projectofinal.datamodel.entities.Torneo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    
    <% Torneo torneo = (Torneo) request.getAttribute("torneoActual");
       Fase fase = (Fase) request.getAttribute("faseActual");
       List<Enparejamiento> em = (List<Enparejamiento>) request.getAttribute("emActual");
       int cantidadEmparejamientos = torneo.getCantidaParticipantes() / 2; %>
       
       <div class="container-fluid">
    
    <div class="row text-center">
       
        <div class="col-sm-12 col-lg-12 col-md-12" style="margin: 2%;">
           
           <div> <h1 style="color: white;">Torneo: <%= torneo.getNombreTorneo() %></h1> </div>
           
       </div> 
           
       <div class="col-sm-12 col-lg-12 col-md-12" style="margin-bottom: 2%;">
           
           <div class="text-left" style="width: 100%; border-bottom: 2px solid red;"> 
               <h3 style="color: white;">Fase actual del torneo: <%= fase.getNombreFase() %> con <%= torneo.getCantidaParticipantes() %> Participantes restantes.</h3> 
           </div>
           
       </div> 
           
           <div class="col-sm-12 col-lg-6 col-md-6">
    
                <div class="table-responsive-md">

                    <table class="table table-dark">

                        <thead>
                            
                            <tr>

                                <th scope="col">Emparejamiento</th>
                                <th scope="col">Id participante 1</th>
                                <th scope="col">Participante 1</th>
                                <th scope="col">Contra</th>
                                <th scope="col">Id participante 2</th>
                                <th scope="col">Participante 2</th>

                            </tr>

                        </thead>

                        <tbody>

                            <%for(Enparejamiento e : em){ %>

                                <tr>

                                    <td><%=e.getNombreEmparejamiento() %></td>
                                    <td><%=e.getIdP1() %></td>
                                    <td><%=e.getNombreP1()%> <%=e.getApellidosP1() %></td>
                                    <td>Vs</td>
                                    <td><%=e.getIdP2() %></td>
                                    <td><%=e.getNombreP2()%> <%=e.getApellidosP2() %></td>

                                </tr>

                            <% } %>

                        </tbody>

                    </table>

                </div>
                                           
           </div>
                            
           <div class="col-sm-12 col-lg-6 col-md-6">
    
               <form method="post" action="ServletEmparejamientoResultado">
                   
                   <div class="form-group bg-dark text-white text-center">

                           <label style="color: white;"><h4 style="text-align: center">Marque al participante ganador</h4></label>
                           
                       </div>
        
                    <% for (int j = 0 ; j < cantidadEmparejamientos ; j++){ %>

                    <div class="col-sm-12 col-lg-12 col-md-12 bg-dark text-white text-center">
                           
                           <div class="form-group bg-dark text-white text-center">

                        <div class="col-sm-12 col-lg-6 col-md-6 form-check bg-dark text-white text-center" style="float: left; border: 1px solid white">
                            
                            <label class="form-check-label">
                                
                                <h3><input type="radio"  style="color: white; margin-top: 3%;" class="form-check-input" checked="checked" value="<%= em.get(j).getIdP1() %>" name="id<%=j%>">
                                <%= em.get(j).getNombreP1() %> <%= em.get(j).getApellidosP1() %> </h3>
                              
                            </label>
                            
                          </div>
                        
                          <div class="col-sm-12 col-lg-6 col-md-6 form-check bg-dark text-white text-center" style="float: right; border: 1px solid white">
                              
                            <label class="form-check-label">
                                
                                <h3><input type="radio" style="color: white; margin-top: 3%;" class="form-check-input" value="<%= em.get(j).getIdP2() %>" name="id<%=j%>">
                                <%= em.get(j).getNombreP2() %> <%= em.get(j).getApellidosP2() %></h3>
                              
                            </label>
                              
                          </div>
                                
                       </div>
                                
                    </div>

                   <% } %>
                   
                   <div class="form-group">
                       
                       <input type="hidden" name="cantidad" value="<%=cantidadEmparejamientos %>">
                       
                   </div>

                       <button style="margin-top: 3%;" type="submit" class="btn btn-info">Insertar resultados</button>
        
                </form> 
               
               
               
               
               
               
                                           
           </div>
                       
</div>
                       
</div>


