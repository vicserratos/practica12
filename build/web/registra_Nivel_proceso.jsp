<%-- 
    Document   : registra_Nivel_proceso
    Created on : 15/11/2015, 10:44:38 PM
    Author     : ERICK
--%>

<jsp:useBean id="registra" scope="request" class="control.Control" />

<%
    String snivel = request.getParameter("snivel");
    String id = request.getParameter("idnivel");
    
    boolean b = false;
    
    registra.conecta();
    b = registra.setNivel(snivel,id);
    registra.desconecta();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registra nivel</title>
    </head>
    <body>
        <%
            if(b){
                out.write("Nivel registrado correctamente");
            }else{
                out.write("Error al registrar nivel");                
            }
        %>
    </body>
</html>
