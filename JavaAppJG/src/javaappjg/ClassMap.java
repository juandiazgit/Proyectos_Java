/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaappjg;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Ordenador
 */
public class ClassMap {
    
    public static void main(String args[]){
        // Declaración de un Map (un HashMap) con clave "Integer" y Valor "String".Las claves pueden ser de cualquier tipo de objetos, aunque los más utilizados como clave son los objetos predefinidos de Java como String, Integer, Double ... !!!!CUIDADO los Map no permiten datos atómicos
        Map<Integer, String> NewMap = new HashMap<>();
        NewMap.put(1, "Juan");
        NewMap.put(2, "Manuel");
        NewMap.put(3, "Jorge");
        NewMap.put(4, "Mario");
        System.out.println(NewMap);
        NewMap.size(); // Devuelve el numero de elementos del Map                             
        
        
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "Casillas");		map.put(15, "Ramos");
        map.put(3, "Pique");		map.put(5, "Puyol");
        map.put(11, "Capdevila");	map.put(14, "Xabi Alonso");
        map.put(16, "Busquets");	map.put(8, "Xavi Hernandez");
        map.put(18, "Pedrito");		map.put(6, "Iniesta");
        map.put(7, "Villa");

        // Imprimimos el Map con un Iterador
        Iterator it = map.keySet().iterator();
        while(it.hasNext()){
          Integer key = (Integer) it.next();
          System.out.println("Clave: " + key + " -> Valor: " + map.get(key));
        }
    }
    
}

