/*
Este código crea una ventana que muestra un listado general de información obtenida desde un archivo CSV.
La ventana tiene un título, una tabla para mostrar los datos y un botón para volver al menú principal. 
Los datos se cargan desde el archivo CSV y se muestran en la tabla.
*/

package vista;

import utilerias.Utilidades;
import controlador.controlListaGeneral;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import modelo.modeloTabla;

/**
 * Clase para la ventana que muestra un listado general de información.
 */
public class ListaGeneral extends JFrame{
    
    /** Etiqueta para el título. */
    public JLabel jlTitulo;
    
    /** Modelo de tabla para los datos. */
    public modeloTabla mt;
    
    /** Tabla para mostrar los datos. */
    public JTable tabla;
    
    /** Botón para volver al menú principal. */
    public JButton jbVolver;
    
    /**
     * Constructor de la clase.
     */
    public ListaGeneral(){
        super("Vuelos Unifly");
        setSize(1200, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Color rgb = new Color(183, 199, 173);
        getContentPane().setBackground(rgb);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/ImagenAvion.png")).getImage());
        crearGUI();
        llenarTabla();
        setVisible(true);
    }

    /**
     * Método para crear la interfaz gráfica.
     */
    private void crearGUI() {
        controlListaGeneral ctr = new controlListaGeneral(this); // Controlador
        
        // Título
        jlTitulo = Utilidades.tituloListas(0, 0, 1200, 40, " Listado general");
        add(jlTitulo);
        
        // Encabezado y datos iniciales de la tabla
        String encabezado[] = {"Num vuelo", "Cédula", "Nombre", "Edad", "Pais", "Ciudad", "Aeropuerto", "Class vuelo", 
            "Fecha salida", "Fecha llegada", "Tipo maleta"};
        String datos[][] = {{"", "", "", "", "", "", "", "", "", "", ""}};
        
        mt = new modeloTabla(datos, encabezado);
        tabla = new JTable(mt);
        tabla.setSelectionBackground(Color.DARK_GRAY);
        tabla.setSelectionForeground(Color.GREEN);
        JScrollPane js = new JScrollPane(tabla);
        js.setBounds(10, 50, 1175, 440);
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/volver.png"));
        jbVolver = new JButton("Volver");
        jbVolver.setBounds(10, 510, 120, 35);
        jbVolver.setIcon(icon);
        jbVolver.addActionListener(ctr);
        add(jbVolver);
        add(js);
    }
    
    /**
     * Método para llenar la tabla con los datos del archivo CSV.
     */
    public void llenarTabla(){
        FileReader fr = null;
        boolean error = false;
        try {
            fr = new FileReader("datos.csv");
        } catch (Exception e) {
            error = true;
            JOptionPane.showMessageDialog(null, "Error al tratar de abrir el archivo 'datos.csv'");
            
        }
        if(!error){
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            
            mt.removeRow(0); // Eliminar fila de datos por defecto
            
            try {
                while((linea = br.readLine()) != null){
                    String tokens[] = linea.split(";");
                    mt.addRow(tokens); // Agregar nueva fila con los datos del archivo CSV
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al tratar de leer el archivo 'datos.csv'");
            }
            
            try {
                fr.close(); // Cerrar archivo
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al tratar de cerrar el archivo 'datos.csv'");
            }
        }     
    }
}
