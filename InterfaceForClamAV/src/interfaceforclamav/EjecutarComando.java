package interfaceforclamav;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

public class EjecutarComando {
    private Process process;

    public void ejecutarComando(String comando, JTextArea textArea, JProgressBar progressBar) {
        // Establecer el directorio fijo
        String directorio = "C:\\Program Files\\ClamAV";
        
        // Dividir el comando en sus argumentos
        String[] comandoArray = {"cmd.exe", "/c", comando};

        // Configurar ProcessBuilder
        ProcessBuilder processBuilder = new ProcessBuilder(comandoArray);
        processBuilder.directory(new File(directorio));

        try {
            process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            
            // Inicializar la barra de progreso
            progressBar.setIndeterminate(true);
            
            // Hilo para leer la salida del proceso en tiempo real
            new Thread(() -> {
                String line;
                try {
                    while ((line = reader.readLine()) != null) {
                        // Actualizar el JTextArea en el hilo de eventos de Swing
                        String finalLine = line;
                        javax.swing.SwingUtilities.invokeLater(() -> {
                            textArea.append(finalLine + "\n");
                        });
                    }

                    int exitCode = process.waitFor();
                    javax.swing.SwingUtilities.invokeLater(() -> {
                        textArea.append("Comando ejecutado con código de salida: " + exitCode + "\n");
                        progressBar.setIndeterminate(false);
                        progressBar.setValue(100);
                    });

                } catch (IOException | InterruptedException e) {
                    javax.swing.SwingUtilities.invokeLater(() -> {
                        textArea.append("Ocurrió un error: " + e.getMessage() + "\n");
                        progressBar.setIndeterminate(false);
                        progressBar.setValue(0);
                    });
                    e.printStackTrace();
                }
            }).start();
            
        } catch (IOException e) {
            textArea.append("Ocurrió un error de E/S.\n");
            progressBar.setIndeterminate(false);
            progressBar.setValue(0);
            e.printStackTrace();
        }
    }

    public void detenerProceso() {
        if (process != null) {
            process.destroy();
        }
    }
}




