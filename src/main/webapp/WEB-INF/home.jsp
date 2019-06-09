<%-- 
    Document   : home
    Created on : 03-jun-2019, 0:50:01
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
            
            <div class="alert alert-info" role="alert">
                 
                <h3> <%= nohayTorneo %> </h3>
            
            </div>
            
        </div>
        
    </div>
    
</div>
            
<% }else if(torneoActivo != null && torneoTerminado == null && nohayTorneo == null){ %>

<div class="container-fluid" style="margin-top: 3%;">
    
    <div class="row h-100 justify-content-center align-items-center">
        
        <div class="col-md-12 col-sl-12 col-sx-12" text-center style=" text-align: center; color: white;"><h2>Todos los torneos creados actualmente</h2></div> 
        
        
        <div class="col-md-12 col-sl-12 col-sx-12 text-center" style="margin: 1%;" ></div> <br>
        
        <% for(Torneo ta : torneoActivo){ %>
        
        <div class="col-md-3 col-lg-3 col-sm-12" style="margin: 1%;">
            
            <div class="card">
                
                <h4 class="card-header"> <%= ta.getNombreTorneo() %> </h4>
                
                <div class="card-body">
                    
                  <h5 class="card-title">Deporte: <%= ta.getDeporte() %> </h5>
                  
                  <h5 class="card-text"> Participantes restantes: <%= ta.getCantidaParticipantes() %> </h5>
                  
                  <p><br></p>
                  
                  <h5 class="card-text"> Estado: <%= ta.getEstado() %> </h5>
                  
                  <form action="ServletMostrarTorneoActivo" method="post">
                      
                  <input type="hidden" name="torneo" value="<%= ta.getNombreTorneo() %>">
                  
                  <button type="submit" class="btn btn-dark">Ver Torneo</button>
                  
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
        
        <% for(Torneo tt : torneoTerminado){ %>
        
        <div class="col-md-3 col-lg-3 col-sm-12" style="margin: 1%;">
            
            <div class="card">
                
                <h4 class="card-header"> <%= tt.getNombreTorneo() %> </h4>
                
                <div class="card-body">
                    
                  <h5 class="card-title">Deporte: <%= tt.getDeporte() %> </h5>
                  
                  <h5 class="card-text"> Participantes restantes: <%= tt.getCantidaParticipantes() %> </h5>
                  
                  <p><br></p>
                  
                  <h5 class="card-text"> Estado: <%= tt.getEstado() %> </h5>
                  
                  <form action="ServletMostrarTorneoTerminado" method="post">
                      
                  <input type="hidden" name="torneo" value="<%= tt.getNombreTorneo() %>">
                  
                  <button type="submit" class="btn btn-danger">Ver Torneo</button>
                  
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
        
        <% for(Torneo ta : torneoActivo){ %>
        
        <div class="col-md-3 col-lg-3 col-sm-12" style="margin: 1%;">
            
            <div class="card">
                
                <h4 class="card-header"> <%= ta.getNombreTorneo() %> </h4>
                
                <div class="card-body">
                    
                  <h5 class="card-title">Deporte: <%= ta.getDeporte() %> </h5>
                  
                  <h5 class="card-text"> Participantes restantes: <%= ta.getCantidaParticipantes() %> </h5>
                  
                  <p><br></p>
                  
                  <h5 class="card-text"> Estado: <%= ta.getEstado() %> </h5>
                  
                  <form action="ServletMostrarTorneoActivo" method="post">
                      
                  <input type="hidden" name="torneo" value="<%= ta.getNombreTorneo() %>">
                  
                  <button type="submit" class="btn btn-dark">Ver Torneo</button>
                  
                  </form>
                  
                </div>
                
            </div>
            
        </div>
        
        <% } %>
        
        
        
        <% for(Torneo tt : torneoTerminado){ %>
        
        <div class="col-md-3 col-lg-3 col-sm-12" style="margin: 1%;">
            
            <div class="card">
                
                <h4 class="card-header"> <%= tt.getNombreTorneo() %> </h4>
                
                <div class="card-body">
                    
                  <h5 class="card-title">Deporte: <%= tt.getDeporte() %> </h5>
                  
                  <h5 class="card-text"> Participantes restantes: <%= tt.getCantidaParticipantes() %> </h5>
                  
                  <p><br></p>
                  
                  <h5 class="card-text"> Estado: <%= tt.getEstado() %> </h5>
                  
                  <form action="ServletMostrarTorneoTerminado" method="post">
                      
                  <input type="hidden" name="torneo" value="<%= tt.getNombreTorneo() %>">
                  
                  <button type="submit" class="btn btn-danger">Ver Torneo</button>
                  
                  </form>
                  
                </div>
                
            </div>
            
        </div>
        
        <% } %>
        
         </div>
    
    </div>
        
        <% } %>