package graficos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class EventosTeclado {

	public static void main(String[] args) {
		
		MarcoTeclado mimarco = new MarcoTeclado();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class MarcoTeclado extends JFrame{
	
	public MarcoTeclado() {
		
		setVisible(true);
		setBounds(450, 200, 400, 300);
		
		this.addKeyListener(new EventoDeTeclado());
	}
}

class EventoDeTeclado implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		char letra = e.getKeyChar();
		System.out.println(letra);
	}	
}





