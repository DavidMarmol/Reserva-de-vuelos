/*
Este código define una ventana de consulta de información por tipo de maleta, donde el usuario 
puede seleccionar un tipo de maleta y obtener información relacionada con ese tipo. La ventana 
contiene una lista desplegable para seleccionar el tipo de maleta, un botón para realizar la 
búsqueda, un área de texto para mostrar el resultado y un botón para volver a la ventana de consultas principal.
*/

package vista;

import utilerias.Utilidades;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloConsultaMaleta;

/**
 * Vista para buscar información por tipo de maleta.
 * Permite al usuario seleccionar un tipo de maleta y mostrar el resultado de la búsqueda.
 * 
 * @version 1.0
 */
public class VistaConsultaMaleta extends JFrame{
    // Componentes de la ventana
    private JComboBox<String> jcResp;
    private JTextArea txtResultado;
    private JButton jbVolver;

    /**
     * Constructor de la clase.
     * Crea la ventana de consulta por tipo de maleta e inicializa sus componentes.
     */
    public VistaConsultaMaleta() {
        // Configuración de la ventana
        setTitle("Buscar por Tipo de Maleta");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/ImagenAvion.png")).getImage());
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // Panel principal
        JPanel panel = new JPanel();
        
        // Etiqueta y lista desplegable para seleccionar el tipo de maleta
        JLabel lblMaleta = new JLabel("Tipo de Maleta:");
        jcResp = new JComboBox<>();
        jcResp.addItem("Seleccione:");
        jcResp.addItem("Maleta de mano");
        jcResp.addItem("Maleta de bodega");
        jcResp.addItem("Ambas");
        
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
                String tipoMaleta = (String) jcResp.getSelectedItem();
                if (!tipoMaleta.equals("Seleccione:")) {
                    // Realizar la búsqueda en el modelo y mostrar el resultado
                    String resultado = ModeloConsultaMaleta.buscarPorMaleta(tipoMaleta);
                    txtResultado.setText(resultado);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor seleccione un tipo de maleta.");
                }
            }
        });

        // Agregar componentes al panel
        panel.add(lblMaleta);
        panel.add(jcResp);
        panel.add(btnBuscar);
        panel.add(new JScrollPane(txtResultado));

        // Agregar panel a la ventana
        add(panel);
        // Hacer visible la ventana
        setVisible(true);
    }
}