package Controlador;

import Modelo.Gasto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Seba-PC
 */
public class GastoDAO {

    int r;
    PreparedStatement ps;
    ResultSet rs;
    Connection con = Conexion.getCon();

    public int nuevoGasto(String nom, String desc, int pre, int cant, int tot, String fech) {

        String sql = "insert into Gasto(nombre,descripcion,precio,cantidad,total,fecha,Empresa_idEmpresa)values(?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, nom);
            ps.setString(2, desc);
            ps.setInt(3, pre);
            ps.setInt(4, cant);
            ps.setInt(5, tot);
            ps.setString(6, fech);
            ps.setInt(7, 1);

            ps.executeUpdate();
        } catch (SQLException e) {
        }

        return r;

    }

    public int getId(String nom, String desc, int pre, int cant, int tot, String fech) {
        String sql = "SELECT idGasto from Gasto WHERE nombre='" + nom + "' AND descripcion='" + desc + "' AND precio='" + pre + "' AND cantidad='" + cant + "'"
                + "AND total='" + tot + "' AND fecha='" + fech + "'";
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
    public int delete(String nom, String desc, int pre, int cant, int tot, String fech) {
        String sql2 = "DELETE from Gasto WHERE idGasto='"+getId(nom, desc, pre, cant, tot, fech)+"'";
        try {
            ps = con.prepareStatement(sql2);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return r;
    }

    public List listarGastosPorDia(String num) {
        String sql = "SELECT * from Gasto WHERE SUBSTRING(Fecha,9,2)='" + num + "'";
        List<Gasto> listaGasto = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Gasto g = new Gasto();
                g.setNombre(rs.getString(2));
                g.setDescripcion(rs.getString(3));
                g.setPrecio(rs.getInt(4));
                g.setCantidad(rs.getInt(5));
                g.setTotal(rs.getInt(6));
                g.setFecha(rs.getString(7));
                listaGasto.add(g);
            }
        } catch (SQLException e) {
        }
        return listaGasto;
    }

    public List listarGastosPorMes(String num) {
        String sql = "SELECT * from Gasto WHERE SUBSTRING(Fecha,6,2)='" + num + "'";
        List<Gasto> listaGasto = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Gasto g = new Gasto();
                g.setNombre(rs.getString(2));
                g.setDescripcion(rs.getString(3));
                g.setPrecio(rs.getInt(4));
                g.setCantidad(rs.getInt(5));
                g.setTotal(rs.getInt(6));
                g.setFecha(rs.getString(7));
                listaGasto.add(g);
            }
        } catch (SQLException e) {
        }
        return listaGasto;
    }

    public List listarGastosPorAño(String num) {
        String sql = "SELECT * from Gasto WHERE SUBSTRING(Fecha,1,4)='" + num + "'";
        List<Gasto> listaGasto = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Gasto g = new Gasto();
                g.setNombre(rs.getString(2));
                g.setDescripcion(rs.getString(3));
                g.setPrecio(rs.getInt(4));
                g.setCantidad(rs.getInt(5));
                g.setTotal(rs.getInt(6));
                g.setFecha(rs.getString(7));
                listaGasto.add(g);
            }
        } catch (SQLException e) {
        }
        return listaGasto;
    }

    public int getPrecio(int id){
    
    String sql="SELECT precio from Gasto WHERE idGasto='"+id+"'";
    
    int precio = 0;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                precio = rs.getInt(1);
            }
        } catch (SQLException e) {
        }
        return precio;
       
    }
}
