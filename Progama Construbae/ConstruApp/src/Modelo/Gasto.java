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
@Table(name = "gasto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gasto.findAll", query = "SELECT g FROM Gasto g")
    , @NamedQuery(name = "Gasto.findByIdGasto", query = "SELECT g FROM Gasto g WHERE g.gastoPK.idGasto = :idGasto")
    , @NamedQuery(name = "Gasto.findByNombre", query = "SELECT g FROM Gasto g WHERE g.nombre = :nombre")
    , @NamedQuery(name = "Gasto.findByDescripcion", query = "SELECT g FROM Gasto g WHERE g.descripcion = :descripcion")
    , @NamedQuery(name = "Gasto.findByPrecio", query = "SELECT g FROM Gasto g WHERE g.precio = :precio")
    , @NamedQuery(name = "Gasto.findByCantidad", query = "SELECT g FROM Gasto g WHERE g.cantidad = :cantidad")
    , @NamedQuery(name = "Gasto.findByTotal", query = "SELECT g FROM Gasto g WHERE g.total = :total")
    , @NamedQuery(name = "Gasto.findByFecha", query = "SELECT g FROM Gasto g WHERE g.fecha = :fecha")
    , @NamedQuery(name = "Gasto.findByEmpresaidEmpresa", query = "SELECT g FROM Gasto g WHERE g.gastoPK.empresaidEmpresa = :empresaidEmpresa")})
public class Gasto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GastoPK gastoPK;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "precio")
    private int precio;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "total")
    private int total;
    @Basic(optional = false)
    @Column(name = "fecha")
    private String fecha;
    @JoinColumn(name = "Empresa_idEmpresa", referencedColumnName = "idEmpresa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empresa empresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gasto")
    private List<Inventario> inventarioList;

    public Gasto() {
    }

    public Gasto(GastoPK gastoPK) {
        this.gastoPK = gastoPK;
    }

    public Gasto(GastoPK gastoPK, String nombre, String descripcion, int precio, int cantidad, int total, String fecha) {
        this.gastoPK = gastoPK;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.total = total;
        this.fecha = fecha;
    }

    public Gasto(int idGasto, int empresaidEmpresa) {
        this.gastoPK = new GastoPK(idGasto, empresaidEmpresa);
    }

    public GastoPK getGastoPK() {
        return gastoPK;
    }

    public void setGastoPK(GastoPK gastoPK) {
        this.gastoPK = gastoPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @XmlTransient
    public List<Inventario> getInventarioList() {
        return inventarioList;
    }

    public void setInventarioList(List<Inventario> inventarioList) {
        this.inventarioList = inventarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gastoPK != null ? gastoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gasto)) {
            return false;
        }
        Gasto other = (Gasto) object;
        if ((this.gastoPK == null && other.gastoPK != null) || (this.gastoPK != null && !this.gastoPK.equals(other.gastoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Gasto[ gastoPK=" + gastoPK + " ]";
    }
    
}
