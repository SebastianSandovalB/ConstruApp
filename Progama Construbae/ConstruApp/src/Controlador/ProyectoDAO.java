package Controlador;

import Modelo.Proyecto;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class ProyectoDAO {

    int r;
    PreparedStatement ps;
    ResultSet rs;
    Connection con = Conexion.getCon();
    Proyecto p = new Proyecto();

    public int nuevoProyecto(String nom, String comuna, String adjudicado) {

        String sql = "insert into Proyecto(direccion,comuna,adjudicado,Empresa_idEmpresa)values(?,?,?,?)";
        Usuario u = null;
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, nom);
            ps.setString(2, comuna);
            ps.setString(3, adjudicado);
            ps.setString(4, "1");

            ps.executeUpdate();
        } catch (SQLException e) {
        }

        return r;

    }

    public JComboBox listarProyecto(JComboBox combx) {

        String sql = "select * from Proyecto";
        ArrayList<String> listaProyecto = new ArrayList<>();

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                combx.addItem(rs.getString("adjudicado"));
            }
        } catch (SQLException e) {
        }
        return combx;
    }
}
