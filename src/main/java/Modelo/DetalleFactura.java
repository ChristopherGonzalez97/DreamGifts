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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author MADICAP
 */
@Entity
@Table(name = "detalle_factura")
@NamedQueries({
    @NamedQuery(name = "DetalleFactura.findAll", query = "SELECT d FROM DetalleFactura d"),
    @NamedQuery(name = "DetalleFactura.findByFacturaFacIdFactura", query = "SELECT d FROM DetalleFactura d WHERE d.detalleFacturaPK.facturaFacIdFactura = :facturaFacIdFactura"),
    @NamedQuery(name = "DetalleFactura.findByArticuloArtIdArticulo", query = "SELECT d FROM DetalleFactura d WHERE d.detalleFacturaPK.articuloArtIdArticulo = :articuloArtIdArticulo"),
    @NamedQuery(name = "DetalleFactura.findByCantidad", query = "SELECT d FROM DetalleFactura d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleFactura.findByValor", query = "SELECT d FROM DetalleFactura d WHERE d.valor = :valor"),
    @NamedQuery(name = "DetalleFactura.findByDetFechaVencimiento", query = "SELECT d FROM DetalleFactura d WHERE d.detFechaVencimiento = :detFechaVencimiento")})
public class DetalleFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleFacturaPK detalleFacturaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR")
    private int valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DET_FECHA_VENCIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date detFechaVencimiento;
    @JoinColumn(name = "ARTICULO_ART_ID_ARTICULO", referencedColumnName = "ART_ID_ARTICULO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Articulo articulo;
    @JoinColumn(name = "FACTURA_FAC_ID_FACTURA", referencedColumnName = "FAC_ID_FACTURA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Factura factura;

    public DetalleFactura() {
    }

    public DetalleFactura(DetalleFacturaPK detalleFacturaPK) {
        this.detalleFacturaPK = detalleFacturaPK;
    }

    public DetalleFactura(DetalleFacturaPK detalleFacturaPK, int cantidad, int valor, Date detFechaVencimiento) {
        this.detalleFacturaPK = detalleFacturaPK;
        this.cantidad = cantidad;
        this.valor = valor;
        this.detFechaVencimiento = detFechaVencimiento;
    }

    public DetalleFactura(int facturaFacIdFactura, int articuloArtIdArticulo) {
        this.detalleFacturaPK = new DetalleFacturaPK(facturaFacIdFactura, articuloArtIdArticulo);
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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Date getDetFechaVencimiento() {
        return detFechaVencimiento;
    }

    public void setDetFechaVencimiento(Date detFechaVencimiento) {
        this.detFechaVencimiento = detFechaVencimiento;
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
