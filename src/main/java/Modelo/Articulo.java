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
import javax.validation.constraints.Size;

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
    @NamedQuery(name = "Articulo.findByArtMarca", query = "SELECT a FROM Articulo a WHERE a.artMarca = :artMarca"),
    @NamedQuery(name = "Articulo.findByArtInhabilitado", query = "SELECT a FROM Articulo a WHERE a.artInhabilitado = :artInhabilitado"),
    @NamedQuery(name = "Articulo.buscador", query = "SELECT a FROM Articulo a WHERE a.artDescripcion LIKE :buscar"),
    @NamedQuery(name = "Articulo.findByArtPrecio", query = "SELECT a FROM Articulo a WHERE a.artPrecio = :artPrecio")})
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ART_ID_ARTICULO")
    private Integer artIdArticulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ART_DESCRIPCION")
    private String artDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ART_STOCK")
    private int artStock;
    @Column(name = "ART_FECHA_VENCIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date artFechaVencimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ART_MARCA")
    private String artMarca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ART_INHABILITADO")
    private short artInhabilitado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ART_PRECIO")
    private int artPrecio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articulo")
    private List<DetalleFactura> detalleFacturaList;
    @JoinColumn(name = "CATEGORIA_ARTICULO_CATEGORIA_ARTICULO", referencedColumnName = "CATEGORIA_ARTICULO")
    @ManyToOne(optional = false)
    private CategoriaArticulo categoriaArticuloCategoriaArticulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articulo")
    private List<DetallePack> detallePackList;

    public Articulo() {
    }

    public Articulo(Integer artIdArticulo) {
        this.artIdArticulo = artIdArticulo;
    }

    public Articulo(Integer artIdArticulo, String artDescripcion, int artStock, String artMarca, short artInhabilitado, int artPrecio) {
        this.artIdArticulo = artIdArticulo;
        this.artDescripcion = artDescripcion;
        this.artStock = artStock;
        this.artMarca = artMarca;
        this.artInhabilitado = artInhabilitado;
        this.artPrecio = artPrecio;
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
      public String Habilitado()
    {
        boolean myBoolean = false;
        if(getArtInhabilitado()==Short.valueOf("0"))
        {
            myBoolean=true;
        }
        String result = myBoolean ? "Si" : "No";
        return result;
    }

    public Date getArtFechaVencimiento() {
        return artFechaVencimiento;
    }

    public void setArtFechaVencimiento(Date artFechaVencimiento) {
        this.artFechaVencimiento = artFechaVencimiento;
    }

    public String getArtMarca() {
        return artMarca;
    }

    public void setArtMarca(String artMarca) {
        this.artMarca = artMarca;
    }

    public short getArtInhabilitado() {
        return artInhabilitado;
    }

    public void setArtInhabilitado(short artInhabilitado) {
        this.artInhabilitado = artInhabilitado;
    }

    public int getArtPrecio() {
        return artPrecio;
    }

    public void setArtPrecio(int artPrecio) {
        this.artPrecio = artPrecio;
    }

    public List<DetalleFactura> getDetalleFacturaList() {
        return detalleFacturaList;
    }

    public void setDetalleFacturaList(List<DetalleFactura> detalleFacturaList) {
        this.detalleFacturaList = detalleFacturaList;
    }

    public CategoriaArticulo getCategoriaArticuloCategoriaArticulo() {
        return categoriaArticuloCategoriaArticulo;
    }

    public void setCategoriaArticuloCategoriaArticulo(CategoriaArticulo categoriaArticuloCategoriaArticulo) {
        this.categoriaArticuloCategoriaArticulo = categoriaArticuloCategoriaArticulo;
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
