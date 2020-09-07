package excepciones_I;

import java.io.EOFException;

import javax.swing.JOptionPane;

public class Comprueba_mail {

	public static void main(String[] args) {

		String email = JOptionPane.showInputDialog("Introduce mail: ");
		
		try {
			
			examina_email(email);
			
		} catch (Exception e) {
			System.out.println("La dirección de email no es correcta");
//			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
	
	static void examina_email(String mail) throws longitud_mail_erronea { 
		int arroba = 0;
		boolean punto = false;
		
		if (mail.length() <= 3) {
			
//			ArrayIndexOutOfBoundsException mi_excepcion = new ArrayIndexOutOfBoundsException();
//			throw new ArrayIndexOutOfBoundsException();
			throw new longitud_mail_erronea("El mail no puede tener menos de 3 caracteres.");
			
		}
		
		for (int i = 0; i < mail.length(); i++) {
			
			if (mail.charAt(i) == '@') {
				arroba++;
			}
			
			if (mail.charAt(i) == '.') {
				punto = true;
			}
		}
		
		if (arroba == 1 && punto == true) {
			System.out.println("Es correcto.");
		} else {
			System.out.println("No es correcto.");
		}
		
	}

}

class longitud_mail_erronea extends Exception {
	
	public longitud_mail_erronea() {}
	
	public longitud_mail_erronea(String msj_error) {
		super(msj_error);
	}
	
}


