import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    String rutaArchivo;

    public FileManager(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public List<String[]> leerCSV() {
        List<String[]> lineasCSV = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] elementos = linea.split(";");
                lineasCSV.add(elementos);
            }
        } catch (IOException e) {
            System.out.println("No se encuentra archivo");
            e.printStackTrace();
        }

        return lineasCSV;
    }

    public void escribirCSV(List<String[]> contenidoCSV) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            for (String[] fila : contenidoCSV) {
                String filaCSV = String.join(";", fila);
                writer.write(filaCSV + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}