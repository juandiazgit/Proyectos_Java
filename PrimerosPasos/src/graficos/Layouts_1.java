package graficos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layouts_1 {

	public static void main(String[] args) {

		Marco_Layout mimarco = new Marco_Layout();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class Marco_Layout extends JFrame {

	public Marco_Layout() {
		
		this.setTitle("Prueba Acciones");
		this.setBounds(300, 200, 600, 300);
		
		Panel_Layout Lamina = new Panel_Layout();
		add(Lamina,BorderLayout.NORTH);
		
		Panel_Layout2 Lamina2 = new Panel_Layout2();
		add(Lamina2,BorderLayout.SOUTH);
		
	}
}

class Panel_Layout extends JPanel {

	public Panel_Layout() {

		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(new JButton("Amarillo"));
		this.add(new JButton("Azul"));
		
	}
}

class Panel_Layout2 extends JPanel{
	
	public Panel_Layout2() {
		
		this.setLayout(new BorderLayout());
		this.add(new JButton("Rojo"),BorderLayout.WEST);
		this.add(new JButton("Verde"),BorderLayout.EAST);
		this.add(new JButton("Negro"),BorderLayout.CENTER);
		
	}
	
}


