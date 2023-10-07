/**
 * La clase MaterialBibliografico representa un material bibliográfico genérico.
 * @author David Dominguez
 * @author Iris Ayala
 * @version 1.0
 * @since 2023-10-06
 */
public class MaterialBibliografico {
    String nombre;              // Nombre del material
    String editorial;           // Editorial o compañía
    Integer año_publicacion;    // Año de publicación
    String genero;              // Género del material
    String autorN;              // Nombre del autor
    String autorA;              // Apellido del autor
    String tipo;                // Tipo de material (Libro, DVD, etc.)

    /**
     * Constructor de la clase MaterialBibliografico.
     * @param nombre Nombre del material.
     * @param editorial Editorial o compañía.
     * @param año_publicacion Año de publicación.
     * @param genero Género del material.
     * @param autorN Nombre del autor.
     * @param autorA Apellido del autor.
     * @param tipo Tipo de material (Libro, DVD, etc.).
     */
    public MaterialBibliografico(String nombre, String editorial, Integer año_publicacion, String genero, String autorN, String autorA, String tipo) {
        this.nombre = nombre;
        this.editorial = editorial;
        this.año_publicacion = año_publicacion;
        this.genero = genero;
        this.autorN = autorN;
        this.autorA = autorA;
        this.tipo = tipo;
    }

    /**
     * Método para generar una referencia bibliográfica en formato APA.
     * @return Referencia en formato APA.
     */
    public String generarReferencia() {
        return "Referencia APA"; // Debes implementar la generación real de la referencia aquí
    }

    /**
     * Método para obtener el nombre del material.
     * @return Nombre del material.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para obtener la editorial o compañía.
     * @return Editorial o compañía.
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * Método para obtener el año de publicación.
     * @return Año de publicación.
     */
    public Integer getAño() {
        return año_publicacion;
    }

    /**
     * Método para obtener el género del material.
     * @return Género del material.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Método para obtener el nombre completo del autor.
     * @return Nombre completo del autor (nombre + apellido).
     */
    public String getAutor() {
        return autorN + " " + autorA;
    }

    /**
     * Método para obtener el tipo de material.
     * @return Tipo de material (Libro, DVD, etc.).
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método estático para generar el formato de nombre de referencia con apellido y primera letra del nombre.
     * @param nombre Nombre del autor.
     * @param apellido Apellido del autor.
     * @return Nombre de referencia en formato APA (Apellido, N.).
     */
    public static String nombreReferencia(String nombre, String apellido) {
        char primeraLetra = nombre.charAt(0);
        return apellido + ", " + primeraLetra + ".";
    }

    /**
     * Método toString para obtener una representación en cadena del objeto MaterialBibliografico.
     * @return Representación en cadena del objeto.
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Editorial: " + editorial + ", Año de Publicación: " + año_publicacion +
               ", Género: " + genero + ", Autor: " + autorN + " " + autorA + ", Tipo: " + tipo;
    }
}
