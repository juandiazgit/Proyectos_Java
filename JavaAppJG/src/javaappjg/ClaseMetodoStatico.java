package javaappjg;

/**
 *
 * @author Ordenador
 */
public class ClaseMetodoStatico {
    
    private String nombre;
    private int edad;
    private static String genero;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void mostrarDeInstancia(){
        System.out.println(this.nombre+","+this.edad);
    }
    
    public static void mostrarDeClase(){
        System.out.println("Metodo Statico");
    }    

    public static String getGenero() {
        return genero;
    }

    public static void setGenero(String genero) {
        ClaseMetodoStatico.genero = genero;
    }   
}
