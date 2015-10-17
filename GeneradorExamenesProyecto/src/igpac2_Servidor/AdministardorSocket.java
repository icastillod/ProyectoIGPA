
package igpac2_Servidor;

/**
 *
 * @author Yerard
 */

import java.io.*;
import java.net.*;
import java.sql.*;



public class AdministardorSocket extends Thread{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Mensaje inicial de un cliente
     */
    public static final String CLIENTE = "CLIENTE";

    /**
     * Mensaje con el registro de la conexión
     */
    public static final String CONEXION = "CONEXION";

    /**
     * Mensaje para indicar que se va a cargar la interfaz grafica
     */
    public static final String CARGAR_GUI = "CARGAR_GUI";

    /**
     * Mensaje para enviar la información de la materia para solicitar los temas 
     */
    public static final String CARGAR_TEMA = "CARGAR_TEMA";

    /**
     * Mensaje para mostrar los temas relacionados a la materia seleccionada
     */
    public static final String MOSTRAR_TEMA = "MOSTRAR_TEMA";

    /**
     * Mensaje para mostrar los tipos de preguntas
     */
    public static final String MOSTRAR_TP = "MOSTRAR TP";

    /**
     * Mensaje para indicar la solicitud de creación de exámenes
     */
    public static final String GENERAR_EXAMEN = "GENERAR EXAMEN";

    /**
     * Mensaje para indicar quien fue el ganador del juego
     */
    public static final String MSJ_CONF = "CONFIRMAR";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * El canal usado para comunicarse con el cliente
     */
    private Socket socketCliente;

    /**
     * El flujo de escritura conectado con el cliente
     */
    private PrintWriter out;

    /**
     * El flujo de lectura conectado con el cliente
     */
    private BufferedReader in;

