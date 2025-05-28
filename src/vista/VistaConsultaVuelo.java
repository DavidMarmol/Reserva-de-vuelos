/*
Esta clase define una ventana de consulta para buscar información por número de vuelo. 
Permite al usuario ingresar un número de vuelo y mostrar el resultado de la búsqueda. 
La ventana contiene un campo de texto para ingresar el número de vuelo, un botón para 
realizar la búsqueda, un área de texto para mostrar el resultado y un botón para volver a la ventana de consultas principal.
*/

package vista;

import utilerias.Utilidades;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EtchedBorder;
import modelo.ModeloConsultaVuelo;

/**
 * Vista para buscar información por número de vuelo.
 * Permite al usuario ingresar un número de vuelo y mostrar el resultado de la búsqueda.
 * 
 * @version 1.0
 */
public class VistaConsultaVuelo extends JFrame {
    // Componentes de la ventana
    private JTextField txtNumeroVuelo;
    private JTextArea txtResultado;
    private JButton jbVolver;

    /**
     * Constructor de la clase.
     * Crea la ventana de consulta por número de vuelo e inicializa sus componentes.
     */
    public VistaConsultaVuelo() {
        // Configuración de la ventana
        setTitle("Buscar por Número de Vuelo");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/ImagenAvion.png")).getImage());
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // Panel principal
        JPanel panel = new JPanel();
        
        // Etiqueta y campo de texto para ingresar el número de vuelo
        JLabel lblNumeroVuelo = new JLabel("Número de Vuelo:");
        txtNumeroVuelo = new JTextField(10);
        
        // Botón de búsqueda
        JButton btnBuscar = new JButton("Buscar");
        
        // Área de texto para mostrar el resultado de la búsqueda
        txtResultado = new JTextArea(10, 30);
        txtResultado.setBorder(new EtchedBorder());
        
        // Botón para volver atrás
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/volver.png"));
        jbVolver = Utilidades.botones(10, 210, 120, 35, "Volver");
        jbVolver.setIcon(icon);
        jbVolver.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                dispose();
                Consultas c = new Consultas();
            }
        });
        add(jbVolver);

        // Acción al presionar el botón de búsqueda
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String numeroVuelo = txtNumeroVuelo.getText();
                // Realizar la búsqueda en el modelo y mostrar el resultado
                String resultado = ModeloConsultaVuelo.buscarPorNumeroVuelo(numeroVuelo);
                txtResultado.setText(resultado);
            }
        });

        // Agregar componentes al panel
        panel.add(lblNumeroVuelo);
        panel.add(txtNumeroVuelo);
        panel.add(btnBuscar);
        panel.add(new JScrollPane(txtResultado));

        // Agregar panel a la ventana
        add(panel);
        // Hacer visible la ventana
        setVisible(true);
    }
}