/*
Este código crea una ventana de consultas para la aplicación de reserva de vuelos. 
La ventana contiene botones para realizar diferentes tipos de consultas, como consultas por cédula, 
número de vuelo, ciudad, tipo de maleta, etc. La ventana también incluye un botón para volver a la ventana 
anterior y utiliza un controlador (controlConsultas) para manejar las acciones de los botones.
 */

package vista;

import Utilerias.Utilidades;
import controlador.controlConsultas;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 * Ventana para realizar consultas en la aplicación de reserva de vuelos.
 */
public class Consultas extends JFrame {

    /** Botón para volver a la ventana anterior */
    public JButton jbVolver;
    /** Botón para realizar consulta por cédula */
    public JButton jbCedula;
    /** Botón para realizar consulta por número de vuelo */
    public JButton jbNumVuelo;
    /** Botón para realizar consulta por ciudad */
    public JButton jbCiudad;
    /** Botón para realizar consulta por tipo de maleta */
    public JButton jbMaleta;
    /** Botón para realizar consulta por tipo de clase */
    public JButton jbPorClase;
    /** Botón para realizar consulta por país */
    public JButton jbPorPais;
    /** Botón para realizar consulta por edad */
    public JButton jbPorEdad;
    /** Etiqueta de título */
    public JLabel jlTitulo;

    /**
     * Constructor de la clase.
     */
    public Consultas() {
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
        controlConsultas ctr = new controlConsultas(this);

        jlTitulo = Utilidades.label(150, 30, 300, 30, "Apartado de consultas");
        add(jlTitulo);

        jbCedula = Utilidades.botones(50, 90, 200, 35, "Consulta por cédula");
        jbCedula.addActionListener(ctr);
        add(jbCedula);

        jbNumVuelo = Utilidades.botones(270, 90, 200, 35, "Consulta por número de vuelo");
        jbNumVuelo.addActionListener(ctr);
        add(jbNumVuelo);

        jbCiudad = Utilidades.botones(50, 140, 200, 35, "Consulta por ciudad");
        jbCiudad.addActionListener(ctr);
        add(jbCiudad);

        jbMaleta = Utilidades.botones(270, 140, 200, 35, "Consulta por tipo de maleta");
        jbMaleta.addActionListener(ctr);
        add(jbMaleta);

        jbPorClase = Utilidades.botones(50, 190, 200, 35, "Consulta por tipo de clase");
        jbPorClase.addActionListener(ctr);
        add(jbPorClase);

        jbPorPais = Utilidades.botones(270, 190, 200, 35, "Consulta por país");
        jbPorPais.addActionListener(ctr);
        add(jbPorPais);

        jbPorEdad = Utilidades.botones(50, 240, 200, 35, "Consulta por edad");
        jbPorEdad.addActionListener(ctr);
        add(jbPorEdad);

        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/volver.png"));
        jbVolver = Utilidades.botones(370, 290, 120, 35, "Volver");
        jbVolver.setIcon(icon);
        jbVolver.addActionListener(ctr);
        add(jbVolver);
    }
}