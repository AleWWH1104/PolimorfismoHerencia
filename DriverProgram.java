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

                //mostrarCatalogoConCitas(lector);
                break;

            case "4":
                salir = true;
            }
        }
    }

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

            lectorCitas.agregarCitaAPA(referenciaL);
            System.out.println(referenciaL);

        } else if ("2".equalsIgnoreCase(tipo)){
            DVD dvd = new DVD(nombre, editorial, anio, genero, autorN, autorA, "DVD");
            catalogo.add(dvd);
            System.out.println("------Impresion de Referencia------");
            String referenciaD =dvd.generarReferencia();

            lectorCitas.agregarCitaAPA(referenciaD);
            System.out.println(referenciaD);   

        } else if ("3".equalsIgnoreCase(tipo)){
            System.out.print("Ingrese link: ");
            String link = in.nextLine();
            Periodico per = new Periodico(nombre, editorial, anio, genero, autorN, autorA, "Periodico", link);
            catalogo.add(per);
            System.out.println("------Impresion de Referencia------");
            String referenciaP =per.generarReferencia();

            lectorCitas.agregarCitaAPA(referenciaP);
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

            lectorCitas.agregarCitaAPA(referenciaAC);
            System.out.println(referenciaAC); 

        } else if ("5".equalsIgnoreCase(tipo)){
            System.out.print("Ingrese El Nombre de la institucion: ");
            String nombreInst = in.nextLine();

            Tesis tesis = new Tesis(nombre, editorial, anio, genero, autorN, autorA, "Tesis", nombreInst);
            catalogo.add(tesis);
            System.out.println("------Impresion de Referencia------");
            String referenciaT =tesis.generarReferencia();

            lectorCitas.agregarCitaAPA(referenciaT);
            System.out.println(referenciaT); 


        }
    

    }

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

    /*
    public void mostrarCatalogoConCitas(FileManager lector) {
        List<String[]> contenidoExistente = lector.leerCSV();

        System.out.println("Catalogo con Citas:");
        for (MaterialBibliografico material : catalogo) {
            String referencia = material.generarReferencia();
            System.out.println(referencia);
        }
    } 
    */
    
        
    public static void main(String[] args) {
        //Instancia del Driver para acceder a las demas funciones
        DriverProgram main = new DriverProgram();
    }
}
