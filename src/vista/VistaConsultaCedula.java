/*
En este código, se define una clase VistaConsultaCedula que representa la ventana de búsqueda por número de cédula. 
Permite al usuario ingresar una cédula y al presionar el botón "Buscar", se busca la información correspondiente en el modelo ModeloConsultaCedula
*/

package vista;

import Utilerias.Utilidades;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloConsultaCedula;

/**
 * Vista para buscar información por cédula.
 * Permite al usuario buscar información por número de cédula y mostrar el resultado.
 * 
 * @version 1.0
 */
public class VistaConsultaCedula extends JFrame {
    
    private JTextField txtCedula;
    private JTextArea txtResultado;
    private JButton jbVolver;
    
    /**
     * Constructor de la clase.
     * Crea la ventana de consulta por cédula e inicializa sus componentes.
     */
    public VistaConsultaCedula() {
        setTitle("Buscar por Cédula");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/ImagenAvion.png")).getImage());
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // Creación de panel principal
        JPanel panel = new JPanel();
        JLabel lblCedula = new JLabel("Cédula:");
        txtCedula = new JTextField(10);
        JButton btnBuscar = new JButton("Buscar");
        txtResultado = new JTextArea(10, 30);
        
        // Botón para volver atrás
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/volver.png"));
        jbVolver = Utilidades.botones(10, 210, 120, 35, "Volver");
        jbVolver.setIcon(icon);
        jbVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                new Consultas(); // Llamada a la ventana principal de consultas
            }
        });
        add(jbVolver);

        // Acción al presionar el botón de búsqueda
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cedula = txtCedula.getText();
                String resultado = ModeloConsultaCedula.buscarPorCedula(cedula);
                txtResultado.setText(resultado);
            }
        });

        // Añadir componentes al panel
        panel.add(lblCedula);
        panel.add(txtCedula);
        panel.add(btnBuscar);
        panel.add(new JScrollPane(txtResultado));

        add(panel);
        setVisible(true);
    }
}