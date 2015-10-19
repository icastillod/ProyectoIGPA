/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: DialogoConectar.java 622 2006-11-09 23:37:02Z da-romer $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License versi�n 2.1
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n12_batallaNaval
 * Autor: Mario S�nchez - 24/02/2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package igpac2_GUICliente;

import javax.swing.JDialog;

/**
 * Es el di�logo usado para pedir los datos necesarios para iniciar una conexi�n
 */
public class DialogoConectar extends JDialog
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz
     */
    private GUICliente principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el panel donde se ingresan los datos
     */
    private PanelDatosJuego panelDatos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el di�logo
     * @param ventanaPrincipal Es una referencia a la clase principal de la interfaz
     * @param nombre Nombre con el que se va a inicializar el panel
     * @param direccion Direcci�n del servidor para inicializar el panel
     * @param puerto Puerto para inicializar el panel
     */
    public DialogoConectar( GUICliente ventanaPrincipal, String nombre, String direccion, int puerto )
    {
        super( ventanaPrincipal, true );

        principal = ventanaPrincipal;
        panelDatos = new PanelDatosJuego( this, nombre, direccion, puerto );
        getContentPane( ).add( panelDatos );

        setTitle( "Datos de la Conexi�n" );
        setSize( 400, 200 );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Intenta realizar una conexi�n
     * @param nombre El nombre del jugador
     * @param direccion Direcci�n donde se encuentra el servidor
     * @param puerto Puerto usado para la conexi�n
     */
    public void conectar( String nombre, String direccion, int puerto )
    {
        principal.conectar( this, nombre, direccion, puerto );
    }

}
