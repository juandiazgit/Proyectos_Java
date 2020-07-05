package graficos;

import java.awt.GraphicsEnvironment;
import javax.swing.*;

public class PruebasFuentes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String fuente = JOptionPane.showInputDialog("Introduce fuente: ");
		
		boolean estalafuente = false;
		
		String [] nombreDeFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		for (String nombreDeLaFuente : nombreDeFuentes) {
			if (nombreDeLaFuente.equals(fuente)) {
				estalafuente = true;
				break;
			}
		}
		
		if (estalafuente) {
			System.out.println("Fuente instalada !");
		}
		else {
			System.out.println("No está instalada la fuente !");
		}
		
	}

}
