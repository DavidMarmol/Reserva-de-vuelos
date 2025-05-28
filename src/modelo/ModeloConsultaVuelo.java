/*
Este modelo busca en la tabla datos un vuelo específico por su número y construye una cadena 
con la información del vuelo encontrado. Si no se encuentra ningún vuelo con ese número, 
devuelve un mensaje indicando que no se encontró ningún vuelo.
 */

package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Modelo para buscar información en la base de datos por número de vuelo.
 */
public class ModeloConsultaVuelo {
    
    /**
     * Método para buscar información en la base de datos por número de vuelo.
     * @param numeroVuelo El número de vuelo a buscar.
     * @return Una cadena con la información del vuelo encontrado o un mensaje indicando que no se encontró ningún vuelo con ese número.
     */
    public static String buscarPorNumeroVuelo(String numeroVuelo) {
        String resultado = ""; // Para almacenar el resultado de la búsqueda
        try {
            // Obtener la conexión a la base de datos
            Connection conn = conexion.getConnection();

            // Consulta SQL para buscar por número de vuelo en la tabla 'datos'
            String sql = "SELECT * FROM datos WHERE num_vuelo = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, numeroVuelo); // Establecer el valor del parámetro en la consulta
            ResultSet rs = statement.executeQuery(); // Ejecutar la consulta

            // Si se encontró un vuelo, se construye la cadena con la información del vuelo
            if (rs.next()) {
                resultado = "Número de vuelo: " + rs.getString("num_vuelo") + "\n" +
                            "Cedula: " + rs.getString("cedula") + "\n" +
                            "Nombre: " + rs.getString("nombre") + "\n" +
                            "Edad: " + rs.getString("edad") + "\n" +
                            "País: " + rs.getString("pais") + "\n" +
                            "Ciudad: " + rs.getString("ciudad") + "\n" +
                            "Aeropuerto: " + rs.getString("aeropuerto") + "\n" +
                            "Clase de vuelo: " + rs.getString("class_vuelo") + "\n" +
                            "Fecha de salida: " + rs.getString("fecha_salida") + "\n" +
                            "Fecha de llegada: " + rs.getString("fecha_llegada") + "\n" +
                            "Tipo de maleta: " + rs.getString("tipo_maleta");
            } else {
                // Si no se encontró un vuelo, se devuelve un mensaje indicando esto
                resultado = "No se encontró ningún vuelo con ese número.";
            }
            conn.close(); // Cerrar la conexión a la base de datos
        } catch (SQLException e) {
            System.err.println("Error al buscar vuelo: " + e.getMessage());
        }
        // Devolver el resultado como una cadena
        return resultado;
    }   
}