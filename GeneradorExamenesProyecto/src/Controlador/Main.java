
package Controlador;

import Modelo.Archivo;
import Vista.GraUserInterface;
import Modelo.Tema;

public class Main 
{
    public static void main(String args[]) 
    {
        
        
        
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new GraUserInterface().setVisible(true);
            }
        });
    } 
}
