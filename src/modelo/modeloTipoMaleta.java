/*
Esta clase modeloTipoMaleta se encarga de abrir un archivo CSV llamado "datos.csv" y 
agregar una línea con el tipo de maleta seleccionado en la ventana TipoMaleta. Si ocurre 
algún error durante el proceso de escritura en el archivo, se muestra un mensaje de error.
*/

package modelo;

import java.io.FileWriter;
import javax.swing.JOptionPane;
import vista.TipoMaleta;

/**
 * Clase que maneja la lógica de registro de un tipo de maleta en un archivo CSV.
 */
public class modeloTipoMaleta {
    
    // Ventana de TipoMaleta
    TipoMaleta tm;
    
    // Constructor que recibe la ventana de TipoMaleta
    public modeloTipoMaleta(TipoMaleta tm){
        this.tm = tm;
    }
    
    // Método para registrar el tipo de maleta en el archivo CSV
    public void registrar(){
        FileWriter fw = null;
        try {
            // Se abre el archivo CSV en modo append (para agregar al final)
            fw = new FileWriter("datos.csv", true);
            // Se escribe en el archivo CSV el tipo de maleta seleccionado en la ventana
            fw.write("" + "" + "" + "" + "" + "" + "" + "" + "" + "" + tm.jcResp.getSelectedItem() + "\r\n");
            // Se cierra el archivo
            fw.close();
            
            // Se muestra un mensaje de éxito en la ventana
            JOptionPane.showMessageDialog(null, "Se registró el tipo de maleta con éxito.");
            
        } catch (Exception e) {
            // En caso de error, se muestra un mensaje de error en la ventana
            JOptionPane.showMessageDialog(null, "Ocurrió un error.\n" + e);
        }
    }
}