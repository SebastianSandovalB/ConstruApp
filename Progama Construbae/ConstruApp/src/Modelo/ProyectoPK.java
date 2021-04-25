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
public class ProyectoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idProyecto")
    private int idProyecto;
    @Basic(optional = false)
    @Column(name = "Empresa_idEmpresa")
    private int empresaidEmpresa;

    public ProyectoPK() {
    }

    public ProyectoPK(int idProyecto, int empresaidEmpresa) {
        this.idProyecto = idProyecto;
        this.empresaidEmpresa = empresaidEmpresa;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
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
        hash += (int) idProyecto;
        hash += (int) empresaidEmpresa;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectoPK)) {
            return false;
        }
        ProyectoPK other = (ProyectoPK) object;
        if (this.idProyecto != other.idProyecto) {
            return false;
        }
        if (this.empresaidEmpresa != other.empresaidEmpresa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.ProyectoPK[ idProyecto=" + idProyecto + ", empresaidEmpresa=" + empresaidEmpresa + " ]";
    }
    
}
