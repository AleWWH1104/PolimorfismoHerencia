public class MaterialBibliografico {
    String nombre;
    String editorial;
    Integer año_publicacion;
    String genero;
    String autor;
    String tipo;
    
    public MaterialBibliografico(String nombre, String editorial, Integer año_publicacion, String genero, String autor, String tipo){
        this.nombre = nombre;
        this.editorial = editorial;
        this.año_publicacion = año_publicacion;
        this.genero = genero;
        this.autor = autor;
        this.tipo = tipo;
    }
    
    public void generarReferencia(){

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
        return autor;
    }

    public String getTipo(){
        return tipo;
    }
}
