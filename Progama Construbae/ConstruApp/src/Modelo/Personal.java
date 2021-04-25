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
@Table(name = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personal.findAll", query = "SELECT p FROM Personal p")
    , @NamedQuery(name = "Personal.findByIdPersonal", query = "SELECT p FROM Personal p WHERE p.personalPK.idPersonal = :idPersonal")
    , @NamedQuery(name = "Personal.findByNombre", query = "SELECT p FROM Personal p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Personal.findByCargo", query = "SELECT p FROM Personal p WHERE p.cargo = :cargo")
    , @NamedQuery(name = "Personal.findBySueldo", query = "SELECT p FROM Personal p WHERE p.sueldo = :sueldo")
    , @NamedQuery(name = "Personal.findByEmpresaidEmpresa", query = "SELECT p FROM Personal p WHERE p.personalPK.empresaidEmpresa = :empresaidEmpresa")})
public class Personal implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonalPK personalPK;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "cargo")
    private String cargo;
    @Column(name = "sueldo")
    private Integer sueldo;
    @JoinColumn(name = "Empresa_idEmpresa", referencedColumnName = "idEmpresa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empresa empresa;

    public Personal() {
    }

    public Personal(PersonalPK personalPK) {
        this.personalPK = personalPK;
    }

    public Personal(PersonalPK personalPK, String nombre, String cargo) {
        this.personalPK = personalPK;
        this.nombre = nombre;
        this.cargo = cargo;
    }
    public Personal(String nom, String cargo, int sueldo){
        this.nombre=nom;
        this.cargo=cargo;
        this.sueldo=sueldo;
        
    }

    public Personal(int idPersonal, int empresaidEmpresa) {
        this.personalPK = new PersonalPK(idPersonal, empresaidEmpresa);
    }

    public PersonalPK getPersonalPK() {
        return personalPK;
    }

    public void setPersonalPK(PersonalPK personalPK) {
        this.personalPK = personalPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getSueldo() {
        return sueldo;
    }

    public void setSueldo(Integer sueldo) {
        this.sueldo = sueldo;
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
        hash += (personalPK != null ? personalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personal)) {
            return false;
        }
        Personal other = (Personal) object;
        if ((this.personalPK == null && other.personalPK != null) || (this.personalPK != null && !this.personalPK.equals(other.personalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Personal[ personalPK=" + personalPK + " ]";
    }
    
}
