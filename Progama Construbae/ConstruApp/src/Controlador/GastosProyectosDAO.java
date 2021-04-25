package Controlador;

import Modelo.Gasto;
import Modelo.Gastoproyecto;
import Modelo.GastoproyectoPK;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GastosProyectosDAO {

    int r;
    PreparedStatement ps;
    ResultSet rs;
    Connection con = Conexion.getCon();

    public List listarGastosPorProyecto(String nomProyecto) {
        String sql = "SELECT * from GastoProyecto WHERE nomProyecto='" + nomProyecto + "'";
        //AND nombre='"+nom+"' AND caracteristica='"+desc+"'
        List<Gastoproyecto> listaGasto = new ArrayList<>();

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                GastoproyectoPK gpk = new GastoproyectoPK();
                Gastoproyecto gpro = new Gastoproyecto();
                gpro.setNomProyecto(nomProyecto);
                gpro.setNombre(rs.getString(3));
                gpro.setCaracteristica(rs.getString(4));
                gpro.setCantidad(rs.getInt(5));
                gpk.setInventarioGastoidGasto(rs.getInt(8));
                gpro.setGastoproyectoPK(gpk);
                listaGasto.add(gpro);
            }
        } catch (SQLException e) {
        }
        return listaGasto;
    }

    public int delete(String nomPro, String nom, String desc, int cant) {
        String sql = "SELECT idGastoProyecto from GastoProyecto WHERE nomProyecto='" + nomPro + "' AND nombre='" + nom + "' AND caracteristica='" + desc + "' "
                + "AND cantidad='" + cant + "'";
        int id = 0;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
        }
        String sql2 = "DELETE from GastoProyecto WHERE idGastoProyecto='" + id + "'";
        try {
            ps = con.prepareStatement(sql2);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return r;
    }
}
