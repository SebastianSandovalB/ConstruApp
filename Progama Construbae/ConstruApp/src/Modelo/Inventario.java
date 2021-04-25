/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Seba-PC
 */
@Entity
@Table(name = "inventario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i")
    , @NamedQuery(name = "Inventario.findByIdInventario", query = "SELECT i FROM Inventario i WHERE i.inventarioPK.idInventario = :idInventario")
    , @NamedQuery(name = "Inventario.findByNombre", query = "SELECT i FROM Inventario i WHERE i.nombre = :nombre")
    , @NamedQuery(name = "Inventario.findByCaracteristica", query = "SELECT i FROM Inventario i WHERE i.caracteristica = :caracteristica")
    , @NamedQuery(name = "Inventario.findByCantidad", query = "SELECT i FROM Inventario i WHERE i.cantidad = :cantidad")
    , @NamedQuery(name = "Inventario.findByEmpresaidEmpresa", query = "SELECT i FROM Inventario i WHERE i.inventarioPK.empresaidEmpresa = :empresaidEmpresa")
    , @NamedQuery(name = "Inventario.findByGastoidGasto", query = "SELECT i FROM Inventario i WHERE i.inventarioPK.gastoidGasto = :gastoidGasto")})
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InventarioPK inventarioPK;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "caracteristica")
    private String caracteristica;
    @Basic(optional = false)
    @Column(name = "Cantidad")
    private int cantidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventario")
    private List<Gastoproyecto> gastoproyectoList;
    @JoinColumn(name = "Empresa_idEmpresa", referencedColumnName = "idEmpresa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empresa empresa;
    @JoinColumn(name = "Gasto_idGasto", referencedColumnName = "idGasto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Gasto gasto;

    public Inventario() {
    }

    public Inventario(InventarioPK inventarioPK) {
        this.inventarioPK = inventarioPK;
    }

    public Inventario(InventarioPK inventarioPK, String nombre, String caracteristica, int cantidad) {
        this.inventarioPK = inventarioPK;
        this.nombre = nombre;
        this.caracteristica = caracteristica;
        this.cantidad = cantidad;
    }

    public Inventario(int idInventario, int empresaidEmpresa, int gastoidGasto) {
        this.inventarioPK = new InventarioPK(idInventario, empresaidEmpresa, gastoidGasto);
    }

    public InventarioPK getInventarioPK() {
        return inventarioPK;
    }

    public void setInventarioPK(InventarioPK inventarioPK) {
        this.inventarioPK = inventarioPK;
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

    @XmlTransient
    public List<Gastoproyecto> getGastoproyectoList() {
        return gastoproyectoList;
    }

    public void setGastoproyectoList(List<Gastoproyecto> gastoproyectoList) {
        this.gastoproyectoList = gastoproyectoList;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Gasto getGasto() {
        return gasto;
    }

    public void setGasto(Gasto gasto) {
        this.gasto = gasto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inventarioPK != null ? inventarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.inventarioPK == null && other.inventarioPK != null) || (this.inventarioPK != null && !this.inventarioPK.equals(other.inventarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Inventario[ inventarioPK=" + inventarioPK + " ]";
    }
    
}
