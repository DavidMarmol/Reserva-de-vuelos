/*
Esta clase se encarga de establecer la conexión con una base de datos MySQL
y ejecutar consultas SQL.
*/
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase para gestionar la conexión con la base de datos.
 */
public class conexion {
    // Configuración de la conexión
    static final String URL = "jdbc:mysql://localhost:3306/database_vuelos";
    static final String USER = "root";
    static final String PASS = "";

    /**
     * Obtiene la conexión a la base de datos.
     * @return La conexión establecida.
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Establecer conexión
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexión exitosa a la base de datos local de XAMPP.");
        } catch (SQLException e) {
            // Manejo de errores
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return conn;
    }

    /**
     * Ejecuta una consulta SQL y devuelve un ResultSet con los resultados.
     * @param consulta La consulta SQL a ejecutar.
     * @return Un ResultSet con los resultados de la consulta.
     */
    public static ResultSet consultar(String consulta) {
        try {
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(consulta);
            return statement.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error al ejecutar consulta: " + e.getMessage());
            return null;
        }
    }
}