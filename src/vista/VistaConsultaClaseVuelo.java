/*
Este código define una ventana de consulta de clase de vuelo en la que el usuario puede seleccionar
una clase de vuelo y obtener información relacionada con ella. La ventana contiene un 
combobox para seleccionar la clase de vuelo, un botón para realizar la búsqueda, un 
área de texto para mostrar el resultado y un botón para volver a la ventana de consultas principal.
*/
package vista;

import utilerias.Utilidades;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloConsultaClaseVuelo;

/**
 * Vista para buscar información por clase de vuelo.
 * Permite al usuario seleccionar una clase de vuelo y mostrar el resultado.
 * 
 * @version 1.0
 */
public class VistaConsultaClaseVuelo extends JFrame{
    private JComboBox<String> jcResp;
    private JTextArea txtResultado;
    private JButton jbVolver;

    /**
     * Constructor de la clase.
     * Crea la ventana de consulta por clase de vuelo e inicializa sus componentes.
     */
    public VistaConsultaClaseVuelo() {
        // Configuración de la ventana
        setTitle("Buscar por Tipo de Clase de Vuelo");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/ImagenAvion.png")).getImage());
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // Panel principal
        JPanel panel = new JPanel();
        
        // Etiqueta y combobox para seleccionar la clase de vuelo
        JLabel lblClase = new JLabel("Clase de Vuelo:");
        jcResp = new JComboBox<>();
        jcResp.addItem("Seleccione:");
        jcResp.addItem("Primera clase");
        jcResp.addItem("Clase económica");
        
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
                String clase = (String) jcResp.getSelectedItem();
                if (!clase.equals("Seleccione:")) {
                    // Realizar la búsqueda en el modelo y mostrar el resultado
                    String resultado = ModeloConsultaClaseVuelo.buscarPorClase(clase);
                    txtResultado.setText(resultado);
                } else {
                    // Mostrar mensaje de error si no se selecciona una clase de vuelo
                    JOptionPane.showMessageDialog(null, "Por favor seleccione una clase de vuelo.");
                }
            }
        });

        // Agregar componentes al panel
        panel.add(lblClase);
        panel.add(jcResp);
        panel.add(btnBuscar);
        panel.add(new JScrollPane(txtResultado));

        // Agregar panel a la ventana
        add(panel);
        // Hacer visible la ventana
        setVisible(true);
    }
}