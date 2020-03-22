package com.arquitecturajava.estrategia;

import com.arquitecturajava.estrategia.Compra;

/**
 *
 * @author Ordenador
 */
public interface TipoDescuento {
    
    public double importeDescontar(Compra c);    
    
}
