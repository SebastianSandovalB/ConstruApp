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
@Table(name = "proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p")
    , @NamedQuery(name = "Proyecto.findByIdProyecto", query = "SELECT p FROM Proyecto p WHERE p.proyectoPK.idProyecto = :idProyecto")
    , @NamedQuery(name = "Proyecto.findByDireccion", query = "SELECT p FROM Proyecto p WHERE p.direccion = :direccion")
    , @NamedQuery(name = "Proyecto.findByComuna", query = "SELECT p FROM Proyecto p WHERE p.comuna = :comuna")
    , @NamedQuery(name = "Proyecto.findByAdjudicado", query = "SELECT p FROM Proyecto p WHERE p.adjudicado = :adjudicado")
    , @NamedQuery(name = "Proyecto.findByEmpresaidEmpresa", query = "SELECT p FROM Proyecto p WHERE p.proyectoPK.empresaidEmpresa = :empresaidEmpresa")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProyectoPK proyectoPK;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "comuna")
    private String comuna;
    @Basic(optional = false)
    @Column(name = "adjudicado")
    private String adjudicado;
    @JoinColumn(name = "Empresa_idEmpresa", referencedColumnName = "idEmpresa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empresa empresa;

    public Proyecto() {
    }

    public Proyecto(ProyectoPK proyectoPK) {
        this.proyectoPK = proyectoPK;
    }

    public Proyecto(ProyectoPK proyectoPK, String direccion, String comuna, String adjudicado) {
        this.proyectoPK = proyectoPK;
        this.direccion = direccion;
        this.comuna = comuna;
        this.adjudicado = adjudicado;
    }

    public Proyecto(int idProyecto, int empresaidEmpresa) {
        this.proyectoPK = new ProyectoPK(idProyecto, empresaidEmpresa);
    }

    public ProyectoPK getProyectoPK() {
        return proyectoPK;
    }

    public void setProyectoPK(ProyectoPK proyectoPK) {
        this.proyectoPK = proyectoPK;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getAdjudicado() {
        return adjudicado;
    }

    public void setAdjudicado(String adjudicado) {
        this.adjudicado = adjudicado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyectoPK != null ? proyectoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.proyectoPK == null && other.proyectoPK != null) || (this.proyectoPK != null && !this.proyectoPK.equals(other.proyectoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Proyecto[ proyectoPK=" + proyectoPK + " ]";
    }
    
}
