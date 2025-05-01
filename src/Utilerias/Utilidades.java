/*
Este código define una clase Utilidades que contiene métodos estáticos para crear componentes de interfaz de usuario Swing de forma reutilizable.
*/

/*
Proyecto Desarrollo 1
Clase de utilidades
Integrantes: Oscar Jimenez          - cod: 2264419
             Juan Pablo Ochoa       - cod: 2559894
             Juan Alejandro Jimenez - cod: 2266096
             Jose David Marmol      - cod: 2266370
Fecha:  29 de abril del 2025
Versión: 1.0
*/

package utilerias;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;

/**
 * Clase de utilidades con métodos para la creación de componentes visuales reutilizables.
 */
public class Utilidades {//se crean métodos para reutilizar donde sea necesario

    /**
     * Crea un JLabel con el texto especificado y configuraciones de fuente y color predeterminadas.
     * 
     * @param c La coordenada x del JLabel.
     * @param f La coordenada y del JLabel.
     * @param ancho El ancho del JLabel.
     * @param alto La altura del JLabel.
     * @param texto El texto a mostrar en el JLabel.
     * @return Un JLabel configurado según los parámetros especificados.
     */
    public static JLabel label (int c, int f, int ancho, int alto, String texto){
        JLabel jl = new JLabel(texto);
        jl.setBounds(c, f, ancho, alto);
        jl.setFont(new Font("Book Antiqua", Font.BOLD, 20));
        jl.setForeground(Color.DARK_GRAY);
        return jl;
    }
    
    /**
     * Crea un JButton con el texto especificado y configuraciones de tooltip y enfoque predeterminadas.
     * 
     * @param c La coordenada x del JButton.
     * @param f La coordenada y del JButton.
     * @param ancho El ancho del JButton.
     * @param alto La altura del JButton.
     * @param texto El texto a mostrar en el JButton.
     * @return Un JButton configurado según los parámetros especificados.
     */
    public static JButton botones (int c, int f, int ancho, int alto, String texto){
        JButton jb = new JButton(texto);
        jb.setBounds(c, f, ancho, alto);
        jb.setToolTipText(texto);
        jb.setFocusable(false);
        return jb;
    }   

    /**
     * Crea un JLabel con el texto especificado y configuraciones de fuente, borde y color predeterminadas para títulos de listas.
     * 
     * @param c La coordenada x del JLabel.
     * @param f La coordenada y del JLabel.
     * @param ancho El ancho del JLabel.
     * @param alto La altura del JLabel.
     * @param texto El texto a mostrar en el JLabel.
     * @return Un JLabel configurado según los parámetros especificados para títulos de listas.
     */
    public static JLabel tituloListas (int c, int f, int ancho, int alto, String texto){
        JLabel jl = new JLabel(texto);
        jl.setBounds(c, f, ancho, alto);
        jl.setFont(new Font("Book Antiqua", Font.BOLD, 30));
        jl.setBorder(new EtchedBorder());
        jl.setOpaque(true);
        jl.setBackground(Color.WHITE);
        return jl;
    }

    /**
     * Crea un JFrame con el título especificado y configuraciones de tamaño, posición, redimensionabilidad y cierre predeterminadas.
     * 
     * @param ancho El ancho del JFrame.
     * @param alto La altura del JFrame.
     * @param texto El texto a mostrar en el título del JFrame.
     * @param opcCerrar La opción de cierre del JFrame (por ejemplo, JFrame.EXIT_ON_CLOSE).
     * @return Un JFrame configurado según los parámetros especificados.
     */
    public static JFrame jframe (int ancho, int alto, String texto, int opcCerrar){
        JFrame jf = new JFrame(texto);
        jf.setSize(ancho, alto);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(opcCerrar);
        jf.setLayout(null);
        return jf;
    }
}