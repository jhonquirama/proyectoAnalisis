/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebastian
 */
@Entity
@Table(name = "OPERACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operaciones.findAll", query = "SELECT o FROM Operaciones o")
    , @NamedQuery(name = "Operaciones.findByIdOperacion", query = "SELECT o FROM Operaciones o WHERE o.idOperacion = :idOperacion")
    , @NamedQuery(name = "Operaciones.findByEstructura", query = "SELECT o FROM Operaciones o WHERE o.estructura = :estructura")
    , @NamedQuery(name = "Operaciones.findByTiempo", query = "SELECT o FROM Operaciones o WHERE o.tiempo = :tiempo")
    , @NamedQuery(name = "Operaciones.findByCantidad", query = "SELECT o FROM Operaciones o WHERE o.cantidad = :cantidad")
    , @NamedQuery(name = "Operaciones.findByOperacion", query = "SELECT o FROM Operaciones o WHERE o.operacion = :operacion")})
public class Operaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_OPERACION")
    private BigDecimal idOperacion;
    @Column(name = "ESTRUCTURA")
    private String estructura;
    @Column(name = "TIEMPO")
    private BigInteger tiempo;
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Column(name = "OPERACION")
    private String operacion;

    public Operaciones() {
    }

    public Operaciones(BigDecimal idOperacion) {
        this.idOperacion = idOperacion;
    }

    public BigDecimal getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(BigDecimal idOperacion) {
        this.idOperacion = idOperacion;
    }

    public String getEstructura() {
        return estructura;
    }

    public void setEstructura(String estructura) {
        this.estructura = estructura;
    }

    public BigInteger getTiempo() {
        return tiempo;
    }

    public void setTiempo(BigInteger tiempo) {
        this.tiempo = tiempo;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperacion != null ? idOperacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operaciones)) {
            return false;
        }
        Operaciones other = (Operaciones) object;
        if ((this.idOperacion == null && other.idOperacion != null) || (this.idOperacion != null && !this.idOperacion.equals(other.idOperacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Operaciones[ idOperacion=" + idOperacion + " ]";
    }
    
}
