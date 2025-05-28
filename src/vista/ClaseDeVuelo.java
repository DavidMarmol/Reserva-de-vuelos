/*
Esta clase utiliza la clase Utilidades para crear componentes visuales como etiquetas 
y botones. La clase controlClaseVuelo se utiliza para manejar las acciones de los botones en esta ventana.
*/

/*
Proyecto Desarrollo 1
Clase de la ventana de registro de las clases de vuelo 
Integrantes: Oscar Jimenez          - cod: 2264419
             Juan Pablo Ochoa       - cod: 2559894
             Juan Alejandro Jimenez - cod: 2266096
             Jose David Marmol      - cod: 2266370
Fecha:  7 de mayo del 2025
Versión: 1.1
*/

package vista;


import controlador.controlClaseVuelo;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import utilerias.Utilidades;

/**
 * Ventana para seleccionar la clase de vuelo.
 */
public class ClaseDeVuelo extends JFrame {

    /** Botón para registrar la clase de vuelo */
    public JButton jbRegistrar;
    /** Botón para volver atrás */
    public JButton jbVolver;
    /** Botón para limpiar los campos */
    public JButton jbLimpiar;
    /** Etiqueta para la pregunta de selección */
    public JLabel jlPreg;
    /** Etiqueta para el título de la ventana */
    public JLabel jlTitulo;
    /** ComboBox para seleccionar la clase de vuelo */
    public JComboBox<String> jcResp;
    /** Referencia a la instancia de la ventana de Registro */
    public Registro ct;

    /**
     * Constructor de la clase.
     * @param r La instancia de la ventana de Registro
     */
    public ClaseDeVuelo(Registro r) {
        super("Vuelos Unifly");
        ct = r;
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
        controlClaseVuelo ctr = new controlClaseVuelo(this);

        jlTitulo = Utilidades.label(130, 30, 300, 30, "Tipo de clase de vuelo");
        add(jlTitulo);

        jlPreg = Utilidades.label(20, 100, 250, 30, "Seleccione la clase de vuelo");
        jlPreg.setFont(new Font("Book Antiqua", Font.BOLD, 18));
        add(jlPreg);

        jcResp = new JComboBox<>();
        jcResp.addItem("Seleccione:");
        jcResp.addItem("Primera clase");
        jcResp.addItem("Clase económica");
        jcResp.setBounds(275, 100, 160, 30);
        add(jcResp);

        jbRegistrar = Utilidades.botones(20, 300, 100, 30, "Registrar");
        jbRegistrar.addActionListener(ctr);
        add(jbRegistrar);

        jbLimpiar = Utilidades.botones(190, 300, 100, 30, "Limpiar");
        jbLimpiar.addActionListener(ctr);
        add(jbLimpiar);

        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/volver.png"));
        jbVolver = Utilidades.botones(350, 300, 110, 35, "Volver");
        jbVolver.setIcon(icon);
        jbVolver.addActionListener(ctr);
        add(jbVolver);
    }
}