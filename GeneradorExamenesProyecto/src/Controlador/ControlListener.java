/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Tema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Yerard
 */
public class ControlListener implements ActionListener{
	private Tema tema;
	
	public ControlListener(Tema tema1) {
		this.tema = tema1;
		
	}

	@Override
	public void actionPerformed(ActionEvent  select) 
        {
            if(select.getActionCommand().equals("Sistemas Naturales"))
            {
                tema = Ftemas("Sistemas Naturales");
		}
		//if(boton.getActionCommand().equals("Salir")){
		//	vista.dispose();
		}
	}
