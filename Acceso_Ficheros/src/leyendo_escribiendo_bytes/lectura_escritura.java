package leyendo_escribiendo_bytes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class lectura_escritura {

	public static void main(String[] args) {
		
		int contador = 0;
		int datos_entrada[] = new int[335158];

		try {
			
			FileInputStream archivo_lectura = new FileInputStream("src/PictureCity.jpg");
			
			boolean final_ar = false;
			
			while (!final_ar) {
				
				int byte_entrada = archivo_lectura.read();
					
				if (byte_entrada != -1) {
					
					datos_entrada[contador] = byte_entrada;
					
				}else{
					
					final_ar = true;
					
				}
				
				System.out.println(datos_entrada[contador]);
				contador++;
			}
			
			archivo_lectura.close();
		
		} catch (IOException e) {
			System.out.println("Error al acceder a la imagen");
		}
		
		System.out.println("Cantidad de Bytes: "+contador);
		
		crea_fichero(datos_entrada);

	}
	
	static void crea_fichero(int datos_nuevo_fichero[]) {
		
		try {
			
			FileOutputStream fichero_nuevo = new FileOutputStream("src/PictureCity_copia.jpg");
			
			for (int i = 0; i < datos_nuevo_fichero.length; i++) {
				fichero_nuevo.write(datos_nuevo_fichero[i]);
			}
		
			fichero_nuevo.close();
			
		}catch(IOException e) {
			System.out.println("Error al crear el archivo");
		}
		
	}

}
