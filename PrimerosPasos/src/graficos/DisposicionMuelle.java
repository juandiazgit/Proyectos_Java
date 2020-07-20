package graficos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Spring;
import javax.swing.SpringLayout;

public class DisposicionMuelle {

	public static void main(String[] args) {

		MarcoMuelle mimarco = new MarcoMuelle();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoMuelle extends JFrame {

	public MarcoMuelle() {
		
		this.setBounds(300, 200, 700, 300);
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
		
		JButton boton1 = new JButton("Boton 1");
		JButton boton2 = new JButton("Boton 2");
		JButton boton3 = new JButton("Boton 3");
		
		SpringLayout miLayout = new SpringLayout();
		this.setLayout(miLayout);
		
		this.add(boton1);
		this.add(boton2);
		this.add(boton3);
		
		Spring mimuelle = Spring.constant(0, 10, 100);
		Spring muelle_rigido = Spring.constant(80);
		
		miLayout.putConstraint(SpringLayout.WEST, boton1, mimuelle, SpringLayout.WEST, this);
		miLayout.putConstraint(SpringLayout.WEST, boton2, muelle_rigido, SpringLayout.EAST, boton1);
		miLayout.putConstraint(SpringLayout.WEST, boton3, muelle_rigido, SpringLayout.EAST, boton2);
		miLayout.putConstraint(SpringLayout.EAST, this, mimuelle, SpringLayout.EAST, boton3);
		
	}
	
}
