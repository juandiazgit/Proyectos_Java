package leyendo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Acceso_Fichero {

	public static void main(String[] args) {

		Leer_Ficher accediendo = new Leer_Ficher();
		accediendo.lee();

	}

}

class Leer_Ficher {

	private FileReader entrada;

	public void lee() {

		try {

//			entrada = new FileReader("C:/Users/USUARIO/Documents/ejemplo.txt");
			entrada = new FileReader("src/ejemplo.txt");

			BufferedReader miBuffer = new BufferedReader(entrada);
			
			String linea = "";
			
//			int c = entrada.read();

			while (linea != null) {

//				c = entrada.read();
//				char letra = (char) c;
				// Imprime unicodes del texto almacenado en el archivo
				linea = miBuffer.readLine();
				if (linea != null)
					System.out.println(linea);
			}
			entrada.close();

		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo.");
//			e.printStackTrace();
		}

	}

}