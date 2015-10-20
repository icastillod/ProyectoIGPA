/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelDatosJuego.java 588 2006-11-04 15:10:29Z jvillalo2 $
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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Es el panel donde se ingresan los datos necesarios para iniciar una conexi�n
 */
public class PanelDatos extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para el bot�n Conectar
     */
    private static final String CONECTAR = "Conectar";

    /**
     * Comando para el bot�n Cancelar
     */
    private static final String CANCELAR = "Cancelar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia al di�logo que contiene al panel
     */
    private DialogoConectar dialogo;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta Nombre
     */
    private JLabel etiquetaNombre;

    /**
     * Etiqueta Direcci�n Servidor
     */
    private JLabel etiquetaServidor;

    /**
     * Etiqueta Puerto
     */
    private JLabel etiquetaPuerto;

    /**
     * Campo de Texto para el Nombre
     */
    private JTextField txtNombre;

    /**
     * Campo de Texto para la Direcci�n Servidor
     */
    private JTextField txtServidor;

    /**
     * Campo de Texto para el Puerto
     */
    private JTextField txtPuerto;

    /**
     * Bot�n Conectar
     */
    private JButton botonConectar;

    /**
     * Bot�n Cancelar
     */
    private JButton botonCancelar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa todos sus componentes
     * @param dialogoConectar Es el di�logo dentro del cual est� este panel
     * @param nombre Nombre con el que se va a inicializar el panel
     * @param direccion Direcci�n del servidor para inicializar el panel
     * @param puerto Puerto para inicializar el panel
     */
    public PanelDatos( DialogoConectar dialogoConectar, String nombre, String direccion, int puerto )
    {
        dialogo = dialogoConectar;

        setLayout( new GridBagLayout( ) );

        // Etiquetas
        GridBagConstraints gbc = new GridBagConstraints( 0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        etiquetaNombre = new JLabel( "Nombre del Jugador:" );
        add( etiquetaNombre, gbc );

        gbc = new GridBagConstraints( 0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        etiquetaServidor = new JLabel( "Direcci�n Servidor:" );
        add( etiquetaServidor, gbc );

        gbc = new GridBagConstraints( 0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        etiquetaPuerto = new JLabel( "Puerto:" );
        add( etiquetaPuerto, gbc );

        // Campos de texto
        gbc = new GridBagConstraints( 1, 0, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        txtNombre = new JTextField( nombre );
        add( txtNombre, gbc );

        gbc = new GridBagConstraints( 1, 1, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        txtServidor = new JTextField( direccion );
        add( txtServidor, gbc );

        gbc = new GridBagConstraints( 1, 2, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        txtPuerto = new JTextField( "" + puerto );
        add( txtPuerto, gbc );

        // Botones
        gbc = new GridBagConstraints( 1, 3, 1, 1, 0.5, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        botonConectar = new JButton( "Conectar" );
        botonConectar.setActionCommand( CONECTAR );
        botonConectar.addActionListener( this );
        add( botonConectar, gbc );

        gbc = new GridBagConstraints( 2, 3, 1, 1, 0.5, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        botonCancelar = new JButton( "Cancelar" );
        botonCancelar.setActionCommand( CANCELAR );
        botonCancelar.addActionListener( this );
        add( botonCancelar, gbc );

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Es el m�todo que se llama cuando se hace click sobre uno de los botones
     * @param evento Es el evento del click sobre el bot�n
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );
        if( CANCELAR.equals( comando ) )
        {
            dialogo.dispose( );
        }
        else if( CONECTAR.equals( comando ) )
        {
            try
            {
                String nombre = txtNombre.getText( );
                String direccion = txtServidor.getText( );

                String strPuerto = txtPuerto.getText( );
                int puerto = Integer.parseInt( strPuerto );

                dialogo.conectar( nombre, direccion, puerto );
            }
            catch( NumberFormatException nfe )
            {
                JOptionPane.showMessageDialog( dialogo, "El n�mero del puerto debe ser un n�mero" );
            }
        }

    }

}
