public class Libro extends MaterialBibliografico {

    public Libro(String nombre, String editorial, Integer año_publicacion, String genero, String autor, String apellido, String tipo){
        super(nombre,editorial, año_publicacion, genero, autor, apellido, tipo);
    }

    @Override
    public String generarReferencia() {
        return getAutor() + ".(" + getAño()+ ")." + getNombre(nombre, apellido) + "."+ getEditorial();
    }
}
