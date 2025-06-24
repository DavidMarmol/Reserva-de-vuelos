package vista;

import controlador.control_inicio;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * Ventana de inicio del sistema.
 * Permite al usuario crear un usuario o cerrar la aplicación.
 */
public class VistaInicio extends JFrame{
    
    public JButton jbCrear, jbSalir;
    public JLabel jlTitulo, jlText;
    
    /**
     * Constructor de la clase.
     * Crea la ventana de inicio e inicializa sus componentes.
     */
    public VistaInicio(){
        super("Inicio");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/ImagenAvion.png")).getImage());
        setLayout(null);
        crearGUI();
        setVisible(true);
    }

    /**
     * Método para crear la interfaz gráfica de la ventana.
     */
    private void crearGUI() {
        control_inicio ctr = new control_inicio(this);
        
        jlTitulo = Utilidades.label(10, 10, 400, 50, "Bienvenido al sistema de reserva de vuelos");
        add(jlTitulo);
        jlTitulo = Utilidades.label(10, 30, 400, 50, "Unifly");
        add(jlTitulo);
        
        jlText = Utilidades.label(10, 100, 300, 30, "Cree un usuario para iniciar");
        jlText.setFont(new Font("Harlow Solid Italic", Font.BOLD, 25));
        jlText.setForeground(Color.red);
        add(jlText);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/crear.png"));
        jbCrear = Utilidades.botones(140, 160, 180, 40, "Crear usuario");
        jbCrear.setIcon(icon);
        jbCrear.addActionListener(ctr);
        add(jbCrear);
        
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/imagenes/salir.png"));
        jbSalir = Utilidades.botones(160, 210, 130, 40, "Cerrar app");
        jbSalir.setIcon(icon2);
        jbSalir.addActionListener(ctr);
        add(jbSalir);
    }
}