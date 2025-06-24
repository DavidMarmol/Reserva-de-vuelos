/*
Este código define una ventana de consulta de información por edad, donde el usuario 
puede ingresar una edad y obtener información relacionada con esa edad. La ventana contiene 
un campo de texto para ingresar la edad, un botón para realizar la búsqueda, un área de texto 
para mostrar el resultado y un botón para volver a la ventana de consultas principal.
*/
package vista;

import Utilerias.Utilidades;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloConsultaEdad;

/**
 * Vista para buscar información por edad.
 * Permite al usuario ingresar una edad y mostrar el resultado de la búsqueda.
 * 
 * @version 1.0
 */
public class VistaConsultaEdad extends JFrame{
    private JTextField txtEdad;
    private JTextArea txtResultado;
    private JButton jbVolver;

    /**
     * Constructor de la clase.
     * Crea la ventana de consulta por edad e inicializa sus componentes.
     */
    public VistaConsultaEdad() {
        // Configuración de la ventana
        setTitle("Buscar por Edad");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/ImagenAvion.png")).getImage());
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // Panel principal
        JPanel panel = new JPanel();
        
        // Etiqueta y campo de texto para ingresar la edad
        JLabel lblEdad = new JLabel("Edad:");
        txtEdad = new JTextField(10);
        
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
                String edad = txtEdad.getText();
                // Realizar la búsqueda en el modelo y mostrar el resultado
                String resultado = ModeloConsultaEdad.buscarPorEdad(edad);
                txtResultado.setText(resultado);
            }
        });

        // Agregar componentes al panel
        panel.add(lblEdad);
        panel.add(txtEdad);
        panel.add(btnBuscar);
        panel.add(new JScrollPane(txtResultado));

        // Agregar panel a la ventana
        add(panel);
        // Hacer visible la ventana
        setVisible(true);
    }
}