package serializacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Serializando {

	public static void main(String[] args) {

		Administrador jefe = new Administrador("Juan", 80000, 2005, 12, 15);
		jefe.setIncentivo(5000);
		
		Empleado[] personal = new Empleado[3];
		personal[0] = jefe;
		personal[1] = new Empleado("Ana", 25000, 2008, 10, 1);
		personal[2] = new Empleado("Luis", 18000, 2012, 9, 15);
		
		try {
			
			//Serializando Objetos
			ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream("src/Java_ser/empleado.dat"));
			escribiendo_fichero.writeObject(personal);
			escribiendo_fichero.close();
			
			//Deserializando Objetos
			ObjectInputStream recuperando_fichero = new ObjectInputStream(new FileInputStream("src/Java_ser/empleado.dat"));
			Empleado[] personal_recuperado = (Empleado[])recuperando_fichero.readObject();
			recuperando_fichero.close();
			
			for (Empleado e : personal_recuperado) {
				System.out.println(e);
			}
			
		} catch (Exception e) {
			System.out.println("Error!");
		}

	}

}

class Empleado implements Serializable{

	private static final long serialVersionUID = -420480708731030847L;
	private String nombre;
	private double sueldos;
	private Date fechaContrato;
	
	public Empleado(String nom, double sue, int anio, int mes, int dia) {
		this.nombre = nom;
		this.sueldos = sue;
		GregorianCalendar calendario = new GregorianCalendar(anio, mes-1, dia);
		this.fechaContrato = calendario.getTime();
	}
	
	public Empleado(String nom) {
		this(nom,30000,2000,01,01); //Este Constructor invoca al otro Constructor de la clase
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public double getSueldo() {
		return this.sueldos;
	}
	
	public Date getFechaContrato() {
		return this.fechaContrato;
	}
	
	public void subeSueldo(double porcentaje) {
		double aumento = this.sueldos*porcentaje/100;
		this.sueldos+=aumento;
	}

	public String toString() {
		
		return "Nombre = "+this.nombre+", sueldo = "+this.sueldos+", fecha de contrato = "+this.fechaContrato;
		
	}
	
}

class Administrador extends Empleado{
	
	private static final long serialVersionUID = 1881056236380136510L;
	private double incentivo;
	
	public Administrador(String nom, double sue, int anio, int mes, int dia) {
		super(nom,sue,anio,mes,dia);
		this.incentivo = 0;
	}
	
	public void setIncentivo(double b) {
		this.incentivo = b;
	}
	
	public double getSueldo() {
		double sueldoBase = super.getSueldo(); //Se invoca el método de la superclase "Empleado".
		return sueldoBase + this.incentivo;
	}

	public String toString() {
		
		return super.toString()+", Incentivo = "+this.incentivo;
		
	}
	
}
