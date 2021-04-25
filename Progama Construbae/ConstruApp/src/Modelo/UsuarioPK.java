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
public class UsuarioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idUsuario")
    private int idUsuario;
    @Basic(optional = false)
    @Column(name = "Empresa_idEmpresa")
    private int empresaidEmpresa;

    public UsuarioPK() {
    }

    public UsuarioPK(int idUsuario, int empresaidEmpresa) {
        this.idUsuario = idUsuario;
        this.empresaidEmpresa = empresaidEmpresa;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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
        hash += (int) idUsuario;
        hash += (int) empresaidEmpresa;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioPK)) {
            return false;
        }
        UsuarioPK other = (UsuarioPK) object;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.empresaidEmpresa != other.empresaidEmpresa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.UsuarioPK[ idUsuario=" + idUsuario + ", empresaidEmpresa=" + empresaidEmpresa + " ]";
    }
    
}
