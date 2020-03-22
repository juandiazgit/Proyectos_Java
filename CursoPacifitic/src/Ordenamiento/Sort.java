package Ordenamiento;

import java.util.ArrayList;
import java.util.List;

public class Sort {	
	
    private static Personas auxPersona;
	
    public static List<Personas> SortPersonas(List<Personas> listPersonas){			
		
        for (int i=0; i < listPersonas.size()-1; i++) {			
            for(int j=0; j<listPersonas.size()-i-1; j++) {
                if(listPersonas.get(j+1).getEdad() < listPersonas.get(j).getEdad()) {
                    auxPersona = listPersonas.get(j+1);
                    listPersonas.set(j+1,listPersonas.get(j));
                    listPersonas.set(j, auxPersona);
                }
            }			
        }
		
        return listPersonas;
    }	
}