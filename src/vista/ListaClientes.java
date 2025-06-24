/*
Crea una ventana de aplicación que muestra un listado de clientes. 
La ventana contiene una tabla donde se muestran los datos de los clientes, como su cédula, nombre y edad.
*/

/*
Proyecto Desarrollo 1
Clase de la ventana de la lista de los clientes
Integrantes: Oscar Jimenez          - cod: 2264419
             Juan Pablo Ochoa       - cod: 2559894
             Juan Alejandro Jimenez - cod: 2266096
             Jose David Marmol      - cod: 2266370
Fecha:  20 de mayo del 2025
Versión: 1.2
*/

package vista;

import Utilerias.Utilidades;
import controlador.controlListCli;
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
import modelo.modeloTabla;

/**
 * Ventana para mostrar el listado de clientes.
 */
public class ListaClientes extends JFrame{
    
    /** Etiqueta para el título de la ventana. */
    public JLabel jlTitulo;
    
    /** Modelo de tabla para los datos de los clientes. */
    public modeloTabla mt;
    
    /** Tabla que muestra los datos de los clientes. */
    public JTable tabla;
    
    /** Botón para volver a la ventana anterior. */
    public JButton jbVolver;
    
    /**
     * Constructor de la clase ListaClientes.
     * Crea la ventana y establece su configuración inicial.
     */
    public ListaClientes(){
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
     * Crea la interfaz gráfica de la ventana.
     */
    private void crearGUI() {
        controlListCli ctr = new controlListCli(this);
         
        jlTitulo = Utilidades.tituloListas(0, 0, 500, 40, " Listado clientes");
        add(jlTitulo);
        
        String encabezado[] = {"Cédula", "Nombre", "Edad"};
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
     * Llena la tabla de clientes con datos del archivo "datos.csv".
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
                        String ced = tokens[1];
                        String nom = tokens[2];
                        String edad = tokens[3];
                        mt.addRow(new Object[]{ced, nom, edad});
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