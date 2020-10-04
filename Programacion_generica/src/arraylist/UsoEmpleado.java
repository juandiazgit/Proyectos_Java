package arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class UsoEmpleado {

	public static void main(String[] args) {

		/*Empleado listaEmpleados[] = new Empleado[3];
		listaEmpleados[0] = new Empleado("Ana", 45, 2500);
		listaEmpleados[1] = new Empleado("Antonio", 55, 2000);
		listaEmpleados[2] = new Empleado("Maria", 25, 2600);*/
		
		ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
		
//		listaEmpleados.ensureCapacity(11);
		
		listaEmpleados.add(new Empleado("Ana", 45, 2500));
		listaEmpleados.add(new Empleado("Antonio", 55, 2000));
		listaEmpleados.add(new Empleado("Maria", 25, 2600));
		listaEmpleados.add(new Empleado("Jose", 35, 2200));
		listaEmpleados.add(new Empleado("Jose", 35, 2200));
		
		listaEmpleados.add(new Empleado("Ana", 45, 2500));
		listaEmpleados.add(new Empleado("Antonio", 55, 2000));
		listaEmpleados.add(new Empleado("Maria", 25, 2600));
		listaEmpleados.add(new Empleado("Jose", 35, 2200));
		listaEmpleados.add(new Empleado("Jose", 35, 2200));
		
		listaEmpleados.add(new Empleado("Pedro", 22, 2200));
		listaEmpleados.add(new Empleado("Pedro", 22, 2200));
		
		listaEmpleados.add(new Empleado("Pedro", 22, 2200));
		listaEmpleados.add(new Empleado("Pedro", 22, 2200));
		
//		listaEmpleados.trimToSize();
		
//		listaEmpleados.add(new Empleado("Olga", 22, 2200));
//		listaEmpleados.set(1,new Empleado("Olga", 22, 2200));
		
//		System.out.println(listaEmpleados.get(4).dameDatos());
		
//		System.out.println(listaEmpleados.size());
		
		/*for (Empleado e : listaEmpleados) {
			System.out.println(e.dameDatos());
		}*/
		
		Iterator<Empleado> mi_interador = listaEmpleados.iterator();
		
		while (mi_interador.hasNext()) {
			System.out.println(mi_interador.next().dameDatos());
		}
		
		
		/*for (int i = 0; i < listaEmpleados.size(); i++) {
			Empleado e = listaEmpleados.get(i);
			System.out.println(e.dameDatos());
		}*/
		
		/*Empleado arrayEmpleado[] = new Empleado[listaEmpleados.size()];
		listaEmpleados.toArray(arrayEmpleado);
		
		for (int i = 0; i < arrayEmpleado.length; i++) {
			System.out.println(arrayEmpleado[i].dameDatos());
		}*/
		
	}

}

class Empleado{
	
	private String nombre;
	private int edad;
	private double salario;
	
	public Empleado(String nombre, int edad, double salario) {
		this.nombre = nombre;
		this.edad = edad;
		this.salario = salario;
	}
	
	public String dameDatos() {
		return "El empleado se llama "+this.nombre+". Tiene "+this.edad+" años, y un salario de "+this.salario;
	}
	
}