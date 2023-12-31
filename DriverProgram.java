/**
 * La clase DriverProgram es una aplicación para gestionar un catálogo de materiales bibliográficos
 * y realizar operaciones como generar referencias, mostrar conteos y mostrar el catálogo con citas.
 * @author David Dominguez
 * @author Iris Ayala
 * @version 1.0
 * @since 2023-10-06
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DriverProgram {
    private List<MaterialBibliografico> catalogo = new ArrayList<>();
    // Ruta del archivo CSV
    //String rutaArchivo = "/Users/alejandraayala/Desktop/Proyectos_POOS2/PolimorfismoHerencia/Bibliografias.csv";
    String rutaArchivo = "Bibliografias.csv";
    String rutaArchivoCitas = "Citas.csv";
    
    /**
     * Constructor de la clase DriverProgram. Inicializa un bucle de menú para interactuar con el programa.
     */
    public DriverProgram(){
        Scanner in = new Scanner(System.in);
        FileManager lector = new FileManager(rutaArchivo);
        FileManager lectorCitas = new FileManager(rutaArchivoCitas);

        boolean salir = false;
        while (!salir) {
        System.out.println("1.Generar referencia");
        System.out.println("2.Mostrar conteo de Materiales");
        System.out.println("3.Mostrar Catalogo con citas");
        System.out.println("4.Salir");
        String opcion = in.nextLine();
        switch (opcion){
            case "1":
                datos(in, lectorCitas);
                System.out.println("_____Escribiendo en CSV_____");
                lector.escribirCSV(catalogo);
                catalogo.clear(); //Se limpia la lista para no sobreescribir en el CSV
                break;
            case "2":
                
                conteoMenu(in, lector);
                break;

            case "3":

                mostrarCatalogoConCitas(lector, lectorCitas);
                break;

            case "4":
                salir = true;
            }
        }
    }

    /**
     * Método para ingresar datos de un material bibliográfico y generar referencias.
     * @param in Scanner para entrada de datos desde el teclado.
     * @param lectorCitas FileManager para gestionar el archivo de citas.
     */
    public void datos(Scanner in, FileManager lectorCitas){
        System.out.print("Nombre del material: ");
        String nombre = in.nextLine();
        System.out.print("Editorial/Compañia: ");
        String editorial = in.nextLine();
        System.out.print("Año de publicacion: ");
        Integer anio = Integer.parseInt(in.nextLine());
        System.out.print("Genero: ");
        String genero = in.nextLine();
        System.out.print("Apellido Autor: ");
        String autorA = in.nextLine();
        System.out.print("Nombre Autor: ");
        String autorN = in.nextLine();
        System.out.print("Tipo \n1.Libro\n2.DVD \n3.Periodico\n4.Articulo Cientifico\n5.Tesis\n");
        String tipo = in.nextLine();
        
        if ("1".equalsIgnoreCase(tipo)) {
            Libro libro = new Libro(nombre, editorial, anio, genero, autorN, autorA, "Libro");
            catalogo.add(libro);
            System.out.println("------Impresion de Referencia------");
            String referenciaL =libro.generarReferencia();

            lectorCitas.agregarCitaAPA(referenciaL + "  - Cita: (" + autorA + ", "+ anio + ")");
            System.out.println(referenciaL);

        } else if ("2".equalsIgnoreCase(tipo)){
            DVD dvd = new DVD(nombre, editorial, anio, genero, autorN, autorA, "DVD");
            catalogo.add(dvd);
            System.out.println("------Impresion de Referencia------");
            String referenciaD =dvd.generarReferencia();

            lectorCitas.agregarCitaAPA(referenciaD + "  - Cita: (" + autorA + ", "+ anio + ")");
            System.out.println(referenciaD);   

        } else if ("3".equalsIgnoreCase(tipo)){
            System.out.print("Ingrese link: ");
            String link = in.nextLine();
            Periodico per = new Periodico(nombre, editorial, anio, genero, autorN, autorA, "Periodico", link);
            catalogo.add(per);
            System.out.println("------Impresion de Referencia------");
            String referenciaP =per.generarReferencia();

            lectorCitas.agregarCitaAPA(referenciaP + "  - Cita: (" + autorA + ", "+ anio + ")");
            System.out.println(referenciaP); 

        } else if ("4".equalsIgnoreCase(tipo)){
            System.out.print("Ingrese DOI: ");
            String doi = in.nextLine();
            System.out.print("Ingrese Volumen: ");
            String volumen = in.nextLine();

            ArtCientifico artCient = new ArtCientifico(nombre, editorial, anio, genero, autorN, autorA, "Articulo Cientifico", doi, volumen);
            catalogo.add(artCient);
            System.out.println("------Impresion de Referencia------");
            String referenciaAC =artCient.generarReferencia();

            lectorCitas.agregarCitaAPA(referenciaAC + "  - Cita: (" + autorA + ", "+ anio + ")");
            System.out.println(referenciaAC); 

        } else if ("5".equalsIgnoreCase(tipo)){
            System.out.print("Ingrese El Nombre de la institucion: ");
            String nombreInst = in.nextLine();

            Tesis tesis = new Tesis(nombre, editorial, anio, genero, autorN, autorA, "Tesis", nombreInst);
            catalogo.add(tesis);
            System.out.println("------Impresion de Referencia------");
            String referenciaT =tesis.generarReferencia();

            lectorCitas.agregarCitaAPA(referenciaT + "  - Cita: (" + autorA + ", "+ anio + ")");
            System.out.println(referenciaT); 


        }
    

    }

    /**
     * Método para mostrar un menú de opciones de conteo de materiales y realizar la operación seleccionada.
     * @param in Scanner para entrada de datos desde el teclado.
     * @param lector FileManager para gestionar el archivo CSV de materiales bibliográficos.
     */
    public void conteoMenu(Scanner in, FileManager lector){

        System.out.println("Seleccione una opción:");
        System.out.println("1. Contar materiales por género");
        System.out.println("2. Contar materiales por autor");
        System.out.println("3. Contar materiales por año de publicación");

        System.out.print("Opción: ");
        int op = in.nextInt();

        if (op == 1){
            Map<String, Integer> conteoPorGenero = lector.contarMaterialesPorGenero();
            System.out.println("Conteo por genero:");
            for (Map.Entry<String, Integer> entry : conteoPorGenero.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } else if (op == 2){
            Map<String, Integer> conteoPorAutor = lector.contarMaterialesPorAutor();
            System.out.println("Conteo por autor:");
            for (Map.Entry<String, Integer> entry : conteoPorAutor.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } else if (op == 3){
            Map<String, Integer> conteoPorAutor = lector.contarMaterialesPorAño();
            System.out.println("Conteo por Año:");
            for (Map.Entry<String, Integer> entry : conteoPorAutor.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

    } 

    /**
     * Método para mostrar el catálogo de materiales bibliográficos con sus respectivas citas.
     * @param lectorBibliografias FileManager para gestionar el archivo CSV de bibliografías.
     * @param lectorCitas FileManager para gestionar el archivo CSV de citas.
     */

    public void mostrarCatalogoConCitas(FileManager lectorBibliografias, FileManager lectorCitas) {
        List<String[]> contenidoBibliografias = lectorBibliografias.leerCSV();
        List<String[]> contenidoCitas = lectorCitas.leerCSV();
    
        if (contenidoBibliografias.size() != contenidoCitas.size()) {
            System.out.println("Los archivos no tienen la misma cantidad de líneas.");
            return;
        }
    
        System.out.println("Catalogo con Citas:");
    
        for (int i = 0; i < contenidoBibliografias.size(); i++) {
            String[] filaBibliografias = contenidoBibliografias.get(i);
            String[] filaCitas = contenidoCitas.get(i);
    
            System.out.println("Datos: " + String.join(",", filaBibliografias));
            System.out.println("Referencia: " + String.join(",", filaCitas));
            System.out.println();
        }
    }

    /**
     * Método principal que crea una instancia de la clase DriverProgram para ejecutar la aplicación.
     * @param args Argumentos de línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        //Instancia del Driver para acceder a las demas funciones
        DriverProgram main = new DriverProgram();
    }
}
