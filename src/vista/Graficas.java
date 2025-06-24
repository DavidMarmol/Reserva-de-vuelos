/*
Este código utiliza la librería JFreeChart para crear diferentes tipos de gráficos (de barras, de pastel, etc.)
con los datos proporcionados por el modelo ModeloGrafs. Cada gráfico se muestra en una pestaña 
dentro de la ventana principal. Los gráficos representan diferentes estadísticas relacionadas con la 
aplicación de reserva de vuelos, como el tipo de maletas, las edades de los pasajeros, las clases de vuelo, etc.
 */

package vista;

import Utilerias.Utilidades;
import controlador.controlGrafs;
import java.awt.Color;
import java.awt.GradientPaint;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import modelo.ModeloGrafs;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 * Ventana para mostrar gráficas estadísticas.
 */
public class Graficas extends JFrame{

    public ModeloGrafs mg = new ModeloGrafs();
    public JFreeChart chart1, chart2, chart3, chart4, chart5;
    public JLabel jlTitulo;
    public JTabbedPane jt;
    public JButton jbVolver;

    public Graficas() {
        super("Vuelos Unifly"); // Título de la ventana
        setSize(700, 600); // Tamaño de la ventana
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // Evitar cierre accidental
        Color rgb = new Color(183, 199, 173);
        getContentPane().setBackground(rgb); // Color de fondo de la ventana
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/ImagenAvion.png")).getImage()); // Icono de la ventana
        setResizable(false); // Evitar que la ventana sea redimensionable
        setLayout(null); // Desactivar el layout manager para posicionar los componentes manualmente
        crearGUI(); // Crear la interfaz gráfica
        setVisible(true); // Hacer visible la ventana
    }

    // Método para crear la interfaz gráfica de la ventana
    private void crearGUI() {
        controlGrafs ctr = new controlGrafs(this); // Controlador para manejar las acciones de los botones
        
        jt = new JTabbedPane(JTabbedPane.TOP); // Panel de pestañas para los gráficos
        estadistica1();
        estadistica2();
        estadistica3();
        estadistica4();
        estadistica5();
        
        jt.setBounds(10, 55, 660, 500); // Posición y tamaño del panel de pestañas
        add(jt);
        
        jlTitulo = Utilidades.tituloListas(0, 0, 700, 35, "Gráficos estadísticos"); // Etiqueta para el título
        add(jlTitulo);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/volver.png")); // Icono para el botón de volver
        jbVolver = Utilidades.botones(565, 38, 110, 35, "Volver"); // Botón para volver
        jbVolver.setIcon(icon);
        jbVolver.addActionListener(ctr);
        add(jbVolver);
    }
    
    // Método para crear el gráfico de estadística 1
    public void estadistica1(){
        JPanel jp = new JPanel();
        jp.setBackground(Color.LIGHT_GRAY);
        jp.setLayout(null);
        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
        mg.contarTipoMaletas();
        int deMano = mg.contadorMaletas[0];
        int deBodega = mg.contadorMaletas[1];
        int ambas = mg.contadorMaletas[2];
        dataset1.addValue(deMano, "Tipo de maleta", "Maleta de mano");
        dataset1.addValue(deBodega, "Tipo de maleta", "Maleta de bodega");
        dataset1.addValue(ambas, "Tipo de maleta", "Ambas");
        chart1 = ChartFactory.createBarChart( "Personas con tipo de maletas", // Título del gráfico
                "Tipos de maletas", // Etiqueta del eje x
                "Cant. Personas", // Etiqueta del eje y
                dataset1, 
                PlotOrientation.VERTICAL, 
                true, 
                true, 
                true
            );
        CategoryPlot plot = chart1.getCategoryPlot();
        plot.setBackgroundPaint(Color.LIGHT_GRAY); // Color del fondo del gráfico
        plot.setDomainGridlinesVisible(true); // Líneas divisorias en el eje x
        plot.setRangeGridlinePaint(Color.BLACK); // Color de las líneas divisorias
        chart1.setBorderPaint(Color.BLACK);
        chart1.setBackgroundPaint(Color.WHITE);
        ChartPanel chartPanel1 = new ChartPanel(chart1);
        
        jt.addTab("Estadistica 1", chartPanel1); // Agregar el gráfico como pestaña
    }
    
    // Método para crear el gráfico de estadística 2
    public void estadistica2(){
        JPanel jp = new JPanel();
        jp.setBackground(Color.DARK_GRAY);
        jp.setLayout(null);
        DefaultPieDataset dataset2 = new DefaultPieDataset();
        mg.contarEdades();
        int cont1 = mg.contadorEdad[0];
        int cont2 = mg.contadorEdad[1];
        int cont3 = mg.contadorEdad[2];
        int cont4 = mg.contadorEdad[3];
        int cont5 = mg.contadorEdad[4];
        dataset2.setValue("Edades entre 7 y 10 años", cont1);
        dataset2.setValue("Edades entre 10 y 20 años", cont2);
        dataset2.setValue("Edades entre 21 y 40 años", cont3);
        dataset2.setValue("Edades entre 41 y 50 años", cont4);
        dataset2.setValue("Edades +50 años", cont5);
        chart2 = ChartFactory.createPieChart3D("Rango de edades", 
                dataset2,
                true, 
                true,
                false
        );
        PiePlot plot = (PiePlot) chart2.getPlot();
        plot.setBackgroundPaint(Color.LIGHT_GRAY); // Color del fondo del gráfico
        
        plot.setLabelBackgroundPaint(Color.ORANGE); // Color de las etiquetas
        plot.setForegroundAlpha(0.60f); // Transparencia del fondo del gráfico
                
        chart2.setBorderPaint(Color.BLACK);
        chart2.setBackgroundPaint(Color.WHITE);
        
        ChartPanel chartPanel2 = new ChartPanel(chart2);
        
        Rotator rotator = new Rotator((PiePlot3D) plot);
        rotator.start();
        
        jt.addTab("Estadistica 2", chartPanel2); // Agregar el gráfico como pestaña
    }
    
