/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Central
 *
 * Proyecto IGPA
 * Ejercicio: 
 * Autor: Ivonne , Gerardo
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package igpac2_Cliente;

import igpac2_GUICliente.GUICliente;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase implementa lo que se debe hacer en un hilo de ejecución cuando se quiere conectar al cliente con el servidor.
 */
public class Conexion extends Thread
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la referencia al juego
     */
    private Cliente cliente;

    /**
     * Es la referencia a la ventana principal de la aplicación
     */
    private GUICliente principal;

    /**
     * El nombre que utilizará el jugador
     */
    private String nombre;

    /**
     * La dirección para localizar al servidor
     */
    private String servidor;

    /**
     * El puerto a través del cual se realizará la conexión con el servidor
     */
    private int puerto;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el nuevo hilo y lo deja listo para conectarse al servidor
     * @param nombreCliente El nombre que utilizará el jugador - nombreJugador != null
     * @param direccionServidor La dirección para localizar al servidor - direccionServidor != null
     * @param puertoServidor El puerto a través del cual se realizará la conexión con el servidor - puertoServidor != null
     */
    public Conexion( String nombreCliente, String direccionServidor, int puertoServidor )
    {
        nombre = nombreCliente;
        servidor = direccionServidor;
        puerto = puertoServidor;
    }

    // -----------------------------------------------------------------
    // métodos
    // -----------------------------------------------------------------

    /**
     * Inicia la ejecución del hilo que realiza la conexión con el servidor e incializa el tablero.<br>
     * Cuando se tiene la conexión y la información del tablero entonces se actualiza la interfaz.
     */
    public void run( )
    {
        try {
            cliente.conectar( nombre, servidor, puerto );
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
