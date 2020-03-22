/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oneinterfaces;

/**
 *
 * @author Ordenador
 */
public class Bicicleta implements Rueda,Silla{

    @Override
    public void avanzar() {
        System.out.println("La bicicleta avanza");
    }

    @Override
    public void detenerse() {
        System.out.println("La bicicleta se detiene");
    }

    @Override
    public void imprimirValor() {
        System.out.println("Valor constante en Bicicleta: "+VALOR);
    }

    @Override
    public void sentarse() {
        System.out.println("Sentarse en la Bicicleta");
    }
}
