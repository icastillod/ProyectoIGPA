/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.igpa.controller;

import com.igpa.entities.Materia;
import com.igpa.entities.Pregunta;
import com.igpa.entities.Tema;
import com.igpa.negocio.MateriaFacade;
import com.igpa.negocio.PreguntaFacade;
import com.igpa.negocio.TemaFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author ivonne
 */
@ManagedBean
@RequestScoped
public class FormularioController implements Serializable {

    @EJB
    private PreguntaFacade preguntaFacade;

    @EJB
    private TemaFacade temaFacade;

    @EJB
    private MateriaFacade materiaFacade;

    private Materia materia;
    private Tema tema;
    private ArrayList<Materia> listMaterias;
    private ArrayList<Tema> listTemas;
    private ArrayList<Pregunta> listPregunta;

    /**
     * Creates a new instance of FormularioController
     */
    public FormularioController() {
        materia = new Materia();
        tema = new Tema();
        listMaterias = new ArrayList<Materia>();
        listTemas = new ArrayList<Tema>();
        listPregunta = new ArrayList<Pregunta>();
    }

    @PostConstruct
    public void init() {
        System.out.println("asdasda:: " + materiaFacade.findAll().size());
        listMaterias.addAll(materiaFacade.findAll());
    }

    public void comunicar() {
        System.out.println("asdasda:: " + materiaFacade.findAll().size());
        listMaterias.addAll(materiaFacade.findAll());
    }

    public void pruebaTema(ValueChangeEvent event) {
        Integer materiaSelect = ((Integer) event.getNewValue());
        System.out.println(materiaSelect);
        ArrayList<Tema> aux = new ArrayList<Tema>();
        aux.addAll(temaFacade.findAll());
        System.out.println("cantidad: " + temaFacade.count());
        materia.setIdMateria(1);
        System.out.println("temas: " + aux.size());
        for (int i = 0; i < aux.size(); i++) {
            if (aux.get(i).getIdMateria().getIdMateria().equals(materia.getIdMateria())) {
                listTemas.add(aux.get(i));
            }
        }
        System.out.println("gg: " + listTemas.size());
    }

    public void cargarTipo(ValueChangeEvent event) {
        Integer temaSelected = ((Integer) event.getNewValue());
        ArrayList<Pregunta> aux = new ArrayList<Pregunta>();
        aux.addAll(preguntaFacade.findAll());
        for (Pregunta varPregunta : aux) {
            if (varPregunta.getIdTema().getIdTema().equals(temaSelected)) {
                listPregunta.add(varPregunta);
            }
        }
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public ArrayList<Materia> getListMaterias() {
        return listMaterias;
    }

    public void setListMaterias(ArrayList<Materia> listMaterias) {
        this.listMaterias = listMaterias;
    }

    public ArrayList<Tema> getListTemas() {
        return listTemas;
    }

    public void setListTemas(ArrayList<Tema> listTemas) {
        this.listTemas = listTemas;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public ArrayList<Pregunta> getListPregunta() {
        return listPregunta;
    }

    public void setListPregunta(ArrayList<Pregunta> listPregunta) {
        this.listPregunta = listPregunta;
    }

}
