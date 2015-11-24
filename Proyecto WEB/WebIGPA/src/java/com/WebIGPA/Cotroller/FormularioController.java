/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WebIGPA.Cotroller;

import com.WebIGPA.Entitys.Materia;
import com.WebIGPA.Entitys.Pregunta;
import com.WebIGPA.Entitys.Respuesta;
import com.WebIGPA.Entitys.Tema;
import com.WebIGPA.Entitys.Tipopregunta;
import com.WebIGPA.Negocio.MateriaFacade;
import com.WebIGPA.Negocio.PreguntaFacade;
import com.WebIGPA.Negocio.RespuestaFacade;
import com.WebIGPA.Negocio.TemaFacade;
import com.WebIGPA.Negocio.TipopreguntaFacade;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Yerard
 */
@Named(value = "formurioCotroller")
@Dependent
@ManagedBean
@ViewScoped
public class FormularioController implements Serializable {

    @EJB
    private RespuestaFacade respuestaFacade;

    @EJB
    private TipopreguntaFacade tipopreguntaFacade;

    @EJB
    private PreguntaFacade preguntaFacade;

    @EJB
    private TemaFacade temaFacade;

    @EJB
    private MateriaFacade materiaFacade;

    private Materia materia;
    private Tema tema;
    private Pregunta pregunta;
    private Respuesta respuesta;
    private Tipopregunta tipopregunta;

    private ArrayList<Materia> listMaterias;
    private ArrayList<Tema> listTemas;
    private ArrayList<Pregunta> listPregunta;
    private ArrayList<Respuesta> listRepuesta;

    private ArrayList<Integer> listTipoPregutaFV;
    private ArrayList<Integer> listTipoPregutaSMU;

    public FormularioController() {
        materia = new Materia();
        tema = new Tema();
        respuesta = new Respuesta();
        tipopregunta = new Tipopregunta();

        listMaterias = new ArrayList<Materia>();
        listTemas = new ArrayList<Tema>();
        listPregunta = new ArrayList<Pregunta>();
        listTipoPregutaFV = new ArrayList<Integer>();
        listTipoPregutaSMU = new ArrayList<Integer>();
    }

    @PostConstruct
    public void init() {
        //System.out.println("asdasda:: " + materiaFacade.findAll().size());
        listMaterias.addAll(materiaFacade.findAll());
    }

    public void comunicar() {
        System.out.println("asdasda:: " + materiaFacade.findAll().size());
        listMaterias.addAll(materiaFacade.findAll());
    }

    public void pruebaTema(ValueChangeEvent event) {
        Integer materiaSelect = ((Integer) event.getNewValue());
        //System.out.println(materiaSelect);
        ArrayList<Tema> aux = new ArrayList<Tema>();
        aux.addAll(temaFacade.findAll());
        //System.out.println("cantidad: " + temaFacade.count());
        materia.setIdMateria(materiaSelect);
        //System.out.println("temas: " + aux.size());
        for (int i = 0; i < aux.size(); i++) {
            if (aux.get(i).getIdMateria().getIdMateria().equals(materia.getIdMateria())) {
                listTemas.add(aux.get(i));
            }
        }
        System.out.println("CAntidad de Temas: " + listTemas.size());
    }

    /*public void cargarTipoPregunta(ValueChangeEvent event) {
        Integer preguntaSelect = ((Integer) event.getNewValue());
        System.out.println(preguntaSelect);
        ArrayList<Tipopregunta> auxTipo = new ArrayList<Tipopregunta>();
        auxTipo.addAll(tipopreguntaFacade.findAll());
        System.out.println("cantidad: " + tipopreguntaFacade.count());
        System.out.println("Tipos de Pregunta: " + auxTipo.size());
        for (int i = 0; i < auxTipo.size(); i++) {
            if (auxTipo.get(i).getIdTipoPregunta().equals(materia.getIdMateria())) {
               // listTemas.add(auxTipo.get(i));
            }
        }
        System.out.println("gg: " + listTemas.size());
    }*/
    public void cargarTipo(ValueChangeEvent event) {
        Integer temaSelected = ((Integer) event.getNewValue());
        System.out.println("Id Tema: "+temaSelected);
        ArrayList<Pregunta> aux = new ArrayList<Pregunta>();
        aux.addAll(preguntaFacade.findAll());
        for (Pregunta varPregunta : aux) {
            if (varPregunta.getIdTema().getIdTema().equals(temaSelected)) {
                listPregunta.add(varPregunta);
            }
        }
        System.out.println("LP: " + listPregunta.size());
        int banFV = 0;
        int banSMU = 0;
        for (Pregunta aux1Pregunta : listPregunta) {
            if (aux1Pregunta.getIdTipoPregunta().getIdTipoPregunta().equals(1)) {
                listTipoPregutaFV.add(++banFV);
            } else if (aux1Pregunta.getIdTipoPregunta().getIdTipoPregunta().equals(2)) {
                listTipoPregutaSMU.add(++banSMU);
            }
        }
        System.out.println("LFV: " + listTipoPregutaFV.size());
        
        System.out.println("LSMU: " + listTipoPregutaSMU.size());
    }

    public void cargarComplejidad(ValueChangeEvent event){
        Integer temaSelected = ((Integer) event.getNewValue());
        System.out.println("Numero preguntas: "+temaSelected);
    }
    /* public void cargarComplejidad(ValueChangeEvent event) {
        Integer complefidadFacil = ((Integer) event.getNewValue());
        Integer complefidadMedia = ((Integer) event.getNewValue());
        Integer complefidadDificil = ((Integer) event.getNewValue());
        System.out.println(complefidadFacil);
        System.out.println(complefidadMedia);
        System.out.println(complefidadDificil);
        ArrayList<Pregunta> facil = new ArrayList<Pregunta>();
        ArrayList<Pregunta> media = new ArrayList<Pregunta>();
        ArrayList<Pregunta> dificil = new ArrayList<Pregunta>();
        facil.addAll(preguntaFacade.findAll());
        media.addAll(preguntaFacade.findAll());
        dificil.addAll(preguntaFacade.findAll());
        System.out.println("cantidad: " + preguntaFacade.count());
        materia.setIdMateria(materiaSelect);
        System.out.println("temas: " + aux.size());
        for (int i = 0; i < aux.size(); i++) {
            if (aux.get(i).getIdMateria().getIdMateria().equals(materia.getIdMateria())) {
                listTemas.add(aux.get(i));
            }
        }
        System.out.println("gg: " + listTemas.size());
    }
     */
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

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public ArrayList<Respuesta> getListRepuesta() {
        return listRepuesta;
    }

    public void setListRepuesta(ArrayList<Respuesta> listRepuesta) {
        this.listRepuesta = listRepuesta;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    public Tipopregunta getTipopregunta() {
        return tipopregunta;
    }

    public void setTipopregunta(Tipopregunta tipopregunta) {
        this.tipopregunta = tipopregunta;
    }

    public ArrayList<Integer> getListTipoPregutaFV() {
        return listTipoPregutaFV;
    }

    public void setListTipoPregutaFV(ArrayList<Integer> listTipoPregutaFV) {
        this.listTipoPregutaFV = listTipoPregutaFV;
    }

    public ArrayList<Integer> getListTipoPregutaSMU() {
        return listTipoPregutaSMU;
    }

    public void setListTipoPregutaSMU(ArrayList<Integer> listTipoPregutaSMU) {
        this.listTipoPregutaSMU = listTipoPregutaSMU;
    }

}
