/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.igpa.controller;

import com.igpa.entities.Materia;
import com.igpa.negocio.MateriaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ivonne
 */
@ManagedBean
@RequestScoped
public class FormularioController {
    @EJB
    private MateriaFacade materiaFacade;
    
    private List<Materia> listaMaterias;
    private Materia materia;

    /**
     * Creates a new instance of FormularioController
     */
    public FormularioController() {
        materia= new Materia();
        listaMaterias = materiaFacade.findAll();
    }

    public List<Materia> getListaMaterias() {
        return listaMaterias;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setListaMaterias(List<Materia> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
}
