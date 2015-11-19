<%-- 
    Document   : vista_aspirante
    Created on : 19/11/2015, 01:24:05 PM
    Author     : francisco
--%>
<%@page import="control.Aspirante"%>
<%@page import="control.Tutor"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="recupera" scope="request" class="control.Control" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
            ArrayList aspirantes = new ArrayList();
            recupera.conecta();
            aspirantes = recupera.getAspirantes();
            recupera.desconecta();
            //Verificamos que se hayan recuperado datos
           
            if(aspirantes.size()>0){
                //Recorremos el arreglo
                for(int i=0; i < aspirantes.size(); i++){
                    Aspirante a = (Aspirante)aspirantes.get(i);
                    //Mostramos cada elemento en la página
                    out.write(a + "<br/>");
                }
            }else{
                out.write("Sin datos disponibles");
            }
        %>
    </body>
</html>
