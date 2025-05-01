package vista;

import utilerias.LimitadorCaracteres;
import controlador.controlLogin;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 * Ventana de login del sistema.
 * Permite al usuario ingresar su nombre de usuario y contraseña.
 */
public class VistaLogin extends JFrame{
    
    public JTextField jtLogin; // Campo de texto para el nombre de usuario
    public JPasswordField jpPassw; // Campo de texto para la contraseña
    public JToggleButton jtVer; // Botón para ver u ocultar la contraseña
    public JButton jbCancelar, jbingresar; // Botones para cancelar e ingresar
    public ImageIcon ver, no_ver; // Iconos para el botón de ver contraseña

    /**
     * Constructor de la clase.
     * Crea la ventana de login e inicializa sus componentes.
     */
    public VistaLogin(){
        super("Inicio");
        setSize(400, 300);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/ImagenAvion.png")).getImage());
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        crearGUI();
        setVisible(true);
    
        JOptionPane.showMessageDialog(this, "Usuario defecto: user \n Contraseña por defecto: 1234");
    }

    /**
     * Método para crear la interfaz gráfica de la ventana.
     */
    private void crearGUI() {
        controlLogin ctr = new controlLogin(this);
        
        // Etiqueta con imagen de título
        ImageIcon im = new ImageIcon(getClass().getResource("/Imagenes/login.png"));
        JLabel jlTitulo = new JLabel("", im, JLabel.CENTER);
        jlTitulo.setBounds(0, 0, 400, 75);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(Color.white);
        jlTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(jlTitulo);

        // Etiqueta y campo de texto para el nombre de usuario
        JLabel jlLogin = new JLabel("Usuario");
        jlLogin.setBounds(10, 90, 100, 30);
        jlLogin.setHorizontalAlignment(JLabel.RIGHT);
        add(jlLogin);

        jtLogin = new JTextField();
        jtLogin.setBounds(120, 90, 150, 30);
        jtLogin.setDocument(new LimitadorCaracteres(jtLogin, 30, ABORT));   
        jtLogin.addActionListener(ctr);  
        add(jtLogin);

        // Etiqueta y campo de texto para la contraseña
        JLabel jlPass = new JLabel("Contraseña");
        jlPass.setBounds(10, 140, 100, 30);
        jlPass.setHorizontalAlignment(JLabel.RIGHT);
        add(jlPass);

        jpPassw = new JPasswordField();
        jpPassw.setBounds(120, 140, 150, 30);
        jpPassw.setEchoChar('*');
        add(jpPassw);

        // Botón para ver u ocultar la contraseña
        ver  = new ImageIcon(getClass().getResource("/Imagenes/visible.png"));
        no_ver  = new ImageIcon(getClass().getResource("/Imagenes/no-visible.png"));
        jtVer = new JToggleButton(no_ver);
        jtVer.setBounds(275, 140, 80, 40);
        jtVer.setBorderPainted(false);//quitar el borde del boton
        jtVer.setFocusPainted(false);//quitar el recuadro del foco del boton
        jtVer.setContentAreaFilled(false);//quita el color de fondo del boton 
        jtVer.addActionListener(ctr);
        add(jtVer);

        // Botones de cancelar e ingresar
        jbCancelar = new JButton("Cancelar");
        jbCancelar.setBounds(45, 200, 150, 35);
        jbCancelar.addActionListener(ctr);
        add(jbCancelar);

        jbingresar = new JButton("Ingresar");
        jbingresar.setBounds(205, 200, 150, 35);
        jbingresar.addActionListener(ctr);
        jbingresar.setMnemonic('I');
        add(jbingresar);
    }
}