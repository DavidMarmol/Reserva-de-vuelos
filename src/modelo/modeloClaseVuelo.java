/*
Este código utiliza un FileWriter para escribir en un archivo CSV llamado "datos.csv". El método 
registrar se encarga de escribir el valor seleccionado en un JComboBox (jcResp) 
en el archivo CSV y mostrar un mensaje de éxito o error según corresponda.
*/

/*
Proyecto Desarrollo 1
Clase modelo de la ventana de tipos de vuelo
Integrantes: Oscar Jimenez          - cod: 2264419
             Juan Pablo Ochoa       - cod: 2559894
             Juan Alejandro Jimenez - cod: 2266096
             Jose David Marmol      - cod: 2266370
Fecha:  6 de mayo del 2025
Versión: 1.1
*/

package modelo;

import java.io.FileWriter;
import javax.swing.JOptionPane;
import vista.ClaseDeVuelo;

/**
 * Modelo para registrar la clase de vuelo seleccionada en un archivo CSV.
 */
public class modeloClaseVuelo {
    
    ClaseDeVuelo cv;
    
    // Constructor que recibe la instancia de la vista ClaseDeVuelo
    public modeloClaseVuelo(ClaseDeVuelo cv){
        this.cv = cv;
    }
    
    /**
     * Registra la clase de vuelo en el archivo CSV.
     */
    public void registrar(){
        FileWriter fw = null;
        try {
            // Crear un FileWriter en modo append (para añadir al final del archivo)
            fw = new FileWriter("datos.csv", true);
            // Escribir los datos de la clase de vuelo seleccionada en el archivo
            fw.write("" + "" + "" + "" + "" + "" + "" + cv.jcResp.getSelectedItem() + ";" );
            // Cerrar el FileWriter
            fw.close();
            
            // Mostrar un mensaje de éxito al usuario
            JOptionPane.showMessageDialog(null, "Se registró la clase con éxito.");
            
        } catch (Exception e) {
            // Mostrar un mensaje de error en caso de excepción
            JOptionPane.showMessageDialog(null, "Ocurrió un error.\n" + e);
        }
    }
}