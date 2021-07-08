/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author MADICAP
 */
@Entity
@Table(name = "detalle_factura")
@NamedQueries({
    @NamedQuery(name = "DetalleFactura.findAll", query = "SELECT d FROM DetalleFactura d"),
    @NamedQuery(name = "DetalleFactura.findByFacturaFACIDFACTURA", query = "SELECT d FROM DetalleFactura d WHERE d.detalleFacturaPK.facturaFACIDFACTURA = :facturaFACIDFACTURA"),
    @NamedQuery(name = "DetalleFactura.findByArticuloArtIdArticulo", query = "SELECT d FROM DetalleFactura d WHERE d.detalleFacturaPK.articuloArtIdArticulo = :articuloArtIdArticulo"),
    @NamedQuery(name = "DetalleFactura.findByCantidad", query = "SELECT d FROM DetalleFactura d WHERE d.cantidad = :cantidad")})
public class DetalleFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleFacturaPK detalleFacturaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private int cantidad;
    @JoinColumn(name = "ARTICULO_ART_ID_ARTICULO", referencedColumnName = "ART_ID_ARTICULO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Articulo articulo;
    @JoinColumn(name = "Factura_FAC_ID_FACTURA", referencedColumnName = "FAC_ID_FACTURA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Factura factura;

    public DetalleFactura() {
    }

    public DetalleFactura(DetalleFacturaPK detalleFacturaPK) {
        this.detalleFacturaPK = detalleFacturaPK;
    }

    public DetalleFactura(DetalleFacturaPK detalleFacturaPK, int cantidad) {
        this.detalleFacturaPK = detalleFacturaPK;
        this.cantidad = cantidad;
    }

    public DetalleFactura(int facturaFACIDFACTURA, int articuloArtIdArticulo) {
        this.detalleFacturaPK = new DetalleFacturaPK(facturaFACIDFACTURA, articuloArtIdArticulo);
    }

    public DetalleFacturaPK getDetalleFacturaPK() {
        return detalleFacturaPK;
    }

    public void setDetalleFacturaPK(DetalleFacturaPK detalleFacturaPK) {
        this.detalleFacturaPK = detalleFacturaPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleFacturaPK != null ? detalleFacturaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFactura)) {
            return false;
        }
        DetalleFactura other = (DetalleFactura) object;
        if ((this.detalleFacturaPK == null && other.detalleFacturaPK != null) || (this.detalleFacturaPK != null && !this.detalleFacturaPK.equals(other.detalleFacturaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.DetalleFactura[ detalleFacturaPK=" + detalleFacturaPK + " ]";
    }
    
}
