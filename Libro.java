/**
 * La clase Libro representa un material bibliográfico de tipo libro que es un subtipo de MaterialBibliografico.
 * Contiene información específica de libros.
 * @author David Dominguez
 * @author Iris Ayala
 * @version 1.0
 * @since 2023-10-06
 */
public class Libro extends MaterialBibliografico {

    /**
     * Constructor de la clase Libro.
     * @param nombre Nombre del libro.
     * @param editorial Editorial o compañía.
     * @param año_publicacion Año de publicación.
     * @param genero Género del libro.
     * @param autorN Nombre del autor.
     * @param autorA Apellido del autor.
     * @param tipo Tipo de material (Libro).
     */
    public Libro(String nombre, String editorial, Integer año_publicacion, String genero, String autorN, String autorA, String tipo) {
        super(nombre, editorial, año_publicacion, genero, autorN, autorA, tipo);
    }

    /**
     * Genera una referencia bibliográfica en formato APA para el libro.
     * @return Referencia en formato APA.
     */
    @Override
    public String generarReferencia() {
        // Formato APA para libro: Autor/a(s) del libro. (Año de publicación). Título del libro. Editorial.
        return nombreReferencia(autorN, autorA) + "(" + getAño() + ")." + getNombre() + "." + getEditorial() + ".";
    }
}
