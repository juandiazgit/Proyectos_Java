package clases_propias;

public class pareja<T> {
	
	private T primero;
	
	public pareja() {
		
		primero = null;
		
	}
	
	public void setPrimero(T nuevoValor) {
		
		primero = nuevoValor;
		
	}
	
	public T getPrimero() {
		
		return primero;
		
	}
	
	public static void imprimirTrabajador(pareja< ? extends Empleado> p) {
		
		Empleado primero = p.getPrimero();
		
		System.out.println(primero.dameDatos());
		
	}

}
