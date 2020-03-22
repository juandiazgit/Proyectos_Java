package twointerfaces;

/**
 *
 * @author Ordenador
 */
public class Cuadrado implements Figura { // La clase implementa la interface Figura

    private float lado;

    public Cuadrado (float lado) { 
        this.lado = lado; 
    }

    @Override
    public float area() { 
        return lado*lado; 
    }
}