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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author MADICAP
 */
@Entity
@Table(name = "comunas")
@NamedQueries({
    @NamedQuery(name = "Comunas.findAll", query = "SELECT c FROM Comunas c"),
    @NamedQuery(name = "Comunas.findByIdComuna", query = "SELECT c FROM Comunas c WHERE c.idComuna = :idComuna"),
    @NamedQuery(name = "Comunas.findByComDescripcion", query = "SELECT c FROM Comunas c WHERE c.comDescripcion = :comDescripcion")})
public class Comunas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ID_COMUNA")
    private String idComuna;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "COM_DESCRIPCION")
    private String comDescripcion;

    public Comunas() {
    }

    public Comunas(String idComuna) {
        this.idComuna = idComuna;
    }

    public Comunas(String idComuna, String comDescripcion) {
        this.idComuna = idComuna;
        this.comDescripcion = comDescripcion;
    }

    public String getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(String idComuna) {
        this.idComuna = idComuna;
    }

    public String getComDescripcion() {
        return comDescripcion;
    }

    public void setComDescripcion(String comDescripcion) {
        this.comDescripcion = comDescripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComuna != null ? idComuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comunas)) {
            return false;
        }
        Comunas other = (Comunas) object;
        if ((this.idComuna == null && other.idComuna != null) || (this.idComuna != null && !this.idComuna.equals(other.idComuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Comunas[ idComuna=" + idComuna + " ]";
    }
    
}
