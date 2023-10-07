/**
 * La clase FileManager proporciona métodos para leer y escribir archivos CSV,
 * así como para realizar operaciones de conteo y agregar citas APA a un archivo.
 * @author David Dominguez
 * @author Iris Ayala
 * @version 1.0
 * @since 2023-10-06
 */

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

    /**
     * Constructor de la clase FileManager.
     * @param rutaArchivo Ruta del archivo CSV que se va a gestionar.
     */
    public FileManager(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    /**
     * Lee un archivo CSV y devuelve sus líneas como una lista de arreglos de cadenas.
     * @return Lista de arreglos de cadenas representando las líneas del archivo CSV.
     */
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

    /**
     * Escribe una lista de objetos MaterialBibliografico en un archivo CSV.
     * @param contenidoCSV Lista de objetos MaterialBibliografico para escribir en el archivo.
     */
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

    // Espacio para realizar métodos de conteo

    /**
     * Realiza el conteo de materiales por género a partir de un archivo CSV.
     * @return Mapa que contiene el conteo de materiales por género.
     */
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

    /**
     * Realiza el conteo de materiales por autor a partir de un archivo CSV.
     * @return Mapa que contiene el conteo de materiales por autor.
     */
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

    /**
     * Realiza el conteo de materiales por año de publicación a partir de un archivo CSV.
     * @return Mapa que contiene el conteo de materiales por año de publicación.
     */
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

    /**
     * Agrega una nueva cita APA al final de un archivo.
     * @param nuevaCitaAPA La cita APA a agregar al archivo.
     */
    public void agregarCitaAPA(String nuevaCitaAPA) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            writer.write(nuevaCitaAPA + "\n");
            System.out.println("Nueva cita APA agregada al archivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}