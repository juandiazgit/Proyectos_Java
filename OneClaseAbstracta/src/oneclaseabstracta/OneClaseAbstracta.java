package oneclaseabstracta;

/**
 *
 * @author Ordenador
 */
public class OneClaseAbstracta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Planta p = new Planta();
        AnimalCarnivoro ac = new AnimalCarnivoro();
        
        p.alimentarse();
        ac.alimentarse();
    }
    
}
