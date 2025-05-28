/*
Este código es un controlador para la ventana de registro de clientes. Se encarga 
de manejar los eventos de los botones y realizar las acciones correspondientes, como 
registrar un cliente o limpiar los campos de texto.
*/

/*
Desarrollo 1
Clase de control de la entidad cliente
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
import javax.swing.JOptionPane;
import modelo.modeloCliente;
import vista.Registro;
import vista.RegistroCliente;
import vista.menu;

/**
 * Controlador para la ventana de registro de clientes.
 */
public class ControlRegistroCliente implements ActionListener {
    // Referencia a la vista de registro de clientes
    RegistroCliente ctrreg;

    /**
     * Constructor que recibe la vista de registro de clientes.
     * 
     * @param cr La vista de registro de clientes.
     */
    public ControlRegistroCliente(RegistroCliente cr) {
        ctrreg = cr;
    }

    /**
     * Método para manejar los eventos de los botones.
     * 
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Acción al presionar el botón "Volver"
        if (e.getSource() == ctrreg.jbVolver) {
            ctrreg.setVisible(false); // Oculta la ventana actual
            ctrreg.dispose(); // Libera los recursos de la ventana actual
            ctrreg.ctrRegistro.setVisible(true); // Muestra la ventana anterior
        }

        // Acción al presionar el botón "Registro"
        if (e.getSource() == ctrreg.jbRegistro) {
            modeloCliente mc = new modeloCliente(ctrreg); // Crea un modelo de cliente con la vista actual
            mc.registrar(); // Llama al método para registrar el cliente en el modelo
        }

        // Acción al presionar el botón "Limpiar"
        if (e.getSource() == ctrreg.jbLimpiar) {
            // Limpia los campos de texto de la vista
            ctrreg.jtCedula.setText("");
            ctrreg.jtEdad.setText("");
            ctrreg.jtNombre.setText("");
        }
    }
}