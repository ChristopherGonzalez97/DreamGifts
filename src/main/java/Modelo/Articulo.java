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
@Table(name = "articulo")
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a"),
    @NamedQuery(name = "Articulo.findByArtIdArticulo", query = "SELECT a FROM Articulo a WHERE a.artIdArticulo = :artIdArticulo"),
    @NamedQuery(name = "Articulo.findByArtDescripcion", query = "SELECT a FROM Articulo a WHERE a.artDescripcion = :artDescripcion"),
    @NamedQuery(name = "Articulo.findByArtStock", query = "SELECT a FROM Articulo a WHERE a.artStock = :artStock"),
    @NamedQuery(name = "Articulo.findByArtFechaVencimiento", query = "SELECT a FROM Articulo a WHERE a.artFechaVencimiento = :artFechaVencimiento"),
    @NamedQuery(name = "Articulo.findByCategoriaArticuloCatIdCategoria", query = "SELECT a FROM Articulo a WHERE a.categoriaArticuloCatIdCategoria = :categoriaArticuloCatIdCategoria")})
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ART_ID_ARTICULO")
    private Integer artIdArticulo;
    @Basic(optional = false)
    @Column(name = "ART_DESCRIPCION")
    private String artDescripcion;
    @Basic(optional = false)
    @Column(name = "ART_STOCK")
    private int artStock;
    @Basic(optional = false)
    @Column(name = "ART_FECHA_VENCIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date artFechaVencimiento;
    @Basic(optional = false)
    @Column(name = "CATEGORIA_ARTICULO_CAT_ID_CATEGORIA")
    private String categoriaArticuloCatIdCategoria;

    public Articulo() {
    }

    public Articulo(Integer artIdArticulo) {
        this.artIdArticulo = artIdArticulo;
    }

    public Articulo(Integer artIdArticulo, String artDescripcion, int artStock, Date artFechaVencimiento, String categoriaArticuloCatIdCategoria) {
        this.artIdArticulo = artIdArticulo;
        this.artDescripcion = artDescripcion;
        this.artStock = artStock;
        this.artFechaVencimiento = artFechaVencimiento;
        this.categoriaArticuloCatIdCategoria = categoriaArticuloCatIdCategoria;
    }

    public Integer getArtIdArticulo() {
        return artIdArticulo;
    }

    public void setArtIdArticulo(Integer artIdArticulo) {
        this.artIdArticulo = artIdArticulo;
    }

    public String getArtDescripcion() {
        return artDescripcion;
    }

    public void setArtDescripcion(String artDescripcion) {
        this.artDescripcion = artDescripcion;
    }

    public int getArtStock() {
        return artStock;
    }

    public void setArtStock(int artStock) {
        this.artStock = artStock;
    }

    public Date getArtFechaVencimiento() {
        return artFechaVencimiento;
    }

    public void setArtFechaVencimiento(Date artFechaVencimiento) {
        this.artFechaVencimiento = artFechaVencimiento;
    }

    public String getCategoriaArticuloCatIdCategoria() {
        return categoriaArticuloCatIdCategoria;
    }

    public void setCategoriaArticuloCatIdCategoria(String categoriaArticuloCatIdCategoria) {
        this.categoriaArticuloCatIdCategoria = categoriaArticuloCatIdCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artIdArticulo != null ? artIdArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.artIdArticulo == null && other.artIdArticulo != null) || (this.artIdArticulo != null && !this.artIdArticulo.equals(other.artIdArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Articulo[ artIdArticulo=" + artIdArticulo + " ]";
    }
    
}
