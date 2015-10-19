package igpac2_Servidor;

/**
 * @author 
 * @version 1.0
 * @created 18-Oct.
 */
public interface FabrExamen {

	public void clonar();

	/**
	 * 
	 * @param cantExam
	 */
	public Examen generarExamen(int cantExam);

}