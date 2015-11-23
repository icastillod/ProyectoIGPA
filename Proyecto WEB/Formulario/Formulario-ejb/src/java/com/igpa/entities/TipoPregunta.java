/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.igpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author ivonne
 */
@Entity
@Table(name = "TipoPregunta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPregunta.findAll", query = "SELECT t FROM TipoPregunta t"),
    @NamedQuery(name = "TipoPregunta.findByIdTipoPregunta", query = "SELECT t FROM TipoPregunta t WHERE t.idTipoPregunta = :idTipoPregunta"),
    @NamedQuery(name = "TipoPregunta.findByNombreTipoPregunta", query = "SELECT t FROM TipoPregunta t WHERE t.nombreTipoPregunta = :nombreTipoPregunta"),
    @NamedQuery(name = "TipoPregunta.findByCantRespuestasPosibles", query = "SELECT t FROM TipoPregunta t WHERE t.cantRespuestasPosibles = :cantRespuestasPosibles"),
    @NamedQuery(name = "TipoPregunta.findByCantREspuestasCorrectas", query = "SELECT t FROM TipoPregunta t WHERE t.cantREspuestasCorrectas = :cantREspuestasCorrectas")})
public class TipoPregunta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdTipoPregunta")
    private Integer idTipoPregunta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NombreTipoPregunta")
    private String nombreTipoPregunta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CantRespuestasPosibles")
    private int cantRespuestasPosibles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CantREspuestasCorrectas")
    private int cantREspuestasCorrectas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoPregunta")
    private Collection<Pregunta> preguntaCollection;

    public TipoPregunta() {
    }

    public TipoPregunta(Integer idTipoPregunta) {
        this.idTipoPregunta = idTipoPregunta;
    }

    public TipoPregunta(Integer idTipoPregunta, String nombreTipoPregunta, int cantRespuestasPosibles, int cantREspuestasCorrectas) {
        this.idTipoPregunta = idTipoPregunta;
        this.nombreTipoPregunta = nombreTipoPregunta;
        this.cantRespuestasPosibles = cantRespuestasPosibles;
        this.cantREspuestasCorrectas = cantREspuestasCorrectas;
    }

    public Integer getIdTipoPregunta() {
        return idTipoPregunta;
    }

    public void setIdTipoPregunta(Integer idTipoPregunta) {
        this.idTipoPregunta = idTipoPregunta;
    }

    public String getNombreTipoPregunta() {
        return nombreTipoPregunta;
    }

    public void setNombreTipoPregunta(String nombreTipoPregunta) {
        this.nombreTipoPregunta = nombreTipoPregunta;
    }

    public int getCantRespuestasPosibles() {
        return cantRespuestasPosibles;
    }

    public void setCantRespuestasPosibles(int cantRespuestasPosibles) {
        this.cantRespuestasPosibles = cantRespuestasPosibles;
    }

    public int getCantREspuestasCorrectas() {
        return cantREspuestasCorrectas;
    }

    public void setCantREspuestasCorrectas(int cantREspuestasCorrectas) {
        this.cantREspuestasCorrectas = cantREspuestasCorrectas;
    }

    @XmlTransient
    public Collection<Pregunta> getPreguntaCollection() {
        return preguntaCollection;
    }

    public void setPreguntaCollection(Collection<Pregunta> preguntaCollection) {
        this.preguntaCollection = preguntaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPregunta != null ? idTipoPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPregunta)) {
            return false;
        }
        TipoPregunta other = (TipoPregunta) object;
        if ((this.idTipoPregunta == null && other.idTipoPregunta != null) || (this.idTipoPregunta != null && !this.idTipoPregunta.equals(other.idTipoPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.igpa.entities.TipoPregunta[ idTipoPregunta=" + idTipoPregunta + " ]";
    }
    
}
