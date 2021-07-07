/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author MADICAP
 */
@Entity
@Table(name = "bancos")
@NamedQueries({
    @NamedQuery(name = "Bancos.findAll", query = "SELECT b FROM Bancos b"),
    @NamedQuery(name = "Bancos.findByBanIdBanco", query = "SELECT b FROM Bancos b WHERE b.banIdBanco = :banIdBanco"),
    @NamedQuery(name = "Bancos.findByBanDescripcion", query = "SELECT b FROM Bancos b WHERE b.banDescripcion = :banDescripcion")})
public class Bancos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BAN_ID_BANCO")
    private Integer banIdBanco;
    @Basic(optional = false)
    @Column(name = "BAN_DESCRIPCION")
    private String banDescripcion;

    public Bancos() {
    }

    public Bancos(Integer banIdBanco) {
        this.banIdBanco = banIdBanco;
    }

    public Bancos(Integer banIdBanco, String banDescripcion) {
        this.banIdBanco = banIdBanco;
        this.banDescripcion = banDescripcion;
    }

    public Integer getBanIdBanco() {
        return banIdBanco;
    }

    public void setBanIdBanco(Integer banIdBanco) {
        this.banIdBanco = banIdBanco;
    }

    public String getBanDescripcion() {
        return banDescripcion;
    }

    public void setBanDescripcion(String banDescripcion) {
        this.banDescripcion = banDescripcion;
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
        if (!(object instanceof Bancos)) {
            return false;
        }
        Bancos other = (Bancos) object;
        if ((this.banIdBanco == null && other.banIdBanco != null) || (this.banIdBanco != null && !this.banIdBanco.equals(other.banIdBanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Bancos[ banIdBanco=" + banIdBanco + " ]";
    }
    
}
