package Controlador;

import Modelo.Personal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PersonalDAO {

    int r;
    PreparedStatement ps;
    ResultSet rs;
    Connection con = Conexion.getCon();

    public int nuevoEmpleado(String nom, String cargo, int sueldo) {

        String sql = "insert into Personal(nombre,cargo,sueldo,Empresa_idEmpresa)values(?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            
            ps.setString(1, nom);
            ps.setString(2, cargo);
            ps.setInt(3, sueldo);
            ps.setInt(4, 1);
            
            ps.executeUpdate();           
        } catch (SQLException e) {
            System.out.println(e);
        }
        return r;
    }
    public List listarInventario() {
        String sql = "select * from Personal";
        List<Personal> listaPersonal = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Personal personal = new Personal();
                personal.setNombre(rs.getString(2));
                personal.setCargo(rs.getString(3));
                personal.setSueldo(rs.getInt(4));
                listaPersonal.add(personal);
            }
        } catch (SQLException e) {
        }
        return listaPersonal;
    }
    
    public int getId(String nom, String desc) {
        String sql = "SELECT idPersonal from Personal WHERE nombre='" + nom + "' AND cargo='" + desc + "'";
        int id = 0;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
        }
        return id;
    }
    
    public int delete(String nom, String desc) {
        String sql2 = "DELETE from Personal WHERE idPersonal='"+getId(nom, desc)+"'";
        try {
            ps = con.prepareStatement(sql2);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return r;
    }

}
