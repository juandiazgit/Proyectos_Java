/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaappjg;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ordenador
 */
public class ClassArrayList {
    
    public static void main(String args[]){
                
        //ArrayList<>
        
        List<String> a = new ArrayList<>();
        a.add("Juan");
        a.add("Carlos");
        a.add("Andres");
        //a.remove(0);
        
        System.out.println(a);
        System.out.println("Tamaño: "+a.size());
    }
}
