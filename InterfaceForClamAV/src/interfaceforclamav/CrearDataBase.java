package interfaceforclamav;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class CrearDataBase {

    public void crearArchivoFreshclamConf() {
        // Contenido del archivo freshclam.conf
        String contenido = "DatabaseDirectory \"C:\\Program Files\\ClamAV\\database\"\n" +
                           "UpdateLogFile \"C:\\Program Files\\ClamAV\\freshclam.log\"\n" +
                           "LogFileMaxSize 2M\n" +
                           "LogTime yes\n" +
                           "# Uncomment the following line to enable logging of executed commands.\n" +
                           "# Debug yes\n";

        // Crear la carpeta database si no existe
        crearCarpetaDatabase();

        // Verificar si el directorio existe
        String rutaDirectorio = "C:\\Program Files\\ClamAV";
        File directorio = new File(rutaDirectorio);
        if (!directorio.exists() || !directorio.isDirectory()) {
            System.out.println("El directorio especificado no existe: " + rutaDirectorio);
            return;
        }

        // Crear el archivo freshclam.conf dentro del directorio existente
        File archivo = new File(directorio, "freshclam.conf");

        try {
            // Crear y escribir en el archivo
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getAbsolutePath());
            } else {
                JOptionPane.showMessageDialog(null,"Ya existe la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            }

            FileWriter writer = new FileWriter(archivo);
            writer.write(contenido);
            writer.close();
            System.out.println("Se escribió en el archivo.");

        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
            e.printStackTrace();
        }
    }
    
    public void crearCarpetaDatabase() {
        String rutaDirectorio = "C:\\Program Files\\ClamAV\\database";
        File directorio = new File(rutaDirectorio);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Carpeta database creada: " + rutaDirectorio);
            } else {
                System.out.println("No se pudo crear la carpeta database: " + rutaDirectorio);
            }
        } else {
            System.out.println("La carpeta database ya existe: " + rutaDirectorio);
        }
    }
}





