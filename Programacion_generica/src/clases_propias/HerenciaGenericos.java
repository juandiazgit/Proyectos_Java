package clases_propias;

public class HerenciaGenericos {

	public static void main(String[] args) {

		/*Empleado Administrativa = new Empleado("Elena", 45, 1500);
		
		Jefe DirectoraComercial = new Jefe("Ana", 27, 3500);
		
		Empleado nuevoEmpleado = DirectoraComercial;*/
		
		pareja<Empleado> Administrativa = new pareja<Empleado>();
		Administrativa.setPrimero(new Empleado("Naty", 30, 2500));
		
		pareja<Jefe> DirectoraComercial = new pareja<Jefe>();
		DirectoraComercial.setPrimero(new Jefe("Juan", 40, 45000));
		
		//pareja<Empleado> nuevoEmpleado = DirectoraComercial;
		
		pareja.imprimirTrabajador(Administrativa);
		pareja.imprimirTrabajador(DirectoraComercial);

	}

}
