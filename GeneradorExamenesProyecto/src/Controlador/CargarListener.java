package Controlador;

import Modelo.Cuestionario;
import java.awt.event.*;
import javax.swing.*;
import Modelo.Pregunta;
import Vista.GraUserInterface;

/**
 *
 * @author Yerard
 */
public class CargarListener implements ActionListener 
{
    private GraUserInterface vista;
    private Cuestionario modelocuestionario;

    public CargarListener(GraUserInterface vista, Cuestionario modelocuestionario) {
        this.vista = vista;
        this.modelocuestionario = modelocuestionario;
    }

    public CargarListener (int facil, int media, int interesante)
    {
        JOptionPane.showMessageDialog(null, facil + media + interesante);
    }
    
    
        //@Override
   /* public void actionPerformed(ActionEvent boton) {
            if(boton.getActionCommand().equals("GENERAR EXAMEN")){
                    modelocuestionario.crearCuestionario();			
		
            }else{
                    modeloDatos.setFuente(abrirArchivo());
                    //modeloDatos.setFuente(leerTxt("Tabla.txt"));
                    vista.setFuente(modeloDatos.getFuente());
            }
            if(modeloDatos.listo())
                    vista.activarAnalisis();

    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void actionPerformed(CargarListener CargarListener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}