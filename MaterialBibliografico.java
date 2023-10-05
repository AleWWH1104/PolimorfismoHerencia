public class MaterialBibliografico {
    String nombre;
    String editorial;
    Integer año_publicacion;
    String genero;
    String autorN;
    String autorA;
    String tipo;
    
    public MaterialBibliografico(String nombre, String editorial, Integer año_publicacion, String genero, String autorN, String autorA, String tipo){
        this.nombre = nombre;
        this.editorial = editorial;
        this.año_publicacion = año_publicacion;
        this.genero = genero;
        this.autorN = autorN;
        this.autorA = autorA;
        this.tipo = tipo;
    }

    public String generarReferencia(){
        return "Rerencias APA";
    }

    public String getNombre(){
        return nombre;
    }
    public String getEditorial(){
        return editorial;
    }
    public Integer getAño(){
        return año_publicacion;
    }
    public String getGenero(){
        return genero;
    }
    public String getAutor(){
        return autorA;
    }

    public String getTipo(){
        return tipo;
    }

    public String nombreReferencia(String nombre, String apellido){
        char primeraLetra = nombre.charAt(0);
        String nombreR = apellido + "." + primeraLetra + ".";
        return nombreR;
    }
    @Override
    public String toString() {
    return "Nombre: " + nombre + ", Editorial: " + editorial + ", Año de Publicación: " + año_publicacion +
           ", Género: " + genero + ", Autor: " + autorN + " "+ autorA + ", Tipo: " + tipo;
    }

}
