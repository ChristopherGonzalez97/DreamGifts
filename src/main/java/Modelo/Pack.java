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
@Table(name = "pack")
@NamedQueries({
    @NamedQuery(name = "Pack.findAll", query = "SELECT p FROM Pack p"),
    @NamedQuery(name = "Pack.findByPckIdPack", query = "SELECT p FROM Pack p WHERE p.pckIdPack = :pckIdPack"),
    @NamedQuery(name = "Pack.findByPckNombre", query = "SELECT p FROM Pack p WHERE p.pckNombre = :pckNombre"),
    @NamedQuery(name = "Pack.findByPckCosto", query = "SELECT p FROM Pack p WHERE p.pckCosto = :pckCosto"),
    @NamedQuery(name = "Pack.findByCatIdCategoria", query = "SELECT p FROM Pack p WHERE p.catIdCategoria = :catIdCategoria"),
    @NamedQuery(name = "Pack.findByPckStock", query = "SELECT p FROM Pack p WHERE p.pckStock = :pckStock")})
public class Pack implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PCK_ID_PACK")
    private Integer pckIdPack;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PCK_NOMBRE")
    private String pckNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PCK_COSTO")
    private String pckCosto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAT_ID_CATEGORIA")
    private int catIdCategoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PCK_STOCK")
    private int pckStock;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pckIdPack")
    private List<Venta> ventaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pack")
    private List<DetallePack> detallePackList;

    public Pack() {
    }

    public Pack(Integer pckIdPack) {
        this.pckIdPack = pckIdPack;
    }

    public Pack(Integer pckIdPack, String pckNombre, String pckCosto, int catIdCategoria, int pckStock) {
        this.pckIdPack = pckIdPack;
        this.pckNombre = pckNombre;
        this.pckCosto = pckCosto;
        this.catIdCategoria = catIdCategoria;
        this.pckStock = pckStock;
    }

    public Integer getPckIdPack() {
        return pckIdPack;
    }

    public void setPckIdPack(Integer pckIdPack) {
        this.pckIdPack = pckIdPack;
    }

    public String getPckNombre() {
        return pckNombre;
    }

    public void setPckNombre(String pckNombre) {
        this.pckNombre = pckNombre;
    }

    public String getPckCosto() {
        return pckCosto;
    }

    public void setPckCosto(String pckCosto) {
        this.pckCosto = pckCosto;
    }

    public int getCatIdCategoria() {
        return catIdCategoria;
    }

    public void setCatIdCategoria(int catIdCategoria) {
        this.catIdCategoria = catIdCategoria;
    }

    public int getPckStock() {
        return pckStock;
    }

    public void setPckStock(int pckStock) {
        this.pckStock = pckStock;
    }

    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    public List<DetallePack> getDetallePackList() {
        return detallePackList;
    }

    public void setDetallePackList(List<DetallePack> detallePackList) {
        this.detallePackList = detallePackList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pckIdPack != null ? pckIdPack.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pack)) {
            return false;
        }
        Pack other = (Pack) object;
        if ((this.pckIdPack == null && other.pckIdPack != null) || (this.pckIdPack != null && !this.pckIdPack.equals(other.pckIdPack))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Pack[ pckIdPack=" + pckIdPack + " ]";
    }
    
}
