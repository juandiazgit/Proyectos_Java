package javaappjg;

import java.util.ArrayList;
import java.util.List;

public class mainClassJG {

    public static void main(String args[]){
        
        //Métodos y atributos estáticos.
        
        ClaseMetodoStatico per = new ClaseMetodoStatico();
        per.setNombre("Juan");
        per.setEdad(24);
        
        per.mostrarDeInstancia();
        
        ClaseMetodoStatico.mostrarDeClase();
        
        ClaseMetodoStatico.setGenero("Masculino");
                
        System.out.println("Genero: "+ClaseMetodoStatico.getGenero());
        
    }
    
}
