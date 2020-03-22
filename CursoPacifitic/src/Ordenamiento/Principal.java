package Ordenamiento;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		
            List<Personas> listPersonas = new ArrayList<Personas>();
            List<Personas> listPersOrden = new ArrayList<Personas>();			

            Personas per1= new Personas("Juan Carlos", 20);
            Personas per2= new Personas("Maria Ruiz", 90);
            Personas per3= new Personas("Manuel Salazar", 12);
            Personas per4= new Personas("Manuel Salazar", 25);
            Personas per5= new Personas("Pablo Rodriguez", 80);
            Personas per6= new Personas("Camila Fuentes", 35);

            listPersonas.add(per1);
            listPersonas.add(per2);
            listPersonas.add(per3);
            listPersonas.add(per4);
            listPersonas.add(per5);
            listPersonas.add(per6);

            System.out.println("Lista ingresada.");
            for(Personas personas : listPersonas) {
                    System.out.println(personas.toString());
            }

            listPersOrden = Sort.SortPersonas(listPersonas);

            System.out.println("\nLista ordenada.");
            for(Personas personas : listPersOrden) {
                    System.out.println(personas.toString());
            }

            Collections.sort(listPersonas);
            System.out.println("\nLista ordenada por Collections.sort");
            for(Personas personas : listPersonas) {
                    System.out.println(personas.toString());
            }

            /*Lista con personas y perros*/            

            Perro pe1 = new Perro("Tobby", 50);
            Perro pe2 = new Perro("Firulays", 75);
            Perro pe3 = new Perro("Capitan", 999);

            ArrayList<IEdad> listPerrosPersonas = new ArrayList<IEdad>();
            listPerrosPersonas.add(per1);
            listPerrosPersonas.add(per2);
            listPerrosPersonas.add(per3);
            listPerrosPersonas.add(per4);
            listPerrosPersonas.add(per5);
            listPerrosPersonas.add(per6);
            listPerrosPersonas.add(pe1);
            listPerrosPersonas.add(pe2);
            listPerrosPersonas.add(pe3);           

            System.out.println("\n*** Lista de perros y personas ordenadas ***");
            Collections.sort(listPerrosPersonas);
            for (IEdad oEdad : listPerrosPersonas) {
//                    System.out.println("Edad: "+oEdad.getEdad()+", Nombre: "+oEdad.toString());
                    System.out.println(oEdad.toString()+" -> Objeto"+oEdad.getClass().getName());
            }           
	}

}
