/*
Ventana de registro de destino para la aplicación.
Permite al usuario ingresar información sobre el destino, como el país, la ciudad y el aeropuerto.
La ventana incluye campos de texto para ingresar estos datos, así como botones para registrar, limpiar y volver atrás.
Los elementos de la ventana están configurados para ser visibles y funcionales.
Extiende de JFrame para representar una ventana de la interfaz gráfica.
*/

/*
Proyecto Desarrollo 1
Clase de la ventana de registro de destinos 
Integrantes: Oscar Jimenez          - cod: 2264419
             Juan Pablo Ochoa       - cod: 2559894
             Juan Alejandro Jimenez - cod: 2266096
             Jose David Marmol      - cod: 2266370
Fecha:  7 de mayo del 2025
Versión: 1.1
*/

package vista;

import Utilerias.Utilidades;
import controlador.ControlRegistroDestino;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 * Ventana de registro de destino para la aplicación.
 * Permite al usuario ingresar información sobre el destino, como el país, la ciudad y el aeropuerto.
 * La ventana incluye campos de texto para ingresar estos datos, así como botones para registrar, limpiar y volver atrás.
 * Los elementos de la ventana están configurados para ser visibles y funcionales.
 * Extiende de JFrame para representar una ventana de la interfaz gráfica.
 */
public class RegistroDestino extends JFrame{
    
    // Declaración de componentes
    /** Etiqueta para el país. */
    public JLabel jlDest;
    
    /** Etiqueta para el título. */
    public JLabel jlTitulo;
    
    /** Etiqueta para el aeropuerto. */
    public JLabel jlAereop;
    
    /** Campo de texto para el país. */
    public JTextField jtPais;
    
    /** Campo de texto para el aeropuerto. */
    public JTextField jtAereop;
    
    /** Campo de texto para la ciudad. */
    public JTextField jtCiudad;
    
    /** Botón para volver atrás. */
    public JButton jbVolver;
    
    /** Botón para registrar. */
    public JButton jbRegistrar;
    
    /** Botón para limpiar campos. */
    public JButton jbLimpiar;
    
    /** Referencia a la ventana principal. */
    public Registro ctrRegistro;
            
    // Constructor de la ventana de registro de destino
    /**
     * Constructor de la clase.
     * @param r Referencia a la ventana principal.
     */
    public RegistroDestino(Registro r){
        super("Vuelos Unifly");
        ctrRegistro = r;
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/ImagenAvion.png")).getImage());
        setLayout(null);
        crearGUI();
        setVisible(true);
    }

    // Método para crear la interfaz gráfica de la ventana
    private void crearGUI() {
        ControlRegistroDestino ctr = new ControlRegistroDestino(this);
        
        // Configuración de labels y campos de texto
        jlTitulo = new JLabel("REGISTRO DE DESTINO");
        jlTitulo.setBounds(165, 40, 200, 30);
        jlTitulo.setForeground(Color.DARK_GRAY);
        jlTitulo.setFont(new Font("Book Antiqua", Font.CENTER_BASELINE, 15));
        add(jlTitulo);
        
        jlDest = new JLabel("Ingrese el país");
        jlDest.setBounds(80, 100, 220, 30);
        jlDest.setForeground(Color.DARK_GRAY);
        jlDest.setFont(new Font("Book Antiqua", Font.CENTER_BASELINE, 18));
        add(jlDest);
        
        jtPais = new JTextField();
        jtPais.setBounds(230, 100, 130, 25);
        add(jtPais);
        
        jlDest = new JLabel("Ingrese la ciudad");
        jlDest.setBounds(80, 140, 220, 30);
        jlDest.setForeground(Color.DARK_GRAY);
        jlDest.setFont(new Font("Book Antiqua", Font.CENTER_BASELINE, 18));
        add(jlDest);
        
        jtCiudad = new JTextField();
        jtCiudad.setBounds(230, 140, 130, 25);
        add(jtCiudad);
        
        jlAereop = new JLabel("Ingrese el aeropuerto");
        jlAereop.setBounds(80, 180, 220, 30);
        jlAereop.setForeground(Color.DARK_GRAY);
        jlAereop.setFont(new Font("Book Antiqua", Font.CENTER_BASELINE, 18));
        add(jlAereop);
        
        jtAereop = new JTextField();
        jtAereop.setBounds(260, 180, 130, 25);
        add(jtAereop);
        
        // Configuración de botones
        jbRegistrar = new JButton("Registrar");
        jbRegistrar.setBounds(20, 280, 100, 30);
        jbRegistrar.setFocusable(false);
        jbRegistrar.addActionListener(ctr);
        add(jbRegistrar);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/volver.png"));
        jbVolver = new JButton("Volver");
        jbVolver.setBounds(350, 280, 100, 35);
        jbVolver.setFocusable(false);
        jbVolver.setIcon(icon);
        jbVolver.addActionListener(ctr);
        add(jbVolver);
        
        jbLimpiar = Utilidades.botones(180, 280, 100, 30, "Limpiar");
        jbLimpiar.setToolTipText("Limpiar campos");
        jbLimpiar.addActionListener(ctr);
        add(jbLimpiar);
    }
}