<%-- 
    Document   : formularioAddParticipante
    Created on : 31-may-2019, 19:30:54
    Author     : administrador
--%>

<%@page import="projecto.projectofinal.datamodel.entities.Torneo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% String  faltaNombre = (String) request.getAttribute("faltaNombre"); %>

<div class="container">
    
    <div class="row">
        
        <% if(faltaNombre != null){ %>
        
         <div class="col-md-12 col-lg-12 col-sm-12 text-center" style="margin-top: 10%;">
             
            <div class="alert alert-danger" role="alert">
                 
                <h3> <%= faltaNombre %> </h3>
            
            </div>
         
         </div>
        
        <% } %>

        <div class="col-sm-12 col-lg-12 col-md-12" style="margin-top: 3%;">

            <form method="post" action="ServletAddParticipantes" style="margin-bottom: 5%;">

                <% int numero = (Integer) session.getAttribute("numero");

               for (int j = 0 ; j < numero; j++){ %>

               <div class="col-sm-12 col-sl-12" style="border: 2px solid red;">
                   
                   <div><h4 style="color: white; padding: 1%;">Participante <%= j+1%></h4></div>

                <div class="form-group">

                    <label style="color: white;">Nombre participante <%= j+1%></label>

                    <input type="text" class="form-control" name="nombre" placeholder="Introduzca el nombre del participante">

                </div>

                <div class="form-group">

                    <label style="color: white;">Apellidos participante <%= j+1%></label>

                    <input type="text" class="form-control" name="apellidos" placeholder="Introduzca apellidos">

                </div>

                <div class="form-group">

                    <label style="color: white;">Edad participante <%= j+1%></label>

                    <input type="text" class="form-control" name="edad" placeholder="Introduzca edad">

                </div>

               </div>

                    <br><br>

               <% } %>

               <button type="submit" class="btn btn-info">Añadir participantes</button>

        </form>

        </div>

       
    </div>
               
</div>
