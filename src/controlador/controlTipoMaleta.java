/*
Este controlador se encarga de gestionar las acciones relacionadas con la ventana 
de tipo de maleta, como registrar un nuevo tipo de maleta, limpiar un campo de texto y realizar una inserción desde un archivo CSV.
*/

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Insert_CSV;
import modelo.modeloTipoMaleta;
import vista.TipoMaleta;

/**
 * Controlador para la ventana de tipo de maleta.
 */
public class controlTipoMaleta implements ActionListener{

    // Referencia a la ventana de tipo de maleta
    TipoMaleta tm;
    
    /**
     * Constructor que recibe la ventana de tipo de maleta.
     */
    public controlTipoMaleta(TipoMaleta tm){
        this.tm = tm;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Acción al presionar el botón "Limpiar"
        if(e.getSource() == tm.jbLimpiar){
            tm.jcResp.setSelectedIndex(0); // Restablece el índice seleccionado en el JComboBox a 0
        }
        
        // Acción al presionar el botón "Volver"
        if(e.getSource() == tm.jbVolver){
            tm.setVisible(false); // Oculta la ventana actual
            tm.dispose(); // Libera los recursos de la ventana actual
            tm.r.setVisible(true); // Muestra la ventana anteriormente oculta
        }
        
        // Acción al presionar el botón "Registrar"
        if(e.getSource() == tm.jbRegistrar){
            modeloTipoMaleta mt = new modeloTipoMaleta(tm); // Crea un modelo de tipo de maleta con la ventana actual
            mt.registrar(); // Llama al método para registrar el tipo de maleta en el modelo
            Insert_CSV.insertarDesdeCSV("datos.csv"); // Inserta datos desde un archivo CSV
        }
    } 
}