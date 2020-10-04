package arraylist;

import java.io.File;

public class UsoArrayList {

	public static void main(String[] args) {

		ArrayList2 archivos = new ArrayList2(5);
		
		archivos.add("Juan");
		archivos.add("María");
		archivos.add("Ana");
		archivos.add("Sandra");
		archivos.add(new File("archivoDeTexto.txt"));
		
		String nombrePersona = (String)archivos.get(2);
		
		System.out.println(nombrePersona);
		
		/*archivos.add(new File("archivoDeTexto.txt"));
		
		File archivo = (File)archivos.get(0);
		
		System.out.println(archivo);*/

	}

}
