/*
La clase menu es la vista principal de la aplicación de reservas de vuelos. Presenta un menú 
con opciones para registrar usuarios, acceder a listados, realizar consultas, ver gráficas, obtener 
información y salir. También incluye un diálogo de información sobre los programadores. Los botones 
del menú están configurados para ejecutar acciones a través de un controlador.
*/

/*
Proyecto Desarrollo 1
Clase de la ventana del menu principal
Integrantes: Oscar Jimenez          - cod: 2264419
             Juan Pablo Ochoa       - cod: 2559894
             Juan Alejandro Jimenez - cod: 2266096
             Jose David Marmol      - cod: 2266370
Fecha:  29 de abril del 2025
Versión: 1.0
*/

package vista;

import utilerias.Utilidades;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controlador.controlMenu;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JDialog;
import javax.swing.JPanel;
import reservadevuelos.ReservaDeVuelos;

/**
 * Clase que define el menú principal de la aplicación.
 */
public class menu extends JFrame{
    
    public JButton jbIniSesion, jbRegistro, jbListados, 
            jbConsultas, jbGraficas, jbInfo, jbSalir, jbAprendiz, jbPdfs, jdQR;
    public JLabel jlImg, jlTitulo;
    
    /**
     * Constructor de la clase.
     * Crea la ventana del menú principal e inicializa sus componentes.
     */
    public menu (){
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
     * Método privado para inicializar y configurar los componentes del menú.
     */
    private void crearGUI() {
        controlMenu ctr = new controlMenu(this);
        
        // Imagen del logo
        ImageIcon img1 = new ImageIcon(getClass().getResource("/imagenes/logo.jpg/"));
        jlImg = new JLabel(img1);
        jlImg.setBounds(0, 0, 128, 128);
        add(jlImg);
        
        // Título de la aplicación
        jlTitulo = Utilidades.label(150, 30, 300, 30, "Reserva de vuelos Unifly");
        add(jlTitulo);
        
        // Botones del menú
        ImageIcon icon3 = new ImageIcon(getClass().getResource("/imagenes/reg.png"));
        jbRegistro = new JButton("Registrar");
        jbRegistro.setBounds(190, 80, 120, 40);
        jbRegistro.setToolTipText("Click aquí para registrar");
        jbRegistro.setMnemonic('R');
        jbRegistro.setFocusable(false);
        jbRegistro.setIcon(icon3);
        jbRegistro.addActionListener(ctr);
        add(jbRegistro);
        
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/imagenes/listas.png"));
        jbListados = new JButton ("Listados");
        jbListados.setBounds(190, 130, 120, 40);
        jbListados.setToolTipText("Apartado de listados");
        jbListados.setFocusable(false);
        jbListados.setIcon(icon2);
        jbListados.addActionListener(ctr);
        add(jbListados);

        ImageIcon icon1 = new ImageIcon(getClass().getResource("/imagenes/consul.png"));
        jbConsultas = new JButton ("Consultas");
        jbConsultas.setBounds(190, 180, 120, 40);
        jbConsultas.setToolTipText("Apartado de consultas");
        jbConsultas.setFocusable(false);
        jbConsultas.setIcon(icon1);
        jbConsultas.addActionListener(ctr);
        add(jbConsultas);
        
        
        ImageIcon icon4 = new ImageIcon(getClass().getResource("/imagenes/info.png"));
        jbInfo = Utilidades.botones(5, 330, 150, 40, "Información");
        jbInfo.setIcon(icon4);
        jbInfo.addActionListener(e -> mostrarDialogoAcercaDe());
        add(jbInfo);
        
        ImageIcon icon5 = new ImageIcon(getClass().getResource("/imagenes/salir.png"));
        jbSalir = Utilidades.botones(370, 330, 110, 40, "Salir");
        jbSalir.setIcon(icon5);
        jbSalir.addActionListener(ctr);
        add(jbSalir);  
    
    }
    
    /**
     * Método para mostrar un diálogo con información sobre los programadores.
     */
    public void mostrarDialogoAcercaDe() {
        JDialog dialogo = new AcercaDeDialog(this, true);
        dialogo.setVisible(true);
    }
    
    /**
     * Clase interna para el diálogo de información sobre los programadores.
     */
    class AcercaDeDialog extends JDialog {
        public AcercaDeDialog(JFrame parent, boolean modal) {
            super(parent, modal);
            setTitle("Info. Programadores");
            setSize(570, 200);
            setLocationRelativeTo(parent);

            JLabel imagen1 = new JLabel(new ImageIcon(getClass().getResource("/imagenes/img7.png")));
            JLabel nombre1 = new JLabel("Oscar Jimenez - "); 
            JLabel correo1 = new JLabel("oscar.eduardo.jimenez@correounivalle.edu.co - 2264419                                ");
           

            JLabel imagen2 = new JLabel(new ImageIcon(getClass().getResource("/imagenes/img8.png")));
            JLabel nombre2 = new JLabel("Juan Pablo Ochoa -");
            JLabel correo2 = new JLabel("juan.ochoa.alvarez@correounivalle.edu.co - 2559894                               ");

            JLabel imagen3 = new JLabel(new ImageIcon(getClass().getResource("/imagenes/avatar.png")));
            JLabel nombre3 = new JLabel("Juan Alejandro Jimenez - ");
            JLabel correo3 = new JLabel("Juan.alejandro.jimenez@correounivalle.edu.co - 2266096                                            ");

            JLabel imagen4 = new JLabel(new ImageIcon(getClass().getResource("/imagenes/img9.png")));
            JLabel nombre4 = new JLabel("Jose David Marmol - ");
            JLabel correo4 = new JLabel("jose.marmol@correounivalle.edu.co - 2266370");
            
            JPanel panel = new JPanel();
            panel.add(imagen1);
            panel.add(nombre1);
            panel.add(correo1);

            panel.add(imagen2);
            panel.add(nombre2);
            panel.add(correo2);

            panel.add(imagen3);
            panel.add(nombre3);
            panel.add(correo3);
            
            panel.add(imagen4);
            panel.add(nombre4);
            panel.add(correo4);

            getContentPane().add(panel);
        }
    }
}