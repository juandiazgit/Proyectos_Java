package twointerfaces;

/**
 *
 * @author Ordenador
 */
public class Rectangulo implements Figura{ // La clase implementa la interface Figura

    private float lado; 
    private float altura;

    public Rectangulo (float lado, float altura) { 
        this.lado = lado; 
        this.altura = altura; 
    }

    @Override
    public float area() { 
        return lado*altura; 
    }

}