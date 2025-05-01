package utilerias;

/**
 * Clase para limitar el número de caracteres y el tipo de datos que se pueden introducir en un JTextComponent.
 * Extiende PlainDocument para sobrescribir el método insertString y realizar la validación.
 */
public class LimitadorCaracteres extends javax.swing.text.PlainDocument
{
    private javax.swing.text.JTextComponent editor; // El editor al que se limita los caracteres
    private int numeroMaximoCaracteres; // Número máximo de caracteres permitidos
    private int tipo; // Tipo de datos aceptados en el editor (0 = numérico, 1 = alfanumérico, 2 = ambos, 3 = reales)

    /**
     * Constructor de la clase LimitadorCaracteres.
     * 
     * @param editor Editor en el que se quieren limitar los caracteres.
     * @param numeroMaximoCaracteres Número máximo de caracteres permitidos.
     * @param tipo Tipo de campo (0 = numérico, 1 = alfanumérico, 2 = ambos, 3 = reales).
     */
    public LimitadorCaracteres(javax.swing.text.JTextComponent editor, int numeroMaximoCaracteres, int tipo)
    {
        this.editor = editor;
        this.numeroMaximoCaracteres = numeroMaximoCaracteres;  
        this.tipo = tipo;
    }

    /**
     * Sobrescribe el método insertString para validar los caracteres introducidos.
     * 
     * @param arg0 Posición en la que se insertará el texto.
     * @param arg1 Texto a insertar.
     * @param arg2 Atributos del texto a insertar.
     * @throws javax.swing.text.BadLocationException Excepción lanzada cuando la posición es inválida.
     */
    @Override
    public void insertString(int arg0, String arg1, javax.swing.text.AttributeSet arg2) throws javax.swing.text.BadLocationException
    {
        // Se valida el tipo de dato aceptado
        switch(tipo)
        {
            case 0: // Numérico
                for(int i=0; i<arg1.length(); i++)                 
                    if(!Character.isDigit(arg1.charAt(i)))
                        return;
                break;
                            
            case 1: // Alfanumérico
                for(int i=0; i<arg1.length(); i++)                 
                    if(!Character.isLetter(arg1.charAt(i)) && !Character.isWhitespace(arg1.charAt(i)))
                        return;
                break;
           
            case 2: // Ambos
                for(int i=0; i<arg1.length(); i++)                 
                    if(!Character.isLetterOrDigit(arg1.charAt(i)) && !Character.isWhitespace(arg1.charAt(i)) && 
                        arg1.charAt(i) != '-' && arg1.charAt(i) != '#' && arg1.charAt(i) != '.' && arg1.charAt(i) != '(' && 
                        arg1.charAt(i) != ')')
                        return;
                break;
           
            case 3: // Reales
                for(int i=0; i<arg1.length(); i++)                 
                    if(!Character.isDigit(arg1.charAt(i)) && arg1.charAt(i) != '.')
                        return;
                break;                              	                                              
           
            case 4: // Números con coma
                for(int i=0; i<arg1.length(); i++)                 
                    if(!Character.isDigit(arg1.charAt(i)) && arg1.charAt(i) != ',')
                        return;
                break;
                            
            default: break;
        }     

        // Se verifica si se supera el número máximo de caracteres
        if ((editor.getText().length()+arg1.length()) > this.numeroMaximoCaracteres)
        {
            editor.getToolkit().beep();
            return;
        }

        // Se inserta el texto
        super.insertString(arg0, arg1, arg2);
    }
}
