<%-- 
    Document   : mostrarTorneoIndividualActivo
    Created on : 03-jun-2019, 23:22:42
    Author     : administrador
--%>

<%@page import="projecto.projectofinal.datamodel.entities.Organizador"%>
<%@page import="projecto.projectofinal.datamodel.entities.Enparejamiento"%>
<%@page import="projecto.projectofinal.datamodel.entities.Resultado"%>
<%@page import="java.util.List"%>
<%@page import="projecto.projectofinal.datamodel.entities.Fase"%>
<%@page import="projecto.projectofinal.datamodel.entities.Torneo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

   <% Torneo tor = (Torneo) request.getAttribute("tor");
      List<Fase> fase = (List<Fase>) request.getAttribute("fase");
      List<List<Resultado>> lres = (List<List<Resultado>>) request.getAttribute("lres");
      List<List<Enparejamiento>> lem = (List<List<Enparejamiento>>) request.getAttribute("lem");
      String aLaEspera = (String) request.getAttribute("aLaEspera"); 
      Organizador org = (Organizador) session.getAttribute("org");
      int numRe = 0;
   
      if(lres != null){
          numRe = lres.size();
          
      }
   
   %>
      
      
      <div class="container-fluid">
    
    <div class="row text-center">
        
        <div class="col-md-12 col-lg-12 col-sm-12" style="margin-top: 3%;">
            
            <div class="col-md-12 col-lg-12 col-sm-12" style="color: white; margin: 2% 0;"><h2>Torneo: <%=tor.getNombreTorneo() %> </h2></div>
            
            <% for(int i = 0; i < fase.size(); i++){%>
            
            <div class="col-sl-12 col-sm-12 col-lg-12 text-left" style="width: 100%;clear: both; border-bottom: 2px solid red;">
                
                <h3 style="color: white">Fase: <%= fase.get(i).getNombreFase() %> </h3></div><br>
                
                <div class="col-lg-6 col-md-6 col-sm-12 " style="float: left;  margin-bottom: 3%;">
                    
                    <div style="width: 100%; margin: 1%;">
                        
                        <h3 style="color: white;">Emparejamientos</h3>
                        
                    </div>
                    
                        <div class="table-responsive-md">

                            <table class="table table-dark table-bordered table-hover">

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
                                    
                                    <% for(Enparejamiento e : lem.get(i)){ %>

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
                    
                 <% if(lres == null || numRe == 0){ %>
                
                <div class="col-md-6 col-sm-12 col-lg-6" style="float: right">
                    
                    <div style="width: 100%; margin: 1%;">
                        
                        <h3 style="color: white;">Resultados</h3>
                        
                    </div>
                    
                    <h2 style="color: white;"><%= aLaEspera %></h2>
                    
                </div>
                
                <% } else { %>
                
                    <div class="col-md-6 col-sm-12 col-lg-6" style="float: right;  margin-bottom: 3%;">
                        
                        <div style="width: 100%; margin: 1%;">
                        
                        <h3 style="color: white;">Resultados</h3>
                        
                    </div>
                    
                        <div class="table-responsive-md">
                   
                        <table class="table table-dark table-bordered table-hover">
                           
                            <thead>
                                
                                <tr>
                                    
                                    <th scope="col">Id participante ganador</th>
                                    <th scope="col">Nombre participante ganador</th>
                                    <th scope="col">Apellidos participante ganador</th>
                                    
                                </tr>
                                
                            </thead>
                            
                            <tbody>
                                
                                <% for(Resultado r : lres.get(i)){ %>
                                
                                <tr>
                                  
                                    <td><%=r.getIdPganador() %></td>
                                    <td><%=r.getNombreGanador() %></td>
                                    <td><%=r.getApellidosGanador() %></td>
                                
                                </tr>
                                
                                <% } %>
                                
                            </tbody>

                        </table>
                        
                    </div>
                        
                </div>
                
                <%  numRe = numRe -1;} %>

            <%  } %>
            
               
               </div>
            
            <%  if(org == null){ %>
               
               <div class="col-lg-12 col-sm-12 col-md-12 text-left" style="margin-bottom: 5%;">
                
                <a class="btn btn-info" href="ServletIndex">Volver página principal</a>
                                               
                </div>
               
               <% }else{ %>
               
               <div class="col-lg-12 col-sm-12 col-md-12 text-left" style="margin-bottom: 5%;">
                
                <a class="btn btn-info" href="ServletCargarOrganizador">Volver página principal</a>
                                               
                </div>
               
               <% } %>
            
        </div>
        
    </div>
    
