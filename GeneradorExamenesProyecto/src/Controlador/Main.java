package Controlador;

import Vista.GraUserInterface;
import Modelo.*;


public class Main 
{
    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                new GraUserInterface().setVisible(true);
            }
        });
        
        
        
    }
    
}
