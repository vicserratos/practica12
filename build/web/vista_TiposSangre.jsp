<%-- 
    Document   : vista_TiposSangre
    Created on : 19/11/2015, 11:07:25 AM
    Author     : francisco
--%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="recupera" scope="request" class="control.Control" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tipos de sangre en la base</title>
    </head>
    <body>
        <%
            ArrayList tipos = new ArrayList();
            recupera.conecta();
            tipos = recupera.getTipoSangre();
            recupera.desconecta();
            //Verificamos que se hayan recuperado datos
           
            if(tipos.size()>0){
                //Recorremos el arreglo
                for(int i=0; i < tipos.size(); i++){
                    String tipo = (String)tipos.get(i);
                    //Mostramos cada elemento en la página
                    out.write(tipo + "<br/>");
                }
            }else{
                out.write("Sin datos disponibles");
            }
        %>
    </body>
</html>
