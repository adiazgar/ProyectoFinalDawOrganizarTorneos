<%-- 
    Document   : erroresAdmin
    Created on : 01-jun-2019, 20:19:02
    Author     : administrador
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    
    <% 
       String noHaPuestoResultado = (String) request.getAttribute("noHaPuestoResultado");
       String idNoValidos = (String) request.getAttribute("idNoValidos");
       String torneoCerrado = (String) request.getAttribute("torneoCerrado");
       String idYaInsertados = (String) request.getAttribute("idYaInsertados");
   
    %>
    
    <div class="container"> 
    
    <div class="row text-center">
    
    <% if(noHaPuestoResultado != null){%>
        
        <div class="col-lg-12 col-md-12 col-sm-12 align-middle">
            
            <div class="alert alert-danger text-center" style="margin: 3%;" role="alert">
                 
                <h3> <%= noHaPuestoResultado %> </h3>
            
            </div>
            
        </div>

    <% } %>
    
    <% if(idNoValidos != null){%>
        
        <div class="col-lg-12 col-md-12 col-sm-12 align-middle">
            
            <div class="alert alert-danger text-center" style="margin: 3%;" role="alert">
                 
                <h3> <%= idNoValidos %> </h3>
            
            </div>
            
        </div>

    <% } %>
    
    <% if(torneoCerrado != null){%>
        
        <div class="col-lg-12 col-md-12 col-sm-12 align-middle">
            
            <div class="alert alert-danger text-center" style="margin: 3%;" role="alert">
                 
                <h3> <%= torneoCerrado %> </h3>
            
            </div>
            
        </div>

    <% } %>
    
    <% if(idYaInsertados != null){%>
        
        <div class="col-lg-12 col-md-12 col-sm-12 align-middle">
            
            <div class="alert alert-danger text-center" style="margin: 3%;" role="alert">
                 
                <h3> <%= idYaInsertados %> </h3>
            
            </div>
            
        </div>

    <% } %>
    
    <div class="col-lg-12 col-sm-12 col-md-12 text-left" style="margin-bottom: 5%;">
                
                <a class="btn btn-info" href="ServletCargarOrganizador">Volver página principal</a>
                                               
         </div>
    
     </div>
    
</div>
