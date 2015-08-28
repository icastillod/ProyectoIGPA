package Modelo;


public class PreguntaSelMultiple  extends Pregunta{
    
    private String[] respuestas = new String[4];

    public PreguntaSelMultiple() {
    }

    public PreguntaSelMultiple(String tipoPregunta, String complejidadPregunta, String enunciadoPregunta, String[] respuestas) {
        super(tipoPregunta, complejidadPregunta, enunciadoPregunta, respuestas);
    }
}
