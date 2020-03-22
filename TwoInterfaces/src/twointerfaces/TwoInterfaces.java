package twointerfaces;

/**
 *
 * @author Ordenador
 */
import java.util.List; import java.util.ArrayList; //Test ejemplo aprenderaprogramar.com

public class TwoInterfaces {

    public static void main (String [ ] Args) {

        Figura cuad1 = new Cuadrado (3.5f);         
        Figura cuad2 = new Cuadrado (2.2f); 
        Figura cuad3 = new Cuadrado (8.9f);
        
        Figura circ1 = new Circulo (3.5f); 
        Figura circ2 = new Circulo (4f);

        Figura rect1 = new Rectangulo (2.25f, 2.55f); 
        Figura rect2 = new Rectangulo (12f, 3f);

        List<Figura> serieDeFiguras = new ArrayList <Figura>();

        serieDeFiguras.add(cuad1); 
        serieDeFiguras.add(cuad2); 
        serieDeFiguras.add(cuad3);

        serieDeFiguras.add(circ1); 
        serieDeFiguras.add(circ2);
        
        serieDeFiguras.add(rect1); 
        serieDeFiguras.add(rect2);

        float areaTotal = 0;

        for (Figura tmp: serieDeFiguras) {      
            areaTotal = areaTotal + tmp.area();     
        }

        System.out.println ("Tenemos un total de " + serieDeFiguras.size() + " "
                + "figuras y su área total es de "  + areaTotal + " uds cuadradas");  
    } 
}