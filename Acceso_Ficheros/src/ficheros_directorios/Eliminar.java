package ficheros_directorios;

import java.io.File;

public class Eliminar {

	public static void main(String[] args) {
		
		File ruta = new File("src"+File.separator+"Java_ser"+File.separator+"prueba_texto.txt");
		ruta.delete();

	}

}
