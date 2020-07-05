package graficos;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MarcoSliders {

	public static void main(String[] args) {

		Frame_Sliders mimarco = new Frame_Sliders();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class Frame_Sliders extends JFrame {

	public Frame_Sliders() {
		
		this.setTitle("Prueba Sliders");
		this.setBounds(300, 200, 600, 300);
		this.setVisible(true);
		
		Lamina_Sliders Lamina = new Lamina_Sliders();
		add(Lamina);
		
	}
}

class Lamina_Sliders extends JPanel{
	
	private JLabel rotulo;
	private JSlider control;
	private static int contador;
	
	public Lamina_Sliders() {
		
		this.setLayout(new BorderLayout());
		rotulo = new JLabel("En un lugar de la mancha de cuyo nombre ..");
		this.add(rotulo,BorderLayout.CENTER);
		
		control = new JSlider(8, 50, 12);
		control.setMajorTickSpacing(20);
		control.setMinorTickSpacing(5);
		control.setPaintTicks(true);
		control.setPaintLabels(true);
		control.setFont(new Font("Serif", Font.ITALIC, 10));
		control.addChangeListener(new EventoSlider());
		
		JPanel laminaSlider = new JPanel();
		laminaSlider.add(control);
		
		this.add(laminaSlider,BorderLayout.NORTH);
	}
	
	private class EventoSlider implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
//			contador++;
			rotulo.setFont(new Font("Serif", Font.PLAIN, control.getValue()));
		}
		
	}
	
}


