public class Libro extends MaterialBibliografico {

    public Libro(String nombre, String editorial, Integer año_publicacion, String genero, String autorN, String autorA, String tipo){
        super(nombre,editorial, año_publicacion, genero, autorN, autorA, tipo);
    }

    @Override
    public String generarReferencia() {
        return nombreReferencia(autorN, autorA) + "(" + getAño()+ ")." + getNombre() + "."+ getEditorial();
    }
}
