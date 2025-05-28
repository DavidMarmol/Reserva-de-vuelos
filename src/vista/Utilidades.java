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
Fecha:  7 de mayo del 2025
Versión: 1.1
*/

package vista;

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
public class Utilidades {

    /**
     * Crea un JLabel con las especificaciones dadas.
     *
     * @param c     la coordenada x del JLabel.
     * @param f     la coordenada y del JLabel.
     * @param ancho el ancho del JLabel.
     * @param alto  el alto del JLabel.
     * @param texto el texto a mostrar en el JLabel.
     * @return un JLabel configurado con los parámetros dados.
     */
    public static JLabel label(int c, int f, int ancho, int alto, String texto) {
        JLabel jl = new JLabel(texto);
        jl.setBounds(c, f, ancho, alto);
        jl.setFont(new Font("Book Antiqua", Font.BOLD, 20));
        jl.setForeground(Color.DARK_GRAY);
        return jl;
    }

    /**
     * Crea un JButton con las especificaciones dadas.
     *
     * @param c     la coordenada x del JButton.
     * @param f     la coordenada y del JButton.
     * @param ancho el ancho del JButton.
     * @param alto  el alto del JButton.
     * @param texto el texto a mostrar en el JButton.
     * @return un JButton configurado con los parámetros dados.
     */
    public static JButton botones(int c, int f, int ancho, int alto, String texto) {
        JButton jb = new JButton(texto);
        jb.setBounds(c, f, ancho, alto);
        jb.setToolTipText(texto);
        jb.setFocusable(false);
        return jb;
    }

    /**
     * Crea un JLabel para títulos de listas con las especificaciones dadas.
     *
     * @param c     la coordenada x del JLabel.
     * @param f     la coordenada y del JLabel.
     * @param ancho el ancho del JLabel.
     * @param alto  el alto del JLabel.
     * @param texto el texto a mostrar en el JLabel.
     * @return un JLabel configurado con los parámetros dados.
     */
    public static JLabel tituloListas(int c, int f, int ancho, int alto, String texto) {
        JLabel jl = new JLabel(texto);
        jl.setBounds(c, f, ancho, alto);
        jl.setFont(new Font("Book Antiqua", Font.BOLD, 30));
        jl.setBorder(new EtchedBorder());
        jl.setOpaque(true);
        jl.setBackground(Color.WHITE);
        return jl;
    }

    /**
     * Crea un JFrame con las especificaciones dadas.
     *
     * @param ancho     el ancho del JFrame.
     * @param alto      el alto del JFrame.
     * @param texto     el título del JFrame.
     * @param opcCerrar la operación de cierre del JFrame.
     * @return un JFrame configurado con los parámetros dados.
     */
    public static JFrame jframe(int ancho, int alto, String texto, int opcCerrar) {
        JFrame jf = new JFrame(texto);
        jf.setSize(ancho, alto);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(opcCerrar);
        jf.setLayout(null);
        return jf;
    }
}