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
@Table(name = "categoria_pack")
@NamedQueries({
    @NamedQuery(name = "CategoriaPack.findAll", query = "SELECT c FROM CategoriaPack c"),
    @NamedQuery(name = "CategoriaPack.findByIdCATEGORIAPACK", query = "SELECT c FROM CategoriaPack c WHERE c.idCATEGORIAPACK = :idCATEGORIAPACK"),
    @NamedQuery(name = "CategoriaPack.findByNombre", query = "SELECT c FROM CategoriaPack c WHERE c.nombre = :nombre")})
public class CategoriaPack implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCATEGORIA_PACK")
    private Integer idCATEGORIAPACK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cATEGORIAPACKidCATEGORIAPACK")
    private List<Pack> packList;

    public CategoriaPack() {
    }

    public CategoriaPack(Integer idCATEGORIAPACK) {
        this.idCATEGORIAPACK = idCATEGORIAPACK;
    }

    public CategoriaPack(Integer idCATEGORIAPACK, String nombre) {
        this.idCATEGORIAPACK = idCATEGORIAPACK;
        this.nombre = nombre;
    }

    public Integer getIdCATEGORIAPACK() {
        return idCATEGORIAPACK;
    }

    public void setIdCATEGORIAPACK(Integer idCATEGORIAPACK) {
        this.idCATEGORIAPACK = idCATEGORIAPACK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pack> getPackList() {
        return packList;
    }

    public void setPackList(List<Pack> packList) {
        this.packList = packList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCATEGORIAPACK != null ? idCATEGORIAPACK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaPack)) {
            return false;
        }
        CategoriaPack other = (CategoriaPack) object;
        if ((this.idCATEGORIAPACK == null && other.idCATEGORIAPACK != null) || (this.idCATEGORIAPACK != null && !this.idCATEGORIAPACK.equals(other.idCATEGORIAPACK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.CategoriaPack[ idCATEGORIAPACK=" + idCATEGORIAPACK + " ]";
    }
    
}
