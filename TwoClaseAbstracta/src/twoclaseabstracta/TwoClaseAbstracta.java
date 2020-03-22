package twoclaseabstracta;

/**
 *
 * @author Ordenador
 */
public class TwoClaseAbstracta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cuadrado cu = new Cuadrado(5, 7, 9);
        cu.imprimir();
        
        Circulo ci= new Circulo(4, 6, 2.3);
        ci.imprimir();
    }
    
}
