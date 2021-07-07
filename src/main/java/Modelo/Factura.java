/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    @Column(name = "FAC_ID_FACTURA")
    private String facIdFactura;
    @Basic(optional = false)
    @Column(name = "FAC_NUMERO")
    private int facNumero;
    @Basic(optional = false)
    @Column(name = "FAC_FECHA_FACTURA")
    @Temporal(TemporalType.DATE)
    private Date facFechaFactura;
    @JoinColumn(name = "PRO_ID_PROVEEDOR", referencedColumnName = "PRO_ID_PROVEEDOR")
    @ManyToOne(optional = false)
    private Proveedor proIdProveedor;

    public Factura() {
    }

    public Factura(String facIdFactura) {
        this.facIdFactura = facIdFactura;
    }

    public Factura(String facIdFactura, int facNumero, Date facFechaFactura) {
        this.facIdFactura = facIdFactura;
        this.facNumero = facNumero;
        this.facFechaFactura = facFechaFactura;
    }

    public String getFacIdFactura() {
        return facIdFactura;
    }

    public void setFacIdFactura(String facIdFactura) {
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
