package twoclaseabstracta;

/**
 *
 * @author Ordenador
 */
public class Cuadrado extends Figura{
    double lado;

    public Cuadrado(double lado, double x, double y) {
        super(x, y);
        this.lado = lado;
    }
    
    @Override
    public double area() {
        return lado*lado;        
    }    

    @Override
    public void imprimir() {
        System.out.println("El área del cuadrado es: "+Cuadrado.this.area());
    }
}
