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
public class Carro implements Rueda{

    public Carro() {
    }        
    
    @Override
    public void avanzar() {        
        System.out.println("El carro avanza");
    }
    
    @Override
    public void detenerse() {
        System.out.println("El se detiene");
    }

    @Override
    public void imprimirValor() {
        System.out.println("Valor constante en Carro: "+VALOR);
    }
}
