public class ArtCientifico extends MaterialBibliografico{

    // Autor/a(s) del artículo. (Año de publicación). Título del artículo. Título de la revista científica, Volumen (Número de emisión), Páginas. DOI o URL
    
    String doi;
    String volumen;
    
    public String getDoi() {
        return doi;
    }

    public String getVolumen() {
        return volumen;
    }

    public ArtCientifico(String nombre, String editorial, Integer año_publicacion, String genero, String autorN, String autorA, String tipo, String doi, String volumen) {
        super(nombre, editorial, año_publicacion, genero, autorN, autorA, tipo);
        this.doi = doi;
        this.volumen = volumen;
    }

    @Override
    public String generarReferencia() {
        return nombreReferencia(autorN, autorA) + "(" + getAño()+ ")." + getNombre() + getEditorial() +" ("+ getVolumen()+"). "  + getDoi();
    }
    
}
