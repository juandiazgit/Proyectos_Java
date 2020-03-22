package oneinterfaces;

/**
 *
 * @author Ordenador
 */
public class OneInterfaces {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Carro c = new Carro();
        Bicicleta b = new Bicicleta();
        c.avanzar();
        b.avanzar();
        c.imprimirValor();
        b.imprimirValor();
        b.sentarse();
    }
}
