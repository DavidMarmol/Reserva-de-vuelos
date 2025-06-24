/*
Este código es un controlador para la ventana de gráficas. Al presionar el botón "Volver", 
se oculta y destruye la ventana actual y se crea una nueva instancia del menú principal.
*/

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Graficas;
import vista.Registro;
import vista.menu;

/**
 * Controlador para la ventana de gráficas.
 */
public class controlGrafs implements ActionListener {
    
    // Referencia a la vista de gráficas
    Graficas g;
    
    /**
     * Constructor que recibe la vista de gráficas.
     * 
     * @param g La vista de gráficas.
     */
    public controlGrafs(Graficas g) {
        this.g = g;
    }
    
    /**
     * Método para manejar los eventos de los botones.
     * 
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Acción al presionar el botón "Volver"
        if (e.getSource() == g.jbVolver) {
            g.setVisible(false); // Oculta la ventana actual
            g.dispose(); // Libera los recursos de la ventana actual
            menu m = new menu(); // Crea una nueva instancia del menú principal
        }
    }   
}