/*
Este código es un controlador para la ventana de clase de vuelo. Se encarga de manejar los eventos de 
los botones y realizar las acciones correspondientes, como registrar una clase de vuelo o limpiar los campos de texto.
*/

/*
Desarrollo 1
Clase de control de la ventana de tipos de vuelo
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
import modelo.modeloClaseVuelo;
import vista.ClaseDeVuelo;

/**
 * Controlador para la ventana de clase de vuelo.
 */
public class controlClaseVuelo implements ActionListener {
    
    // Referencia a la vista de clase de vuelo
    ClaseDeVuelo cv;
    
    /**
     * Constructor que recibe la vista de clase de vuelo.
     * 
     * @param cv La vista de clase de vuelo.
     */
    public controlClaseVuelo(ClaseDeVuelo cv) {
        this.cv = cv; 
    }

    /**
     * Método para manejar los eventos de los botones.
     * 
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Acción al presionar el botón "Limpiar"
        if (e.getSource() == cv.jbLimpiar) {
            cv.jcResp.setSelectedIndex(0); // Establece el índice seleccionado en 0 (primer elemento)
        }
        
        // Acción al presionar el botón "Registrar"
        if (e.getSource() == cv.jbRegistrar) {
            modeloClaseVuelo mc = new modeloClaseVuelo(cv); // Crea un modelo de clase de vuelo con la vista actual
            mc.registrar(); // Llama al método para registrar la clase de vuelo en el modelo
        }
        
        // Acción al presionar el botón "Volver"
        if (e.getSource() == cv.jbVolver) {
            cv.setVisible(false); // Oculta la ventana actual
            cv.dispose(); // Libera los recursos de la ventana actual
            cv.ct.setVisible(true); // Muestra la ventana anterior
        }
    }
}