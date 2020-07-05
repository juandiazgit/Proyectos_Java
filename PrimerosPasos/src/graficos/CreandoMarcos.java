package graficos;

import java.awt.Frame;

import javax.swing.*;

public class CreandoMarcos {

	public static void main(String[] args) {
		
		miMarco marco1 = new miMarco();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class miMarco extends JFrame {
	
	public miMarco() {
		//Dar un tamaño a la ventana.
//		setSize(500, 300);
		
		//Cambiar la ubicación en la pantalla.
//		setLocation(400, 200);
		
		//Realiza las dos acciones anteriores.
		setBounds(400, 200, 450, 250);
		
		//Indica redimensionar la ventana.
//		setResizable(false);
		
		//Muestra la ventana maximizada.
//		setExtendedState(Frame.MAXIMIZED_BOTH);
		
		setTitle("Mi ventana");
	}
	
	
}