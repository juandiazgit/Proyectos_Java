package Ordenamiento;

public class Personas implements IEdad{

	String nombre;
	int edad;
		
	public Personas(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
        @Override
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	public String toString() {		
		return "Edad: "+this.edad+", Nombre: "+this.nombre;
	}
	
	@Override
	public int compareTo(IEdad pers) {
		return getEdad()-pers.getEdad();
	}

}
