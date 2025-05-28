/*
Este código es un controlador para la ventana de lista de destinos. Al presionar el botón "Volver", 
se oculta y destruye la ventana actual y se crea una nueva instancia de la ventana de listados.
*/

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.ListaDest;
import vista.Listados;
import vista.menu;

/**
 * Controlador para la ventana de lista de destinos.
 */
public class controlListDest implements ActionListener{

    // Referencia a la vista de lista de destinos
    ListaDest ld;
    
    /**
     * Constructor que recibe la vista de lista de destinos.
     * 
     * @param ld La vista de lista de destinos.
     */
    public controlListDest(ListaDest ld){
        this.ld = ld;
    }
    
    /**
     * Método para manejar los eventos de los botones.
     * 
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Acción al presionar el botón "Volver"
        if(e.getSource() == ld.jbVolver){
            ld.setVisible(false); // Oculta la ventana actual
            ld.dispose(); // Libera los recursos de la ventana actual
            Listados l = new Listados(); // Crea una nueva instancia de la ventana de listados            
        }
    }
}