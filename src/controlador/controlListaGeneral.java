/*
Este código es un controlador para la ventana de lista general. Al presionar el botón "Volver", 
se oculta y destruye la ventana actual y se crea una nueva instancia de la ventana de listados.
*/

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.ListaGeneral;
import vista.Listados;

/**
 * Controlador para la ventana de lista general.
 */
public class controlListaGeneral implements ActionListener {
    
    // Referencia a la vista de lista general
    ListaGeneral lg;
    
    /**
     * Constructor que recibe la vista de lista general.
     * 
     * @param lg La vista de lista general.
     */
    public controlListaGeneral(ListaGeneral lg) {
        this.lg = lg;
    }

    /**
     * Método para manejar los eventos de los botones.
     * 
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Acción al presionar el botón "Volver"
        if (e.getSource() == lg.jbVolver) {
            lg.setVisible(false); // Oculta la ventana actual
            lg.dispose(); // Libera los recursos de la ventana actual
            Listados l = new Listados(); // Crea una nueva instancia de la ventana de listados
        }
    } 
}