/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author MADICAP
 */
@Entity
@Table(name = "factura")
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByFacIdFactura", query = "SELECT f FROM Factura f WHERE f.facIdFactura = :facIdFactura"),
    @NamedQuery(name = "Factura.findByFacNumero", query = "SELECT f FROM Factura f WHERE f.facNumero = :facNumero"),
    @NamedQuery(name = "Factura.findByFacFechaFactura", query = "SELECT f FROM Factura f WHERE f.facFechaFactura = :facFechaFactura")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FAC_ID_FACTURA")
    private Integer facIdFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FAC_NUMERO")
    private int facNumero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FAC_FECHA_FACTURA")
    @Temporal(TemporalType.DATE)
    private Date facFechaFactura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
    private List<DetalleFactura> detalleFacturaList;
    @JoinColumn(name = "ESTADO_FACTURA_idESTADO_FACTURA", referencedColumnName = "idESTADO_FACTURA")
    @ManyToOne(optional = false)
    private EstadoFactura eSTADOFACTURAidESTADOFACTURA;
    @JoinColumn(name = "PRO_ID_PROVEEDOR", referencedColumnName = "PRO_ID_PROVEEDOR")
    @ManyToOne(optional = false)
    private Proveedor proIdProveedor;

    public Factura() {
    }

    public Factura(Integer facIdFactura) {
        this.facIdFactura = facIdFactura;
    }

    public Factura(Integer facIdFactura, int facNumero, Date facFechaFactura) {
        this.facIdFactura = facIdFactura;
        this.facNumero = facNumero;
        this.facFechaFactura = facFechaFactura;
    }

    public Integer getFacIdFactura() {
        return facIdFactura;
    }

    public void setFacIdFactura(Integer facIdFactura) {
        this.facIdFactura = facIdFactura;
    }

    public int getFacNumero() {
        return facNumero;
    }

    public void setFacNumero(int facNumero) {
        this.facNumero = facNumero;
    }

    public Date getFacFechaFactura() {
        return facFechaFactura;
    }

    public void setFacFechaFactura(Date facFechaFactura) {
        this.facFechaFactura = facFechaFactura;
    }

    public List<DetalleFactura> getDetalleFacturaList() {
        return detalleFacturaList;
    }

    public void setDetalleFacturaList(List<DetalleFactura> detalleFacturaList) {
        this.detalleFacturaList = detalleFacturaList;
    }

    public EstadoFactura getESTADOFACTURAidESTADOFACTURA() {
        return eSTADOFACTURAidESTADOFACTURA;
    }

    public void setESTADOFACTURAidESTADOFACTURA(EstadoFactura eSTADOFACTURAidESTADOFACTURA) {
        this.eSTADOFACTURAidESTADOFACTURA = eSTADOFACTURAidESTADOFACTURA;
    }

    public Proveedor getProIdProveedor() {
        return proIdProveedor;
    }

    public void setProIdProveedor(Proveedor proIdProveedor) {
        this.proIdProveedor = proIdProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facIdFactura != null ? facIdFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.facIdFactura == null && other.facIdFactura != null) || (this.facIdFactura != null && !this.facIdFactura.equals(other.facIdFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Factura[ facIdFactura=" + facIdFactura + " ]";
    }
    
}
