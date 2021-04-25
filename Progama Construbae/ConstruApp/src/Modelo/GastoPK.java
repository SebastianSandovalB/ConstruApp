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
public class GastoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idGasto")
    private int idGasto;
    @Basic(optional = false)
    @Column(name = "Empresa_idEmpresa")
    private int empresaidEmpresa;

    public GastoPK() {
    }

    public GastoPK(int idGasto, int empresaidEmpresa) {
        this.idGasto = idGasto;
        this.empresaidEmpresa = empresaidEmpresa;
    }

    public int getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(int idGasto) {
        this.idGasto = idGasto;
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
        hash += (int) idGasto;
        hash += (int) empresaidEmpresa;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GastoPK)) {
            return false;
        }
        GastoPK other = (GastoPK) object;
        if (this.idGasto != other.idGasto) {
            return false;
        }
        if (this.empresaidEmpresa != other.empresaidEmpresa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.GastoPK[ idGasto=" + idGasto + ", empresaidEmpresa=" + empresaidEmpresa + " ]";
    }
    
}
