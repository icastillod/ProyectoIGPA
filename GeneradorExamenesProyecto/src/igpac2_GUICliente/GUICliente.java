package igpac2_GUICliente;
import igpac2_Cliente.ThreadConectar;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import javax.swing.*;
import igpac2_Servidor.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
* Esta clase muesta la interfaz del usuario final.
* @author: Ivonne Castillo, Gerardo Rico
* @version: 30/09/2015 
*/
public class GUICliente extends javax.swing.JFrame
{ 
    private static final long serialVersionUID = 1L;
    private Container contenedor;
    private JLabel lblTitulo;
    private JLabel lblUniversidad;
    private JLabel lblMateria;
    private JLabel lblTema;
    private JLabel lblComplejidad;
    private JLabel lblNumPregXCompl;
    private JLabel lblCantTotalPreg;
    private JLabel lblCantExamen;
    private JLabel lblTipoPregunta;
    private JLabel lblDetalleTipoPregunta;
    private JButton btGenerarExam;
    private JButton btcargarpreguntas;
    private JComboBox cbMateria;
    private JCheckBox chComplFacil;
    private JCheckBox chComplMedia;
    private JCheckBox chComplInteresante;
    private JCheckBox chTema1;
    private JCheckBox chTema2;
    private JCheckBox chTema3;
    private JComboBox cbTipoPregunta;
    private JComboBox cbDetalleTipoPregunta;
    private JList lstTema;
    //private JTextArea areaArchivo;
    private JScrollPane scrollFuente;
    private JSeparator separador1;
    private JSeparator separador2;
    private JTextField tfCantExam;
    private JTextField tfPregFacil;
    private JTextField tfPregMedia;
    private JTextField tfPregInteresante;
    private JPanel jpTemas;

    /**
     * Constructor para la interfaz grafica del usuario
     * @param GUICliente no tiene parámetro
     */
    public GUICliente() throws SQLException 
    {
        setSize(600, 700);
        setLocationRelativeTo(null);
	this.setResizable(false);
	inicializar();
	setPositions();
        bloqueos();
		
	contenedor = getContentPane();
	contenedor.setLayout(null);
	//areaArchivo.setEditable(false);
	
	setTitle("Generador Exámenes");
        lblTitulo.setText("GENERADOR DE EXAMENES");
        lblUniversidad.setText("UNIVERSIDAD CENTRAL");
        lblMateria.setText("Materia:");
        lblTema.setText("Temas:");
        lblComplejidad.setText("Complejidad:");
        lblNumPregXCompl.setText("Numero de preguntas:");
        lblCantTotalPreg.setText("Numero total de Preguntas:");
        lblCantExamen.setText("Cantidad Exámenes:");
        lblTipoPregunta.setText("Tipo de Preguntas:");
        lblDetalleTipoPregunta.setText("Tipo Detalle Tipo Preguntas:");
        //areaArchivo.setText("Cuestionarios Generados");
        btGenerarExam.setText("GENERAR EXAMEN");
        btcargarpreguntas.setText("CARGAR PREGUNTAS");
        lblCantExamen.setText("Cantidad de examenes:");
        chComplFacil.setText("Facil");
        chComplMedia.setText("Media");
        chComplInteresante.setText("Interesante");
        chTema1.setText("");
        chTema2.setText("");
        chTema3.setText("");
        
        //scrollFuente.setViewportView(areaArchivo);
	contenedor.add(lblTitulo);
	contenedor.add(lblUniversidad);
	contenedor.add(lblMateria);
        contenedor.add(cbMateria);
        contenedor.add(lblTema);
        contenedor.add(lstTema);
	contenedor.add(lblComplejidad);
	contenedor.add(lblNumPregXCompl);
	contenedor.add(lblCantTotalPreg);
	contenedor.add(lblTipoPregunta);
        contenedor.add(lblDetalleTipoPregunta);
	contenedor.add(scrollFuente);
	contenedor.add(chComplFacil);
	contenedor.add(chComplMedia);
	contenedor.add(chComplInteresante);
        contenedor.add(separador1);
        contenedor.add(separador2);
        contenedor.add(btcargarpreguntas);
        contenedor.add(btGenerarExam);
        contenedor.add(lblCantExamen);
        contenedor.add(tfCantExam);
        contenedor.add(tfPregFacil);
        contenedor.add(tfPregMedia);
        contenedor.add(tfPregInteresante);
        contenedor.add(cbTipoPregunta);
        contenedor.add(cbDetalleTipoPregunta);
        contenedor.add(jpTemas);
        contenedor.add(chTema1);
        contenedor.add(chTema2);
        contenedor.add(chTema3);
    }