    /**
     * Indica que la finalizacion del programa 
     */
    private boolean finCrear;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    public AdministardorSocket( )
    {

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Retorna el socket usado para comunicarse con el cliente
     * @return socketCliente
     */
    public Socket darSocketCliente() {
        return socketCliente;
    }

    /**
     * Indica si el encuentro ya terminó.
     * @return Retorna true si se generaron los exámenes. Retorna false en caso contrario.
     */
    public boolean examenGenerado( )
    {
        return finCrear;
    }

    /**
     * Obtiene la información de un jugador a partir del mensaje que envió cuando entró al encuentro
     * @param info El mensaje que fue enviado - info es de la forma "JUGADOR:<nombre>"
     * @return Retorna la información del jugador
     * @throws BatallaNavalException Se lanza esta excepción si hay problemas consultando a la base de datos o se recibe un mensaje con un formato inesperado
     */
    private RegistroCliente consultarCliente( String info ) 
    {
        if( info.startsWith( CLIENTE ) )
        {
            String nombre = info.split( ":" )[ 1 ];
            try
            {
                RegistroJugador reg1 = adminResultados.consultarRegistroJugador( nombre );
                return reg1;
            }
            catch( SQLException e )
            {
                throw new BatallaNavalException( "Hubo un problema leyendo la información del jugador: " + e.getMessage( ) );
            }
        }
        else
        {
            throw new BatallaNavalException( "El mensaje no tiene el formato esperado" );
        }
    }

    /**
     * Envía la información registrada de un jugador usando uno de los streams que permiten la comunicación con los clientes
     * @param out El stream a través del cual se debe enviar la información - out es un stream abierto hacia el cliente
     * @param reg El registro que se va a transmitir - reg != null
     */
    private void enviarInformacion( PrintWriter out, RegistroCliente reg )
    {
    	//TODO: Cree el String con el mensaje del registro del cliente 
    	//      envie el mensaje a traves del escritor que se recibe como parámetro
    	String cadena = CONEXION + ":" + reg.darNombreJugador( );
        out.println( cadena );
    }

    /**
     * Inicia el encuentro y realiza todas las acciones necesarias mientras que este dure.<br>
     * El ciclo de vida de un encuentro tiene tres partes:<br>
     * 1. Iniciar el encuentro <br>
     * 2. Realizar el encuentro (permitir la comunicación entre los clientes)<br>
     * 3. Terminar el encuentro y enviar la información sobre el ganador
     */
    public void run( )
    {
        try
        {
            iniciarEncuentro( );

            // Iniciar el juego
            int atacante = 1;

            while( !finJuego )
            {
                procesarJugada( atacante );

                if( finJuego )
                {
                    terminarEncuentro( );
                }
                else
                {
                    atacante = ( atacante == 1 ) ? 2 : 1;
                }
            }
        }
        catch( Exception e )
        {
            finJuego = true;

            try
            {
                in1.close( );
                out1.close( );
                socketJugador1.close( );
            }
            catch( IOException e2 )
            {
                e2.printStackTrace( );
            }

            try
            {
                in2.close( );
                out2.close( );
                socketJugador2.close( );
            }
            catch( IOException e2 )
            {
                e2.printStackTrace( );
            }
        }
    }

    /**
     * Realiza las actividades necesarias para iniciar un encuentro: <br>
     * 1. Lee la información con los nombres de los jugadores <br>
     * 2. Consulta los registros de los jugadores <br>
     * 3. Envía a cada jugador tanto su información como la de su oponente <br>
     * 4. Le envía a cada jugador un indicador para que sepa si es su turno de jugar. Siempre inicia el juego el primer jugador que se conectó. <br>
     * @throws BatallaNavalException Se lanza esta excepción si hay problemas con el acceso a la base de datos
     * @throws IOException Se lanza esta excepción si hay problemas en la comunicación
     */
    protected void iniciarEncuentro( ) throws IOException, BatallaNavalException
    {
        // Leer la información sobre los jugadores
    	//TODO: leer la información del socket del jugador 1 y llamar al método consultarJugador con la información leida
    	//      asignar el resultado a una variable de tipo RegistroJugador llamada reg2 
    	String info1 = in1.readLine( );
        RegistroJugador reg1 = consultarJugador( info1 );
        jugador1 = new JugadorRemoto( reg1 );

        //TODO: leer la información del socket del jugador 2 y llamar al método consultarJugador con la información leida, 
        //      asignar el resultado a una variable de tipo RegistroJugador llamada reg2 
        String info2 = in2.readLine( );
        RegistroJugador reg2 = consultarJugador( info2 );
        jugador2 = new JugadorRemoto( reg2 );

        // Enviar a cada jugador la información sobre su registro y el del oponente (en ese orden)
        enviarInformacion( out1, jugador1.darRegistroJugador( ) );
        enviarInformacion( out1, jugador2.darRegistroJugador( ) );

        enviarInformacion( out2, jugador2.darRegistroJugador( ) );
        enviarInformacion( out2, jugador1.darRegistroJugador( ) );

        // Enviar a cada jugador la información sobre en qué orden deben jugar: siempre empieza el jugador 1
        out1.println( PRIMER_TURNO );
        out2.println( SEGUNDO_TURNO );
    }

    /**
     * Realiza las actividades necesarias para terminar un encuentro: <br>
     * 1. Actualiza los registros de los jugadores en la base de datos <br>
     * 2. Envía un mensaje a los jugadores advirtiendo sobre el fin del juego y el nombre del ganador <br>
     * 3. Cierra las conexiones a los jugadores
     * @throws BatallaNavalException Se lanza esta excepción si hay problemas con el acceso a la base de datos
     * @throws IOException Se lanza esta excepción si hay problemas en la comunicación
     */
    private void terminarEncuentro( ) throws BatallaNavalException, IOException
    {
        // Actualizar el registro de los jugadores
        RegistroJugador ganador = null;
        RegistroJugador perdedor = null;
        if( jugador1.darPuntosPartida( ) > jugador2.darPuntosPartida( ) )
        {
            ganador = jugador1.darRegistroJugador( );
            perdedor = jugador2.darRegistroJugador( );
        }
        else
        {
            ganador = jugador2.darRegistroJugador( );
            perdedor = jugador1.darRegistroJugador( );
        }
        try
        {
            adminResultados.registrarVictoria( ganador.darNombreJugador( ) );
            adminResultados.registrarDerrota( perdedor.darNombreJugador( ) );
        }
        catch( SQLException e )
        {
            throw new BatallaNavalException( "Error actualizando la información en la base de datos: " + e.getMessage( ) );
        }
        // Enviar un mensaje indicando el fin del juego y el ganador
        //TODO: Cree el String con el mensaje del ganador de la partida y envielo a cada jugador
        String cadenaGanador = GANADOR + ":" + ganador.darNombreJugador( );
        out1.println( cadenaGanador );
        out2.println( cadenaGanador );

        // Cerrar los canales de los jugadores
        //TODO: Cierre todos los canales de comunicación
        in1.close( );
        out1.close( );
        in2.close( );
        out2.close( );
        socketJugador1.close( );
        socketJugador2.close( );
    }

    /**
     * Este método se encarga de procesar una jugada completa del juego, recibiendo y enviando los mensajes, y además actualizando el puntaje del juego <br>
     * Si con esta jugada el encuentro debe terminar, entonces el atributo encuentroTerminado del encuentro se convierte en true
     * @param atacante El número del jugador que tiene el turno de atacar - atacante = 1 o atacante = 2
     * @throws BatallaNavalException Se lanza esta excepción si hay problemas con la información que llega
     * @throws IOException Se lanza esta excepción si hay problemas en la comunicación
     */
    private void procesarJugada( int atacante ) throws IOException, BatallaNavalException
    {
        PrintWriter atacanteOut = ( atacante == 1 ) ? out1 : out2;
        PrintWriter atacadoOut = ( atacante == 1 ) ? out2 : out1;

        BufferedReader atacanteIn = ( atacante == 1 ) ? in1 : in2;
        BufferedReader atacadoIn = ( atacante == 1 ) ? in2 : in1;

        // Leer la jugada del atacante que indica donde se va a hacer el ataque
        //TODO: leer la información del atacanteIn y asignarla a una variable de tipo String llamada lineaAtaque
        String lineaAtaque = atacanteIn.readLine( );

        if(lineaAtaque != null)
        {
        	if( !lineaAtaque.startsWith( JUGADA ) )
        		throw new BatallaNavalException( "Se esperaba una JUGADA pero se recibió " + lineaAtaque );
        	
        	// Reenviar el ataque al jugador atacado
        	//TODO: enviar el ataque al jugador atacado
        	atacadoOut.println( lineaAtaque );
        	
        	// Leer la información sobre el resultado del ataque que envía el jugador atacado
        	//TODO leer la informacion del atacadoIn con el resultado de la jugada del atacante, asigne el resultado en un String de nombre lineaResultado
        	String lineaResultado = atacadoIn.readLine( );
        	
        	if( !lineaResultado.startsWith( AGUA ) && !lineaResultado.startsWith( IMPACTO ) && !lineaResultado.startsWith( FIN_JUEGO ) )
        		throw new BatallaNavalException( "Se esperaba el resultado de una JUGADA pero se recibió " + lineaResultado );
        	
        	// Revisar el resultado para saber si el encuentro termina y actualizar los puntajes
        	if( lineaResultado.startsWith( IMPACTO ) )
        	{
        		JugadorRemoto jugadorAtacante = ( atacante == 1 ) ? jugador1 : jugador2;
        		jugadorAtacante.aumentarPuntosEncuentro( 1 );
        	}
        	else if( lineaResultado.startsWith( FIN_JUEGO ) )
        	{
        		JugadorRemoto jugadorAtacante = ( atacante == 1 ) ? jugador1 : jugador2;
        		jugadorAtacante.aumentarPuntosEncuentro( 20 );
        		
        		finJuego = true;
        	}
        	
        	// Enviar el resultado del disparo al jugador atacante
        	//TODO: envie el resultado de la jugada al atacante a través del canal atacanteOut 
        	atacanteOut.println( lineaResultado );
        }
        else
        	throw new BatallaNavalException( "Se esperaba una JUGADA pero se recibió una cadena nula" );
    }

    /**
     * Retorna una cadena con la información del encuentro con el siguiente formato:<br>
     * <jugador1> ( <puntos> ) - <jugador2> ( <puntos> )
     * @return cadena
     */
    public String toString( )
    {
        RegistroJugador j1 = jugador1.darRegistroJugador( );
        RegistroJugador j2 = jugador2.darRegistroJugador( );

        String cadena = j1.darNombreJugador( ) + "( " + jugador1.darPuntosPartida( ) + " ) - " + j2.darNombreJugador( ) + "( " + jugador2.darPuntosPartida( ) + " )";
        return cadena;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica el invariante de la clase
     * <b>inv:</b><br>
     * !finJuego => socketJugador1 != null <br>
     * !finJuego => out1 != null <br>
     * !finJuego => in1 != null <br>
     * !finJuego => socketJugador2 != null <br>
     * !finJuego => out2 != null <br>
     * !finJuego => in2 != null <br>
     * jugador1 != null <br>
     * jugador2 != null <br>
     */
    private void verificarInvariante( )
    {
        if( !finJuego )
        {
            assert socketJugador1 != null : "Canal inválido";
            assert out1 != null : "Flujo inválido";
            assert in1 != null : "Flujo inválido";
            assert socketJugador2 != null : "Canal inválido";
            assert out2 != null : "Flujo inválido";
            assert in2 != null : "Flujo inválido";
        }
        
        assert jugador1 != null : "Jugador nulo";
        assert jugador2 != null : "Jugador nulo";
    }
    
    
    
}
