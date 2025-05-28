/*
Este código es un controlador para la ventana de cronograma.Se encarga de manejar los eventos 
de los botones y realizar las acciones correspondientes, como registrar un cronograma o limpiar los campos de texto.
*/

/*
Desarrollo 1
Clase de control de la ventana de cronograma
Integrantes: Oscar Jimenez          - cod: 2264419
             Juan Pablo Ochoa       - cod: 2559894
             Juan Alejandro Jimenez - cod: 2266096
             Jose David Marmol      - cod: 2266370
Fecha:  6 de mayo del 2025
Versión: 1.1
*/
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.modeloCrono;
import vista.Cronograma;

/**
 * Controlador para la ventana de cronograma.
 */
public class controlCrono implements ActionListener {
    
    // Referencia a la vista de cronograma
    Cronograma cr;
    
    /**
     * Constructor que recibe la vista de cronograma.
     * 
     * @param cr La vista de cronograma.
     */
    public controlCrono(Cronograma cr) {
        this.cr = cr;
    }

    /**
     * Método para manejar los eventos de los botones.
     * 
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Acción al presionar el botón "Volver"
        if (e.getSource() == cr.jbVolver) {
            cr.setVisible(false); // Oculta la ventana actual
            cr.dispose(); // Libera los recursos de la ventana actual
            cr.ct.setVisible(true); // Muestra la ventana anterior
        }
        
        // Acción al presionar el botón "Limpiar"
        if (e.getSource() == cr.jbLimpiar) {
            // Limpia los campos de texto de la vista
            cr.jtFechasal.setText("");
            cr.jtFechalle.setText("");
        }
        
        // Acción al presionar el botón "Registrar"
        if (e.getSource() == cr.jbRegistrar) {
            modeloCrono mc = new modeloCrono(cr); // Crea un modelo de cronograma con la vista actual
            mc.registrar(); // Llama al método para registrar el cronograma en el modelo
        }
    }   
}