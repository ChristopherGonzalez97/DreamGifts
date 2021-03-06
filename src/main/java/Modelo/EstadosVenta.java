/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author MADICAP
 */
@Entity
@Table(name = "estados_venta")
@NamedQueries({
    @NamedQuery(name = "EstadosVenta.findAll", query = "SELECT e FROM EstadosVenta e"),
    @NamedQuery(name = "EstadosVenta.findByIdEstado", query = "SELECT e FROM EstadosVenta e WHERE e.idEstado = :idEstado"),
    @NamedQuery(name = "EstadosVenta.findByEstDescripcion", query = "SELECT e FROM EstadosVenta e WHERE e.estDescripcion = :estDescripcion")})
public class EstadosVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ID_ESTADO")
    private String idEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "EST_DESCRIPCION")
    private String estDescripcion;

    public EstadosVenta() {
    }

    public EstadosVenta(String idEstado) {
        this.idEstado = idEstado;
    }

    public EstadosVenta(String idEstado, String estDescripcion) {
        this.idEstado = idEstado;
        this.estDescripcion = estDescripcion;
    }

    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstDescripcion() {
        return estDescripcion;
    }

    public void setEstDescripcion(String estDescripcion) {
        this.estDescripcion = estDescripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadosVenta)) {
            return false;
        }
        EstadosVenta other = (EstadosVenta) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.EstadosVenta[ idEstado=" + idEstado + " ]";
    }
    
}
