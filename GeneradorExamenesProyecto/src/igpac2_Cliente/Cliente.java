/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Central
 *
 * Proyecto IGPA
 * Ejercicio: 
 * Autor: Ivonne , Gerardo
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package igpac2_Cliente;

import java.io.*;
import java.net.*;
import java.util.*;

public class Cliente
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Indica que no se ha establecido la conexión con el servidor
     */
    public static final int SIN_CONECTAR = 0;

    /**
     * Indica que se está esperando que el jugador local realice
     */
    public static final int ESPERANDO_LOCAL = 1;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Indica el estado de la conexion
     */
    private int estado;

    /**
     * La última dirección de servidor al que se conectó
     */
    private String servidor;

    /**
     * El último puerto usado para conectarse
     */
    private int puerto;
  
    /**
     * Es el canal usado para comunicarse con el servidor
     */
    private Socket canal;

    /**
     * El flujo que envía los datos al servidor a través del socketServidor
     */
    private PrintWriter out;

    /**
     * Es el flujo de donde se leen los datos que llegan del servidor a través del socketServidor
     */
    private BufferedReader in;
    
// -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Inicializa el juego de Batalla Naval
     */
    public Cliente( )
    {
        servidor = "localhost";
        puerto = 9999;
    }

    // -----------------------------------------------------------------
    // métodos
    // -----------------------------------------------------------------
    /**
     * Retorna la dirección del servidor
     * @return servidor
     */
    public String darDireccionServidor( )
    {
        return servidor;
    }

    /**
     * Retorna el puerto usado para conectarse al servidor
     * @return puerto
     */
    public int darPuertoServidor( )
    {
        return puerto;
    }

    /**
     * Establece una conexión con el servidor del juego y envía los datos del jugador para poder empezar un juego<br>
     * Este método termina cuando se consigue un oponente y se establece la conexión entre los dos jugadores.
     * @param nom El nombre del jugador local - nombre != null
     * @param dirServ La dirección usada para encontrar el servidor - direccionServidor != null
     * @param puertoServ El puerto usado para realizar la conexión - puertoServidor > 0
     * @throws BatallaNavalException Se lanza esta excepción si hay problemas estableciendo la comunicación
     */
    public void conectar( String dirServ, int puertoServ ) throws IOException
    {
        servidor = dirServ;
        puerto = puertoServ;
            // Conectar al servidor
        	// TODO: Asigne al atributo canal un nuevo socket con la direcion y puerto recibidos por parametro
        	// TODO: asigne al atributo out el canal de escritura del socket
        	// TODO: asigne al atributo in el canal de lectura del socket
        	canal = new Socket( dirServ, puertoServ );
            out = new PrintWriter( canal.getOutputStream( ), true );
            in = new BufferedReader( new InputStreamReader( canal.getInputStream( ) ) );
            
        	// iniciar el encuentro
    }


    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * método para la extensión 1
     * @return respuesta1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * método para la extensión2
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }
}