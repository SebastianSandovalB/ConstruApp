/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Seba-PC
 */
@Embeddable
public class PersonalPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idPersonal")
    private int idPersonal;
    @Basic(optional = false)
    @Column(name = "Empresa_idEmpresa")
    private int empresaidEmpresa;

    public PersonalPK() {
    }

    public PersonalPK(int idPersonal, int empresaidEmpresa) {
        this.idPersonal = idPersonal;
        this.empresaidEmpresa = empresaidEmpresa;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public int getEmpresaidEmpresa() {
        return empresaidEmpresa;
    }

    public void setEmpresaidEmpresa(int empresaidEmpresa) {
        this.empresaidEmpresa = empresaidEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPersonal;
        hash += (int) empresaidEmpresa;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonalPK)) {
            return false;
        }
        PersonalPK other = (PersonalPK) object;
        if (this.idPersonal != other.idPersonal) {
            return false;
        }
        if (this.empresaidEmpresa != other.empresaidEmpresa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.PersonalPK[ idPersonal=" + idPersonal + ", empresaidEmpresa=" + empresaidEmpresa + " ]";
    }
    
}
