/*
Este código define una ventana de consulta de ciudad en la que el usuario puede ingresar 
el nombre de una ciudad y obtener información relacionada con ella. La ventana contiene un 
campo de texto para ingresar el nombre de la ciudad, un botón para realizar la búsqueda, un área 
de texto para mostrar el resultado y un botón para volver a la ventana de consultas principal.
*/
package vista;

import utilerias.Utilidades;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloConsultaCiudad;

/**
 * Vista para buscar información por ciudad.
 * Permite al usuario buscar información por nombre de ciudad y mostrar el resultado.
 * 
 * @version 1.0
 */
public class VistaConsultaCiudad extends JFrame {
    private JTextField txtCiudad;
    private JTextArea txtResultado;
    private JButton jbVolver;

    /**
     * Constructor de la clase.
     * Crea la ventana de consulta por ciudad e inicializa sus componentes.
     */
    public VistaConsultaCiudad() {
        // Configuración de la ventana
        setTitle("Buscar por Ciudad");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/ImagenAvion.png")).getImage());
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // Panel principal
        JPanel panel = new JPanel();
        
        // Etiqueta y campo de texto para ingresar la ciudad
        JLabel lblCiudad = new JLabel("Ciudad:");
        txtCiudad = new JTextField(10);
        
        // Botón de búsqueda
        JButton btnBuscar = new JButton("Buscar");
        
        // Área de texto para mostrar el resultado de la búsqueda
        txtResultado = new JTextArea(10, 30);
        
        // Botón para volver atrás
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/volver.png"));
        jbVolver = Utilidades.botones(10, 210, 120, 35, "Volver");
        jbVolver.setIcon(icon);
        jbVolver.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                dispose();
                new Consultas(); // Llamada a la ventana principal de consultas
            }
        });
        add(jbVolver);

        // Acción al presionar el botón de búsqueda
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ciudad = txtCiudad.getText();
                if (!ciudad.isEmpty()) {
                    // Realizar la búsqueda en el modelo y mostrar el resultado
                    String resultado = ModeloConsultaCiudad.buscarPorCiudad(ciudad);
                    txtResultado.setText(resultado);
                } else {
                    // Mostrar mensaje de error si no se ingresa una ciudad
                    JOptionPane.showMessageDialog(null, "Por favor ingrese una ciudad.");
                }
            }
        });

        // Agregar componentes al panel
        panel.add(lblCiudad);
        panel.add(txtCiudad);
        panel.add(btnBuscar);
        panel.add(new JScrollPane(txtResultado));

        // Agregar panel a la ventana
        add(panel);
        // Hacer visible la ventana
        setVisible(true);
    }
}