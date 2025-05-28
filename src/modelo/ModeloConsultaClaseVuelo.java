/*
Este modelo busca en la tabla datos todos los vuelos asociados a una clase de vuelo dada y construye una cadena 
con la información encontrada. Si no se encuentran vuelos para la clase de vuelo especificada, devuelve un mensaje 
indicando que no se encontraron vuelos.
*/

package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Modelo para buscar información en la base de datos por clase de vuelo.
 */
public class ModeloConsultaClaseVuelo {

    /**
     * Método para buscar información en la base de datos por clase de vuelo.
     * @param clase La clase de vuelo a buscar.
     * @return Una cadena con la información de los vuelos encontrados para la clase de vuelo.
     */
    public static String buscarPorClase(String clase) {
        StringBuilder resultado = new StringBuilder(); // Para almacenar el resultado de la búsqueda
        try {
            // Obtener la conexión a la base de datos
            Connection conn = conexion.getConnection();

            // Consulta SQL para buscar por clase de vuelo en la tabla 'datos'
            String sql = "SELECT * FROM datos WHERE class_vuelo = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, clase); // Establecer el valor del parámetro en la consulta
            ResultSet rs = statement.executeQuery(); // Ejecutar la consulta

            // Iterar sobre los resultados y añadirlos al resultado
            while (rs.next()) {
                resultado.append("Número de vuelo: ").append(rs.getString("num_vuelo")).append("\n")
                        .append("Cedula: ").append(rs.getString("cedula")).append("\n")
                        .append("Nombre: ").append(rs.getString("nombre")).append("\n")
                        .append("Edad: ").append(rs.getString("edad")).append("\n")
                        .append("País: ").append(rs.getString("pais")).append("\n")
                        .append("Ciudad: ").append(rs.getString("ciudad")).append("\n")
                        .append("Aeropuerto: ").append(rs.getString("aeropuerto")).append("\n")
                        .append("Clase de vuelo: ").append(rs.getString("class_vuelo")).append("\n")
                        .append("Fecha de salida: ").append(rs.getString("fecha_salida")).append("\n")
                        .append("Fecha de llegada: ").append(rs.getString("fecha_llegada")).append("\n")
                        .append("Tipo de maleta: ").append(rs.getString("tipo_maleta")).append("\n\n");
            }
            conn.close(); // Cerrar la conexión a la base de datos
        } catch (SQLException e) {
            System.err.println("Error al buscar por clase de vuelo: " + e.getMessage());
        }

        // Si no se encontraron vuelos, se devuelve un mensaje indicando esto
        if (resultado.length() == 0) {
            return "No se encontraron vuelos para la clase de vuelo seleccionada.";
        }
        // Devolver el resultado como una cadena
        return resultado.toString();
    }
}