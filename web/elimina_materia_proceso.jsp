<%-- 
    Document   : elimina_materia_proceso
    Created on : 19/11/2015, 10:10:43 PM
    Author     : Victor
--%>

<jsp:useBean id="registra" scope="request" class="control.Control" />

<%
    int nIdMateria = Integer.parseInt(request.getParameter("nIdMateria"));
    
    boolean b = false;
    
    registra.conecta();
    b = registra.removeMateria(nIdMateria);
    registra.desconecta();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Elimina Materia</title>
    </head>
    <body>
        <%
            if(b){
                out.write("Materia eliminada correctamente");
            }else{
                out.write("Error al eliminar Materia");                
            }
        %>
    </body>
</html>
