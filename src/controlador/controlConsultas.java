/*
Este código es un controlador para la ventana de consultas. Al presionar cada botón en la ventana de consultas, 
se oculta y destruye la ventana actual y se crea una nueva instancia de la vista correspondiente a la consulta seleccionada
*/

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Consultas;
import vista.VistaConsultaCedula;
import vista.VistaConsultaCiudad;
import vista.VistaConsultaClaseVuelo;
import vista.VistaConsultaEdad;
import vista.VistaConsultaMaleta;
import vista.VistaConsultaPais;
import vista.menu;
import vista.VistaConsultaVuelo;

/**
 * Controlador para la ventana de consultas.
 */
public class controlConsultas implements ActionListener {

    // Referencia a la vista de consultas
    Consultas co;

    /**
     * Constructor que recibe la vista de consultas.
     * 
     * @param co La vista de consultas.
     */
    public controlConsultas(Consultas co) {
        this.co = co;
    }

    /**
     * Método para manejar los eventos de los botones.
     * 
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Acción al presionar el botón "Volver"
        if (e.getSource() == co.jbVolver) {
            co.setVisible(false); // Oculta la ventana actual
            co.dispose(); // Libera los recursos de la ventana actual
            menu m = new menu(); // Crea una nueva instancia del menú principal
        }

        // Acción al presionar el botón "Consultar por Cédula"
        if (e.getSource() == co.jbCedula) {
            co.setVisible(false); // Oculta la ventana actual
            co.dispose(); // Libera los recursos de la ventana actual
            VistaConsultaCedula m = new VistaConsultaCedula(); // Crea una nueva instancia de la vista de consulta por cédula
        }

        // Acción al presionar el botón "Consultar por Número de Vuelo"
        if (e.getSource() == co.jbNumVuelo) {
            co.setVisible(false); // Oculta la ventana actual
            co.dispose(); // Libera los recursos de la ventana actual
            VistaConsultaVuelo m = new VistaConsultaVuelo(); // Crea una nueva instancia de la vista de consulta por número de vuelo
        }

        // Acción al presionar el botón "Consultar por Edad"
        if (e.getSource() == co.jbPorEdad) {
            co.setVisible(false); // Oculta la ventana actual
            co.dispose(); // Libera los recursos de la ventana actual
            VistaConsultaEdad m = new VistaConsultaEdad(); // Crea una nueva instancia de la vista de consulta por edad
        }

        // Acción al presionar el botón "Consultar por Clase de Vuelo"
        if (e.getSource() == co.jbPorClase) {
            co.setVisible(false); // Oculta la ventana actual
            co.dispose(); // Libera los recursos de la ventana actual
            VistaConsultaClaseVuelo m = new VistaConsultaClaseVuelo(); // Crea una nueva instancia de la vista de consulta por clase de vuelo
        }

        // Acción al presionar el botón "Consultar por Maleta"
        if (e.getSource() == co.jbMaleta) {
            co.setVisible(false); // Oculta la ventana actual
            co.dispose(); // Libera los recursos de la ventana actual
            VistaConsultaMaleta m = new VistaConsultaMaleta(); // Crea una nueva instancia de la vista de consulta por maleta
        }

        // Acción al presionar el botón "Consultar por País"
        if (e.getSource() == co.jbPorPais) {
            co.setVisible(false); // Oculta la ventana actual
            co.dispose(); // Libera los recursos de la ventana actual
            VistaConsultaPais m = new VistaConsultaPais(); // Crea una nueva instancia de la vista de consulta por país
        }

        // Acción al presionar el botón "Consultar por Ciudad"
        if (e.getSource() == co.jbCiudad) {
            co.setVisible(false); // Oculta la ventana actual
            co.dispose(); // Libera los recursos de la ventana actual
            VistaConsultaCiudad m = new VistaConsultaCiudad(); // Crea una nueva instancia de la vista de consulta por ciudad
        }
    }
}