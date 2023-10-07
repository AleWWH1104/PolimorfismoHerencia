/**
 * La clase DVD representa un material bibliográfico de tipo DVD que es un subtipo de MaterialBibliografico.
 * Contiene información específica de DVDs.
 * @author Iris Ayala
 * @version 1.0
 * @since 2023-10-06
 */
public class DVD extends MaterialBibliografico {

    /**
     * Constructor de la clase DVD.
     * @param nombre Nombre del DVD.
     * @param editorial Editorial o compañía.
     * @param año_publicacion Año de publicación.
     * @param genero Género del DVD.
     * @param autorN Nombre del autor.
     * @param autorA Apellido del autor.
     * @param tipo Tipo de material (DVD).
     */
    public DVD(String nombre, String editorial, Integer año_publicacion, String genero, String autorN, String autorA, String tipo) {
        super(nombre, editorial, año_publicacion, genero, autorN, autorA, tipo);
    }

    /**
     * Genera una referencia bibliográfica en formato APA para el DVD.
     * @return Referencia en formato APA.
     */
    @Override
    public String generarReferencia() {
        // Formato APA para DVD: Autor/a(s) del DVD. (Año de publicación). Título del DVD. [DVD]. Editorial.
        return nombreReferencia(autorN, autorA) + "(" + getAño() + ")." + getNombre() + ".[DVD]." + getEditorial() + ".";
    }
}
