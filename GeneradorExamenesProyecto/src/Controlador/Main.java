package Controlador;

import Vista.GraUserInterface;
import Modelo.*;


public class Main 
{
    public static void main(String args[]) 
    {
        String[] listarespuesta;
        listarespuesta = new String[4];

        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                new GraUserInterface().setVisible(true);
            }
        });
        Pregunta[] preg = new PreguntaSelMultiple[13];
        
        //Pregunta preg1 = new PreguntaSelMultiple();
        preg[0].setComplejidadPregunta("Facil");
        preg[0].setTipoPregunta("Seleccion Multiple");
        preg[0].setEnunciadoPregunta("La mayor parte de los reptiles dependen de la temperatura ambiental para regular su temperatura corporal, por lo que su producción de calor es baja y su metabolismo lento. Por otro lado los mamíferos no dependen de la temperatura ambiental para regular su temperatura corporal. Teniendo en cuenta esta diferencia usted pensaría que los:");
        
        listarespuesta[0]="mamíferos presentan una menor cantidad de mitocondrias en sus células en comparación con los reptiles";
        listarespuesta[1]="reptiles presentan una menor cantidad de mitocondrias en sus células en comparación con los mamíferos";
        listarespuesta[2]="mamíferos presentan una menor cantidad de ribosomas en sus células en comparación con los reptiles";
        listarespuesta[3]="reptiles presentan una menor cantidad de ribosomas en comparación con los mamíferos";
        
        preg[0].setRespuestas(listarespuesta);
        
        //Pregunta preg2 = new PreguntaSelMultiple();
        preg[1].setComplejidadPregunta("Facil");
        preg[1].setTipoPregunta("Seleccion Multiple");
        preg[1].setEnunciadoPregunta("Donde ocurren las reacciones oscuras y de fijación del carbono ");
        
        listarespuesta[0]="En el citoplasma.";
        listarespuesta[1]="En el estroma del cloroplasto.";
        listarespuesta[2]="En las membranas de los tilacoides.";
        listarespuesta[3]="En las mitocondrias.";
        
        preg[1].setRespuestas(listarespuesta);
        
        //Pregunta preg3 = new PreguntaSelMultiple();
        preg[2].setComplejidadPregunta("Facil");
        preg[2].setTipoPregunta("Seleccion Multiple");
        preg[2].setEnunciadoPregunta("Cuál de los siguientes enunciados NO es correcto en relación con el aparato de Golgi :");
        
        listarespuesta[0]="Es un conjunto especializado de sacos membranosos que se originan a partir del Retículo endoplasmático.";
        listarespuesta[1]="Separa la proteínas y los lípidos que se reciben del Retículo endoplasmático de acuerdo con su destino.";
        listarespuesta[2]="Empaca algunos materiales en vesículas que son transportadoras a otras partes de la célula o de la membrana plasmática.";
        listarespuesta[3]="Son vesículas membranosas que digieren partículas alimenticias, que van desde proteínas hasta microorganismos.";
        
        preg[2].setRespuestas(listarespuesta);
        
        //Pregunta preg4 = new PreguntaSelMultiple();
        preg[3].setComplejidadPregunta("Facil");
        preg[3].setTipoPregunta("Seleccion Multiple");
        preg[3].setEnunciadoPregunta("Cuál de los siguientes enunciados SI es correcto en relación con la mitocondria :");
        
        listarespuesta[0]="Son las estructuras encargadas de la producción de energía mediante metabolismo aeróbico, ausente en procariotas, presente animales y plantas.";
        listarespuesta[1]="Son las estructuras encargadas de la producción de energía mediante metabolismo anaeróbico, presente en procariotas, animales y plantas.";
        listarespuesta[2]="Son las estructuras encargadas de sintetizar las proteínas presente en procariotas, animales y plantas.";
        listarespuesta[3]="Contienen alimentos que se obtienen a través de fagocitosis, ausente en procariotas, presente animales y plantas.";
        
        preg[3].setRespuestas(listarespuesta);
        
        //Pregunta preg[4] = new PreguntaSelMultiple();
        preg[4].setComplejidadPregunta("Media");
        preg[4].setTipoPregunta("Seleccion Multiple");
        preg[4].setEnunciadoPregunta("Son características de la célula eucariota :");
        
        listarespuesta[0]="Carece de núcleo definido y envoltura nuclear.";
        listarespuesta[1]="Contiene un núcleo con membrana nuclear definida.";
        listarespuesta[2]="Contiene vacuola que en la mayoría de los casos contiene agua, membrana celular y citoplasma.";
        listarespuesta[3]="Contienen ribosomas  que sintetizan las proteínas para el matabolismo celular.";
        
        preg[4].setRespuestas(listarespuesta);
        
        //Pregunta preg[5] = new PreguntaSelMultiple();
        preg[5].setComplejidadPregunta("Media");
        preg[5].setTipoPregunta("Seleccion Multiple");
        preg[5].setEnunciadoPregunta("Cuál de las siguientes evidencias demostraría que una substancia entra a una célula mediante transporte activo en lugar de hacerlo por pasivo ?");
        
        listarespuesta[0]="La substancia entra a la célula cuando su concentración es más alta afuera que adentro.";
        listarespuesta[1]="Se requiere rompimiento de ATP para que la sustancia se mueva hacia dentro de la célula.";
        listarespuesta[2]="La substancia entra a la célula cuando su concentración es más baja afuera que adentro.";
        listarespuesta[3]="Todas las anteriores.";
        
        preg[5].setRespuestas(listarespuesta);
        
        //Pregunta preg[6] = new PreguntaSelMultiple();
        preg[6].setComplejidadPregunta("Media");
        preg[6].setTipoPregunta("Seleccion Multiple");
        preg[6].setEnunciadoPregunta("Cuál de las siguientes evidencias demostraría que una substancia entra a una célula mediante transporte activo en lugar de hacerlo por pasivo ?");
        
        listarespuesta[0]="La substancia entra a la célula cuando su concentración es más alta afuera que adentro.";
        listarespuesta[1]="Se requiere rompimiento de ATP para que la sustancia se mueva hacia dentro de la célula.";
        listarespuesta[2]="La substancia entra a la célula cuando su concentración es más baja afuera que adentro.";
        listarespuesta[3]="Todas las anteriores.";
        
        preg[6].setRespuestas(listarespuesta);
        
  
       // Pregunta preg[7] = new PreguntaSelMultiple();
        preg[7].setComplejidadPregunta("Media");
        preg[7].setTipoPregunta("Seleccion Multiple");
        preg[7].setEnunciadoPregunta("Es característico de plantas tipo  C4 :");
        
        listarespuesta[0]="Fijación de carbono en 2 pasos.";
        listarespuesta[1]="Fijación de carbono en 1 paso.";
        listarespuesta[2]="Interviene 1 molécula de Fosfoenolpiruvato de 4 C";
        listarespuesta[3]="No producen Glucosa.";
        
        preg[7].setRespuestas(listarespuesta);
        
        
       // Pregunta preg[8] = new PreguntaSelMultiple();
        preg[8].setComplejidadPregunta("Media");
        preg[8].setTipoPregunta("Seleccion Multiple");
        preg[8].setEnunciadoPregunta("Donde se produce la glucólisis?");
        
        listarespuesta[0]="En el citoplasma.";
        listarespuesta[1]="En la matriz mitocondrial.";
        listarespuesta[2]="En la membrana interna de las mitocondrias.";
        listarespuesta[3]="En los cloroplastos.";
        
        preg[8].setRespuestas(listarespuesta);
        
        
       // Pregunta preg[9] = new PreguntaSelMultiple();
        preg[9].setComplejidadPregunta("Interesante");
        preg[9].setTipoPregunta("Seleccion Multiple");
        preg[9].setEnunciadoPregunta("Cuales son los productos importantes de la fermentación del jugo de uva por los hongos esenciales para la producción de champaña?");
        
        listarespuesta[0]="Ácido Láctico y NAD+.";
        listarespuesta[1]="ATP y CO2.";
        listarespuesta[2]="ATP y etanol.";
        listarespuesta[3]="CO2 y etanol.";
        
        preg[9].setRespuestas(listarespuesta);
        
        
       // Pregunta preg[10] = new PreguntaSelMultiple();
        preg[10].setComplejidadPregunta("Interesante");
        preg[10].setTipoPregunta("Seleccion Multiple");
        preg[10].setEnunciadoPregunta("Casi todo el ATP producido en la respiración aeróbica proviene de");
        
        listarespuesta[0]="Glucólisis.";
        listarespuesta[1]="El ciclo del ácido Cítrico.";
        listarespuesta[2]="El sistema de transporte de electrones.";
        listarespuesta[3]="Fermentación.";
        
        preg[10].setRespuestas(listarespuesta);
        
        
     //   Pregunta preg[11] = new PreguntaSelMultiple();
        preg[11].setComplejidadPregunta("Interesante");
        preg[11].setTipoPregunta("Seleccion Multiple");
        preg[11].setEnunciadoPregunta("Un conjunto de canales membranosos, rodeados de ribosomas reciben el nombre de :");
        
        listarespuesta[0]="Lisosomas.";
        listarespuesta[1]="Aparato de Golgi";
        listarespuesta[2]="Retículo endoplásmico rugoso.";
        listarespuesta[3]="etículo endoplásmico liso.";
        
        preg[11].setRespuestas(listarespuesta);
        
        
       // Pregunta preg[12] = new PreguntaSelMultiple();
        preg[12].setComplejidadPregunta("Interesante");
        preg[12].setTipoPregunta("Seleccion Multiple");
        preg[12].setEnunciadoPregunta("Si una célula animal se coloca en una solución cuya concentración de solutos es mayor que la que se encuentra en el interior de la célula :");
        
        listarespuesta[0]="La célula se hinchará.";
        listarespuesta[1]="La célula se encogerá.";
        listarespuesta[2]="La célula permanecerá del mismo tamaño.";
        listarespuesta[3]="La solución se describe como hipertónica.";
        
        preg[12].setRespuestas(listarespuesta);  
        
    }
    
}
