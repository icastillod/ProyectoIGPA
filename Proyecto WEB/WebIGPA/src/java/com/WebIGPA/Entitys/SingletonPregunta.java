/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WebIGPA.Entitys;

import java.util.ArrayList;

/**
 *
 * @author Yerard
 */
public class SingletonPregunta {

    private static SingletonPregunta instance = null;
    private static int cantidadFV;
    private static int cantidadSM;
    private static int complejidadFacil;
    private static int complejidadMedia;
    private static int complejidadDificil;
    private static ArrayList<Pregunta> listPreguntaFinales;

    private SingletonPregunta() {

    }

    public static synchronized SingletonPregunta getInstance() {
        if (instance == null) {
            instance = new SingletonPregunta();
            listPreguntaFinales = new ArrayList<Pregunta>();
        }
        return instance;
    }

    public void add(Pregunta pregunta) {
        listPreguntaFinales.add(pregunta);
    }

    public static int getCantidadFV() {
        return cantidadFV;
    }

    public static void setCantidadFV(int cantidadFV) {
        SingletonPregunta.cantidadFV = cantidadFV;
    }

    public static int getCantidadSM() {
        return cantidadSM;
    }

    public static void setCantidadSM(int cantidadSM) {
        SingletonPregunta.cantidadSM = cantidadSM;
    }

    public static int getComplejidadFacil() {
        return complejidadFacil;
    }

    public static void setComplejidadFacil(int complejidadFacil) {
        SingletonPregunta.complejidadFacil = complejidadFacil;
    }

    public static int getComplejidadMedia() {
        return complejidadMedia;
    }

    public static void setComplejidadMedia(int complejidadMedia) {
        SingletonPregunta.complejidadMedia = complejidadMedia;
    }

    public static int getComplejidadDificil() {
        return complejidadDificil;
    }

    public static void setComplejidadDificil(int complejidadDificil) {
        SingletonPregunta.complejidadDificil = complejidadDificil;
    }

    public static ArrayList<Pregunta> getListPreguntaFinales() {
        return listPreguntaFinales;
    }

    public static void setListPreguntaFinales(ArrayList<Pregunta> listPreguntaFinales) {
        SingletonPregunta.listPreguntaFinales = listPreguntaFinales;
    }

}
