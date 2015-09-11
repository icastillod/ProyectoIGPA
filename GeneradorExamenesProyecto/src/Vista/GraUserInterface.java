package Vista;
import java.awt.*;
import java.awt.event.ItemEvent;
import javax.swing.*;
import Controlador.CargarListener;
import Modelo.Pregunta;
import Modelo.PreguntaSelMultiple;

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
    //private JLabel lblCantTotalPreg;
    //private JLabel lblCantExamen;
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
    public JTextArea areaArchivo;
    private JScrollPane scrollFuente;
    private JSeparator separador1;
    private JSeparator separador2;
    //private JTextField tfCantExam;
    private JTextField tfPregFacil;
    private JTextField tfPregMedia;
    private JTextField tfPregInteresante;
    private CargarListener cuestion;
    private int valFacil;
    private int valMedia;
    private int valInteresante;
    
        
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
        //lblCantTotalPreg.setText("Numero total de Preguntas:");
        //lblCantExamen.setText("Cantidad Exámenes:");
        lblTipoPregunta.setText("Tipo de Preguntas:");
        lblDetalleTipoPregunta.setText("Tipo Detalle Tipo Preguntas:");
        areaArchivo.setText("Cuestionarios Generados");
        btGenerarExam.setText("GENERAR EXAMEN");
        btcargarpreguntas.setText("CARGAR PREGUNTAS");
        //lblCantExamen.setText("Cantidad de examenes:");
        chComplFacil.setText("Facil");
        chComplMedia.setText("Media");
        chComplInteresante.setText("Interesante");
        chTema1.setText("");
        chTema2.setText("");
        chTema3.setText("");
        
        scrollFuente.setViewportView(areaArchivo);
	contenedor.add(lblTitulo);
	contenedor.add(lblUniversidad);
	contenedor.add(lblMateria);
        contenedor.add(cbMateria);
        contenedor.add(lblTema);
        contenedor.add(lstTema);
	contenedor.add(lblComplejidad);
	contenedor.add(lblNumPregXCompl);
	//contenedor.add(lblCantTotalPreg);
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
        //contenedor.add(lblCantExamen);
        //contenedor.add(tfCantExam);
        contenedor.add(tfPregFacil);
        contenedor.add(tfPregMedia);
        contenedor.add(tfPregInteresante);
        contenedor.add(cbTipoPregunta);
        contenedor.add(cbDetalleTipoPregunta);
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
        //lblCantTotalPreg = new JLabel();
        //lblCantExamen = new JLabel();
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
        //lblCantExamen = new JLabel();
        //tfCantExam = new JTextField();
        tfPregFacil = new JTextField();
        tfPregMedia = new JTextField();
        tfPregInteresante = new JTextField();
        
        cbMateria.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMateriasItemStateChanged(evt);
            }
        });
        
        btGenerarExam.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGenerarExamActionPerformed(evt);
            }
        });
        
        
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
        //lblCantTotalPreg.setBounds(15, 165, 220, 20);
        //tfPregInteresante.setBounds(160, 170, 30, 20);
	lblTipoPregunta.setBounds(570,60,220,20);
        cbTipoPregunta.setBounds(570,85,200,20); 
        lblDetalleTipoPregunta.setBounds(785,60,220,20);
        cbDetalleTipoPregunta.setBounds(785,85,200,20);
        lblTema.setBounds(350,60,100,20);
        chTema1.setBounds(355, 90, 190, 20);
        chTema2.setBounds(355, 110, 190, 20);
        chTema3.setBounds(355, 130, 190, 20);
        //tfCantExam.setBounds(180, 185, 30, 20);
        //lblCantExamen.setBounds(15, 180, 185, 30);
        btGenerarExam.setBounds(600, 180, 185, 30);
        btcargarpreguntas.setBounds(800, 180, 185, 30);
        separador2.setBounds(7, 220, 983, 10);
        scrollFuente.setBounds(15, 230, 970, 435);
    }
    
   private void bloqueos() 
    {
        lblDetalleTipoPregunta.setVisible(false);
        cbDetalleTipoPregunta.setVisible(false);
     //   lblNumPregXCompl.setVisible(false);
     //   tfPregFacil.setVisible(false);
     //   tfPregMedia.setVisible(false);
     //   tfPregInteresante.setVisible(false);
       // chTema1.setVisible(false);
       // chTema2.setVisible(false);
       // chTema3.setVisible(false);
    }
    
    private void materiasLista()
    {
        cbMateria.addItem("Seleccione Materia");
        cbMateria.addItem("Sistemas Naturales");
        cbMateria.addItem("Biologia");
        //cbMateria.addItem("Microbiologia");
    }
    
    public String [] getTemas(String cbMateria)
    {
        String [] temas = new String[3];
        if (cbMateria.equalsIgnoreCase("Sistemas Naturales"))
        {
            temas[0] = "Celula";
            temas[1] = "Sistema Respiratorio";
            temas[2] = "Fotosintesis";
        }
        if (cbMateria.equalsIgnoreCase("Biologia"))
        {
            temas[0] = "Anatomia";
            temas[1] = "Mundo";
            temas[2] = "Hongos";
        }   
        return temas;
    }
    
    private void cbMateriasItemStateChanged(java.awt.event.ItemEvent evt)
    {
        if (evt.getStateChange() == ItemEvent.SELECTED )
        {
            if(this.cbMateria.getSelectedIndex()==1)
            {
                chTema1.setText("Celula");
                chTema2.setText("Sistema Respiratorio");
                chTema3.setText("Fotocintesis");
            } else if(this.cbMateria.getSelectedIndex()==2)
            {
                chTema1.setText("Anatomia");
                chTema2.setText("Mundo");
                chTema3.setText("Hongos");               
            } else if(this.cbMateria.getSelectedIndex()==0)
            {
                chTema1.setText(" ");
                chTema2.setText(" ");
                chTema3.setText(" ");
            }
        }
    }
    
    private void btGenerarExamActionPerformed(java.awt.event.ActionEvent evt) 
    {
        if(chTema1.isSelected() || chTema2.isSelected() || chTema3.isSelected())
        {
            if(chComplFacil.isSelected()) 
            {
                if (tfPregFacil.getText().equals(""))
                {
                    valFacil = 0;
                }else{
                    valFacil = new Integer(tfPregFacil.getText());
                }
            }
            if(chComplMedia.isSelected())
            {
                if (tfPregMedia.getText().equals(""))
                {
                    valMedia = 0;
                }else{
                    valMedia = new Integer(tfPregMedia.getText());
                }
            }
            if (chComplInteresante.isSelected())
            {
                if (tfPregInteresante.getText().equals(""))
                {
                    valInteresante = 0;
                }else{
                    valInteresante = new Integer(tfPregInteresante.getText());
                }
            }
            CargarListener CargarListener = new CargarListener(valFacil, valMedia, valInteresante);
            cuestion.actionPerformed(CargarListener);
        }else{
                JOptionPane.showMessageDialog(null, "Validar campos");
            }
    }
    
    public void imprirPreguntas(String ax)
    {
        int nCuestion = 0;
        nCuestion = Integer.parseInt(ax);

        String[] listarespuesta;
        listarespuesta = new String[4];
        Pregunta[] preg = new PreguntaSelMultiple[13];
       
        for(int i=0; i<nCuestion; i++)
        { 
        
        
        //Pregunta preg1 = new PreguntaSelMultiple();
        preg[0].setComplejidadPregunta("Facil");
        preg[0].setTipoPregunta("Seleccion Multiple");
        preg[0].setEnunciadoPregunta("La mayor parte de los reptiles dependen de la temperatura ambiental para regular su temperatura corporal, por lo que su producción de calor es baja y su metabolismo lento. Por otro lado los mamíferos no dependen de la temperatura ambiental para regular su temperatura corporal. Teniendo en cuenta esta diferencia usted pensaría que los:");
        
        listarespuesta[0]="mamíferos presentan una menor cantidad de mitocondrias en sus células en comparación con los reptiles";
        listarespuesta[1]="reptiles presentan una menor cantidad de mitocondrias en sus células en comparación con los mamíferos";
        listarespuesta[2]="mamíferos presentan una menor cantidad de ribosomas en sus células en comparación con los reptiles";
        listarespuesta[3]="reptiles presentan una menor cantidad de ribosomas en comparación con los mamíferos";
        
        preg[0].setRespuestas(listarespuesta);
        
        //Pregunta preg2 = new PreguntaSelMultiple();
        preg[1].setComplejidadPregunta("Facil");
        preg[1].setTipoPregunta("Seleccion Multiple");
        preg[1].setEnunciadoPregunta("Donde ocurren las reacciones oscuras y de fijación del carbono ");
        
        listarespuesta[0]="En el citoplasma.";
        listarespuesta[1]="En el estroma del cloroplasto.";
        listarespuesta[2]="En las membranas de los tilacoides.";
        listarespuesta[3]="En las mitocondrias.";
        
        preg[1].setRespuestas(listarespuesta);
        
        //Pregunta preg3 = new PreguntaSelMultiple();
        preg[2].setComplejidadPregunta("Facil");
        preg[2].setTipoPregunta("Seleccion Multiple");
        preg[2].setEnunciadoPregunta("Cuál de los siguientes enunciados NO es correcto en relación con el aparato de Golgi :");
        
        listarespuesta[0]="Es un conjunto especializado de sacos membranosos que se originan a partir del Retículo endoplasmático.";
        listarespuesta[1]="Separa la proteínas y los lípidos que se reciben del Retículo endoplasmático de acuerdo con su destino.";
        listarespuesta[2]="Empaca algunos materiales en vesículas que son transportadoras a otras partes de la célula o de la membrana plasmática.";
        listarespuesta[3]="Son vesículas membranosas que digieren partículas alimenticias, que van desde proteínas hasta microorganismos.";
        
        preg[2].setRespuestas(listarespuesta);
        
        //Pregunta preg4 = new PreguntaSelMultiple();
        preg[3].setComplejidadPregunta("Facil");
        preg[3].setTipoPregunta("Seleccion Multiple");
        preg[3].setEnunciadoPregunta("Cuál de los siguientes enunciados SI es correcto en relación con la mitocondria :");
        
        listarespuesta[0]="Son las estructuras encargadas de la producción de energía mediante metabolismo aeróbico, ausente en procariotas, presente animales y plantas.";
        listarespuesta[1]="Son las estructuras encargadas de la producción de energía mediante metabolismo anaeróbico, presente en procariotas, animales y plantas.";
        listarespuesta[2]="Son las estructuras encargadas de sintetizar las proteínas presente en procariotas, animales y plantas.";
        listarespuesta[3]="Contienen alimentos que se obtienen a través de fagocitosis, ausente en procariotas, presente animales y plantas.";
        
        preg[3].setRespuestas(listarespuesta);
        
        //Pregunta preg[4] = new PreguntaSelMultiple();
        preg[4].setComplejidadPregunta("Media");
        preg[4].setTipoPregunta("Seleccion Multiple");
        preg[4].setEnunciadoPregunta("Son características de la célula eucariota :");
        
        listarespuesta[0]="Carece de núcleo definido y envoltura nuclear.";
        listarespuesta[1]="Contiene un núcleo con membrana nuclear definida.";
        listarespuesta[2]="Contiene vacuola que en la mayoría de los casos contiene agua, membrana celular y citoplasma.";
        listarespuesta[3]="Contienen ribosomas  que sintetizan las proteínas para el matabolismo celular.";
        
        preg[4].setRespuestas(listarespuesta);
        
        //Pregunta preg[5] = new PreguntaSelMultiple();
        preg[5].setComplejidadPregunta("Media");
        preg[5].setTipoPregunta("Seleccion Multiple");
        preg[5].setEnunciadoPregunta("Cuál de las siguientes evidencias demostraría que una substancia entra a una célula mediante transporte activo en lugar de hacerlo por pasivo ?");
        
        listarespuesta[0]="La substancia entra a la célula cuando su concentración es más alta afuera que adentro.";
        listarespuesta[1]="Se requiere rompimiento de ATP para que la sustancia se mueva hacia dentro de la célula.";
        listarespuesta[2]="La substancia entra a la célula cuando su concentración es más baja afuera que adentro.";
        listarespuesta[3]="Todas las anteriores.";
        
        preg[5].setRespuestas(listarespuesta);
        
        //Pregunta preg[6] = new PreguntaSelMultiple();
        preg[6].setComplejidadPregunta("Media");
        preg[6].setTipoPregunta("Seleccion Multiple");
        preg[6].setEnunciadoPregunta("Cuál de las siguientes evidencias demostraría que una substancia entra a una célula mediante transporte activo en lugar de hacerlo por pasivo ?");
        
        listarespuesta[0]="La substancia entra a la célula cuando su concentración es más alta afuera que adentro.";
        listarespuesta[1]="Se requiere rompimiento de ATP para que la sustancia se mueva hacia dentro de la célula.";
        listarespuesta[2]="La substancia entra a la célula cuando su concentración es más baja afuera que adentro.";
        listarespuesta[3]="Todas las anteriores.";
        
        preg[6].setRespuestas(listarespuesta);
        
  
       // Pregunta preg[7] = new PreguntaSelMultiple();
        preg[7].setComplejidadPregunta("Media");
        preg[7].setTipoPregunta("Seleccion Multiple");
        preg[7].setEnunciadoPregunta("Es característico de plantas tipo  C4 :");
        
        listarespuesta[0]="Fijación de carbono en 2 pasos.";
        listarespuesta[1]="Fijación de carbono en 1 paso.";
        listarespuesta[2]="Interviene 1 molécula de Fosfoenolpiruvato de 4 C";
        listarespuesta[3]="No producen Glucosa.";
        
        preg[7].setRespuestas(listarespuesta);
        
        
       // Pregunta preg[8] = new PreguntaSelMultiple();
        preg[8].setComplejidadPregunta("Media");
        preg[8].setTipoPregunta("Seleccion Multiple");
        preg[8].setEnunciadoPregunta("Donde se produce la glucólisis?");
        
        listarespuesta[0]="En el citoplasma.";
        listarespuesta[1]="En la matriz mitocondrial.";
        listarespuesta[2]="En la membrana interna de las mitocondrias.";
        listarespuesta[3]="En los cloroplastos.";
        
        preg[8].setRespuestas(listarespuesta);
        
        
       // Pregunta preg[9] = new PreguntaSelMultiple();
        preg[9].setComplejidadPregunta("Interesante");
        preg[9].setTipoPregunta("Seleccion Multiple");
        preg[9].setEnunciadoPregunta("Cuales son los productos importantes de la fermentación del jugo de uva por los hongos esenciales para la producción de champaña?");
        
        listarespuesta[0]="Ácido Láctico y NAD+.";
        listarespuesta[1]="ATP y CO2.";
        listarespuesta[2]="ATP y etanol.";
        listarespuesta[3]="CO2 y etanol.";
        
        preg[9].setRespuestas(listarespuesta);
        
        
       // Pregunta preg[10] = new PreguntaSelMultiple();
        preg[10].setComplejidadPregunta("Interesante");
        preg[10].setTipoPregunta("Seleccion Multiple");
        preg[10].setEnunciadoPregunta("Casi todo el ATP producido en la respiración aeróbica proviene de");
        
        listarespuesta[0]="Glucólisis.";
        listarespuesta[1]="El ciclo del ácido Cítrico.";
        listarespuesta[2]="El sistema de transporte de electrones.";
        listarespuesta[3]="Fermentación.";
        
        preg[10].setRespuestas(listarespuesta);
        
        
     //   Pregunta preg[11] = new PreguntaSelMultiple();
        preg[11].setComplejidadPregunta("Interesante");
        preg[11].setTipoPregunta("Seleccion Multiple");
        preg[11].setEnunciadoPregunta("Un conjunto de canales membranosos, rodeados de ribosomas reciben el nombre de :");
        
        listarespuesta[0]="Lisosomas.";
        listarespuesta[1]="Aparato de Golgi";
        listarespuesta[2]="Retículo endoplásmico rugoso.";
        listarespuesta[3]="etículo endoplásmico liso.";
        
        preg[11].setRespuestas(listarespuesta);
        
        
       // Pregunta preg[12] = new PreguntaSelMultiple();
        preg[12].setComplejidadPregunta("Interesante");
        preg[12].setTipoPregunta("Seleccion Multiple");
        preg[12].setEnunciadoPregunta("Si una célula animal se coloca en una solución cuya concentración de solutos es mayor que la que se encuentra en el interior de la célula :");
        
        listarespuesta[0]="La célula se hinchará.";
        listarespuesta[1]="La célula se encogerá.";
        listarespuesta[2]="La célula permanecerá del mismo tamaño.";
        listarespuesta[3]="La solución se describe como hipertónica.";
        
        preg[12].setRespuestas(listarespuesta);  
        
       
            areaArchivo.setText(preg[i].getComplejidadPregunta());
            areaArchivo.setText(preg[i].getTipoPregunta());
            areaArchivo.setText(preg[i].getEnunciadoPregunta());
            for(int j=0;j<4;j++)
            {
                areaArchivo.setText(preg[i].getRespuestas()[j]);
            }
            areaArchivo.setText("\n");
        }
        

    }
 
    
    
}