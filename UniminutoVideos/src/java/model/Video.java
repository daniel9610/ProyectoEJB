/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Time;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DanielEsteban
 */
@Entity
@Table(name = "video")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Video.findAll", query = "SELECT v FROM Video v"),
    @NamedQuery(name = "Video.findByIsan", query = "SELECT v FROM Video v WHERE v.isan = :isan"),
    @NamedQuery(name = "Video.findByTitulo", query = "SELECT v FROM Video v WHERE v.titulo = :titulo"),
    @NamedQuery(name = "Video.findByDuracion", query = "SELECT v FROM Video v WHERE v.duracion = :duracion"),
    @NamedQuery(name = "Video.findByA\u00f1oProduccion", query = "SELECT v FROM Video v WHERE v.a\u00f1oProduccion = :a\u00f1oProduccion"),
    @NamedQuery(name = "Video.findByValorVideo", query = "SELECT v FROM Video v WHERE v.valorVideo = :valorVideo")})
public class Video implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Isan")
    private Integer isan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Duracion")
    @Temporal(TemporalType.TIME)
    private Date duracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "A\u00f1oProduccion")
    @Temporal(TemporalType.DATE)
    private Date añoProduccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ValorVideo")
    private int valorVideo;
    @JoinColumn(name = "IdSerie", referencedColumnName = "IdSerie")
    @ManyToOne(optional = false)
    private Serie idSerie;
    @JoinColumn(name = "cod_idioma", referencedColumnName = "cod_idioma")
    @ManyToOne(optional = false)
    private Idioma codIdioma;

    public Video() {
    }

    public Video(Integer isan, String titulo, Date duracion, Date añoProduccion, int valorVideo, Serie idSerie, Idioma codIdioma) {
        this.isan = isan;
        this.titulo = titulo;
        this.duracion = duracion;
        this.añoProduccion = añoProduccion;
        this.valorVideo = valorVideo;
        this.idSerie = idSerie;
        this.codIdioma = codIdioma;
    }
    
    

    public Video(Integer isan) {
        this.isan = isan;
    }

//    public Video(Integer isan, String titulo, Date duracion, Date añoProduccion, int valorVideo) {
//        this.isan = isan;
//        this.titulo = titulo;
//        this.duracion = duracion;
//        this.añoProduccion = añoProduccion;
//        this.valorVideo = valorVideo;
//    }

  

   

    public Integer getIsan() {
        return isan;
    }

    public void setIsan(Integer isan) {
        this.isan = isan;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDuracion() {
        return duracion;
    }

    public void setDuracion(Date duracion) {
        this.duracion = duracion;
    }

    public Date getAñoProduccion() {
        return añoProduccion;
    }

    public void setAñoProduccion(Date añoProduccion) {
        this.añoProduccion = añoProduccion;
    }

    public int getValorVideo() {
        return valorVideo;
    }

    public void setValorVideo(int valorVideo) {
        this.valorVideo = valorVideo;
    }

    public Serie getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Serie idSerie) {
        this.idSerie = idSerie;
    }

    public Idioma getCodIdioma() {
        return codIdioma;
    }

    public void setCodIdioma(Idioma codIdioma) {
        this.codIdioma = codIdioma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isan != null ? isan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Video)) {
            return false;
        }
        Video other = (Video) object;
        if ((this.isan == null && other.isan != null) || (this.isan != null && !this.isan.equals(other.isan))) {
            return false;
        }
        return true;
    }
Serie serie;
Idioma idioma;
    @Override
    public String toString() {
        return "model.Video[ isan=" + isan + " ]";
    }

    public Serie getSerie() {
        return serie;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setSerie(Serie serie) {
       this.serie = serie;
    }

    public void setIdioma(Idioma idioma) {
          this.idioma = idioma;
    }
    
}
