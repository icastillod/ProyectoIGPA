package Vista;
import java.awt.*;
import javax.swing.*;

public class GraUserInterface extends javax.swing.JFrame 
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
    private JTextArea areaArchivo;
    private JScrollPane scrollFuente;
    private JSeparator separador1;
    private JSeparator separador2;
    private JTextField tfCantExam;
    private JTextField tfPregFacil;
    private JTextField tfPregMedia;
    private JTextField tfPregInteresante;
    private JPanel jpTemas;
        
    public GraUserInterface() 
    {
        setSize(1000, 700);
        setLocationRelativeTo(null);
	this.setResizable(false);
	inicializar();
	setPositions();
        bloqueos();
        materiasLista();
		
	contenedor = getContentPane();
	contenedor.setLayout(null);
	areaArchivo.setEditable(false);
	
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
        areaArchivo.setText("Cuestionarios Generados");
        btGenerarExam.setText("GENERAR EXAMEN");
        btcargarpreguntas.setText("CARGAR PREGUNTAS");
        lblCantExamen.setText("Cantidad de examenes:");
        chComplFacil.setText("Facil");
        chComplMedia.setText("Media");
        chComplInteresante.setText("Interesante");
        chTema1.setText("T1");
        chTema2.setText("T2");
        chTema3.setText("T3");
        
        scrollFuente.setViewportView(areaArchivo);
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

    private void inicializar()
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
        areaArchivo = new JTextArea();
	scrollFuente = new JScrollPane();
        separador1 = new JSeparator();
        separador2 = new JSeparator();
        lblCantExamen = new JLabel();
        tfCantExam = new JTextField();
        tfPregFacil = new JTextField();
        tfPregMedia = new JTextField();
        tfPregInteresante = new JTextField();
        jpTemas = new JPanel();
    }
    
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
    
    private void bloqueos() 
    {
        lblNumPregXCompl.setVisible(false);
        tfPregFacil.setVisible(false);
        tfPregMedia.setVisible(false);
        tfPregInteresante.setVisible(false);
    }
    
    private void materiasLista()
    {
        cbMateria.addItem(" ");
        cbMateria.addItem("Sistemas Naturales");
        cbMateria.addItem("Biologia");
        cbMateria.addItem("Microbiologia");
    }
        
}

