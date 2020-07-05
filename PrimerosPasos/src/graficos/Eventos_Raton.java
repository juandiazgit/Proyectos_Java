package graficos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Eventos_Raton {

	public static void main(String[] args) {
		
		MarcoRaton mimarco = new MarcoRaton();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoRaton extends JFrame{
	
	public MarcoRaton() {
		
		setVisible(true);
		setBounds(450, 200, 400, 300);
//		this.addMouseListener(new EventosDeRaton());
		this.addMouseMotionListener(new EventosDeRaton());
	}
}

class EventosDeRaton implements MouseMotionListener{

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("Estás arrastrando.");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("Estás moviendo.");
	}
}







