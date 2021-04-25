/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Seba-PC
 */
@Entity
@Table(name = "gastoproyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gastoproyecto.findAll", query = "SELECT g FROM Gastoproyecto g")
    , @NamedQuery(name = "Gastoproyecto.findByIdGastoProyecto", query = "SELECT g FROM Gastoproyecto g WHERE g.gastoproyectoPK.idGastoProyecto = :idGastoProyecto")
    , @NamedQuery(name = "Gastoproyecto.findByNomProyecto", query = "SELECT g FROM Gastoproyecto g WHERE g.nomProyecto = :nomProyecto")
    , @NamedQuery(name = "Gastoproyecto.findByNombre", query = "SELECT g FROM Gastoproyecto g WHERE g.nombre = :nombre")
    , @NamedQuery(name = "Gastoproyecto.findByCaracteristica", query = "SELECT g FROM Gastoproyecto g WHERE g.caracteristica = :caracteristica")
    , @NamedQuery(name = "Gastoproyecto.findByCantidad", query = "SELECT g FROM Gastoproyecto g WHERE g.cantidad = :cantidad")
    , @NamedQuery(name = "Gastoproyecto.findByInventarioidInventario", query = "SELECT g FROM Gastoproyecto g WHERE g.gastoproyectoPK.inventarioidInventario = :inventarioidInventario")
    , @NamedQuery(name = "Gastoproyecto.findByInventarioEmpresaidEmpresa", query = "SELECT g FROM Gastoproyecto g WHERE g.gastoproyectoPK.inventarioEmpresaidEmpresa = :inventarioEmpresaidEmpresa")
    , @NamedQuery(name = "Gastoproyecto.findByInventarioGastoidGasto", query = "SELECT g FROM Gastoproyecto g WHERE g.gastoproyectoPK.inventarioGastoidGasto = :inventarioGastoidGasto")})
public class Gastoproyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GastoproyectoPK gastoproyectoPK;
    @Basic(optional = false)
    @Column(name = "nomProyecto")
    private String nomProyecto;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "caracteristica")
    private String caracteristica;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumns({
        @JoinColumn(name = "Inventario_idInventario", referencedColumnName = "idInventario", insertable = false, updatable = false)
        , @JoinColumn(name = "Inventario_Empresa_idEmpresa", referencedColumnName = "Empresa_idEmpresa", insertable = false, updatable = false)
        , @JoinColumn(name = "Inventario_Gasto_idGasto", referencedColumnName = "Gasto_idGasto", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Inventario inventario;

    public Gastoproyecto() {
    }

    public Gastoproyecto(GastoproyectoPK gastoproyectoPK) {
        this.gastoproyectoPK = gastoproyectoPK;
    }

    public Gastoproyecto(GastoproyectoPK gastoproyectoPK, String nomProyecto, String nombre, String caracteristica, int cantidad) {
        this.gastoproyectoPK = gastoproyectoPK;
        this.nomProyecto = nomProyecto;
        this.nombre = nombre;
        this.caracteristica = caracteristica;
        this.cantidad = cantidad;
    }

    public Gastoproyecto(int idGastoProyecto, int inventarioidInventario, int inventarioEmpresaidEmpresa, int inventarioGastoidGasto) {
        this.gastoproyectoPK = new GastoproyectoPK(idGastoProyecto, inventarioidInventario, inventarioEmpresaidEmpresa, inventarioGastoidGasto);
    }

    public GastoproyectoPK getGastoproyectoPK() {
        return gastoproyectoPK;
    }

    public void setGastoproyectoPK(GastoproyectoPK gastoproyectoPK) {
        this.gastoproyectoPK = gastoproyectoPK;
    }

    public String getNomProyecto() {
        return nomProyecto;
    }

    public void setNomProyecto(String nomProyecto) {
        this.nomProyecto = nomProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gastoproyectoPK != null ? gastoproyectoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gastoproyecto)) {
            return false;
        }
        Gastoproyecto other = (Gastoproyecto) object;
        if ((this.gastoproyectoPK == null && other.gastoproyectoPK != null) || (this.gastoproyectoPK != null && !this.gastoproyectoPK.equals(other.gastoproyectoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Gastoproyecto[ gastoproyectoPK=" + gastoproyectoPK + " ]";
    }
    
}
