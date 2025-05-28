/*
Este modelo de tabla hace que todas las celdas de la tabla sean no editables, lo que significa
que el usuario no puede modificar su contenido directamente. Esto puede ser útil en situaciones 
donde se desea mostrar datos de solo lectura en una tabla.
*/

/*
Proyecto Desarrollo 1
Clase modelo de la lista de los clientes 
Integrantes: Oscar Jimenez          - cod: 2264419
             Juan Pablo Ochoa       - cod: 2559894
             Juan Alejandro Jimenez - cod: 2266096
             Jose David Marmol      - cod: 2266370
Fecha:  20 de mayo del 2025
Versión: 1.2
*/

package modelo;

import javax.swing.table.DefaultTableModel;

/**
 * Modelo personalizado para controlar la edición de celdas en una tabla.
 */
public class modeloTabla extends DefaultTableModel {
    
    // Constructor que recibe los datos y encabezados de la tabla
    public modeloTabla(Object datos[][], Object encabezados[]) {
        super(datos, encabezados);
    }
    
    // Método para determinar si una celda es editable
    @Override
    public boolean isCellEditable(int row, int column) {
        // Devuelve false para hacer que todas las celdas sean no editables
        return false;
    }
}