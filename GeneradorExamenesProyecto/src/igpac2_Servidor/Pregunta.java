package igpac2_Servidor;

/**
 * @author 
 * @version 1.0
 * @created 18-Oct.
 */
public class Pregunta implements FabricaPregunta {

	private String enunciadoPregunta;
	private Respuesta [ ] respuesta;
	private String complejidad;
	private float procentaje;
	private TipoPregunta tipoPregunta;
	private boolean estPregunta;
	public Tema m_Tema;
	public Respuesta m_Respuesta;
	public TipoPregunta m_TipoPreguta;



	public void finalize() throws Throwable {

	}
	public void Pregunta(){

	}

    /**
     *
     * @return
     */
        public TipoPregunta getTipoPregunta(){
		return null;
	}

	public Pregunta modificarPregunta(){
		return null;
	}

	public Respuesta solicitarRespuestas(){
		return null;
	}

	public Pregunta getPregunta(){
		return null;
	}

	public Pregunta setPregunta(){
		return null;
	}

    @Override
    public Pregunta crearPregunta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}//end Pregunta