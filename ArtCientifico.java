/**
 * La clase ArtCientifico representa un artículo científico que es un subtipo de MaterialBibliografico.
 * Contiene información adicional como DOI y número de volumen de la revista científica.
 * @author David Dominguez
 * @version 1.0
 * @since 2023-10-06
 */
public class ArtCientifico extends MaterialBibliografico {

    private String doi;      // DOI (Digital Object Identifier) del artículo
    private String volumen;  // Número de volumen de la revista científica

    /**
     * Constructor de la clase ArtCientifico.
     * @param nombre Nombre del artículo.
     * @param editorial Editorial o compañía.
     * @param año_publicacion Año de publicación.
     * @param genero Género del artículo.
     * @param autorN Nombre del autor.
     * @param autorA Apellido del autor.
     * @param tipo Tipo de material (Artículo Científico).
     * @param doi DOI (Digital Object Identifier) del artículo.
     * @param volumen Número de volumen de la revista científica.
     */
    public ArtCientifico(String nombre, String editorial, Integer año_publicacion, String genero, String autorN, String autorA, String tipo, String doi, String volumen) {
        super(nombre, editorial, año_publicacion, genero, autorN, autorA, tipo);
        this.doi = doi;
        this.volumen = volumen;
    }

    /**
     * Obtiene el DOI (Digital Object Identifier) del artículo.
     * @return DOI del artículo.
     */
    public String getDoi() {
        return doi;
    }

    /**
     * Obtiene el número de volumen de la revista científica.
     * @return Número de volumen de la revista científica.
     */
    public String getVolumen() {
        return volumen;
    }

    /**
     * Genera una referencia bibliográfica en formato APA para el artículo científico.
     * @return Referencia en formato APA.
     */
    @Override
    public String generarReferencia() {
        // Formato APA para artículo científico: Autor/a(s) del artículo. (Año de publicación). Título del artículo. Título de la revista científica, Volumen (Número de emisión), Páginas. DOI o URL
        return nombreReferencia(autorN, autorA) + " (" + getAño() + "). " + getNombre() + ". " + getEditorial() + ", " + getVolumen() + ". " + getDoi();
    }
}
