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
public class DetalleFacturaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "FACTURA_FAC_ID_FACTURA")
    private int facturaFacIdFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ARTICULO_ART_ID_ARTICULO")
    private int articuloArtIdArticulo;

    public DetalleFacturaPK() {
    }

    public DetalleFacturaPK(int facturaFacIdFactura, int articuloArtIdArticulo) {
        this.facturaFacIdFactura = facturaFacIdFactura;
        this.articuloArtIdArticulo = articuloArtIdArticulo;
    }

    public int getFacturaFacIdFactura() {
        return facturaFacIdFactura;
    }

    public void setFacturaFacIdFactura(int facturaFacIdFactura) {
        this.facturaFacIdFactura = facturaFacIdFactura;
    }

    public int getArticuloArtIdArticulo() {
        return articuloArtIdArticulo;
    }

    public void setArticuloArtIdArticulo(int articuloArtIdArticulo) {
        this.articuloArtIdArticulo = articuloArtIdArticulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) facturaFacIdFactura;
        hash += (int) articuloArtIdArticulo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFacturaPK)) {
            return false;
        }
        DetalleFacturaPK other = (DetalleFacturaPK) object;
        if (this.facturaFacIdFactura != other.facturaFacIdFactura) {
            return false;
        }
        if (this.articuloArtIdArticulo != other.articuloArtIdArticulo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.DetalleFacturaPK[ facturaFacIdFactura=" + facturaFacIdFactura + ", articuloArtIdArticulo=" + articuloArtIdArticulo + " ]";
    }
    
}
