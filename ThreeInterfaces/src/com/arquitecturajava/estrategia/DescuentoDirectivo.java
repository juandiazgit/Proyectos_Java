package com.arquitecturajava.estrategia;

/**
 *
 * @author Ordenador
 */
public class DescuentoDirectivo implements TipoDescuento {
    @Override
    public double importeDescontar(Compra c){
        return c.getImporte()*50/100;
    }
}