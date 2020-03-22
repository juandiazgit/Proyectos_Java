package referencesobjects;

/**
 *
 * @author Ordenador
 */
public class ReferencesObjects {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Persona per1 = new Persona();
        Persona per2 = new Persona();
        
//      Para que apunte a una misma dirección de memoria.
        per2=per1;
        
        per1.setNombre("Juan Diaz");
        System.out.println("per1.getNombre: "+per1.getNombre());
        System.out.println("per2.getNombre: "+per2.getNombre());
        per2.setNombre("Maria Ruiz");
        System.out.println("per1.getNombre: "+per1.getNombre());
        
//      Se asigna para que apunte a null.
        per1 = null;
        
//      Se invoca garbage collector.
        System.gc();
    }
    
}