/*
Este código crea una ventana de aplicación que muestra un listado de destinos.
La ventana contiene una tabla donde se muestran los datos de los destinos, como el país, la ciudad y el aeropuerto. 
 */

package vista;

import Utilerias.Utilidades;
import controlador.controlListDest;
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
 * Ventana que muestra un listado de destinos.
 */
public class ListaDest extends JFrame{
   
    /** Etiqueta para el título de la ventana. */
    public JLabel jlTitulo;
    
    /** Modelo de tabla para los datos de los destinos. */
    public modeloTabla mt;
    
    /** Tabla que muestra los datos de los destinos. */
    public JTable tabla;
    
    /** Botón para volver atrás. */
    public JButton jbVolver;
    
    /**
     * Constructor de la clase ListaDest.
     */
    public ListaDest(){
        super("Vuelos Unifly");
        setSize(500, 400);
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
     * Método que crea la interfaz gráfica de la ventana.
     */
    private void crearGUI() {
        controlListDest ctr = new controlListDest(this);
         
        jlTitulo = Utilidades.tituloListas(0, 0, 500, 40, " Listado Destinos");
        add(jlTitulo);
        
        String encabezado[] = {"País", "Ciudad", "Aeropuerto"};
        String datos[][] = {{"", "", ""}};
        
        mt = new modeloTabla(datos, encabezado);
        tabla = new JTable(mt);
        tabla.setSelectionBackground(Color.DARK_GRAY);
        tabla.setSelectionForeground(Color.GREEN);
        JScrollPane js = new JScrollPane(tabla);
        js.setBounds(20, 50, 450, 200);
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/volver.png"));
        jbVolver = new JButton("Volver");
        jbVolver.setBounds(20, 260, 120, 35);
        jbVolver.setIcon(icon);
        jbVolver.addActionListener(ctr);
        add(jbVolver);
        add(js);
    }
    
    /**
     * Método que carga los datos de los destinos en la tabla.
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
            
            mt.removeRow(0);
            
            try {
                while((linea = br.readLine()) != null){
                    String tokens[] = linea.split(";");
                    if (tokens.length >= 4) {
                        String pais = tokens[4];
                        String ciudad = tokens[5];
                        String aeropuerto = tokens[6];
                        mt.addRow(new Object[]{pais, ciudad, aeropuerto});
                    }  
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al tratar de leer el archivo 'datos.csv'");
            }
            
            try {
                fr.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al tratar de cerrar el archivo 'datos.csv'");
            }
        }       
    }
}