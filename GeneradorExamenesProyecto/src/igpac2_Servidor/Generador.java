/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad central
 *
 * Proyecto IGPA
 * Autor: 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package igpac2_Servidor;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

/**
 * El Servidor Generardo es el encargado de crear los examenes y de solicitar el cargue de las preguntas en el mismo
 */
public class Generador
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es el punto por el cual los clientes solicitan conexiones
     */
    private ServerSocket receptor;

    /**
     * Es el conjunto de propiedades que contienen la configuración de la aplicación
     */
    private Properties config;

    /**
     * Es una colección con las preguntas que están siendo solicitadas
     */
    protected Collection preguntas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Inicia el servidor 
     * @param archivo El archivo de propiedades que tiene la configuración del servidor - archivo != null
     * @throws Exception Se lanza esta excepción si hay problemas con el archivo de propiedades o hay problemas en la conexión a la base de datos
     * @throws SQLException Se lanza esta excepción si hay problemas conectando el almacén a la base de datos.
     */
    public Generador( String archivo ) throws SQLException, Exception
    {
        preguntas = new Vector( );

        cargarConfiguracion( archivo );
    }

    // -----------------------------------------------------------------
    // métodos
    // -----------------------------------------------------------------

    /**
     * Carga la configuración a partir de un archivo de propiedades
     * @param archivo El archivo de propiedades que contiene la configuración que requiere el servidor - archivo != null y el archivo debe contener la propiedad
     *        "servidor.puerto" y las propiedades que requiere el administrador de resultados
     * @throws Exception Se lanza esta excepción si hay problemas cargando el archivo de propiedades
     */
    private void cargarConfiguracion( String archivo ) throws Exception
    {
        FileInputStream fis = new FileInputStream( archivo );
        config = new Properties( );
        config.load( fis );
        fis.close( );
    }

    /**
     * Retorna una colección actualizada con los encuentros que se están desarrollando actualmente y no han terminado.<br>
     * Si había encuentros en la lista que ya habían terminado deben ser eliminados.
     * @return colección de encuentros
     */
    public Collection darListaActualizadaEncuentros( )
    {
        Collection listaActualizada = new Vector( );

        // Armar la lista actualizada con los encuentros que no han terminado
        Iterator iter = preguntas.iterator( );
        while( iter.hasNext( ) )
        {
            Pregunta e = ( Pregunta )iter.next( );
            if( !e.PreguntaLista( ) )
                listaActualizada.add( e );
        }

        // Reemplazar la lista antigua con la lista actualizada
        preguntas = listaActualizada;

        return preguntas;
    }

    /**
     * Este método se encarga de recibir todas las conexiones entrantes y crear los encuentros cuando fuera necesario.
     */
    public void recibirConexiones( )
    {
        String aux = config.getProperty( "servidor.puerto" );
        int puerto = Integer.parseInt( aux );
        try
        {
        	//TODO: crear una nueva instancia del ServerSocket y asignarla al atributo receptor
        	receptor = new ServerSocket( puerto );
        	
            while( true )
            {
                // Esperar una nueva conexión
            	// TODO: declarar el socket que se crea al aceptar la conexion en una nueva variable y llamela socketNuevoCliente
            	Socket socketNuevoCliente = receptor.accept( );
            }
        }
        catch( IOException e )
        {
            e.printStackTrace( );
        }
        finally
        {
            try
            {
                receptor.close( );
            }
            catch( IOException e )
            {
                e.printStackTrace( );
            }
        }
    }

    /**
     * Agrega una nueva pregunta a la lista del examen y la carga
     * @param nuevaPregunta != null
     */
    protected void cargarPregunta( Pregunta nuevaPregunta )
    {
        preguntas.add( nuevaPregunta );
        nuevaPregunta.cargar( );
    }
    
    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica el invariante de la clase <br>
     * <b>inv:</b><br>
     * receptor!= null <br>
     * config!=null <br>
     * adminResultados!=null <br>
     * encuentros!=null <br>
     */
    private void verificarInvariante( )
    {        
        assert receptor != null : "Canal inválido";
        assert config != null : "Conjunto de propiedades inválidas";
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
    
    /**
     * método para la extensión3
     * @return respuesta3
     */
    public String metodo3( )
    {
        return "Respuesta 3";
    }

}
