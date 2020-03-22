package com.arquitecturajava;

/**
 *
 * @author Ordenador
 */
public class Principal {
    public static void main(String[] args) {
        Compra c= new Compra(1000,"tienda");
        System.out.println("Descuento: "+c.descuento());
    }
}
