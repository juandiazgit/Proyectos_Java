package twoclaseabstracta;

/**
 *
 * @author Ordenador
 */
public class Circulo extends Figura{
    double radio;

    public Circulo(double radio, double x, double y) {
        super(x, y);
        this.radio = radio;
    }            

    @Override
    public double area() {
        return Math.PI*radio*radio;
    }
    
    @Override
    public void imprimir() {
        System.out.println("El área del circulo es: "+Circulo.this.area());
    }
}
