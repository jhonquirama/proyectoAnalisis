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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebastian
 */
@Entity
@Table(name = "ORDENACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordenacion.findAll", query = "SELECT o FROM Ordenacion o")
    , @NamedQuery(name = "Ordenacion.findByIdOrdenacion", query = "SELECT o FROM Ordenacion o WHERE o.idOrdenacion = :idOrdenacion")
    , @NamedQuery(name = "Ordenacion.findByMetodo", query = "SELECT o FROM Ordenacion o WHERE o.metodo = :metodo")
    , @NamedQuery(name = "Ordenacion.findByTiempo", query = "SELECT o FROM Ordenacion o WHERE o.tiempo = :tiempo")
    , @NamedQuery(name = "Ordenacion.findByCantidad", query = "SELECT o FROM Ordenacion o WHERE o.cantidad = :cantidad")
    , @NamedQuery(name = "Ordenacion.findByTipoDato", query = "SELECT o FROM Ordenacion o WHERE o.tipoDato = :tipoDato")})

public class Ordenacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ORDENACION")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuenciaOr")
    @SequenceGenerator(name = "secuenciaOr", sequenceName = "secuencia", allocationSize = 1)
    private BigDecimal idOrdenacion;
    @Column(name = "METODO")
    private String metodo;
    @Column(name = "TIEMPO")
    private BigInteger tiempo;
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Column(name = "TIPO_DATO")
    private String tipoDato;

    public Ordenacion() {
    }

    public Ordenacion(BigDecimal idOrdenacion) {
        this.idOrdenacion = idOrdenacion;
    }

    public BigDecimal getIdOrdenacion() {
        return idOrdenacion;
    }

    public void setIdOrdenacion(BigDecimal idOrdenacion) {
        this.idOrdenacion = idOrdenacion;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
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

    public String getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenacion != null ? idOrdenacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordenacion)) {
            return false;
        }
        Ordenacion other = (Ordenacion) object;
        if ((this.idOrdenacion == null && other.idOrdenacion != null) || (this.idOrdenacion != null && !this.idOrdenacion.equals(other.idOrdenacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Ordenacion[ idOrdenacion=" + idOrdenacion + " ]";
    }

}
