/*
Este código utiliza un FileWriter para escribir en un archivo CSV llamado "datos.csv". 
El método registrar se encarga de escribir en el archivo CSV los datos ingresados en los campos de 
texto de la vista RegistroCliente (jtCedula, jtNombre, jtEdad) y muestra un mensaje de éxito o error según corresponda.
*/

/*
Proyecto Desarrollo 1
Clase modelo de la entidad cliente 
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
import vista.RegistroCliente;

/**
 * Modelo para registrar los datos de un cliente en un archivo CSV.
 */
public class modeloCliente {
    
    RegistroCliente rc;
    
    // Constructor que recibe la instancia de la vista RegistroCliente
    public modeloCliente(RegistroCliente rc){
        this.rc = rc;
    }
    
    /**
     * Registra los datos del cliente en el archivo CSV.
     */
    public void registrar(){
        FileWriter fw = null;
        try {
            // Crear un FileWriter en modo append (para añadir al final del archivo)
            fw = new FileWriter("datos.csv", true);
            // Escribir los datos del cliente en el archivo CSV
            fw.write("" + rc.jtCedula.getText() + ";" +
                    rc.jtNombre.getText() + ";" + 
                    rc.jtEdad.getText() + ";");
            // Cerrar el FileWriter
            fw.close();
            
            // Mostrar un mensaje de éxito al usuario
            JOptionPane.showMessageDialog(null, "Se registró el cliente con éxito.");
            
        } catch (Exception e) {
            // Mostrar un mensaje de error en caso de excepción
            JOptionPane.showMessageDialog(null, "Ocurrió un error.\n" + e);
        }
    }
}