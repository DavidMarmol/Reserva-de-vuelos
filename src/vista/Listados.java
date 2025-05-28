/*
Esta clase representa la ventana principal para acceder a los diferentes listados de la aplicación, como clientes, 
destinos y un listado general. Los botones están configurados para realizar las acciones correspondientes al ser presionados.
*/

package vista;

import utilerias.Utilidades;
import controlador.controlListados;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * Clase para la ventana de listados de la aplicación.
 */
public class Listados extends JFrame{
    
    /** Botón para volver al menú principal. */
    public JButton jbVolver;
    
    /** Botón para acceder al listado de clientes. */
    public JButton jbListCli;
    
    /** Botón para acceder al listado de destinos. */
    public JButton jbListDest;
    
    /** Botón para acceder al listado general. */
    public JButton jbListGeneral;
    
    /** Título de la ventana. */
    public JLabel jlTitulo;
    
    /**
     * Constructor de la clase.
     */
    public Listados(){
        super("Vuelos Unifly");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/ImagenAvion.png")).getImage());
        setLayout(null);
        crearGUI();
        setVisible(true);
    }

    /**
     * Método para crear la interfaz gráfica de la ventana.
     */
    private void crearGUI() {
        controlListados ctr = new controlListados(this); // Controlador
        
        // Título
        jlTitulo = Utilidades.label(150, 30, 300, 30, "Apartado de listados");
        add(jlTitulo);
        
        // Botones para acceder a los listados
        jbListCli = Utilidades.botones(60, 90, 180, 35, "Listado clientes");
        jbListCli.setToolTipText("Acceder al listado de los clientes");
        jbListCli.addActionListener(ctr);
        add(jbListCli);
        
        jbListDest = Utilidades.botones(270, 90, 180, 35, "Listado destinos");
        jbListDest.setToolTipText("Acceder al listado de los destinos");
        jbListDest.addActionListener(ctr);
        add(jbListDest);
        
        jbListGeneral = Utilidades.botones(175, 150, 180, 35, "Listado general");
        jbListGeneral.setToolTipText("Acceder al listado general");
        jbListGeneral.addActionListener(ctr);
        add(jbListGeneral);
        
        // Botón para volver al menú principal
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/volver.png"));
        jbVolver = Utilidades.botones(370, 290, 120, 35, "Volver");
        jbVolver.setIcon(icon);
        jbVolver.addActionListener(ctr);
        add(jbVolver);
    }
}