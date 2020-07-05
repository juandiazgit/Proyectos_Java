package poo;
import java.util.*;

public class Uso_Empleado {

	public static void main(String[] args) {
		
		Jefatura jefe_RRHH = new Jefatura("Juan",55000,2006,9,25);
		jefe_RRHH.estableceIncentivo(2570);

		Empleado[] misEmpleados = new Empleado[6];
		misEmpleados[0] = new Empleado("Paco Gómez", 85000, 1990, 12, 17);
		misEmpleados[1] = new Empleado("Ana López", 95000, 1995, 06, 02);
		misEmpleados[2] = new Empleado("Maria Martín", 105000, 2002, 03, 15);
		misEmpleados[3] = new Empleado("Antonio Fernández");
		misEmpleados[4] = jefe_RRHH; //Polimorfismo en acción. Principio de sustitución.
		misEmpleados[5] = new Jefatura("Maria", 95000, 1999, 5, 26);
		
		Jefatura jefa_finanzas = (Jefatura)misEmpleados[5];
		jefa_finanzas.estableceIncentivo(55000);
		
		System.out.println("El Jefe: "+jefa_finanzas.dameNombre() +""
						+ " tiene un bonus de: "+jefa_finanzas.establece_bonus(500));
		
		System.out.println(misEmpleados[3].dameNombre()+" tiene un bonus de: "
						  +misEmpleados[3].establece_bonus(200));
		
		System.out.println(jefa_finanzas.tomar_decisiones("Dar más dias vacaciones a los empleados."));
		
		for (Empleado e : misEmpleados) {
			e.subeSueldo(5);
		}
		
		Arrays.sort(misEmpleados);
		
		for (Empleado e : misEmpleados) {
			System.out.println("Nombre: "+e.dameNombre()
			   + ", Id: "+e.dameId() 
			   + ", Sueldo: "+e.dameSueldo()
			   + ", Fecha de Alta: "+e.dameFechaContrato());
		}
	}

}

class Empleado implements Comparable, Trabajadores{
	
	private String nombre;
	private double sueldo;
	private Date altaContrato;
	private int Id;
	private static int IdSiguiente = 0; //Definición de variable de clase con "static"
	
	public Empleado(String nom, double sue, int anio, int mes, int dia) {
		this.nombre = nom;
		this.sueldo = sue;
		GregorianCalendar calendario = new GregorianCalendar(anio, mes-1, dia);
		this.altaContrato = calendario.getTime();
		++IdSiguiente;
		this.Id = IdSiguiente;
	}
	
	public Empleado(String nom) {
		this(nom,30000,2000,01,01); //Este Constructor invoca al otro Constructor de la clase
	}
	
	public String dameNombre() {
		return this.nombre;
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
	
	public int compareTo(Object miObjecto) {
		
		Empleado otroEmpleado = (Empleado)miObjecto;
		
		if (this.Id < otroEmpleado.Id) {
			return -1;
		}
		
		if (this.Id > otroEmpleado.Id) {
			return 1;
		}
		
		return 0;
	}
	
	public double establece_bonus(double gratificacion) {
		
		return Trabajadores.bonus_base+gratificacion;
	}
}

class Jefatura extends Empleado implements Jefes{
	
	private double incentivo;
	
	public Jefatura(String nom, double sue, int anio, int mes, int dia) {
		super(nom,sue,anio,mes,dia);
	}
	
	public void estableceIncentivo(double b) {
		this.incentivo = b;
	}
	
	public double dameSueldo() {
		double sueldoJefe = super.dameSueldo(); //Se invoca el método de la superclase "Empleado".
		return sueldoJefe + this.incentivo;
	}
	
	public String tomar_decisiones(String decision) {
		return "El miembro de la dirección ha tomado la decisión de: "+decision;
	}
	
	public double establece_bonus(double gratificacion) {

		double prima = 2000;
		return Trabajadores.bonus_base+gratificacion+prima;

	}
}