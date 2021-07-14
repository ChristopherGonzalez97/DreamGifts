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
@Table(name = "categoria_articulo")
@NamedQueries({
    @NamedQuery(name = "CategoriaArticulo.findAll", query = "SELECT c FROM CategoriaArticulo c"),
    @NamedQuery(name = "CategoriaArticulo.findByCategoriaArticulo", query = "SELECT c FROM CategoriaArticulo c WHERE c.categoriaArticulo = :categoriaArticulo"),
    @NamedQuery(name = "CategoriaArticulo.findByCatNombre", query = "SELECT c FROM CategoriaArticulo c WHERE c.catNombre = :catNombre"),
    @NamedQuery(name = "CategoriaArticulo.buscador", query = "SELECT c FROM CategoriaArticulo c WHERE c.catNombre LIKE :buscar")})
public class CategoriaArticulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CATEGORIA_ARTICULO")
    private Integer categoriaArticulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CAT_NOMBRE")
    private String catNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaArticuloCategoriaArticulo")
    private List<Articulo> articuloList;

    public CategoriaArticulo() {
    }

    public CategoriaArticulo(Integer categoriaArticulo) {
        this.categoriaArticulo = categoriaArticulo;
    }

    public CategoriaArticulo(Integer categoriaArticulo, String catNombre) {
        this.categoriaArticulo = categoriaArticulo;
        this.catNombre = catNombre;
    }

    public Integer getCategoriaArticulo() {
        return categoriaArticulo;
    }

    public void setCategoriaArticulo(Integer categoriaArticulo) {
        this.categoriaArticulo = categoriaArticulo;
    }

    public String getCatNombre() {
        return catNombre;
    }

    public void setCatNombre(String catNombre) {
        this.catNombre = catNombre;
    }

    public List<Articulo> getArticuloList() {
        return articuloList;
    }

    public void setArticuloList(List<Articulo> articuloList) {
        this.articuloList = articuloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoriaArticulo != null ? categoriaArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaArticulo)) {
            return false;
        }
        CategoriaArticulo other = (CategoriaArticulo) object;
        if ((this.categoriaArticulo == null && other.categoriaArticulo != null) || (this.categoriaArticulo != null && !this.categoriaArticulo.equals(other.categoriaArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.CategoriaArticulo[ categoriaArticulo=" + categoriaArticulo + " ]";
    }
    
}
