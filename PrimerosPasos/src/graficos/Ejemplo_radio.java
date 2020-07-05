package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Ejemplo_radio {

	public static void main(String[] args) {

		Marco_radio mimarco = new Marco_radio();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class Marco_radio extends JFrame {

	public Marco_radio() {
		
		this.setTitle("Ejemplo RadioButton");
		this.setBounds(300, 200, 600, 300);
		this.setVisible(true);
		
		Lamina_radio Lamina = new Lamina_radio();
		add(Lamina);
		
	}
}

class Lamina_radio extends JPanel {
	
	private JLabel texto;
//	private JRadioButton boton1,boton2,boton3,boton4;
	private ButtonGroup migrupo;
	private JPanel lamina_botones;
	
	public Lamina_radio() {
		
		setLayout(new BorderLayout());
		texto = new JLabel("En un lugar de la mancha de cuyo nombre...");
		texto.setFont(new Font("Serif", Font.PLAIN, 12));
		this.add(texto, BorderLayout.CENTER);
		migrupo = new ButtonGroup();
		lamina_botones = new JPanel();
		this.colocarBotones("Pequeño", false, 10);
		this.colocarBotones("Mediano", true, 12);
		this.colocarBotones("Grade", false, 18);
		this.colocarBotones("Muy grande", false, 26);
		this.add(lamina_botones,BorderLayout.SOUTH);
		
	}
	
	private void colocarBotones(String nombre, boolean seleccionado, final int tamanio) {
		
		JRadioButton boton = new JRadioButton(nombre, seleccionado);
		migrupo.add(boton);
		lamina_botones.add(boton);
		
		ActionListener mievento = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				texto.setFont(new Font("Serif", Font.PLAIN, tamanio));
				
			}
			
		};
		
		boton.addActionListener(mievento);
		
	}
	
}


