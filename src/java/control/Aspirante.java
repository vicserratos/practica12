/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author francisco
 */
public class Aspirante {
    private String nombre;
    private String tiposangre;
    private String correo;
    
   public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoSangre() {
        return tiposangre;
    }

    public void setTipoSangre(String tiposangre) {
        this.tiposangre = tiposangre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    @Override
    public String toString(){
        return "Nombre: " +nombre + " Tipo de sangre: " + tiposangre + " Correo: " + correo + " ";
    }
}
