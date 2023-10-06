public class Tesis extends MaterialBibliografico{
    // Formato: Autor, A. (Año). Título de la tesis [Tipo de tesis para optar un grado o título inédita]. Nombre de la institución que otorga el tít.

    String nombreInst;
    public Tesis(String nombre, String editorial, Integer año_publicacion, String genero, String autorN, String autorA, String tipo, String nombreInst) {
        super(nombre, editorial, año_publicacion, genero, autorN, autorA, tipo);
        this.nombreInst = nombreInst;
        
    }

    public String getNombreInst() {
        return nombreInst;
    }
    
    @Override
    public String generarReferencia() {
        return nombreReferencia(autorN, autorA) + "(" + getAño()+ ")." + getNombre() +" ["+ getTipo()+"] " + getNombreInst() + ".";
    }

}
