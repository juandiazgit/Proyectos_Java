package graficos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EjemploArea {

	public static void main(String[] args) {

		MarcoArea mimarco = new MarcoArea();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoArea extends JFrame {

	public MarcoArea() {
		
		this.setBounds(300, 200, 600, 300);

		LaminaArea Lamina = new LaminaArea();
		this.add(Lamina);
		this.setVisible(true);

	}
}

class LaminaArea extends JPanel {
	
	JTextArea miarea;

	public LaminaArea() {
		
		miarea = new JTextArea(8,20);
//		miarea.setLineWrap(true);
		JScrollPane laminaBarras = new JScrollPane(miarea);
		this.add(laminaBarras);
		
		JButton miboton = new JButton("Dale");
		miboton.addActionListener(new GestionaArea());
		this.add(miboton);
	}
	
	private class GestionaArea implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println(miarea.getText());
			
		}

	}

}
