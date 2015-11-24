package com.WebIGPA.Cotroller;

import com.WebIGPA.Entitys.Materia;
import com.WebIGPA.Entitys.NumeroPregunta;
import com.WebIGPA.Entitys.Pregunta;
import com.WebIGPA.Entitys.Respuesta;
import com.WebIGPA.Entitys.SingletonPregunta;
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
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
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
    private ArrayList<Pregunta> listPreguntaFinales;

    private ArrayList<NumeroPregunta> listTipoPregutaFV;
    private ArrayList<NumeroPregunta> listTipoPregutaSMU;
    private ArrayList<NumeroPregunta> listComplejidadFacil;
    private ArrayList<NumeroPregunta> listComplejidadMedia;
    private ArrayList<NumeroPregunta> listComplejidadDificil;

    private int cantidadPreguntasFV;
    private int cantidadPreguntasSM;
    private int cantidadSeleccionadaFV;
    private int cantidadSeleccionadaSM;
    private int complejidadPreguntaF;
    private int complejidadPreguntaM;
    private int complejidadPreguntaD;
    private int complejidadSeleccionadaF;
    private int complejidadSeleccionadaM;
    private int complejidadSeleccionadaD;

    SingletonPregunta instance = SingletonPregunta.getInstance();

    public FormularioController() {
        materia = new Materia();
        tema = new Tema();
        respuesta = new Respuesta();
        tipopregunta = new Tipopregunta();

        listMaterias = new ArrayList<Materia>();
        listTemas = new ArrayList<Tema>();
        listPregunta = new ArrayList<Pregunta>();
        listPreguntaFinales = new ArrayList<Pregunta>();
        listTipoPregutaFV = new ArrayList<NumeroPregunta>();
        listTipoPregutaSMU = new ArrayList<NumeroPregunta>();
        listComplejidadFacil = new ArrayList<NumeroPregunta>();
        listComplejidadMedia = new ArrayList<NumeroPregunta>();
        listComplejidadDificil = new ArrayList<NumeroPregunta>();
    }

    @PostConstruct
    public void init() {
        //System.out.println("asdasda:: " + materiaFacade.findAll().size());
        listMaterias.addAll(materiaFacade.findAll());
    }

    public String comunicar() {
        return "/faces/examen.xhtml";
    }

    public void pruebaTema(ValueChangeEvent event) {
        instance.setCantidadFV(0);
        instance.setCantidadSM(0);
        instance.setComplejidadDificil(0);
        instance.setComplejidadMedia(0);
        instance.setComplejidadFacil(0);
        Integer materiaSelect = ((Integer) event.getNewValue());
        //System.out.println(materiaSelect);
        ArrayList<Tema> aux = new ArrayList<Tema>();
        aux.addAll(temaFacade.findAll());
        //System.out.println("cantidad: " + temaFacade.count());
        materia.setIdMateria(materiaSelect);
        //System.out.println("temas: " + aux.size());
        listTemas.clear();
        for (int i = 0; i < aux.size(); i++) {
            if (aux.get(i).getIdMateria().getIdMateria().equals(materia.getIdMateria())) {
                listTemas.add(aux.get(i));
            }
        }
        System.out.println("CAntidad de Temas: " + listTemas.size());
    }

    public void cargarTipo(ValueChangeEvent event) {
        Integer temaSelected = ((Integer) event.getNewValue());
        System.out.println("Id Tema: " + temaSelected);
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
            NumeroPregunta num = new NumeroPregunta();
            if (aux1Pregunta.getIdTipoPregunta().getIdTipoPregunta().equals(1)) {
                num.setCantidad(++banFV);
                listTipoPregutaFV.add(num);
            } else if (aux1Pregunta.getIdTipoPregunta().getIdTipoPregunta().equals(2)) {
                num.setCantidad(++banSMU);
                listTipoPregutaSMU.add(num);
            }
        }
        cantidadPreguntasFV = listTipoPregutaFV.size();
        instance.setCantidadFV(cantidadPreguntasFV);
        cantidadPreguntasSM = listTipoPregutaSMU.size();
        instance.setCantidadSM(cantidadPreguntasSM);
        System.out.println("LFV: " + listTipoPregutaFV.size());
        System.out.println("LSMU: " + listTipoPregutaSMU.size());

        int facil = 0;
        int media = 0;
        int dificil = 0;
        for (Pregunta pregunta : listPregunta) {
            NumeroPregunta num = new NumeroPregunta();
            if (pregunta.getComplejdad() == 1) {
                num.setCantidad(++facil);
                listComplejidadFacil.add(num);
            } else if (pregunta.getComplejdad() == 2) {
                num.setCantidad(++media);
                listComplejidadMedia.add(num);
            } else if (pregunta.getComplejdad() == 3) {
                num.setCantidad(++dificil);
                listComplejidadDificil.add(num);
            }
        }
        int com;
        com = listComplejidadFacil.size();
        cargarFinales(com);
        instance.setComplejidadFacil(com);
        com = listComplejidadMedia.size();
        cargarFinales(com);
        instance.setComplejidadMedia(com);
        com = listComplejidadDificil.size();
        cargarFinales(com);
        instance.setComplejidadDificil(com);
        System.out.println("Complejidad Facil: " + listComplejidadFacil.size());
        System.out.println("Complejidad Media: " + listComplejidadMedia.size());
        System.out.println("Complejidad Dificil: " + listComplejidadDificil.size());

    }

    public void cargarFinales(int com) {
        if (com != 0) {
            for (Pregunta pregunta : listPregunta) {
                if (pregunta.getComplejdad() == com) {
                    instance.add(pregunta);
                }
            }
        }
    }

    public void cargarComplejidad(ValueChangeEvent event) {
        Integer temaSelected = ((Integer) event.getNewValue());
        System.out.println("Numero preguntas: " + temaSelected);
        System.out.println("preguntas: " + listPregunta.size());

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

    public int getCantidadPreguntasFV() {
        return instance.getCantidadFV();
    }

    public void setCantidadPreguntasFV(int cantidadPreguntasFV) {
        this.cantidadPreguntasFV = cantidadPreguntasFV;
    }

    public int getCantidadPreguntasSM() {
        return instance.getCantidadSM();
    }

    public void setCantidadPreguntasSM(int cantidadPreguntasSM) {
        this.cantidadPreguntasSM = cantidadPreguntasSM;
    }

    public ArrayList<NumeroPregunta> getListTipoPregutaFV() {
        return listTipoPregutaFV;
    }

    public void setListTipoPregutaFV(ArrayList<NumeroPregunta> listTipoPregutaFV) {
        this.listTipoPregutaFV = listTipoPregutaFV;
    }

    public ArrayList<NumeroPregunta> getListTipoPregutaSMU() {
        return listTipoPregutaSMU;
    }

    public void setListTipoPregutaSMU(ArrayList<NumeroPregunta> listTipoPregutaSMU) {
        this.listTipoPregutaSMU = listTipoPregutaSMU;
    }

    public SingletonPregunta getInstance() {
        return instance;
    }

    public void setInstance(SingletonPregunta instance) {
        this.instance = instance;
    }

    public int getCantidadSeleccionadaFV() {
        return cantidadSeleccionadaFV;
    }

    public void setCantidadSeleccionadaFV(int cantidadSeleccionadaFV) {
        this.cantidadSeleccionadaFV = cantidadSeleccionadaFV;
    }

    public int getCantidadSeleccionadaSM() {
        return cantidadSeleccionadaSM;
    }

    public void setCantidadSeleccionadaSM(int cantidadSeleccionadaSM) {
        this.cantidadSeleccionadaSM = cantidadSeleccionadaSM;
    }

    public int getComplejidadSeleccionadaF() {
        return instance.getComplejidadFacil();
    }

    public void setComplejidadSeleccionadaF(int complejidadSeleccionadaF) {
        this.complejidadSeleccionadaF = complejidadSeleccionadaF;
    }

    public int getComplejidadSeleccionadaM() {
        return instance.getComplejidadMedia();
    }

    public void setComplejidadSeleccionadaM(int complejidadSeleccionadaM) {
        this.complejidadSeleccionadaM = complejidadSeleccionadaM;
    }

    public int getComplejidadSeleccionadaD() {
        return instance.getComplejidadDificil();
    }

    public void setComplejidadSeleccionadaD(int complejidadSeleccionadaD) {
        this.complejidadSeleccionadaD = complejidadSeleccionadaD;
    }

    public int getComplejidadPreguntaF() {
        return complejidadPreguntaF;
    }

    public void setComplejidadPreguntaF(int complejidadPreguntaF) {
        this.complejidadPreguntaF = complejidadPreguntaF;
    }

    public int getComplejidadPreguntaM() {
        return complejidadPreguntaM;
    }

    public void setComplejidadPreguntaM(int complejidadPreguntaM) {
        this.complejidadPreguntaM = complejidadPreguntaM;
    }

    public int getComplejidadPreguntaD() {
        return complejidadPreguntaD;
    }

    public void setComplejidadPreguntaD(int complejidadPreguntaD) {
        this.complejidadPreguntaD = complejidadPreguntaD;
    }

    public ArrayList<Pregunta> getListPreguntaFinales() {
        return instance.getListPreguntaFinales();
    }

    public void setListPreguntaFinales(ArrayList<Pregunta> listPreguntaFinales) {
        this.listPreguntaFinales = listPreguntaFinales;
    }

}
