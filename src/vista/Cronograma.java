/*
Este código crea una ventana para registrar cronogramas de vuelos en la aplicación de reserva de vuelos. 
La ventana contiene etiquetas y campos de texto para ingresar fechas y horas de salida y llegada, 
así como botones para registrar, limpiar y volver a la ventana anterior. Se utiliza un controlador 
(controlCrono) para manejar las acciones de los botones.
*/

/*
Proyecto Desarrollo 1
Clase de la ventana del registro del cronograma
Integrantes: Oscar Jimenez          - cod: 2264419
             Juan Pablo Ochoa       - cod: 2559894
             Juan Alejandro Jimenez - cod: 2266096
             Jose David Marmol      - cod: 2266370
Fecha:  7 de mayo del 2025
Versión: 1.1
*/

package vista;

import controlador.controlCrono;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import utilerias.Utilidades;

/**
 * Ventana para registrar cronogramas de vuelos.
 */
public class Cronograma extends JFrame {

    /** Etiqueta de título */
    public JLabel jlTitulo;
    /** Etiqueta para la hora de salida */
    public JLabel jlHorasal;
    /** Etiqueta para la hora de llegada */
    public JLabel jlHoralle;
    /** Etiqueta para la fecha de salida */
    public JLabel jlFechasal;
    /** Etiqueta para la fecha de llegada */
    public JLabel jlFechalle;
    /** Campo de texto para la hora de salida */
    public JTextField jtHorasal;
    /** Campo de texto para la hora de llegada */
    public JTextField jtHoralle;
    /** Campo de texto para la fecha de salida */
    public JTextField jtFechasal;
    /** Campo de texto para la fecha de llegada */
    public JTextField jtFechalle;
    /** Botón para registrar */
    public JButton jbRegistrar;
    /** Botón para volver */
    public JButton jbVolver;
    /** Botón para limpiar */
    public JButton jbLimpiar;
    /** Ventana de registro */
    public Registro ct;

    /** Constructor de la clase */
    public Cronograma(Registro ct) {
        super("Vuelos Unifly"); // Título de la ventana
        this.ct = ct;
        setSize(500, 400); // Tamaño de la ventana
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // Evitar cierre accidental
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/ImagenAvion.png")).getImage()); // Icono de la ventana
        setLayout(null); // Desactivar el layout manager para posicionar los componentes manualmente
        setResizable(false); // Evitar que la ventana sea redimensionable
        crearGUI(); // Crear la interfaz gráfica
        setVisible(true); // Hacer visible la ventana
    }

    /** Método para crear la interfaz gráfica de la ventana */
    private void crearGUI() {
        controlCrono ctr = new controlCrono(this); // Controlador para manejar las acciones de los botones

        // Labels y JTextFields
        jlTitulo = Utilidades.label(120, 30, 230, 40, "Registro de cronograma");
        add(jlTitulo);

        jlFechasal = Utilidades.label(20, 155, 230, 30, "Fecha/hora de salida");
        jlFechasal.setFont(new Font("Book Antiqua", Font.BOLD, 18));
        add(jlFechasal);

        jtFechasal = new JTextField();
        jtFechasal.setBounds(230, 155, 170, 30);
        jtFechasal.setText("dd/mm/aaaa 00:00pm-am");
        add(jtFechasal);

        jlFechalle = Utilidades.label(20, 210, 230, 30, "Fecha/hora de llegada");
        jlFechalle.setFont(new Font("Book Antiqua", Font.BOLD, 18));
        add(jlFechalle);

        jtFechalle = new JTextField();
        jtFechalle.setBounds(230, 210, 170, 30);
        jtFechalle.setText("dd/mm/aaaa 00:00pm-am");
        add(jtFechalle);

        // Botones
        jbRegistrar = Utilidades.botones(20, 320, 100, 30, "Registrar");
        jbRegistrar.addActionListener(ctr);
        add(jbRegistrar);

        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/volver.png"));
        jbVolver = Utilidades.botones(340, 320, 110, 35, "Volver");
        jbVolver.setIcon(icon);
        jbVolver.addActionListener(ctr);
        add(jbVolver);

        jbLimpiar = Utilidades.botones(190, 320, 100, 30, "Limpiar");
        jbLimpiar.addActionListener(ctr);
        add(jbLimpiar);
    }
}
