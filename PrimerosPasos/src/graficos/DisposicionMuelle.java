package graficos;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DisposicionMuelle {

	public static void main(String[] args) {

		MarcoMuelle mimarco = new MarcoMuelle();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoMuelle extends JFrame {

	public MarcoMuelle() {
		
		this.setBounds(300, 200, 600, 300);
		this.setVisible(true);
		
		LaminaMuelle Lamina = new LaminaMuelle();
		add(Lamina);
		
	}
}

class LaminaMuelle extends JPanel{
	
	private JLabel rotulo;
	private JSlider control;
	private static int contador;
	
	public LaminaMuelle() {
		
		
		
	}
	
}


