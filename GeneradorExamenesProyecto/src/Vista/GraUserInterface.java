package Vista;
import java.awt.*;
import javax.swing.*;

public class GraUserInterface extends javax.swing.JFrame {
    
    private static final long serialVersionUID = 1L;
    private Container contenedor;
    private JLabel lblTitulo;
    private JLabel lblUniversidad;
    private JLabel lblMateria;
    private JLabel lblTema;
    private JLabel lblComplejidad;
    private JLabel lblCantExamen;
    private JLabel lblTipoPregunta;
    private JLabel lblDetalleTipoPregunta;
    private JButton btGenerarExam;
    private JButton btcargarpreguntas;
    private JComboBox cbMateria;
    private JComboBox cbComplejidad;
    private JComboBox cbTipoPregunta;
    private JComboBox cbDetalleTipoPregunta;
    private JList lstTema;
    private JTextArea areaArchivo;
    private JScrollPane scrollFuente;
    private JSeparator separador1;
    private JSeparator separador2;
    private JTextField tfCantExam;
    
    
    public GraUserInterface() {
        
        setSize(1000, 700);
        setLocationRelativeTo(null);
	this.setResizable(false);
	inicializar();
	setPositions();
		
	contenedor = getContentPane();
	contenedor.setLayout(null);
	areaArchivo.setEditable(false);
	
	setTitle("Generador Exámenes");
        lblTitulo.setText("GENERADOR DE EXAMENES");
        lblUniversidad.setText("UNIVERSIDAD CENTRAL");
        lblMateria.setText("Materia:");
        lblTema.setText("Temas:");
        lblComplejidad.setText("Complejidad:");
        lblCantExamen.setText("Cantidad Exámenes:");
        lblTipoPregunta.setText("Tipo de Preguntas:");
        lblDetalleTipoPregunta.setText("Tipo Detalle Tipo Preguntas:");
        areaArchivo.setText("Cuestionarios Generados");
        btGenerarExam.setText("GENERAR EXAMEN");
        btcargarpreguntas.setText("CARGAR PREGUNTAS");
        lblCantExamen.setText("Cantidad de examenes:");
		
	scrollFuente.setViewportView(areaArchivo);
	contenedor.add(lblTitulo);
	contenedor.add(lblUniversidad);
	contenedor.add(lblMateria);
        contenedor.add(cbMateria);
        contenedor.add(lblTema);
        contenedor.add(lstTema);
	contenedor.add(lblComplejidad);
	contenedor.add(lblTipoPregunta);
        contenedor.add(lblDetalleTipoPregunta);
	contenedor.add(scrollFuente);
	contenedor.add(cbComplejidad);
        contenedor.add(separador1);
        contenedor.add(separador2);
        contenedor.add(btcargarpreguntas);
        contenedor.add(btGenerarExam);
        contenedor.add(lblCantExamen);
        contenedor.add(tfCantExam);
        contenedor.add(cbTipoPregunta);
        contenedor.add(cbDetalleTipoPregunta);
    }

    private void inicializar(){
        
        lblTitulo = new JLabel();
        lblUniversidad = new JLabel();
        lblMateria = new JLabel();
        lblTema = new JLabel();
        lblComplejidad = new JLabel();
        lblCantExamen = new JLabel();
        lblTipoPregunta = new JLabel();
        lblDetalleTipoPregunta = new JLabel();
        btGenerarExam = new JButton();
        btcargarpreguntas = new JButton();
        cbMateria = new JComboBox();
        cbComplejidad = new JComboBox();
        cbTipoPregunta = new JComboBox();
        cbDetalleTipoPregunta = new JComboBox();
        lstTema = new JList();
        areaArchivo = new JTextArea();
	scrollFuente = new JScrollPane();
        separador1 = new JSeparator();
        separador2 = new JSeparator();
        lblCantExamen = new JLabel();
        tfCantExam = new JTextField();
	
    }
    
    private void setPositions() {
	lblTitulo.setBounds(15, 8, 300, 20);
        lblUniversidad.setBounds(800, 8, 200, 20);
        separador1.setBounds(7, 50, 983, 10);
	lblMateria.setBounds(15, 60, 220, 20);
        cbMateria.setBounds(240, 60, 200, 20);
        lblComplejidad.setBounds(15, 85, 220, 20);
        cbComplejidad.setBounds(240,85,200,20);
	lblTipoPregunta.setBounds(15,110,220,20);
        cbTipoPregunta.setBounds(240,110,200,20); 
        lblDetalleTipoPregunta.setBounds(15,135,220,20);
        cbDetalleTipoPregunta.setBounds(240,135,200,20);
        lblTema.setBounds(460,60,100,20);
        lstTema.setBounds(560,60,200,20);
        tfCantExam.setBounds(190, 180, 50, 30);
        lblCantExamen.setBounds(15, 180, 185, 30);
        btGenerarExam.setBounds(600, 180, 185, 30);
        btcargarpreguntas.setBounds(800, 180, 185, 30);
        separador2.setBounds(7, 220, 983, 10);
        scrollFuente.setBounds(15, 230, 970, 435);
		
	}
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    
    public static void main(String args[]) {
        GraUserInterface principal;
        principal = new GraUserInterface();
        principal.setVisible(true);
    }
    // Variables declaration - do not modify                     
    // End of variables declaration                   
}

