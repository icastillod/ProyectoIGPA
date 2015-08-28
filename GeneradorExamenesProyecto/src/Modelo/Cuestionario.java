package Modelo;

import java.awt.Dialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Yerard
 * @version 1.0
 * @created 25-Ago.-2015 8:46:24 p. m.
 */
public class Cuestionario extends Clonable 
{
    
    public Cuestionario()
    {

    }
    
    public void crearCuestionario(int facil, int media, int interesante)
    {
        JOptionPane.showMessageDialog(null, facil + media + interesante);
    }
    

    public void finalize() throws Throwable 
    {
    
    }

    public Cuestionario clonarCuestionario()
    {
	return null;
    }
    
}