    /**
     * Metodo para inivializar los objetos graficos que se mostraran en la interz
     * @param inicializar sin parametos
     */
    private void inicializar() throws SQLException
    {
        lblTitulo = new JLabel();
        lblUniversidad = new JLabel();
        lblMateria = new JLabel();
        lblTema = new JLabel();
        lblComplejidad = new JLabel();
        lblNumPregXCompl = new JLabel();
        lblCantTotalPreg = new JLabel();
        lblCantExamen = new JLabel();
        lblTipoPregunta = new JLabel();
        lblDetalleTipoPregunta = new JLabel();
        btGenerarExam = new JButton();
        btcargarpreguntas = new JButton();
        cbMateria = new JComboBox();
        chComplFacil = new JCheckBox();
        chComplMedia= new JCheckBox();
        chComplInteresante = new JCheckBox();
        chTema1 = new JCheckBox();
        chTema2 = new JCheckBox();
        chTema3 = new JCheckBox();
        cbTipoPregunta = new JComboBox();
        cbDetalleTipoPregunta = new JComboBox();
        lstTema = new JList();
        //areaArchivo = new JTextArea();
	scrollFuente = new JScrollPane();
        separador1 = new JSeparator();
        separador2 = new JSeparator();
        lblCantExamen = new JLabel();
        tfCantExam = new JTextField();
        tfPregFacil = new JTextField();
        tfPregMedia = new JTextField();
        tfPregInteresante = new JTextField();
        jpTemas = new JPanel();
        cargarMateria();
    }
    /**
     * Metodo que especifica la posicion de cada elemento que compone la interzas
     * @param setPosition sin parametos
     */
    private void setPositions() 
    {
	lblTitulo.setBounds(15, 8, 300, 20);
        lblUniversidad.setBounds(800, 8, 200, 20);
        separador1.setBounds(7, 50, 983, 10);
	lblMateria.setBounds(15, 60, 220, 20);
        cbMateria.setBounds(130, 60, 200, 20);
        lblComplejidad.setBounds(15, 85, 220, 20);
        lblNumPregXCompl.setBounds(130, 85, 220, 20);
        chComplFacil.setBounds(20, 105, 100, 20);
        chComplMedia.setBounds(20, 125, 100, 20);
        chComplInteresante.setBounds(20, 145, 100, 20);
        tfPregFacil.setBounds(130, 105, 30, 20);
        tfPregMedia.setBounds(130, 125, 30, 20);
        tfPregInteresante.setBounds(130, 145, 30, 20);
        lblCantTotalPreg.setBounds(15, 165, 220, 20);
        //tfPregInteresante.setBounds(160, 170, 30, 20);
	lblTipoPregunta.setBounds(570,60,220,20);
        cbTipoPregunta.setBounds(570,85,200,20); 
        lblDetalleTipoPregunta.setBounds(785,60,220,20);
        cbDetalleTipoPregunta.setBounds(785,85,200,20);
        lblTema.setBounds(350,60,100,20);
        jpTemas.setBounds(350,85,200,70);
        jpTemas.setBackground(Color.WHITE);
        chTema1.setBounds(355, 90, 190, 20);
        chTema2.setBounds(355, 110, 190, 20);
        chTema3.setBounds(355, 130, 190, 20);
        tfCantExam.setBounds(180, 185, 30, 20);
        lblCantExamen.setBounds(15, 180, 185, 30);
        btGenerarExam.setBounds(600, 180, 185, 30);
        btcargarpreguntas.setBounds(800, 180, 185, 30);
        separador2.setBounds(7, 220, 983, 10);
        scrollFuente.setBounds(15, 230, 970, 435);
    }
    /**
     * Metodo para ocultar temporalmente elementos graficos de la interzzas
     * @param bloqueos sin parametos
     */
    private void bloqueos() 
    {
        lblNumPregXCompl.setVisible(false);
        tfPregFacil.setVisible(false);
        tfPregMedia.setVisible(false);
        tfPregInteresante.setVisible(false);
       // chTema1.setVisible(false);
       // chTema2.setVisible(false);
       // chTema3.setVisible(false);
    }
    /**
     * Metodo para cargar en pantalla las materias almacenadas en la base de datos 
     * @param cargarMateria sin parametos
     */
    public void cargarMateria() throws SQLException{
        
        Materia m = new Materia();
        ArrayList materia = m.getMateria();
        
        for (Object materia1 : materia) {
            cbMateria.addItem(materia1);
        }
    }
    /**
     * Metodo para cargar en pantalla los temas almacenadas en la base de datos, correspondientes a la materia seleccinada 
     * @param cargarTema Parametos Materia 
     * 
     */
    public void cargarTema(String materia)throws SQLException{
        
        Tema t = new Tema();
        ArrayList tema = t.getTema(materia);
        for (int x = 0; x<tema.size();x++) {
     //       lstTema[x]=tema[x];
        }
        
    }
    
     /**
     * Intenta realizar una conexi�n.<br>
     * El proceso de conexi�n al servidor se hace en un hilo aparte usando la clase ThreadConectar.
     * @param dialogo Es el di�logo que fue usado para recibir los datos
     * @param nombre El nombre del jugador
     * @param direccion Direcci�n donde se encuentra el servidor
     * @param puerto Puerto usado para la conexi�n
     */
    public void conectar( DialogoConectar dialogo, String nombre, String direccion, int puerto )
    {
        dialogo.dispose( );
        Thread t = new ThreadConectar( batallaNaval, this, nombre, direccion, puerto );
        t.start( );
    }
    
    /**
     * Metodo para cargar en pantalla la interfaz grafica
     * @param main String[] args
     */
    public static void main(String[] args) throws SQLException {
        
        GUICliente interfaz = new GUICliente();
        interfaz.setVisible(true);
    }
    
}
