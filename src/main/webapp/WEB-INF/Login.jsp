<%-- 
    Document   : Login
    Created on : 29-may-2019, 20:54:58
    Author     : administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% String noLogin = (String) request.getAttribute("noLogin"); %>

<div class="container py-5">
    
    <div class="row">
        
        <div class="col-md-12">
            
            <h2 class="text-center text-white mb-4">Bienvenido al inicio de sessión de organizadores</h2>
            
            <div class="row">
                
                <div class="col-md-6 mx-auto" style="margin-top: 3%;">

                    <div class="card rounded-0">
                        
                        <div class="card-header">
                            
                            <h3 class="mb-0">Iniciar Sessión</h3>
                            
                        </div>
                        
                        <div class="card-body">
                            
                            <form class="form" role="form" action="ServletLogin" autocomplete="off" id="formLogin" novalidate="" method="POST">
                                
                                <div class="form-group">
                                    
                                    <label for="usuario">Usuario</label>
                                    
                                    <input type="text" class="form-control form-control-lg rounded-0" name="usuario" id="usuario"
                                           placeholder="Introduzca la contraseña" required="">
                                    
                                    <div class="invalid-feedback">Es necesario escribir el usuario!</div>
                                    
                                </div>
                                
                                <div class="form-group">
                                    
                                    <label>Contraseña</label>
                                    
                                    <input type="password" class="form-control form-control-lg rounded-0" id="password" name="password"
                                           required="" placeholder="Introduzca la contraseña" autocomplete="new-password">
                                    
                                    <div class="invalid-feedback">Es necesario escribir la contraseña!</div>
                                    
                                </div>
                                
                               
                                
                                <button type="submit" class="btn btn-success btn-lg float-right" id="btnLogin">Iniciar Sessión</button>
                                
                            </form>
                            
                        </div>
                       
                    </div>

                </div>

            </div>

        </div>
        
        <% if(noLogin != null){ %>
        
         <div class="col-md-12 col-lg-12 col-sm-12 text-center" style="margin-top: 10%; bo">
             
            <div class="alert alert-danger" role="alert">
                 
                <h3> <%= noLogin %> </h3>
            
            </div>
         
         </div>
        
        <% } %>
        
    </div>
    
</div>
        
        <script>
            
            $("#btnLogin").click(function(event) {

    //Fetch form to apply custom Bootstrap validation
    var form = $("#formLogin");

    if (form[0].checkValidity() === false) {
      event.preventDefault();
      event.stopPropagation();
    }
    
    form.addClass('was-validated');
  });
            
        </script>