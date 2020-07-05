import java.util.*;

public class Entrada_ejemplo1 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Introduce tu nombre por favor: ");
		String nombre_usuario = entrada.nextLine();
		
		System.out.print("Introduce edad: ");
		int edad_usuario = entrada.nextInt();
		
		System.out.println("EL nombre es: "+nombre_usuario);
		System.out.println("La edad es: "+edad_usuario);
	}

}
