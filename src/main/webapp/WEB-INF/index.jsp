<%-- 
    Document   : index
    Created on : 29-may-2019, 19:59:57
    Author     : administrador
--%>

<%@page import="java.util.List"%>
<%@page import="projecto.projectofinal.datamodel.entities.Torneo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% RequestDispatcher rd = request.getRequestDispatcher("ServletIndex");
   rd.forward(request, response); 
%>

