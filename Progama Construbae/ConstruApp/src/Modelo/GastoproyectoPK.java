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
public class GastoproyectoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idGastoProyecto")
    private int idGastoProyecto;
    @Basic(optional = false)
    @Column(name = "Inventario_idInventario")
    private int inventarioidInventario;
    @Basic(optional = false)
    @Column(name = "Inventario_Empresa_idEmpresa")
    private int inventarioEmpresaidEmpresa;
    @Basic(optional = false)
    @Column(name = "Inventario_Gasto_idGasto")
    private int inventarioGastoidGasto;

    public GastoproyectoPK() {
    }

    public GastoproyectoPK(int idGastoProyecto, int inventarioidInventario, int inventarioEmpresaidEmpresa, int inventarioGastoidGasto) {
        this.idGastoProyecto = idGastoProyecto;
        this.inventarioidInventario = inventarioidInventario;
        this.inventarioEmpresaidEmpresa = inventarioEmpresaidEmpresa;
        this.inventarioGastoidGasto = inventarioGastoidGasto;
    }

    public int getIdGastoProyecto() {
        return idGastoProyecto;
    }

    public void setIdGastoProyecto(int idGastoProyecto) {
        this.idGastoProyecto = idGastoProyecto;
    }

    public int getInventarioidInventario() {
        return inventarioidInventario;
    }

    public void setInventarioidInventario(int inventarioidInventario) {
        this.inventarioidInventario = inventarioidInventario;
    }

    public int getInventarioEmpresaidEmpresa() {
        return inventarioEmpresaidEmpresa;
    }

    public void setInventarioEmpresaidEmpresa(int inventarioEmpresaidEmpresa) {
        this.inventarioEmpresaidEmpresa = inventarioEmpresaidEmpresa;
    }

    public int getInventarioGastoidGasto() {
        return inventarioGastoidGasto;
    }

    public void setInventarioGastoidGasto(int inventarioGastoidGasto) {
        this.inventarioGastoidGasto = inventarioGastoidGasto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idGastoProyecto;
        hash += (int) inventarioidInventario;
        hash += (int) inventarioEmpresaidEmpresa;
        hash += (int) inventarioGastoidGasto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GastoproyectoPK)) {
            return false;
        }
        GastoproyectoPK other = (GastoproyectoPK) object;
        if (this.idGastoProyecto != other.idGastoProyecto) {
            return false;
        }
        if (this.inventarioidInventario != other.inventarioidInventario) {
            return false;
        }
        if (this.inventarioEmpresaidEmpresa != other.inventarioEmpresaidEmpresa) {
            return false;
        }
        if (this.inventarioGastoidGasto != other.inventarioGastoidGasto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.GastoproyectoPK[ idGastoProyecto=" + idGastoProyecto + ", inventarioidInventario=" + inventarioidInventario + ", inventarioEmpresaidEmpresa=" + inventarioEmpresaidEmpresa + ", inventarioGastoidGasto=" + inventarioGastoidGasto + " ]";
    }
    
}
