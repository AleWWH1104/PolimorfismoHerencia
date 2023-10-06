import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DriverProgram {
    private List<MaterialBibliografico> catalogo = new ArrayList<>();
    // Ruta del archivo CSV
    String rutaArchivo = "/Users/alejandraayala/Desktop/Proyectos_POOS2/PolimorfismoHerencia/Bibliografias.csv";

    public DriverProgram(){
        Scanner in = new Scanner(System.in);
        FileManager lector = new FileManager(rutaArchivo);
        boolean salir = false;
        while (!salir) {
        System.out.println("1.Generar referencia");
        System.out.println("2.Mostrar conteo de Materiales");
        System.out.println("3.Mostrar Catalogo con citas");
        System.out.println("4.Salir");
        String opcion = in.nextLine();
        switch (opcion){
            case "1":
                datos(in);
                System.out.println("_____Escribiendo en CSV_____");
                lector.escribirCSV(catalogo);
                catalogo.clear(); //Se limpia la lista para no sobreescribir en el CSV
                break;
            case "2":
            case "3":
            case "4":
                salir = true;
            }
        }
    }

    public void datos(Scanner in){
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
            System.out.println(referenciaL);
        } else if ("2".equalsIgnoreCase(tipo)){
            DVD dvd = new DVD(nombre, editorial, anio, genero, autorN, autorA, "DVD");
            catalogo.add(dvd);
            System.out.println("------Impresion de Referencia------");
            String referenciaD =dvd.generarReferencia();
            System.out.println(referenciaD);   
        } else if ("3".equalsIgnoreCase(tipo)){
            System.out.print("Ingrese link: ");
            String link = in.nextLine();
            Periodico per = new Periodico(nombre, editorial, anio, genero, autorN, autorA, "Periodico", link);
            catalogo.add(per);
            System.out.println("------Impresion de Referencia------");
            String referenciaP =per.generarReferencia();
            System.out.println(referenciaP); 
        }
    }
        
    public static void main(String[] args) {
        //Instancia del Driver para acceder a las demas funciones
        DriverProgram main = new DriverProgram();
    }
}
