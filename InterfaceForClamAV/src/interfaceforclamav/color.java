/**
 *
 * @author BlueFox
 * @GitHub github.com/CodeForUsers
 */


package interfaceforclamav;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class color {

    private JTextPane areaTexto;
    private Map<String, Color> coloresPalabrasClave;
    private boolean resaltadoPendiente = false;

    public color(JTextPane areaTexto) {
        this.areaTexto = areaTexto;
        this.coloresPalabrasClave = crearColoresPalabrasClave();

        areaTexto.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                programarResaltado();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                programarResaltado();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                programarResaltado();
            }
        });
    }

    private Map<String, Color> crearColoresPalabrasClave() {
        Map<String, Color> coloresPalabrasClave = new HashMap<>();
        coloresPalabrasClave.put("Error", Color.RED);
        coloresPalabrasClave.put("OK", Color.GREEN);
        coloresPalabrasClave.put("FOUND", Color.RED);
        return coloresPalabrasClave;
    }

    private void programarResaltado() {
        if (resaltadoPendiente) {
            return;
        }

        resaltadoPendiente = true;
        SwingUtilities.invokeLater(() -> {
            resaltarPalabrasClave();
            resaltadoPendiente = false;
        });
    }

    private void resaltarPalabrasClave() {
        try {
            StyledDocument doc = areaTexto.getStyledDocument();
            SimpleAttributeSet normal = new SimpleAttributeSet();
            StyleConstants.setForeground(normal, Color.WHITE);

            String texto = doc.getText(0, doc.getLength());
            doc.setCharacterAttributes(0, texto.length(), normal, true);

            for (Map.Entry<String, Color> entrada : coloresPalabrasClave.entrySet()) {
                String palabraClave = entrada.getKey();
                Color color = entrada.getValue();
                SimpleAttributeSet resaltado = new SimpleAttributeSet();
                StyleConstants.setForeground(resaltado, color);

                int indice = texto.indexOf(palabraClave);
                while (indice >= 0) {
                    int finPalabra = indice + palabraClave.length();
                    doc.setCharacterAttributes(indice, palabraClave.length(), resaltado, false);
                    indice = texto.indexOf(palabraClave, finPalabra);
                }
            }
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }
}













