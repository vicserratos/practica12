/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import datos.Conexion;
import java.util.ArrayList;

/**
 *
 * @author ERICK
 */
public class Control {
    
    // Creamos un objeto de tipo Conexion para abrir la comunicacion con la base 
    // de datos
    Conexion conexionBD = new Conexion();

    /*
     * Metodo que permite realizar la conexion a una base de datos especifica.
     * @author     Erick Matla          
     * @param      sin parametros
     */
    public String conecta() {
        try {
            conexionBD.conectar("Insti");
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Conexion exitosa";
    }

    /*
     * Metodo que permite realizar la desconexion de una base de datos.
     * @author     Erick Matla     
     * @param      sin parametros
     */
    public void desconecta() {
        try {
            conexionBD.desconectar();
        } catch (Exception e) {
            System.out.println("Desconexión fallida" + e.getMessage());
        }
    }
    
    /*
     * Método que permite recuperar los alumnos registrados
     */
    public ArrayList getAlumnos() throws Exception{
        ArrayList alumnos = new ArrayList();
        try{
            alumnos = conexionBD.getAlumnos();
        }catch(Exception ex){
            System.err.println("Error durante la conexión con la BD: " + ex.getMessage());
        }
        return alumnos;
    }
    
    public ArrayList getTutores() throws Exception{
        ArrayList tutores = new ArrayList();
        try{
            tutores = conexionBD.getTutores();
        }catch(Exception ex){
            System.err.println("Error durante la conexión con la BD: " + ex.getMessage());
        }
        return tutores;
    }
    public ArrayList getTipoSangre() throws Exception{
        ArrayList tipos = new ArrayList();
        try{
            tipos = conexionBD.getTipoSangre();
        }catch(Exception ex){
            System.err.println("Error durante la conexión con la BD: " + ex.getMessage());
        }
        return tipos;
    }
    
    public ArrayList getAspirantes() throws Exception{
        ArrayList aspirantes = new ArrayList();
        try{
            aspirantes = conexionBD.getAspirantes();
        }catch(Exception ex){
            System.err.println("Error durante la conexión con la BD: " + ex.getMessage());
        }
        return aspirantes;
    }
    
    public ArrayList getBeca() throws Exception{
        ArrayList becas = new ArrayList();
        try{
            becas = conexionBD.getBeca();
        }catch(Exception ex){
            System.err.println("Error durante la conexión con la BD: " + ex.getMessage());
        }
        return becas;
    }
    
        public boolean setAspirante(int id, String nombre, String app, String apm, String tipo, String correo){
        boolean b = false;
        try{
            b = conexionBD.setAspirante(id, nombre, app, apm, tipo, correo);
        } catch(Exception e){
            System.err.println("Error durante a conexion con la BD: " + e.getMessage());
        }
        return b;
    }
    
    public boolean setTutor(int id, String nombre, String app, String apm, String parentesco, String calle, String cp, String municipio, String estado, String tel1, String tipo1, String tel2, String tipo2){
        boolean b = false;
        try{
            b = conexionBD.setTutor(id, nombre, app, apm, parentesco, calle, cp , municipio, estado, tel1, tipo1, tel2, tipo2);
        } catch (Exception e){
            System.err.println("Error durante a conexion con la BD: " + e.getMessage());
        }
        return b;
    }
    
    /*
     * Método que permite recuperar los alumnos registrados
     */
    public boolean setNivel(String nivel,String id) throws Exception{
        boolean b = false;
        try{
            int num = Integer.parseInt(id);
            b = conexionBD.setNivel(nivel,num);
        }catch(Exception ex){
            System.err.println("Error durante la conexión con la BD: " + ex.getMessage());
        }
        return b;
    }
}
