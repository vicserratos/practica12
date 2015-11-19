<%-- 
    Document   : vista_becas
    Created on : 19/11/2015, 01:50:21 PM
    Author     : francisco
--%>

<%@page import="control.Beca"%>
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
            ArrayList becas = new ArrayList();
            recupera.conecta();
            becas = recupera.getBeca();
            recupera.desconecta();
            //Verificamos que se hayan recuperado datos
           
            if(becas.size()>0){
                //Recorremos el arreglo
                for(int i=0; i < becas.size(); i++){
                    Beca a = (Beca)becas.get(i);
                    //Mostramos cada elemento en la página
                    out.write(a + "<br/>");
                }
            }else{
                out.write("Sin datos disponibles");
            }
        %>
    </body>
</html>
