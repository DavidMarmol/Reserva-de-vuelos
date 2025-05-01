/*
El método main de la clase ReservaDeVuelos es la entrada principal del programa. En él, se configura 
el aspecto visual de la interfaz de usuario utilizando la librería JTattoo. Luego, se instancia y muestra 
la clase menu, que es la ventana principal de la aplicación de reservas de vuelos. Además, se llama al método 
insertarDesdeCSV de la clase Insert_CSV para insertar datos desde un archivo CSV en la base de datos.
*/

/*
Proyecto Desarrolo 1
Clase main 
Integrantes: Oscar Jimenez          - cod: 2264419
             Juan Pablo Ochoa       - cod: 2559894
             Juan Alejandro Jimenez - cod: 2266096
             Jose David Marmol      - cod: 2266370
Fecha:  29 de abril del 2025
Versión: 1.0
*/

package reservadevuelos;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import modelo.Insert_CSV;
import vista.VistaLogin;
import vista.menu;

/**
 *
 * @author OSCAR
 */
public class ReservaDeVuelos {
    public static void main(String[] args) throws IOException {
       String look = "";

        try {
            //look = "com.jtattoo.plaf.acryl.AcrylLookAndFeel";
            //look = "com.jtattoo.plaf.aero.AeroLookAndFeel";
            //look = "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel";
            //look = "com.jtattoo.plaf.bernstein.BernsteinLookAndFeel";
            //look = "com.jtattoo.plaf.fast.FastLookAndFeel";
            //look = "com.jtattoo.plaf.graphite.GraphiteLookAndFeel";
            //look = "com.jtattoo.plaf.hifi.HiFiLookAndFeel";
            //look = "com.jtattoo.plaf.luna.LunaLookAndFeel";
            look = "com.jtattoo.plaf.mcwin.McWinLookAndFeel";
            //look = "com.jtattoo.plaf.mint.MintLookAndFeel";
            //look = "com.jtattoo.plaf.noire.NoireLookAndFeel";
            //look = "com.jtattoo.plaf.smart.SmartLookAndFeel";
            //look = "com.jtattoo.plaf.texture.TextureLookAndFeel";
            UIManager.setLookAndFeel(look);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al tratar de cargar el paquete '" + look + "'.\n\n"
                    + "Se tomara el LookAndFeel por defecto.", "Error de paquete", JOptionPane.WARNING_MESSAGE);

            JFrame.setDefaultLookAndFeelDecorated(false);
            look = "";
        }
        //Diario x = new Diario();ç
        VistaLogin vl = new VistaLogin();
        //menu m = new menu();
        // Llamar al método para insertar datos desde el archivo CSV
        String nombreArchivoCSV = "datos.csv"; // Reemplaza "nombre_del_archivo.csv" con el nombre real de tu archivo CSV
        Insert_CSV.insertarDesdeCSV(nombreArchivoCSV);
    }
}