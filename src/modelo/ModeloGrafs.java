/**
 * Este modelo utiliza consultas SQL para obtener datos de una base de datos y los organiza en arreglos o mapas para su posterior uso en gráficos estadísticos.
 * Cada método está diseñado para obtener un tipo específico de datos y manejar excepciones en caso de errores de base de datos.
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 * Modelo para obtener datos utilizados en gráficos estadísticos.
 */
public class ModeloGrafs {
    
    /** Contadores para el gráfico de tipo de maletas */
    public int[] contadorMaletas = new int[3];
    /** Contadores para el gráfico de edades */
    public int[] contadorEdad = new int[5];
    /** Contadores para el gráfico de clases de vuelo */
    public int[] contadorClase = new int[2];

    /** Conexión a la base de datos */
    public conexion c;
    
    /**
     * Método para obtener datos del gráfico 1: Contar el tipo de maletas.
     * @return Arreglo con la cantidad de cada tipo de maleta.
     */
    public int[] contarTipoMaletas() {
        Connection conn = null;
        try {
            conn = c.getConnection();
            String sql = "SELECT tipo_maleta FROM datos";

            try (Statement statement = conn.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    String tipo = resultSet.getString("tipo_maleta");
                    if (tipo.equalsIgnoreCase("Maleta de mano")) {
                        contadorMaletas[0]++;
                    } else if (tipo.equalsIgnoreCase("Maleta de bodega")) {
                        contadorMaletas[1]++;
                    } else {
                        contadorMaletas[2]++; // Para ambas
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener resultados desde la base de datos: " + e.getMessage());
        } finally {
            //conn.close();
        }
        return contadorMaletas;
    }
    
    /**
     * Método para obtener datos del gráfico 2: Contar las edades.
     * @return Arreglo con la cantidad de cada rango de edad.
     */
    public int[] contarEdades() {
        Connection conn = null;
        try {
            conn = c.getConnection();
            String sql = "SELECT edad FROM datos";

            try (Statement statement = conn.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    int edad = resultSet.getInt("edad");
                    if (edad >= 7 && edad <=10) {
                        contadorEdad[0]++;
                    } else if (edad >= 10 && edad <=20) {
                        contadorEdad[1]++;
                    } else if (edad >= 21 && edad <= 40) {
                        contadorEdad[2]++;
                    } else if (edad >= 41 && edad <= 50){
                        contadorEdad[3]++; 
                    } else {
                        contadorEdad[4]++; // para edades +50
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener resultados desde la base de datos: " + e.getMessage());
        } finally {
            //conn.close();
        }
        return contadorEdad;
    }
    
    /**
     * Método para obtener datos del gráfico 3: Contar las clases de vuelo.
     * @return Arreglo con la cantidad de vuelos por clase.
     */
    public int[] contarClases() {
        Connection conn = null;
        try {
            conn = c.getConnection();
            String sql = "SELECT class_vuelo FROM datos";

            try (Statement statement = conn.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    String clase = resultSet.getString("class_vuelo");
                    if (clase.equalsIgnoreCase("Primera clase")) {
                        contadorClase[0]++;
                    } else if (clase.equalsIgnoreCase("Clase economica")) {
                        contadorClase[1]++;
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener resultados desde la base de datos: " + e.getMessage());
        } finally {
            //conn.close();
        }
        return contadorClase;
    }
    
    /**
     * Método para obtener datos del gráfico 4: Contar vuelos por país.
     * @return Mapa con el país como clave y la cantidad de vuelos como valor.
     */
    public Map<String, Integer> obtenerDatosPaises() {
        Map<String, Integer> datosPaises = new HashMap<>();
        Connection conn = null;
        try{
            conn = conexion.getConnection();
            String sql = "SELECT pais, COUNT(*) AS cantidad FROM datos GROUP BY pais";
            try(Statement statement = conn.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)){
                while (resultSet.next()) {
                    String pais = resultSet.getString("pais");
                    int cantidad = resultSet.getInt("cantidad");
                    datosPaises.put(pais, cantidad);
                }
            }catch (SQLException e) {
                System.err.println("Error al obtener datos de los países: " + e.getMessage());
            }
        }finally {
            //conn.close();
        }
        return datosPaises;
    }
    
    /**
     * Método para obtener datos del gráfico 5: Contar vuelos por mes.
     * @return Mapa con el mes como clave y la cantidad de vuelos como valor.
     */
    public Map<Integer, Integer> obtenerDatosMeses() {
        Map<Integer, Integer> datosMeses = new HashMap<>();
        try {
            Connection conn = conexion.getConnection();
            String sql = "SELECT fecha_salida FROM datos";
            try(Statement statement = conn.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)){
                while (resultSet.next()) {
                    String fecha = resultSet.getString("fecha_salida");
                    int mes = obtenerMesDeFecha(fecha);
                    int cantidad = datosMeses.getOrDefault(mes, 0);
                    datosMeses.put(mes, cantidad + 1);
                }
                
            } catch (SQLException e) {
                System.err.println("Error al obtener datos de los meses: " + e.getMessage());
            }
        
        }finally{
            
        }
        return datosMeses;
    }
    
    // Método auxiliar para obtener el mes de una fecha en formato "dd/MM/yyyy"
    private static int obtenerMesDeFecha(String fecha) {
        // Dividir la fecha en sus componentes: día, mes, año, hora y minuto
        String[] partesFecha = fecha.split(" ")[0].split("/");
        // Obtener el mes (parte 1) y convertirlo a entero
        int mes = Integer.parseInt(partesFecha[1]);

        return mes;
    }
}