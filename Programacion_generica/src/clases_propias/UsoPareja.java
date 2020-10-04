package clases_propias;

public class UsoPareja {

	public static void main(String[] args) {

		pareja<String> una = new pareja<String>();
		una.setPrimero("Juan");
		System.out.println(una.getPrimero());
		
		
		Persona per1 = new Persona("Ana");
		pareja<Persona> otra = new pareja<Persona>();
		otra.setPrimero(per1);
		System.out.println(otra.getPrimero());

	}

}

class Persona{
	
	private String nombre;
	
	public Persona(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return this.nombre;
	}
	
}