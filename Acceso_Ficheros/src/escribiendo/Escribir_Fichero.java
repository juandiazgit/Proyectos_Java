package escribiendo;

import java.io.FileWriter;
import java.io.IOException;

public class Escribir_Fichero {

	public static void main(String[] args) {

		escribiend accede_es = new escribiend() ;
		accede_es.escribe();

	}

}

class escribiend{
	
	public void escribe() {
		
		String frase = "Esto es una prueba de escritura.";
		
		try {
			
//			FileWriter escribiendo = new FileWriter("src/new_file.txt",true); //Escribe sobre un archivo existente
			FileWriter escribiendo = new FileWriter("src/new_file.txt");
			
			for (int i = 0; i < frase.length(); i++) {
				
				escribiendo.write(frase.charAt(i));
				
			}
			
			escribiendo.close();
			
		}catch (IOException e){
			
			e.printStackTrace();
			
		}
		
	}
	
}