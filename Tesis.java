/**
 * La clase Tesis representa un material bibliográfico de tipo tesis que es un subtipo de MaterialBibliografico.
 * Contiene información específica de tesis, incluyendo el nombre de la institución que otorga el título.
 * @author David Dominguez
 * @version 1.0
 * @since 2023-10-06
 */
public class Tesis extends MaterialBibliografico {

    private String nombreInst;  // Nombre de la institución que otorga el título de la tesis

    /**
     * Constructor de la clase Tesis.
     * @param nombre Nombre de la tesis.
     * @param editorial Editorial o compañía.
     * @param año_publicacion Año de publicación.
     * @param genero Género de la tesis.
     * @param autorN Nombre del autor.
     * @param autorA Apellido del autor.
     * @param tipo Tipo de material (Tesis).
     * @param nombreInst Nombre de la institución que otorga el título.
     */
    public Tesis(String nombre, String editorial, Integer año_publicacion, String genero, String autorN, String autorA, String tipo, String nombreInst) {
        super(nombre, editorial, año_publicacion, genero, autorN, autorA, tipo);
        this.nombreInst = nombreInst;
    }

    /**
     * Obtiene el nombre de la institución que otorga el título de la tesis.
     * @return Nombre de la institución.
     */
    public String getNombreInst() {
        return nombreInst;
    }

    /**
     * Genera una referencia bibliográfica en formato APA para la tesis.
     * @return Referencia en formato APA.
     */
    @Override
    public String generarReferencia() {
        // Formato APA para tesis: Autor, A. (Año). Título de la tesis [Tipo de tesis para optar un grado o título inédita]. Nombre de la institución que otorga el título.
        return nombreReferencia(autorN, autorA) + "(" + getAño() + ")." + getNombre() + "[" + getTipo() + "]" + getNombreInst() + ".";
    }
}
