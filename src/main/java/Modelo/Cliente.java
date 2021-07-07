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
@Table(name = "cliente")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByCliIdCliente", query = "SELECT c FROM Cliente c WHERE c.cliIdCliente = :cliIdCliente"),
    @NamedQuery(name = "Cliente.findByCliNombre", query = "SELECT c FROM Cliente c WHERE c.cliNombre = :cliNombre"),
    @NamedQuery(name = "Cliente.findByCliApellido", query = "SELECT c FROM Cliente c WHERE c.cliApellido = :cliApellido"),
    @NamedQuery(name = "Cliente.findByCliDireccion", query = "SELECT c FROM Cliente c WHERE c.cliDireccion = :cliDireccion"),
    @NamedQuery(name = "Cliente.findByCliTelefono", query = "SELECT c FROM Cliente c WHERE c.cliTelefono = :cliTelefono"),
    @NamedQuery(name = "Cliente.findByCliCorreo", query = "SELECT c FROM Cliente c WHERE c.cliCorreo = :cliCorreo")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CLI_ID_CLIENTE")
    private Integer cliIdCliente;
    @Basic(optional = false)
    @Column(name = "CLI_NOMBRE")
    private String cliNombre;
    @Basic(optional = false)
    @Column(name = "CLI_APELLIDO")
    private String cliApellido;
    @Basic(optional = false)
    @Column(name = "CLI_DIRECCION")
    private String cliDireccion;
    @Basic(optional = false)
    @Column(name = "CLI_TELEFONO")
    private int cliTelefono;
    @Basic(optional = false)
    @Column(name = "CLI_CORREO")
    private String cliCorreo;

    public Cliente() {
    }

    public Cliente(Integer cliIdCliente) {
        this.cliIdCliente = cliIdCliente;
    }

    public Cliente(Integer cliIdCliente, String cliNombre, String cliApellido, String cliDireccion, int cliTelefono, String cliCorreo) {
        this.cliIdCliente = cliIdCliente;
        this.cliNombre = cliNombre;
        this.cliApellido = cliApellido;
        this.cliDireccion = cliDireccion;
        this.cliTelefono = cliTelefono;
        this.cliCorreo = cliCorreo;
    }

    public Integer getCliIdCliente() {
        return cliIdCliente;
    }

    public void setCliIdCliente(Integer cliIdCliente) {
        this.cliIdCliente = cliIdCliente;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public String getCliApellido() {
        return cliApellido;
    }

    public void setCliApellido(String cliApellido) {
        this.cliApellido = cliApellido;
    }

    public String getCliDireccion() {
        return cliDireccion;
    }

    public void setCliDireccion(String cliDireccion) {
        this.cliDireccion = cliDireccion;
    }

    public int getCliTelefono() {
        return cliTelefono;
    }

    public void setCliTelefono(int cliTelefono) {
        this.cliTelefono = cliTelefono;
    }

    public String getCliCorreo() {
        return cliCorreo;
    }

    public void setCliCorreo(String cliCorreo) {
        this.cliCorreo = cliCorreo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cliIdCliente != null ? cliIdCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.cliIdCliente == null && other.cliIdCliente != null) || (this.cliIdCliente != null && !this.cliIdCliente.equals(other.cliIdCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Cliente[ cliIdCliente=" + cliIdCliente + " ]";
    }
    
}
