/*
Esta clase define una ventana de consulta para buscar información por país. Permite al usuario 
ingresar un país y mostrar el resultado de la búsqueda. La ventana contiene un campo de texto para 
ingresar el país, un botón para realizar la búsqueda, un área de texto para mostrar el resultado y 
un botón para volver a la ventana de consultas principal.
*/

package vista;

import Utilerias.Utilidades;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloConsultaPais;

/**
 * Vista para buscar información por país.
 * Permite al usuario ingresar un país y mostrar el resultado de la búsqueda.
 * 
 * @version 1.0
 */
public class VistaConsultaPais extends JFrame {
    // Componentes de la ventana
    private JTextField txtPais;
    private JTextArea txtResultado;
    private JButton jbVolver;

    /**
     * Constructor de la clase.
     * Crea la ventana de consulta por país e inicializa sus componentes.
     */
    public VistaConsultaPais() {
        // Configuración de la ventana
        setTitle("Buscar por País");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/ImagenAvion.png")).getImage());
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // Panel principal
        JPanel panel = new JPanel();
        
        // Etiqueta y campo de texto para ingresar el país
        JLabel lblPais = new JLabel("País:");
        txtPais = new JTextField(10);
        
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
                Consultas c = new Consultas();
            }
        });
        add(jbVolver);

        // Acción al presionar el botón de búsqueda
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pais = txtPais.getText();
                if (!pais.isEmpty()) {
                    // Realizar la búsqueda en el modelo y mostrar el resultado
                    String resultado = ModeloConsultaPais.buscarPorPais(pais);
                    txtResultado.setText(resultado);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un país.");
                }
            }
        });

        // Agregar componentes al panel
        panel.add(lblPais);
        panel.add(txtPais);
        panel.add(btnBuscar);
        panel.add(new JScrollPane(txtResultado));

        // Agregar panel a la ventana
        add(panel);
        // Hacer visible la ventana
        setVisible(true);
    }
}