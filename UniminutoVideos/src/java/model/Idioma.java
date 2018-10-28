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
@Table(name = "idioma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Idioma.findAll", query = "SELECT i FROM Idioma i"),
    @NamedQuery(name = "Idioma.findByCodIdioma", query = "SELECT i FROM Idioma i WHERE i.codIdioma = :codIdioma"),
    @NamedQuery(name = "Idioma.findByNombreidioma", query = "SELECT i FROM Idioma i WHERE i.nombreidioma = :nombreidioma")})
public class Idioma implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codIdioma")
    private Collection<Video> videoCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_idioma")
    public Integer codIdioma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Nombre_idioma")
    private String nombreidioma;

    public Idioma() {
    }

    public Idioma(Integer codIdioma) {
        this.codIdioma = codIdioma;
    }

    public Idioma(Integer codIdioma, String nombreidioma) {
        this.codIdioma = codIdioma;
        this.nombreidioma = nombreidioma;
    }

    public Integer getCodIdioma() {
        return codIdioma;
    }

    public void setCodIdioma(Integer codIdioma) {
        this.codIdioma = codIdioma;
    }

    public String getNombreidioma() {
        return nombreidioma;
    }

    public void setNombreidioma(String nombreidioma) {
        this.nombreidioma = nombreidioma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codIdioma != null ? codIdioma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Idioma)) {
            return false;
        }
        Idioma other = (Idioma) object;
        if ((this.codIdioma == null && other.codIdioma != null) || (this.codIdioma != null && !this.codIdioma.equals(other.codIdioma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Idioma[ codIdioma=" + codIdioma + " ]";
    }

    @XmlTransient
    public Collection<Video> getVideoCollection() {
        return videoCollection;
    }

    public void setVideoCollection(Collection<Video> videoCollection) {
        this.videoCollection = videoCollection;
    }
    
}
