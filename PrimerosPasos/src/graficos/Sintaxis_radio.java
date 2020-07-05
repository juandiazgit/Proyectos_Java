package graficos;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Sintaxis_radio {

	public static void main(String[] args) {

		Marco_radio_sintaxis mimarco = new Marco_radio_sintaxis();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class Marco_radio_sintaxis extends JFrame {

	public Marco_radio_sintaxis() {
		
		this.setTitle("Prueba RadioButton");
		this.setBounds(300, 200, 600, 300);
		this.setVisible(true);
		
		Lamina_radio_sintaxis Lamina = new Lamina_radio_sintaxis();
		add(Lamina);
		
	}
}

class Lamina_radio_sintaxis extends JPanel {
	
	public Lamina_radio_sintaxis() {
		
		ButtonGroup migrupo1 = new ButtonGroup();
		ButtonGroup migrupo2 = new ButtonGroup();
		
		JRadioButton boton1 = new JRadioButton("Azul", false);
		JRadioButton boton2 = new JRadioButton("Rojo", true);
		JRadioButton boton3 = new JRadioButton("Verde", false);
		JRadioButton boton4 = new JRadioButton("Masculino", false);
		JRadioButton boton5 = new JRadioButton("Femenino", false);
		
		migrupo1.add(boton1);
		migrupo1.add(boton2);
		migrupo1.add(boton3);
		migrupo2.add(boton4);
		migrupo2.add(boton5);
		
		this.add(boton1);
		this.add(boton2);
		this.add(boton3);
		this.add(boton4);
		this.add(boton5);
	}
	
}


