/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Jugador.java 644 2006-11-14 20:16:26Z da-romer $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n12_batallaNaval
 * Autor: Mario Sánchez - 21-feb-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package igpac2_Cliente;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Esta es la clase que se encarga de actualizar los tableros, manejar las comunicaciones con el servidor y generar los mensajes con la información del juego para el jugador.<br>
 * Esta clase conoce la parte fija de los mensajes del protocolo de comunicación.<br>
 * <b>inv:</b><br>
 * estadoJuego pertenece a {SIN_CONECTAR, ESPERANDO_LOCAL, ESPERANDO_OPONENTE, ESPERANDO_RESPUESTA}<br>
 * estadoJuego = SIN_CONECTAR => juegoTerminado = true<br>
 * estadoJuego != SIN_CONECTAR => canal != null<br>
 * estadoJuego != SIN_CONECTAR => out != null<br>
 * estadoJuego != SIN_CONECTAR => in != null<br>
 * estadoJuego != SIN_CONECTAR => tableroFlota != null<br>
 * estadoJuego != SIN_CONECTAR => tableroAtaque != null<br>
 * estadoJuego != SIN_CONECTAR => servidor != null<br>
 * estadoJuego != SIN_CONECTAR => mensajesSinLeer != null<br>
 * estadoJuego != SIN_CONECTAR => nombreJugador != null <br>
 * estadoJuego != SIN_CONECTAR => puerto > 0
 */
public class Cliente
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Indica que no se ha establecido la conexión con el servidor para jugar
     */
    public static final int SIN_CONECTAR = 0;

    /**
     * Indica que se está esperando que el jugador local realice una jugada
     */
    public static final int ESPERANDO_LOCAL = 1;

    /**
     * Indica que se está esperando a que el oponente realice una jugada
     */
    public static final int ESPERANDO_OPONENTE = 2;

    /**
     * Indica que se acaba de enviar la jugada del jugador local y se está esperando la respuesta del cliente
     */
    public static final int ESPERANDO_RESPUESTA = 3;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Indica el estado actual del juego
     */
    private int estadoJuego;

    /**
     * Es un indicador para saber si un juego ya terminó
     */
    private boolean juegoTerminado;

    /**
     * El nombre del jugador local
     */
    private String nombreJugador;

    /**
     * La última dirección de servidor al que se conectó
     */
    private String servidor;

    /**
     * El último puerto usado para conectarse
     */
    private int puerto;

    /**
     * Es el nombre del ganador del último encuentro
     */
    private String nombreGanador;

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

    /**
     * Es una colección de mensajes que aún deben ser mostrados al jugador
     */
    private Collection mensajesSinLeer;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Inicializa el juego de Batalla Naval
     */
    public Cliente( )
    {
        mensajesSinLeer = null;
        nombreJugador = "Almirante Nelson";
        servidor = "localhost";
        puerto = 9999;
        estadoJuego = SIN_CONECTAR;
        juegoTerminado = true;
        nombreGanador = "";
        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del jugador
     * @return nombreJugador
     */
    public String darNombreJugador( )
    {
        return nombreJugador;
    }

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
    public void conectar( String nom, String dirServ, int puertoServ ) throws IOException
    {
        nombreJugador = nom;
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

        verificarInvariante( );
    }


    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica el invariante de la clase<br>
     * <b>inv</b><br>
     * estadoJuego pertenece a {SIN_CONECTAR, ESPERANDO_LOCAL, ESPERANDO_OPONENTE, ESPERANDO_RESPUESTA}<br>
     * estadoJuego = SIN_CONECTAR => juegoTerminado = true<br>
     * estadoJuego != SIN_CONECTAR => canal != null<br>
     * estadoJuego != SIN_CONECTAR => out != null<br>
     * estadoJuego != SIN_CONECTAR => in != null<br>
     * estadoJuego != SIN_CONECTAR => tableroFlota != null<br>
     * estadoJuego != SIN_CONECTAR => tableroAtaque != null<br>
     * estadoJuego != SIN_CONECTAR => servidor != null<br>
     * estadoJuego != SIN_CONECTAR => mensajesSinLeer != null<br>
     * estadoJuego != SIN_CONECTAR => nombreJugador != null <br>
     * estadoJuego != SIN_CONECTAR => puerto > 0
     */
    private void verificarInvariante( )
    {
        assert ( estadoJuego == SIN_CONECTAR || estadoJuego == ESPERANDO_LOCAL || estadoJuego == ESPERANDO_OPONENTE || estadoJuego == ESPERANDO_RESPUESTA ) : "El estado no es válido";
        if( estadoJuego == SIN_CONECTAR )
            assert juegoTerminado : "Valor inválido de atributo juegoTerminado";
        else
        {
            assert ( canal == null ) : "Si el estado es SIN_CONECTAR, entonces no hay conexión";
            assert ( out == null ) : "Si el estado es SIN_CONECTAR, entonces no hay conexión";
            assert ( in == null ) : "Si el estado es SIN_CONECTAR, entonces no hay conexión";
            assert ( servidor != null ) : "La dirección del servidor no puede ser null";
            assert ( mensajesSinLeer != null ) : "La lista de mensajes no puede ser null";
            assert ( nombreJugador != null ) : "El nombre del jugador no puede ser null";
            assert ( puerto > 0 ) : "El puerto debe ser mayor a 0";
        }
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