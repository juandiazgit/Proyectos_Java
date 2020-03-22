package Source;

//import java.util.LinkedList;
//import java.util.Scanner;

/**
 *
 * @author Ordenador
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Scanner scn = new Scanner(System.in);
        
//        LinkedList<String> lnkList = new LinkedList<>();
//        lnkList.add("Cadena");
//        String laCadena = lnkList.getFirst();
//        System.out.println("La cadena: "+laCadena);

        Elemento<Double> elemD = new Elemento<>();
        elemD.setDato(5.0);
        System.out.println("ValorD : "+elemD.getDato());                
        
        Elemento<String> elemS = new Elemento<>();
        elemS.setDato("Palabra");
        System.out.println("ValorS : "+elemS.getDato());
        
        Elemento<Boolean> elemB = new Elemento<>();
        elemB.setDato(true);
        System.out.println("ValorB : "+elemB.getDato());
    }
    
}
