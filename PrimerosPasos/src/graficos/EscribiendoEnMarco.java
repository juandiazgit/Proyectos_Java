package graficos;

import javax.swing.*;
import java.awt.*;

public class EscribiendoEnMarco {

	public static void main(String[] args) {
		
		MarcoConTexto mimarco = new MarcoConTexto();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoConTexto extends JFrame{
	
	public MarcoConTexto() {
		setVisible(true);
		setSize(600, 450);
		setLocation(400, 200);
		setTitle("Primer texto");
		
		Lamina miLamina = new Lamina();
		
		//Poner la lámina por encima del marco.
		add(miLamina);
	}
	
}

class Lamina extends JPanel{
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Estamos aprendiendo Swing", 100, 100);
	}
	
}