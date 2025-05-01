package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaInicio;

/**
 * Controlador para la ventana de inicio.
 */
public class control_inicio implements ActionListener{

    VistaInicio vi;
    
    /**
     * Constructor que recibe la ventana de inicio.
     * @param vi La ventana de inicio.
     */
    public control_inicio(VistaInicio vi){
        this.vi = vi;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Acción al presionar el botón "Crear"
        if(e.getSource() == vi.jbCrear){
            vi.setVisible(false); // Oculta la ventana actual
            vi.dispose(); // Libera los recursos de la ventana actual
           
        }
        
        // Acción al presionar el botón "Salir"
        if(e.getSource() == vi.jbSalir){
            System.exit(0); // Sale de la aplicación
        }
    }
}
