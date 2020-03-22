package com.arquitecturajava.estrategia;

import com.arquitecturajava.Compra;

/**
 *
 * @author Ordenador
 */
public class DescuentoTienda implements TipoDescuento {
    
    @Override
    public double importeDescontar(com.arquitecturajava.estrategia.Compra c) {
        double descuento;
        if (c.getImporte() > 0 && c.getImporte() < 100) {
            descuento = 10;
        } else {
            descuento = 20;
        }
        return c.getImporte() * descuento / 100;
    }
}