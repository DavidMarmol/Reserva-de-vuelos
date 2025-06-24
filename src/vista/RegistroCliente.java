/*
Esta clase Registro representa la ventana de registro de clientes en la aplicación. 
Contiene campos para ingresar la cédula, nombre y edad del cliente, junto con botones para registrar, limpiar y volver atrás.
*/

/*
Proyecto Desarrollo 1
Clase de la ventana de registro de clientes 
Integrantes: Oscar Jimenez          - cod: 2264419
             Juan Pablo Ochoa       - cod: 2559894
             Juan Alejandro Jimenez - cod: 2266096
             Jose David Marmol      - cod: 2266370
Fecha:  7 de mayo del 2025
Versión: 1.1
*/

package vista;

import Utilerias.Utilidades;
import controlador.ControlRegistroCliente;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 * Ventana para el registro de clientes.
 */
public class RegistroCliente extends JFrame{
    public JButton jbRegistro, jbDestino, jbVolver, jbLimpiar; // Botones de la ventana
    public JLabel jlCedula, jlEdad, jlNombre, jlTitulo; // Etiquetas de la ventana
    public JTextField jtCedula, jtEdad, jtNombre; // Campos de texto para ingresar datos
    public Registro ctrRegistro; // Referencia a la ventana principal
    
    /**
     * Constructor de la clase.
     * @param registro Referencia a la ventana principal.
     */
    public RegistroCliente(Registro registro){
        super("Vuelos Unifly");
        ctrRegistro = registro; // Asignar referencia a la ventana principal
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
        ControlRegistroCliente ctr = new ControlRegistroCliente(this); // Controlador
        
        // Labels y campos de texto
        jlTitulo = new JLabel("REGISTRO DE CLIENTES");
        jlTitulo.setForeground(Color.DARK_GRAY);
        jlTitulo.setBounds(175, 40, 200, 30);
        jlTitulo.setFont(new Font("Book Antiqua", Font.CENTER_BASELINE, 15));
        add(jlTitulo);
        
        jlCedula = new JLabel("Cedula");
        jlCedula.setForeground(Color.DARK_GRAY);
        jlCedula.setBounds(110, 100, 200, 30);
        jlCedula.setFont(new Font("Book Antiqua", Font.CENTER_BASELINE, 13));
        add(jlCedula);
        
        jtCedula = new JTextField();
        jtCedula.setBounds(170, 100, 200, 25);
        add(jtCedula);

        jlNombre = new JLabel("Nombre");
        jlNombre.setForeground(Color.DARK_GRAY);
        jlNombre.setBounds(110, 150, 200, 30);
        jlNombre.setFont(new Font("Book Antiqua", Font.CENTER_BASELINE, 12));
        add(jlNombre);
        
        jtNombre =  new JTextField();
        jtNombre.setBounds(170, 150, 200, 25);
        add(jtNombre);
        
        jlEdad = new JLabel("Edad");
        jlEdad.setForeground(Color.DARK_GRAY);
        jlEdad.setBounds(110, 200, 200, 30);
        jlEdad.setFont(new Font("Book Antiqua", Font.CENTER_BASELINE, 13));
        add(jlEdad);
        
        jtEdad = new JTextField();
        jtEdad.setBounds(170, 200, 200, 25);
        add(jtEdad);
        
        // Botones
        jbRegistro = new JButton("Registrar");
        jbRegistro.setBounds(20, 300, 120, 30);
        jbRegistro.setToolTipText("Click aquí para registrar un cliente");
        jbRegistro.setFocusable(false);
        jbRegistro.addActionListener(ctr);
        add(jbRegistro);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/volver.png"));
        jbVolver = new JButton("Volver");
        jbVolver.setBounds(320, 300, 120, 35);
        jbVolver.setToolTipText("Click aquí para volver");
        jbVolver.setFocusable(false);
        jbVolver.setIcon(icon);
        jbVolver.addActionListener(ctr);
        add(jbVolver);
        
        jbLimpiar = Utilidades.botones(170, 300, 120, 30, "Limpiar");
        jbLimpiar.setToolTipText("Click para limpiar campos");
        jbLimpiar.addActionListener(ctr);
        add(jbLimpiar);
    }
}