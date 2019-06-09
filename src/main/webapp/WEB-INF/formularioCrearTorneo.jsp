<%-- 
    Document   : newjsp
    Created on : 30-may-2019, 21:04:56
    Author     : administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% String noNombre = (String) request.getAttribute("noNombre");
   String existe = (String) request.getAttribute("existe"); %>

<div class="container">
    
    <div class="row">
        
        <div class=" col-sm-12 col-md-12 col-lg-12 text-center" style="color: white;margin-top: 3%;"><h2>Formulario para crear un torneo</h2></div>

        <div class="col-sm-12 col-md-12 col-lg-12 align-middle" style="margin: 3%; border: 2px solid red;padding: 3%;">
    
    <form method="post" action="ServletCrearTorneo">
        
        <div class="form-group text-left" style="color: white;margin-bottom: 3%">
            
            <label><h3>Nombre del torneo</h3></label>
            
            <input type="text" class="form-control" name="nombre" placeholder="Introduzca el nombre del torneo">
            
        </div>
        
        <div class="form-group text-left" style="color: white; margin-bottom: 3%">
            
            <label><h3>Selecciona el tipo de actividad que tendrá su torneo.</h3></label>
            
            <select class="form-control" id="sel1" name="deporte">
                
                <option value="Natacion">Natación</option>
                <option value="Ping Pong">Ping Pong</option>
                <option value="Carreras de sacos">Carreras de sacos</option>
                <option value="Carrera 100 metro">Carrera 100 metro</option>
                <option value="Tenis">Tenis</option>
                <option value="Petanca">Petanca</option>
                <option value="Damas">Damas</option>
                <option value="Ajedrez">Ajedrez</option>
                
            </select>
            
        </div>
        
        <div class="form-group text-left" style="color: white; margin-bottom: 5%;">
            
            <label><h3>Seleccione el número de participantes que va tener el torneo.</h3></label>
            
            <select class="form-control" id="sel1" name="numero">
                
                <option value="2">Dos participantes</option>
                <option value="4">Cuatro participantes</option>
                <option value="8">Ocho participantes</option>
                <option value="16">Dieciseis participantes</option>
                
            </select>
      
    </div>
  
        <button type="submit" class="btn btn-success">Crear torneo</button>
        
</form>
    
</div>
         
          <% if(noNombre != null){ %>
        
         <div class="col-md-12 col-lg-12 col-sm-12 text-center" style="margin-top: 3%;margin-left: 3%; ">
             
            <div class="alert alert-danger" role="alert">
                 
                <h3> <%= noNombre %> </h3>
            
            </div>
         
         </div>
        
        <% } %>
        
        <% if(existe != null){ %>
        
         <div class="col-md-12 col-lg-12 col-sm-12 text-center" style="margin-top: 3%;margin-left: 3%;">
             
            <div class="alert alert-danger" role="alert">
                 
                <h3> <%= existe %> </h3>
            
            </div>
         
         </div>
        
        <% } %>
         
</div>
    
</div>