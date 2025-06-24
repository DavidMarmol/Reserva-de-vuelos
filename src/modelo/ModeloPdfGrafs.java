package modelo;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import org.jfree.chart.JFreeChart;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import vista.Graficas;

/**
 * Modelo para la creación de un documento PDF con gráficos.
 */
public class ModeloPdfGrafs {

    /**
     * Crea un documento PDF con los gráficos proporcionados.
     * @param graficas Objeto que contiene los gráficos a incluir en el PDF.
     */
    public void createPDFWithCharts(Graficas graficas) {
        // Paso 1: Creación de un objeto documento
        Document document = new Document(PageSize.LETTER);

        try {
            // Paso 2: Creación del escritor
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Graficos.pdf"));

            // Paso 3: Abrimos el documento
            document.open();

            // Paso 4: Obtenemos el ContentByte y dibujamos los gráficos en él
            PdfContentByte cb = writer.getDirectContent();

            JFreeChart[] charts = {
                graficas.chart1,
                graficas.chart2,
                graficas.chart3
            };

            for (JFreeChart chart : charts) {
                // Creamos una nueva página para cada gráfica
                document.newPage();
                Graphics2D g2 = cb.createGraphics(PageSize.LETTER.getWidth(), PageSize.LETTER.getHeight());
                Rectangle2D r2D = new Rectangle2D.Double(0, 0, PageSize.LETTER.getWidth(), PageSize.LETTER.getHeight());
                chart.draw(g2, r2D);
                g2.dispose();
            }
        } catch (DocumentException | FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } finally {
            // Paso 5: Cerramos el documento
            document.close();
        }

        // Mostrar mensaje en un JOptionPane después de crear el documento PDF
        JOptionPane.showMessageDialog(null, "Se descargó el archivo 'Graficos.pdf' en la carpeta del proyecto", 
                                      "PDF Creado", JOptionPane.INFORMATION_MESSAGE);
    }
}