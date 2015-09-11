package Modelo;

import Vista.GraUserInterface;
import java.awt.Dialog;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Yerard
 * @version 1.0
 * @created 25-Ago.-2015 8:46:24 p. m.
 */
public class Cuestionario extends Clonable 
{
    private PreguntaSelMultiple[] Preg;
    private GraUserInterface areaArchivo;

    
    
    public Cuestionario()
    {   
        
    }
    
    public Cuestionario(int facil, int media, int interesante)
    {
        int p = facil+media+interesante;
        for(int i=0; i<p; i++)
        {
            Modelo.solucion examen;
            examen = new solucion(i);
        }      
        
    }
    

    public void finalize() throws Throwable 
    {
    
    }

    public Cuestionario clonarCuestionario()
    {
	return null;
    }

    private String toString(Pregunta preg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}