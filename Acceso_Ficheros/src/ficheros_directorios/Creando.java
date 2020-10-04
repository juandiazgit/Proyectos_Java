package ficheros_directorios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Creando {

	public static void main(String[] args) {

		File ruta = new File("src"+File.separator+"Java_ser"+File.separator+"prueba_texto.txt");
//		ruta.mkdir();
		
		String archivo_destino = ruta.getAbsolutePath();
		
		try {
			ruta.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Escribiendo accede_es = new Escribiendo();
		accede_es.escribir(archivo_destino);
	}

}

class Escribiendo{
	
	public void escribir(String ruta_archivo) {
		
		String frase = "Esto es un ejemplo de escritura.";
		
		try {
			
			FileWriter escritura = new FileWriter(ruta_archivo);
			
			for (int i = 0; i < frase.length(); i++) {
				escritura.write(frase.charAt(i));
			}
			
			escritura.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
