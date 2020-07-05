package graficos;

import javax.swing.JFrame;

import java.awt.Frame;
import java.awt.event.*;

public class CambioEstado {

	public static void main(String[] args) {
		
		MarcoEstado mimarco = new MarcoEstado();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class MarcoEstado extends JFrame{
	
	public MarcoEstado() {
		
		setVisible(true);
		
		setBounds(450, 200, 500, 350);
		
		this.addWindowStateListener(new cambiaEstado());
	}
}

class cambiaEstado implements WindowStateListener{

	public void windowStateChanged(WindowEvent e) {
//		System.out.println("**La ventana ha cambiado de estado**");
//		System.out.println(e.getNewState());
		
		if (e.getNewState() == Frame.MAXIMIZED_BOTH) {
			System.out.println("La ventana está a pantalla completa.");
		} else if (e.getNewState() == Frame.NORMAL) {
			System.out.println("La ventana está normal.");
		} else if (e.getNewState() == Frame.ICONIFIED) {
			System.out.println("La ventana está minimizada.");
		}
	}
	
}