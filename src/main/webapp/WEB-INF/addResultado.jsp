<%-- 
    Document   : formularioAddResultado
    Created on : 01-jun-2019, 20:04:07
    Author     : administrador
--%>

<%@page import="projecto.projectofinal.datamodel.entities.Enparejamiento"%>
<%@page import="projecto.projectofinal.datamodel.entities.Fase"%>
<%@page import="java.util.List"%>
<%@page import="projecto.projectofinal.datamodel.entities.Torneo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    
    <% List<Torneo> torneos = (List<Torneo>) request.getAttribute("listaTorneos"); %>
    
    

<div class="container-fluid" style="margin-top: 3%;">
    
    <div class="row h-100 justify-content-center align-items-center">
        
        <div class="col-md-12 col-sl-12 col-sx-12" text-center style=" text-align: center; color: white;"><h2>Torneos en proceso</h2></div> 
        
        
        <div class="col-md-12 col-sl-12 col-sx-12 text-center" style="margin: 1%;" ></div> <br>
        
        <% for(Torneo t : torneos){ %>
        
        <div class="col-md-3 col-lg-3 col-sm-12" style="margin: 1%;">
            
            <div class="card">
                
                <h4 class="card-header"> <%= t.getNombreTorneo() %> </h4>
                
                <div class="card-body">
                    
                  <h5 class="card-title">Deporte: <%= t.getDeporte() %> </h5>
                  
                  <h5 class="card-text"> Participantes restantes: <%= t.getCantidaParticipantes() %> </h5>
                  
                  <p><br></p>
                  
                  <h5 class="card-text"> Estado: <%= t.getEstado() %> </h5>
                  
                  <form action="ServletFaseResultado" method="post">
                      
                  <input type="hidden" name="torneo" value="<%= t.getNombreTorneo() %>">
                  
                  <button type="submit" class="btn btn-dark">Insertar resultado</button>
                  
                  </form>
                  
                </div>
                
            </div>
            
        </div>
        
        <% } %>
        
        
    </div>
    
</div>
        