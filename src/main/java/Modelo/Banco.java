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
@Table(name = "banco")
@NamedQueries({
    @NamedQuery(name = "Banco.findAll", query = "SELECT b FROM Banco b"),
    @NamedQuery(name = "Banco.findByBanIdBanco", query = "SELECT b FROM Banco b WHERE b.banIdBanco = :banIdBanco"),
    @NamedQuery(name = "Banco.findByBanNombre", query = "SELECT b FROM Banco b WHERE b.banNombre = :banNombre")})
public class Banco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BAN_ID_BANCO")
    private Integer banIdBanco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "BAN_NOMBRE")
    private String banNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "banIdBanco")
    private List<Venta> ventaList;

    public Banco() {
    }

    public Banco(Integer banIdBanco) {
        this.banIdBanco = banIdBanco;
    }

    public Banco(Integer banIdBanco, String banNombre) {
        this.banIdBanco = banIdBanco;
        this.banNombre = banNombre;
    }

    public Integer getBanIdBanco() {
        return banIdBanco;
    }

    public void setBanIdBanco(Integer banIdBanco) {
        this.banIdBanco = banIdBanco;
    }

    public String getBanNombre() {
        return banNombre;
    }

    public void setBanNombre(String banNombre) {
        this.banNombre = banNombre;
    }

    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (banIdBanco != null ? banIdBanco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banco)) {
            return false;
        }
        Banco other = (Banco) object;
        if ((this.banIdBanco == null && other.banIdBanco != null) || (this.banIdBanco != null && !this.banIdBanco.equals(other.banIdBanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Banco[ banIdBanco=" + banIdBanco + " ]";
    }
    
}
