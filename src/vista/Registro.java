/*
Esta clase representa la ventana de registro de tickets de la aplicación. Contiene botones para 
registrar diferentes aspectos de un vuelo, como el número de vuelo, el cliente, el destino, la clase de vuelo, 
el cronograma y el tipo de maleta. Los elementos de la ventana están configurados para ser visibles y funcionales.
*/

/*
Proyecto Desarrollo 1
clase de la ventana de registros
Integrantes: Oscar Jimenez          - cod: 2264419
             Juan Pablo Ochoa       - cod: 2559894
             Juan Alejandro Jimenez - cod: 2266096
             Jose David Marmol      - cod: 2266370
Fecha:  7 de mayo del 2025
Versión: 1.1
*/

package vista;

import controlador.controlRegistro;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import reservadevuelos.ReservaDeVuelos;
import utilerias.Utilidades;

/**
 * Clase para la ventana de registro de tickets.
 */
public class Registro extends JFrame{
    
    /** Botón para registrar el número de vuelo. */
    public JButton jbNumVuelo;
    
    /** Botón para registrar un cliente. */
    public JButton jbCliente;
    
    /** Botón para registrar el destino. */
    public JButton jbDestino;
    
    /** Botón para registrar la clase de vuelo. */
    public JButton jbClaseDeVuelo;
    
    /** Botón para registrar el cronograma. */
    public JButton jbCrono;
    
    /** Botón para registrar el tipo de maleta. */
    public JButton jbMaleta;
    
    /** Botón para volver al menú principal. */
    public JButton jbVolver;
    
    /** Título de la ventana. */
    public JLabel jlTitulo;
    
    /** Instancia de la clase principal ReservaDeVuelos. */
    public ReservaDeVuelos rv;
    
    /**
     * Constructor de la clase.
     */
    public Registro(){
        super("Vuelos Unifly");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/ImagenAvion.png")).getImage());
        setLayout(null);
        crearGUI();
        setVisible(true);
        JOptionPane.showMessageDialog(this, "Ingresar Datos en Orden Numerico");
    }

    /**
     * Método para crear la interfaz gráfica de la ventana.
     */
    private void crearGUI() {
        controlRegistro ctr = new controlRegistro(this); // Controlador
        
        // Título
        jlTitulo = new JLabel("Registro de ticket");
        jlTitulo.setBounds(165, 30, 230, 30);
        jlTitulo.setForeground(Color.DARK_GRAY);
        jlTitulo.setFont(new Font("Book Antiqua", Font.CENTER_BASELINE, 20));
        add(jlTitulo);
        
        // Botones
        jbNumVuelo = new JButton("# De vuelo");
        jbNumVuelo.setBounds(190, 80, 120, 30);
        jbNumVuelo.setToolTipText("Click aquí para registrar el numero de vuelo");
        jbNumVuelo.setFocusable(false);
        jbNumVuelo.addActionListener(ctr);
        add(jbNumVuelo);
        
        
        JLabel num1 = new JLabel("1");
        num1.setBounds(170, 85, 100, 20);
        num1.setFont(new Font("Arial", Font.BOLD, 15));
        num1.setForeground(Color.blue);
        add(num1);
        
        
        jbCliente = new JButton("Cliente");
        jbCliente.setBounds(190, 120, 120, 30);
        jbCliente.setToolTipText("Click aquí para registrar un cliente");
        jbCliente.setFocusable(false);
        jbCliente.addActionListener(ctr);
        add(jbCliente);
        
        JLabel num2 = new JLabel("2");
        num2.setBounds(170, 125, 100, 20);
        num2.setFont(new Font("Arial", Font.BOLD, 15));
        num2.setForeground(Color.blue);
        add(num2);
        
        
        jbDestino = Utilidades.botones(190, 160, 120, 30, "Destino");
        jbDestino.setToolTipText("Click para registrar el destino");
        jbDestino.addActionListener(ctr);
        add(jbDestino);
        
        
        JLabel num3 = new JLabel("3");
        num3.setBounds(170, 165, 100, 20);
        num3.setFont(new Font("Arial", Font.BOLD, 15));
        num3.setForeground(Color.blue);
        add(num3);
        
        
        jbClaseDeVuelo = Utilidades.botones(190, 200, 120, 30, "Clase de vuelo");
        jbClaseDeVuelo.setToolTipText("Registrar clase de vuelo");
        jbClaseDeVuelo.addActionListener(ctr);
        add(jbClaseDeVuelo);
        
        
        JLabel num4 = new JLabel("4");
        num4.setBounds(170, 205, 100, 20);
        num4.setFont(new Font("Arial", Font.BOLD, 15));
        num4.setForeground(Color.blue);
        add(num4);
        
        
        jbCrono = Utilidades.botones(190, 240, 120, 30, "Cronograma");
        jbCrono.setToolTipText("Registrar el cronograma");
        jbCrono.addActionListener(ctr);
        add(jbCrono);
        
        
        JLabel num5 = new JLabel("5");
        num5.setBounds(170, 245, 100, 20);
        num5.setFont(new Font("Arial", Font.BOLD, 15));
        num5.setForeground(Color.blue);
        add(num5);
        
        
        jbMaleta = Utilidades.botones(190, 280, 120, 30, "Tipo de maleta");
        jbMaleta.setToolTipText("Registrar tipo de maleta");
        jbMaleta.addActionListener(ctr);
        add(jbMaleta);
        
        
        JLabel num6 = new JLabel("6");
        num6.setBounds(170, 285, 100, 20);
        num6.setFont(new Font("Arial", Font.BOLD, 15));
        num6.setForeground(Color.blue);
        add(num6);
        
        
        // Botón Volver
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/volver.png"));
        jbVolver = new JButton("Volver");
        jbVolver.setBounds(360, 325, 120, 35);
        jbVolver.setToolTipText("Click aquí para volver");
        jbVolver.setFocusable(false);
        jbVolver.setIcon(icon);
        jbVolver.addActionListener(ctr);
        add(jbVolver);
        
        /*
        JLabel qr = new JLabel("QR Javadocs");
        qr.setBounds(5, 195, 100, 20);
        qr.setFont(new Font("Arial", Font.BOLD, 15));
        qr.setForeground(Color.red);
        add(qr);*/
    }
}