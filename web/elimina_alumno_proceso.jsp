<%-- 
    Document   : elimina_alumno_proceso
    Created on : 19/11/2015, 09:01:17 PM
    Author     : Victor
--%>

<jsp:useBean id="registra" scope="request" class="control.Control" />

<%
    int nIdAlumno = Integer.parseInt(request.getParameter("nIdAlumno"));
    
    boolean b = false;
    
    registra.conecta();
    b = registra.removeAlumno(nIdAlumno);
    registra.desconecta();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Elimina Alumno</title>
    </head>
    <body>
        <%
            if(b){
                out.write("Alumno eliminado correctamente");
            }else{
                out.write("Error al eliminar Alumno");                
            }
        %>
    </body>
</html>
