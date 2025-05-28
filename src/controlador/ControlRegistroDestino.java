/*
Este código es un controlador para la ventana de registro de destinos. Se encarga 
de manejar los eventos de los botones y realizar las acciones correspondientes, como 
registrar un destino o limpiar los campos de texto.
*/

/*
Desarrollo 1
Clase de control de la entidad destino
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
import modelo.modeloDest;
import vista.Registro;
import vista.RegistroDestino;

/**
 * Controlador para la ventana de registro de destinos.
 */
public class ControlRegistroDestino implements ActionListener {
    
    // Referencia a la vista de registro de destinos
    RegistroDestino ctrDest;
    
    /**
     * Constructor que recibe la vista de registro de destinos.
     * 
     * @param crD La vista de registro de destinos.
     */
    public ControlRegistroDestino(RegistroDestino crD) {
        ctrDest = crD;
    }

    /**
     * Método para manejar los eventos de los botones.
     * 
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Acción al presionar el botón "Volver"
        if (e.getSource() == ctrDest.jbVolver) {
            ctrDest.setVisible(false); // Oculta la ventana actual
            ctrDest.dispose(); // Libera los recursos de la ventana actual
            ctrDest.ctrRegistro.setVisible(true); // Muestra la ventana anterior
        }
        
        // Acción al presionar el botón "Registrar"
        if (e.getSource() == ctrDest.jbRegistrar) {
            modeloDest md = new modeloDest(ctrDest); // Crea un modelo de destino con la vista actual
            md.registar(); // Llama al método para registrar el destino en el modelo
        }
        
        // Acción al presionar el botón "Limpiar"
        if (e.getSource() == ctrDest.jbLimpiar) {
            // Limpia los campos de texto de la vista
            ctrDest.jtPais.setText("");
            ctrDest.jtCiudad.setText("");
            ctrDest.jtAereop.setText("");
            ctrDest.requestFocus(); // Establece el foco en la ventana
        }
    }
}