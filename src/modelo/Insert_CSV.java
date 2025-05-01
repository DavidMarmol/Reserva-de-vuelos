package modelo;

/**
 * Clase que proporciona métodos para insertar datos desde un archivo CSV a una base de datos.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert_CSV {

    /**
     * Inserta datos desde un archivo CSV a una base de datos.
     * @param nombreArchivo El nombre del archivo CSV.
     */
    public static void insertarDesdeCSV(String nombreArchivo) {
        try {
            // Obtener la conexión a la base de datos
            Connection conn = conexion.getConnection();

            // Truncar la tabla antes de insertar nuevos datos
            truncarTabla(conn);

            // Ruta relativa al archivo CSV
            String rutaArchivo = nombreArchivo;

            // Consulta para insertar datos en la tabla 'datos'
            String sql = "INSERT INTO datos (num_vuelo, cedula, nombre, edad, pais, ciudad, " +
                    "aeropuerto, class_vuelo, fecha_salida, fecha_llegada, tipo_maleta) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Preparar la consulta
            PreparedStatement statement = conn.prepareStatement(sql);

            // Leer el archivo CSV y procesar cada línea
            leerArchivoCSV(rutaArchivo, conn, statement);

            // Cerrar la conexión
            conn.close();
            System.out.println("Datos insertados correctamente desde el archivo CSV.");

        } catch (SQLException e) {
            System.err.println("Error al insertar datos desde el archivo CSV: " + e.getMessage());
        }
    }

    /**
     * Trunca la tabla 'datos' en la base de datos.
     * @param conn La conexión a la base de datos.
     */
    private static void truncarTabla(Connection conn) {
        try {
            // Sentencia SQL para truncar la tabla
            String sql = "TRUNCATE TABLE datos";

            // Preparar la sentencia
            PreparedStatement statement = conn.prepareStatement(sql);

            // Ejecutar la sentencia de truncado
            statement.executeUpdate();

            System.out.println("Tabla truncada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al truncar la tabla: " + e.getMessage());
        }
    }

    /**
     * Lee un archivo CSV y procesa cada línea.
     * @param rutaArchivo La ruta del archivo CSV.
     * @param conn La conexión a la base de datos.
     * @param statement La consulta preparada para insertar datos.
     */
    private static void leerArchivoCSV(String rutaArchivo, Connection conn, PreparedStatement statement) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String line;
            // Leer el archivo línea por línea
            while ((line = br.readLine()) != null) {
                // Dividir la línea en diferentes datos usando ";"
                String[] datos = line.split(";");
                // Insertar los datos en la base de datos
                insertarDatosEnBaseDeDatos(conn, statement, datos);
            }
        } catch (IOException | SQLException e) {
            System.err.println("Error al leer el archivo CSV o insertar datos en la base de datos: " + e.getMessage());
        }
    }

    /**
     * Inserta datos en la base de datos.
     * @param conn La conexión a la base de datos.
     * @param statement La consulta preparada para insertar datos.
     * @param datos Los datos a insertar.
     * @throws SQLException Si ocurre un error al insertar los datos.
     */
    private static void insertarDatosEnBaseDeDatos(Connection conn, PreparedStatement statement, String[] datos) throws SQLException {
        // Asignar los datos a los parámetros de la consulta
        for (int i = 0; i < datos.length; i++) {
            statement.setString(i + 1, datos[i]);
        }
        // Ejecutar la consulta de inserción
        statement.executeUpdate();
    }
}