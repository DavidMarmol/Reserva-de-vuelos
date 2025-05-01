/*
Este controlador es el encargado de gestionar la navegación entre las 
diferentes opciones del menú principal de la aplicación. Cada vez que se selecciona una opción, 
se cierra el menú actual y se abre la ventana correspondiente.
*/

/*
Proyecto Desarrollo 1
Integrantes: Oscar Jimenez          - cod: 2264419
             Juan Pablo Ochoa       - cod: 2559894
             Juan Alejandro Jimenez - cod: 2266096
             Jose David Marmol      - cod: 2266370
Fecha:  29 de abril del 2025
Versión: 1.0
*/

package controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import vista.menu;

/**
 * Controlador para el menú principal.
 */
public class controlMenu implements ActionListener{
    
    
    // Referencia al menú principal
    menu ctrmenu;
    
    /**
     * Constructor que recibe el menú principal.
     * @param crm El menú principal.
     */
    public controlMenu(menu crm){
        ctrmenu = crm;   
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Acción al presionar el botón "Registro"
        if(e.getSource() == ctrmenu.jbRegistro){
            ctrmenu.setVisible(false); // Oculta el menú actual
            ctrmenu.dispose(); // Libera los recursos del menú actual
            
        }
        
        // Acción al presionar el botón "Listados"
        if (e.getSource()== ctrmenu.jbListados){
            ctrmenu.setVisible(false); // Oculta el menú actual
            ctrmenu.dispose(); // Libera los recursos del menú actual
            
        }
        
        // Acción al presionar el botón "Consultas"
        if (e.getSource() == ctrmenu.jbConsultas){
            ctrmenu.setVisible(false); // Oculta el menú actual
            ctrmenu.dispose(); // Libera los recursos del menú actual
            
        }
        
        
        // Acción al presionar el botón "Salir"
        if(e.getSource() == ctrmenu.jbSalir){
            salir(); // Sale de la aplicación
        }
              
  }
    
    /**
     * Muestra un mensaje de confirmación antes de salir de la aplicación.
     */
    public void salir(){
        int respuesta = JOptionPane.showConfirmDialog(ctrmenu,
                "¿Salir de la Aplicación?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION)
            System.exit(0);
    } 
}