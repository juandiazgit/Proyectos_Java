package com.arquitecturajava.estrategia;

/**
 *
 * @author Ordenador
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Compra c = new Compra(1000);
        System.out.println("DescuentoTienda: "+c.descuento(new DescuentoTienda()));
        System.out.println("DescuentoDirectivo: "+c.descuento(new DescuentoDirectivo()));
    }
    
}
