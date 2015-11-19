<%-- 
    Document   : alta_alumno
    Created on : 19/11/2015, 11:16:28 AM
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registra Alumno</title>
    </head>
    <body>
        <form method="post" action="alta_alumno_proceso.jsp">
            Datos de Alumno
            <br/>
            Id: <input type="text" size="80" name="nIdAspiranteA" id="nIdAspirante">
            <br/>
            Nombre: <input type="text" size="80" name="sNombreA" id="sNombre">
            <br/>
            Apellido Paterno: <input type="text" size="80" name="sAppA" id="sApp">
            <br/>
            Apeliido Materno: <input type="text" size="80" name="sApmA" id="sApm">
            <br/>
            Tipo de Sangre: <input type="text" size="80" name="sTipoSangreA" id="sTipoSangre">
            <br/>
            Correo electronico: <input type="text" size="80" name="sCorreoA" id="sCorreo">
            <br/><br/>
            
            Datos Tutor 1
            <br/>
            Nombre: <input type="text" size="80" name="sNombreT1" id="sNombre">
            <br/>
            Apellido Paterno: <input type="text" size="80" name="sAppT1" id="sApp">
            <br/>
            Apellido Materno: <input type="text" size="80" name="sApmT1" id="sApm">
            <br/>
            Parentesco: <input type="text" size="80" name="sParentescoT1" id="sParentesco">
            <br/>
            Calle: <input type="text" size="80" name="sCalleT1" id="sCalle">
            <br/>
            Codigo Postal: <input type="text" size="80" name="sCPT1" id="sCP">
            <br/>
            Municipio: <input type="text" size="80" name="sMunicipioT1" id="sMunicipioT1">
            <br/>
            Estado: <input type="text" size="80" name="sEstadoT1" id="sEstado">
            <br/>
            Telefono 1: <input type="text" size="80" name="sTelefono1T1" id="sTelefono">
            <br/>
            Tipo Telefono 1: <input type="text" size="80" name="sTipoTelefono1T1" id="sTipoTelefono">
            <br/>
            Telefono 2: <input type="text" size="80" name="sTelefono2T1" id="sTelefono">
            <br/>
            Tipo Telefono 2: <input type="text" size="80" name="sTipoTelefono2T1" id="sTipoTelefono">
            <br/><br/>
            
            Datos Tutor 2
            <br/>
            Nombre: <input type="text" size="80" name="sNombreT2" id="sNombre">
            <br/>
            Apellido Paterno: <input type="text" size="80" name="sAppT2" id="sApp">
            <br/>
            Apellido Materno: <input type="text" size="80" name="sApmT2" id="sApm">
            <br/>
            Parentesco: <input type="text" size="80" name="sParentescoT2" id="sParentesco">
            <br/>
            Calle: <input type="text" size="80" name="sCalleT2" id="sCalle">
            <br/>
            Codigo Postal: <input type="text" size="80" name="sCPT2" id="sCP">
            <br/>
            Municipio: <input type="text" size="80" name="sMunicipioT2" id="sMunicipioT1">
            <br/>
            Estado: <input type="text" size="80" name="sEstadoT2" id="sEstado">
            <br/>
            Telefono 1: <input type="text" size="80" name="sTelefono1T2" id="sTelefono">
            <br/>
            Tipo Telefono 1: <input type="text" size="80" name="sTipoTelefono1T2" id="sTipoTelefono">
            <br/>
            Telefono 2: <input type="text" size="80" name="sTelefono2T2" id="sTelefono">
            <br/>
            Tipo Telefono 2: <input type="text" size="80" name="sTipoTelefono2T2" id="sTipoTelefono">
            <br/><br/>
            <input type="submit" value="Registrar">
        </form>
    </body>
</html>
