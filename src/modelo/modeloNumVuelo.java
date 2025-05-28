/*
Este código utiliza un BufferedReader para leer el archivo CSV y verificar si el número de vuelo 
ya existe antes de registrarlo. Si el número de vuelo no está repetido, se escribe en el archivo CSV 
utilizando un FileWriter en modo append (para añadir al final del archivo). Se muestra un mensaje de éxito o error al usuario según corresponda.
*/

package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import vista.NumVuelo;

/**
 * Modelo para registrar un número de vuelo en un archivo CSV.
 */
public class modeloNumVuelo {
    
    NumVuelo nv;
    
    // Constructor que recibe la instancia de la vista NumVuelo
    public modeloNumVuelo(NumVuelo nv){
        this.nv = nv;
    }
    
    /**
     * Registra el número de vuelo en el archivo CSV.
     */
    public void registrar(){
        FileWriter fw = null;
        try {
            // Validar que el número de vuelo no esté repetido
            if (!numeroVueloRepetido(nv.jtNum.getText())) {
                fw = new FileWriter("datos.csv", true);
                fw.write(nv.jtNum.getText() + "" + "" + "" + "" + "" + "" + "" + "" + "" + "" + ";");
                fw.close();

                // Mostrar un mensaje de éxito al usuario
                JOptionPane.showMessageDialog(null, "Se registró el numero de vuelo con éxito.");
            } else {
                // Mostrar un mensaje de error si el número de vuelo ya existe
                JOptionPane.showMessageDialog(null, "El numero de vuelo ya existe.");
            }

        } catch (Exception e) {
            // Mostrar un mensaje de error en caso de excepción
            JOptionPane.showMessageDialog(null, "Ocurrió un error.\n" + e);
        }
    }

    // Método para verificar si un número de vuelo está repetido en el archivo CSV
    private boolean numeroVueloRepetido(String numVuelo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("datos.csv"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(";");
            if (parts.length > 0 && parts[0].equals(numVuelo)) {
                br.close();
                return true;
            }
        }
        br.close();
        return false;
    }
}