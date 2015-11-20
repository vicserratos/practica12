<%-- 
    Document   : elimina_alumno.jsp
    Created on : 19/11/2015, 08:55:24 PM
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Elimina Alumno</title>
    </head>
    <body>
        <form method="post" action="elimina_alumno_proceso.jsp">
            Id Alumno: <input type="text" size="80" name="nIdAlumno" id="nIdAlumno">
            <br/>
            <input type="submit" value="Eliminar">
        </form>
    </body>
</html>
