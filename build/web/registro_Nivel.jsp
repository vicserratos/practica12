<%-- 
    Document   : registro_Nivel
    Created on : 15/11/2015, 10:42:08 PM
    Author     : ERICK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registra nivel</title>
    </head>
    <body>
        <form method="post" action="registra_Nivel_proceso.jsp">
            Nivel: <input type="text" size="80" name="snivel" id="snivel">
            <br/>
            id: <input type="text" size="80" name="idnivel" id="idnivel">
            <br/>
            <input type="submit" value="Registrar">
        </form>
    </body>
</html>
