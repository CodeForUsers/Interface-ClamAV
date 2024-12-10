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
import java.io.IOException;
import java.io.InputStreamReader;

public class taskiller {

    /**
     * Método para finalizar un proceso por su nombre.
     * @param processName Nombre del proceso (ej. "notepad.exe").
     * @return true si el proceso se eliminó correctamente, false en caso contrario.
     */
    public boolean killProcessByName(String processName) {
        String comando = "taskkill /F /IM " + processName;
        return ejecutarComando(comando);
    }

    /**
     * Método para finalizar un proceso por su ID.
     * @param pid ID del proceso.
     * @return true si el proceso se eliminó correctamente, false en caso contrario.
     */
    public boolean killProcessByPid(int pid) {
        String comando = "taskkill /F /PID " + pid;
        return ejecutarComando(comando);
    }

    /**
     * Método privado para ejecutar un comando.
     * @param comando Comando a ejecutar.
     * @return true si el comando se ejecutó correctamente, false en caso contrario.
     */
    private boolean ejecutarComando(String comando) {
        try {
            Process process = Runtime.getRuntime().exec(comando);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            int exitCode = process.waitFor();
            return exitCode == 0;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }


}

