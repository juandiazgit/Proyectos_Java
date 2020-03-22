package twointerfaces;

/**
 *
 * @author Ordenador
 */
public class Circulo implements Figura{ // La clase implementa la interface Figura

    private float diametro;

    public Circulo (float diametro) { 
        this.diametro = diametro; 
    }

    @Override
    public float area() { 
        return (PI*diametro*diametro/4f); 
    }
    
}