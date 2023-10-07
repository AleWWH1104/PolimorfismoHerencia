/**
 * La clase Periodico representa un material bibliográfico de tipo periódico que es un subtipo de MaterialBibliografico.
 * Contiene información específica de periódicos, incluyendo un enlace o link.
 * @author Iris Ayala
 * @version 1.0
 * @since 2023-10-06
 */
public class Periodico extends MaterialBibliografico {

    private String link;  // Enlace o link al periódico en línea

    /**
     * Constructor de la clase Periodico.
     * @param nombre Nombre del periódico.
     * @param editorial Editorial o compañía.
     * @param año_publicacion Año de publicación.
     * @param genero Género del periódico.
     * @param autorN Nombre del autor.
     * @param autorA Apellido del autor.
     * @param tipo Tipo de material (Periódico).
     * @param link Enlace o link al periódico en línea.
     */
    public Periodico(String nombre, String editorial, Integer año_publicacion, String genero, String autorN, String autorA, String tipo, String link) {
        super(nombre, editorial, año_publicacion, genero, autorN, autorA, tipo);
        this.link = link;
    }

    /**
     * Obtiene el enlace o link al periódico en línea.
     * @return Enlace o link al periódico en línea.
     */
    public String getLink() {
        return link;
    }

    /**
     * Genera una referencia bibliográfica en formato APA para el periódico.
     * @return Referencia en formato APA.
     */
    @Override
    public String generarReferencia() {
        // Formato APA para periódico: Autor/a(s) del artículo. (Año de publicación). Título del artículo. Título del periódico, Enlace.
        return nombreReferencia(autorN, autorA) + " (" + getAño() + "). " + getNombre() + ". " + getEditorial() + ". " + getLink();
    }
}
