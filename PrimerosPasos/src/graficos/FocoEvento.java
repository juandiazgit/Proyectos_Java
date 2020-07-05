package graficos;

import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FocoEvento {

	public static void main(String[] args) {
		
		MarcoFoco mimarco = new MarcoFoco();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoFoco extends JFrame{
	
	public MarcoFoco() {
		
		setVisible(true);
		setBounds(450, 200, 400, 300);
		
		this.add(new LaminaFoco());
	}
}

class LaminaFoco extends JPanel{

	JTextField cuadro1;
	JTextField cuadro2;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setLayout(null);
		
		cuadro1 = new JTextField();
		cuadro2 = new JTextField();
		
		cuadro1.setBounds(80, 10, 150, 20);
		cuadro2.setBounds(80, 50, 150, 20);
		
		this.add(cuadro1);
		this.add(cuadro2);
		
		LanzaFocos elFoco = new LanzaFocos();
		cuadro1.addFocusListener(elFoco);
	}
	
	private class LanzaFocos implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			
			String email = cuadro1.getText();
			boolean comprobacion = false;
			
			for (int i = 0; i < email.length(); i++) {
				if (email.charAt(i) == '@') {
					comprobacion = true;
				}
			}
			
			if (comprobacion) {
				System.out.println("Correcto.");
			} else {
				System.out.println("Incorrecto.");
			}
		}
	}
	
}








