/*
Este código define una clase Rotator que extiende de Timer e implementa ActionListener. 
Su propósito es rotar un gráfico de tipo PiePlot3D continuamente. La clase tiene un constructor
que recibe el gráfico a rotar y un método actionPerformed que es llamado por el temporizador para actualizar 
el ángulo de inicio del gráfico y lograr la rotación continua.
 */

package vista;

import java.awt.event.*;
import javax.swing.*;
import org.jfree.chart.plot.PiePlot3D;

/**
 * Clase que implementa la rotación continua de un gráfico PiePlot3D.
 */
class Rotator extends Timer implements ActionListener {

    /** El gráfico a rotar. */
    public PiePlot3D plot;
    
    /** El ángulo actual de rotación. */
    public int angle = 270;
    
    /**
     * Constructor que recibe el gráfico a rotar.
     *
     * @param plot el gráfico PiePlot3D.
     */
    Rotator(final PiePlot3D plot) {
        super(100, null); // Crea un Timer con un retraso de 100 ms y sin ActionListener inicial.
        this.plot = plot;
        addActionListener(this); // Agrega esta instancia como ActionListener del Timer.
    }
    
    /**
     * Modifica el ángulo de inicio del gráfico.
     *
     * @param event el evento de acción.
     */
    public void actionPerformed(final ActionEvent event) {
        this.plot.setStartAngle(this.angle); // Establece el ángulo de inicio del gráfico.
        this.angle = this.angle + 1; // Incrementa el ángulo en 1 grado.
        if (this.angle == 360) { // Si el ángulo llega a 360, reinicia a 0.
            this.angle = 0;
        }
    }
}