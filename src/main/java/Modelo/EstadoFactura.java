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
@Table(name = "estado_factura")
@NamedQueries({
    @NamedQuery(name = "EstadoFactura.findAll", query = "SELECT e FROM EstadoFactura e"),
    @NamedQuery(name = "EstadoFactura.findByIdESTADOFACTURA", query = "SELECT e FROM EstadoFactura e WHERE e.idESTADOFACTURA = :idESTADOFACTURA"),
    @NamedQuery(name = "EstadoFactura.findByNombreEstado", query = "SELECT e FROM EstadoFactura e WHERE e.nombreEstado = :nombreEstado")})
public class EstadoFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idESTADO_FACTURA")
    private Integer idESTADOFACTURA;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE_ESTADO")
    private String nombreEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eSTADOFACTURAidESTADOFACTURA")
    private List<Factura> facturaList;

    public EstadoFactura() {
    }

    public EstadoFactura(Integer idESTADOFACTURA) {
        this.idESTADOFACTURA = idESTADOFACTURA;
    }

    public EstadoFactura(Integer idESTADOFACTURA, String nombreEstado) {
        this.idESTADOFACTURA = idESTADOFACTURA;
        this.nombreEstado = nombreEstado;
    }

    public Integer getIdESTADOFACTURA() {
        return idESTADOFACTURA;
    }

    public void setIdESTADOFACTURA(Integer idESTADOFACTURA) {
        this.idESTADOFACTURA = idESTADOFACTURA;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idESTADOFACTURA != null ? idESTADOFACTURA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoFactura)) {
            return false;
        }
        EstadoFactura other = (EstadoFactura) object;
        if ((this.idESTADOFACTURA == null && other.idESTADOFACTURA != null) || (this.idESTADOFACTURA != null && !this.idESTADOFACTURA.equals(other.idESTADOFACTURA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.EstadoFactura[ idESTADOFACTURA=" + idESTADOFACTURA + " ]";
    }
    
}
