/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import control.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ERICK
 */
public class Conexion {
    
    //Creamos nuestros objetos para la comunicacion y ejecucion de codigo SQL
    private Connection con;
    private Statement stmt;    
    private ResultSet rs;    
    private final String url;
    private final String sid = "Insti";  //SID de la base
    private final String user = "usuario"; // usuario de la base (system)
    private final String password = "contraseña"; //password de la base (mi contraseña)
    //Constructor    
    public Conexion() {
        this.url = "jdbc:oracle:thin:@localhost:1521:";
        stmt = null;
        con = null;
        rs = null;
    }

    /*
     * Metodo que nos permite abrir la conexion con una base de datos 
     * especificada en el parametro de entrada del metodo que ha sido
     * invocado en la capa de Control
     * @author  Erick Matla
     * @version 1.0
     * @param   nombrebase - nombre de la base de datos a la cual nos 
     *          conectaremos
     */
    public String conectar(String nombreBase)
            throws SQLException {
        String driver = "oracle.jdbc.driver.OracleDriver";       
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url+sid,user,password);
        } catch (ClassNotFoundException | SQLException e) {
            return e.getMessage()+"hola";
        }
    return "Conexion exitosa";
    }

    /*
     * Metodo que nos permite cerrar la conexion con una base de datos 
     * el metodo debe ser invocado en la capa de Control
     * @author  Erick Matla
     * @version 1.0
     * @param   sin parametros     
     */
    public void desconectar()
            throws SQLException {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }
    
    /*
     *
     */
    public ArrayList getAlumnos() throws SQLException {
       ArrayList alumnos = new ArrayList();
        try {
            con = DriverManager.getConnection(url+sid,user,password);
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT nidalumno,sapp,sapm,snombre from Alumno join aspirante on alumno.aspirantenidaspirante = aspirante.nidaspirante where aspirante.nidaspirante = alumno.aspirantenidaspirante");
            while (rs.next()) {
                Alumno a = new Alumno();
                a.setId(rs.getInt(1));
                a.setApp(rs.getString(2));
                a.setApm(rs.getString(3));
                a.setNombre(rs.getString(4));
                alumnos.add(a);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }

        System.out.println(alumnos);
      return alumnos;
    }
    
    public ArrayList getTipoSangre() throws SQLException{
        ArrayList tipos = new ArrayList();
        try {
            con = DriverManager.getConnection(url+sid,user,password);
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT DISTINCT sTipoSangre AS TipoSangre FROM Aspirante");
            while(rs.next()){
                String tSangre = rs.getString(1);
                tipos.add(tSangre);
            }
        }catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return tipos;
    }
    
    public ArrayList getTutores() throws SQLException {
       ArrayList tutores = new ArrayList();
        try {
            con = DriverManager.getConnection(url+sid,user,password);
            stmt = con.createStatement();
            rs = stmt.executeQuery("select sNombre||' '||sApp||' '||sApm as nombreCompleto from Tutor");
            while (rs.next()) {
                Tutor a = new Tutor();
                a.setNombre(rs.getString(1));
                tutores.add(a);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }

        System.out.println(tutores);
      return tutores;
    }
    
    public ArrayList getAspirantes() throws SQLException {
       ArrayList aspirantes = new ArrayList();
        try {
            con = DriverManager.getConnection(url+sid,user,password);
            stmt = con.createStatement();
            rs = stmt.executeQuery("select sNombre||' '||sApp||' '||sApm as NombreCompleto, sTipoSangre as TipoSangre, sCorreo as Correo from Aspirante");
            while (rs.next()) {
                Aspirante a = new Aspirante();
                a.setNombre(rs.getString(1));
                a.setTipoSangre(rs.getString(2));
                a.setCorreo(rs.getString(3));
                aspirantes.add(a);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }

        System.out.println(aspirantes);
      return aspirantes;
    }
    
    public ArrayList getBeca() throws SQLException{
        ArrayList becas = new ArrayList();
        try {
            con = DriverManager.getConnection(url+sid,user,password);
            stmt = con.createStatement();
            rs = stmt.executeQuery("select avg(Beca.nMonto) as \"promedio monto\",sEmpresa as empresa\n" +
            "from\n" +
            "(Beca join Empresa on Beca.Empresanidempresa = empresa.nidempresa)\n" +
            "group by sEmpresa");
            while(rs.next()){
                Beca beca = new Beca();
                beca.setMonto(rs.getInt(1));
                beca.setEmpresa(rs.getString(2));
                becas.add(beca);
            }
        }catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return becas;
    }
    
        public boolean setAspirante(int id, String nombre, String app, String apm, String tipo, String correo) throws Exception{
        boolean b = false;
        
        try{
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO Aspirante (nIdAspirante,sApp,sApm,sNombre,sTipoSangre,sCorreo) VALUES ( " + id + ",'" + app + "','" + apm + "','" + nombre + "','" + tipo + "','" + correo + "')");
            b = true;
            System.out.println(id+nombre+app+apm+tipo+correo);
        } catch (Exception e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return b;
    }
    
    
    public boolean setTutor(int id, String nombre, String app, String apm, String parentesco, String calle, String cp, String municipio, String estado, String tel1, String tipo1, String tel2, String tipo2){
        boolean b = false;
        try{
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO Tutor (nIdTutor,sApp,sApm,sNombre) VALUES (" + id + ",'" + app + "','" + apm + "','" + nombre + "')");
            stmt.executeUpdate("INSERT INTO Telefono (nIdTelefono,sTelefono) VALUES (" + id + ",'" + tel1 + "')");
            stmt.executeUpdate("INSERT INTO Telefono (nIdTelefono,sTelefono) VALUES (" + (id+1) + ",'" + tel2 + "')");
            stmt.executeUpdate("INSERT INTO CTipoTelefono (nIdTipoTelefono,sTipoTelefono) VALUES (" + id + ",'" + tipo1 + "')");
            stmt.executeUpdate("INSERT INTO CTipoTelefono (nIdTipoTelefono,sTipoTelefono) VALUES (" + (id+1) + ",'" + tipo2 + "')");
            stmt.executeUpdate("INSERT INTO CTipoDireccion (nIdTipoDireccion,sTipoDireccion) VALUES (" + id + "," + id + ")");
            stmt.executeUpdate("INSERT INTO CEstado (nIDEstado,sEstado) VALUES (" + id + ",'" + estado + "')");
            stmt.executeUpdate("INSERT INTO CMunicipio (nIdMunicipio,sMunicipio,CEstadonIdEstado) VALUES (" + id + ",'" + municipio + "'," + id + ")");
            stmt.executeUpdate("INSERT INTO Direccion (nIdDireccion,sCalle,sCP,CMunicipionIdMunicipio) VALUES (" + id + ",'" + calle + "','" + cp + "'," + id + ")");
            stmt.executeUpdate("INSERT INTO Tutor_Direccion (TutornIdTutor,DireccionnIdDireccion,CTipoDireccionnIdTipoDireccion) VALUES (" + id + "," + id + "," + id + ")");
            stmt.executeUpdate("INSERT INTO Parentesco (nIdParentesco,sParentesco) VALUES (" + id + ",'" + parentesco + "')");
            stmt.executeUpdate("INSERT INTO Tutor_Aspirante (TutornIdTutor,AspiratenIdAspirante,ParentesconIdParentesco) VALUES (" + id + "," + id + "," + id + ")");
            stmt.executeUpdate("INSERT INTO Telefono_Tutor (TelefononIdTelefono,TutornIdTutor,CTipoTelefononIdTipoTelefono) VALUES (" + id + "," + id + "," + id + ")");            
            b = true;
        } catch (Exception e){
            System.out.println("SQLException: " + e.getMessage());
        }
        return b;
    }
    
    /*
     *
     */    
    public boolean setNivel(String nivel,int id) throws Exception {
        boolean b = false;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("insert into cnivel (nidcnivel,scnivel) VALUES (" + id + ",'" + nivel + "')");
            b = true;
        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
        return b;
    }
    
    public boolean removeAlumno(int id){
        boolean b = false;
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT AspirantenIdAspirante FROM Alumno WHERE nIdAlumno = " + id);
            rs.next();
            int idAspirante = rs.getInt(1);           
            stmt.executeUpdate("DELETE FROM Alumno_CTipoCertificado WHERE AlumnonIdAlumno = " + idAspirante);
            stmt.executeUpdate("DELETE FROM Alumno_Materia_Profesor WHERE AlumnonIdAlumno = " + idAspirante);
            stmt.executeUpdate("DELETE FROM Beca WHERE AlumnonIdAlumno = " + idAspirante);
            stmt.executeUpdate("DELETE FROM Tutor_Aspirante WHERE AspiratenIdAspirante = " + idAspirante);
            stmt.executeUpdate("DELETE FROM Alumno WHERE nIdAlumno = " + id);            
            stmt.executeUpdate("DELETE FROM Aspirante WHERE nIdAspirante = " + idAspirante);         
            b = true;
        } catch (Exception e){
            System.out.println("SQLException: " + e.getMessage());
        }
        return b;
    }
    
        public boolean removeMateria(int id){
        boolean b = false;
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT CNivelnIdCNivel FROM Materia WHERE nIdMateria = " + id);
            rs.next();
            int nIdCNivel = rs.getInt(1);
            rs = stmt.executeQuery("SELECT CCiclonIdCCiclo FROM Materia_Profesor WHERE MaterianIdMateria = " + id);
            rs.next();
            int cCiclonIdCCiclo = rs.getInt(1);
            stmt.executeUpdate("DELETE FROM Materia_Profesor WHERE MaterianIdMateria = " + id);   
            System.out.println("4");
            stmt.executeUpdate("DELETE FROM Materia WHERE nIdMateria = " + id);   
            System.out.println("5");
            stmt.executeUpdate("DELETE FROM CNivel WHERE nIdCNivel = " + nIdCNivel);
            System.out.println("1");
            stmt.executeUpdate("DELETE FROM CCiclo WHERE nIdCCiclo = " + cCiclonIdCCiclo);
            System.out.println("2");
            stmt.executeUpdate("DELETE FROM CTipoCiclo WHERE nIdTipoCiclo = " + cCiclonIdCCiclo);    
            System.out.println("3");
            b = true;
        } catch (Exception e){
            System.out.println("SQLException: " + e.getMessage());
        }
        return b;
    }
}

