package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PruebaEventos {

	public static void main(String[] args) {
		
		MarcoBotones mimarco = new MarcoBotones();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoBotones extends JFrame{
	
	public MarcoBotones() {
		
		setTitle("Botones y Eventos.");
		setBounds(550, 200, 400, 300);
		
		LaminasBotones miLamina = new LaminasBotones();
		
		//Adiciona la lámina al contenedor. 
		add(miLamina);
	}
}

class LaminasBotones extends JPanel{
	
	JButton BotonAzul = new JButton("Azul");
	JButton BotonAmarillo = new JButton("Amarillo");
	JButton BotonRojo = new JButton("Rojo");
	
	
	public LaminasBotones() {
		this.add(BotonAzul);
		this.add(BotonAmarillo);
		this.add(BotonRojo);
		
		ActionListener azul = new ColorFondo(Color.BLUE);
		ActionListener amarillo = new ColorFondo(Color.YELLOW);
		ActionListener rojo = new ColorFondo(Color.RED);
		
		BotonAzul.addActionListener(azul);
		BotonAmarillo.addActionListener(amarillo);
		BotonRojo.addActionListener(rojo);
	}
	
	private class ColorFondo implements ActionListener{
		
		private Color colorDeFondo;

		public ColorFondo(Color c) {
			this.colorDeFondo = c;
		}
		
		public void actionPerformed(ActionEvent e) {
			setBackground(colorDeFondo);
		}
	}
}





