import java.util.List;

public class DriverProgram {
    public static void main(String[] args) {
        // Ruta del archivo CSV
        String rutaArchivo = "/Users/alejandraayala/Desktop/Proyectos_POOS2/PolimorfismoHerencia/Bibliografias.csv";

        // Crear un objeto para leer el archivo existente
        FileManager lector = new FileManager(rutaArchivo);
        List<String[]> contenidoCSV = lector.leerCSV();

        // Procesar el contenido del archivo CSV si es necesario
        for (String[] fila : contenidoCSV) {
            // Realizar operaciones con las filas, si es necesario
            for (String elemento : fila) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }
}
