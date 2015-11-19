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
public class Beca {
    private int monto;
    private String empresa;
    
    public String getEmpresa(){
        return empresa;
    }
    public int getMonto(){
        return monto;
    }
    public void setEmpresa(String empresa){
        this.empresa = empresa;
    }
    public void setMonto(int monto){
        this.monto = monto;
    }
    @Override
    public String toString(){
      return monto + " " + empresa + " ";  
    }
}
