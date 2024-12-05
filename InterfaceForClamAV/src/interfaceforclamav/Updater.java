/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaceforclamav;

/**
 *
 * @author David
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Updater {
    public String updateDatabase(String directory) {
        String command = "freshclam";
        StringBuilder output = new StringBuilder();

        try {
            File dir = new File(directory);
            if (!dir.exists() || !dir.isDirectory()) {
                throw new IOException("Directorio no encontrado o no es un directorio válido: " + directory);
            }

            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);
            builder.directory(dir);
            Process process = builder.start();

            // Capturar salida estándar
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Capturar errores
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = errorReader.readLine()) != null) {
                output.append("ERROR: ").append(line).append("\n");
            }

            reader.close();
            errorReader.close();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            output.append("Excepción: ").append(e.getMessage()).append("\n");
        }

        return output.toString();
    }
}





