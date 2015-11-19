

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author francisco
 */
public class Prueba {
   public static void main(String args[]) throws SQLException {
        //URL of Oracle database server
        String url = "jdbc:oracle:thin:@localhost:1521:Insti"; 
     Connection con;
     Statement stmt;    
     ResultSet rs; 
        //properties for creating connection to Oracle database
      
        //creating connection to Oracle database using JDBC
        ArrayList alumnos = new ArrayList();
        try {
            con = DriverManager.getConnection(url,"system","androidE76");
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
      
    }

}
