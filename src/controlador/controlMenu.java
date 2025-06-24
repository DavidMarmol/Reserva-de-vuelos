/*
Este controlador es el encargado de gestionar la navegación entre las 
diferentes opciones del menú principal de la aplicación. Cada vez que se selecciona una opción, 
se cierra el menú actual y se abre la ventana correspondiente.
*/

/*
Proyecto Desarrollo 1
Clase de control del menu principal
Integrantes: Oscar Jimenez          - cod: 2264419
             Juan Pablo Ochoa       - cod: 2559894
             Juan Alejandro Jimenez - cod: 2266096
             Jose David Marmol      - cod: 2266370
Fecha:  29 de abril del 2025
Versión: 1.0
*/

package controlador;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ModeloPdfGrafs;
import org.jfree.chart.JFreeChart;
import vista.Consultas;
import vista.Graficas;
import vista.ListaClientes;
import vista.ListaDest;
import vista.Listados;
import vista.Registro;
import vista.menu;

/**
 * Controlador para el menú principal.
 */
public class controlMenu implements ActionListener{
    
    
    // Referencia al menú principal
    menu ctrmenu;
    
    /**
     * Constructor que recibe el menú principal.
     * @param crm El menú principal.
     */
    public controlMenu(menu crm){
        ctrmenu = crm;   
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Acción al presionar el botón "Registro"
        if(e.getSource() == ctrmenu.jbRegistro){
            ctrmenu.setVisible(false); // Oculta el menú actual
            ctrmenu.dispose(); // Libera los recursos del menú actual
            Registro r = new Registro(); // Crea una nueva instancia de la ventana de registro
        }
        
        // Acción al presionar el botón "Listados"
        if (e.getSource()== ctrmenu.jbListados){
            ctrmenu.setVisible(false); // Oculta el menú actual
            ctrmenu.dispose(); // Libera los recursos del menú actual
            Listados lc = new Listados(); // Crea una nueva instancia de la ventana de listados
        }
        
        // Acción al presionar el botón "Consultas"
        if (e.getSource() == ctrmenu.jbConsultas){
            ctrmenu.setVisible(false); // Oculta el menú actual
            ctrmenu.dispose(); // Libera los recursos del menú actual
            Consultas co = new Consultas(); // Crea una nueva instancia de la ventana de consultas
        }
        
        // Acción al presionar el botón "Gráficas"
        if(e.getSource() == ctrmenu.jbGraficas){
            ctrmenu.setVisible(false); // Oculta el menú actual
            ctrmenu.dispose(); // Libera los recursos del menú actual
            Graficas g = new Graficas(); // Crea una nueva instancia de la ventana de gráficas
        }
        
        // Acción al presionar el botón "Salir"
        if(e.getSource() == ctrmenu.jbSalir){
            salir(); // Sale de la aplicación
        }
        
        
        if(e.getSource() == ctrmenu.jbPdfs){
            Graficas g = new Graficas();
            g.setVisible(false);
            ModeloPdfGrafs mg = new ModeloPdfGrafs();
            mg.createPDFWithCharts(g);
        }
        
    }
    
    /**
     * Muestra un mensaje de confirmación antes de salir de la aplicación.
     */
    public void salir(){
        int respuesta = JOptionPane.showConfirmDialog(ctrmenu,
                "¿Salir de la Aplicación?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION)
            System.exit(0);
    } 
}