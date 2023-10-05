import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DriverProgram {
    private List<MaterialBibliografico> catalogo = new ArrayList<>();

    public void datos(){
        Scanner in = new Scanner(System.in);
        System.out.print("Nombre del material: ");
        String nombre = in.nextLine();
        System.out.print("Editorial: ");
        String editorial = in.nextLine();
        System.out.print("Año de publicacion: ");
        Integer anio = Integer.parseInt(in.nextLine());
        System.out.print("Genero: ");
        String genero = in.nextLine();
        System.out.print("Apellido Autor: ");
        String autorA = in.nextLine();
        System.out.print("Nombre Autor: ");
        String autorN = in.nextLine();
        System.out.print("Tipo \n1.Libro\n2.DVD \n3.Tesis\n4.Articulo Cientifico\n5.Periodico");
        String tipo = in.nextLine();
        
        if ("1".equalsIgnoreCase(tipo)) {
            Libro libro = new Libro(nombre, editorial, anio, genero, autorN, autorA, tipo);
            catalogo.add(libro);
        }
    }
        
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
