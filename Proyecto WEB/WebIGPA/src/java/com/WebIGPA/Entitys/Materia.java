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
@Table(name = "materia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m"),
    @NamedQuery(name = "Materia.findByIdMateria", query = "SELECT m FROM Materia m WHERE m.idMateria = :idMateria"),
    @NamedQuery(name = "Materia.findByNombreMateria", query = "SELECT m FROM Materia m WHERE m.nombreMateria = :nombreMateria")})
public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdMateria")
    private Integer idMateria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NombreMateria")
    private String nombreMateria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMateria")
    private Collection<Tema> temaCollection;

    public Materia() {
    }

    public Materia(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public Materia(Integer idMateria, String nombreMateria) {
        this.idMateria = idMateria;
        this.nombreMateria = nombreMateria;
    }

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    @XmlTransient
    public Collection<Tema> getTemaCollection() {
        return temaCollection;
    }

    public void setTemaCollection(Collection<Tema> temaCollection) {
        this.temaCollection = temaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMateria != null ? idMateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.idMateria == null && other.idMateria != null) || (this.idMateria != null && !this.idMateria.equals(other.idMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.WebIGPA.Entitys.Materia[ idMateria=" + idMateria + " ]";
    }
    
}
