<%-- 
    Document   : LayoutOrg
    Created on : 29-may-2019, 21:20:28
    Author     : administrador
--%>

<%@page import="projecto.projectofinal.datamodel.entities.Organizador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body style="background-image: url(img/f.jpg); padding-top: 70px;">
        
       <nav class="navbar navbar-expand-lg navbar-light bg-dark fixed-top" style="color:white;">
           
            <a class="navbar-brand" href="ServletCargarOrganizador" style="color: white; margin-right: 10%;">Organizador de torneos</a>
            
            <button class="navbar-toggler" type="button" data-toggle="collapse" 
                    data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            
            <div class="collapse navbar-collapse" id="navbarNav">
                
              <ul class="navbar-nav mr-auto">
                  
                  <li class="nav-item" >
                      
                    <a class="btn btn-outline-success d-lg-inline-block mb-3 mb-md-0 ml-md-3" href="ServletFormularioTorneo">Crear Torneo</a>
                    
                </li>
                
                <li class="nav-item" style="float:right">
                    
                    <a class="btn btn-outline-info d-lg-inline-block mb-3 mb-md-0 ml-md-3" href="ServletRdResultado">Insertar Resultados</a>
                    
                </li>
                
                <li class="nav-item" style="float:right">
                    
                    <a class="btn btn-outline-danger d-lg-inline-block mb-3 mb-md-0 ml-md-3" href="ServletRdBorrarTorneo">Borrar Torneo</a>
                    
                </li>
                
              </ul>
                
                <a class="btn btn-outline-light d-lg-inline-block mb-3 mb-md-0 ml-md-3" href="ServletLogout">Cerrar Sessión</a>
                
            </div>
            
          </nav>
            
            <div class="row">
                
                <div class="col-sl-12 col-sm-12">
                    
                    <jsp:include page="<%= ((String) request.getAttribute("action")) + ".jsp" %>"></jsp:include>
                    
                </div>
                
            </div>
            
            
        </div>
        
        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
       integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" 
integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script> 
    </body>
</html>
