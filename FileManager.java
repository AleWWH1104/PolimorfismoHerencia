import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                String[] elementos = linea.split(",");
                lineasCSV.add(elementos);
            }
        } catch (IOException e) {
            System.out.println("No se encuentra archivo");
            e.printStackTrace();
        }

        return lineasCSV;
    }

    public void escribirCSV(List<MaterialBibliografico> contenidoCSV) {
        try {
            // Leer el contenido existente del archivo
            List<String[]> contenidoExistente = leerCSV();

            for (MaterialBibliografico fila : contenidoCSV) {
                String filaCSV = fila.getNombre() + "," +
                                 fila.getEditorial() + "," +
                                 fila.getAño() + "," +
                                 fila.getGenero() + "," +
                                 fila.getAutor() + "," +
                                 fila.getTipo();
                contenidoExistente.add(filaCSV.split(","));
            }

            // Escribir todo de nuevo en el archivo
            try (FileWriter writer = new FileWriter(rutaArchivo)) {
                for (String[] fila : contenidoExistente) {
                    String filaCSV = String.join(",", fila);
                    writer.write(filaCSV + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Espacio Para realizar metodos deel el conteo
    public Map<String, Integer> contarMaterialesPorGenero() {
        List<String[]> lineasCSV = leerCSV();
        Map<String, Integer> conteoPorGenero = new HashMap<>();

        for (String[] fila : lineasCSV) {
            if (fila.length >= 4) {
                String genero = fila[3]; // Suponiendo que la columna del género es la cuarta columna

                // Actualizar el conteo para el género actual
                conteoPorGenero.put(genero, conteoPorGenero.getOrDefault(genero, 0) + 1);
            }
        }

        return conteoPorGenero;
    } 

    public Map<String, Integer> contarMaterialesPorAutor() {
        List<String[]> lineasCSV = leerCSV();
        Map<String, Integer> conteoPorAutor = new HashMap<>();

        for (String[] fila : lineasCSV) {
            if (fila.length >= 5) {
                String autor = fila[4];

                // Actualizar el conteo para el autor actual
                conteoPorAutor.put(autor, conteoPorAutor.getOrDefault(autor, 0) + 1);
            }
        }

        return conteoPorAutor;
    }

    public Map<String, Integer> contarMaterialesPorAño() {
        List<String[]> lineasCSV = leerCSV();
        Map<String, Integer> conteoPorAño = new HashMap<>();

        for (String[] fila : lineasCSV) {
            if (fila.length >= 2) {
                String año = fila[2];

                // Actualizar el conteo para el año actual
                conteoPorAño.put(año, conteoPorAño.getOrDefault(año, 0) + 1);
            }
        }

        return conteoPorAño;
    }

    public void agregarCitaAPA(String nuevaCitaAPA) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            writer.write(nuevaCitaAPA + "\n");
            System.out.println("Nueva cita APA agregada al archivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}