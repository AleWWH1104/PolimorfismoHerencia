public class Periodico extends MaterialBibliografico{
    String link;
    public Periodico(String nombre, String editorial, Integer año_publicacion, String genero, String autorN, String autorA, String tipo, String link){
        super(nombre,editorial, año_publicacion, genero, autorN, autorA, tipo);
        this.link = link;
    }

    public String getlink(){
        return link;
    }
    @Override
    public String generarReferencia() {
        return nombreReferencia(autorN, autorA) + "(" + getAño()+ ")." + getNombre() + "."+ getEditorial()+ "." + getlink();
    }
}
