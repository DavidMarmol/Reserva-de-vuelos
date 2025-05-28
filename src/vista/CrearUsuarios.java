package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * Ventana para la creación de usuarios.
 */
public class CrearUsuarios extends JFrame {

    /** Botón para crear el usuario */
    public JButton jbCrear;
    /** Botón para volver */
    public JButton jbVolver;
    /** Etiqueta de título */
    public JLabel jlText;
    /** Etiqueta para el nombre */
    public JLabel jlNom;
    /** Etiqueta para el código de acceso */
    public JLabel jlCodAcc;
    /** Etiqueta para el cargo */
    public JLabel jlCargo;
    /** Etiqueta para el número de cédula */
    public JLabel jlCedu;
    /** Etiqueta para el número de celular */
    public JLabel jlNumCel;
    /** Campo de texto para el nombre */
    public JTextField jtNom;
    /** Campo de texto para el código de acceso */
    public JTextField jtCodAcc;
    /** Campo de texto para el cargo */
    public JTextField jtCargo;
    /** Campo de texto para el número de cédula */
    public JTextField jtCedu;
    /** Campo de texto para el número de celular */
    public JTextField jtNumCel;

    /** Constructor de la clase */
    public CrearUsuarios() {
        super("Creación de usuarios");
        setSize(500, 370);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/ImagenAvion.png")).getImage());
        setLayout(null);
        crearGUI();
        setVisible(true);
    }

    /** Método para crear la interfaz gráfica de la ventana */
    private void crearGUI() {
        jlText = Utilidades.label(0, 10, 500, 40, "Creacion de usuario");
        jlText.setOpaque(true);
        jlText.setForeground(Color.black);
        add(jlText);

        jlText = Utilidades.label(10, 50, 250, 30, "Creación de administrador");
        add(jlText);

        jlNom = Utilidades.label(10, 90, 100, 30, "Nombre:");
        add(jlNom);
        jtNom = new JTextField();
        jtNom.setBounds(190, 90, 160, 30);
        add(jtNom);

        jlCodAcc = Utilidades.label(10, 130, 210, 30, "Codigo de acceso:");
        add(jlCodAcc);
        jtCodAcc = new JTextField();
        jtCodAcc.setBounds(190, 130, 140, 30);
        add(jtCodAcc);

        jlCedu = Utilidades.label(10, 170, 210, 30, "Numero de cedula:");
        add(jlCedu);
        jtCedu = new JTextField();
        jtCedu.setBounds(190, 170, 140, 30);
        add(jtCedu);

        jlCargo = Utilidades.label(10, 210, 100, 30, "Cargo:");
        add(jlCargo);
        jtCargo = new JTextField();
        jtCargo.setBounds(190, 210, 140, 30);
        add(jtCargo);

        jlNumCel = Utilidades.label(10, 250, 210, 30, "Numero celular:");
        add(jlNumCel);
        jtNumCel = new JTextField();
        jtNumCel.setBounds(190, 250, 140, 30);
        add(jtNumCel);

        jbCrear = Utilidades.botones(380, 300, 90, 30, "Crear");
        jbCrear.setBackground(Color.BLUE);
        jbCrear.setForeground(Color.white);
        add(jbCrear);

        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/volver.png"));
        jbVolver = Utilidades.botones(10, 300, 110, 35, "Salir");
        jbVolver.setIcon(icon);
        add(jbVolver);
    }
}