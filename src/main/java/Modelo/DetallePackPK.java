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
import javax.validation.constraints.NotNull;

/**
 *
 * @author MADICAP
 */
@Embeddable
public class DetallePackPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "PCK_ID_PACK")
    private int pckIdPack;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ART_ID_ARTICULO")
    private int artIdArticulo;

    public DetallePackPK() {
    }

    public DetallePackPK(int pckIdPack, int artIdArticulo) {
        this.pckIdPack = pckIdPack;
        this.artIdArticulo = artIdArticulo;
    }

    public int getPckIdPack() {
        return pckIdPack;
    }

    public void setPckIdPack(int pckIdPack) {
        this.pckIdPack = pckIdPack;
    }

    public int getArtIdArticulo() {
        return artIdArticulo;
    }

    public void setArtIdArticulo(int artIdArticulo) {
        this.artIdArticulo = artIdArticulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pckIdPack;
        hash += (int) artIdArticulo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePackPK)) {
            return false;
        }
        DetallePackPK other = (DetallePackPK) object;
        if (this.pckIdPack != other.pckIdPack) {
            return false;
        }
        if (this.artIdArticulo != other.artIdArticulo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.DetallePackPK[ pckIdPack=" + pckIdPack + ", artIdArticulo=" + artIdArticulo + " ]";
    }
    
}
