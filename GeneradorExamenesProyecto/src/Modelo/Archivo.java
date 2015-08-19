package Modelo;

import java.io.*;

public class Archivo 
{
    public String leerTxt(String direccion) //direccion del archivo
    {
        String texto = "";
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            while((bfRead = bf.readLine()) != null){ 
                //haz el ciclo, mientras bfRead tiene datos
                temp = temp + bfRead; //guardado el texto del archivo
            }
            texto = temp;
        }catch(Exception e){ 
            System.err.println("No se encontro archivo");
        }
        return texto;
    }
    
    public  String leerGrafico()
    {
        File f;
        javax.swing.JFileChooser j= new javax.swing.JFileChooser();
        j.showOpenDialog(j);
        try{
            String path= j.getSelectedFile().getAbsolutePath();
            String lectura="";
            f = new File(path);
        try{
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String aux;
            while((aux = br.readLine())!=null)
            lectura = lectura+aux+"n";
        }catch(IOException e){}
        return lectura;
        }catch(NullPointerException e){
            javax.swing.JOptionPane.showMessageDialog(j, "Has seleccionado cerrar programa, saliendo...");
            System.exit(0);
        }return null;
    }
}
