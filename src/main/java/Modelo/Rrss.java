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
@Table(name = "rrss")
@NamedQueries({
    @NamedQuery(name = "Rrss.findAll", query = "SELECT r FROM Rrss r"),
    @NamedQuery(name = "Rrss.findByRrsIdRrss", query = "SELECT r FROM Rrss r WHERE r.rrsIdRrss = :rrsIdRrss"),
    @NamedQuery(name = "Rrss.findByRrsNombre", query = "SELECT r FROM Rrss r WHERE r.rrsNombre = :rrsNombre")})
public class Rrss implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RRS_ID_RRSS")
    private Integer rrsIdRrss;
    @Basic(optional = false)
    @Column(name = "RRS_NOMBRE")
    private String rrsNombre;

    public Rrss() {
    }

    public Rrss(Integer rrsIdRrss) {
        this.rrsIdRrss = rrsIdRrss;
    }

    public Rrss(Integer rrsIdRrss, String rrsNombre) {
        this.rrsIdRrss = rrsIdRrss;
        this.rrsNombre = rrsNombre;
    }

    public Integer getRrsIdRrss() {
        return rrsIdRrss;
    }

    public void setRrsIdRrss(Integer rrsIdRrss) {
        this.rrsIdRrss = rrsIdRrss;
    }

    public String getRrsNombre() {
        return rrsNombre;
    }

    public void setRrsNombre(String rrsNombre) {
        this.rrsNombre = rrsNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rrsIdRrss != null ? rrsIdRrss.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rrss)) {
            return false;
        }
        Rrss other = (Rrss) object;
        if ((this.rrsIdRrss == null && other.rrsIdRrss != null) || (this.rrsIdRrss != null && !this.rrsIdRrss.equals(other.rrsIdRrss))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Rrss[ rrsIdRrss=" + rrsIdRrss + " ]";
    }
    
}
