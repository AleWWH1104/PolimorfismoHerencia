public class MaterialBibliografico {
    String nombre;
    String apellido;
    String editorial;
    Integer año_publicacion;
    String genero;
    String autor;
    String tipo;
    
    public MaterialBibliografico(String nombre, String editorial, Integer año_publicacion, String genero, String autor,String apellido, String tipo){
        this.nombre = nombre;
        this.editorial = editorial;
        this.año_publicacion = año_publicacion;
        this.genero = genero;
        this.autor = autor;
        this.tipo = tipo;
        this.apellido = apellido;
    }

    public String generarReferencia(){
        return "Rerencias APA";
    }

    public String getNombre(String nombre, String apellido){
        char primeraLetra = nombre.charAt(0);
        nombre = apellido + "." + primeraLetra + ".";
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
        return autor;
    }

    public String getTipo(){
        return tipo;
    }
}
