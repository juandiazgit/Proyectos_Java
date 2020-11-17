import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PruebaMapas {

	public static void main(String[] args) {
		
		HashMap<String, Empleado> personal = new HashMap<String, Empleado>();
		
		personal.put("145", new Empleado("Juan"));
		personal.put("146", new Empleado("Ana"));
		personal.put("147", new Empleado("Antonio"));
		personal.put("148", new Empleado("Sandra"));

		System.out.println(personal);
		
		personal.remove("147");
		
		System.out.println(personal);
		
		personal.put("148", new Empleado("Natalia"));
		
		System.out.println(personal);
		
		System.out.println(personal.entrySet());
		
		//Devuelve un set de Entry<String, Empleado>
		//Listar la clave y el valor
		
		for (Map.Entry<String, Empleado> entrada: personal.entrySet()) {
			
			String clave = entrada.getKey();
			Empleado valor = entrada.getValue();
			
			System.out.println("Clave="+clave+", valor="+valor);
			
			//Actualizar el valor de la clave 145
			if (clave.equals("145")) {
				entrada.setValue(new Empleado("Carlos"));
			}
		}
		
		System.out.println(personal.entrySet());
		
		//Lista las claves
		for (String clave: personal.keySet()) {
			System.out.println("Clave: "+clave);
		}
		
		System.out.println(personal.keySet());
		
		//Actualizar valor con clave 148
		personal.replace("148", new Empleado("Natalia_ABC"));
		
		System.out.println(personal.entrySet());
		System.out.println(personal.size());
		
		//Recorrer los elementos con Iteradores
		Iterator<String> it = personal.keySet().iterator();
		
		while (it.hasNext()) {
			String clave = it.next();
			System.out.println("Clave="+clave+", Valor="+personal.get(clave));
		}
		
	}

}


class Empleado{
	
	private String nombre;
	private double sueldo;
	
	public Empleado(String n) {
		
		this.nombre = n;
		this.sueldo = 2000;
		
	}

	@Override
	public String toString() {
		
		return "[Nombre="+this.nombre+", sueldo="+this.sueldo+"]";
		
	}
	
}