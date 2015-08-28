package Modelo;

public abstract class Pregunta {

	private String tipoPregunta;
	private String complejidadPregunta;
	private String enunciadoPregunta;
	private String[] respuestas = new String[4];

    public Pregunta(String tipoPregunta, String complejidadPregunta, String enunciadoPregunta, String[] respuestas) {
        this.tipoPregunta = tipoPregunta;
        this.complejidadPregunta = complejidadPregunta;
        this.enunciadoPregunta = enunciadoPregunta;
        this.respuestas = respuestas;
    }
    
    public Pregunta(){
    }

    public String getTipoPregunta() {
        return tipoPregunta;
    }

    public String getComplejidadPregunta() {
        return complejidadPregunta;
    }

    public String getEnunciadoPregunta() {
        return enunciadoPregunta;
    }

    public String[] getRespuestas() {
        return respuestas;
    }

    public void setTipoPregunta(String tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    public void setComplejidadPregunta(String complejidadPregunta) {
        this.complejidadPregunta = complejidadPregunta;
    }

    public void setEnunciadoPregunta(String enunciadoPregunta) {
        this.enunciadoPregunta = enunciadoPregunta;
    }

    public void setRespuestas(String[] respuestas) {
        this.respuestas = respuestas;
    }

	        
}