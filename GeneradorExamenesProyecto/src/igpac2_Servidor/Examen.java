/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Central
 *
 * Proyecto IGPA
 * Ejercicio: 
 * Ejercicio: PRogramador de Examenes
 * Autor: Ivenne Castrillo, Gerardo Rico - 23/02/2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package igpac2_Servidor;

import igpac2_Servidor.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;


/**
 *
 * @author Ivonne, Gerardo
 */
public class Examen implements FabrExamen {
	private int cantPregunta;
	private Pregunta [ ] pregunta;
	public FabricaPregunta m_FabricaPregunta;
	public FlaywExamen m_FlaywExamen;
	public FabrFlayw m_FabrFlayw;

    
	public void Examen(){

	}

	public Pregunta cargarPreguntas(){
		return null;
	}

	public void clonar(){

	}

	/**
	 * 
	 * @param fecha
	 * @param nomProfesor
	 * @param tema
	 * @param materia
	 * @param Pregunta
     * @return 
	 */
	public Examen examen(Date fecha, Profesor nomProfesor, Tema tema, Materia materia, Pregunta [ ] Pregunta){
		return null;
	}

	public void setCantPreguntas(){

	}

    @Override
    public Examen generarExamen(int cantExam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