    // Método para crear el gráfico de estadística 3
    public void estadistica3(){
        JPanel jp = new JPanel();
        jp.setBackground(Color.DARK_GRAY);
        jp.setLayout(null);
        DefaultPieDataset dataset3 = new DefaultPieDataset();
        mg.contarClases();
        int cont1 = mg.contadorClase[0];
        int cont2 = mg.contadorClase[1];
        dataset3.setValue("Primera clase", cont1);
        dataset3.setValue("Clase economica", cont2);
        chart3 = ChartFactory.createPieChart("Tipos de clases", 
                dataset3,
                true, 
                true,
                false
        );
        PiePlot plot = (PiePlot) chart3.getPlot();
        plot.setBackgroundPaint(Color.LIGHT_GRAY); // Color del fondo del gráfico
        chart3.setBorderPaint(Color.BLACK);
        chart3.setBackgroundPaint(Color.WHITE);
        ChartPanel chartPanel3 = new ChartPanel(chart3);
        
        
        jt.addTab("Estadistica 3", chartPanel3); // Agregar el gráfico como pestaña
    }
    
    // Método para crear el gráfico de estadística 4
    public void estadistica4(){
        JPanel jp = new JPanel();
        jp.setBackground(Color.DARK_GRAY);
        jp.setLayout(null);
        mg.obtenerDatosPaises();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String pais : mg.obtenerDatosPaises().keySet()) {
            int cantidad = mg.obtenerDatosPaises().get(pais);
            dataset.setValue(cantidad, "Visitas", pais);
        }

        JFreeChart chart = ChartFactory.createLineChart(
                "Visitas por País",
                "País", 
                "Visitas", 
                dataset, 
                PlotOrientation.VERTICAL, 
                false, 
                true, 
                false);
        
        CategoryPlot plot = new CategoryPlot();
        ChartPanel chartPanel = new ChartPanel(chart);
        plot.setDomainGridlinesVisible(true); // Líneas divisorias en el eje x
        plot.setRangeGridlinePaint(Color.BLACK); // Color de las líneas divisorias
        chart.setBorderPaint(Color.BLACK);
        chart.setBackgroundPaint(Color.WHITE);
    
        
        jt.addTab("Estadistica 4", chartPanel); // Agregar el gráfico como pestaña
    }
    
    // Método para crear el gráfico de estadística 5
    public void estadistica5(){
        JPanel jp = new JPanel();
        jp.setBackground(Color.DARK_GRAY);
        jp.setLayout(null);
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Map<Integer, Integer> datosMeses = mg.obtenerDatosMeses();
        for (int mes = 1; mes <= 12; mes++) {
            int cantidad = datosMeses.getOrDefault(mes, 0);
            String nombreMes = obtenerNombreMes(mes);
            dataset.addValue(cantidad, "Viajes", nombreMes);
        }

        JFreeChart chart = ChartFactory.createBarChart3D(
                "Viajes por Mes", 
                "Mes", 
                "Cantidad de Viajes", 
                dataset, 
                PlotOrientation.HORIZONTAL, 
                true, 
                true, 
                false);
        
        ChartPanel panel = new ChartPanel(chart);
        chart.setBackgroundPaint(Color.WHITE); // Color de fondo del gráfico
        chart.getTitle().setPaint(Color.BLACK); // Color del título 
            	    	    
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.LIGHT_GRAY); // Color del fondo del gráfico

        plot.setDomainGridlinesVisible(true); // Líneas divisorias en el eje x
        plot.setRangeGridlinePaint(Color.BLACK); // Color de las líneas divisorias
        
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(true); // Dibujar contorno de las barras
        
        // Color de las barras
        GradientPaint gp = new GradientPaint(0.0f, 0.0f, Color.GREEN, 0.0f, 0.0f, new Color(0, 64, 0));
        renderer.setSeriesPaint(0, gp);
        
        jt.addTab("Estadistica 5", panel); // Agregar el gráfico como pestaña
    }   
    
    /**
     * Obtiene el nombre de un mes a partir de su número.
     * @param mes El número del mes.
     * @return El nombre del mes.
     */
    private String obtenerNombreMes(int mes) {
        switch (mes) {
            case 1: return "Enero";
            case 2: return "Febrero";
            case 3: return "Marzo";
            case 4: return "Abril";
            case 5: return "Mayo";
            case 6: return "Junio";
            case 7: return "Julio";
            case 8: return "Agosto";
            case 9: return "Septiembre";
            case 10: return "Octubre";
            case 11: return "Noviembre";
            case 12: return "Diciembre";
            default: return "";
        }
    }
}