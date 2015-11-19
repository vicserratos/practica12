<%-- 
    Document   : vista_alumnos
    Created on : 15/11/2015, 10:31:10 PM
    Author     : ERICK
--%>

<%@page import="control.Alumno"%>
<%@page import="control.Tutor"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="recupera" scope="request" class="control.Control" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vista Alumnos</title>
    </head>
    <body>
        <%
            ArrayList tutores = new ArrayList();
            recupera.conecta();
            tutores = recupera.getTutores();
            recupera.desconecta();
            //Verificamos que se hayan recuperado datos
           
            if(tutores.size()>0){
                //Recorremos el arreglo
                for(int i=0; i < tutores.size(); i++){
                    String nombre = ((Tutor)tutores.get(i)).getNombre();
                    //Mostramos cada elemento en la página
                    out.write(nombre + "<br/>");
                }
            }else{
                out.write("Sin datos disponibles");
            }
        %>
    </body>
</html>
