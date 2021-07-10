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
@Table(name = "detalle_pack")
@NamedQueries({
    @NamedQuery(name = "DetallePack.findAll", query = "SELECT d FROM DetallePack d"),
    @NamedQuery(name = "DetallePack.findByPckIdPack", query = "SELECT d FROM DetallePack d WHERE d.detallePackPK.pckIdPack = :pckIdPack"),
    @NamedQuery(name = "DetallePack.findByArtIdArticulo", query = "SELECT d FROM DetallePack d WHERE d.detallePackPK.artIdArticulo = :artIdArticulo"),
    @NamedQuery(name = "DetallePack.findByCantidad", query = "SELECT d FROM DetallePack d WHERE d.cantidad = :cantidad")})
public class DetallePack implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallePackPK detallePackPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private int cantidad;
    @JoinColumn(name = "ART_ID_ARTICULO", referencedColumnName = "ART_ID_ARTICULO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Articulo articulo;
    @JoinColumn(name = "PCK_ID_PACK", referencedColumnName = "PCK_ID_PACK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pack pack;

    public DetallePack() {
    }

    public DetallePack(DetallePackPK detallePackPK) {
        this.detallePackPK = detallePackPK;
    }

    public DetallePack(DetallePackPK detallePackPK, int cantidad) {
        this.detallePackPK = detallePackPK;
        this.cantidad = cantidad;
    }

    public DetallePack(int pckIdPack, int artIdArticulo) {
        this.detallePackPK = new DetallePackPK(pckIdPack, artIdArticulo);
    }

    public DetallePackPK getDetallePackPK() {
        return detallePackPK;
    }

    public void setDetallePackPK(DetallePackPK detallePackPK) {
        this.detallePackPK = detallePackPK;
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

    public Pack getPack() {
        return pack;
    }

    public void setPack(Pack pack) {
        this.pack = pack;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detallePackPK != null ? detallePackPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePack)) {
            return false;
        }
        DetallePack other = (DetallePack) object;
        if ((this.detallePackPK == null && other.detallePackPK != null) || (this.detallePackPK != null && !this.detallePackPK.equals(other.detallePackPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.DetallePack[ detallePackPK=" + detallePackPK + " ]";
    }

}
