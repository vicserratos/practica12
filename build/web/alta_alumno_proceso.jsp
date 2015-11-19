<%-- 
    Document   : alta_alumno_proceso
    Created on : 19/11/2015, 11:41:41 AM
    Author     : Victor
--%>

<jsp:useBean id="registraA" scope="request" class="control.Control" />

<%
    String nidaspirante = request.getParameter("nIdAspiranteA");
    int idd = Integer.parseInt(nidaspirante);
    String sNombreA = request.getParameter("sNombreA");
    String sAppA = request.getParameter("sAppA");
    String sApmA = request.getParameter("sApmA");
    String stipoSangre = request.getParameter("sTipoSangreA");
    String sCorreo = request.getParameter("sCorreoA");
    
    String sNombreT1 = request.getParameter("sNombreT1");
    String sAppT1 = request.getParameter("sAppT1");
    String sApmT1 = request.getParameter("sApmT1");
    String sParentescoT1 = request.getParameter("sParentescoT1");
    String sCalleT1 = request.getParameter("sCalleT1");
    String sCPT1 = request.getParameter("sCPT1");
    String sMunicipioT1 = request.getParameter("sMunicipioT1");
    String sEstadoT1 = request.getParameter("sEstadoT1");
    String sTelefono1T1 = request.getParameter("sTelefono1T1");
    String sTipoTelefono1T1 = request.getParameter("sTipoTelefono1T1");
    String sTelefono2T1 = request.getParameter("sTelefono2T1");
    String sTipoTelefono2T1 = request.getParameter("sTipoTelefono2T1");
    
    String sNombreT2 = request.getParameter("sNombreT2");
    String sAppT2 = request.getParameter("sAppT2");
    String sApmT2 = request.getParameter("sApmT2");
    String sParentescoT2 = request.getParameter("sParentescoT2");
    String sCalleT2 = request.getParameter("sCalleT2");
    String sCPT2 = request.getParameter("sCPT2");
    String sMunicipioT2 = request.getParameter("sMunicipioT2");
    String sEstadoT2 = request.getParameter("sEstadoT2");
    String sTelefono1T2 = request.getParameter("sTelefono1T2");
    String sTipoTelefono1T2 = request.getParameter("sTipoTelefono1T2");
    String sTelefono2T2 = request.getParameter("sTelefono2T2");
    String sTipoTelefono2T2 = request.getParameter("sTipoTelefono2T2");

    
    boolean b = false;
    boolean c = false;
    
    registraA.conecta();
    b = registraA.setAspirante(idd, sNombreA, sAppA, sApmA, stipoSangre, sCorreo);
    b = registraA.setTutor(idd, sNombreT1,sAppT1,sApmT1,sParentescoT1,sCalleT1,sCPT1,sMunicipioT1,sEstadoT1,sTelefono1T1,sTipoTelefono1T1,sTelefono2T1,sTipoTelefono2T1);
    registraA.desconecta();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registra Alumno</title>
    </head>
    <body>
        <%
            if(b){
                out.write("Alumno registrado correctamente");
            }else{
                out.write("Error al registrar Alumno");                
            }
        %>
    </body>
</html>
