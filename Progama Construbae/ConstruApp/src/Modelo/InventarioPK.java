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
public class InventarioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idInventario")
    private int idInventario;
    @Basic(optional = false)
    @Column(name = "Empresa_idEmpresa")
    private int empresaidEmpresa;
    @Basic(optional = false)
    @Column(name = "Gasto_idGasto")
    private int gastoidGasto;

    public InventarioPK() {
    }

    public InventarioPK(int idInventario, int empresaidEmpresa, int gastoidGasto) {
        this.idInventario = idInventario;
        this.empresaidEmpresa = empresaidEmpresa;
        this.gastoidGasto = gastoidGasto;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public int getEmpresaidEmpresa() {
        return empresaidEmpresa;
    }

    public void setEmpresaidEmpresa(int empresaidEmpresa) {
        this.empresaidEmpresa = empresaidEmpresa;
    }

    public int getGastoidGasto() {
        return gastoidGasto;
    }

    public void setGastoidGasto(int gastoidGasto) {
        this.gastoidGasto = gastoidGasto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idInventario;
        hash += (int) empresaidEmpresa;
        hash += (int) gastoidGasto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioPK)) {
            return false;
        }
        InventarioPK other = (InventarioPK) object;
        if (this.idInventario != other.idInventario) {
            return false;
        }
        if (this.empresaidEmpresa != other.empresaidEmpresa) {
            return false;
        }
        if (this.gastoidGasto != other.gastoidGasto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.InventarioPK[ idInventario=" + idInventario + ", empresaidEmpresa=" + empresaidEmpresa + ", gastoidGasto=" + gastoidGasto + " ]";
    }
    
}
