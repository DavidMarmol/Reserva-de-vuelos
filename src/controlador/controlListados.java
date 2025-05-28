/*
Este código es un controlador para la ventana de listados. Al presionar cada botón en la ventana de listados, 
se oculta y destruye la ventana actual y se crea una nueva instancia de la ventana correspondiente al listado seleccionado o del menú principal.
*/

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.ListaClientes;
import vista.ListaDest;
import vista.ListaGeneral;
import vista.Listados;
import vista.menu;

/**
 * Controlador para la ventana de listados.
 */
public class controlListados implements ActionListener{

    // Referencia a la vista de listados
    Listados l;
    
    /**
     * Constructor que recibe la vista de listados.
     * 
     * @param l La vista de listados.
     */
    public controlListados(Listados l){
        this.l = l;
    }

    /**
     * Método para manejar los eventos de los botones.
     * 
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Acción al presionar el botón "Lista de Clientes"
        if(e.getSource() == l.jbListCli){
            l.setVisible(false); // Oculta la ventana actual
            l.dispose(); // Libera los recursos de la ventana actual
            ListaClientes lc = new ListaClientes(); // Crea una nueva instancia de la ventana de lista de clientes
        }
        
        // Acción al presionar el botón "Lista de Destinos"
        if(e.getSource() == l.jbListDest){
            l.setVisible(false); // Oculta la ventana actual
            l.dispose(); // Libera los recursos de la ventana actual
            ListaDest ld = new ListaDest(); // Crea una nueva instancia de la ventana de lista de destinos
        }
        
        // Acción al presionar el botón "Lista General"
        if(e.getSource() == l.jbListGeneral){
            l.setVisible(false); // Oculta la ventana actual
            l.dispose(); // Libera los recursos de la ventana actual
            ListaGeneral lg = new ListaGeneral(); // Crea una nueva instancia de la ventana de lista general
        }
        
        // Acción al presionar el botón "Volver"
        if(e.getSource() == l.jbVolver){
            l.setVisible(false); // Oculta la ventana actual
            l.dispose(); // Libera los recursos de la ventana actual
            menu m = new menu(); // Crea una nueva instancia del menú principal
        }
    } 
}