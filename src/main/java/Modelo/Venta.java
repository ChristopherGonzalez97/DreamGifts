/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "venta")
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v"),
    @NamedQuery(name = "Venta.findByVtaIdVenta", query = "SELECT v FROM Venta v WHERE v.vtaIdVenta = :vtaIdVenta"),
    @NamedQuery(name = "Venta.findByVtaTotal", query = "SELECT v FROM Venta v WHERE v.vtaTotal = :vtaTotal"),
    @NamedQuery(name = "Venta.findByVtaFechaVenta", query = "SELECT v FROM Venta v WHERE v.vtaFechaVenta = :vtaFechaVenta"),
    @NamedQuery(name = "Venta.findByVtaFechaTransferencia", query = "SELECT v FROM Venta v WHERE v.vtaFechaTransferencia = :vtaFechaTransferencia"),
    @NamedQuery(name = "Venta.findByVtaCodigoTransferencia", query = "SELECT v FROM Venta v WHERE v.vtaCodigoTransferencia = :vtaCodigoTransferencia"),
    @NamedQuery(name = "Venta.findByVtaNombreDestinatario", query = "SELECT v FROM Venta v WHERE v.vtaNombreDestinatario = :vtaNombreDestinatario"),
    @NamedQuery(name = "Venta.findByVtaDireccionDestinatario", query = "SELECT v FROM Venta v WHERE v.vtaDireccionDestinatario = :vtaDireccionDestinatario"),
    @NamedQuery(name = "Venta.findByVtaTelefono", query = "SELECT v FROM Venta v WHERE v.vtaTelefono = :vtaTelefono"),
    @NamedQuery(name = "Venta.findByVtaCorreo", query = "SELECT v FROM Venta v WHERE v.vtaCorreo = :vtaCorreo"),
    @NamedQuery(name = "Venta.findByVtaFechaEntrega", query = "SELECT v FROM Venta v WHERE v.vtaFechaEntrega = :vtaFechaEntrega"),
    @NamedQuery(name = "Venta.findByVtaHoraEntregaInicial", query = "SELECT v FROM Venta v WHERE v.vtaHoraEntregaInicial = :vtaHoraEntregaInicial"),
    @NamedQuery(name = "Venta.findByVtaHoraEntregaFinal", query = "SELECT v FROM Venta v WHERE v.vtaHoraEntregaFinal = :vtaHoraEntregaFinal"),
    @NamedQuery(name = "Venta.findBetweenFechas", query = "SELECT v FROM Venta v WHERE v.vtaFechaVenta BETWEEN :fechaInicial AND :fechaFinal"),
    @NamedQuery(name = "Venta.findByVtaSaludo", query = "SELECT v FROM Venta v WHERE v.vtaSaludo = :vtaSaludo")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "VTA_ID_VENTA")
    private Integer vtaIdVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VTA_TOTAL")
    private int vtaTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VTA_FECHA_VENTA")
    @Temporal(TemporalType.DATE)
    private Date vtaFechaVenta;
    @Column(name = "VTA_FECHA_TRANSFERENCIA")
    @Temporal(TemporalType.DATE)
    private Date vtaFechaTransferencia;
    @Column(name = "VTA_CODIGO_TRANSFERENCIA")
    private Integer vtaCodigoTransferencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "VTA_NOMBRE_DESTINATARIO")
    private String vtaNombreDestinatario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "VTA_DIRECCION_DESTINATARIO")
    private String vtaDireccionDestinatario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VTA_TELEFONO")
    private int vtaTelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "VTA_CORREO")
    private String vtaCorreo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VTA_FECHA_ENTREGA")
    @Temporal(TemporalType.DATE)
    private Date vtaFechaEntrega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "VTA_HORA_ENTREGA_INICIAL")
    private String vtaHoraEntregaInicial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "VTA_HORA_ENTREGA_FINAL")
    private String vtaHoraEntregaFinal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "VTA_SALUDO")
    private String vtaSaludo;
    @JoinColumn(name = "BAN_ID_BANCO", referencedColumnName = "BAN_ID_BANCO")
    @ManyToOne
    private Banco banIdBanco;
    @JoinColumn(name = "CLI_ID_CLIENTE", referencedColumnName = "CLI_ID_CLIENTE")
    @ManyToOne(optional = false)
    private Cliente cliIdCliente;
    @JoinColumn(name = "COMUNA_ID_COMUNA", referencedColumnName = "ID_COMUNA")
    @ManyToOne(optional = false)
    private Comuna comunaIdComuna;
    @JoinColumn(name = "ESTADO_VENTA_ID_ESTADO", referencedColumnName = "ID_ESTADO")
    @ManyToOne(optional = false)
    private EstadoVenta estadoVentaIdEstado;
    @JoinColumn(name = "PCK_ID_PACK", referencedColumnName = "PCK_ID_PACK")
    @ManyToOne(optional = false)
    private Pack pckIdPack;
    @JoinColumn(name = "RRSS_RRS_ID_RRSS", referencedColumnName = "RRS_ID_RRSS")
    @ManyToOne(optional = false)
    private Rrss rrssRrsIdRrss;

    public Venta() {
    }

    public Venta(Integer vtaIdVenta) {
        this.vtaIdVenta = vtaIdVenta;
    }

    public Venta(Integer vtaIdVenta, int vtaTotal, Date vtaFechaVenta, String vtaNombreDestinatario, String vtaDireccionDestinatario, int vtaTelefono, String vtaCorreo, Date vtaFechaEntrega, String vtaHoraEntregaInicial, String vtaHoraEntregaFinal, String vtaSaludo) {
        this.vtaIdVenta = vtaIdVenta;
        this.vtaTotal = vtaTotal;
        this.vtaFechaVenta = vtaFechaVenta;
        this.vtaNombreDestinatario = vtaNombreDestinatario;
        this.vtaDireccionDestinatario = vtaDireccionDestinatario;
        this.vtaTelefono = vtaTelefono;
        this.vtaCorreo = vtaCorreo;
        this.vtaFechaEntrega = vtaFechaEntrega;
        this.vtaHoraEntregaInicial = vtaHoraEntregaInicial;
        this.vtaHoraEntregaFinal = vtaHoraEntregaFinal;
        this.vtaSaludo = vtaSaludo;
    }

    public Integer getVtaIdVenta() {
        return vtaIdVenta;
    }

    public void setVtaIdVenta(Integer vtaIdVenta) {
        this.vtaIdVenta = vtaIdVenta;
    }

    public int getVtaTotal() {
        return vtaTotal;
    }

    public void setVtaTotal(int vtaTotal) {
        this.vtaTotal = vtaTotal;
    }

    public Date getVtaFechaVenta() {
        return vtaFechaVenta;
    }

    public void setVtaFechaVenta(Date vtaFechaVenta) {
        this.vtaFechaVenta = vtaFechaVenta;
    }

    public Date getVtaFechaTransferencia() {
        return vtaFechaTransferencia;
    }
    
    
    
    public void setVtaFechaTransferencia(Date vtaFechaTransferencia) {
        this.vtaFechaTransferencia = vtaFechaTransferencia;
    }

    public Integer getVtaCodigoTransferencia() {
        return vtaCodigoTransferencia;
    }

    public void setVtaCodigoTransferencia(Integer vtaCodigoTransferencia) {
        this.vtaCodigoTransferencia = vtaCodigoTransferencia;
    }

    public String getVtaNombreDestinatario() {
        return vtaNombreDestinatario;
    }

    public void setVtaNombreDestinatario(String vtaNombreDestinatario) {
        this.vtaNombreDestinatario = vtaNombreDestinatario;
    }

    public String getVtaDireccionDestinatario() {
        return vtaDireccionDestinatario;
    }

    public void setVtaDireccionDestinatario(String vtaDireccionDestinatario) {
        this.vtaDireccionDestinatario = vtaDireccionDestinatario;
    }

    public int getVtaTelefono() {
        return vtaTelefono;
    }

    public void setVtaTelefono(int vtaTelefono) {
        this.vtaTelefono = vtaTelefono;
    }

    public String getVtaCorreo() {
        return vtaCorreo;
    }

    public void setVtaCorreo(String vtaCorreo) {
        this.vtaCorreo = vtaCorreo;
    }

    public Date getVtaFechaEntrega() {
        return vtaFechaEntrega;
    }

    public void setVtaFechaEntrega(Date vtaFechaEntrega) {
        this.vtaFechaEntrega = vtaFechaEntrega;
    }

    public String getVtaHoraEntregaInicial() {
        return vtaHoraEntregaInicial;
    }

    public void setVtaHoraEntregaInicial(String vtaHoraEntregaInicial) {
        this.vtaHoraEntregaInicial = vtaHoraEntregaInicial;
    }

    public String getVtaHoraEntregaFinal() {
        return vtaHoraEntregaFinal;
    }

    public void setVtaHoraEntregaFinal(String vtaHoraEntregaFinal) {
        this.vtaHoraEntregaFinal = vtaHoraEntregaFinal;
    }

    public String getVtaSaludo() {
        return vtaSaludo;
    }

    public void setVtaSaludo(String vtaSaludo) {
        this.vtaSaludo = vtaSaludo;
    }

    public Banco getBanIdBanco() {
        return banIdBanco;
    }

    public void setBanIdBanco(Banco banIdBanco) {
        this.banIdBanco = banIdBanco;
    }

    public Cliente getCliIdCliente() {
        return cliIdCliente;
    }

    public void setCliIdCliente(Cliente cliIdCliente) {
        this.cliIdCliente = cliIdCliente;
    }

    public Comuna getComunaIdComuna() {
        return comunaIdComuna;
    }

    public void setComunaIdComuna(Comuna comunaIdComuna) {
        this.comunaIdComuna = comunaIdComuna;
    }

    public EstadoVenta getEstadoVentaIdEstado() {
        return estadoVentaIdEstado;
    }

    public void setEstadoVentaIdEstado(EstadoVenta estadoVentaIdEstado) {
        this.estadoVentaIdEstado = estadoVentaIdEstado;
    }

    public Pack getPckIdPack() {
        return pckIdPack;
    }

    public void setPckIdPack(Pack pckIdPack) {
        this.pckIdPack = pckIdPack;
    }

    public Rrss getRrssRrsIdRrss() {
        return rrssRrsIdRrss;
    }

    public void setRrssRrsIdRrss(Rrss rrssRrsIdRrss) {
        this.rrssRrsIdRrss = rrssRrsIdRrss;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vtaIdVenta != null ? vtaIdVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.vtaIdVenta == null && other.vtaIdVenta != null) || (this.vtaIdVenta != null && !this.vtaIdVenta.equals(other.vtaIdVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Venta[ vtaIdVenta=" + vtaIdVenta + " ]";
    }
    
}
