package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    //Patron Singleton
    private static Connection con;

    static {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            //con = (Connection) DriverManager.getConnection("jdbc:mysql://construbae.cqluvpme7vly.us-east-1.rds.amazonaws.com:3306/construbae?serverTimezone=UTC", "admin", "Baeza1283");
            //con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/construbae", "root", "");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://mysql.construbae.cl:3306/construbae", "construbae", "Baeza1283");
            
            System.out.println("Coneccion Exitosa!");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e.getMessage());
            System.out.println(e);
        }
    }

    public static Connection getCon() {
        return con;
    }
}
