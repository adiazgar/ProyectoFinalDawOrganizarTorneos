<%-- 
    Document   : borrarTorneo
    Created on : 06-jun-2019, 21:05:22
    Author     : administrador
--%>

<%@page import="java.util.List"%>
<%@page import="projecto.projectofinal.datamodel.entities.Torneo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% List<Torneo> torneoActivo = (List<Torneo>) request.getAttribute("torneoActivo");
   List<Torneo> torneoTerminado = (List<Torneo>) request.getAttribute("torneoTerminado");
   String nohayTorneo = (String) request.getAttribute("nohayTorneo");
%>

<% if(torneoActivo == null && torneoTerminado == null && nohayTorneo != null){ %>

<div class="container text-center">
    
    <div class="row h-100 justify-content-center align-items-center">
        
        <div class="col-md-12 col-sl-12 col-sx-12">
            
            <%=nohayTorneo %>
            
        </div>
        
    </div>
    
</div>
            
<% }else if(torneoActivo != null && torneoTerminado == null && nohayTorneo == null){ %>

<div class="container-fluid" style="margin-top: 3%;">
    
    <div class="row h-100 justify-content-center align-items-center">
        
        <div class="col-md-12 col-sl-12 col-sx-12" text-center style=" text-align: center; color: white;"><h2>Todos los torneos creados actualmente</h2></div> 
        
        
        <div class="col-md-12 col-sl-12 col-sx-12 text-center" style="margin: 1%;" ></div> <br>
        
        <% for(int i= 0;i < torneoActivo.size(); i++){ %>
        
        <div class="col-md-3 col-lg-3 col-sm-12" style="margin: 1%;">
            
            <div class="card">
                
                <h4 class="card-header"> <%= torneoActivo.get(i).getNombreTorneo() %> </h4>
                
                <div class="card-body">
                    
                  <h5 class="card-title">Deporte: <%= torneoActivo.get(i).getDeporte() %> </h5>
                  
                  <h5 class="card-text"> Participantes restantes: <%= torneoActivo.get(i).getCantidaParticipantes() %> </h5>
                  
                  <p><br></p>
                  
                  <h5 class="card-text"> Estado: <%= torneoActivo.get(i).getEstado() %> </h5>
                  
                  <form action="ServletBorrarTorneo" method="post">
                      
                  <input type="hidden" name="torneo" value="<%= torneoActivo.get(i).getNombreTorneo() %>">
                  
                  <button type="button" class="btn btn-dark" data-toggle="modal" data-target="#borrar<%=i%>"l>Eliminar Torneo</button>
                  
                  <div class="modal fade" id="borrar<%=i%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                      
                    <div class="modal-dialog modal-dialog-centered" role="document">
                        
                      <div class="modal-content">
                          
                        <div class="modal-header">
                            
                            <h5 class="modal-title" id="exampleModalLabel">Eliminar torneo <%= torneoActivo.get(i).getNombreTorneo() %></h5>
                          
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                              
                            <span aria-hidden="true">&times;</span>
                            
                          </button>
                          
                        </div>
                          
                        <div class="modal-body">
                          
                            Está seguro que deseas borrar este torneo.
                            
                        </div>
                          
                        <div class="modal-footer">
                            
                          <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                          
                          <button type="submit" class="btn btn-success">Eliminar Torneo</button>
                          
                        </div>
                          
                      </div>
                        
                    </div>
                      
                  </div>
                  
                  </form>
                  
                </div>
                
            </div>
            
        </div>
        
        <% } %>
        
         </div>
    
    </div>

        <% }else if(torneoActivo == null && torneoTerminado != null && nohayTorneo == null){%>
        
        <div class="container-fluid" style="margin-top: 3%;">
    
    <div class="row h-100 justify-content-center align-items-center">
        
        <div class="col-md-12 col-sl-12 col-sx-12" text-center style=" text-align: center; color: white;"><h2>Todos los torneos creados actualmente</h2></div> 
        
        
        <div class="col-md-12 col-sl-12 col-sx-12 text-center" style="margin: 1%;" ></div> <br>
        
        <% for(int i = 0; i < torneoTerminado.size(); i++){ %>
        
        <div class="col-md-3 col-lg-3 col-sm-12" style="margin: 1%;">
            
            <div class="card">
                
                <h4 class="card-header"> <%= torneoTerminado.get(i).getNombreTorneo() %> </h4>
                
                <div class="card-body">
                    
                  <h5 class="card-title">Deporte: <%= torneoTerminado.get(i).getDeporte() %> </h5>
                  
                  <h5 class="card-text"> Participantes restantes: <%= torneoTerminado.get(i).getCantidaParticipantes() %> </h5>
                  
                  <p><br></p>
                  
                  <h5 class="card-text"> Estado: <%= torneoTerminado.get(i).getEstado() %> </h5>
                  
                  <form action="ServletBorrarTorneo" method="post">
                      
                  <input type="hidden" name="torneo" value="<%= torneoTerminado.get(i).getNombreTorneo() %>">
                  
                  <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#borrar<%=i%>">Eliminar Torneo</button>
                  
                  <div class="modal fade" id="borrar<%=i%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                      
                    <div class="modal-dialog modal-dialog-centered" role="document">
                        
                      <div class="modal-content">
                          
                        <div class="modal-header">
                            
                            <h5 class="modal-title" id="exampleModalLabel">Eliminar torneo <%= torneoTerminado.get(i).getNombreTorneo() %></h5>
                          
                          <button type="submit" class="close" data-dismiss="modal" aria-label="Close">
                              
                            <span aria-hidden="true">&times;</span>
                            
                          </button>
                          
                        </div>
                          
                        <div class="modal-body">
                          
                            Está seguro que deseas borrar este torneo.
                            
                        </div>
                          
                        <div class="modal-footer">
                            <input type="hidden" name="torneo" value="<%= torneoTerminado.get(i).getNombreTorneo() %>">
                            
                          <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                          
                          <button type="submit" class="btn btn-success">Eliminar Torneo</button>
                          
                        </div>
                          
                      </div>
                        
                    </div>
                      
                  </div>
                  
                  </form>
                  
                </div>
                
            </div>
            
        </div>
        
        <% } %>
        
         </div>
    
    </div>

        <% }else{ %>
        
            <div class="container-fluid" style="margin-top: 3%;">
    
    <div class="row h-100 justify-content-center align-items-center">
        
        <div class="col-md-12 col-sl-12 col-sx-12" text-center style=" text-align: center; color: white;"><h2>Todos los torneos creados actualmente</h2></div> 
        
        
        <div class="col-md-12 col-sl-12 col-sx-12 text-center" style="margin: 1%;" ></div> <br>
        
        <% for(int i= 0;i < torneoActivo.size(); i++){ %>
        
        <div class="col-md-3 col-lg-3 col-sm-12" style="margin: 1%;">
            
            <div class="card">
                
                <h4 class="card-header"> <%= torneoActivo.get(i).getNombreTorneo() %> </h4>
                
                <div class="card-body">
                    
                  <h5 class="card-title">Deporte: <%= torneoActivo.get(i).getDeporte() %> </h5>
                  
                  <h5 class="card-text"> Participantes restantes: <%= torneoActivo.get(i).getCantidaParticipantes() %> </h5>
                  
                  <p><br></p>
                  
                  <h5 class="card-text"> Estado: <%= torneoActivo.get(i).getEstado() %> </h5>
                  
                  <form action="ServletBorrarTorneo" method="post">
                      
                  <input type="hidden" name="torneo" value="<%= torneoActivo.get(i).getNombreTorneo() %>">
                  
                  <button type="button" class="btn btn-dark" data-toggle="modal" data-target="#borrar<%=i%>">Eliminar Torneo</button>
                  
                  <div class="modal fade" id="borrar<%=i%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                      
                    <div class="modal-dialog modal-dialog-centered" role="document">
                        
                      <div class="modal-content">
                          
                        <div class="modal-header">
                            
                            <h5 class="modal-title" id="exampleModalLabel">Eliminar torneo <%= torneoActivo.get(i).getNombreTorneo() %></h5>
                          
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                              
                            <span aria-hidden="true">&times;</span>
                            
                          </button>
                          
                        </div>
                          
                        <div class="modal-body">
                          
                            Está seguro que deseas borrar este torneo.
                            
                        </div>
                          
                        <div class="modal-footer">
                            
                          <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                          
                          <button type="submit" class="btn btn-success">Eliminar Torneo</button>
                          
                        </div>
                          
                      </div>
                        
                    </div>
                      
                  </div>
                  
                  </form>
                  
                </div>
                
            </div>
            
        </div>
        
        <% } %>
        
        
        <% for(int i = 0; i < torneoTerminado.size(); i++){ %>
        
        <div class="col-md-3 col-lg-3 col-sm-12" style="margin: 1%;">
            
            <div class="card">
                
                <h4 class="card-header"> <%= torneoTerminado.get(i).getNombreTorneo() %> </h4>
                
                <div class="card-body">
                    
                  <h5 class="card-title">Deporte: <%= torneoTerminado.get(i).getDeporte() %> </h5>
                  
                  <h5 class="card-text"> Participantes restantes: <%= torneoTerminado.get(i).getCantidaParticipantes() %> </h5>
                  
                  <p><br></p>
                  
                  <h5 class="card-text"> Estado: <%= torneoTerminado.get(i).getEstado() %> </h5>
                  
                  <form action="ServletBorrarTorneo" method="post">
                      
                  <input type="hidden" name="torneo" value="<%= torneoTerminado.get(i).getNombreTorneo() %>">
                  
                  <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#borrar<%=i+10%>">Eliminar Torneo</button>
                  
                  <div class="modal fade" id="borrar<%=i+10%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                      
                    <div class="modal-dialog modal-dialog-centered" role="document">
                        
                      <div class="modal-content">
                          
                        <div class="modal-header">
                            
                            <h5 class="modal-title" id="exampleModalLabel">Eliminar torneo <%= torneoTerminado.get(i).getNombreTorneo() %></h5>
                          
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                              
                            <span aria-hidden="true">&times;</span>
                            
                          </button>
                          
                        </div>
                          
                        <div class="modal-body">
                          
                            Está seguro que deseas borrar este torneo.
                            
                        </div>
                          
                        <div class="modal-footer">
                            
                          <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                          
                          <button type="submit" class="btn btn-success">Eliminar Torneo</button>
                          
                        </div>
                          
                      </div>
                        
                    </div>
                      
                  </div>
                  
                  </form>
                  
                </div>
                
            </div>
            
        </div>
        
        <% } %>
        
         </div>
    
    </div>
        
        <% } %>