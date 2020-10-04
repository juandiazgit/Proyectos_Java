package clases_propias;

import java.util.GregorianCalendar;

public class MetodosGenericos {

	public static void main(String[] args) {
		
		String nombres[] = {"Maria","Pepe","Jose"};
		
		//String elementos = MisMatrices.getElementos(nombres);
		//String elementos = MisMatrices.<String>getElementos(nombres);
		String elementos = MisMatrices.getMenor(nombres);
		System.out.println(elementos);
		
		/*Empleado listaEmpleados[] = {new Empleado("Ana", 45, 2500),
				                     new Empleado("Ana", 45, 2500),
				                     new Empleado("Ana", 45, 2500),
				                     new Empleado("Ana", 45, 2500),
				                     new Empleado("Ana", 45, 2500),};
		
		System.out.println(MisMatrices.getElementos(listaEmpleados));*/
		
		/*Empleado paco = new Empleado("Paco", 45, 2500);
		Empleado ana = new Empleado("Ana", 45, 2500);
		Empleado maria = new Empleado("Maria", 45, 2500);
		
		Empleado misEmpleados[] = {paco,ana,maria};
		
		System.out.println(MisMatrices.getMenor(misEmpleados));*/
		
		GregorianCalendar fechas[] = {new GregorianCalendar(2015, 07, 12),
									  new GregorianCalendar(2015, 05, 12),
									  new GregorianCalendar(2015, 04, 12)};
		
		System.out.println(MisMatrices.getMenor(fechas).getTime().toString());
		
	}

}

class MisMatrices{
	
	 public static <T> String getElementos(T[] a) {
		 
		 return "El array tiene "+a.length+" elementos.";
		 
	 }
	 
	 public static <T extends Comparable<T>> T getMenor(T[] a) {
		 
		 if (a == null || a.length == 0) {
			 return null;
		 }
		 
		 T elementoMenor = a[0];
		 
		 for (int i = 1; i < a.length; i++) {
			 
			 if (elementoMenor.compareTo(a[i]) > 0) {
				 elementoMenor = a[i];
			 }
			 
		}
		 
		 return elementoMenor;
		 
	 }
	
}