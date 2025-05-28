/*
Este controlador se encarga de gestionar las acciones relacionadas con la ventana 
de número de vuelo, como registrar un nuevo número de vuelo o limpiar el campo de texto.
*/

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Insert_CSV;
import modelo.modeloNumVuelo;
import vista.NumVuelo;
import vista.Registro;
import vista.menu;

/**
 * Controlador para la ventana de número de vuelo.
 */
public class controlNumVuelo implements ActionListener{

    // Referencia a la ventana de número de vuelo
    NumVuelo nv;
    
    /**
     * Constructor que recibe la ventana de número de vuelo.
     */
    public controlNumVuelo(NumVuelo nv){
        this.nv = nv;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Acción al presionar el botón "Volver"
        if (e.getSource() == nv.jbVolver) {
            nv.setVisible(false); // Oculta la ventana actual
            nv.dispose(); // Libera los recursos de la ventana actual
            Registro r = new Registro(); // Crea una nueva instancia de la ventana de registro
        }
        
        // Acción al presionar el botón "Limpiar"
        if(e.getSource() == nv.jbLimpiar){
            nv.jtNum.setText(""); // Limpia el campo de texto de la ventana
        }
        
        // Acción al presionar el botón "Registrar"
        if(e.getSource() == nv.jbRegistrar){
            modeloNumVuelo m = new modeloNumVuelo(nv); // Crea un modelo de número de vuelo con la ventana actual
            m.registrar(); // Llama al método para registrar el número de vuelo en el modelo
        }
    } 
}