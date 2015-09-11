package Controlador;

import Modelo.Cuestionario;
import java.awt.event.*;
import javax.swing.*;
import Modelo.Pregunta;
import Vista.GraUserInterface;
import static java.lang.Integer.getInteger;

/**
 *
 * @author Yerard
 */
public class CargarListener implements ActionListener 
{
    private GraUserInterface vista;
    private Cuestionario modelocuestionario;
    private int nCuestion;

    public CargarListener(GraUserInterface vista, Cuestionario modelocuestionario) {
        this.vista = vista;
        this.modelocuestionario = modelocuestionario;
    }

    public CargarListener (int facil, int media, int interesante)
    {
        String ax = JOptionPane.showInputDialog(null, "Ingrese el numero de examenes a generar: ", "Examenes", JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Error al generar los examenes", "Examenes", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
        //vista.imprirPreguntas(ax);
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