package graficos;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LibreDisposicion {

	public static void main(String[] args) {

		MarcoLibre mimarco = new MarcoLibre();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoLibre extends JFrame {

	public MarcoLibre() {
		
		this.setBounds(400, 200, 600, 300);
		this.setVisible(true);
		
		LaminaLibre Lamina = new LaminaLibre();
		add(Lamina);
		
	}
}

class LaminaLibre extends JPanel{
	
	public LaminaLibre() {
		
		this.setLayout(new EnColumnas());
		
		JLabel nombre = new JLabel("Nombre: ");
		JLabel apellido = new JLabel("Apellido: ");
		JLabel edad = new JLabel("Edad: ");
		JLabel tlfno = new JLabel("Teléfono: ");
		
		JTextField c_nombre = new JTextField();
		JTextField c_apellido = new JTextField();
		JTextField c_edad = new JTextField();
		JTextField c_tlfno = new JTextField();
		
//		nombre.setBounds(20,20, 80, 10);
//		c_nombre.setBounds(100,16, 100, 20);
//		
//		apellido.setBounds(20,60, 80, 15);		
//		c_apellido.setBounds(100,55, 100, 20);
		
		this.add(nombre);
		this.add(c_nombre);
		this.add(apellido);
		this.add(c_apellido);
		this.add(edad);
		this.add(c_edad);
		this.add(tlfno);
		this.add(c_tlfno);
		
	}
	
}

class EnColumnas implements LayoutManager{

	private int x;
	private int y;
	
	@Override
	public void addLayoutComponent(String name, Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeLayoutComponent(Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void layoutContainer(Container micontenedor) {
		
		y = 20;
		int contador = 0;
		int d = micontenedor.getWidth();
		x = d/2;
		
		int n = micontenedor.getComponentCount();
		
		for (int i = 0; i < n; i++) {
			
			contador++;
			Component c = micontenedor.getComponent(i);
			c.setBounds(x-100, y, 100, 20);
			x+=100;
			
			if ((contador%2)==0) {
				x = d/2;
				y += 40;
			}
		}
		
	}
	
}
