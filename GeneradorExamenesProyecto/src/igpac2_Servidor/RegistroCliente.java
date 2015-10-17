/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Registrocliente.java 588 2006-11-04 15:10:29Z jvillalo2 $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License versión 2.1
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n12_batallaNaval
 * Autor: Mario Sánchez - 23/02/2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package igpac2_Servidor;

import java.text.*;

/**
 * Esta clase mantiene la información del número de de victorias y derrotas de un jugador<br>
 * <b>inv:</b><br>
 * nombreJugador != null<br>
 * encuentrosGanados >= 0<br>
 * encuentrosPerdidos >= 0<br>
 */
public class RegistroCliente
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * El nombre del jugador
     */
    private String nombre;

    /**
     * El número de encuentros ganados hasta el momento
     */
    private int ganados;

    /**
     * El número de encuentros perdidos hasta el momento
     */
    private int perdidos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo registro
     * @param nombreP El nombre del jugador - nombre != null
     * @param ganadosP El número de encuentros ganados - ganados >= 0
     * @param perdidosP El número de encuentros perdidos - perdidos >= 0
     */
    public RegistroCliente( String nombreP, int ganadosP, int perdidosP )
    {
        nombre = nombreP;
        ganados = ganadosP;
        perdidos = perdidosP;
        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del cliente
     * @return nombre
     */
    public String darNombre( )
    {
        return nombre;
    }
    
    /**
     * Retorna una cadena con la información del registro
     * @return Retorna una cadena de la forma <nombre>
     */
    public String toString( )
    {
        return nombre;
    }


    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica el invariante de la clase<br>
     * <b>inv:</b><br>
     * nombre != null<br>
     */
    private void verificarInvariante( )
    {
        assert ( nombre != null ) : "El nombre no puede ser null";
    }
}
