/*
Este código es un controlador para la ventana de lista de clientes. Al presionar el botón "Volver", 
se oculta y destruye la ventana actual y se crea una nueva instancia de la ventana de listados.
*/

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.ListaClientes;
import vista.Listados;
import vista.menu;

/**
 * Controlador para la ventana de lista de clientes.
 */
public class controlListCli implements ActionListener {

    // Referencia a la vista de lista de clientes
    ListaClientes lc;

    /**
     * Constructor que recibe la vista de lista de clientes.
     * 
     * @param lc La vista de lista de clientes.
     */
    public controlListCli(ListaClientes lc) {
        this.lc = lc;
    }

    /**
     * Método para manejar los eventos de los botones.
     * 
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Acción al presionar el botón "Volver"
        if (e.getSource() == lc.jbVolver) {
            lc.setVisible(false); // Oculta la ventana actual
            lc.dispose(); // Libera los recursos de la ventana actual
            Listados l = new Listados(); // Crea una nueva instancia de la ventana de listados
        }
    }
}