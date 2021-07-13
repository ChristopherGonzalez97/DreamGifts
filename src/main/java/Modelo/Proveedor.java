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
@Table(name = "proveedor")
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p"),
    @NamedQuery(name = "Proveedor.findByProIdProveedor", query = "SELECT p FROM Proveedor p WHERE p.proIdProveedor = :proIdProveedor"),
    @NamedQuery(name = "Proveedor.findByProRut", query = "SELECT p FROM Proveedor p WHERE p.proRut = :proRut"),
    @NamedQuery(name = "Proveedor.findByProNombre", query = "SELECT p FROM Proveedor p WHERE p.proNombre = :proNombre"),
    @NamedQuery(name = "Proveedor.findByProTelefono", query = "SELECT p FROM Proveedor p WHERE p.proTelefono = :proTelefono"),
    @NamedQuery(name = "Proveedor.findByProCorreo", query = "SELECT p FROM Proveedor p WHERE p.proCorreo = :proCorreo"),
    @NamedQuery(name = "Proveedor.findByProDireccion", query = "SELECT p FROM Proveedor p WHERE p.proDireccion = :proDireccion"),
    @NamedQuery(name = "Proveedor.findByProRazonSocial", query = "SELECT p FROM Proveedor p WHERE p.proRazonSocial = :proRazonSocial")})
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRO_ID_PROVEEDOR")
    private Integer proIdProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PRO_RUT")
    private String proRut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PRO_NOMBRE")
    private String proNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRO_TELEFONO")
    private int proTelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PRO_CORREO")
    private String proCorreo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PRO_DIRECCION")
    private String proDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PRO_RAZON_SOCIAL")
    private String proRazonSocial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proIdProveedor")
    private List<Factura> facturaList;

    public Proveedor() {
    }

    public Proveedor(Integer proIdProveedor) {
        this.proIdProveedor = proIdProveedor;
    }

    public Proveedor(Integer proIdProveedor, String proRut, String proNombre, int proTelefono, String proCorreo, String proDireccion, String proRazonSocial) {
        this.proIdProveedor = proIdProveedor;
        this.proRut = proRut;
        this.proNombre = proNombre;
        this.proTelefono = proTelefono;
        this.proCorreo = proCorreo;
        this.proDireccion = proDireccion;
        this.proRazonSocial = proRazonSocial;
    }

    public Integer getProIdProveedor() {
        return proIdProveedor;
    }

    public void setProIdProveedor(Integer proIdProveedor) {
        this.proIdProveedor = proIdProveedor;
    }

    public String getProRut() {
        return proRut;
    }

    public void setProRut(String proRut) {
        this.proRut = proRut;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public int getProTelefono() {
        return proTelefono;
    }

    public void setProTelefono(int proTelefono) {
        this.proTelefono = proTelefono;
    }

    public String getProCorreo() {
        return proCorreo;
    }

    public void setProCorreo(String proCorreo) {
        this.proCorreo = proCorreo;
    }

    public String getProDireccion() {
        return proDireccion;
    }

    public void setProDireccion(String proDireccion) {
        this.proDireccion = proDireccion;
    }

    public String getProRazonSocial() {
        return proRazonSocial;
    }

    public void setProRazonSocial(String proRazonSocial) {
        this.proRazonSocial = proRazonSocial;
    }

    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proIdProveedor != null ? proIdProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.proIdProveedor == null && other.proIdProveedor != null) || (this.proIdProveedor != null && !this.proIdProveedor.equals(other.proIdProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Proveedor[ proIdProveedor=" + proIdProveedor + " ]";
    }
    
}
