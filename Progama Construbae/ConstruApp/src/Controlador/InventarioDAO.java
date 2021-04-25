package Controlador;

import Modelo.Inventario;
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
public class InventarioDAO {

    int r;
    PreparedStatement ps;
    ResultSet rs;
    Connection con = Conexion.getCon();

    public int nuevoMaterial(String nom, String carac, int cant, int idGasto) {

        String sql = "INSERT into Inventario(nombre,caracteristica,Cantidad,Empresa_idEmpresa,Gasto_idGasto)values(?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, nom);
            ps.setString(2, carac);
            ps.setInt(3, cant);
            ps.setInt(4, 1);
            ps.setInt(5, idGasto);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return r;

    }

    public int getIdGasto(String nom, String desc) {
        String sql = "SELECT Gasto_idGasto from Inventario WHERE nombre='" + nom + "' AND caracteristica='" + desc + "'";
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

    public int getIdInv(String nom, String desc) {
        String sql = "SELECT idInventario from Inventario WHERE nombre='" + nom + "' AND caracteristica='" + desc + "'";
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
        String sql = "SELECT idInventario from Inventario WHERE nombre='" + nom + "' AND caracteristica='" + desc + "'";
        int id = 0;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
        }
        String sql2 = "DELETE from Inventario WHERE idInventario='"+id+"'";
        try {
            ps = con.prepareStatement(sql2);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return r;
    }

    public int actualizar(String nom, String carac, int cant, int idGasto, int idInv) {
        String sql = "update Inventario set nombre=?,caracteristica=?,Cantidad=?,Empresa_idEmpresa=?,Gasto_idGasto=? where idInventario=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nom);
            ps.setString(2, carac);
            ps.setInt(3, cant);
            ps.setInt(4, 1);
            ps.setInt(5, idGasto);
            ps.setInt(6, idInv);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }

    public List listarInventario() {
        String sql = "SELECT * from Inventario";
        List<Inventario> inventario = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Inventario inv = new Inventario();
                inv.setNombre(rs.getString(2));
                inv.setCaracteristica(rs.getString(3));
                inv.setCantidad(rs.getInt(4));
                inventario.add(inv);
            }
        } catch (SQLException e) {
        }
        return inventario;
    }

    public int descontar(String nomProyecto, String nom, String carac, int cant, int idInv, int idGasto) {
        String sql = "insert into GastoProyecto(nomProyecto,nombre,caracteristica,cantidad,Inventario_idInventario,Inventario_Empresa_idEmpresa,Inventario_Gasto_idGasto)values(?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, nomProyecto);
            ps.setString(2, nom);
            ps.setString(3, carac);
            ps.setInt(4, cant);
            ps.setInt(5, idInv);
            ps.setInt(6, 1);
            ps.setInt(7, idGasto);

            ps.executeUpdate();
        } catch (SQLException e) {
        }

        return r;

    }

}
