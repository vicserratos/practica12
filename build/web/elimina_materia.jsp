<%-- 
    Document   : elimina_materia
    Created on : 19/11/2015, 10:06:28 PM
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Elimina Materia</title>
    </head>
    <body>
        <form method="post" action="elimina_materia_proceso.jsp">
            Id Materia: <input type="text" size="80" name="nIdMateria" id="nIdMateria">
            <br/>
            <input type="submit" value="Eliminar">
        </form>
    </body>
</html>