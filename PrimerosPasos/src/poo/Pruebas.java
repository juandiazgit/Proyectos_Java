package poo;

public class Pruebas {

	public static void main(String[] args) {

		Empleados trabajador1 = new Empleados("Paco");
		Empleados trabajador2 = new Empleados("Ana");
		Empleados trabajador3 = new Empleados("Antonio");
		Empleados trabajador4 = new Empleados("Maria");

		trabajador1.cambiaSeccion("RRHH");

		System.out.println(trabajador1.devuelveDatos() + "\n" + trabajador2.devuelveDatos() + "\n"
				+ trabajador3.devuelveDatos() + "\n" + trabajador4.devuelveDatos());

		System.out.println(Empleados.dameIdSiguiente());

	}

}

class Empleados {

	private final String nombre; // Definición de Constante con "final"
	private String seccion;
	private int Id;
	private static int IdSiguiente = 1; // Definición de variable de clase con "static"

	public Empleados(String nom) {
		this.nombre = nom;
		this.seccion = "Administración";
		this.Id = this.IdSiguiente;
		this.IdSiguiente++;
	}

	public void cambiaSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String devuelveDatos() {
		return "Nombre: " + this.nombre + ", Sección: " + this.seccion + ", Id = " + this.Id;
	}

	public static String dameIdSiguiente() {
		return "Siguiente Id: " + IdSiguiente;
	}

}