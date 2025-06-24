/*
Esta clase representa la ventana para el registro de números de vuelo. Contiene un campo de texto 
para ingresar el número de vuelo, y botones para registrar el número, limpiar el campo y volver al 
menú principal. Los elementos de la ventana están configurados para ser visibles y funcionales.
*/

package vista;

import Utilerias.Utilidades;
import controlador.controlNumVuelo;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 * Clase para la ventana de registro de número de vuelo.
 */
public class NumVuelo extends JFrame{
    
    /** Botón para volver al menú principal. */
    public JButton jbVolver;
    
    /** Botón para registrar el número de vuelo. */
    public JButton jbRegistrar;
    
    /** Botón para limpiar el campo de texto. */
    public JButton jbLimpiar;
    
    /** Título de la ventana. */
    public JLabel jlTitulo;
    
    /** Etiqueta para el campo de texto. */
    public JLabel jlNum;
    
    /** Campo de texto para ingresar el número de vuelo. */
    public JTextField jtNum;
    
    /**
     * Constructor de la clase.
     */
    public NumVuelo(){
        super("Vuelos Unifly");
        setSize(400, 350);
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
        controlNumVuelo ctr = new controlNumVuelo(this); // Controlador
        
        // Título
        jlTitulo = Utilidades.label(70, 30, 300, 40, "Registro de numero de vuelo");
        add(jlTitulo);
        
        // Etiqueta y campo de texto para el número de vuelo
        jlNum = Utilidades.label(30, 110, 200, 30, "Numero de vuelo:");
        add(jlNum);
        
        jtNum = new JTextField();
        jtNum.setBounds(235, 110, 100, 30);
        add(jtNum);
        
        // Botones
        jbRegistrar = Utilidades.botones(10, 220, 110, 35, "Registrar");
        jbRegistrar.addActionListener(ctr);
        add(jbRegistrar);
        
        jbLimpiar = Utilidades.botones(140, 220, 110, 35, "Limpiar");
        jbLimpiar.addActionListener(ctr);
        add(jbLimpiar);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/volver.png"));
        jbVolver = Utilidades.botones(270, 220, 110, 35, "Volver");
        jbVolver.setIcon(icon);
        jbVolver.addActionListener(ctr);
        add(jbVolver);
    }
}