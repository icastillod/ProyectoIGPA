/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: ThreadConectar.java 640 2006-11-14 06:06:59Z da-romer $ 
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Todos los derechos reservados 2005 
 *
 * Proyecto Cupi2 
 * Ejercicio: n12_batallaNaval 
 * Autor: Mario Sánchez - 27/02/2006 
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
public class ThreadConectar extends Thread
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
     * @param juego Es una referencia al juego - juego != null
     * @param interfaz Es una referencia a la ventana principal de la aplicación - interfaz != null
     * @param nombreJugador El nombre que utilizará el jugador - nombreJugador != null
     * @param direccionServidor La dirección para localizar al servidor - direccionServidor != null
     * @param puertoServidor El puerto a través del cual se realizará la conexión con el servidor - puertoServidor != null
     */
    public ThreadConectar( String nombreJugador, String direccionServidor, int puertoServidor )
    {
        nombre = nombreJugador;
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
            Logger.getLogger(ThreadConectar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
