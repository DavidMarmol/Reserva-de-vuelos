/*
Este código define una clase TipoMaleta que representa la ventana para seleccionar el tipo de maleta 
en la aplicación. La ventana contiene una etiqueta para indicar la selección, un ComboBox para elegir el tipo 
de maleta, y botones para registrar, volver y limpiar la selección. Los elementos de la ventana están configurados para ser visibles y funcionales.
*/

/*
Proyecto Desarrollo 1
Clase de la ventana del registro de maleta 
Integrantes: Oscar Jimenez          - cod: 2264419
             Juan Pablo Ochoa       - cod: 2559894
             Juan Alejandro Jimenez - cod: 2266096
             Jose David Marmol      - cod: 2266370
Fecha:  7 de mayo del 2025
Versión: 1.1
*/

package vista;

import Utilerias.Utilidades;
import controlador.controlTipoMaleta;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 * Ventana para seleccionar el tipo de maleta.
 */
public class TipoMaleta extends JFrame{
    
    public JLabel jlTitulo, jlPreg;
    public JComboBox<String> jcResp;
    public JButton jbVolver, jbRegistrar, jbLimpiar;
    public Registro r;
    
    /**
     * Constructor que recibe la ventana principal.
     *
     * @param r la ventana principal.
     */
    public TipoMaleta(Registro r){
        super("Vuelos Unifly");
        this.r = r;
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
     * Crea la interfaz gráfica de la ventana.
     */
    private void crearGUI() {
        controlTipoMaleta ctr = new controlTipoMaleta(this);
        
        // Etiquetas y combobox
        
        jlTitulo = Utilidades.label(175, 20, 200, 30, "Tipo de maleta");
        add(jlTitulo);
        
        jlPreg = Utilidades.label(40, 90, 300, 30, "Seleccione el tipo de maleta");
        jlPreg.setFont(new Font("Book Antiqua", Font.BOLD, 18));
        add(jlPreg);
        
        jcResp = new JComboBox<>();
        jcResp.addItem("Seleccione:");
        jcResp.addItem("Maleta de mano");
        jcResp.addItem("Maleta de bodega");
        jcResp.addItem("Ambas");
        jcResp.setBounds(40, 130, 200, 30);
        add(jcResp);
        
        
        // Botones
        
        jbRegistrar = Utilidades.botones(30, 290, 120, 30, "Registrar");
        jbRegistrar.addActionListener(ctr);
        add(jbRegistrar);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/volver.png"));
        jbVolver = Utilidades.botones(360, 290, 120, 35, "Volver");
        jbVolver.setIcon(icon);
        jbVolver.addActionListener(ctr);
        add(jbVolver);  
        
        jbLimpiar = Utilidades.botones(185, 290, 120, 30, "Limpiar");
        jbLimpiar.addActionListener(ctr);
        add(jbLimpiar);  
    }
}