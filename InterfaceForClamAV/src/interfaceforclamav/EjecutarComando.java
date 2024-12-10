/**
 *
 * @author BlueFox
 * @GitHub github.com/CodeForUsers
 */

package interfaceforclamav;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class EjecutarComando {
    private Process process;
    private boolean isRunning = false;
    private int processId;

    public void ejecutarComando(String comando, String directorioSeleccionado, JTextPane textArea, JProgressBar progressBar) {
        // Establecer el directorio fijo para ClamAV
        String directorioClamAV = "C:\\Program Files\\ClamAV";
        String outputFilePath = "../resultData/result.txt"; // Ruta del archivo de salida

        // Verificar si el directorio resultData existe, si no, crearlo
        File outputDir = new File("../resultData");
        if (!outputDir.exists()) {
            if (outputDir.mkdirs()) {
                System.out.println("Directorio creado: " + outputDir.getAbsolutePath());
            } else {
                System.out.println("No se pudo crear el directorio: " + outputDir.getAbsolutePath());
                appendToPane(textArea,"No se pudo crear el directorio de salida.\n",null);
                return;
            }
        }

        // Construir el comando completo con el directorio seleccionado
        String comandoCompleto = comando + " " + directorioSeleccionado;

        // Dividir el comando en sus argumentos
        String[] comandoArray = {"cmd.exe", "/c", comandoCompleto};

        // Configurar ProcessBuilder
        ProcessBuilder processBuilder = new ProcessBuilder(comandoArray);
        processBuilder.directory(new File(directorioClamAV));
        processBuilder.redirectErrorStream(true);

        try {
            process = processBuilder.start();
            isRunning = true;
            processId = getProcessId(process); // Obtener el ID del proceso
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            // Inicializar la barra de progreso
            progressBar.setIndeterminate(true);
            progressBar.setString("Analyzing...");

            // Hilo para leer la salida del proceso en tiempo real
            new Thread(() -> {
                String line;
                try (FileWriter fileWriter = new FileWriter(outputFilePath,true)){
                    while ((line = reader.readLine()) != null) {
                        // Actualizar el JTextArea en el hilo de eventos de Swing
                        String finalLine = line;
                        javax.swing.SwingUtilities.invokeLater(() -> {
                            appendToPane(textArea,finalLine + "\n",null);
                        });
                        // Escribir en el archivo de texto
                        fileWriter.write(line + "\n");
                    }

                    int exitCode = process.waitFor();
                    isRunning = false;
                    javax.swing.SwingUtilities.invokeLater(() -> {
                        //textArea.append("Comando ejecutado con código de salida: " + exitCode + "\n");
                        progressBar.setIndeterminate(false);
                        progressBar.setValue(100);
                        progressBar.setString("Finish");
                    });
                    // Escribir el código de salida en el archivo de texto
                    fileWriter.write("Comando ejecutado con código de salida: " + exitCode + "\n");

                } catch (IOException | InterruptedException e) {
                    isRunning = false;
                    javax.swing.SwingUtilities.invokeLater(() -> {
                        //textArea.append("Ocurrió un error: " + e.getMessage() + "\n");
                        progressBar.setIndeterminate(false);
                        progressBar.setValue(0);
                        progressBar.setString("Error");
                    });
                    // Escribir el error en el archivo de texto
                    try (FileWriter fileWriter = new FileWriter(outputFilePath, true)) {
                        fileWriter.write("Ocurrió un error: " + e.getMessage() + "\n");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    e.printStackTrace();
                }
            }).start();

        } catch (IOException e) {
            //textArea.append("Ocurrió un error de E/S.\n");
            progressBar.setIndeterminate(false);
            progressBar.setValue(0);
            e.printStackTrace();
            progressBar.setString("Error E/S");
        }
    }

    private int getProcessId(Process process) {
        // Obtener el ID del proceso en Windows
        String processInfo = process.toString();
        String[] parts = processInfo.split(",");
        for (String part : parts) {
            if (part.trim().startsWith("pid=")) {
                return Integer.parseInt(part.trim().substring(4));
            }
        }
        return -1; // Retornar un valor por defecto en caso de no encontrar el ID
    }
    
// Método personalizado para añadir texto al final del JTextPane 
    private static void appendToPane(JTextPane textPane, String texto, Color color)
    { StyledDocument doc = textPane.getStyledDocument(); 
    Style style = textPane.addStyle("Estilo", null); 
    if (color != null) { 
        StyleConstants.setForeground(style, color); 
    } 
    try { 
        doc.insertString(doc.getLength(), texto, style); 
    } catch (BadLocationException e) {
        e.printStackTrace(); } }





}







