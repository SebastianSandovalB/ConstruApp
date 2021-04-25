package Controlador;

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioDAO {
    
    int r;
    PreparedStatement ps;
    ResultSet rs;
    Connection con = Conexion.getCon();
    Usuario u = new Usuario();
    
    public Usuario getUserByName(String nom, String pw){
    
    String sql = "select * from Usuario WHERE nombre=? and contraseña=?";
    Usuario u = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nom);
            ps.setString(2, pw);
            rs = ps.executeQuery();
            while (rs.next()) {
                u = new Usuario();
                u.setNombre(rs.getString(2));
                u.setContraseña(rs.getString(3));
                u.setCargo(rs.getString(4));
            }
        } catch (SQLException e) {
        }

     return u;
    
    }
}
