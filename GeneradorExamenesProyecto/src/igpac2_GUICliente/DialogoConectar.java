/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Central
 * Proyecto IGPC
 * Autor: 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package igpac2_GUICliente;

import javax.swing.JDialog;

/**
 * Es el dialogo usado para pedir los datos necesarios para iniciar una conexion
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
    private PanelDatos panelDatos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el dialogo
     * @param ventanaPrincipal Es una referencia a la clase principal de la interfaz
     * @param nombre Nombre con el que se va a inicializar el panel
     * @param direccion Direcci�n del servidor para inicializar el panel
     * @param puerto Puerto para inicializar el panel
     */
    public DialogoConectar( GUICliente ventanaPrincipal, String nombre, String direccion, int puerto )
    {
        super( ventanaPrincipal, true );

        principal = ventanaPrincipal;
        panelDatos = new PanelDatos( this, nombre, direccion, puerto );
        getContentPane( ).add( panelDatos );

        setTitle( "Datos de la Conexion" );
        setSize( 400, 200 );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Intenta realizar una conexi�n
     * @param nombre El nombre del cliente
     * @param direccion Direcci�n donde se encuentra el servidor
     * @param puerto Puerto usado para la conexi�n
     */
    public void conectar( String nombre, String direccion, int puerto )
    {
        principal.conectar( nombre, direccion, puerto );
    }

}
