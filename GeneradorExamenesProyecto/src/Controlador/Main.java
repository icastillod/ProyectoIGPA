
package Controlador;

import Modelo.Archivo;

public class Main {

    public static void main(String[] args) {
        //leer un TXT
        
        Archivo a = new Archivo();
        String s1 = a.leerGrafico();//Ruta del A
        
        System.out.println(s1);
    }
}
