/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DanielEsteban
 */
@Entity
@Table(name = "serie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Serie.findAll", query = "SELECT s FROM Serie s"),
    @NamedQuery(name = "Serie.findByIdSerie", query = "SELECT s FROM Serie s WHERE s.idSerie = :idSerie"),
    @NamedQuery(name = "Serie.findByNombreSerie", query = "SELECT s FROM Serie s WHERE s.nombreSerie = :nombreSerie"),
    @NamedQuery(name = "Serie.findByTemporada", query = "SELECT s FROM Serie s WHERE s.temporada = :temporada"),
    @NamedQuery(name = "Serie.findByValorSerie", query = "SELECT s FROM Serie s WHERE s.valorSerie = :valorSerie")})
public class Serie implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSerie")
    private Collection<Video> videoCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdSerie")
    public Integer idSerie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NombreSerie")
    private String nombreSerie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Temporada")
    private int temporada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ValorSerie")
    private int valorSerie;

    public Serie() {
    }

    public Serie(Collection<Video> videoCollection, Integer idSerie, String nombreSerie, int temporada, int valorSerie) {
        this.videoCollection = videoCollection;
        this.idSerie = idSerie;
        this.nombreSerie = nombreSerie;
        this.temporada = temporada;
        this.valorSerie = valorSerie;
    }

    public Serie(Integer idSerie) {
        this.idSerie = idSerie;
    }

    public Serie(Integer idSerie, String nombreSerie, int temporada, int valorSerie) {
        this.idSerie = idSerie;
        this.nombreSerie = nombreSerie;
        this.temporada = temporada;
        this.valorSerie = valorSerie;
    }

    public Integer getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Integer idSerie) {
        this.idSerie = idSerie;
    }

    public String getNombreSerie() {
        return nombreSerie;
    }

    public void setNombreSerie(String nombreSerie) {
        this.nombreSerie = nombreSerie;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public int getValorSerie() {
        return valorSerie;
    }

    public void setValorSerie(int valorSerie) {
        this.valorSerie = valorSerie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSerie != null ? idSerie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Serie)) {
            return false;
        }
        Serie other = (Serie) object;
        if ((this.idSerie == null && other.idSerie != null) || (this.idSerie != null && !this.idSerie.equals(other.idSerie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Serie[ idSerie=" + idSerie + " ]";
    }

    @XmlTransient
    public Collection<Video> getVideoCollection() {
        return videoCollection;
    }

    public void setVideoCollection(Collection<Video> videoCollection) {
        this.videoCollection = videoCollection;
    }
    
}
