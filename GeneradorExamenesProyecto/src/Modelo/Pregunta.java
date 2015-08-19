/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Yerard
 */
public abstract class Pregunta {

	private String tipoPregunta;
	private String complejidadPregunta;
	private int enunciadoPregunta;
	public Respuestas m_Respuestas;

	public Pregunta(){

	}

	public void finalize() throws Throwable {

	}

    public String getTipoPregunta() {
        return tipoPregunta;
    }

    public void setTipoPregunta(String tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    public String getComplejidadPregunta() {
        return complejidadPregunta;
    }

    public void setComplejidadPregunta(String complejidadPregunta) {
        this.complejidadPregunta = complejidadPregunta;
    }

    public int getEnunciadoPregunta() {
        return enunciadoPregunta;
    }

    public void setEnunciadoPregunta(int enunciadoPregunta) {
        this.enunciadoPregunta = enunciadoPregunta;
    }

    public Respuestas getM_Respuestas() {
        return m_Respuestas;
    }

    public void setM_Respuestas(Respuestas m_Respuestas) {
        this.m_Respuestas = m_Respuestas;
    }
        
        
}//end Pregunta