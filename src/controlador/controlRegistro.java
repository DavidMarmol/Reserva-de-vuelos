/*
Este controlador se encarga de gestionar las acciones relacionadas con la ventana 
de registro principal, redirigiendo a las diferentes ventanas de registro según la opción seleccionada.
*/

/*
Proyecto Desarrollo 1
Clase de control de la ventana de registros
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
import vista.ClaseDeVuelo;
import vista.Cronograma;
import vista.NumVuelo;
import vista.Registro;
import vista.RegistroCliente;
import vista.RegistroDestino;
import vista.TipoMaleta;
import vista.menu;

/**
 * Controlador para la ventana de registro principal.
 */
public class controlRegistro implements ActionListener{

    // Referencia a la ventana de registro principal
    Registro ctrreg;
   
    /**
     * Constructor que recibe la ventana de registro principal.
     */
    public controlRegistro(Registro cr){
        ctrreg = cr;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Acción al presionar el botón "Cliente"
        if (e.getSource() == ctrreg.jbCliente){
            ctrreg.setVisible(false); // Oculta la ventana actual
            ctrreg.dispose(); // Libera los recursos de la ventana actual
            RegistroCliente ventanaRegistro = new RegistroCliente(ctrreg); // Crea una nueva instancia de la ventana de registro de cliente
        }
        
        // Acción al presionar el botón "Destino"
        if(e.getSource() == ctrreg.jbDestino){
            ctrreg.setVisible(false); // Oculta la ventana actual
            ctrreg.dispose(); // Libera los recursos de la ventana actual
            RegistroDestino ventana = new RegistroDestino(ctrreg); // Crea una nueva instancia de la ventana de registro de destino
        }
        
        // Acción al presionar el botón "Volver"
        if(e.getSource() == ctrreg.jbVolver){
            ctrreg.setVisible(false); // Oculta la ventana actual
            ctrreg.dispose(); // Libera los recursos de la ventana actual
            menu m = new menu(); // Crea una nueva instancia del menú principal
        }
        
        // Acción al presionar el botón "Clase de Vuelo"
        if(e.getSource() == ctrreg.jbClaseDeVuelo){
            ctrreg.setVisible(false); // Oculta la ventana actual
            ctrreg.dispose(); // Libera los recursos de la ventana actual
            ClaseDeVuelo cv = new ClaseDeVuelo(ctrreg); // Crea una nueva instancia de la ventana de clase de vuelo
        }
        
        // Acción al presionar el botón "Cronograma"
        if(e.getSource() == ctrreg.jbCrono){
            ctrreg.setVisible(false); // Oculta la ventana actual
            ctrreg.dispose(); // Libera los recursos de la ventana actual
            Cronograma cr = new Cronograma(ctrreg); // Crea una nueva instancia de la ventana de cronograma
        }
        
        // Acción al presionar el botón "Tipo de Maleta"
        if(e.getSource() == ctrreg.jbMaleta){
            ctrreg.setVisible(false); // Oculta la ventana actual
            ctrreg.dispose(); // Libera los recursos de la ventana actual
            TipoMaleta tm = new TipoMaleta(ctrreg); // Crea una nueva instancia de la ventana de tipo de maleta
        }
        
        // Acción al presionar el botón "Número de Vuelo"
        if(e.getSource() == ctrreg.jbNumVuelo){
            ctrreg.setVisible(false); // Oculta la ventana actual
            ctrreg.dispose(); // Libera los recursos de la ventana actual
            NumVuelo nv = new NumVuelo(); // Crea una nueva instancia de la ventana de número de vuelo
        }
    }
}