package com.arquitecturajava;

public class Compra {
    
    private double importe;
    private String tipo;

    public Compra(double importe, String tipo) {
        super();
        this.importe = importe;
        this.tipo = tipo;
    }
    
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getImporte() {
        return importe;
    }  

    public void setImporte(double importe) {
        this.importe = importe;
    }
    
    public double descuento() {
        double descuento;
        if (tipo.equals("tienda")) {
            if (importe > 0 && importe < 100){
                descuento = 10;
             }else{
                descuento = 20;
             }
        } else {
            if (importe > 0 && importe < 100) {
                descuento = 20;
             } else {
                descuento = 30;
            }
        }
        return importe-(importe *descuento/100);
    }
}