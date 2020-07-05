package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_Persona {

	public static void main(String[] args) {
		
		Persona[] lasPersonas =new Persona[2];
		
		lasPersonas[0] = new Empleado2("Luis Conde", 50000, 2009, 02, 25);
		lasPersonas[1] = new Alumno("Ana López", "Biológicas");
		
		for (Persona p: lasPersonas) {
			System.out.println(p.dameNombre()+", "+p.dameDescripcion());
		}
	}

}

abstract class Persona{
	
	private String nombre;
	
	public Persona(String nom) {
		this.nombre = nom;
	}
	
	public String dameNombre() {
		return this.nombre;
	}
	
	public abstract String dameDescripcion();
}

class Empleado2 extends Persona{
	
	private double sueldo;
	private Date altaContrato;
	private int Id;
	private static int IdSiguiente = 0; //Definición de variable de clase con "static"
	
	public Empleado2(String nom, double sue, int anio, int mes, int dia) {
		super(nom); // Se invoca el contructor de la clase padre
		this.sueldo = sue;
		GregorianCalendar calendario = new GregorianCalendar(anio, mes-1, dia);
		this.altaContrato = calendario.getTime();
		++IdSiguiente;
		this.Id = IdSiguiente;
	}
	
	public String dameDescripcion() {
		return "Este empleado tiene Id = "+this.Id+", Sueldo = "+this.sueldo;
	}
	
	public double dameSueldo() {
		return this.sueldo;
	}
	
	public Date dameFechaContrato() {
		return this.altaContrato;
	}
	
	public void subeSueldo(double porcentaje) {
		double aumento = this.sueldo*porcentaje/100;
		this.sueldo+=aumento;
	}
	
	public int dameId() {
		return this.Id;
	}
}

class Alumno extends Persona{
	
	private String carrera;
	
	public Alumno(String nom, String car) {
		super(nom);
		this.carrera = car;
	}
	
	public String dameDescripcion() {
		return "Este alumno está estudiando "+this.carrera;
	}
}
