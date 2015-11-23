/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WebIGPA.Entitys;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Yerard
 */
@Entity
@Table(name = "pregunta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pregunta.findAll", query = "SELECT p FROM Pregunta p"),
    @NamedQuery(name = "Pregunta.findByIdPregunta", query = "SELECT p FROM Pregunta p WHERE p.idPregunta = :idPregunta"),
    @NamedQuery(name = "Pregunta.findByEnunciado", query = "SELECT p FROM Pregunta p WHERE p.enunciado = :enunciado"),
    @NamedQuery(name = "Pregunta.findByComplejdad", query = "SELECT p FROM Pregunta p WHERE p.complejdad = :complejdad")})
public class Pregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdPregunta")
    private Integer idPregunta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Enunciado")
    private String enunciado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Complejdad")
    private int complejdad;
    @JoinColumn(name = "IdTipoPregunta", referencedColumnName = "IdTipoPregunta")
    @ManyToOne(optional = false)
    private Tipopregunta idTipoPregunta;
    @JoinColumn(name = "IdTema", referencedColumnName = "IdTema")
    @ManyToOne(optional = false)
    private Tema idTema;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPregunta")
    private Collection<Respuesta> respuestaCollection;

    public Pregunta() {
    }

    public Pregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public Pregunta(Integer idPregunta, String enunciado, int complejdad) {
        this.idPregunta = idPregunta;
        this.enunciado = enunciado;
        this.complejdad = complejdad;
    }

    public Integer getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public int getComplejdad() {
        return complejdad;
    }

    public void setComplejdad(int complejdad) {
        this.complejdad = complejdad;
    }

    public Tipopregunta getIdTipoPregunta() {
        return idTipoPregunta;
    }

    public void setIdTipoPregunta(Tipopregunta idTipoPregunta) {
        this.idTipoPregunta = idTipoPregunta;
    }

    public Tema getIdTema() {
        return idTema;
    }

    public void setIdTema(Tema idTema) {
        this.idTema = idTema;
    }

    @XmlTransient
    public Collection<Respuesta> getRespuestaCollection() {
        return respuestaCollection;
    }

    public void setRespuestaCollection(Collection<Respuesta> respuestaCollection) {
        this.respuestaCollection = respuestaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPregunta != null ? idPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pregunta)) {
            return false;
        }
        Pregunta other = (Pregunta) object;
        if ((this.idPregunta == null && other.idPregunta != null) || (this.idPregunta != null && !this.idPregunta.equals(other.idPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.WebIGPA.Entitys.Pregunta[ idPregunta=" + idPregunta + " ]";
    }
    
}
