/*
Este modelo busca en la tabla datos todos los vuelos asociados a una ciudad dada y construye 
una cadena con la información encontrada. Si no se encuentran vuelos para la ciudad especificada, 
devuelve un mensaje indicando que no se encontraron vuelos.
*/

package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Modelo para buscar información en la base de datos por ciudad.
 */
public class ModeloConsultaCiudad {
    
    /**
     * Método para buscar información en la base de datos por ciudad.
     * @param ciudad La ciudad a buscar.
     * @return Una cadena con la información de los vuelos encontrados para la ciudad.
     */
    public static String buscarPorCiudad(String ciudad) {
        StringBuilder resultado = new StringBuilder(); // Para almacenar el resultado de la búsqueda
        try {
            // Obtener la conexión a la base de datos
            Connection conn = conexion.getConnection();

            // Consulta SQL para buscar por ciudad en la tabla 'datos'
            String sql = "SELECT * FROM datos WHERE ciudad = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, ciudad); // Establecer el valor del parámetro en la consulta
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
            System.err.println("Error al buscar por ciudad: " + e.getMessage());
        }
        
        // Si no se encontraron vuelos, se devuelve un mensaje indicando esto
        if (resultado.length() == 0) {
            return "No se encontraron vuelos para la ciudad ingresada.";
        }
        // Devolver el resultado como una cadena
        return resultado.toString();
    }
}