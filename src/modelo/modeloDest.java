/*
Este código utiliza un FileWriter para escribir en un archivo CSV llamado "datos.csv". 
El método registrar se encarga de escribir en el archivo CSV los datos del destino ingresados en los campos 
de texto de la vista RegistroDestino (jtPais, jtCiudad, jtAereop) y muestra un mensaje de éxito o error según corresponda.
*/

/*
Proyecto Desarrollo 1
Clase modelo de la entidad destino
Integrantes: Oscar Jimenez          - cod: 2264419
             Juan Pablo Ochoa       - cod: 2559894
             Juan Alejandro Jimenez - cod: 2266096
             Jose David Marmol      - cod: 2266370
Fecha:  6 de mayo del 2025
Versión: 1.1
*/

/*
Esta clase se encarga de registrar un destino en un archivo CSV.
*/
package modelo;

import java.io.FileWriter;
import javax.swing.JOptionPane;
import vista.RegistroDestino;

/**
 * Modelo para registrar un destino en un archivo CSV.
 */
public class modeloDest {
    
    RegistroDestino rd;
    
    // Constructor que recibe la instancia de la vista RegistroDestino
    public modeloDest(RegistroDestino rd){
        this.rd = rd;
    }
    
    /**
     * Registra el destino en el archivo CSV.
     */
    public void registar(){
        FileWriter fw = null;
        try {
            // Crear un FileWriter en modo append (para añadir al final del archivo)
            fw = new FileWriter("datos.csv", true);
            // Escribir los datos del destino en el archivo CSV
            fw.write("" + "" + "" + "" + rd.jtPais.getText() + ";" +
                    rd.jtCiudad.getText() + ";" +
                    rd.jtAereop.getText() + ";");
            // Cerrar el FileWriter
            fw.close();
            
            // Mostrar un mensaje de éxito al usuario
            JOptionPane.showMessageDialog(null, "Se registró el destino con éxito.");
            
        } catch (Exception e) {
            // Mostrar un mensaje de error en caso de excepción
            JOptionPane.showMessageDialog(null, "Ocurrió un error.\n" + e);
        }
    }
}