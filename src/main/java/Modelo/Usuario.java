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
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUsuIdUsuario", query = "SELECT u FROM Usuario u WHERE u.usuIdUsuario = :usuIdUsuario"),
    @NamedQuery(name = "Usuario.findByUsuNombre", query = "SELECT u FROM Usuario u WHERE u.usuNombre = :usuNombre"),
    @NamedQuery(name = "Usuario.findByUsuClave", query = "SELECT u FROM Usuario u WHERE u.usuClave = :usuClave"),
    @NamedQuery(name = "Usuario.findByHabilitado", query = "SELECT u FROM Usuario u WHERE u.habilitado = :habilitado")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_ID_USUARIO")
    private Integer usuIdUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "USU_NOMBRE")
    private String usuNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "USU_CLAVE")
    private String usuClave;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HABILITADO")
    private short habilitado;

    public Usuario() {
    }

    public Usuario(Integer usuIdUsuario) {
        this.usuIdUsuario = usuIdUsuario;
    }

    public Usuario(Integer usuIdUsuario, String usuNombre, String usuClave, short habilitado) {
        this.usuIdUsuario = usuIdUsuario;
        this.usuNombre = usuNombre;
        this.usuClave = usuClave;
        this.habilitado = habilitado;
    }

    public Integer getUsuIdUsuario() {
        return usuIdUsuario;
    }

    public void setUsuIdUsuario(Integer usuIdUsuario) {
        this.usuIdUsuario = usuIdUsuario;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getUsuClave() {
        return usuClave;
    }

    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }

    public short getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(short habilitado) {
        this.habilitado = habilitado;
    }
    public String Habilitado()
    {
        boolean myBoolean = false;
        if(getHabilitado()==Short.valueOf("0"))
        {
            myBoolean=true;
        }
        String result = myBoolean ? "Si" : "No";
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuIdUsuario != null ? usuIdUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuIdUsuario == null && other.usuIdUsuario != null) || (this.usuIdUsuario != null && !this.usuIdUsuario.equals(other.usuIdUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Usuario[ usuIdUsuario=" + usuIdUsuario + " ]";
    }
    
}
