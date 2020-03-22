package com.arquitecturajava.estrategia;

import com.arquitecturajava.Compra;

/**
 *
 * @author Ordenador
 */
public class DescuentoInternet implements TipoDescuento {

    @Override
    public double importeDescontar(com.arquitecturajava.estrategia.Compra c) {

        double descuento;
        if (c.getImporte() > 0 && c.getImporte() < 200) {
            descuento = 20;
        } else {
            descuento = 30;
        }    
        return c.getImporte() * descuento / 100;
    }   
}