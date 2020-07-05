package graficos;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PruebaDisposiciones {

	public static void main(String[] args) {

		MarcoCaja mimarco = new MarcoCaja();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoCaja extends JFrame {

	public MarcoCaja() {
		
		this.setTitle("Marco en la caja");
		this.setBounds(500, 200, 200, 200);
		
		JLabel rotulo1 = new JLabel("Nombre");
		JTextField texto1 = new JTextField(10);
		texto1.setMaximumSize(texto1.getPreferredSize());
		
		Box cajaH1 = Box.createHorizontalBox();
		cajaH1.add(rotulo1);
		cajaH1.add(Box.createHorizontalStrut(10));
		cajaH1.add(texto1);
		
		JLabel rotulo2 = new JLabel("Contraseña");
		JTextField texto2 = new JTextField(10);
		texto2.setMaximumSize(texto2.getPreferredSize());
		
		Box cajaH2 = Box.createHorizontalBox();
		cajaH2.add(rotulo2);
		cajaH2.add(Box.createHorizontalStrut(10));
		cajaH2.add(texto2);
		
		JButton boton1 = new JButton("Ok");
		JButton boton2 = new JButton("Cancelar");
		
		Box cajaH3 = Box.createHorizontalBox();
		cajaH3.add(boton1);
		cajaH3.add(Box.createGlue());
		cajaH3.add(boton2);
		
		Box cajaVertical = Box.createVerticalBox();
		cajaVertical.add(cajaH1);
		cajaVertical.add(cajaH2);
		cajaVertical.add(cajaH3);
		
		this.add(cajaVertical,BorderLayout.CENTER);
		
	}
}



