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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author MADICAP
 */
@Entity
@Table(name = "estado_venta")
@NamedQueries({
    @NamedQuery(name = "EstadoVenta.findAll", query = "SELECT e FROM EstadoVenta e"),
    @NamedQuery(name = "EstadoVenta.findByIdEstado", query = "SELECT e FROM EstadoVenta e WHERE e.idEstado = :idEstado"),
    @NamedQuery(name = "EstadoVenta.findByEstDescripcion", query = "SELECT e FROM EstadoVenta e WHERE e.estDescripcion = :estDescripcion")})
public class EstadoVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESTADO")
    private Integer idEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "EST_DESCRIPCION")
    private String estDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoVentaIdEstado")
    private List<Venta> ventaList;

    public EstadoVenta() {
    }

    public EstadoVenta(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public EstadoVenta(Integer idEstado, String estDescripcion) {
        this.idEstado = idEstado;
        this.estDescripcion = estDescripcion;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstDescripcion() {
        return estDescripcion;
    }

    public void setEstDescripcion(String estDescripcion) {
        this.estDescripcion = estDescripcion;
    }

    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
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
        if (!(object instanceof EstadoVenta)) {
            return false;
        }
        EstadoVenta other = (EstadoVenta) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.EstadoVenta[ idEstado=" + idEstado + " ]";
    }
    
}
